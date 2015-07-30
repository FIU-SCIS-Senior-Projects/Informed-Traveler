package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import organization.Autosaves;


import simulation.Simulation;
import statistics.Statistics;

public class PropertiesPanel extends JPanel {
	
	final ClassLoader loader = MainFrame.class.getClassLoader();

	DecimalFormat f = new DecimalFormat("#0.00");
	
	private MainFrame MainFrame;
	private Statistics Stats;
	private GridBagLayout gbl = new GridBagLayout();
	
	//speedPanel
	JPanel speedPanel = new JPanel();
	
	private ImageIcon speedIcon = new ImageIcon("icons/geschwindigkeit_s.gif");
	private JLabel speedPanelHeader = new JLabel("Speed", speedIcon,JLabel.LEFT);
	
	private JLabel quickening = new JLabel("Simulation speed:");
	private JLabel quickeningValue = new JLabel();
	
	private JLabel discretization = new JLabel("Discr. steps [ms] :");
	private JLabel discretizationValue = new JLabel();
	private JSlider discretizationSlider = new JSlider(8,200,24);
	
	private JLabel reactionTime = new JLabel("Reaction time [ms] :");
	private JLabel reactionTimeValue = new JLabel();
	private JSlider reactionTimeSlider = new JSlider(100,2000,500);
	
	//valuePanel
	JPanel valuePanel = new JPanel();
	
	private ImageIcon valueIcon = new ImageIcon("icons/zahnrad_s.png");
	private JLabel valuePanelHeader = new JLabel("Simulation values", valueIcon, JLabel.LEFT);
	
	private JLabel maxVelocity = new JLabel("Max. speed [m/s] :");
	private JLabel maxVelocityValue = new JLabel();
	private JSlider maxVelocitySlider = new JSlider(8, 20, 15);
	
	private JLabel lookahead = new JLabel("Lookahead [m] :");
	private JLabel lookaheadValue = new JLabel();
	private JSlider lookaheadSlider = new JSlider(10,110,70);
	
	private JLabel laneSwapSlowdown = new JLabel("Slow down to swap lane [m/s] :");
	private JLabel laneSwapSlowdownValue = new JLabel();
	private JSlider laneSwapSlowdownSlider = new JSlider(0,15,5);
	
	
	public PropertiesPanel(MainFrame MF){
		this.MainFrame=MF;
//		this.Stats=MainFrame.S.Statistics;
		setLayout(gbl);
		this.setPreferredSize(new Dimension(180,400));
		this.setMinimumSize(new Dimension(180,400));
		this.setMaximumSize(new Dimension(180,2000));
		
		
		this.setBorder(new TitledBorder("Settings"));
		((TitledBorder)this.getBorder()).setBorder(new LineBorder(this.getBackground()));
		
		//speedPanel
		speedPanelHeader.setOpaque(true);
		ComponentTitledBorder speedPanelBorder = new ComponentTitledBorder(speedPanelHeader, speedPanel,new EtchedBorder());
		speedPanel.setBorder(speedPanelBorder);
		speedPanel.setLayout(new GridBagLayout());
		
		reactionTimeSlider.setPaintTicks(true);
		reactionTimeSlider.setMinorTickSpacing(100);
		reactionTimeSlider.setMajorTickSpacing(500);
		reactionTimeSlider.setPaintTrack(true);
		reactionTimeSlider.setPaintLabels(true);
		reactionTimeSlider.setToolTipText("Time intervals [ms], at which the agents update their speed. (Relativ)");
		
		discretizationSlider.setPaintTicks(true);
		discretizationSlider.setMinorTickSpacing(10);
		discretizationSlider.setMajorTickSpacing(100);
		discretizationSlider.setPaintTrack(true);
		discretizationSlider.setPaintLabels(true);
		discretizationSlider.setToolTipText("Time intervals [ms], at which the agents update their position. (Absolut)");
		
		discretizationSlider.setEnabled(!MF.autoAdaptDiscretization);
		discretization.setEnabled(!MF.autoAdaptDiscretization);
		discretizationValue.setEnabled(!MF.autoAdaptDiscretization);
		//																										x	y	w	h	wx	wy		anchor
		GridBagFunctions.addComponent(speedPanel, (GridBagLayout)speedPanel.getLayout(), quickening,			0,	0,	1,	1,	1,	0,		GridBagConstraints.CENTER, new Insets(0, 2, 0, 5));
		GridBagFunctions.addComponent(speedPanel, (GridBagLayout)speedPanel.getLayout(), quickeningValue,		1,	0,	1,	1,	0,	0,		GridBagConstraints.EAST		, new Insets(0,2,10,0));
		
		GridBagFunctions.addComponent(speedPanel, (GridBagLayout)speedPanel.getLayout(), reactionTime,			0,	1,	1,	1,	1,	0,		GridBagConstraints.CENTER, new Insets(0, 2, 0, 5));
		GridBagFunctions.addComponent(speedPanel, (GridBagLayout)speedPanel.getLayout(), reactionTimeValue,		1,	1,	1,	1,	0,	0,		GridBagConstraints.EAST		, new Insets(0,2,0,0));
		GridBagFunctions.addComponent(speedPanel, (GridBagLayout)speedPanel.getLayout(), reactionTimeSlider,	0,	2,	2,	1,	1,	0,		GridBagConstraints.EAST		, new Insets(0,2,0,0));
		
		GridBagFunctions.addComponent(speedPanel, (GridBagLayout)speedPanel.getLayout(), discretization,		0,	3,	1,	1,	1,	0,		GridBagConstraints.CENTER, new Insets(0, 2, 0, 5));
		GridBagFunctions.addComponent(speedPanel, (GridBagLayout)speedPanel.getLayout(), discretizationValue,	1,	3,	1,	1,	0,	0,		GridBagConstraints.EAST		, new Insets(0,2,0,0));
		GridBagFunctions.addComponent(speedPanel, (GridBagLayout)speedPanel.getLayout(), discretizationSlider, 	0, 	4,	2,	1, 	1,	0, 		GridBagConstraints.EAST);
		
		
		
		//valuePanel;
		valuePanelHeader.setOpaque(true);
		ComponentTitledBorder valuePanelBorder = new ComponentTitledBorder(valuePanelHeader, valuePanel, new EtchedBorder());
		valuePanel.setBorder(valuePanelBorder);
		valuePanel.setLayout(new GridBagLayout());
		
		maxVelocitySlider.setPaintTicks(true);
		maxVelocitySlider.setMinorTickSpacing(1);
		maxVelocitySlider.setMajorTickSpacing(4);
		maxVelocitySlider.setPaintTrack(true);
		maxVelocitySlider.setPaintLabels(true);
		maxVelocitySlider.setToolTipText("Set max. speed");
		
		lookaheadSlider.setPaintTicks(true);
		lookaheadSlider.setMinorTickSpacing(5);
		lookaheadSlider.setMajorTickSpacing(20);
		lookaheadSlider.setPaintTrack(true);
		lookaheadSlider.setPaintLabels(true);
		lookaheadSlider.setToolTipText("Set Lookahead");
		
		laneSwapSlowdownSlider.setPaintTicks(true);
		laneSwapSlowdownSlider.setMinorTickSpacing(1);
		laneSwapSlowdownSlider.setMajorTickSpacing(4);
		laneSwapSlowdownSlider.setPaintTrack(true);
		laneSwapSlowdownSlider.setPaintLabels(true);
		laneSwapSlowdownSlider.setToolTipText("Set speed");
		
		//																											x	y	w	h	wx	wy		anchor
		GridBagFunctions.addComponent(valuePanel, (GridBagLayout)valuePanel.getLayout()	, maxVelocity, 				0, 	0,	1,	1, 	1,	 0, 	GridBagConstraints.NORTHWEST);
		GridBagFunctions.addComponent(valuePanel, (GridBagLayout)valuePanel.getLayout()	, maxVelocityValue, 		1, 	0,	1,	1, 	0,	 0, 	GridBagConstraints.EAST);
		GridBagFunctions.addComponent(valuePanel, (GridBagLayout)valuePanel.getLayout()	, maxVelocitySlider, 		0, 	1,	2,	1, 	1,	 0, 	GridBagConstraints.EAST);
		
		GridBagFunctions.addComponent(valuePanel, (GridBagLayout)valuePanel.getLayout()	, lookahead, 				0, 	2,	1,	1, 	1,	 0, 	GridBagConstraints.NORTHWEST);
		GridBagFunctions.addComponent(valuePanel, (GridBagLayout)valuePanel.getLayout()	, lookaheadValue, 			1, 	2,	1,	1, 	0,	 0, 	GridBagConstraints.EAST);
		GridBagFunctions.addComponent(valuePanel, (GridBagLayout)valuePanel.getLayout()	, lookaheadSlider, 			0, 	3,	2,	1, 	1,	 0, 	GridBagConstraints.EAST);
		
		GridBagFunctions.addComponent(valuePanel, (GridBagLayout)valuePanel.getLayout()	, laneSwapSlowdown, 		0, 	4,	1,	1, 	1,	 0, 	GridBagConstraints.NORTHWEST);
		GridBagFunctions.addComponent(valuePanel, (GridBagLayout)valuePanel.getLayout()	, laneSwapSlowdownValue, 	1, 	4,	1,	1, 	0,	 0, 	GridBagConstraints.EAST);
		GridBagFunctions.addComponent(valuePanel, (GridBagLayout)valuePanel.getLayout()	, laneSwapSlowdownSlider, 	0, 	5,	2,	1, 	1,	 0, 	GridBagConstraints.EAST);
		
		
		
		//Complete adjustment-Panel
		//															x	y	w	h	wx		wy		anchor
		GridBagFunctions.addComponent(this, gbl, speedPanel,		0,	0,	1,	1,	1,		0,		GridBagConstraints.NORTHWEST);
		GridBagFunctions.addComponent(this, gbl, valuePanel,		0,	1,	1,	1,	1,		0,		GridBagConstraints.NORTHWEST);
		
		
		//Listener
		reactionTimeSlider.addChangeListener( new ChangeListener() {
			 @Override public void stateChanged( ChangeEvent e ) {
				 MainFrame.S.reactionTime = ((JSlider)e.getSource()).getValue();
			}
		 } );
		discretizationSlider.addChangeListener( new ChangeListener() {
			 @Override public void stateChanged( ChangeEvent e ) {
				 if(discretizationSlider.isEnabled())
				 MainFrame.S.setDiscretization(((JSlider)e.getSource()).getValue());
			}
		 } );
		
		 maxVelocitySlider.addChangeListener( new ChangeListener() {
			 @Override public void stateChanged( ChangeEvent e ) {
				 MainFrame.S.maxVelocity = ((JSlider)e.getSource()).getValue();
			}
		 } );
		 lookaheadSlider.addChangeListener( new ChangeListener() {
			 @Override public void stateChanged( ChangeEvent e ) {
				 MainFrame.S.setMinLookahead(((JSlider)e.getSource()).getValue());
			}
		 } );
		 laneSwapSlowdownSlider.addChangeListener( new ChangeListener() {
			 @Override public void stateChanged( ChangeEvent e ) {
				 MainFrame.S.setLaneSwapSlowdown(((JSlider)e.getSource()).getValue());
			}
		 } );
	}
	
	
	
	@Override
	protected void paintComponent(Graphics g){
		
		super.paintComponent(g);
		if(MainFrame.S!=null){
			//speedPanel
			quickeningValue.setText(f.format(MainFrame.S.getQuickening()) );
			discretizationValue.setText(Long.toString(MainFrame.S.getDiscretization()));
			if(!discretizationValue.isEnabled()) discretizationSlider.setValue((int)MainFrame.S.getDiscretization());
			reactionTimeValue.setText(Long.toString(MainFrame.S.reactionTime));
			//valuePanel
			maxVelocityValue.setText(Integer.toString(MainFrame.S.maxVelocity));
			lookaheadValue.setText(Integer.toString(MainFrame.S.getMinLookahead()));
			laneSwapSlowdownValue.setText(Integer.toString(MainFrame.S.getLaneSwapSlowdown()));
			laneSwapSlowdownSlider.setMaximum(maxVelocitySlider.getValue());
		}
	}
	
}
