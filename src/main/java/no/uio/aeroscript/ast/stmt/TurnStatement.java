package no.uio.aeroscript.ast.stmt;

import java.util.HashMap;

import no.uio.aeroscript.type.Direction;
import no.uio.aeroscript.type.Memory;

public class TurnStatement extends Statement{
    Direction direction;
    Float degrees;

    public TurnStatement(Float degrees, Direction direction, Float speed, Float time){
        super(speed, time);
        this.degrees = degrees;
        this.direction = direction;
    }

    @Override
    public void execute(HashMap<Memory, Object> heap){

        if (direction != null) {
            System.out.println("Drone turning " + degrees + " degrees to the " + direction.getDescription());
        } else {
            System.out.println("Drone turning " + degrees + " degrees");
        }

        HashMap<String, Object> vars = getVariables(heap);

        Float currentBattery = (Float)vars.get("battery level");
        Float newBattery = currentBattery - (degrees * 0.3f + (time * 0.3f) + (speed * 1));

        vars.put("battery level", newBattery);

        if ((Float) vars.get("battery level") <= 0){
            throw new RuntimeException("Battery depleted");
        }
    }

}
