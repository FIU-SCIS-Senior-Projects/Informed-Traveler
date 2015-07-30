package simulation;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import organization.Autosaves;
import organization.EventQueue;

import statistics.Statistics;

import entities.*;
import sweetwaterCity.CityInitialization;



public class Simulation implements Runnable, Serializable {

	
//****************************
//	*constants & attributes*
//****************************
	 
	public final long seed;
	public final double startTime;	
	public final long standardDiscretization = 40;	
	public Lane[] lines;
	public LaneEnd[] lineEnds;
	public Sink[] sinks;
	public Spring[] springs;
	
//****************************
	public Statistics Statistics;
	private Random R;	
	private double simtime=0;
	public double realTime=0;		
	public int autoSaveCounter=0;
	
	/**
	 * Holds (in millisec.) the Interval in which the Cars update their Position.
	 */
	private long discretization = standardDiscretization;
	private double quickening = 1;
	
	/**
	 * Holds (in millisec) the Interval in which the Cars adapt their acceleration.
	 */
	public long reactionTime = 500;
	public int maxVelocity = 15;
	
	public double actAcceleration =0;
	public double actVelocity=0;
	
	
	public boolean play=false;
	public boolean interrupted = false;
	
	private int minLookahead = 70;
	private double standardPositiveAcceleration = 2.8;
	private double standardNegativeAcceleration = -8;
	private double standardMinDeceleration = -0.8;
	private double standardChevalricCoefficient = 0.5;
	private double minSwapIndex=1.5;
	private int laneSwapSlowdown = 5;
	private double standardLength = 4;
	private int numberOfCars = 0;
	private int actualCars = 0;
	public LinkedList<Car> cars;
	
	public EventQueue events;
	
	
	
//****************************
//	*constructor*
//****************************
	public Simulation(long seed) {

		this.seed=seed;
		
		startTime=System.currentTimeMillis();
		realTime=0;
		simtime=0;
		
		R = new Random(seed);
		
		cars = new LinkedList<Car>();
		events = new EventQueue();		
		
		//Initialize
//                CityInitialization.initialize(this);
                CityInitialization.initialize(this);
		Statistics = new Statistics(this);		
	}

//****************************
//	   *methods*
//****************************
	@Override
	public void run(){
		List<Car> deleteCars = new ArrayList<Car>();
		List<Integer> indices = new ArrayList<Integer>();
		
		double t=System.currentTimeMillis();
		while(play){
			realTime+=(System.currentTimeMillis()-t)/1000.0;
		//	System.out.println("Dauer der Runde: "+(System.currentTimeMillis()-t));
			t = System.currentTimeMillis();
			
			//Look after Events
			events.handleEvents(this.simtime);
			
			//Choose acceleration and update obstacles
			this.actAcceleration = 0;
			this.actVelocity = 0;
			
			
			for(int i=0; i<cars.size(); i++){
                            indices.add(Math.abs(R.nextInt())%(i+1), i);
			}
			for(int i=0; i<cars.size();i++){
                            cars.get(indices.get(i)).routine();
			}
			indices=new ArrayList<Integer>();
			
			this.actAcceleration/= (double)this.actualCars;
			this.actVelocity/=(double)this.actualCars;
			
			
			//****Upadte Positions every discretization Milliseconds*****
			for(long z = this.discretization; z<=reactionTime/quickening; z+=this.discretization){
                            for(Car c: cars){ if(c.updatePosition()) deleteCars.add(c); }
                            while(deleteCars.size()>0){
                                    removeCar(deleteCars.remove(0));
                            }

                            try {
                                    Thread.sleep(this.discretization/*+Math.round(delay)*/);
                            } catch (InterruptedException e) {e.printStackTrace();}
                            this.simtime+=(double)quickening*discretization/1000.0;
				
			}
			//****Upadte Positions every discretization Milliseconds  -  END*****
			
			
			//Autosave
//			double t =System.currentTimeMillis();
			this.play=false;
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ObjectOutputStream oos;
                        try {
                                oos = new ObjectOutputStream( baos );
                                oos.writeObject( this );
                                oos.close();
                        } catch (IOException e) {e.printStackTrace();}
                        byte[] outp =baos.toByteArray();
//				System.out.println("outp.length="+outp.length);
                        Autosaves.autoSaves.add(outp);


                        if(autoSaveCounter>=40) Autosaves.autoSaves.remove(0);
                        if(autoSaveCounter<40) autoSaveCounter++;

                        if(!this.interrupted) this.play=true;
//				System.out.println("Dauer des Autosaves:"+(System.currentTimeMillis()-t));
					
		}
		
	} 	
	
	public  synchronized void newCar(Spring s, int direction){
		Car c = new Car(numberOfCars, this ,  s.successorLines[0], direction);
		cars.add(c);
		numberOfCars++;
		actualCars++;
		Statistics.newCar(s.id);
		s.swapLines(direction, 0, null, c);
	}
	
	/**
	 * Sets a Car on springs[0] with direction 1.
	 */
	public void testCar(){
		newCar(springs[10],1);
	}
	
	
	/**
	 * Returns a direction for the next Car that arrives at the Dissection specified by id.,
	 * which wants to drive to the Direction specified by oldDirection
	 * @param id
	 * @param oldDirection
	 * @return
	 */
	public int getDirection(int id, int oldDirection) {
		return barbarossaplatz.Probabilities.getDirection(id, oldDirection, Math.abs(R.nextInt())%100);
	}
	
	/**
	 * Returns a direction for the next Car that arrives at the spring specified by id.
	 * @param id
	 * @return
	 */
	public int getNewDirection(int springID) {
		return barbarossaplatz.Probabilities.getNewDirection(springID, Math.abs(R.nextInt())%100);
	}
	
	/**
	 * Returns the predictant of the arrival time of the next Car at the spring specified by springID.
	 * @param id
	 * @return
	 */
	public double getLanePredictant(int springID) {
		return barbarossaplatz.Probabilities.getLanePredictant(springID);
	}

	public void finalStats(Car c, int sinkID) {
		Statistics.finalStats(c, sinkID);
		
	}
	
	/**
	 * Removes the given Car c from this Simulations car-list
	 * @param c
	 */
	public  synchronized void removeCar(Car c) {
		if(cars.remove(c));// System.out.println("Simulation: Fahrzeug "+c.id+" wurde gel�scht.");
		else System.out.println("Simulation:  !!!!!!!!!!!Vehicle "+c.id+ " can not be founded");
		actualCars--;
		
	}
	
	public int getInt() {
		return (R.nextInt());
	}
//****************************

	public void setMinLookahead(int minLookahead) {
		this.minLookahead = minLookahead;
	}
	public int getMinLookahead() {
		return minLookahead;
	}
	
	public void setDiscretization(long discretization){
		this.discretization=discretization;
	}
	public long getDiscretization(){
		return discretization;
	}

	public void setStandardPositiveAcceleration(double standardPositiveAcceleration) {
		this.standardPositiveAcceleration = standardPositiveAcceleration;
	}
	public double getStandardPositiveAcceleration() {
		return standardPositiveAcceleration;
	}

	public void setStandardNegativeAcceleration(double standardNegativeAcceleration) {
		this.standardNegativeAcceleration = standardNegativeAcceleration;
	}


	public double getStandardMinDeceleration(){
		return standardMinDeceleration;
	}
	public double getStandardNegativeAcceleration() {
		return standardNegativeAcceleration;
	}
	public void setStandardLength(double standardLength){
		this.standardLength=standardLength;
	}
	public double getStandardLength() {
		return standardLength;
	}

	public void setQuickening(double quickening) {
		this.quickening = quickening;
	}

	public double getSimTime(){
		return simtime;
	}

	public double getQuickening() {
		return quickening;
	}

	public double getGaussian(){
		return R.nextGaussian();
	}
	
	public double getDouble() {
		return R.nextDouble();
	}




	public void setStandardChevalricCoefficient(double standardChevalricCoefficient) {
		this.standardChevalricCoefficient = standardChevalricCoefficient;
	}




	public double getStandardChevalricCoefficient() {
		return standardChevalricCoefficient;
	}




	public void setMinSwapIndex(double minSwapIndex) {
		this.minSwapIndex = minSwapIndex;
	}




	public double getMinSwapIndex() {
		return minSwapIndex;
	}




	public void setLaneSwapSlowdown(int value) {
		this.laneSwapSlowdown= value;
		
	}
	public int getLaneSwapSlowdown(){
		return this.laneSwapSlowdown;
	}

        public LinkedList<Car> getCars() {
                        return cars;
                }


}
