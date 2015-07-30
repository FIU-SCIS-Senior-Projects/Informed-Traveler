
package tests;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class AwtTests {



	public static void main(String[] args){
		OverlayTest();
		
	}
	
	
	

	public void beep(){
		Toolkit.getDefaultToolkit().beep();
		System.exit( 0 );
	}
	
	public void screenDimension(){
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println( d );
	}
	
	public static void helloJFrame(){
		 JFrame f =   new JFrame( "Das Fenster zur Welt" );
		 f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		// f.setSize  ( 300, 200 );
		 f.pack();
		 //f.setUndecorated(false);
	     
		 f.setVisible  ( true );
	     
	     f.setResizable(false);
	    
	    
	}
	
	public void JFramePosition(){
		 JFrame f =   new JFrame( "Das Fenster zur Welt" );
		 f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		 f.setSize  ( 300, 200 );
	     f.setVisible  ( true );
	     
		   try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {e.printStackTrace();
			}
			
			Dimension d = Toolkit.getDefaultToolkit().  getScreenSize()  ;
			f.  setLocation  ( (d.width - f.getSize().width ) / 2,
			               (d.height - f.getSize().height) / 2 );
			
		
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {e.printStackTrace();
		}
		
		f.  setLocation  (d.width-f.getSize().width ,0 );
		
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {e.printStackTrace();
		}
	}
	
	public static void OverlayTest(){
		JFrame F = new JFrame();
		JPanel p = new JPanel();
		JPanel drawPanel = new JPanel();
		JScrollPane scrollPanel = new JScrollPane(drawPanel);
		
		OverlayLayout ol = new OverlayLayout(p);
		p.setLayout(ol);
		JButton button = new JButton("TestButton");
	
		button.setBackground(Color.yellow);
		p.setBackground(Color.cyan);
		drawPanel.setBackground(Color.pink);
	
		button.setAlignmentX(0.8F);
		button.setAlignmentY(1F);
		
		p.add(button);
		p.add(scrollPanel);
		F.add(p);
		
		F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		F.setSize(new Dimension(200,200));
		
		F.setVisible(true);
	}
	
	public static void ExitPopup(){
		final JFrame Popup = new JFrame("Beenden");
		
		Popup.setLayout(new GridLayout(10,10,2,1));
		
		Popup.add(new JLabel("Wollen sie die Simulation sofort beenden?"));
		
		JPanel panel_button = new JPanel();
		panel_button.setLayout(new GridLayout(5,10,1,2));
		JButton y = new JButton("Ja");
		JButton n = new JButton("Nein");
		panel_button.add(y);
		panel_button.add(n);
		
		Popup.add(panel_button);
		
		ActionListener alY = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {System.exit(0);}
		};
		
		ActionListener alN = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {Popup.dispose();};
			
		};
		
		y.addActionListener(alY);
		n.addActionListener(alN);
		
		Popup.setUndecorated(true);
		Popup.setResizable(false);
		Popup.pack();
		
		Popup.setVisible(true);
	}

}