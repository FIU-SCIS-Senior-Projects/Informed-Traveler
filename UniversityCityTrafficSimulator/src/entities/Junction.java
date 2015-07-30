package entities;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

import simulation.Simulation;

public class Junction extends LaneEnd{

//****************************
//	*constants & attributes*
//****************************


	
//****************************
	


	
	
//****************************
//	*constructor*
//****************************
	
	
	
	public Junction(Simulation S, String name, Point coords,  Lane[] successorLines, int[] leadingToDirections) {
		super(S,name,leadingToDirections, coords, successorLines);
		
		
		
	}

	public Junction(Simulation S, String name, Point coords,  Lane[] successorLines, int[] leadingToDirections, int lineEndStatus) {
		super(S,name,leadingToDirections, coords, successorLines);
		this.free=lineEndStatus;
		
	}
//****************************
//	   *methods*
//****************************

	@Override
	public Lane swapLines(int direction, double d, Lane l, Car c){
		
		Lane setOn;
		if(this.nOfSucceedingLines==1){
			setOn=this.successorLines[0];
			this.checkDirection(c, setOn);
		}
		else{
			setOn = findLine(direction);
			if(setOn==null){
				int x =100;
				for(Lane k : successorLines){
					for (int dir : k.getEndPoint().leadingToDirections){
						if(Math.abs(direction-dir)<x) {
							setOn=k;
							x=Math.abs(direction-dir);
						}
					}
				}
//				System.out.println("Wollte nach: "+direction +" - Gesetzt auf: "+setOn.name);
//				System.out.println();
				//As per construction this line does not lead to the car's direction
				c.tryToSwapLane=true;
			}
			else this.checkDirection(c, setOn);
		} 	
		
		//Update PredecessorGraph
		{
			Car newPredecessor = setOn.getLastCar(c.getDirection());
			
			//Update old Predecessors
			if(c.getPredecessor()!=null && c.getPredecessor().pos.line!=setOn && c.getPredecessor().getSuccessor()==c) c.getPredecessor().setSuccessor(c.getSuccessor());
			
			//setNewPredecessor
			c.setPredecessor(newPredecessor);
			
			//Check if old Successor is more than one line away
			Car oldSuccessor=c.getSuccessor();
			if(oldSuccessor!=null && oldSuccessor.pos.line!=l){
				if(oldSuccessor.getPredecessor()==c) oldSuccessor.setPredecessor(null);
				c.setSuccessor(null);
				
			}
			
			//Update the new Predecessors old Successor
			if(newPredecessor!=null && newPredecessor.pos.line==setOn && newPredecessor.getSuccessor()!=null && newPredecessor.getSuccessor()!=c && newPredecessor.getSuccessor().getPredecessor()==newPredecessor){
				newPredecessor.getSuccessor().setPredecessor(c);
			}
			
			//Set new Successor
			if(newPredecessor!=null) newPredecessor.setSuccessor(c);
			
		}
		setOn.addLastCar(c);
		c.pos.update(setOn, d);
		l.removeCar(c);
		return setOn;
	}
	
	
	
	/**
	 * Returns the last car on the first Line that  succeeds this junction and which leads to dir .
	 * If the by dir specified Line is very short (i.e. it is part of a junction) and has itself only one succeeding line, this method returns
	 * the last car on that line.
	 * @param dir {1,...,#succeedingLines}
	 */
	@Override
	public Car getLastCar(int direction, boolean lookahead) {
		Lane l = findLine(direction);
		//Die Heuristik wo der Agent hin will muss noch verbessert werden:
		if(l==null) return this.getNearestCar();
		
		if(lookahead && l.nOfCars()==0 && l.length<this.S.getMinLookahead()) return l.getEndPoint().getLastCar(direction, false);
		return l.getLastCar();
	}
	
	
	
	/**
	 * Finds those lines in the Line[] Array successorLines whose endPoint 
	 * leads to the given direction, and chooses from those the one whose last Car has the biggest distance from this LineEnd.
	 * @param direction
	 * @return
	 */
	private Lane findLine(int direction){
		Lane l = null; double dist = -10;
		for (Lane x : successorLines){
			List<Car> currentCars = x.getCurrentCars();
			for (int i : x.getEndPoint().leadingToDirections){
				if(i==direction && (currentCars.size()>0 ? (x.length-currentCars.get(currentCars.size()-1).pos.back) : x.length)>dist){
					l=x; dist = (currentCars.size()>0) ? (x.length-currentCars.get(currentCars.size()-1).pos.back) : x.length ;
				}
				if(i>direction) break;
			}
		}
		return l;
	}

	@Override
	public Lane[] getSuccessorLines() {
		return this.successorLines;
	}

	@Override
	public boolean dissectsDirection(int direction) {
		return false;
	}

	

}
	
