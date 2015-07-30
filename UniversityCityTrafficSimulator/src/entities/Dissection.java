package entities;

import java.awt.Point;

import simulation.Simulation;

public class Dissection extends Junction {

	/**
	 * Holds the directions which this dissection has to replace by a new one.
	 * Is null if all directions are concerned.
	 */
	private final int[] relevantDirections;
	public final int id;
	
//****************************
//		*constructor*
//****************************
		
		
		
		public Dissection(Simulation S, int id, String name, Point coords, Lane[] successorLines, int[] leadingToDirections, int[] relevantDirections) {
			super(S,name, coords,successorLines,leadingToDirections);
			this.relevantDirections = relevantDirections;
			this.id=id;
						
		}
		public Dissection(Simulation S, int id, String name, Point coords, Lane[] successorLines, int[] leadingToDirections, int[] relevantDirections, int lineEndStatus) {
			super(S,name, coords,successorLines,leadingToDirections);
			this.id=id;
			this.relevantDirections = relevantDirections;
			this.free=lineEndStatus;
		}
		
		@Override
		public Lane swapLines(int direction, double d, Lane l, Car c){
			if(rollTheDiceFor(direction)) c.setDirection(S.getDirection(this.id,direction));
			Lane setOn = super.swapLines(c.getDirection(), d, l, c);
			return setOn;
		}
		
		
		private boolean rollTheDiceFor(int dir){
			if(relevantDirections == null) return true;
			for(int x:relevantDirections){
				if(dir==x) return true;
				if(x>dir) return false;
			}
			return false;
		}
		
		
		@Override
		public boolean dissectsDirection(int direction) {
			boolean leadingToDirection = false;
			for(int i : leadingToDirections){
				if(i==direction){
					leadingToDirection=true;
					break;
				}
				if(i>direction){
					break;
				}
			}
			
			if(!leadingToDirection) return(rollTheDiceFor(direction));
			else return false;
			
		}
		
		
		
		
}
