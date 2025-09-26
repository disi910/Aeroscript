package no.uio.aeroscript.ast.stmt;

import java.util.HashMap;

import no.uio.aeroscript.type.Memory;

public class ReturnToDockStatement extends Statement{

    public ReturnToDockStatement(Float speed, Float time){
        super(speed, time);
    }
    
    @Override
    public void execute(HashMap<Memory, Object> heap){

        HashMap<String, Object> vars = getVariables(heap);

        Float distanceTravelled = (Float) vars.get("distance travelled");
        Float currentBattery = (Float) vars.get("battery level");
        Integer altitude = (Integer) vars.get("altitude");
        
        Float newBattery = currentBattery - (altitude + (time * 0.1f) + (speed * 1));
        vars.put("battery level", newBattery);

        System.out.println("Drone returning to dock!");
        System.out.println("Distance travelled: " + distanceTravelled);
        System.out.println("Battery level: " + newBattery);
        System.out.println("Terminating... ");

        if ((Float) vars.get("battery level") <= 0){
            throw new RuntimeException("Battery depleted");
        }

    }
}
