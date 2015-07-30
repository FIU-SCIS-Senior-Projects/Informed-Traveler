package events;

import simulation.Simulation;
import entities.LaneEnd;

public class TrafficLight_Event extends Event {

	public LaneEnd p;
	private int toState;
	private Simulation S;

	public TrafficLight_Event(Simulation S, LaneEnd e, int toState, double executionTime ) {
		super(executionTime);
		this.S=S;
		this.p=e;
		this.toState=toState;
	}

	
	@Override
	public synchronized void execute() {
	//	System.out.println("TLEvent: "+p.name+"  execTime%105: "+(executionTime%105)+ "   set to "+toState);
		p.free=toState;
		
		S.events.add(new TrafficLight_Event(S, p, toState, executionTime+160));
		
		
	}
	
	public void print(){
		System.out.println("TfL_E -- "+p.name+"  ToState: "+toState+"  execT.: "+executionTime);
	}
		
}
