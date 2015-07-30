package gui;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class GridBagFunctions {

	public static void addComponent( Container cont, GridBagLayout gbl, Component c, int x, int y, int width, int height, double weightx, double weighty, int anchor ){
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = x; gbc.gridy = y;
		gbc.gridwidth = width; gbc.gridheight = height;
		gbc.weightx = weightx; gbc.weighty = weighty;
		gbc.anchor = anchor;
		
		gbl.setConstraints( c, gbc );
		cont.add( c );
		
	}
	
	
	public static void addComponent( Container cont, GridBagLayout gbl, Component c, int x, int y, int width, int height, double weightx, double weighty, int anchor, Insets insets ){
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = x; gbc.gridy = y;
		gbc.gridwidth = width; gbc.gridheight = height;
		gbc.weightx = weightx; gbc.weighty = weighty;
		gbc.anchor = anchor;
		
		gbl.setConstraints( c, gbc );
		cont.add( c );
		gbc.insets=insets;
	}
}
