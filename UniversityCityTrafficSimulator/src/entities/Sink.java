package entities;

import java.awt.Point;
import simulation.Simulation;


public class Sink extends LaneEnd {
	
	public final int id;
	
	public Sink(Simulation S, String name, int id, int leadingToDirection, Point coords) {
		super(S,name,new int[] {leadingToDirection}, coords, null);
		this.id=id;
		this.free=LaneEnd.LINEEND_GREEN;
	}

	/**
	 * Looks after the final Statistics to be updated, sets the car's predecessor's successor to null,
	 * and brings the cars much too short life to an unhappy end.
	 */
	@Override
	public synchronized Lane swapLines(int direction, double d, Lane l, Car c) {
	//	System.out.print("Senke "+name+": ");
		if(c.getSuccessor()!=null) c.getSuccessor().setPredecessor(null);
		S.finalStats(c, this.id);
		l.removeCar(c);
		
		return null;			
	}

	@Override
	public Car getLastCar(int direction, boolean lookahead) {
		return null;
	}	
	@Override
	public Lane[] getSuccessorLines() {
		return null;
	}
	@Override
	public boolean dissectsDirection(int direction) {
		return false;
	}

}
