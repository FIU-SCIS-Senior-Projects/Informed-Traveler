package tests;
import java.awt.*;
import javax.swing.*;
public class ClipDemo extends JPanel
{
  @Override
  protected void paintComponent( Graphics g )
  {
    super.paintComponent( g );
      Graphics gcopy = g.create();
      // Clipping erstmalig setzen, auch mit clipRect() möglich
      g.setClip( 100, 100, 100, 200 );            // setClip()!!
      g.setColor( Color.ORANGE );
    g.fillRect( 0, 0, getWidth(), getHeight() );
    g.setColor( Color.BLACK );
    g.drawOval( 150, 100, 100, 100 );
    // Zweiter Clipping-Bereich
      g.clipRect( 0, 200, 150, 50 );              // clipRect()!
      g.setColor( Color.BLUE );
    g.fillRect( 0, 0, 5000, 5000 );
    // Arbeite mit der ursprünglichen Größe
      gcopy.  setColor( Color.GREEN );
      gcopy.  fillRect( 50, 50, 20, 50 );
      gcopy.dispose();
    }
  public static void main( String[] args )
  {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    f.setSize( 400, 400 );
    f.add( new ClipDemo() );
    f.setVisible( true );
  }
}

