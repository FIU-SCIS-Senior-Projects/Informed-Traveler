package organization;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;

import events.Event;
import events.TrafficLight_Event;

	

	public class EventQueue implements Serializable {
		
		private LinkedList<Event> eventList;
	
		
		public EventQueue(){
			this.eventList = new LinkedList<Event>();
			
		}
		
		
		public synchronized void add(Event e){
			/*
			if(!eventList.isEmpty() && eventList.element().executionTime==0 && e.executionTime==0 && ((TrafficLight_Event)e).p.name.equals("leI_M6_5")){
				System.out.println("hab sich schon wieder");
			}
			*/
			if(eventList.isEmpty()){
				eventList.addFirst(e);
				return;
			}
			if(e.compareTo(eventList.getLast())>=0){
				eventList.addLast(e);
				return;
			}
			for(int i=0; i<eventList.size(); i++){
				Event x=eventList.get(i);
				if(e.compareTo(x)<=0){
					eventList.add(i, e);
					return;
				}
			}
			
		}
		
		public synchronized void handleEvents(double simtime){
//			System.out.println("Länge der eventList: "+eventList.size());
			while(this.eventList.isEmpty()==false){
				if(this.eventList.element().executionTime>simtime) return;
					
				this.eventList.pop().execute();
			}
			
		}


		public synchronized void print() {
			for(Event e: eventList){
				e.print();
			}
		}
		
}
