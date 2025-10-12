package no.uio.aeroscript.runtime;

import no.uio.aeroscript.antlr.AeroScriptBaseVisitor;
import no.uio.aeroscript.antlr.AeroScriptParser;
import no.uio.aeroscript.ast.expr.*;
import no.uio.aeroscript.ast.stmt.*;
import no.uio.aeroscript.type.*;

import java.util.*;

/* For now, let us just ignore interrupts, will need to build
 * an interrupt lookup table and introduce a message queue later... */
public class Interpreter extends AeroScriptBaseVisitor<Object> {
    private HashMap<Memory, Object> heap;
    private Stack<Statement> stack;
    private HashMap<String, ArrayList<Statement>> methodTable = new HashMap<>();

    // Remember to set to null in all action-visit methods
    private Float currentSpeed = null;
    private Float currentTime = null;


    public Interpreter(HashMap<Memory, Object> heap, Stack<Statement> stack) {
        this.heap = heap;
        this.stack = stack;
    }

    private void resetSpeedTime(){
        currentSpeed = null;
        currentTime = null;
    }

    @Override
    public Object visitPoint(AeroScriptParser.PointContext ctx) {
        Expression xNode = (Expression) visit(ctx.expression(0));
        Expression yNode = (Expression) visit(ctx.expression(1));
        float x = Float.parseFloat(xNode.evaluate().toString());
        float y = Float.parseFloat(yNode.evaluate().toString());
        return new Point(x, y);
    }

    @Override
    public Object visitRange(AeroScriptParser.RangeContext ctx) {
        Expression startNode = (Expression) visit(ctx.expression(0));
        Expression endNode = (Expression) visit(ctx.expression(1));
        float start = Float.parseFloat(startNode.evaluate().toString());
        float end = Float.parseFloat(endNode.evaluate().toString());
        return new Range(start, end);
    }

    /* Program = list of executions */
    // the program context contains all the exections as shown in the antlr grammar. 
    @Override
    public ArrayList<Execution> visitProgram(AeroScriptParser.ProgramContext ctx) {
        ArrayList<Execution> execList = new ArrayList<>();
        String startModeName = null;
        HashMap<String, String> transitions = new HashMap<>(); // modeName -> nextModeName
        
        // Build method table
        for (AeroScriptParser.ExecutionContext ex : ctx.execution()) {
            String modeName = ex.ID(0).getText();
            ArrayList<Statement> statements = new ArrayList<>();
            
            // Parse all statements in this mode
            for (AeroScriptParser.StatementContext stmtCtx : ex.statement()) {
                statements.add((Statement) visitStatement(stmtCtx));
            }
            
            // Store in method table
            methodTable.put(modeName, statements);
            execList.add(new Execution(modeName, statements));
            
            // Check if this mode has a leading arrow 
            if (ex.ARROW() != null && ex.ARROW().size() > 0) {
                // If there's an ARROW token before any ID token, it's the start mode
                int firstArrowIndex = ex.ARROW(0).getSymbol().getTokenIndex();
                int firstIdIndex = ex.ID(0).getSymbol().getTokenIndex();
                
                if (firstArrowIndex < firstIdIndex) {
                    startModeName = modeName;
                }
            }
            
            if (ex.ID().size() > 1) {
                String nextMode = ex.ID(1).getText();
                transitions.put(modeName, nextMode);
            }
        }
        
        if (startModeName != null) {
            HashMap<String, Object> vars = (HashMap<String, Object>) heap.get(Memory.VARIABLES);
            vars.put("initial execution", startModeName);
            
            // STEP 3: Execute the program starting from the start mode
            executeChain(startModeName, transitions);
        }
        
        return execList;
    }

    // Helper method to execute a chain of modes following transitions
    private void executeChain(String modeName, HashMap<String, String> transitions) {
        // Execute current mode's statements
        execute(modeName);
        
        // If this mode transitions to another, execute it next
        if (transitions.containsKey(modeName)) {
            String nextMode = transitions.get(modeName);
            executeChain(nextMode, transitions);
        }
    }

    public void execute(String execName){
        ArrayList<Statement> statements = methodTable.get(execName);
        // Execute all statements in the list of statements in the execution
        if (statements != null){
            for (Statement s : statements){
                s.execute(heap);
            }
        }
    }
    
    @Override
    public Object visitStatement(AeroScriptParser.StatementContext ctx){
        // A statement is an action
        return visitAction(ctx.action());
    }

    @Override
    public Object visitAction(AeroScriptParser.ActionContext ctx){
        resetSpeedTime();

        // First check if optional speed and for x seconds is present
        if (ctx.AT_SPEED() != null){
            currentSpeed = Float.parseFloat(ctx.expression().getText());
            System.out.println("Speed set: " + currentSpeed);
        } else if (ctx.FOR() != null && ctx.SECONDS() != null){
            currentTime = Float.parseFloat(ctx.expression().getText());
            System.out.println("Time set: " + currentTime);
        }

        // Check through all actions
        if (ctx.acDock() != null){
            return visitAcDock(ctx.acDock());
        } else if (ctx.acMove() != null) {
            return visitAcMove(ctx.acMove());
        } else if (ctx.acTurn() != null) {
            return visitAcTurn(ctx.acTurn());
        } else if (ctx.acAscend() != null) {
            return visitAcAscend(ctx.acAscend());
        } else if (ctx.acDescend() != null) {
            return visitAcDescend(ctx.acDescend());
        } else {
            throw new RuntimeException("Action not detected");
        }
    }

    @Override
    public Object visitAcDock(AeroScriptParser.AcDockContext ctx){
        if (ctx.RETURN_TO_BASE() != null){
            return new ReturnToDockStatement(currentSpeed, currentTime);
        } else {
            throw new RuntimeException("Error on visitAcDock()");
        }
    }

    @Override
    public Object visitAcMove(AeroScriptParser.AcMoveContext ctx){
        if (ctx.POINT() != null){
            // Then it's a "move to point"
            Point target = (Point) visitPoint(ctx.point());
            return new MoveToPointStatement(target, currentSpeed, currentTime);

        } else if (ctx.MOVE() != null && ctx.BY() != null){
            // Then it's a "move by n distance"
            Float distance = Float.parseFloat(ctx.NUMBER().getText());
            return new MoveByDistanceStatement(distance, currentSpeed, currentTime);

        } else {
            throw new RuntimeException("Error on visitAcMove()");
        }
    }

    @Override
    public Object visitAcTurn(AeroScriptParser.AcTurnContext ctx){
        Float degrees = null;
        if (ctx.TURN() != null && ctx.BY() != null){
            degrees = Float.parseFloat(ctx.expression().getText());
            if (ctx.RIGHT() != null){
                return new TurnStatement(degrees, Direction.RIGHT, currentSpeed, currentTime);
            } else if (ctx.LEFT() != null){
                return new TurnStatement(degrees, Direction.LEFT, currentSpeed, currentTime);
            } else {
                return new TurnStatement(degrees, null, currentSpeed, currentTime);
            }
        } else {
            throw new RuntimeException("Error on visitAcTurn()");
        }
    }

    @Override
    public Object visitAcAscend(AeroScriptParser.AcAscendContext ctx){
        if (ctx.ASCEND_BY() != null){
            Integer value = Integer.parseInt(ctx.expression().getText());
            return new AscendStatement(value, currentSpeed, currentTime);
        } else {
            throw new RuntimeException("Error on visitAcAscend");
        }
    }

    @Override
    public Object visitAcDescend(AeroScriptParser.AcDescendContext ctx){
        HashMap<String, Object> vars = (HashMap<String, Object>) heap.get(Memory.VARIABLES);
        Integer altitude = (Integer) vars.get("altitude");

        if (ctx.DESCEND_TO_GROUND() != null){
            return new DescendStatement(altitude, currentSpeed, currentTime);

        } else if(ctx.DESCEND_BY() != null && ctx.expression() != null){
            Integer value = Integer.parseInt(ctx.expression().getText());
            return new DescendStatement(value, currentSpeed, currentTime);
            
        } else {
            throw new RuntimeException("Error on visitAcAscend");
        }
    }

    /* Expressions */
    public Expression visitExpression(AeroScriptParser.ExpressionContext ctx) {
        return switch (ctx) {
            case AeroScriptParser.PlusExpContext pex -> visitPlusExp(pex);
            case AeroScriptParser.MinusExpContext pex -> visitMinusExp(pex);
            case AeroScriptParser.TimesExpContext pex -> visitTimesExp(pex);
            case AeroScriptParser.NumExpContext pex -> visitNumExp(pex);
            case AeroScriptParser.NegExpContext pex -> visitNegExp(pex);
            case AeroScriptParser.ParentExpContext pex -> visitParentExp(pex);
            case AeroScriptParser.RangeExpContext pex -> visitRangeExp(pex);
            case AeroScriptParser.PointExpContext pex -> visitPointExp(pex);
            default -> new NumberExpression((float) 0) ;
        };
    }
    
    @Override
    public Expression visitPlusExp(AeroScriptParser.PlusExpContext ctx){
        Expression left = visitExpression(ctx.left);
        Expression right = visitExpression(ctx.right);
        return new OperationExpression("SUM",left, right);
    }
    @Override
    public Expression visitMinusExp(AeroScriptParser.MinusExpContext ctx){
        Expression left = visitExpression(ctx.left);
        Expression right = visitExpression(ctx.right);
        return new OperationExpression("SUB",left, right);
    }
    @Override
    public Expression visitTimesExp(AeroScriptParser.TimesExpContext ctx){
        Expression left = visitExpression(ctx.left);
        Expression right = visitExpression(ctx.right);
        return new OperationExpression("MUL",left, right);
    }
    @Override
    public Expression visitNumExp(AeroScriptParser.NumExpContext ctx){
        return new NumberExpression(Float.parseFloat(ctx.NUMBER().getText()));
    }
    @Override
    public Expression visitNegExp(AeroScriptParser.NegExpContext ctx){
        return new NegNumberExpression(visitExpression(ctx.expression())) ;
    }
    @Override
    public Expression visitParentExp(AeroScriptParser.ParentExpContext ctx){
        return visitExpression(ctx.expression());
    }
    @Override
    public Expression visitPointExp(AeroScriptParser.PointExpContext ctx){
        Expression left = visitExpression(ctx.point().left);
        Expression right = visitExpression(ctx.point().right);
        return new PointExpression(left, right);
    }
    @Override
    public Expression visitRangeExp(AeroScriptParser.RangeExpContext ctx){
        Expression left = visitExpression(ctx.range().left);
        Expression right = visitExpression(ctx.range().right);
        return new RangeExpression(left, right);
    }

    // Getter methods
    public Float getBattery(){
        HashMap<String, Object> vars = (HashMap<String, Object>) heap.get(Memory.VARIABLES);
        return (Float) vars.get("battery level");
    }
    public Point getPosition(){
        HashMap<String, Object> vars = (HashMap<String, Object>) heap.get(Memory.VARIABLES);
        return (Point) vars.get("current position");
    }
    public Float getDistanceTravelled(){
        HashMap<String, Object> vars = (HashMap<String, Object>) heap.get(Memory.VARIABLES);
        return (Float) vars.get("distance travelled");
    }

}
