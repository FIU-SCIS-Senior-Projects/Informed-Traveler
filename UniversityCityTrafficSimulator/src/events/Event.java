package events;

import java.io.Serializable;
import java.util.Comparator;

import simulation.Simulation;





public abstract class Event implements Comparable<Event>, Serializable{
	
		public final double executionTime;
		
		
		public Event(double executionTime){
			this.executionTime=executionTime;
		}


		
		
		/**
		 * Returns 1 if the exec.Time of this Event is a bigger Number than e.execTime
		 * Returns -1 if the exec.Time of this Event is a smaller Number than e.execTime.
		 * I.e. this.compareTo(e) == -1 if and only if this Event takes place earlier.
		 */
                @Override
		public synchronized int compareTo(Event e) {
			if(this.executionTime > e.executionTime) return 1;
			else if (this.executionTime < e.executionTime) return -1;
			return 0;
		}
		
		public abstract void execute();



		public void print() {
			// TODO Auto-generated method stub
			
		}
}
