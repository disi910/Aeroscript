package no.uio.aeroscript.ast.stmt;

import java.util.HashMap;

import no.uio.aeroscript.type.Memory;

public class ReturnToDockStatement extends Statement{
    
    public void execute(HashMap<Memory, Object> heap){

        HashMap<String, Object> vars = (HashMap<String, Object>) heap.get(Memory.VARIABLES);

        System.out.println("Drone returning to dock!");
        System.out.println("Distance travelled: " + vars.get("distance travelled"));
        System.out.println("Battery level: " + vars.get("battery level"));
        System.out.println("Terminating... ");

        // TODO: Implement terminate program

    }
}
