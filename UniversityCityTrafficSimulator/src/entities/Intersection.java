package entities;

import java.awt.Point;

import simulation.Simulation;

public class Intersection extends Junction{


	
	public Intersection(Simulation S, String name, Point coords, Lane succeedingLine, int[] leadingToDirections) {
		super(S, name, coords, new Lane[]{succeedingLine}, leadingToDirections);
	}
	public Intersection(Simulation S, String name, Point coords, Lane succeedingLine, int[] leadingToDirections, int lineEndStatus) {
		super(S, name,coords, new Lane[]{succeedingLine}, leadingToDirections, lineEndStatus);

	}

	/*
	@Override
	public Line swapLines(int direction, double d, Line l, Car c) {
		Line setOn=this.succeedingLine;
		Car p = setOn.getLastCar(c.getDirection());
		
		if(c.getSuccessor()!=null && c.getSuccessor().pos.line!=l){
			c.getSuccessor().setPredecessor(null);
			c.setSuccessor(null);
		}
		c.setPredecessor(p);
		if(p!=null){
			if(p.getSuccessor()!=null && p.getSuccessor().id!=c.id){
				c.setSuccessor(p.getSuccessor());
				if(p.getSuccessor().id!=p.id) p.getSuccessor().setPredecessor(c);
				else System.out.println("nachfolgereferenz auf sich selbst! Agent:  "+p.id);
			}
			p.setSuccessor(c);
		}
		
		setOn.addLastCar(c);
		c.pos.update(setOn, d);
		l.removeCar(c);
		return setOn;
	}
*/
	
	@Override
	public Car getLastCar(int direction, boolean lookahead) {
		if(lookahead && successorLines[0].nOfCars()==0 && successorLines[0].length<this.S.getMinLookahead()){
			return successorLines[0].getEndPoint().getLastCar(direction, false);
		}
		return this.successorLines[0].getLastCar();
	}
	
		


	@Override
	public Lane[] getSuccessorLines() {
		return successorLines;
	}




}
