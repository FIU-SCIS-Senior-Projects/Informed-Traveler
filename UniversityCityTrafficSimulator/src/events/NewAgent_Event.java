package events;

import simulation.Simulation;
import entities.Spring;

public class NewAgent_Event extends Event {

	private Simulation S;
	private Spring spring;
	private boolean predictantZero = false;

	public NewAgent_Event(Simulation S, double executionTime, Spring s) {
		super(executionTime);
		this.S=S;
		this.spring =s;
		
	}

	@Override
	public  synchronized void execute() {
		
		double Predictant = S.getLanePredictant(spring.id);
		
		if(!(Predictant == 0) && (spring.successorLines[0].getLastCar()== null || spring.successorLines[0].getLastCar().pos.back <spring.successorLines[0].length-2)){
			int direction = S.getNewDirection(spring.id);
			S.newCar(spring,direction);
			
			double nextAgent =S.getSimTime()+ (-1.0 * Predictant * Math.log(S.getDouble()));
			S.events.add(new NewAgent_Event(S,nextAgent, spring));
			
		}
		else{
			double nextAgent =S.getSimTime()+ 0.5;
			S.events.add(new NewAgent_Event(S,nextAgent, spring));
		}
	}
	
	public void print(){
		System.out.println("NA_E -- " + spring.name +"   ExecT.: "+executionTime);
	}
}
