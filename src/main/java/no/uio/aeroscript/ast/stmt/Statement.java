package no.uio.aeroscript.ast.stmt;

import java.util.HashMap;

import no.uio.aeroscript.type.Memory;

public abstract class Statement {
    protected Float speed;
    protected Float time;

    public Statement(Float speed, Float time){
        this.speed = (speed != null) ? speed : 0.0f;
        this.time = (time != null) ? time : 0.0f;
    }

    public abstract void execute(HashMap<Memory, Object> heap);

    protected HashMap<String, Object> getVariables(HashMap<Memory, Object> heap){ 
        return (HashMap<String, Object>) heap.get(Memory.VARIABLES); 
    }

    protected void checkBatteryLevel(HashMap<Memory, Object> heap){
        HashMap<String, Object> vars = getVariables(heap);
        Float batteryLevel = (Float)vars.get("battery level");
        
        if ( batteryLevel <= 0){
            throw new RuntimeException("Battery depleted");
        } else {
            System.out.println("Battery level: " + batteryLevel);
        }
    }
}
