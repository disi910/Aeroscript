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
        
        // Programmet er en liste med excecutions, Jeg må håndtere hver type expression,
        // Samt håndtere pilene og sånt tror jeg
        ArrayList<Execution> execList = new ArrayList<>();

        for (AeroScriptParser.ExecutionContext ex : ctx.execution()){
            String modeName = ex.ID(0).getText();
            ArrayList<Statement> statements = new ArrayList<>();
            
            for (AeroScriptParser.StatementContext statement : ex.statement()){
                Statement s = (Statement) visitStatement(statement);
                statements.add(s);
            }
            methodTable.put(modeName, statements);
            
            if (ex.ARROW(0) != null){
                Execution exec = new Execution(modeName, statements);
                execList.add(exec);
            }

        }

        return new ArrayList<Execution>();
    }


    public Object visitStatement(AeroScriptParser.StatementContext ctx){
        // A statement is an action
        return visitAction(ctx.action());
    }

    @Override
    public Object visitAction(AeroScriptParser.ActionContext ctx){

        
        currentSpeed = null;
        currentTime = null;

        // First check if optional speed and for x seconds is present
        if (ctx.AT_SPEED() != null){
            currentSpeed = Float.parseFloat(ctx.expression(1).getText());
            System.out.println("Speed set: " + currentSpeed);
        } else if (ctx.FOR() != null && ctx.SECONDS() != null){
            currentTime = Float.parseFloat(ctx.expression(0).getText());
            System.out.println("Time set: " + currentTime);
        }

        // Check through all actions
        if (ctx.acMove() != null){
            return visitAcMove(ctx.acMove());
        } else {
            return visitAcMove(ctx.acMove());
        }
    }

    @Override
    public Object visitAcMove(AeroScriptParser.AcMoveContext ctx){
        if (ctx.POINT() != null){
            // Then it's a "move to point"
            Point target = (Point) visitPoint(ctx.point());
            return new MoveToPointStatement(target, currentSpeed, currentTime);

        } else {
            // Then it's a "move by n distance"
            Float distance = Float.parseFloat(ctx.NUMBER().getText());
            return new MoveByDistanceStatement(distance, currentSpeed, currentTime);

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
}
