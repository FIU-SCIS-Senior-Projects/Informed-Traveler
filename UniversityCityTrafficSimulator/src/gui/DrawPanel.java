package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.text.DecimalFormat;
import javax.swing.JPanel;
import javax.swing.Scrollable;
import entities.Car;
import entities.Lane;
import entities.LaneEnd;
import entities.Spring;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import simulation.Simulation;

public class DrawPanel extends JPanel implements Scrollable{
	
	private Simulation S;
	private MainFrame MF;
	
	DecimalFormat f = new DecimalFormat("#0.0");
	
	public DrawPanel(Simulation S, MainFrame MF){
		super();
		this.MF=MF;
		this.S=S;
                this.addMouseListener(new MouseListener() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	 int screenX = e.getX();
                         int screenY = e.getY();
                         int carX, carY;
                         System.out.println("cars number: " + getCarsNumberInCurrentSimulation().size());
                         System.out.println("screen(X,Y) = " + screenX + "," + screenY );

                         LinkedList<Car> carsList2 = getCarsNumberInCurrentSimulation();
                         for(Car c: carsList2) {
                             carX = c.pos.getCoords().x;
                             carY = c.pos.getCoords().y;
                                // TODO is the check if the selected point is contained in the bound of one car in the list and to display information about the selected agent/car
                                if((carX==screenX && carY==screenY)||(carX==screenX+1 && carY==screenY+1)||(carX==screenX-1 && carY==screenY-1)) {//{
                                System.out.println("car id: "+ c.id + "; speed = " + f.format(c.getVelocity()) + "; accelaration = " + f.format(c.getAcceleration())
                                            + "; length = " + f.format(c.length) + "; direction = " + c.getDirection()
                                            + "; min. deceleration = " + f.format(c.minDeceleration) + "; distance to obstacles = " + f.format(c.obstacleDist));
//                        if(c.getDirection()==1?(carX<=screenX && carX>=screenX+c.length):(carX>=screenX && carX<=screenX+c.length) ){
                                    JOptionPane.showMessageDialog(MF.MainFrame, "car id: "+ c.id + "; speed = " + f.format(c.getVelocity()) + "; accelaration = " + f.format(c.getAcceleration())
                                            + "; length = " + f.format(c.length) + "; direction = " + c.getDirection()
                                            + "; min. deceleration = " + f.format(c.minDeceleration) + "; distance to obstacles = " + f.format(c.obstacleDist)
                                            , "Agent Information", 0, new ImageIcon ("icons\\symbol_information.png"));
//                                   if(S!=null&&S.play==true) {
//                                                S.interrupted=true;
//                                                JOptionPane.showMessageDialog(MF.MainFrame, "car id: "+ c.id + " x = " + carX + ", y = " + carY, "Pause", 0, new ImageIcon ("icons\\pause_m.png"));
//                                                try {
//                                                        Thread.sleep(500);
//                                                } catch (InterruptedException ee) {ee.printStackTrace();}                                               
//                                            }
                                }

                         }
				    
		    }

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	
	@Override
	 protected void paintComponent( Graphics g )
	  {
	    super.paintComponent( g );
	 
	//    g.drawLine( 10, 10, 110, 10 );
	   
	    if(S!=null){
	    	draw(g);
	    }
	  }
	
	
	private void draw(Graphics g){
	//	System.out.println("DrawPanel:draw aufgerufen");
		double zoom = MF.zoom;
		drawGraph(g,zoom);
		drawTrafficLights(g,zoom);
		drawCars(g,zoom);
		
	}
	
	public void drawGraph(Graphics g, double zoom){
		for(LaneEnd e :S.lineEnds){
			for(Lane l : e.getSuccessorLines()){
				if(!MF.junctionsOn && l.id>128) continue;
				g.drawLine((int)Math.round(e.Coordinates.x * zoom), (int)Math.round(e.Coordinates.y * zoom), (int) Math.round(l.getEndPoint().Coordinates.x *zoom), (int) Math.round(l.getEndPoint().Coordinates.y*zoom) );
				//closed lines
				if(l.isClosed()){
                                    g.setColor(Color.white);
                                    g.fillOval((int) Math.round(l.getEndPoint().Coordinates.x *zoom-7.5 + 10*(e.Coordinates.x -l.getEndPoint().Coordinates.x)/(l.length*3.379)), (int) Math.round(l.getEndPoint().Coordinates.y*zoom-7.5 + 10*(e.Coordinates.y -l.getEndPoint().Coordinates.y)/(l.length*3.379)), 15, 15);
                                    g.setColor(Color.red);
                                    g.drawOval((int) Math.round(l.getEndPoint().Coordinates.x *zoom-7.5 + 10*(e.Coordinates.x -l.getEndPoint().Coordinates.x)/(l.length*3.379)), (int) Math.round(l.getEndPoint().Coordinates.y*zoom-7.5 + 10*(e.Coordinates.y -l.getEndPoint().Coordinates.y)/(l.length*3.379)), 15, 15);
                                    g.setColor(Color.black);
				}
				//	System.out.println(l.name+": Pixel: "+e.Coordinates.distance(l.getEndPoint().Coordinates)+" , entspricht : "+e.Coordinates.distance(l.getEndPoint().Coordinates)*0.296+"metern");
				
			
			}
		}
		for(Spring e :S.springs){
			for(Lane l : e.getSuccessorLines()){
				if(!MF.junctionsOn && l.id>128) continue;
				g.drawLine((int)Math.round(e.Coordinates.x * zoom), (int)Math.round(e.Coordinates.y * zoom), (int) Math.round(l.getEndPoint().Coordinates.x *zoom), (int) Math.round(l.getEndPoint().Coordinates.y*zoom) );
			//closed lines
			if(l.isClosed()){
                            g.setColor(Color.white);
                            g.fillOval((int) Math.round(l.getEndPoint().Coordinates.x *zoom-7.5 + 10*(e.Coordinates.x -l.getEndPoint().Coordinates.x)/(l.length*3.379)), (int) Math.round(l.getEndPoint().Coordinates.y*zoom-7.5 + 10*(e.Coordinates.y -l.getEndPoint().Coordinates.y)/(l.length*3.379)), 15, 15);
                            g.setColor(Color.red);
                            g.drawOval((int) Math.round(l.getEndPoint().Coordinates.x *zoom-7.5 + 10*(e.Coordinates.x -l.getEndPoint().Coordinates.x)/(l.length*3.379)), (int) Math.round(l.getEndPoint().Coordinates.y*zoom-7.5 + 10*(e.Coordinates.y -l.getEndPoint().Coordinates.y)/(l.length*3.379)), 15, 15);
                            g.setColor(Color.black);
			}
		//		System.out.println(l.name+": Pixel: "+e.Coordinates.distance(l.getEndPoint().Coordinates)+" , entspricht : "+e.Coordinates.distance(l.getEndPoint().Coordinates)*0.296+"metern");
				
			
			}
		}
		
	}
	
	
	public void drawTrafficLights(Graphics g, double zoom){
		for(LaneEnd e :S.lineEnds){
			switch(e.trafficLightState()){
			case LaneEnd.LINEEND_GREEN : if(!MF.lineEndsOn) continue; else g.setColor(Color.green); break;
			case LaneEnd.LINEEND_YELLOW : g.setColor(Color.orange); break;
			case LaneEnd.LINEEND_RED : g.setColor(Color.red); break;
			}
			g.fillOval((int)Math.round((e.Coordinates.x -3)* zoom), (int)Math.round((e.Coordinates.y-3) * zoom) , (int) Math.round(6 * zoom) , (int) Math.round( 6 * zoom));
		}
		g.setColor(Color.black);		
	}
	
	
	public void drawCars(Graphics g, double zoom){
		g.setColor(Color.blue);
		
		for(Spring e :S.springs){
			Point x = new Point((int)Math.round(e.Coordinates.x * zoom), (int)Math.round(e.Coordinates.y * zoom));

			for(Lane l : e.getSuccessorLines()){
				Point y = new Point((int) Math.round(l.getEndPoint().Coordinates.x *zoom), (int) Math.round(l.getEndPoint().Coordinates.y*zoom) );
					
				for(Car c:l.getCurrentCars()){
					drawCar(g,zoom,c,l,x,y);
				}
			}
		}
		
		for(LaneEnd e :S.lineEnds){
			Point x = new Point((int)Math.round(e.Coordinates.x * zoom), (int)Math.round(e.Coordinates.y * zoom));
			
			for(Lane l : e.getSuccessorLines()){
				Point y = new Point((int) Math.round(l.getEndPoint().Coordinates.x *zoom), (int) Math.round(l.getEndPoint().Coordinates.y*zoom) );
				
				for(Car c:l.getCurrentCars()){
					drawCar(g, zoom, c,l,x,y);
				}
			}
		}
		
		
		g.setColor(Color.black);
	}
	
	
	
	
	private void drawCar(Graphics g, double zoom, Car c, Lane l, Point x, Point y){
		//Car
		double p = (double) ((double)l.length-c.pos.front)/ (double)l.length ;
		Point frontMiddleCoords = new Point((int)Math.round(x.x+(y.x-x.x)*p),(int)Math.round(x.y+(y.y-x.y)*p));
		
		c.pos.setCoords(frontMiddleCoords.x, frontMiddleCoords.y);
		
		p = (double) ((double)l.length-c.pos.back)/ (double)l.length ;
		Point backMiddleCoords = new Point((int)Math.round(x.x+(y.x-x.x)*p),(int)Math.round(x.y+(y.y-x.y)*p));
		
		int carPixelWidth = (int)Math.round(2*3.378*zoom);

		Point s = new Point(1, -(x.x-y.x)/ ((x.y-y.y)==0?1:x.y-y.y));
		double abs_s = Math.sqrt(s.x*s.x+s.y*s.y);
		Point s_w = new Point( (int)Math.round(s.x/abs_s) , (int)Math.round(s.y/abs_s) );
		s_w.x = s_w.x*carPixelWidth/2;
		s_w.y = s_w.y*carPixelWidth/2;
		
		g.fillPolygon(new int[] {frontMiddleCoords.x+s_w.x , backMiddleCoords.x+s_w.x , backMiddleCoords.x-s_w.x , frontMiddleCoords.x-s_w.x }  ,  new int[] {frontMiddleCoords.y+s_w.y , backMiddleCoords.y+s_w.y , backMiddleCoords.y-s_w.y , frontMiddleCoords.y-s_w.y } , 4);
		
		//Blinker
		if(MF.blinker && c.tryToSwapLane){
			g.setColor(Color.orange);
			
			if( !((c.getDirection() < l.getEndPoint().leadingToDirections[0]) ^ (x.y-y.y>=0) ) ){
				g.fillOval(frontMiddleCoords.x-s_w.x-2, frontMiddleCoords.y-s_w.y-2, 4, 4);
				g.fillOval(backMiddleCoords.x-s_w.x-2, backMiddleCoords.y-s_w.y-2, 4, 4);
			}
			else{
				g.fillOval(frontMiddleCoords.x+s_w.x-2, frontMiddleCoords.y+s_w.y-2, 4, 4);
				g.fillOval(backMiddleCoords.x+s_w.x-2, backMiddleCoords.y+s_w.y-2,4, 4);	
			}
		}
		
		
		//Attributes
		if(this.MF.drawID){
			g.setColor(Color.black);
			g.drawString(Integer.toString(c.id), c.pos.getCoords().x+5, c.pos.getCoords().y+10);
		}
		
		if(this.MF.drawSafetyDistance){
			g.setColor(Color.GREEN);
			g.drawString(f.format(c.safetyDistance), c.pos.getCoords().x+5, c.pos.getCoords().y+10);
		}
		
		if(this.MF.drawDirection){
			g.setColor(Color.cyan);
			g.drawString(Integer.toString(c.getDirection()), c.pos.getCoords().x+5, c.pos.getCoords().y);
		}
			
		if(this.MF.drawVelocity){
			g.setColor(Color.red);
			g.drawString(f.format(c.getVelocity()) , c.pos.getCoords().x-20, c.pos.getCoords().y-5);
		}
		if(this.MF.drawAcceleration){
			g.setColor(Color.yellow);
			g.drawString(f.format(c.getAcceleration()) , c.pos.getCoords().x-20, c.pos.getCoords().y+ (MF.drawVelocity? 5 : -5));
		}
		if(this.MF.drawObstacleDist && c.obstacleDist<9000){
			g.setColor(Color.black);
			if(c.obstacleDist<0) g.setColor(Color.red);
			g.drawString(f.format(c.obstacleDist), c.pos.getCoords().x-20, c.pos.getCoords().y+(MF.drawVelocity&&MF.drawAcceleration ? 15 : MF.drawVelocity||MF.drawAcceleration? 5 : -5) );
			
		}
		
		
		//Pred-/Succ-Graph
		Car pred = c.getPredecessor();
		Car succ=c.getSuccessor();
		try{
		if(MF.predecessorGraphOn&&pred!=null){
			g.setColor(Color.yellow);
			g.drawLine(c.pos.getCoords().x, c.pos.getCoords().y, pred.pos.getCoords().x+5, pred.pos.getCoords().y+5);
		}
		}catch(NullPointerException e){
			e.printStackTrace();
		}
		try{
		if(MF.successorGraphOn && succ!=null && succ.pos.getCoords()!=null){
			g.setColor(Color.orange);
			g.drawLine(c.pos.getCoords().x, c.pos.getCoords().y, succ.pos.getCoords().x+5, succ.pos.getCoords().y+5);
		}
		}catch(NullPointerException e)
		{ 
			e.printStackTrace();
			}
		
		g.setColor(Color.blue);
		
	}
	
	
	
	
	
	@Override
	public Dimension getPreferredScrollableViewportSize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getScrollableBlockIncrement(Rectangle arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getScrollableTracksViewportHeight() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getScrollableTracksViewportWidth() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getScrollableUnitIncrement(Rectangle arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return 0;
	}


	public void setSim(Simulation S) {
		this.S=S;
	}

         private LinkedList<Car> getCarsNumberInCurrentSimulation() {
		
		return this.S.getCars();
	}
}
