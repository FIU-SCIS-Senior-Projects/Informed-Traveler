package tests;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import javax.swing.*;


public class ProtoSimFrame {
	
	
	static JFrame f  = new JFrame("Barbarossaplatz");
	static JPanel panel = new JPanel(new GridLayout(1,5));
	static JButton button1 = new JButton("hallo", new ImageIcon("D:\\Ingo\\Documents\\Uni\\MoSiSeminar\\Icons\\play.png"));
	static JButton button2 = new JButton("ende", new ImageIcon("D:\\Ingo\\Documents\\Uni\\MoSiSeminar\\Icons\\stop.png"));
	
	static ActionListener a1 = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			button1.setText("test");
		}
	};
	static ActionListener a2 = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	};
	
	public static void main(String[]args){
		
		Toolkit.getDefaultToolkit().setDynamicLayout(true);
	
	//	f.setOpacity( 0.5F );
	//	f.setShape( new Ellipse2D.Float(0.0F, 0.0F, 100.0F, 100.0F) );
		f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		f.setLocation( 0, 0 );
		f.setSize(Toolkit.getDefaultToolkit().getScreenSize().width /2, Toolkit.getDefaultToolkit().getScreenSize().height /2);
		f.setResizable(true);
		
		
		

	       panel.add(button1);
	       panel.add(button2);

	       f.add(panel);

	       f.pack();
		
		
		
		button1.addActionListener(a1);
		
		
		f.setVisible( true );
	
	}
	
	
	
}
