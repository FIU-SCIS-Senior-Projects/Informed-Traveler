package organization;

import java.awt.Point;
import java.io.Serializable;

import entities.Lane;




public class Position implements Serializable {

//****************************
//	*constants & attributes*
//****************************
		final double carLength;
//****************************
		public Lane line;
		public double front;
		public double back;
		/**
		 * This point represents the middle of the cars front on the screen.
		 */
		public Point Coords;
		
		
		
//****************************
//		*constructor*
//****************************		
		public Position(Lane line, double length){
			this.line = line;
			this.carLength=length;
			this.front=line.length-length;
			this.back=front+length;
		}
		
		
//****************************
//		   *methods*
//****************************	
		/**
		 * Use this Version if the car didn't swap lines
		 * @param d
		 */
		public void update(double d){
			this.front=front-d;
			this.back=front+carLength;
		}
		
		/**
		 * Use this Version only if Position on the line hasn't changed.
		 * @param line
		 */
		public void update(Lane line){
			this.line = line;
		}
		
		public void update(Lane line, double d){
			this.line=line;
			if(d<0) System.out.println("Position: d<0: d=" +d);
			this.front=line.length-d;
			this.back = front+carLength;
		}
		
		public Point getCoords(){
			return Coords;
		}
		public void setCoords(int x, int y){
			this.Coords=new Point(x,y);
		}
		
}
