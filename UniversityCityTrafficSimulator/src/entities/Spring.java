package entities;

import java.awt.Point;

import simulation.Simulation;

public class Spring extends LaneEnd {

    public final int id;

    public Spring(Simulation S, String name, int id, int[] leadingToDirections, Point coords, Lane successorLine) {
        super(S, name, leadingToDirections, coords, new Lane[]{successorLine});
        this.id = id;
    }

    public Lane[] getSuccessorLines() {
        return (successorLines);
    }

    @Override
    public Lane swapLines(int direction, double d, Lane l, Car c) {
        Lane setOn = this.successorLines[0];
        this.checkDirection(c, setOn);
        Car p = setOn.getLastCar(direction);
        c.setPredecessor(p);
        if (p != null) {
            p.setSuccessor(c);
        }
        setOn.addLastCar(c);
        c.pos.update(setOn, 0);
        return setOn;
    }

    @Override
    public Car getLastCar(int direction, boolean lookahead) {
        // TODO Auto-generated method stub
        return null;
    }

    public void checkDirection(Car c, Lane setOn) {
        c.tryToSwapLane = !setOn.leadingToDirection(c.getDirection());
    }

    @Override
    public boolean dissectsDirection(int direction) {
        // TODO Auto-generated method stub
        return false;
    }

}
