package gui;

import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.*;

import simulation.Simulation;

public class StartDialog extends JDialog{
	
	private Simulation S;
	
	
	public StartDialog(final JFrame MainFrame){
		
		//Dialog properties
		super(MainFrame, "New simulation", true);
		setLocation(new Point(MainFrame.getLocationOnScreen().x+(MainFrame.getSize().width-getSize().width)/2, MainFrame.getLocationOnScreen().y+(MainFrame.getSize().height-getSize().height)/2));
		setResizable(false);
		
		setLayout(new GridLayout(2,1,0,20));
		
		//Textfield for seed:
		JTextField entry = new JFormattedTextField(new DecimalFormat("##################"));
		entry.setText("");
		ActionListener actionListener = new ActionListener() {
			  @Override
			  public void actionPerformed( ActionEvent e ) {
				  System.out.println("seed = "+ ((JFormattedTextField)e.getSource()).getText() );
				  boolean f = true;
				  long seed =0;
				  try{
					  seed = Long.parseLong( (((JFormattedTextField) e.getSource()).getText()) );
					  if(seed==42) {
						  MainFrame.setTitle("DON'T PANIC");
						  JOptionPane.showMessageDialog(MainFrame, "Right!");
					  }
					  }catch(NumberFormatException exc){System.out.println("Invalid entry"); f=false;}
				
				if(f){
					S = new Simulation(seed);
					dispose();
				}
			  }
		};
		entry.addActionListener(actionListener);
		
		//pack Dialog
		add(new JLabel("Please enter a random number of type Long."));
		add(entry);
		
		pack();
		setVisible(true);

	}
	
	public Simulation getSimulation(){
		return S;
	}
	
}
