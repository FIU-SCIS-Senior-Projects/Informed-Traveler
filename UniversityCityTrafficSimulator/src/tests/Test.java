package tests;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

import javax.swing.*;

import organization.Position;

import simulation.Simulation;

import entities.*;
import gui.ComponentTitledBorder;
import gui.GridBagFunctions;
import organization.EventQueue;



public class Test {

	static LinkedList<Integer> ints;
	
	private static double s_20 = 4;
	private static double s_50 = 8;
	private static double A = -(s_20)/49.0 + 5.0*s_50/588.0 + 1.0/84.0;
	private static double B = 16.0*s_20/49.0 - 31.0*s_50/588.0 - 23.0/84.0;
	
		 public static void main(String[] args){ 
			 double obstacleSpeed=0; 
			System.out.println( 0.5 + obstacleSpeed* B + obstacleSpeed*obstacleSpeed* A);
		
			 componentTitleTest();
			 /*
			  JFrame f = new JFrame();
			  
			 GridBagLayout gbl = new GridBagLayout();
			 
			 f.setLayout(gbl);
			 
			 JButton b = new JButton("testbutton");
			 JButton b2= new JButton("button2");
			 
			 GridBagFunctions.addComponent(f, gbl, b, 0, 0, 1, 1, 1, 1, GridBagConstraints.WEST, new Insets(10,10,10,10));
			 GridBagFunctions.addComponent(f, gbl, b2, 1, 0, 1, 1, 0, 1, GridBagConstraints.EAST);
			 
			 f.setSize(new Dimension(250,100));
			 f.setVisible(true);
			 */
		    } 
		    
		 private static void componentTitleTest(){
			 try{ 
		            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); 
		        } catch(Exception e){ 
		            e.printStackTrace(); 
		        } 
		        final JPanel proxyPanel = new JPanel(); 
		        proxyPanel.add(new JLabel("Proxy Host: ")); 
		        proxyPanel.add(new JTextField("proxy.xyz.com")); 
		        proxyPanel.add(new JLabel("  Proxy Port")); 
		        proxyPanel.add(new JTextField("8080")); 
		        final JCheckBox checkBox = new JCheckBox("Use Proxy", true); 
		        checkBox.setFocusPainted(true); 
		        JLabel test = new JLabel("Test");
		        test.setOpaque(true);
		        ComponentTitledBorder componentBorder =    new ComponentTitledBorder(checkBox, proxyPanel 
		                , BorderFactory.createEtchedBorder()); 
		        checkBox.addActionListener(new ActionListener(){ 
		            public void actionPerformed(ActionEvent e){ 
		                boolean enable = checkBox.isSelected(); 
		                Component comp[] = proxyPanel.getComponents(); 
		                for(int i = 0; i<comp.length; i++){ 
		                    comp[i].setEnabled(enable); 
		                } 
		            } 
		        }); 
		        proxyPanel.setBorder(componentBorder); 
		        JFrame frame = new JFrame("ComponentTitledBorder - santhosh@in.fiorano.com"); 
		        Container contents = frame.getContentPane(); 
		        contents.setLayout(new FlowLayout()); 
		        contents.add(proxyPanel); 
		        frame.pack(); 
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		        frame.setVisible(true);
		 }
		
		

	
	/* 
		Simulation S = new Simulation(10);
		Junction p = new Junction(null);
		Line l = new Line(50,p);
		
		for(int i=1;i<5;i++){
			Car c = new Car(i, S,0,l,-2);
			c.pos.update(10*i);
			l.addCar(c);
		}
		
		Car c = new Car(5, S,0,l,-2);
		c.pos.update(0);
		l.addCar(c);
	 */
	
	/*
	PriorityQueue<?extends Event> Q = new PriorityQueue<Event>();
	
	Testevent t1 = new Testevent(144.4);
	Testevent t2 = new Testevent(10.40);
	
	System.out.println(t1.compareTo(t2));
	
	Q.add(t1); Q.add(t2);
	*/
}

