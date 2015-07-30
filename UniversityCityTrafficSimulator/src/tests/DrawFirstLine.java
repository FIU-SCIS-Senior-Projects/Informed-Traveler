package tests;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;



class DrawFirstLine extends JPanel
{
  protected void paintComponent( Graphics g )
  {
    super.paintComponent( g );
 
    g.drawLine( 30, 10, 100, 100 );
  }
 
public static void main( String args[] )
  {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    f.setSize ( 100, 100 );
    f.add( new DrawFirstLine() );
    f.setVisible( true );
  }


}