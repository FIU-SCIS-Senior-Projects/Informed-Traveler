package entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import simulation.Simulation;

public class Lane implements Serializable {

public final int id;
//****************************
//	*constants & attributes*
//****************************
	public static final int RIGHT_NEIGHBOUR = 1;
	public static final int LEFT_NEIGHBOUR = -1;
	/**
	 * Holds the length of this line in [m]
	 */
	public final int length;
	public final String name;
	
//****************************
	private LinkedList<Car> cars;
	private Lane leftNeighbour;
	private Lane rightNeighbour;
	private LaneEnd endPoint;
	private boolean closed;
	
	
	
//****************************
//	*constructor*
//****************************
	public Lane(String name, int id, int length){
		this.name=name;
		this.id=id;
		this.length=length;
		cars=new LinkedList<Car>();
		this.closed=false;	
	}
//****************************
//	   *methods*
//****************************
        
        public int getID(){
            return this.id;
        }
        
	public int EndPointIsPassable(int direction){
		return (endPoint.isPassable( direction));
	}

	public synchronized boolean swapLane(Car car, int direction, boolean voluntarySwap) {
		
		//Establish the Lane to swap On
		Lane swapOnto = null;
		boolean tryLeft;
		boolean tryRight;
		
		
		if(!voluntarySwap){
                    if(direction<endPoint.leadingToDirections[0]) swapOnto = leftNeighbour;
                    else swapOnto = rightNeighbour;
		}
		else{
                    //Situations in which a swap isn't useful
                    if(car.obstacleDist==car.pos.front || car.getAcceleration()>=car.checkAcceleration(null, false)-0.5 || (car.getVelocity()>endPoint.S.maxVelocity-3 && car.getAcceleration()>0)) return false;

                    tryLeft = leftNeighbour==null? false : leftNeighbour.leadingToDirection(direction);
                    tryRight = rightNeighbour==null? false : rightNeighbour.leadingToDirection(direction);
                    if(!tryLeft && !tryRight) return false;
                    if(!tryLeft){swapOnto = checkAccelerationForLaneAndNeighbours(null, rightNeighbour, car);}
                    else if(!tryRight){swapOnto = checkAccelerationForLaneAndNeighbours(leftNeighbour, null, car);}
                    else{swapOnto = checkAccelerationForLaneAndNeighbours(leftNeighbour, rightNeighbour, car);}
		}
		if(swapOnto==null){
//			System.out.println("Lane "+this.name+" CarID.: "+car.id +"  :   swapOnto = null  -- !!fehler!!");
			return false;
		}
		
		if(swapOnto.enoughSpace(car.pos.front/length , car.length , car.getVelocity()) ){
		
			Car oldPredecessor=car.getPredecessor();
			Car oldSuccessor=car.getSuccessor();
			if( swapOnto.addCar(car, car.pos.front/length*swapOnto.length) ){
				if(oldSuccessor!=null && oldSuccessor.getPredecessor()==car)oldSuccessor.setPredecessor(oldPredecessor);
				if(oldPredecessor!=null && oldSuccessor!=null && oldSuccessor.pos.line==oldPredecessor.pos.line){oldPredecessor.setSuccessor(oldSuccessor);}
				else if(oldPredecessor!=null) oldPredecessor.setSuccessor(null);
				
				if(swapOnto.leadingToDirection(car.getDirection())) car.tryToSwapLane = false;
				
				car.pos.update(swapOnto, swapOnto.length-car.pos.front/length*(double)swapOnto.length);
				this.removeCar(car);
				return true;
			}
			
			
			
		}
		return false;
	}
	
	/**
	 * Returns the Lane to swap on, or null if a swap isn't worth the effort.
	 * @param leftNeighbour
	 * @param rightNeighbour
	 * @return
	 */
	private Lane checkAccelerationForLaneAndNeighbours(Lane leftNeighbour, Lane rightNeighbour, Car c) {
		double possibleLeftAcceleration = -20;
		double possibleLeftSuccessorAccelerationDifference = 0;
		double possibleRightAcceleration = -20;
		double possibleRightSuccessorAccelerationDifference = 0;
		double actAcceleration = c.getAcceleration();
		
		
		if(leftNeighbour!=null && leftNeighbour.enoughSpace(c.pos.front/length, c.length, c.getVelocity())){
			double frontOnLeftLine = c.pos.front/length*leftNeighbour.length;
			List<Car> lN_Cars = leftNeighbour.getCurrentCars();
			
			if(lN_Cars.isEmpty()){
				Car possiblePred = leftNeighbour.endPoint.getLastCar(c.getDirection(),false);
				possibleLeftAcceleration= c.checkAcceleration(possiblePred, false);
			}
			else if(lN_Cars.get(0).pos.front > frontOnLeftLine){
				Car possibleSucc = lN_Cars.get(0);
				Car possiblePred = possibleSucc.getPredecessor();
				possibleLeftAcceleration=c.checkAcceleration(possiblePred, false);
				possibleLeftSuccessorAccelerationDifference =possibleSucc.checkAcceleration(c, true)-possibleSucc.getAcceleration();
			}
			else if(lN_Cars.get(lN_Cars.size()-1).pos.front < frontOnLeftLine){
				Car possiblePred = lN_Cars.get(lN_Cars.size()-1);
				Car possibleSucc = possiblePred.getSuccessor();
				possibleLeftAcceleration = c.checkAcceleration(possiblePred, true);
				if(possibleSucc!=null && possibleSucc.getPredecessor()==possiblePred) possibleLeftSuccessorAccelerationDifference = possibleSucc.checkAcceleration(c, false)-possibleSucc.getAcceleration();
			}
			else{
				int i=1;
				for(; i<lN_Cars.size()-1; i++){
					
					if(lN_Cars.get(i).pos.front>frontOnLeftLine) break;
				}
				if(i==lN_Cars.size()){
					System.out.println("Lane: Index error in addCar()");
				}
				Car possiblePred = lN_Cars.get(i-1);
				Car possibleSucc = lN_Cars.get(i);
				
				possibleLeftAcceleration = c.checkAcceleration(possiblePred, true);
				possibleLeftSuccessorAccelerationDifference = possibleSucc.checkAcceleration(c, true)-possibleSucc.getAcceleration();
			}
			
		}
		if(rightNeighbour!=null && rightNeighbour.enoughSpace(c.pos.front/length, c.length, c.getVelocity())){
			double frontOnRightLine = c.pos.front/length*rightNeighbour.length;
			List<Car> rN_Cars = rightNeighbour.getCurrentCars();
			
			if(rN_Cars.isEmpty()){
				Car possiblePred = rightNeighbour.endPoint.getLastCar(c.getDirection(),false);
				possibleRightAcceleration= c.checkAcceleration(possiblePred, false);
			}
			else if(rN_Cars.get(0).pos.front > frontOnRightLine){
				Car possibleSucc = rN_Cars.get(0);
				Car possiblePred = possibleSucc.getPredecessor();
				possibleRightAcceleration=c.checkAcceleration(possiblePred, false);
				possibleRightSuccessorAccelerationDifference =possibleSucc.checkAcceleration(c, true)-possibleSucc.getAcceleration();
			}
			else if(rN_Cars.get(rN_Cars.size()-1).pos.front < frontOnRightLine){
				Car possiblePred = rN_Cars.get(rN_Cars.size()-1);
				Car possibleSucc = possiblePred.getSuccessor();
				possibleRightAcceleration = c.checkAcceleration(possiblePred, true);
				if(possibleSucc!=null && possibleSucc.getPredecessor()==possiblePred) possibleRightSuccessorAccelerationDifference = possibleSucc.checkAcceleration(c, false)-possibleSucc.getAcceleration();
			}
			else{
				int i=1;
				for(; i<rN_Cars.size()-1; i++){
					
					if(rN_Cars.get(i).pos.front>frontOnRightLine) break;
				}		
				if(i==rN_Cars.size()){
					System.out.println("Lane: Index error in addCar()");
				}
				Car possiblePred = rN_Cars.get(i-1);
				Car possibleSucc = rN_Cars.get(i);
				
				possibleLeftAcceleration = c.checkAcceleration(possiblePred, true);
				possibleLeftSuccessorAccelerationDifference = possibleSucc.checkAcceleration(c, true)-possibleSucc.getAcceleration();
			}
		}
		
		double leftIndex = possibleLeftAcceleration-actAcceleration + c.chevalricCoefficient* (possibleLeftSuccessorAccelerationDifference);
		double rightIndex = possibleRightAcceleration-actAcceleration + c.chevalricCoefficient* (possibleRightSuccessorAccelerationDifference);
		
		if(leftIndex<endPoint.S.getMinSwapIndex() && rightIndex<endPoint.S.getMinSwapIndex()) return null;
		else return(leftIndex>rightIndex ? leftNeighbour : rightNeighbour);
	}
	



	
	/**
	 * Checks if on this Lane is enough space for a car between relativeFrontPosition*this.length and relativeFrontPosition*this.length+length.
	 * This DOESN'T imply a safety-check of the acceleration of this car and its possible successor.
	 * @param relativeFrontPosition
	 * @param length
	 * @return
	 */
	public boolean enoughSpace(double relativeFrontPosition, double length, double speed){
		double front = this.length *  relativeFrontPosition;
		//The way this car drives until it sets its acceleration
		double s_0 =  speed* (double)endPoint.S.reactionTime/1000.0;
		
		//Do not swap lanes in the first 5  or last 1 meters of a lane
		if(front < 1 || this.length-front < 7) return false;
		if(cars.peekFirst()== null || front+length < cars.peekFirst().pos.front-2.5 ){
			Car nearest = endPoint.getNearestCar();
			if(nearest!=null && front+nearest.pos.back-s_0<2) return false;
		}
		for(Car c : cars){
			//The way c drives until it sets its acceleration
			double s_c = c.getVelocity()*(double)endPoint.S.reactionTime/1000.0;
			if( (c.pos.front+0.1>front && c.pos.front<front+length+ s_c) || (c.pos.back > (front-s_0) && c.pos.back-0.1 < front+length) || c.pos.front-0.1<front && c.pos.back+0.1>front+length){
				return false;
			}
		if(c.pos.front > front+length) return true;
		}
		return true;
	}
	
	
	/**
	 * This method adds the given car c to this line. It assumes, that there is "enough space" for the car
	 * in terms of the method enoughSpace(). It may add the car c to this line even if this assumption is not fulfilled.
	 * It does perform a safetyCheck of the acceleration respective the car c and it's predecessor on this line and the car's succeccor on this line.
	 * This means the method returns false (and doesn't add the car) if either c.checkAcceleration(possiblePred) or possibleSucc.checkAcceleration(c)
	 * returns a value smaller than c.safeDeceleration.
	 * If the car c has been added, the method updates the predecessor-graph on THIS line, which means the oldPredecessor and oldSuccessor have to be handled accessorily.
	 * 
	 * @param Car c - is added to this lane
	 * @param frontOnNewLine
	 * @return false iff the acceleration-safetyCheck of the related cars doesn't fulfill c's safety-criterion.
	 */
	public synchronized boolean addCar(Car c, double frontOnNewLine){
	
		//special cases
		if(cars.isEmpty()){
			Car possiblePred = endPoint.getLastCar(c.getDirection(), false);
			
			if(possiblePred!=null && c.checkAcceleration(possiblePred, false)<c.safeDeceleration) return false;
			
			
			c.setPredecessor(possiblePred);
			if(possiblePred!=null){
				possiblePred.setSuccessor(c);
			}
			c.setSuccessor(null);
			
			cars.add(c);
			return true;
		}
		if(cars.peekLast().pos.front < frontOnNewLine){
			Car possiblePred = getLastCar();
			Car possibleSucc = possiblePred.getSuccessor();
			
			if( c.checkAcceleration(possiblePred,true)<c.safeDeceleration || (possibleSucc!=null && possibleSucc.checkAcceleration(c, false)<c.safeDeceleration)) return false;
			
			c.setPredecessor(possiblePred);
			if(possibleSucc!=c) c.setSuccessor(possibleSucc);
			else c.setSuccessor(null);
			possiblePred.setSuccessor(c);
			if(possibleSucc!=null && possibleSucc!=c && possibleSucc.getPredecessor()==possiblePred) possibleSucc.setPredecessor(c);
			
			cars.addLast(c);
			return true;
		}
		if(cars.peekFirst().pos.front > frontOnNewLine){
			Car possibleSucc = cars.get(0);
			Car possiblePred = possibleSucc.getPredecessor();
			if(possiblePred == null || !possiblePred.pos.line.leadingToDirection(c.getDirection()) ) possiblePred = endPoint.getLastCar(c.getDirection(), false);
			
			if( (possiblePred != null && c.checkAcceleration(possiblePred, false)<c.safeDeceleration)  || possibleSucc.checkAcceleration(c, true)<c.safeDeceleration ) return false;
			
			c.setPredecessor(possiblePred);
			c.setSuccessor(possibleSucc);
			if(possiblePred!=null){
				possiblePred.setSuccessor(c);
			}
			
			possibleSucc.setPredecessor(c);
			
			cars.addFirst(c);
			return true;
		}
		
		
		//
		int i=1;
		for(; i<cars.size()-1; i++){
			
			if(cars.get(i).pos.front>frontOnNewLine) break;
		}	
		if(i==cars.size()){
			System.out.println("Lane: Index error in addCar()");
		}
		Car possiblePred = cars.get(i-1);
		Car possibleSucc = cars.get(i);
		
		if(c.checkAcceleration(possiblePred,true)<c.safeDeceleration || possibleSucc.checkAcceleration(c, true)<c.safeDeceleration ) return false;
		
		c.setPredecessor(possiblePred);
		c.setSuccessor(possibleSucc);
		possiblePred.setSuccessor(c);
		possibleSucc.setPredecessor(c);
		
		cars.add(i,c);
		return true;
	}
	
	/**
	 * Only removes the given Car c from this lane's 'cars'-list.
	 * @param c
	 */
	public synchronized void removeCar(Car c) {
		if(cars.remove(c));// System.out.println("Line "+name+". Fahrzeug "+c.id+" wurde gel�scht.");
		//else System.out.println("!!!!!!!!!!!Fahrzeug "+c.id+ " konnte nicht gefunden werden!!!!!!");
			
	}
	
	/**
	 * Returns the Last car in this line's carlist, or invokes the getLastCar() method of the by dir specified succeeding line.
	 * If no such line exists, it invokes the getLastCar() method of the succeeding line with the highest direction-number,
	 * i.e. the last line in the endPoints list of succeeding lines.
	 */
	public synchronized Car getLastCar(int dir) {
		if(!(cars.size()==0)){return(cars.peekLast());}
		return getEndPoint().getLastCar(dir,false);
	}
	
	
	/**
	 * Returns the last car on this line, or null if it is empty.
	 * @return
	 */
	public synchronized Car getLastCar(){
		return cars.peekLast();
	}
	
	/**
	 * Returns the Last car in this line's carlist, or null if it is empty.
	 */
	public synchronized void addLastCar(Car c) {
		cars.addLast(c);
	}
	
	/**
	 * Returns true iff this lanes field 'leadingToDirection' (which holds the directions in ASCENDING order) contains the value dir.
	 * @param dir
	 * @return false iff dir is no element in 'leadingToDirections'.
	 */
	public boolean leadingToDirection(int dir){
		if(this.closed)return false;
		for(int x : endPoint.leadingToDirections){
			if(dir == x) return true;
			if(x>dir) break;
		}
		return false;
	}
	
	public boolean dissectsDirection(int dir){
		if(this.closed) return true;
		else return endPoint.dissectsDirection(dir);
	}

//****************************
	public Lane getLN(){
		return leftNeighbour;
	}
	public Lane getRN(){
		return rightNeighbour;
	}
	public LaneEnd getEndPoint() {
		return endPoint;
	}
	public void setEndPoint(LaneEnd p){
		this.endPoint = p;
	}


	
	public synchronized List<Car> getCurrentCars() {
		return new ArrayList<Car>(cars);
	}
	

	public void set_N_eP(Lane leftN, Lane rightN, LaneEnd LE) {
		this.leftNeighbour=leftN;
		this.rightNeighbour=rightN;
		this.endPoint=LE;
		
	}

	public int nOfCars() {
		return cars.size();
	}
	
	public void closeLine(){
		this.closed=true;
	}
	public void openLine(){
		this.closed=false;
	}
	public boolean isClosed(){
		return closed;
	}
	
}
