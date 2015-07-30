package tests;	
	import java.awt.Font;
	import java.awt.Graphics;
	import java.awt.Graphics2D;
	import java.awt.GraphicsEnvironment;

	import javax.swing.JFrame;

	public class DrawStringDemo extends JFrame {

	  String message = "David says, \"\u231B\u05DC\u05D5\u05DD \u05E2\u05D5\u05DC\u05DD\"";

	  public DrawStringDemo() {
	    super("DrawStringDemo");
	  }

	  public void paint(Graphics g) {
	    Graphics2D graphics2D = (Graphics2D) g;
	    GraphicsEnvironment.getLocalGraphicsEnvironment();
	    Font font = new Font("LucidaSans", Font.PLAIN, 40);
	    graphics2D.setFont(font);
	    graphics2D.drawString(message, 50, 75);
	  }

	  public static void main(String[] args) {
	    JFrame frame = new DrawStringDemo();
	    frame.setSize(800,300);
	    frame.setVisible(true);
	  }
	}


