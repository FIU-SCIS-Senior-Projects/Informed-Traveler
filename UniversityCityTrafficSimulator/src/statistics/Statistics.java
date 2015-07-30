package statistics;

import java.io.Serializable;

import simulation.Simulation;
import entities.Car;


public class Statistics implements Serializable{
	
	private int[] producedCars;
	private int[]erasedCars;
	private Simulation S;
	private int producedAgents=0;
	public int erasedAgents = 0;
	public Statistics(Simulation S){
		this.S = S;
		producedCars = new int[S.springs.length];
		erasedCars = new int[S.sinks.length];
	}
	
	
	public void finalStats(Car c, int sinkID ) {
		erasedAgents++;
		erasedCars[sinkID-1]++;
	}
		
	
	public void newCar(int springID) {
		producedAgents += 1;
		switch(springID){
		//A1
		case 39: producedCars[0]++; return;
		case 40: producedCars[1]++; return;		
		case 41: producedCars[2]++; return;
		case 42: producedCars[3]++; return;
                //A2   
		case 43: producedCars[4]++; return;		
		case 44: producedCars[5]++; return;
		//A3
		case 45: producedCars[6]++; return;
		case 46: producedCars[7]++; return;
		//A4
		case 47: producedCars[8]++; return;
		case 48: producedCars[9]++; return;
		//A5
		case 49: producedCars[10]++; return;
		case 50: producedCars[11]++; return;
		case 51: producedCars[12]++; return;
                case 52: producedCars[13]++; return;
                //A6
                case 53: producedCars[14]++; return;
		case 54: producedCars[15]++; return;
		case 55: producedCars[16]++; return;
                //A7
		case 56: producedCars[17]++; return;
                case 57: producedCars[18]++; return;
                case 58: producedCars[19]++; return;
                //A8
                case 59: producedCars[20]++; return;
                //A9    
                case 60: producedCars[21]++; return;
                //A10
                case 61: producedCars[22]++; return;
                case 62: producedCars[23]++; return;
                case 63: producedCars[24]++; return;
                //A11
                case 64: producedCars[25]++; return;  
		default: System.out.println("!!!!!!!!!!!!!Statistics: spring not founded. 1 car is messing in the generating statistics!!!!!!!!!!!!!!!"); // Quelle nicht gefunden. 1 Auto fehlt in der Produced-Statistik
		}
		
	}
	
	public int getProducedCars(int springID){
		switch(springID){
		//A1
		case 39: return producedCars[0]; 
		case 40: return producedCars[1];		
		case 41: return producedCars[2];
		case 42: return producedCars[3];
		//A2
                case 43: return producedCars[4];		
		case 44: return producedCars[5];
		//A3
		case 45: return producedCars[6];
		case 46: return producedCars[7];
		//A4
		case 47: return producedCars[8]; 
		case 48: return producedCars[9];
		//A5
		case 49: return producedCars[10];
		case 50: return producedCars[11];
		case 51: return producedCars[12];
		case 52: return producedCars[13];
                //A6
                case 53: return producedCars[14];
		case 54: return producedCars[15];
		case 55: return producedCars[16];
                //A7
		case 56: return producedCars[17];
                case 57: return producedCars[18];
                case 58: return producedCars[19];
                //A8
                case 59: return producedCars[20];
                //A9    
                case 60: return producedCars[21];
                //A10
                case 61: return producedCars[22];
                case 62: return producedCars[23];
                case 63: return producedCars[24];
                //A11
                case 64: return producedCars[25];
		default: return 0;
		}
	}

	public int getProducedCars() {
		return producedAgents;
	}

	public int getDeletedCars(int sinkID) {
		return erasedCars[sinkID-1];
	}

}
