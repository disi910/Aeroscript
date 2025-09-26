package no.uio.aeroscript.ast.stmt;

import java.util.HashMap;

import no.uio.aeroscript.type.Memory;
import no.uio.aeroscript.type.Point;

public class MoveByDistanceStatement extends Statement{
    private Float distance;

    public MoveByDistanceStatement(Float distance, Float speed, Float time){
        super(speed, time);
        this.distance = distance;
    }

    @Override
    public void execute(HashMap<Memory, Object> heap){
        HashMap<String, Object> vars = getVariables(heap);

        Float currentBattery = (Float) vars.get("battery level");
        Float currentDistance = (Float) vars.get("distance travelled");
        Point currentPos = (Point) vars.get("current position");
        
        // Move the drone by *distance* meters on the X axis
        Point newPos = new Point(currentPos.getX() + distance, currentPos.getY());
        Float newBattery = (distance * 0.5f) + (time * 0.1f) + (speed * 1);

        vars.put("current position", newPos);
        vars.put("battery level", currentBattery - newBattery);
        vars.put("distance travelled", currentDistance + distance);

        System.out.println("Drone moving on the X axis by " + distance + " Meters. Battery: " + (Float)vars.get("battery level"));

        if ((Float) vars.get("battery level") <= 0){
            throw new RuntimeException("Battery depleted");
        }
    }
}