package tests;
import java.awt.Graphics;
import javax.swing. *;
import java.awt.*;

public class paintXORufo extends JFrame {
	int x[]={0,20,50,70,50,20,0};
	int y[]={50,35,35,50,60,60,50};
	Polygon poly = new Polygon(x,y,7);
	
	void XORTrick() {
		Graphics g=getGraphics();
		Polygon oldPoly=poly;
		poly=new Polygon(poly.xpoints,poly.ypoints,7);
		movePoly(1); // Polygon einen Pixel nach rechts schieben
		g.setColor(Color.green);
		g.setXORMode(Color.black);
		g.fillPolygon(oldPoly); // Polygon an alter Position löschen
		g.fillPolygon(poly); // Polygon an neuer Position zeichnen
	}

	void movePoly(int dx) {
	int lauf;
	if (poly.xpoints[0]>800) // rechter Rand erreicht?
		poly=new Polygon(x,y,7); // ja, links wieder starten
		for (lauf=0;lauf<poly.npoints;lauf++) // Verschiebung nach rechts
		poly.xpoints[lauf]+=dx;
	}
	
	public static void main( String args[] ) {
		paintXORufo f = new paintXORufo();
		f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		f.setSize ( 800, 80 );
		f.setVisible( true );
		f.movePoly(-100); // im unsichtbare Bereich beginnen andernfalls
		// darf beim ersten Aufruf Ufo nicht gelöscht werden
		while (true) {
			f.XORTrick(); // Zeichnen
			try { Thread.sleep(10); } // 10ms warten
			catch (InterruptedException e) {}
		}
	}
}
