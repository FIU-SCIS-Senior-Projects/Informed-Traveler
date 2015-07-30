package entities;

import java.awt.Point;
import java.io.Serializable;

import simulation.Simulation;

abstract public class LaneEnd implements Serializable{
	
//****************************
//	*constants & attributes*
//****************************
public static final int LINEEND_GREEN = 1;
public static final int LINEEND_YELLOW = 0;
public static final int LINEEND_RED = -1;

public final String name;
public Simulation S;
/**
 * Holds the directions this LineEnd leads to in ascending order.
 */
public final int[] leadingToDirections;
public final Lane[] successorLines;
public final int nOfSucceedingLines;

public final Point Coordinates;


//****************************
/**
 * This variable has one of the three values LINEEND_GREEN, LINEEND_YELLOW,  LINEEND_RED, specifying if an agent which wants to cross this junction is allowed to do so.
 * ******???i.e. it tells that a traffic light is actually red, or that an agent on another incoming line has the right of way.???**** you can also solve different? as when changing lanes...
 */
public int free;

	
	

//****************************
//		*constructor*
//****************************	
public LaneEnd(Simulation S, String name, int[] leadingToDirections, Point coords, Lane[] succeedingLines) {
	this.name=name;
	this.S=S;
	this.successorLines=succeedingLines;
	if(successorLines!=null) this.nOfSucceedingLines=succeedingLines.length;
	else this.nOfSucceedingLines=0;
	this.leadingToDirections=leadingToDirections;
	this.Coordinates=coords;
	this.free=LaneEnd.LINEEND_GREEN;
}

	
//****************************
//*methods*
//****************************

	

	public abstract Lane swapLines(int direction, double d, Lane l, Car c);
	public abstract Car getLastCar(int direction, boolean lookahead);
	
	public Car getNearestCar(){
		if(this.getClass()==Sink.class) return null;
		Car c=null; double dist = 10000;
		for(Lane l : successorLines){
			if(l.getLastCar()!= null && l.length-l.getLastCar().pos.back<dist) c = l.getLastCar();
		}
		return c;
	}

	public int isPassable(int direction){
		return (free);
		//Es muss noch gepr�ft werden ob die Line auf die das Auto (das in Richtung direction fahren will) keine Stra�en kreuzt, die belegt sind.
	}
	
	public void checkDirection(Car c, Lane setOn){
		c.tryToSwapLane = !setOn.leadingToDirection(c.getDirection());
		
	}
	
	public int trafficLightState(){
		return free;
	}

	
	public abstract Lane[] getSuccessorLines();


	public abstract boolean dissectsDirection(int direction);

	
}
