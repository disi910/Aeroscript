package no.uio.aeroscript.ast.stmt;

import java.util.HashMap;

import no.uio.aeroscript.type.Memory;

public class AscendStatement extends Statement{
    Integer value;

    public AscendStatement(Integer value, Float speed, Float time){
        super(speed, time);
        this.value = value;
    }

    // Assumption: Distance does not increase when drone ascend

    @Override
    public void execute(HashMap<Memory, Object> heap){
        System.out.println("    AcAscend");
        HashMap<String, Object> vars = getVariables(heap);
        
        Integer currentAltitide = (Integer) vars.get("altitude");
        Float currentBattery = (Float) vars.get("battery level");

        Integer newAltitude = currentAltitide + value;
        Float newBattery = currentBattery - ((value * 0.6f) + (time * 0.1f) + (speed * 1.0f));

        // Battery and Altitude change
        vars.put("battery level", newBattery);
        vars.put("altitude", newAltitude);

        // Log
        System.out.println("Drone ascending by " + value + " meters, to altitude: " + newAltitude);

        // Check battery depletion
        checkBatteryLevel(heap);
    }
}
