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
        System.out.println("    AcMove");
        HashMap<String, Object> vars = getVariables(heap);

        Float currentBattery = (Float) vars.get("battery level");
        Float currentDistance = (Float) vars.get("distance travelled");
        Point currentPos = (Point) vars.get("current position");
        
        // Move the drone by *distance* meters on the X axis
        Point newPos = new Point(currentPos.getX() + distance, currentPos.getY());
        Float newBattery = currentBattery - (distance * 0.5f) + (time * 0.1f) + (speed * 1);

        vars.put("current position", newPos);
        vars.put("battery level", newBattery);
        vars.put("distance travelled", currentDistance + distance);

        System.out.println("Drone moving on the X axis by " + distance + " meters");
        System.out.println("To point: " + newPos.getX() + ", " + newPos.getY());
        System.out.println("Distance travelled: " + (currentDistance + distance));

        checkBatteryLevel(heap);
    }
}