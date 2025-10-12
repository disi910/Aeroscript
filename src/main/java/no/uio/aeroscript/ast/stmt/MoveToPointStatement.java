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
        System.out.println("    AcMove");
        HashMap<String, Object> vars = getVariables(heap);

        Float currentBattery = (Float) vars.get("battery level");
        Float currentDistance = (Float) vars.get("distance travelled");
        Point currentPos = (Point) vars.get("current position");
        
        Float moveDistance = (float) Math.sqrt(
            Math.pow(target.getX() - currentPos.getX(), 2.0f) + 
            Math.pow(target.getY() - currentPos.getY(), 2.0f));
        Float distanceTravelled = currentDistance + moveDistance;
        Float newBattery = currentBattery - (moveDistance * 0.7f + (time * 0.1f) + (speed * 1.0f));

        vars.put("current position", target);
        vars.put("battery level", newBattery);
        vars.put("distance travelled", distanceTravelled);

        System.out.println("Drone moving to point: " + target.getX()+", "+target.getY());
        System.out.println("Distance travelled: " + distanceTravelled);


        checkBatteryLevel(heap);
    }
}