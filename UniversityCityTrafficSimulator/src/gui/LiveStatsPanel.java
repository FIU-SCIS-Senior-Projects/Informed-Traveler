package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;


import simulation.Main;
import statistics.Statistics;



public class LiveStatsPanel extends JPanel{

	final ClassLoader loader = MainFrame.class.getClassLoader();
	
	private MainFrame MainFrame;
	private Statistics Stats;
	private GridBagLayout gbl = new GridBagLayout();
	
	//timePanel
	private JPanel timePanel = new JPanel();
	
	private JLabel realTime = new JLabel("Real time:");
	private JLabel realTimeValue = new JLabel();
	private JLabel simTime= new JLabel("Simulation time:");
	private JLabel simTimeValue = new JLabel();
	private JLabel trafficLightPeriod = new JLabel("Traffic light period:");
	private JLabel trafficLightPeriodValue = new JLabel();
	
	//agentPanel
	private JPanel agentPanel = new JPanel();
	private JLabel runningAgents = new JLabel("In system:");
	private JLabel runningAgentsValue = new JLabel();
	private JLabel actAcc = new JLabel("Current \u00D8-Acceleration:");
	private JLabel actAccValue = new JLabel();
	private JLabel actVel = new JLabel("Current \u00D8-Speed:");
	private JLabel actVelValue = new JLabel();
	private JLabel prodCars = new JLabel("Current number of prod. agents:");
	private JLabel prodCarsValue = new JLabel();
	private JLabel averageProdCars = new JLabel("\u00D8 / min:");
	private JLabel averageProdCarsValue = new JLabel();
	
	//springPanel
        
	private JPanel springPanel = new JPanel();
        private JScrollPane springScrollPanel = new JScrollPane(springPanel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        
        //intarr size = total # of spring groups
        //ints in intarr = number of springs in each corresponding group
        private int[] intarr = {4,2,2,2,4,3,3,1,1,3,1};
        private String[] intarrSpringsName = {"A1_1","A1_2","A1_3","A1_4","A2_1","A2_2", "A3_1", "A3_2","A4_1","A4_2","A5_1","A5_2","A5_3","A5_4","A6_1","A6_2","A6_3",
                                               "A7_1","A7_2","A7_3","A8_1","A9_1","A10_1","A10_2","A10_3","A11_1"};
        private JLabel[][] jlarrS; 
    
	//sinkPanel
	private JPanel sinkPanel = new JPanel();
        private JScrollPane sinkScrollPanel = new JScrollPane(sinkPanel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        private int[] intarrV = {3,2,2,3,3,3,3,1,1,3,1};
        private String[] intarrSinksName = {"V1_1","V1_2","V1_3","V2_1","V2_2", "V3_1", "V3_2","V4_1","V4_2","V4_3","V5_1","V5_2","V5_3","V6_1","V6_2","V6_3",
                                               "V7_1","V7_2","V7_3","V8_1","V9_1","V10_1","V10_2","V10_3","V11_1"};
        private JLabel[][] jlarrV; 

        
	private JLabel differenz = new JLabel();
	
	
	//Header
	private ImageIcon clockIcon = new ImageIcon("icons\\clock_s.png");
	private JLabel timePanelHeader = new JLabel("Time", clockIcon, JLabel.LEFT);
	
	private ImageIcon agentIcon = new ImageIcon("icons\\agent_s.png");
	private JLabel agentPanelHeader = new JLabel("Agents", agentIcon, JLabel.LEFT);
	
	private ImageIcon springIcon = new ImageIcon("icons\\spring_s.gif");
	private JLabel springPanelHeader = new JLabel("Spring strength", springIcon, JLabel.LEFT); // Quellstaerke
	
	private ImageIcon sinkIcon = new ImageIcon("icons\\swirl_icon.png");
	private JLabel sinkPanelHeader = new JLabel("Sink workload", sinkIcon, JLabel.LEFT); // Senkenauslastung
	
	//Format
	DecimalFormat f = new DecimalFormat("#0.0");
	
	
	
	
	public LiveStatsPanel(MainFrame MF){
		this.MainFrame= MF;
		this.setLayout(gbl);
		
		this.setPreferredSize(new Dimension(180,450));
		this.setMinimumSize(new Dimension(180,450));
		this.setMaximumSize(new Dimension(180,2000));
		
		this.setBorder(new TitledBorder("Live-Statistic"));
		((TitledBorder)this.getBorder()).setBorder(new LineBorder(this.getBackground()));
		
		//timePanel
		timePanelHeader.setOpaque(true);
		ComponentTitledBorder timeBorder = new ComponentTitledBorder(timePanelHeader, timePanel,new EtchedBorder());
		timePanel.setBorder(timeBorder);
		timePanel.setLayout(new GridBagLayout());
		
		//														x	y	w	h	wx		wy		anchor
		GridBagFunctions.addComponent(timePanel, (GridBagLayout)timePanel.getLayout(), realTime,			0,	0,	1,	1,	1,	0,		GridBagConstraints.NORTHWEST, new Insets(0, 2, 0, 5));
		GridBagFunctions.addComponent(timePanel, (GridBagLayout)timePanel.getLayout(), realTimeValue,			1,	0,	2,	1,	0,	0,		GridBagConstraints.EAST		, new Insets(0,2,0,0));
		GridBagFunctions.addComponent(timePanel, (GridBagLayout)timePanel.getLayout(), simTime,				0,	1,	1,	1,	1,	0,		GridBagConstraints.NORTHWEST, new Insets(0, 2, 0, 5));
		GridBagFunctions.addComponent(timePanel, (GridBagLayout)timePanel.getLayout(), simTimeValue,			1,	1,	2,	1,	0,	0,		GridBagConstraints.EAST		, new Insets(0,2,0,0));
		GridBagFunctions.addComponent(timePanel, (GridBagLayout)timePanel.getLayout(), trafficLightPeriod,		0,	2,	1,	1,	1,	0,		GridBagConstraints.NORTHWEST, new Insets(0, 2, 0, 5));
		GridBagFunctions.addComponent(timePanel, (GridBagLayout)timePanel.getLayout(), trafficLightPeriodValue,         1,	2,	2,	1,	0,	0,		GridBagConstraints.EAST		, new Insets(0,2,0,0));
		
		
		//agentPanel
		agentPanelHeader.setOpaque(true);
		ComponentTitledBorder agentBorder = new ComponentTitledBorder(agentPanelHeader, agentPanel, new EtchedBorder());
		agentPanel.setBorder(agentBorder);
		agentPanel.setLayout(new GridBagLayout());
		
		//													x	y	w	h	wx		wy		anchor
		GridBagFunctions.addComponent(agentPanel, (GridBagLayout)agentPanel.getLayout(), runningAgents,		0,	0,	1,	1,	1,		0,		GridBagConstraints.NORTHWEST, new Insets(0, 2, 0, 5));
		GridBagFunctions.addComponent(agentPanel, (GridBagLayout)agentPanel.getLayout(), runningAgentsValue,	1,	0,	1,	1,	0,		0,		GridBagConstraints.EAST		, new Insets(0,2,0,0));
		
		GridBagFunctions.addComponent(agentPanel, (GridBagLayout)agentPanel.getLayout(), actAcc,		0,	1,	1,	1,	1,		0,		GridBagConstraints.NORTHWEST, new Insets(0, 2, 0, 5));
		GridBagFunctions.addComponent(agentPanel, (GridBagLayout)agentPanel.getLayout(), actAccValue,		1,	1,	1,	1,	0,		0,		GridBagConstraints.EAST		, new Insets(0,2,0,0));
		GridBagFunctions.addComponent(agentPanel, (GridBagLayout)agentPanel.getLayout(), actVel,		0,	2,	1,	1,	1,		0,		GridBagConstraints.NORTHWEST, new Insets(0, 2, 0, 5));
		GridBagFunctions.addComponent(agentPanel, (GridBagLayout)agentPanel.getLayout(), actVelValue,		1,	2,	1,	1,	0,		0,		GridBagConstraints.EAST		, new Insets(0,2,0,0));
		
		GridBagFunctions.addComponent(agentPanel, (GridBagLayout)agentPanel.getLayout(), prodCars,		0,	3,	1,	1,	1,		0,		GridBagConstraints.NORTHWEST, new Insets(0, 2, 0, 5));
		GridBagFunctions.addComponent(agentPanel, (GridBagLayout)agentPanel.getLayout(), prodCarsValue,		1,	3,	1,	1,	0,		0,		GridBagConstraints.EAST		, new Insets(0,2,0,0));
		GridBagFunctions.addComponent(agentPanel, (GridBagLayout)agentPanel.getLayout(), averageProdCars,	0,	4,	1,	1,	1,		0,		GridBagConstraints.NORTHWEST, new Insets(0, 2, 0, 5));
		GridBagFunctions.addComponent(agentPanel, (GridBagLayout)agentPanel.getLayout(), averageProdCarsValue,	1,	4,	1,	1,	0,		0,		GridBagConstraints.EAST		, new Insets(0,2,0,0));
			
		//SpringPanel
                springScrollPanel.setMinimumSize(new Dimension(230,150));
		springPanelHeader.setOpaque(true);
		ComponentTitledBorder springBorder= new ComponentTitledBorder(springPanelHeader, springPanel, new EtchedBorder());
		springPanel.setBorder(springBorder);
		springPanel.setLayout(new GridBagLayout());
		
//                //create JLabel objects for springs
//                int i, j;
//                jlarrS = new JLabel[intarr.length][][];                
//                for( i = 0; i < intarr.length ; i++){
//                    jlarrS[i] = new JLabel[intarr.length][3];
//                    for( j = 0; j < intarr[i]; j++){
//                        jlarrS[i][j][0] = new JLabel("A"+(i+1)+"_"+(j+1)+":"); //labeled jlabel
//                        jlarrS[i][j][1] = new JLabel(); //Value
//                        jlarrS[i][j][2] = new JLabel(); //AverageValue
//                    }
//                }
       
                // Charaf modifications just a comment for Daniel to show him what are my modifications
                // You can delete it after you read it
                //create JLabel objects for springs
                int i;
                jlarrS = new JLabel[intarrSpringsName.length][3];                
                for( i = 0; i < intarrSpringsName.length ; i++){
                        jlarrS[i][0] = new JLabel(intarrSpringsName[i]); //labeled jlabel
                        jlarrS[i][1] = new JLabel(); //Value
                        jlarrS[i][2] = new JLabel(); //AverageValue
                }
                
		//add JLabel objects to GridBagFunctions										x	y	w	h	wx	wy	anchor
                for( i = 0; i < intarrSpringsName.length ; i++){
                        GridBagFunctions.addComponent(springPanel, (GridBagLayout)springPanel.getLayout(), jlarrS[i][0],		0,	i,	1,	1,	0.5,	0,	GridBagConstraints.NORTHWEST, new Insets(0, 2, 0, 5));
                        GridBagFunctions.addComponent(springPanel, (GridBagLayout)springPanel.getLayout(), jlarrS[i][1],		1,	i,	1,	1,	0.5,	0,	GridBagConstraints.NORTHWEST, new Insets(0, 2, 0, 0));
                        GridBagFunctions.addComponent(springPanel, (GridBagLayout)springPanel.getLayout(), jlarrS[i][2],                2,	i,	1,	1,	0,	0,	GridBagConstraints.NORTHWEST, new Insets(0, 2, 0, 0));
                }

                
                //SinkPanel
                sinkScrollPanel.setMinimumSize(new Dimension(230,120));
                sinkPanelHeader.setOpaque(true);
		ComponentTitledBorder sinkBorder = new ComponentTitledBorder(sinkPanelHeader, sinkPanel, new EtchedBorder());
		sinkPanel.setBorder(sinkBorder);
		sinkPanel.setLayout(new GridBagLayout());
                
//                //create JLabel objects for sinks(V)
//                jlarrV = new JLabel[intarrV.length][][];                
//                for( i = 0; i < intarrV.length ; i++){
//                    jlarrV[i] = new JLabel[intarrV.length][3];
//                    for( j = 0; j < intarrV[i]; j++){
//                        jlarrV[i][j][0] = new JLabel("S_V"+(i+1)+"_"+(j+1)); //labeled jlabel
//                        jlarrV[i][j][1] = new JLabel(); //Value
//                        jlarrV[i][j][2] = new JLabel(); //AverageValue
//                    }
//                }
       
                // Charaf modifications just a comment for Daniel to show him what are my modifications
                // You can delete it after you read it
                //create JLabel objects for sinks(V)
                jlarrV = new JLabel[intarrSinksName.length][3];                
                for( i = 0; i < intarrSinksName.length ; i++){
                        jlarrV[i][0] = new JLabel(intarrSinksName[i]); //labeled jlabel
                        jlarrV[i][1] = new JLabel(); //Value
                        jlarrV[i][2] = new JLabel(); //AverageValue
                        //jlarrV[i][3] = new JLabel();
                }
                
		//add JLabel objects to GridBagFunctions									x	y	w	h	wx	wy	anchor
                for( i = 0; i < intarrSinksName.length ; i++){
                    //here the j being used as the y variable does not need to be incremented, whereas in springs yess
                    GridBagFunctions.addComponent(sinkPanel, (GridBagLayout)sinkPanel.getLayout(), jlarrV[i][0],		0,	i,	1,	1,	0.5,	0,	GridBagConstraints.NORTHWEST, new Insets(0, 2, 0, 5));
                    GridBagFunctions.addComponent(sinkPanel, (GridBagLayout)sinkPanel.getLayout(), jlarrV[i][1],                1,	i,	1,	1,	0.5,	0,	GridBagConstraints.NORTHWEST, new Insets(0, 2, 0, 0));
                    GridBagFunctions.addComponent(sinkPanel, (GridBagLayout)sinkPanel.getLayout(), jlarrV[i][2],                2,	i,	1,	1,	0,	0,	GridBagConstraints.NORTHWEST, new Insets(0, 2, 0, 0));
                    //GridBagFunctions.addComponent(sinkPanel, (GridBagLayout)sinkPanel.getLayout(), jlarrV[i][3],              2,	i,	1,	1,	0,	0,	GridBagConstraints.NORTHWEST, new Insets(0, 2, 0, 0));
                }
                
                

		//Complete Stats-Panel
		//                                                          x	y	w	h	wx		wy		anchor
		GridBagFunctions.addComponent(this, gbl, timePanel,         0,	0,	1,	1,	1,		0,		GridBagConstraints.NORTHWEST);
		GridBagFunctions.addComponent(this, gbl, agentPanel,        0,	1,	1,	1,	1,		0,		GridBagConstraints.NORTHWEST);
//		GridBagFunctions.addComponent(this, gbl, springPanel,       0,	2,	1,	1,	1,		0,		GridBagConstraints.NORTHWEST);
                GridBagFunctions.addComponent(this, gbl, springScrollPanel, 0,	2,	1,	1,	1,		0,		GridBagConstraints.NORTHWEST);
//		GridBagFunctions.addComponent(this, gbl, sinkPanel,         0, 	3, 	1, 	1, 	1, 		0,		GridBagConstraints.NORTHWEST);
                GridBagFunctions.addComponent(this, gbl, sinkScrollPanel,   0, 	3, 	1, 	1, 	1, 		0,		GridBagConstraints.NORTHWEST);
//		GridBagFunctions.addComponent(this, gbl, differenz,         0, 	4, 	1, 	1, 	1, 		1,		GridBagConstraints.NORTHWEST);
		
	}
	
	
	
	
	@Override
	protected void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		if(MainFrame.S!=null){
                    //Time
                    if(MainFrame.S.play)
                    realTimeValue.setText((int)MainFrame.S.realTime/60+":"+Math.round(MainFrame.S.realTime)%60 );  
                    simTimeValue.setText((int)MainFrame.S.getSimTime()/60 +":"+f.format(MainFrame.S.getSimTime()%60));
                    trafficLightPeriodValue.setText((int)Math.floor(MainFrame.S.getSimTime()/160)+" - "+(int)Math.floor(MainFrame.S.getSimTime()%160) );
                    //Agents
                    runningAgentsValue.setText(Integer.toString(MainFrame.S.cars.size()));
                    actAccValue.setText(f.format(MainFrame.S.actAcceleration));
                    actVelValue.setText(f.format(MainFrame.S.actVelocity));
                    prodCarsValue.setText(Integer.toString(Stats.getProducedCars()) );
                    averageProdCarsValue.setText(f.format((double)Stats.getProducedCars()*60.0/MainFrame.S.getSimTime()) );
                    
                    //Springs
                    int i ,j, x, y, k;
                    x = 39; // 39 <= x <= 64
                    y = 1;  // rules? y<11
                    for( i = 0; i < intarrSpringsName.length ; i++){
//                        for( j = 0; j < intarr[i]; j++){                           
                            jlarrS[i][1].setText( Integer.toString(Stats.getProducedCars(x)) );
                            jlarrS[i][2].setText(" \u00D8/min: " + f.format( (Stats.getProducedCars(x++))*60.0 / MainFrame.S.getSimTime()));
                            if(x>64)x=39;
//                        }
                    }
                    
                    
//                    //Sinks
//                    for( i = 0; i < intarrV.length ; i++){
//                        for( j = 0; j < intarrV[i]; j++){
//                            jlarrV[i][1].setText( Integer.toString(this.Stats.getDeletedCars(y)) );
//                            jlarrV[i][2].setText(" \u00D8/min: " + f.format( (this.Stats.getDeletedCars(y++))*60.0 / MainFrame.S.getSimTime() ) );
//                            if(y<6)y=1;
//                        }
//                    }

                    //Sinks
                    for( i = 0; i < intarrSinksName.length ; i++){                        
                            jlarrV[i][1].setText( Integer.toString(Stats.getDeletedCars(y)) );
                            jlarrV[i][2].setText(" \u00D8/min: " + f.format( (Stats.getDeletedCars(y++))*60.0 / MainFrame.S.getSimTime() ) );
                            if(y>11)y=1;
                    }
//                  differenz.setText(Integer.toString(Integer.parseInt(springA1Value.getText())+Integer.parseInt(springA2Value.getText())+Integer.parseInt(springA3Value.getText())+Integer.parseInt(springA4Value.getText())+Integer.parseInt(springA5Value.getText())+Integer.parseInt(springA6Value.getText()) - Integer.parseInt(sinkV1Value.getText())- Integer.parseInt(sinkV2Value.getText())- Integer.parseInt(sinkV3Value.getText())- Integer.parseInt(sinkV4Value.getText())- Integer.parseInt(sinkV5Value.getText())- Integer.parseInt(sinkV6Value.getText())- Integer.parseInt(sinkV7Value.getText())- Integer.parseInt(sinkV8Value.getText()) ) + "  erased: "+Stats.erasedAgents );
		}
	}
	
	public void setStatistics(){
		if(MainFrame.S==null) this.Stats = null;
		else this.Stats = MainFrame.S.Statistics;
	}
	
}
