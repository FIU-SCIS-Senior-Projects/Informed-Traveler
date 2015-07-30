package gui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.MenuListener;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import entities.Lane;
import events.Event;
import organization.Autosaves;
import barbarossaplatz.Initialization;
import barbarossaplatz.Probabilities;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.logging.Filter;
import javax.imageio.ImageIO;
import javax.swing.filechooser.FileFilter;
import simulation.Simulation;

public class MainFrame implements Runnable {

	
//****************************
//	*constants & attributes*
//****************************
	
	//Aktuelle Simulation
	Simulation S;
	Thread simThread;
	
	
	//Grafische Einstellungen
	boolean predecessorGraphOn = false;
	boolean successorGraphOn=false;
	boolean lineEndsOn =true;
	boolean autoAdaptDiscretization=true;
	boolean drawDirection = false;
        boolean drawAllSpringsID = false;
	boolean drawID = false;
	boolean drawVelocity = false;
	boolean drawAcceleration = false;
	boolean drawObstacleDist = false;
	boolean drawSafetyDistance = false;
	boolean junctionsOn = true;
	
	long blinkerPhase = 0;
	boolean blinker = false;
	
	public double zoom = 1;
	
	//Frame
	JFrame MainFrame = new JFrame("UniversityCity Traffic Simulator v0.1");
	
	
	//Panels
	DrawPanel drawPanel = new DrawPanel(null,this);
	JScrollPane scrollPanel = new JScrollPane(drawPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	
	PropertiesPanel propPanel = new PropertiesPanel(this);
	LiveStatsPanel statsPanel = new LiveStatsPanel(this);
	JScrollPane propScrollPanel = new JScrollPane(propPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	JScrollPane statsScrollPanel = new JScrollPane(statsPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	
	//Layout-Manager
	GridBagLayout framegbl = new GridBagLayout();
	//Time-Rollback
	JSlider timeRollback;
	
	//MenuBar
	JMenuBar menuBar = new JMenuBar();
	
	//ToolBars
	JToolBar toolbar0 = new JToolBar();
	JToolBar toolbar1 = new JToolBar();
	JToolBar toolbar2 = new JToolBar();
        
        //Export the model graph
//        JToolBar toolbarModelGraph = new JToolBar();
	
	
	
	//Menus
	JMenu fileMenu = new JMenu("Menu");
	JMenu propertieMenu = new JMenu ("Settings");
	JMenu viewMenu = new JMenu("View");
	JMenu statsMenu = new JMenu("Statistic");
	
	//--------------- Charaf'code ---------------------
	JMenu languageMenu = new JMenu("Language");
	Locale currentLocale;
        ResourceBundle messages;
        ResourceBundle bundle;

	//--------------- End -----------------------------
	
	JMenu laneCloseMenu = new JMenu("Block lane");
	JMenu laneCloseMenu_1 = new JMenu("Entry points (Ai)"); 		//Quellspuren
	JMenu laneCloseMenu_2 = new JMenu("Exit points (Vi)");			//Senkenspuren
	JMenu laneCloseMenu_3 = new JMenu("Junction lanes (Ki)");		//Kreuzungsspuren
	JMenu laneCloseMenu_4 = new JMenu("Connection lanes (Mi)");		//The connection lane is the lane which connect two spring lanes. //Verbindungsspuren
	
	ActionListener laneCloseListener;	
	
	//MainFrameLoader
	public final ClassLoader loader = MainFrame.class.getClassLoader();
	
	//Buttons	
	JButton	button_fwd = new JButton(new ImageIcon("icons\\fwd_m.png"));
	JButton	button_rwd = new JButton(new ImageIcon("icons\\rwd_m.png"));
	
	//Actions
	Action germanLanguageAction;
	Action spanishLanguageAction;
	
	
	
//****************************
//	*constructor*
//****************************		
	
	public MainFrame(){
		
		//MainFrame properties
		MainFrame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width-10, Toolkit.getDefaultToolkit().getScreenSize().height-50));
		MainFrame.setMinimumSize(new Dimension(750,500));
		MainFrame.setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
			
		MainFrame.setLayout(framegbl);                
		
		
		//Panel properties
		drawPanel.setPreferredSize(new Dimension(2300,2150));
		drawPanel.setBackground(Color.WHITE);
		drawPanel.setAutoscrolls(true);
		
		scrollPanel.setMinimumSize(new Dimension(500,300));
		scrollPanel.setAutoscrolls(true);
		propScrollPanel.setMinimumSize(new Dimension(200,150));
			
		statsScrollPanel.setMinimumSize(new Dimension(230,150));
		
		//---------------------- Charaf's code ----------------------------   
		String language = "en"; 
		String country = "US";
		
	     
	    currentLocale = new Locale(language, country);
	    String baseName = "gui/resources/MessagesBundle";
	    bundle = ResourceBundle.getBundle(baseName, currentLocale);    
		
	   //------------------------ End --------------------------------------	
		
		laneCloseMenu.add(laneCloseMenu_1); 
		laneCloseMenu.add(laneCloseMenu_2); 
		laneCloseMenu.add(laneCloseMenu_3); 
		laneCloseMenu.add(laneCloseMenu_4);				
		
		laneCloseListener = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean selected = false;
				if(((JRadioButton)e.getSource()).isSelected()){
					selected = true;
					((JRadioButton)e.getSource()).setText(((JRadioButton)e.getSource()).getText().substring(0,((JRadioButton)e.getSource()).getText().indexOf(' '))+" open");
					((JRadioButton)e.getSource()).setIcon(new ImageIcon("icons\\oneway_s.gif"));
					
				}
				else{
					((JRadioButton)e.getSource()).setText(((JRadioButton)e.getSource()).getText().substring(0,((JRadioButton)e.getSource()).getText().indexOf(' '))+" block");
					((JRadioButton)e.getSource()).setIcon(null);
				}
				
				
				for(Lane l : S.lines){
					if(l.name.equals(((JRadioButton)e.getSource()).getText().substring(0,((JRadioButton)e.getSource()).getText().indexOf(' ')))){
						if(selected){l.closeLine();}
						else l.openLine();
						break;
					}
				}
			}
			
		};
		
		
		
		
		
		
		final Action newSimulationAction = new AbstractAction(){
                {	putValue(Action.NAME, bundle.getString("new_simulation"));
                //	putValue( Action.DISPLAYED_MNEMONIC_INDEX_KEY, 1 );
                putValue( Action.SMALL_ICON, new ImageIcon ("icons\\car_s.png"));
                putValue( Action.LARGE_ICON_KEY,new ImageIcon ("icons\\car_m.png"));
                }
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    if(JOptionPane.showConfirmDialog(MainFrame, "Do you want to start a new simulation?", "Start a new simulation?", JOptionPane.OK_CANCEL_OPTION)==0){
                        StartDialog start = new StartDialog(MainFrame);
                        S = start.getSimulation();
                        drawPanel.setSim(S);
                        statsPanel.setStatistics();
                        if(S!=null) //System.out.println("Yippie ya yay Schweinebacke");
                            propScrollPanel.setVisible(true);
                            statsScrollPanel.setVisible(true);
                            MainFrame.validate();
                            laneCloseMenuInitialization();
                    }
                }
                private void laneCloseMenuInitialization() {
                    
                    for(Lane l : S.lines){
                        JRadioButton b = new JRadioButton(l.name+" block");
                        char c = l.name.charAt(0);
                        
                        switch(c){
                            case 'A' : if(laneCloseMenu_1.getComponentCount()>0 && l.name.charAt(1)!=((JRadioButton)laneCloseMenu_1.getComponent(laneCloseMenu_1.getComponentCount()-1)).getText().charAt(1))laneCloseMenu_1.addSeparator();
                            laneCloseMenu_1.add(b); break;
                            case 'V' :  laneCloseMenu_2.add(b); break;
                            case 'K' :  laneCloseMenu_3.add(b); break;
                            case 'M' :  laneCloseMenu_4.add(b); break;
                        }
                        b.addActionListener(laneCloseListener);
                    }
                }
                
            };
		final Action runAction = new AbstractAction() {
			  {		putValue( Action.NAME, bundle.getString("run"));
			//        putValue( Action.DISPLAYED_MNEMONIC_INDEX_KEY, 1 );
			        putValue( Action.SMALL_ICON, new ImageIcon ("icons\\run_s.png"));
			        putValue( Action.LARGE_ICON_KEY, new ImageIcon ("icons\\run_m.png"));
			      
			  }
			@Override
			public void actionPerformed(ActionEvent arg0) {
                            if(S!=null){
                                if(!S.play){
                                    S.interrupted=false;
                                    S.play=true;
                                    simThread = new Thread(S);
                                    simThread.start();
                                    if(timeRollback.getValue()<40){
                                        for(int i=timeRollback.getValue(); i<Autosaves.autoSaves.size();i++){
                                                Autosaves.autoSaves.remove(i);
                                        }
                                        S.autoSaveCounter=timeRollback.getValue();
                                        timeRollback.setValue(40);
                                    }
                                }

                            }
                            else newSimulationAction.actionPerformed(null);
			}
		};
		final Action pauseAction = new AbstractAction() {
		      { putValue( Action.NAME,                         bundle.getString("pause") );
		  //   	putValue( Action.DISPLAYED_MNEMONIC_INDEX_KEY, 1 );
		        putValue( Action.SMALL_ICON,                   new ImageIcon ("icons\\pause_s.png"));
		        putValue( Action.LARGE_ICON_KEY,              new ImageIcon ("icons\\pause_m.png"));
		      }
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(S!=null&&S.play==true){
				S.interrupted=true;
				JOptionPane.showMessageDialog(MainFrame, "The simulation will paused. The last round will calculated.", "Pause", 0, new ImageIcon ("icons\\pause_m.png"));
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {e.printStackTrace();}
			}
			}
		}; 
		final Action zoomInAction = new AbstractAction() {
		      { putValue( Action.NAME, bundle.getString( "zoom_in" ));
		//        putValue( Action.DISPLAYED_MNEMONIC_INDEX_KEY, 1 );
		        putValue( Action.SMALL_ICON, new ImageIcon ("icons\\zoomIn_s.png"));
		        putValue( Action.LARGE_ICON_KEY, new ImageIcon ("icons\\zoomIn_m.png"));
		      }
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(S!=null && zoom<10){
					zoom+=0.10;
					drawPanel.setPreferredSize(new Dimension((int)(2300.0*zoom), (int)(2150.0*zoom)));
					drawPanel.setSize(new Dimension((int)(2300.0*zoom), (int)(2150.0*zoom)));
					drawPanel.validate();
					scrollPanel.validate();
				}
				
			}
		}; 
		final Action zoomOutAction = new AbstractAction() {
		      { putValue( Action.NAME,                         bundle.getString("zoom_out"));
		//        putValue( Action.DISPLAYED_MNEMONIC_INDEX_KEY, 1 );
		        putValue( Action.SMALL_ICON,  new ImageIcon ("icons\\zoomOut_s.png"));
		        putValue( Action.LARGE_ICON_KEY,  new ImageIcon ("icons\\zoomOut_m.png"));
		      }
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(S!=null && zoom>0.25){
					zoom-=0.10;
					drawPanel.setPreferredSize(new Dimension((int)(2300.0*zoom), (int)(2150.0*zoom)));
					drawPanel.setSize(new Dimension((int)(2300.0*zoom), (int)(2150.0*zoom)));
					drawPanel.validate();
					scrollPanel.validate();
				}
			}
		}; 
                final Action exportGraphAction = new AbstractAction() {
		      { //putValue( Action.NAME,                         bundle.getString("exportModelGraph"));
		//        putValue( Action.DISPLAYED_MNEMONIC_INDEX_KEY, 1 );
		        putValue( Action.SMALL_ICON,  new ImageIcon ("icons\\modelGraph_1_24x24.png"));
		        putValue( Action.LARGE_ICON_KEY,  new ImageIcon ("icons\\modelGraph_1_24x24.png"));
		      }
			@Override
			public void actionPerformed(ActionEvent arg0) {
                        
                            JFileChooser myChooser = new JFileChooser();
                            myChooser.setCurrentDirectory(myChooser.getFileSystemView().getParentDirectory(new File(System.getProperty("user.home"))));
                            myChooser.setAcceptAllFileFilterUsed(false);
                            myChooser.addChoosableFileFilter(new FileFilter() {
                                    public String getDescription() {
                                        return "Portable Network Graphics (*.png)";
                                    }

                                    public boolean accept(File f) {
                                        if (f.isDirectory()) {
                                            return true;
                                        } else {
                                            return f.getName().toLowerCase().endsWith(".png");
                                        }
                                    }
                                });
                            myChooser.addChoosableFileFilter(new FileFilter() {
                                    public String getDescription() {
                                        return "Portable Document Format (*.jpeg)";
                                    }

                                    public boolean accept(File f) {
                                        if (f.isDirectory()) {
                                            return true;
                                        } else {
                                            return f.getName().toLowerCase().endsWith(".jpeg");
                                        }
                                    }
                                });
                            
                            int option = myChooser.showSaveDialog(drawPanel);
                            if(option == JFileChooser.APPROVE_OPTION) {
                                if(myChooser.getSelectedFile() != null) {
                            
                                    String filePath = myChooser.getSelectedFile().getPath();
                                    String filterDescription = myChooser.getFileFilter().getDescription();//getChoosableFileFilters();
                                    if(filterDescription.equals("Portable Network Graphics (*.png)")) {
                                        filePath = filePath + ".png";
                                        BufferedImage bi = new BufferedImage((int) drawPanel.getBounds().getWidth(), 
                                                (int) drawPanel.getBounds().getHeight(), BufferedImage.TYPE_INT_ARGB); 
                                        Graphics g = bi.createGraphics();
                                        drawPanel.addNotify();
                                        drawPanel.setVisible(true);
                                        drawPanel.validate();
                                        drawPanel.paint(g);  //this == JComponent
                                        g.dispose();
                                        try {
                                            ImageIO.write(bi,"png",new File(filePath));
                                        } catch (Exception ex) {
                                            System.err.println(ex);
                                        }
                                    }
                                    // export graphic in jpeg format
                                    else if (filterDescription.equals("Portable Document Format (*.jpeg)")) {
                                        filePath = filePath + ".jpeg";
                                        BufferedImage expImage = new BufferedImage(drawPanel.getWidth(),
                                        drawPanel.getHeight(),BufferedImage.TYPE_INT_RGB);
                                        /*
                                         * Print to Image, scaling if necessary.
                                         */
                                        Graphics2D g2 = expImage.createGraphics();
                                        drawPanel.addNotify();
                                        drawPanel.setVisible(true);
                                        drawPanel.validate();   
                                        drawPanel.paint(g2);
                                        /*
                                         * Write to File
                                         */
                                        try {
                                            OutputStream out = new FileOutputStream(filePath);
                                            ImageIO.write(expImage, "jpeg", out);
                                            out.close();
                                        } catch (Exception ex) {
                                                 System.err.println(ex);
                                        }
                                    }
                                }
                            }
                        }
                };	               
		final Action statisicAction = new AbstractAction() {
		      { putValue( Action.NAME,                          bundle.getString("show_live_statistics"));
		     // putValue( Action.DISPLAYED_MNEMONIC_INDEX_KEY, 1 );
		        putValue( Action.SMALL_ICON,                   new ImageIcon ("icons\\statistics_s.png"));
		        putValue( Action.LARGE_ICON_KEY,              new ImageIcon ("icons\\statistics_m.png"));
		      }
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(S!=null){
					statsScrollPanel.setVisible(!statsScrollPanel.isVisible());				
					MainFrame.validate();
				}
			}
		 };
		final Action propertiesAction = new AbstractAction() {
		      { putValue( Action.NAME,                         bundle.getString("show_settings_pane"));
		     // putValue( Action.DISPLAYED_MNEMONIC_INDEX_KEY, 1 );
		        putValue( Action.SMALL_ICON,                   new ImageIcon ("icons\\properties_s.png"));
		        putValue( Action.LARGE_ICON_KEY,              new ImageIcon ("icons\\properties_m.png"));
		      }
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(S!=null){
					propScrollPanel.setVisible(!propScrollPanel.isVisible());
					MainFrame.validate();	
				}
			}
		 };
		final Action stopSimAction = new AbstractAction() {
		      { putValue( Action.NAME,                         bundle.getString("finish_simulation"));
		     // putValue( Action.DISPLAYED_MNEMONIC_INDEX_KEY, 1 );
		        putValue( Action.SMALL_ICON,                   new ImageIcon ("icons\\stopsim2_s.png"));
		        putValue( Action.LARGE_ICON_KEY,              new ImageIcon ("icons\\stopsim2_m.png"));
		      }
			@Override
			public void actionPerformed(ActionEvent arg0) {
                            if(JOptionPane.showConfirmDialog(MainFrame, "Do you want to finish the running simulation?", "Finish simulation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon("icons\\stopsim2_m.png")) == 0){
                                S.interrupted=true;
                                JOptionPane.showMessageDialog(MainFrame, "The simulation will exit.", "", 0, new ImageIcon ("icons\\stopsim2_m.png"));
                                try {
                                        Thread.sleep(500);
                                } catch (InterruptedException e) {e.printStackTrace();}
                                S=null; drawPanel.setSim(null);
                                statsPanel.setStatistics();
                                statsScrollPanel.setVisible(false);		
                                propScrollPanel.setVisible(false);
                                MainFrame.validate();
                            }
				
			}
		 };
		final Action endProgramAction = new AbstractAction() {
		      { putValue( Action.NAME,                         bundle.getString("exit_program"));
		     // putValue( Action.DISPLAYED_MNEMONIC_INDEX_KEY, 1 );
		        putValue( Action.SMALL_ICON, new ImageIcon ("icons\\end_s.png"));
		        putValue( Action.LARGE_ICON_KEY, new ImageIcon ("icons\\end_m.png"));
		      }
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
                            ((WindowListener)MainFrame.getListeners(WindowListener.class)[0]).windowClosing(null);
				
			}
		 };
		 
		 //--------------------------- Charaf'Code ------------------------------------------
		final Action engLanguageAction = new AbstractAction() {
		      { putValue( Action.NAME, bundle.getString("english"));
		      //        putValue( Action.DISPLAYED_MNEMONIC_INDEX_KEY, 1 );
		      //		putValue( Action.SMALL_ICON,                   new ImageIcon ("icons/zoomIn_s.png"));
		      //		putValue( Action.LARGE_ICON_KEY,              new ImageIcon ("icons/zoomIn_m.png"));
		      }
			@Override
			public void actionPerformed(ActionEvent arg0) {
				fileMenu.setText(bundle.getString("menu"));
				propertieMenu.setText(bundle.getString("settings"));
				statsMenu.setText(bundle.getString("statistic"));
				viewMenu.setText(bundle.getString("view"));
				languageMenu.setText(bundle.getString("language"));
				
				laneCloseMenu.setText(bundle.getString("block_lane"));
				laneCloseMenu_1.setText(bundle.getString("entry_points"));
				laneCloseMenu_2.setText(bundle.getString("exit_points"));
				laneCloseMenu_3.setText(bundle.getString("junction_lanes"));
				laneCloseMenu_4.setText(bundle.getString("connection_lanes"));
				
				newSimulationAction.putValue(newSimulationAction.NAME, bundle.getString("new_simulation"));
				runAction.putValue(runAction.NAME, bundle.getString("run"));
				pauseAction.putValue(pauseAction.NAME, bundle.getString("pause"));
				zoomInAction.putValue(zoomInAction.NAME, bundle.getString("zoom_in"));
				zoomOutAction.putValue(zoomOutAction.NAME, bundle.getString("zoom_out"));
				statisicAction.putValue(statisicAction.NAME, bundle.getString("show_live_statistics"));
				propertiesAction.putValue(propertiesAction.NAME, bundle.getString("show_settings_pane"));
				stopSimAction.putValue(stopSimAction.NAME, bundle.getString("finish_simulation"));
				endProgramAction.putValue(endProgramAction.NAME, bundle.getString("exit_program"));
				this.putValue(this.NAME, bundle.getString("english"));
//				germanLanguageAction.putValue(germanLanguageAction.NAME, bundle.getString("german"));
//				spanishLanguageAction.putValue(spanishLanguageAction.NAME, bundle.getString("spanish"));
				
			}
		}; 
		final Action germanLanguageAction = new AbstractAction() {
		      { putValue( Action.NAME, bundle.getString("german"));

		      }
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ResourceBundle messages_de = ResourceBundle.getBundle("gui/resources/MessagesBundle_de_DE", new Locale("de", "DE"));
				
				fileMenu.setText(messages_de.getString("menu"));
				propertieMenu.setText(messages_de.getString("settings"));
				statsMenu.setText(messages_de.getString("statistic"));
				viewMenu.setText(messages_de.getString("view"));
				languageMenu.setText(messages_de.getString("language"));
				
				laneCloseMenu.setText(messages_de.getString("block_lane"));
				laneCloseMenu_1.setText(messages_de.getString("entry_points"));
				laneCloseMenu_2.setText(messages_de.getString("exit_points"));
				laneCloseMenu_3.setText(messages_de.getString("junction_lanes"));
				laneCloseMenu_4.setText(messages_de.getString("connection_lanes"));
				
				newSimulationAction.putValue(newSimulationAction.NAME, messages_de.getString("new_simulation"));
				runAction.putValue(runAction.NAME, messages_de.getString("run"));
				pauseAction.putValue(pauseAction.NAME, messages_de.getString("pause"));
				zoomInAction.putValue(zoomInAction.NAME, messages_de.getString("zoom_in"));
				zoomOutAction.putValue(zoomOutAction.NAME, messages_de.getString("zoom_out"));
				statisicAction.putValue(statisicAction.NAME, messages_de.getString("show_live_statistics"));
				propertiesAction.putValue(propertiesAction.NAME, messages_de.getString("show_settings_pane"));
				stopSimAction.putValue(stopSimAction.NAME, messages_de.getString("finish_simulation"));
				endProgramAction.putValue(endProgramAction.NAME, messages_de.getString("exit_program"));
				this.putValue(this.NAME, messages_de.getString("german"));
//				engLanguageAction.putValue(engLanguageAction.NAME, messages_de.getString("english"));
//				spanishLanguageAction.putValue(spanishLanguageAction.NAME, messages_de.getString("spanish"));
				
				
				
			}
		}; 		
		final Action spanishLanguageAction = new AbstractAction() {
		      { putValue( Action.NAME,                         bundle.getString("spanish") );
		//        putValue( Action.DISPLAYED_MNEMONIC_INDEX_KEY, 1 );
//		        putValue( Action.SMALL_ICON,                   new ImageIcon ("icons/zoomIn_s.png"));
//		        putValue( Action.LARGE_ICON_KEY,              new ImageIcon ("icons/zoomIn_m.png"));
		      }
			@Override
			public void actionPerformed(ActionEvent arg0) {
			   ResourceBundle messages_es = ResourceBundle.getBundle("gui/resources/MessagesBundle_es_ES", new Locale("es", "ES"));
				
				fileMenu.setText(messages_es.getString("menu"));
				propertieMenu.setText(messages_es.getString("settings"));
				statsMenu.setText(messages_es.getString("statistic"));
				viewMenu.setText(messages_es.getString("view"));
				languageMenu.setText(messages_es.getString("language"));
				
				laneCloseMenu.setText(messages_es.getString("block_lane"));
				laneCloseMenu_1.setText(messages_es.getString("entry_points"));
				laneCloseMenu_2.setText(messages_es.getString("exit_points"));
				laneCloseMenu_3.setText(messages_es.getString("junction_lanes"));
				laneCloseMenu_4.setText(messages_es.getString("connection_lanes"));
				
				newSimulationAction.putValue(newSimulationAction.NAME, messages_es.getString("new_simulation"));
				runAction.putValue(runAction.NAME, messages_es.getString("run"));
				pauseAction.putValue(pauseAction.NAME, messages_es.getString("pause"));
				zoomInAction.putValue(zoomInAction.NAME, messages_es.getString("zoom_in"));
				zoomOutAction.putValue(zoomOutAction.NAME, messages_es.getString("zoom_out"));
				statisicAction.putValue(statisicAction.NAME, messages_es.getString("show_live_statistics"));
				propertiesAction.putValue(propertiesAction.NAME, messages_es.getString("show_settings_pane"));
				stopSimAction.putValue(stopSimAction.NAME, messages_es.getString("finish_simulation"));
				endProgramAction.putValue(endProgramAction.NAME, messages_es.getString("exit_program"));
				this.putValue(this.NAME, messages_es.getString("spanish"));
//				engLanguageAction.putValue(engLanguageAction.NAME, messages_es.getString("english"));
//				germanLanguageAction.putValue(germanLanguageAction.NAME, messages_es.getString("german"));
				
				
			}
		}; 
		 //--------------------------- End --------------------------------------------------	
		ActionListener fwdListener = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(S!=null && S.getQuickening()<5){
					S.setQuickening(S.getQuickening()+0.25);
					if(autoAdaptDiscretization)	S.setDiscretization(Math.round(S.standardDiscretization/S.getQuickening()));
				}
			}
			
		};
		ActionListener rwdListener = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(S!=null && S.getQuickening()>0.25)
                                    S.setQuickening(S.getQuickening()-0.25);
				if(autoAdaptDiscretization)
                                    S.setDiscretization(Math.round(S.standardDiscretization/S.getQuickening()));
				}
		};
		 
		 
		 //View-Properties
		 JCheckBoxMenuItem drawLineEnds = new JCheckBoxMenuItem("Show green traffic light",true);
		 ItemListener drawLineEndsListener=new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				lineEndsOn=(!lineEndsOn);
			}
			 
		 };
		 drawLineEnds.addItemListener(drawLineEndsListener);
		
		 JCheckBoxMenuItem drawJunctions = new JCheckBoxMenuItem("Show junction",true);
		 ItemListener drawJunctionsListener=new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				junctionsOn=(!junctionsOn);
			}
			 
		 };
		 drawJunctions.addItemListener(drawJunctionsListener);
		//------------------------- Charaf ---------------------
                 JCheckBoxMenuItem drawAllSpringsIDCheckBox = new JCheckBoxMenuItem("Show all springs ID",false);
		 ItemListener drawAllSpringsIDListener=new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				drawAllSpringsID=(!drawAllSpringsID);
				
			}
			 
		 };
		 drawAllSpringsIDCheckBox.addItemListener(drawAllSpringsIDListener);
                 
                //------------------------------------------------------
                              
		 JCheckBoxMenuItem drawIDCheckBox = new JCheckBoxMenuItem("Show car ID",false);
		 ItemListener drawIDListener=new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				drawID=(!drawID);
				
			}
			 
		 };
		 drawIDCheckBox.addItemListener(drawIDListener);
		 
		 JCheckBoxMenuItem drawDirectionCheckBox = new JCheckBoxMenuItem("Show directions",false);
		 ItemListener drawDirectionListener=new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				drawDirection=(!drawDirection);
				
			}
			 
		 };
		 drawDirectionCheckBox.addItemListener(drawDirectionListener);
		 
		 StayOpenCheckBoxMenuItem drawVelocityCheckBox = new StayOpenCheckBoxMenuItem("Show car speed",false);
		 ItemListener drawVelocityListener=new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				drawVelocity=(!drawVelocity);
	
			}
			 
		 };
		 drawVelocityCheckBox.addItemListener(drawVelocityListener);
		 
		 StayOpenCheckBoxMenuItem drawAccelerationCheckBox = new StayOpenCheckBoxMenuItem("Show car acceleration",false);
		 ItemListener drawAccelerationListener=new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				drawAcceleration=(!drawAcceleration);
	
			}
			 
		 };
		 drawAccelerationCheckBox.addItemListener(drawAccelerationListener);
		
		 StayOpenCheckBoxMenuItem drawObstacleDistCheckBox = new StayOpenCheckBoxMenuItem("Show obstacle distance",false);
		 ItemListener drawObstacleDistListener=new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				drawObstacleDist=(!drawObstacleDist);
	
			}
			 
		 };
		 drawObstacleDistCheckBox.addItemListener(drawObstacleDistListener);
		
		 StayOpenCheckBoxMenuItem drawSafetyDistCheckBox = new StayOpenCheckBoxMenuItem("Show safety distance",false);
		 ItemListener drawSafetyDistListener=new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				drawSafetyDistance=(!drawSafetyDistance);
			}
			 
		 };
		 drawSafetyDistCheckBox.addItemListener(drawSafetyDistListener);
		 
		 
		 JCheckBoxMenuItem props = new JCheckBoxMenuItem("Show settings pane", true);
		 ItemListener propsListener=new ItemListener(){

				@Override
				public void itemStateChanged(ItemEvent e) {
					framegbl.removeLayoutComponent(propScrollPanel);
				
				}
				 
			 };
		 props.addItemListener(propsListener);
		 
		 		 
		JCheckBoxMenuItem liveStats = new JCheckBoxMenuItem("Show LiveStats-Box", true);
		ItemListener liveStatsListener=new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				framegbl.removeLayoutComponent(statsScrollPanel);
			
			}
			 
		 };
		liveStats.addItemListener(liveStatsListener);
		
		
		//prop-Properties
		JCheckBoxMenuItem autoAdaptDiscretizationCheckBox = new JCheckBoxMenuItem("Auto adaption of discretization steps", true); //  Diskretisierungsschritte automatisch w�hlen
		ItemListener autoAdaptListener=new ItemListener(){

                            @Override
                            public void itemStateChanged(ItemEvent e) {
                                S.setDiscretization(Math.round(S.standardDiscretization/S.getQuickening()));
                                autoAdaptDiscretization=!autoAdaptDiscretization;
                                Component[] comp = propPanel.speedPanel.getComponents();
                                comp[5].setEnabled(!autoAdaptDiscretization);
                                comp[6].setEnabled(!autoAdaptDiscretization);
                                comp[7].setEnabled(!autoAdaptDiscretization);
                            }
				 
			 };
		autoAdaptDiscretizationCheckBox.addItemListener(autoAdaptListener);
		
		JCheckBoxMenuItem predecessorGraphCheckBox = new JCheckBoxMenuItem("Show predecessor graph", false);
		ItemListener predecessorGraphListener=new ItemListener(){

				@Override
				public void itemStateChanged(ItemEvent e) {
					predecessorGraphOn=!predecessorGraphOn;
				}
			};
		predecessorGraphCheckBox.addItemListener(predecessorGraphListener);
				 
		JCheckBoxMenuItem successorGraphCheckBox = new JCheckBoxMenuItem("Show successor graph", false);
		ItemListener successorGraphListener=new ItemListener(){
                            @Override
                            public void itemStateChanged(ItemEvent e) {
                                    successorGraphOn=!successorGraphOn;
                            }
			};
		successorGraphCheckBox.addItemListener(successorGraphListener);
		
                //------------------------- Show Springs id's in GUI (Daniel) ------------------
                JMenu showSprings = new JMenu("Show groups of springs");
                final JLabel A1_SS = new JLabel("A1");
		final JLabel A2_SS = new JLabel("A2");
		final JLabel A3_SS = new JLabel("A3");
		final JLabel A4_SS = new JLabel("A4");
		final JLabel A5_SS = new JLabel("A5");
		final JLabel A6_SS = new JLabel("A6");
                final JLabel A7_SS = new JLabel("A7");
		final JLabel A8_SS = new JLabel("A8");
		final JLabel A9_SS = new JLabel("A9");
		final JLabel A10_SS = new JLabel("A10");
		final JLabel A11_SS = new JLabel("A11");
                JCheckBoxMenuItem GraphCheckBox_A1_SS = new JCheckBoxMenuItem("Show A1", false);
                JCheckBoxMenuItem GraphCheckBox_A2_SS = new JCheckBoxMenuItem("Show A2", false);
                JCheckBoxMenuItem GraphCheckBox_A3_SS = new JCheckBoxMenuItem("Show A3", false);
                JCheckBoxMenuItem GraphCheckBox_A4_SS = new JCheckBoxMenuItem("Show A4", false);
                JCheckBoxMenuItem GraphCheckBox_A5_SS = new JCheckBoxMenuItem("Show A5", false);
                JCheckBoxMenuItem GraphCheckBox_A6_SS = new JCheckBoxMenuItem("Show A6", false);
                JCheckBoxMenuItem GraphCheckBox_A7_SS = new JCheckBoxMenuItem("Show A7", false);
                JCheckBoxMenuItem GraphCheckBox_A8_SS = new JCheckBoxMenuItem("Show A8", false);
                JCheckBoxMenuItem GraphCheckBox_A9_SS = new JCheckBoxMenuItem("Show A9", false);
                JCheckBoxMenuItem GraphCheckBox_A10_SS = new JCheckBoxMenuItem("Show A10", false);
                JCheckBoxMenuItem GraphCheckBox_A11_SS = new JCheckBoxMenuItem("Show A11", false);
                showSprings.add(GraphCheckBox_A1_SS);
                showSprings.add(GraphCheckBox_A2_SS);
                showSprings.add(GraphCheckBox_A3_SS);
                showSprings.add(GraphCheckBox_A4_SS);
                showSprings.add(GraphCheckBox_A5_SS);
                showSprings.add(GraphCheckBox_A6_SS);
                showSprings.add(GraphCheckBox_A7_SS);
                showSprings.add(GraphCheckBox_A8_SS);
                showSprings.add(GraphCheckBox_A9_SS);
                showSprings.add(GraphCheckBox_A10_SS);
                showSprings.add(GraphCheckBox_A11_SS);
                
			ChangeListener showSpringListener = new ChangeListener(){

				@Override
				public void stateChanged(ChangeEvent e) {
					if(e.getSource()==GraphCheckBox_A1_SS){
                                            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                            MainFrame.add(A1_SS);
                                            A1_SS.setLocation(90,1440);
                                            A1_SS.setSize(50, 50);
                                            A1_SS.setVisible(true);
                                            MainFrame.setLayout(null);
                                        }else if(e.getSource()==GraphCheckBox_A2_SS){
                                            
                                        }else if(e.getSource()==GraphCheckBox_A3_SS){
                                            
                                        }else if(e.getSource()==GraphCheckBox_A4_SS){
                                            
                                        }else if(e.getSource()==GraphCheckBox_A5_SS){
                                            
                                        }else if(e.getSource()==GraphCheckBox_A6_SS){
                                            
                                        }else if(e.getSource()==GraphCheckBox_A7_SS){
                                            
                                        }else if(e.getSource()==GraphCheckBox_A8_SS){
                                            
                                        }else if(e.getSource()==GraphCheckBox_A9_SS){
                                            
                                        }else if(e.getSource()==GraphCheckBox_A10_SS){
                                            
                                        }else if(e.getSource()==GraphCheckBox_A11_SS){
                                            
                                        }
				}
			};
		predecessorGraphCheckBox.addItemListener(predecessorGraphListener);
                //------------------------------------------------------------------------------
                //============Art's Code===========================================
		JMenu springProperties = new JMenu("Modify strength of spring"); // Change the number of the cars accessed from this spring. // Quellst�rken
		final JLabel A1 = new JLabel("A1: 48/min");
		final JLabel A2 = new JLabel("A2: 13/min");
		final JLabel A3 = new JLabel("A3: 14/min");
		final JLabel A4 = new JLabel("A4: 45/min");
		final JLabel A5 = new JLabel("A5: 32/min");
		final JLabel A6 = new JLabel("A6: 34/min");
                final JLabel A7 = new JLabel("A7: 18/min");
		final JLabel A8 = new JLabel("A8: 9/min");
		final JLabel A9 = new JLabel("A9: 14/min");
		final JLabel A10 = new JLabel("A10: 16/min");
		final JLabel A11 = new JLabel("A11: 6/min");
		final JSlider springA1Slider = new JSlider(0,60,48);
		final JSlider springA2Slider = new JSlider(0,60,13);
		final JSlider springA3Slider = new JSlider(0,60,14);
		final JSlider springA4Slider = new JSlider(0,60,45);
		final JSlider springA5Slider = new JSlider(0,60,32);
		final JSlider springA6Slider = new JSlider(0,60,34);
                final JSlider springA7Slider = new JSlider(0,60,18);
		final JSlider springA8Slider = new JSlider(0,60,9);
		final JSlider springA9Slider = new JSlider(0,60,14);
		final JSlider springA10Slider = new JSlider(0,60,16);
		final JSlider springA11Slider = new JSlider(0,60,6);
		springProperties.add(A1); springProperties.add(springA1Slider);
		springProperties.add(A2); springProperties.add(springA2Slider);
		springProperties.add(A3); springProperties.add(springA3Slider);
		springProperties.add(A4); springProperties.add(springA4Slider);
		springProperties.add(A5); springProperties.add(springA5Slider);
		springProperties.add(A6); springProperties.add(springA6Slider);
                springProperties.add(A7); springProperties.add(springA7Slider);
		springProperties.add(A8); springProperties.add(springA8Slider);
		springProperties.add(A9); springProperties.add(springA9Slider);
		springProperties.add(A10); springProperties.add(springA10Slider);
		springProperties.add(A11); springProperties.add(springA11Slider);
		
		ChangeListener springListener = new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e) {
				if(e.getSource()==springA1Slider){
					int newValue = ((JSlider) e.getSource()).getValue(); 
					Probabilities.updatePredictant(1, newValue); A1.setText("A1: "+ newValue+"/min");
				}
				else if(e.getSource()==springA2Slider){
					int newValue = ((JSlider) e.getSource()).getValue(); 
					Probabilities.updatePredictant(2, newValue); A2.setText("A2: "+ newValue+"/min");
				}
				else if(e.getSource()==springA3Slider){
					int newValue = ((JSlider) e.getSource()).getValue(); 
					Probabilities.updatePredictant(3, newValue); A3.setText("A3: "+ newValue+"/min");
				}
				else if(e.getSource()==springA4Slider){
					int newValue = ((JSlider) e.getSource()).getValue(); 
					Probabilities.updatePredictant(4, newValue); A4.setText("A4: "+ newValue+"/min");
				}
				else if(e.getSource()==springA5Slider){
					int newValue = ((JSlider) e.getSource()).getValue(); 
					Probabilities.updatePredictant(5, newValue); A5.setText("A5: "+ newValue+"/min");
				}
				else if(e.getSource()==springA6Slider){
					int newValue = ((JSlider) e.getSource()).getValue(); 
					Probabilities.updatePredictant(6, newValue); A6.setText("A6: "+ newValue+"/min");
				}
                                else if(e.getSource()==springA7Slider){
					int newValue = ((JSlider) e.getSource()).getValue(); 
					Probabilities.updatePredictant(7, newValue); A7.setText("A7: "+ newValue+"/min");
				}
                                else if(e.getSource()==springA8Slider){
					int newValue = ((JSlider) e.getSource()).getValue(); 
					Probabilities.updatePredictant(8, newValue); A8.setText("A8: "+ newValue+"/min");
				}
                                else if(e.getSource()==springA9Slider){
					int newValue = ((JSlider) e.getSource()).getValue(); 
					Probabilities.updatePredictant(9, newValue); A9.setText("A9: "+ newValue+"/min");
				}
                                else if(e.getSource()==springA10Slider){
					int newValue = ((JSlider) e.getSource()).getValue(); 
					Probabilities.updatePredictant(10, newValue); A10.setText("A10: "+ newValue+"/min");
				}
                                else if(e.getSource()==springA11Slider){
					int newValue = ((JSlider) e.getSource()).getValue(); 
					Probabilities.updatePredictant(11, newValue); A11.setText("A11: "+ newValue+"/min");
				}
			}	
		};
		springA1Slider.addChangeListener(springListener); 
                springA2Slider.addChangeListener(springListener); 
                springA3Slider.addChangeListener(springListener); 
                springA4Slider.addChangeListener(springListener); 
                springA5Slider.addChangeListener(springListener); 
                springA6Slider.addChangeListener(springListener);
                springA7Slider.addChangeListener(springListener); 
                springA8Slider.addChangeListener(springListener); 
                springA9Slider.addChangeListener(springListener); 
                springA10Slider.addChangeListener(springListener); 
                springA11Slider.addChangeListener(springListener);
		
		//================Art's Code End========================================
		
		
		
		//file-Properties
			 timeRollback = new JSlider ( 1, 40, 40 );
			 timeRollback.setPaintTicks(true);
			 timeRollback.setMajorTickSpacing( 8 );
			 timeRollback.setMinorTickSpacing( 1 );
			 timeRollback.setPaintTrack( true );
			 timeRollback.setToolTipText("Time-Rollback");
			 timeRollback.setMaximumSize(new Dimension(200,50));
			 timeRollback.setOpaque(false);
			 timeRollback.addChangeListener( new ChangeListener() {
				 @Override public void stateChanged( ChangeEvent e ) {
				   
                                    if(S!=null && 
                                           ((JSlider) e.getSource()).getValue()<=S.autoSaveCounter){
                                         System.out.print( "Rollback zu Autosave nr. " + ((JSlider) e.getSource()).getValue() );
                                         pauseAction.actionPerformed(null);

                                         ByteArrayInputStream bais = null;
                                         try{
                                         bais = new ByteArrayInputStream(Autosaves.autoSaves.get(((JSlider) e.getSource()).getValue()-1));
                                         }catch(NullPointerException e2){e2.printStackTrace();}
                                         ObjectInputStream  ois = null;
                                         try {
                                                   ois = new ObjectInputStream(bais);
                                         } catch (IOException e1) {e1.printStackTrace();}

                                         try {S = (Simulation) ois.readObject();
                                                   System.out.println(" -- SimTime dieses Saves: "+S.getSimTime());}
                                         catch (IOException e1) {e1.printStackTrace();}
                                         catch (ClassNotFoundException e1) {e1.printStackTrace();}

                                         try {bais.close();}
                                         catch (IOException e1) {e1.printStackTrace();}

                                         drawPanel.setSim(S);
                                         statsPanel.setStatistics();

                                    }
			   }
			 } );

			
			 
		 
		//Modify Menus and pack them onto theMenuBar	
		fileMenu.add(newSimulationAction);
		fileMenu.add(runAction);
		fileMenu.add(pauseAction);
		fileMenu.add(timeRollback);
		fileMenu.addSeparator();
		fileMenu.add(stopSimAction);
		fileMenu.add(endProgramAction);
		
		propertieMenu.add(predecessorGraphCheckBox);
		propertieMenu.add(successorGraphCheckBox);
		propertieMenu.addSeparator();
		propertieMenu.add(springProperties);
		propertieMenu.add(laneCloseMenu);
		propertieMenu.addSeparator();
		propertieMenu.add(autoAdaptDiscretizationCheckBox);
		propertieMenu.addSeparator();
		propertieMenu.add(propertiesAction);
			
		statsMenu.add(new JCheckBoxMenuItem("Stop live statistic"));
		statsMenu.addSeparator();
		statsMenu.add(statisicAction);
		
		viewMenu.add(zoomInAction);
		viewMenu.add(zoomOutAction);
		viewMenu.addSeparator();
		viewMenu.add(drawLineEnds);
		viewMenu.add(drawJunctions);
		viewMenu.addSeparator();
                viewMenu.add(showSprings);
                viewMenu.add(drawAllSpringsIDCheckBox);
		viewMenu.add(drawIDCheckBox);
		viewMenu.add(drawDirectionCheckBox);
		viewMenu.add(drawVelocityCheckBox);
		viewMenu.add(drawAccelerationCheckBox);
		viewMenu.add(drawObstacleDistCheckBox);
		viewMenu.add(drawSafetyDistCheckBox);
		viewMenu.addSeparator();
		viewMenu.add(liveStats);
		viewMenu.add(props);
		
		//---------------- Charaf'code -------------------------------------
		languageMenu.add(engLanguageAction);
		languageMenu.add(spanishLanguageAction);
		languageMenu.add(germanLanguageAction);
		menuBar.add(languageMenu);

		//---------------- End ---------------------------------------------
		
		menuBar.add(fileMenu);
		menuBar.add(propertieMenu);
		menuBar.add(statsMenu);
		menuBar.add(viewMenu);
		
		//---------------- Charaf'code -------------------------------------
		menuBar.add(languageMenu);
		//---------------- End ---------------------------------------------
		

		
		//Modify buttons
		button_fwd.setToolTipText("Increase simulation speed");
		button_fwd.addActionListener(fwdListener);
		button_rwd.setToolTipText("Decrease simulation speed");
		button_rwd.addActionListener(rwdListener);
	
		//Modify Tools and pack them onto the ToolBars
		toolbar0.add(stopSimAction);
		toolbar0.addSeparator();
		toolbar0.add(runAction);
		toolbar0.add(pauseAction);
		toolbar0.addSeparator();
		toolbar0.add(button_rwd);
		toolbar0.add(button_fwd );
		toolbar0.addSeparator();
		toolbar0.add(timeRollback);
		toolbar0.addSeparator();
		toolbar0.add(zoomInAction);
		toolbar0.add(zoomOutAction);
		toolbar0.setFloatable(false);
		toolbar0.addSeparator();
                toolbar0.add(exportGraphAction);
		
		toolbar1.add(propertiesAction);
		toolbar1.add(statisicAction);
		toolbar1.setFloatable(false);
		
		
		
//		toolbar2.add(stopSimAction);
//		toolbar2.setFloatable(false);
		
		
		
		//Pack everything onto the Frame:
		MainFrame.setJMenuBar( menuBar );
		//									x	y	w	h	wx		wy		anchor
		GridBagFunctions.addComponent(MainFrame, framegbl, toolbar0,		0,	0,	1,	1,	1,		0,	GridBagConstraints.EAST);
		GridBagFunctions.addComponent(MainFrame, framegbl, toolbar1,		1,	0,	2,	1,	0,		0,	GridBagConstraints.CENTER);
//		GridBagFunctions.addComponent(MainFrame, framegbl, toolbar2,		3,	0,	1,	1,	0,		0,	GridBagConstraints.EAST);
		GridBagFunctions.addComponent(MainFrame, framegbl, scrollPanel,		0,	1,	3,	5,	1.0,            1.0,    GridBagConstraints.NORTHWEST);
		GridBagFunctions.addComponent(MainFrame, framegbl, propScrollPanel,	3,	1,	1,	1,	0,		0.5,	GridBagConstraints.NORTHWEST);
		GridBagFunctions.addComponent(MainFrame, framegbl, statsScrollPanel,    3,	2,	1,	2,	0,		0.5,	GridBagConstraints.NORTHWEST);
		
		
		//Ask luser if he really wants to end this beautiful simulation without even taking a glimpse at the statistics
		MainFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		WindowListener endX = new WindowListener(){

			@Override
			public void windowActivated(WindowEvent arg0) {}

			@Override
			public void windowClosed(WindowEvent arg0) {}

			@Override
			public void windowClosing(WindowEvent arg0) {
				if(JOptionPane.showConfirmDialog(MainFrame, "Do you want to exit this program?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon("icons\\end_m.png")) == 0){
					MainFrame.dispose();
					System.exit(0);
				}
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {}

			@Override
			public void windowDeiconified(WindowEvent arg0) {}

			@Override
			public void windowIconified(WindowEvent arg0) {}

			@Override
			public void windowOpened(WindowEvent arg0) {}
			
		};
		MainFrame.addWindowListener(endX);
	
		
//		toolbar0.setBackground(Color.blue);
//		toolbar1.setBackground(Color.green);
//		toolbar2.setBackground(Color.red);
		
		//Show me whatcha gat
		statsScrollPanel.setVisible(false);
		propScrollPanel.setVisible(false);
		MainFrame.pack();
		MainFrame.setVisible(true);
		
		Thread paintThread = new Thread(this);
		paintThread.start();
	}
	

	

	@Override
	public void run() {
		while(true){
			
			blinkerPhase = (blinkerPhase+50) % 500;
			if(blinkerPhase == 0 ) blinker = !blinker;
			
			MainFrame.repaint();
			
			try {Thread.sleep(50);} 
			catch (InterruptedException e) {break;}
		}
	}	
}
