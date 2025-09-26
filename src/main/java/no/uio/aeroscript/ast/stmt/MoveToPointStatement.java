package no.uio.aeroscript.ast.stmt;

import java.util.HashMap;

import no.uio.aeroscript.type.Memory;
import no.uio.aeroscript.type.Point;

public class MoveToPointStatement extends Statement{
    private Point target;

    public MoveToPointStatement(Point target, Float speed, Float time){
        super(speed, time);
        this.target = target;
    }

    @Override
    public void execute(HashMap<Memory, Object> heap){
        HashMap<String, Object> vars = getVariables(heap);

        Float currentBattery = (Float) vars.get("battery level");
        Float currentDistance = (Float) vars.get("distance travelled");
        Point currentPos = (Point) vars.get("current position");
        
        // Cartesian distance
        Float distanceMoved = (float) Math.sqrt(Math.pow(target.getX() - currentPos.getX(), 2.0f) + Math.pow(target.getY() - currentPos.getY(), 2.0f));
        Float newBattery = (distanceMoved * 0.7f) + (time * 0.1f) + (speed * 1);

        vars.put("current position", target);
        vars.put("battery level", currentBattery - newBattery);
        vars.put("distance travelled", currentDistance + distanceMoved);

        System.out.println("Drone moving to point: " + target.getX()+", "+target.getY()+ " Battery: " + (Float)vars.get("battery level"));

        if ((Float) vars.get("battery level") <= 0){
            throw new RuntimeException("Battery depleted");
        }
    }
}