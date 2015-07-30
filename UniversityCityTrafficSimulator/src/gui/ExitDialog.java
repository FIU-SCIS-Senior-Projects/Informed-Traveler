package gui;

	import java.awt.GridLayout;
	import java.awt.Point;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.text.DecimalFormat;

	import javax.swing.*;

	import simulation.Simulation;


	public class ExitDialog extends JDialog{
		
		private Simulation S;
		
		public ExitDialog(final JFrame MainFrame){
			
			//Dialog properties
			super(MainFrame, "New simulation", true);
			setLocation(new Point(MainFrame.getLocationOnScreen().x+(MainFrame.getSize().width-getSize().width)/2, MainFrame.getLocationOnScreen().y+(MainFrame.getSize().height-getSize().height)/2));
			setResizable(false);
			
			setLayout(new GridLayout(2,1,0,20));
			
			//Textfield for seed:
			JTextField entry = new JFormattedTextField(new DecimalFormat("##################"));
			entry.setText("42");
			ActionListener actionListener = new ActionListener() {
				  @Override
				  public void actionPerformed( ActionEvent e ) {
					  System.out.println("seed = "+ ((JFormattedTextField)e.getSource()).getText() );
					  boolean f = true;
					  long seed =0;
					  try{
						  seed = Long.parseLong( (((JFormattedTextField) e.getSource()).getText()) );
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

//	
//	
//	//Buttons
//	JButton y = new JButton("Ja");
//	JButton n = new JButton("Nein");
//	//Label
//	JLabel l = new JLabel("Wollen sie die Simulation sofort beenden, ohne die Statistiken anzusehen?");
//	
//	public ExitDialog(JFrame MainFrame){
//		
//		//Dialog options
//		super(MainFrame, "Beenden", true);
//		setLocation(new Point(MainFrame.getLocationOnScreen().x+(MainFrame.getSize().width-getSize().width)/2, MainFrame.getLocationOnScreen().y+(MainFrame.getSize().height-getSize().height)/2));
//		setResizable(false);
//		setLayout(new GridLayout(2,1,0,50));
//		
//		//Add buttons
//		JPanel panel_button = new JPanel();
//		panel_button.setLayout(new GridLayout(1,2,50,0));
//		panel_button.add(y);
//		panel_button.add(n);
//		
//		//Pack dialog
//		add(l);
//		add(panel_button);
//		
//		//Listener		
//		ActionListener alN = new ActionListener(){
//			@Override
//			public void actionPerformed(ActionEvent e) {dispose();};
//			
//		};
//		
//		y.addActionListener(this);
//		n.addActionListener(alN);
//		
//		
//		//Show
//		pack();
//		setVisible(true);
//	
//	}
//	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		
//		l.setText("Wirklich? Die haben mich viel Arbeit gekostet!");
//		l.setHorizontalAlignment(JLabel.CENTER);
//		ActionListener alYfinally = new ActionListener(){
//			@Override
//			public void actionPerformed(ActionEvent arg0) {System.exit(0);}
//		};
//		y.removeActionListener(this);
//		y.addActionListener(alYfinally);
//	
//	}
//		
//	
//
//}
