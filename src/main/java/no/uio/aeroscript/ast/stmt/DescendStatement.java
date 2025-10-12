package no.uio.aeroscript.ast.stmt;

import java.util.HashMap;

import no.uio.aeroscript.type.Memory;

public class DescendStatement extends Statement{
    Integer value;

    public DescendStatement(Integer value, Float speed, Float time){
        super(speed, time);
        this.value = value;
    }

    // Assumption: Distance does not increase when drone descend

    @Override
    public void execute(HashMap<Memory, Object> heap){
        System.out.println("    AcDescend");
        HashMap<String, Object> vars = getVariables(heap);
        
        Integer currentAltitide = (Integer) vars.get("altitude");
        Float currentBattery = (Float) vars.get("battery level");

        Integer actualDescent = Math.min(value, currentAltitide);
        Integer newAltitude = currentAltitide - actualDescent;
        Float newBattery = currentBattery - (actualDescent * 0.2f + (time * 0.1f) + (speed * 1.0f));

        // Battery and Altitude change
        vars.put("battery level", newBattery);
        vars.put("altitude", newAltitude);

        // Log
        if (newAltitude == 0){
            System.out.println("Drone descending by " + value + " meters, to ground");
        } else {
            System.out.println("Drone descending by " + value + " meters, to altitude: " + newAltitude);
        }

        // Check battery depletion
        checkBatteryLevel(heap);
    }
}
