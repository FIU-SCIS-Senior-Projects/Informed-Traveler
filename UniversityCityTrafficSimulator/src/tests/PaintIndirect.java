package tests;
import java.awt.*;
import javax.swing.JOptionPane;
class DrawingWindow extends Window
{
  String title = "";
  DrawingWindow( Frame f )
  {
    super( f );
    setSize( Toolkit.getDefaultToolkit().getScreenSize() );
    setVisible( true );
  }
  @Override
  public void paint( Graphics g )
  {
    g.drawString( title, 100, 400 );
  }
}
public class PaintIndirect
{
  public static void main( String[] args ) throws Exception
  {
    DrawingWindow w = new DrawingWindow( new Frame() );
    w.title = "Bei den US-Militäraktionen in Afghanistan sind über 800 " +
      "Zivilisten durch militärischen Fehlgriffe umgekommen.";
    w.repaint();
    JOptionPane.showMessageDialog( w, "Die Quelle?" );
    w.title = "New York Times und die nichtstaatliche Organisation Global Exchange.";
    w.repaint();
    w.title = JOptionPane.showInputDialog( w, "Antwort" );
    w.repaint();
    JOptionPane.showMessageDialog( w, "Nun ist aber Schluss!" );
    System.exit( 0 );
  }
}