package no.uio.aeroscript.runtime;

import no.uio.aeroscript.antlr.AeroScriptLexer;
import no.uio.aeroscript.antlr.AeroScriptParser;
import no.uio.aeroscript.ast.stmt.Statement;
import no.uio.aeroscript.type.Memory;
import no.uio.aeroscript.type.Point;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.HashMap;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class InterpreterTest {
    private HashMap<Memory, Object> heap;
    private Stack<Statement> stack;
    private Interpreter interpreter;

    @BeforeEach
    void setUp() {
        initInterpreter();
        this.interpreter = new Interpreter(this.heap, this.stack);
    }

    private void initInterpreter() {
        this.heap = new HashMap<>();
        this.stack = new Stack<>();
        HashMap<Memory, HashMap<String, Object>> variables = new HashMap<>();
        variables.put(Memory.VARIABLES, new HashMap<>());
        HashMap<String, Object> vars = variables.get(Memory.VARIABLES);

        float batteryLevel = 100;
        int initialZ = 0;
        Point initialPosition = new Point(0, 0);

        vars.put("initial position", initialPosition);
        vars.put("current position", initialPosition);
        vars.put("altitude", initialZ);
        vars.put("initial battery level", batteryLevel);
        vars.put("battery level", batteryLevel);
        vars.put("battery low", false);
        vars.put("distance travelled", 0.0f);
        vars.put("initial execution", null);

        heap.put(Memory.VARIABLES, vars);
    }

    private void executeProgram(String program) {
        AeroScriptParser.ProgramContext programContext = parseProgram(program);
        interpreter.visitProgram(programContext);
    }

    private AeroScriptParser.ProgramContext parseProgram(String program) {
        AeroScriptLexer lexer = new AeroScriptLexer(CharStreams.fromString(program));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        AeroScriptParser parser = new AeroScriptParser(tokens);
        return parser.program();
    }

    private AeroScriptParser.ExpressionContext parseExpression(String expression) {
        AeroScriptLexer lexer = new AeroScriptLexer(CharStreams.fromString(expression));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        AeroScriptParser parser = new AeroScriptParser(tokens);
        return parser.expression();
    }

    // Helper method to evaluate an expression and return float result
    private float evaluateExpression(String expression) {
        return Float.parseFloat(interpreter.visitExpression(parseExpression(expression)).evaluate().toString());
    }

    @Test
    void testActionsWorks() throws Exception {
        String testProgram = " -> TestMode {\n" +
                           "    move to point (10, 20) at speed 10\n" +
                           "    move by 5\n" +
                           "    turn right by 5\n" +
                           "    turn by 5\n" +
                           "    ascend by 10 \n" +
                           "    descend by 5\n" +
                           "    descend by 10\n" +
                           "    return to base\n" +
                           "}\n" +
                           " -> NewMode {\n" +
                           "    ascend by 10 \n" +
                           "    ascend by 10 \n" +
                           "}";
        
        executeProgram(testProgram);
        
        Point pos = interpreter.getPosition();
        Float battery = interpreter.getBattery();
        Float distance = interpreter.getDistanceTravelled();
        
        // Check battery was depleted
        assertTrue(battery < 100.0f);
        
        System.out.println("Position: (" + pos.getX() + ", " + pos.getY() + ")");
        System.out.println("Battery: " + battery);
        System.out.println("Distance: " + distance);
    }

    @Test
    void getFirstExecution() {
        // Test that initial execution is null by default
        HashMap<String, Object> vars = (HashMap<String, Object>) heap.get(Memory.VARIABLES);
        assertNull(vars.get("initial execution"));

        // Test with a simple program that has an execution
        String testProgram = " NotStartMode {\n" +
                           "    move by 5\n" +
                           "}\n" +
                           "-> ActualStartMode {\n" +
                           "    move by 5\n" +
                           "}";
        
        executeProgram(testProgram);
        assertEquals("ActualStartMode", vars.get("initial execution"));

    }

    @Test
    void getPosition() {
        // Test initial position is (0, 0)
        Point initialPos = interpreter.getPosition();
        assertEquals(0.0f, initialPos.getX(), 0.01f);
        assertEquals(0.0f, initialPos.getY(), 0.01f);

        // Test position after movement
        String testProgram = "-> MoveTest {\n" +
                           "    move to point (5, 10)\n" +
                           "}";
        
        executeProgram(testProgram);
        
        Point finalPos = interpreter.getPosition();
        assertEquals(5.0f, finalPos.getX(), 0.01f);
        assertEquals(10.0f, finalPos.getY(), 0.01f);
    }

    @Test
    void getDistanceTravelled() {
        // Test initial distance is 0
        assertEquals(0.0f, interpreter.getDistanceTravelled(), 0.01f);

        // Test distance after movement
        String testProgram = "-> DistanceTest {\n" +
                           "    move by 10\n" +
                           "    move by 5\n" +
                           "}";
        
        executeProgram(testProgram);
        
        // Should have travelled 15 units total (10 + 5)
        assertEquals(15.0f, interpreter.getDistanceTravelled(), 0.01f);
    }

    @Test
    void getBatteryLevel() {
        // Test initial battery level is 100
        assertEquals(100.0f, interpreter.getBattery(), 0.01f);

        // Test battery level after some actions
        String testProgram = "-> BatteryTest {\n" +
                           "    move by 5\n" +
                           "    turn by 10\n" +
                           "}";
        
        executeProgram(testProgram);
        
        // Battery should be less than 100 after actions
        Float finalBattery = interpreter.getBattery();
        assertTrue(finalBattery < 100.0f);
        assertTrue(finalBattery > 0.0f);
        
        System.out.println("Battery after actions: " + finalBattery);
    }

    @Test
    void visitProgram() {
        // Create a program with multiple executions
        String testProgram = "-> Execution {\n" +
                           "    move by 1\n" +
                           "}\n" +
                           "ExecutionTwo{\n" +
                           "    move by 2\n" +
                           "}\n" +
                           "ExecutionThree {\n" +
                           "    turn by 5\n" +
                           "}\n" +
                           "ExecutionFour {\n" +
                           "    ascend by 5\n" +
                           "}\n" +
                           "ExecutionFive {\n" +
                           "    descend by 3\n" +
                           "}";
        
        // Visit the program and get the executions
        Object result = interpreter.visitProgram(parseProgram(testProgram));
        
        // Verify we have executions (the first one with arrow should execute)
        assertNotNull(result);
        
        // Check that some actions were performed (battery should be depleted)
        assertTrue(interpreter.getBattery() < 100.0f);
        
        // Check that distance was tracked from the movements
        assertTrue(interpreter.getDistanceTravelled() > 0.0f);
        
        System.out.println("Final battery: " + interpreter.getBattery());
        System.out.println("Final distance: " + interpreter.getDistanceTravelled());
        System.out.println("Final position: (" + interpreter.getPosition().getX() + 
                         ", " + interpreter.getPosition().getY() + ")");
    }

    @Test
    void visitExpression() {
        initInterpreter();
        Interpreter interpreter = new Interpreter(this.heap, this.stack);

        assertEquals(5.0f, Float.parseFloat(interpreter.visitExpression(parseExpression("2 + 3")).evaluate().toString()));
        assertEquals(-1.0f, Float.parseFloat(interpreter.visitExpression(parseExpression("2 - 3")).evaluate().toString()));
        assertEquals(6.0f, Float.parseFloat(interpreter.visitExpression(parseExpression("2 * 3")).evaluate().toString()));
        assertEquals(-1, Float.parseFloat(interpreter.visitExpression(parseExpression("-- 1")).evaluate().toString()));
    }
}
