package entities;

import organization.Position;
import simulation.Simulation;
import entities.*;
import java.io.Serializable;

public class Car implements Serializable{

//****************************
//	*constants & attributes*
//****************************
	public final int id;
	final Simulation Simulation;
	/**[m/sec�]*/
	final double maxAcceleration;
	/**[m/sec�]*/
	final double minAcceleration;
	public final double minDeceleration;
	final double safeDeceleration;
	final double chevalricCoefficient;
	/**Represents the length of this car in [m]*/
	public final double length;
//****************************
	public boolean erased = false;
	/**[m/sec]*/
	private double velocity;
	/**[m/sec�]*/
	private double acceleration;
	private Car predecessor;
	private Car successor;
	private double lastSwap=0;
	
	public Position pos;
	private int direction;
	public boolean tryToSwapLane;
	public double safetyDistance;
	
	public double obstacleDist;
	double obstacleSpeed;
	private double obstacleAcceleration;

		
//****************************
//		*constructor*
//****************************
	public Car(int id,Simulation Simulation, Lane line, int direction){
		//identification
		this.id = id;
		this.Simulation = Simulation;
		
		//predecessor & successor
		this.predecessor = line.getLastCar(direction);
		if(predecessor!=null) this.predecessor.setSuccessor(this);
		this.successor=null;
		
		//car-attributes
		length = Simulation.getStandardLength()+0.6*Simulation.getGaussian();
		double r = Simulation.getGaussian();
		maxAcceleration = Simulation.getStandardPositiveAcceleration()+0.6*r;
		minAcceleration = Simulation.getStandardNegativeAcceleration()-r;
		this.minDeceleration = Simulation.getStandardMinDeceleration()-0.2*r;
		this.safeDeceleration = -1.5+0.5*r;
		this.chevalricCoefficient = Simulation.getStandardChevalricCoefficient()+0.1*r;
		
		setAcceleration(0);
		if(predecessor==null || predecessor.pos.line!=line) setVelocity(18);
		else setVelocity(predecessor.getVelocity());
		
		//position and direction
		this.setDirection(direction);
		this.pos=new Position(line,length);		
	}	
	
//****************************
//		   *methods*
//****************************
	public synchronized void routine(){
		updatePredecessor();
		updateObstacle();
//		if(obstacleDist<0  &&this.pos.front>3){
//			System.out.println("Agent "+this.id+": Unfall auf Lane " +this.pos.line.name+"!!!");
//		}
		this.setAcceleration(chooseAcceleration(obstacleDist, obstacleSpeed));
		if( (tryToSwapLane || Simulation.getSimTime()-lastSwap > 1.5) && pos.line.swapLane(this, direction, !tryToSwapLane)){
			lastSwap=Simulation.getSimTime();
			updateObstacle();
			this.setAcceleration(chooseAcceleration(obstacleDist, obstacleSpeed));
		}
		Simulation.actAcceleration+=this.acceleration;
		Simulation.actVelocity+=this.velocity;
		
//		System.out.println("Agent "+id+":      Front: "+pos.front+"   tryToSwL.:"+tryToSwapLane +"    Pred.ID: "+((predecessor==null)?"NULL":predecessor.id) +"   Succ.ID: "+((successor==null)?"NULL":successor.id)+"    ObstDist: "+obstacleDist+"  ObstV="+obstacleSpeed+" velocity= "+velocity + "   acceleration="+acceleration  +"   safetyDist="+safetyDistance+"    minDecel.="+this.minDeceleration+"   minAcc="+this.minAcceleration);
		
	}
	
	
	private void updatePredecessor(){
            if(this.predecessor!=null && predecessor.pos.line!=this.pos.line){
                if(this.pos.line.dissectsDirection(this.direction)) {
                        if(predecessor.getSuccessor()==this) predecessor.setSuccessor(null);
                        predecessor=pos.line.getEndPoint().getNearestCar();
                }
                else if(!predecessor.pos.line.leadingToDirection(this.direction)){
                        if(predecessor.getSuccessor()==this) predecessor.setSuccessor(null);
                        predecessor=pos.line.getEndPoint().getLastCar(this.direction, true);	
                }
            }
            else if(predecessor==null){
                if(this.pos.line.dissectsDirection(direction)){
                        predecessor=this.pos.line.getEndPoint().getNearestCar();}
                else  predecessor=this.pos.line.getEndPoint().getLastCar(direction, true);
            }
            if(predecessor!=null && predecessor.getSuccessor()==null)predecessor.setSuccessor(this);
	}
	
	
	private void updateObstacle() {
		switch(pos.line.EndPointIsPassable(direction)){
			case LaneEnd.LINEEND_RED :
                            if(this.predecessor==null || this.predecessor.pos.line!=pos.line){
                                    obstacleDist=pos.front; obstacleSpeed = 0; obstacleAcceleration = 0;
                                    break;			
                            }

                            else{
                                    obstacleDist=pos.front-predecessor.pos.back; obstacleSpeed=predecessor.getVelocity(); obstacleAcceleration=predecessor.getAcceleration();
                                    break;
                            }
			case LaneEnd.LINEEND_YELLOW:
                            //If the Agent would have to use more than 2/5 of his maximum negative acceleration, he goes on driving even though the traffic light is yellow.
                            //Otherwise he stops
                            if(-0.5*getVelocity()*getVelocity()/pos.front < 0.6*minAcceleration){
                                if(this.predecessor==null){
                                    obstacleDist=10000; obstacleSpeed=0; obstacleAcceleration=0;
                                    break;
                                }
                                else{
                                    if(this.predecessor.pos.line!=pos.line) obstacleDist= pos.front+predecessor.pos.line.length-predecessor.pos.back;
                                    else obstacleDist=pos.front-predecessor.pos.back;
                                    obstacleSpeed=predecessor.getVelocity(); obstacleAcceleration=predecessor.getAcceleration();
                                    break;
                                }
                            }
                            else{
                                    if(this.predecessor==null || this.predecessor.pos.line!=pos.line){
                                        obstacleDist=pos.front; obstacleSpeed = 0; obstacleAcceleration = 0;
                                        break;
                                    }
                                    else{
                                        obstacleDist=pos.front-predecessor.pos.back; obstacleSpeed=predecessor.getVelocity(); obstacleAcceleration=predecessor.getAcceleration();
                                        break;
                                    }
				}
			case LaneEnd.LINEEND_GREEN:
                            if(this.predecessor==null){
                                obstacleDist=10000; obstacleSpeed=20; obstacleAcceleration=0;
                                break;
                            }
                            else{
                                if(this.predecessor.pos.line!=pos.line) obstacleDist= pos.front+predecessor.pos.line.length-predecessor.pos.back;
                                else obstacleDist=pos.front-predecessor.pos.back;
                                obstacleSpeed=predecessor.getVelocity(); obstacleAcceleration=predecessor.getAcceleration();
                                break;
                            }
		}		
	}
	
	
	private double chooseAcceleration(double obstacleDist, double obstacleSpeed) {
		double acc;
			
		acc= 0;
		if(obstacleDist >= this.Simulation.getMinLookahead()/Simulation.maxVelocity * (velocity+this.maxAcceleration)){
			acc=0.5*this.maxAcceleration; 
		}
		else if(obstacleSpeed > this.getVelocity()){
			if(obstacleDist < getSafetyDistance(obstacleSpeed)){
				if(obstacleAcceleration > 0) acc = 0.5*obstacleAcceleration;
				else acc = obstacleAcceleration-0.8;
			}
			else //if (obstacleDist<10)
			{
				if(obstacleAcceleration >= 0) acc = Math.min(0.5*maxAcceleration, 0.5+obstacleAcceleration); //1.5*obstacleAcceleration;
				else acc = 0;
			}
		}
		else{
			double sD = getSafetyDistance(obstacleSpeed);
			double deceleration;
			if(obstacleDist<=sD){
				//acc = Math.min(-1,(1-obstacleDist/sD)*minAcceleration);
				sD = obstacleDist/2;
				deceleration = Math.min(-2, 0.5*(velocity-obstacleSpeed)*(velocity-obstacleSpeed)/(sD-obstacleDist) + obstacleAcceleration);
			}
			else{
				sD = Math.max(2, getSafetyDistance(obstacleSpeed + obstacleAcceleration*(velocity-obstacleSpeed)/(obstacleAcceleration+2) ));
				deceleration =0.5*(velocity-obstacleSpeed)*(velocity-obstacleSpeed)/(sD-obstacleDist) + obstacleAcceleration;
			}
			
			if(deceleration>this.minDeceleration) acc = 0.4/*-0.5/deceleration*/;
			else acc = deceleration;
			
		}
		
		
		//Slow down if the junction ahead is closed or dissects this car's direction
		if(this.pos.line.isClosed()){
	//		System.out.println("line closed");
			double deceleration = (-velocity*velocity)/(2.0*(pos.front-2.5));
			if((deceleration<-0.34 || this.pos.front<3) && acc>deceleration){
				acc = Math.min(0,deceleration);
			}
		}
		else if(pos.front<80 && pos.front > 1.5 && pos.line.dissectsDirection(direction)){
			double deceleration = (Simulation.getLaneSwapSlowdown()*Simulation.getLaneSwapSlowdown()-velocity*velocity)/(2.0*(pos.front-1.5));
			if(deceleration<-0.8 && acc>deceleration){
				acc = deceleration;
			}
		}
		
		
		//Slow down if the simulation's maximum velocity has been changed
		if(velocity>this.Simulation.maxVelocity && acc > -0.5) acc = -0.5;
		
		
		if(acc > this.maxAcceleration) acc = this.maxAcceleration;
		else if(acc < this.minAcceleration)acc = this.minAcceleration;
		if(getVelocity()==Simulation.maxVelocity && acc >0 ) acc = 0;
		else if (getVelocity()==0 && acc <0) acc =0;

		
		
		return acc;
		
		
		
	}
	
	/**
	 * updates the Position of the Car. Returns true, if the Car has to be deleted
	 */
	public synchronized boolean updatePosition() {
		if(this.erased) return false;
		
		double t = (double)Simulation.getDiscretization()/1000*Simulation.getQuickening();
		
		if(acceleration>0){
			if(velocity+acceleration*t<Simulation.maxVelocity) setVelocity(getVelocity() + (getAcceleration()*t));
			else setVelocity(Simulation.maxVelocity);
		}
		else if(getAcceleration()<0){
			if(getVelocity()+getAcceleration()*t>0) setVelocity(getVelocity() + (getAcceleration()*t));
			else setVelocity(0);
		}
		
		double s_0=this.pos.front;
		double s_t = getVelocity()*t;  
		if(s_0-s_t>=-0.5*length) {
			this.pos.update(s_t);
			return false;
		}
		LaneEnd eP=pos.line.getEndPoint();
		eP.swapLines(this.getDirection(), s_t-s_0, pos.line, this);
		if(eP.getClass()==Sink.class){this.erased = true; return true;}
		return false;
	}


	private double getSafetyDistance(double obstacleSpeed){
		
		//	return( 0.8 + obstacleSpeed* B + obstacleSpeed*obstacleSpeed* A + obstacleAcceleration);
		
		// Positive iff this car is faster than the obstacle
		
		double safetyDistance = 0.5*obstacleSpeed+2;
		this.safetyDistance = safetyDistance;
		if(safetyDistance < 0 ){
//			System.out.println("SD < 0!!!!!!!");
		}
		/*
		double delta = (velocity-obstacleSpeed)/7;
		
		//					Mindestabstand	 +		 Zus. Brmsw. d. h�h. Geschw.  	 + 			 Reaktionsweg	
		safetyDistance=	(      1 			 + 		velocity*delta - 3.5*delta*delta +  (double)Simulation.reactionTime/1000.0*velocity);
	*/
		
		//	System.out.println("SafetyDistance="+safetyDistance);
		return(safetyDistance);
		
	}




//****************************
	public Car getPredecessor(){
		return predecessor;
	}
	public void setPredecessor(Car c){
		predecessor=c;
	}
	public Car getSuccessor(){
		return successor;
	}
	public void setSuccessor(Car c){
		successor=c;
	}



	void setDirection(int direction) {
		this.direction = direction;
	}



	public int getDirection() {
		return direction;
	}


	/**
	 * Returns the acceleration this Car would choose if possiblePred was his predecessor.
	 * @param possiblePred - may be null
	 * @return
	 */
	public double checkAcceleration(Car possiblePred, boolean isOnMyLane) {
		
		if(possiblePred==null) return chooseAcceleration(10000,30);
		else{
			double distance= ( (isOnMyLane) ? (this.pos.front-possiblePred.pos.back) : (this.pos.front+possiblePred.pos.line.length-possiblePred.pos.back));
			return chooseAcceleration(distance, possiblePred.getVelocity());
		}
	}



	public void setAcceleration(double acceleration) {
		this.acceleration = acceleration;
	}



	public double getAcceleration() {
		return acceleration;
	}



	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}



	public double getVelocity() {
		return velocity;
	}
	
}
