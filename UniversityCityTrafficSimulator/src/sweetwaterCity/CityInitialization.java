package sweetwaterCity;

import java.awt.Point;
import java.util.LinkedList;
import entities.*;
import events.NewAgent_Event;
import events.TrafficLight_Event;
import java.util.Arrays;
import simulation.Simulation;

public class CityInitialization 
{
    public static void initialize(Simulation S) 
    {
        int i = 1;
        double t = System.currentTimeMillis();
        System.out.println("Initialization of the model");
        
//*************Lines***********
//<editor-fold defaultstate="collapsed" desc="A Lanes">
        LinkedList<Lane> lines = new LinkedList<Lane>();
        // 8th STREET
        Lane A1_1 = new Lane("A1_1", i++, 210); lines.add(A1_1); // id = 1
        Lane A1_2 = new Lane("A1_2", i++, 210); lines.add(A1_2);
        Lane A1_3 = new Lane("A1_3", i++, 210); lines.add(A1_3);
        Lane A1_4 = new Lane("A1_4", i++, 240); lines.add(A1_4);
        
        Lane A2_1 = new Lane("A2_1", i++, 120); lines.add(A2_1);
        Lane A2_2 = new Lane("A2_2", i++, 210); lines.add(A2_2);   
        
        Lane A3_1 = new Lane("A3_1", i++, 90); lines.add(A3_1);
        Lane A3_2 = new Lane("A3_2", i++, 210); lines.add(A3_2);
        
        Lane A4_1 = new Lane("A4_1", i++, 70); lines.add(A4_1);
        Lane A4_2 = new Lane("A4_2", i++, 200); lines.add(A4_2);
        
        Lane A5_1 = new Lane("A5_1", i++, 320); lines.add(A5_1);
        Lane A5_2 = new Lane("A5_2", i++, 310); lines.add(A5_2);
        Lane A5_3 = new Lane("A5_3", i++, 310); lines.add(A5_3);
        Lane A5_4 = new Lane("A5_4", i++, 310); lines.add(A5_4); // id = 20 
        
        // FLAGLER
        Lane A6_1 = new Lane("A6_1", i++, 300); lines.add(A6_1); 
        Lane A6_2 = new Lane("A6_2", i++, 300); lines.add(A6_2);
        Lane A6_3 = new Lane("A6_3", i++, 200); lines.add(A6_3);
        
        Lane A7_1 = new Lane("A7_1", i++, 180); lines.add(A7_1);
        Lane A7_2 = new Lane("A7_2", i++, 180); lines.add(A7_2);   
        Lane A7_3 = new Lane("A7_3", i++, 180); lines.add(A7_3);
         
        Lane A8_1 = new Lane("A8_1", i++, 100); lines.add(A8_1); 
        
        Lane A9_1 = new Lane("A9_1", i++, 130); lines.add(A9_1);
        
        Lane A10_1 = new Lane("A10_1", i++, 120); lines.add(A10_1);
        Lane A10_2 = new Lane("A10_2", i++, 200); lines.add(A10_2);
        Lane A10_3 = new Lane("A10_3", i++, 200); lines.add(A10_3); 
        
        Lane A11_1 = new Lane("A11_1", i++, 210); lines.add(A11_1);
      
      
//</editor-fold>        
//<editor-fold defaultstate="collapsed" desc="V Lanes">       
        // 8th STREET
        Lane V1_1 = new Lane("V1_1", i++, 210); lines.add(V1_1);
        Lane V1_2 = new Lane("V1_2", i++, 210); lines.add(V1_2);
        Lane V1_3 = new Lane("V1_3", i++, 210); lines.add(V1_3);
        
        Lane V2_1 = new Lane("V2_1", i++, 210); lines.add(V2_1);
        Lane V2_2 = new Lane("V2_2", i++, 210); lines.add(V2_2);
        
        Lane V3_1 = new Lane("V3_1", i++, 210); lines.add(V3_1); // id = 30
        Lane V3_2 = new Lane("V3_2", i++, 200); lines.add(V3_2);
        
        Lane V4_1 = new Lane("V4_1", i++, 210); lines.add(V4_1);
        Lane V4_2 = new Lane("V4_2", i++, 210); lines.add(V4_2);
        Lane V4_3 = new Lane("V4_3", i++, 210); lines.add(V4_3);
        
        Lane V5_1 = new Lane("V5_1", i++, 310); lines.add(V5_1);
        Lane V5_2 = new Lane("V5_2", i++, 310); lines.add(V5_2);
        Lane V5_3 = new Lane("V5_3", i++, 310); lines.add(V5_3);
        
        // FLAGLER
        Lane V6_1 = new Lane("V6_1", i++, 300); lines.add(V6_1);
        Lane V6_2 = new Lane("V6_2", i++, 300); lines.add(V6_2);
        Lane V6_3 = new Lane("V6_3", i++, 300); lines.add(V6_3);
        
        Lane V7_1 = new Lane("V7_1", i++, 180); lines.add(V7_1);
        Lane V7_2 = new Lane("V7_2", i++, 180); lines.add(V7_2);
        Lane V7_3 = new Lane("V7_3", i++, 190); lines.add(V7_3);
         
        Lane V8_1 = new Lane("V8_1", i++, 180); lines.add(V8_1); // id = 30
        
        Lane V9_1 = new Lane("V9_1", i++, 180); lines.add(V9_1);
        
        Lane V10_1 = new Lane("V10_1", i++, 200); lines.add(V10_1);
        Lane V10_2 = new Lane("V10_2", i++, 200); lines.add(V10_2);
        Lane V10_3 = new Lane("V10_3", i++, 200); lines.add(V10_3);
        
        Lane V11_1 = new Lane("V11_1", i++, 210); lines.add(V11_1);
//</editor-fold>        
//<editor-fold defaultstate="collapsed" desc="M Lanes">        
        // 8th STREET
        Lane M1_1 = new Lane("M1_1", i++, 93); lines.add(M1_1);//check me y y y mf
        Lane M1_2 = new Lane("M1_2", i++, 90); lines.add(M1_2);
        
        Lane M2_1 = new Lane("M2_1", i++, 430); lines.add(M2_1);
        Lane M2_2 = new Lane("M2_2", i++, 430); lines.add(M2_2);
        Lane M2_3 = new Lane("M2_3", i++, 320); lines.add(M2_3);
        Lane M2_3_1 = new Lane("M2_3_1", i++, 110); lines.add(M2_3_1);
        Lane M2_3_2 = new Lane("M2_3_2", i++, 112); lines.add(M2_3_2);      
        
        Lane M3_1 = new Lane("M3_1", i++, 430); lines.add(M3_1);
        Lane M3_2 = new Lane("M3_2", i++, 430); lines.add(M3_2);        
        Lane M3_3 = new Lane("M3_3", i++, 430); lines.add(M3_3);
        Lane M3_4 = new Lane("M3_4", i++, 430); lines.add(M3_4);
        Lane M3_1_1 = new Lane("M3_1_1", i++, 152); lines.add(M3_1_1);
        Lane M3_1_2 = new Lane("M3_1_2", i++, 150); lines.add(M3_1_2);        
        
        Lane M4_1 = new Lane("M4_1", i++, 102); lines.add(M4_1);
        Lane M4_2 = new Lane("M4_2", i++, 100); lines.add(M4_2);
        
        Lane M5_1 = new Lane("M5_1", i++, 420); lines.add(M5_1);
        Lane M5_2 = new Lane("M5_2", i++, 420); lines.add(M5_2);
        Lane M5_3 = new Lane("M5_3", i++, 280); lines.add(M5_3);
        Lane M5_3_1 = new Lane("M5_3_1", i++, 140); lines.add(M5_3_1);
        Lane M5_3_2 = new Lane("M5_3_2", i++, 142); lines.add(M5_3_2);
        Lane M5_3_3 = new Lane("M5_3_3", i++, 146); lines.add(M5_3_3);
        
        Lane M6_1 = new Lane("M6_1", i++, 420); lines.add(M6_1);
        Lane M6_1_1 = new Lane("M6_1_1", i++, 420); lines.add(M6_1_1);
        Lane M6_1_2 = new Lane("M6_1_2", i++, 420); lines.add(M6_1_2);
        Lane M6_1_3 = new Lane("M6_1_3", i++, 420); lines.add(M6_1_3);
        Lane M6_2 = new Lane("M6_2", i++, 212); lines.add(M6_2);
        Lane M6_3 = new Lane("M6_3", i++, 211); lines.add(M6_3); // id = 60
        Lane M6_4 = new Lane("M6_4", i++, 210); lines.add(M6_4);
        
        Lane M7_1 = new Lane("M7_1", i++, 121); lines.add(M7_1);
        Lane M7_2 = new Lane("M7_2", i++, 120); lines.add(M7_2);
        
        Lane M8_4_1 = new Lane("M8_4_1", i++, 180); lines.add(M8_4_1);
        Lane M8_4_2 = new Lane("M8_4_2", i++, 140); lines.add(M8_4_2);
        Lane M8_4_3 = new Lane("M8_4_3", i++, 142); lines.add(M8_4_3);
        //Lane M8_4_4 = new Lane("M8_4_4", i++, 45); lines.add(M8_4_4);
        
        Lane M9_1 = new Lane("M9_1", i++, 750); lines.add(M9_1);
        Lane M9_1_1 = new Lane("M9_1_1", i++, 42); lines.add(M9_1_1);
        Lane M9_1_2 = new Lane("M9_1_2", i++, 40); lines.add(M9_1_2);
        Lane M9_1_3 = new Lane("M9_1_3", i++, 64); lines.add(M9_1_3);
        //Lane M9_1_4 = new Lane("M9_1_4", i++, 20); lines.add(M9_1_4);
        
        Lane M10_1 = new Lane("M10_1", i++, 700); lines.add(M10_1);
        Lane M10_1_1 = new Lane("M10_1_1", i++, 112); lines.add(M10_1_1);
        Lane M10_1_2 = new Lane("M10_1_2", i++, 110); lines.add(M10_1_2);
        
        Lane M11_1 = new Lane("M11_1", i++, 810); lines.add(M11_1);
        Lane M11_2 = new Lane("M11_2", i++, 670); lines.add(M11_2);
        Lane M11_2_1 = new Lane("M11_2_1", i++, 140); lines.add(M11_2_1);
        Lane M11_2_2 = new Lane("M11_2_2", i++, 142); lines.add(M11_2_2);
        
        Lane M12_1 = new Lane("M12_1", i++, 700); lines.add(M12_1);
        Lane M12_2 = new Lane("M12_2", i++, 810); lines.add(M12_2);
        Lane M12_1_1 = new Lane("M12_1_1", i++, 112); lines.add(M12_1_1);
        Lane M12_1_2 = new Lane("M12_1_2", i++, 110); lines.add(M12_1_2);
        //FLAGLER
        Lane M13_3_1 = new Lane("M13_3_1", i++, 100); lines.add(M13_3_1);
        Lane M13_3_2 = new Lane("M13_3_2", i++, 101); lines.add(M13_3_2);
        
        Lane M14_1 = new Lane("M14_1", i++, 340); lines.add(M14_1);
        Lane M14_2 = new Lane("M14_2", i++, 440); lines.add(M14_2);
        Lane M14_3 = new Lane("M14_3", i++, 440); lines.add(M14_3);
        Lane M14_1_1 = new Lane("M14_1_1", i++, 102); lines.add(M14_1_1);
        Lane M14_1_2 = new Lane("M14_1_2", i++, 100); lines.add(M14_1_2);
        
        Lane M15_1 = new Lane("M15_1", i++, 440); lines.add(M15_1);
        Lane M15_2 = new Lane("M15_2", i++, 440); lines.add(M15_2);
        Lane M15_3 = new Lane("M15_3", i++, 380); lines.add(M15_3);
        Lane M15_3_1 = new Lane("M15_3_1", i++, 60); lines.add(M15_3_1);
        Lane M15_3_2 = new Lane("M15_3_2", i++, 61); lines.add(M15_3_2);
        
        Lane M16_1_1 = new Lane("M16_1_1", i++, 80); lines.add(M16_1_1);
        Lane M16_1_2 = new Lane("M16_1_2", i++, 83); lines.add(M16_1_2);
        
        Lane M17_1 = new Lane("M17_1", i++, 340); lines.add(M17_1);
        Lane M17_2 = new Lane("M17_2", i++, 420); lines.add(M17_2);
        Lane M17_3 = new Lane("M17_3", i++, 420); lines.add(M17_3);
        Lane M17_1_1 = new Lane("M17_1_1", i++, 81); lines.add(M17_1_1);
        Lane M17_1_2 = new Lane("M17_1_2", i++, 80); lines.add(M17_1_2);
        
        Lane M18_1 = new Lane("M18_1", i++, 420); lines.add(M18_1);
        Lane M18_2 = new Lane("M18_2", i++, 420); lines.add(M18_2);
        Lane M18_3 = new Lane("M18_3", i++, 350); lines.add(M18_3);
        Lane M18_3_1 = new Lane("M18_3_1", i++, 70); lines.add(M18_3_1);
        Lane M18_3_2 = new Lane("M18_3_2", i++, 71); lines.add(M18_3_2);
        
        Lane M19_1_1 = new Lane("M19_1_1", i++, 50); lines.add(M19_1_1);
        Lane M19_1_2 = new Lane("M19_1_2", i++, 54); lines.add(M19_1_2);
        
        Lane M20_1_1 = new Lane("M20_1_1", i++, 81); lines.add(M20_1_1);
        Lane M20_1_2 = new Lane("M20_1_2", i++, 80); lines.add(M20_1_2);//i=128
        
//</editor-fold>        
//<editor-fold defaultstate="collapsed" desc="K Lanes">        
        // 8th STREET
        Lane K1_1 = new Lane("K1_1", i++, 120); lines.add(K1_1);
        Lane K1_2 = new Lane("K1_2", i++, 120); lines.add(K1_2);
        Lane K1_3 = new Lane("K1_3", i++, 120); lines.add(K1_3);
        Lane K1_4 = new Lane("K1_4", i++, 120); lines.add(K1_4);
        Lane K1_5 = new Lane("K1_5", i++, 120); lines.add(K1_5);
        Lane K1_6 = new Lane("K1_6", i++, 120); lines.add(K1_6);
        Lane K1_7 = new Lane("K1_7", i++, 175); lines.add(K1_7);
        Lane K1_8 = new Lane("K1_8", i++, 203); lines.add(K1_8);
        Lane K1_9 = new Lane("K1_9", i++, 148); lines.add(K1_9);

        Lane K2_1 = new Lane("K2_1", i++, 120); lines.add(K2_1); 
        Lane K2_2 = new Lane("K2_2", i++, 120); lines.add(K2_2);
        Lane K2_3 = new Lane("K2_3", i++, 120); lines.add(K2_3);
        Lane K2_4 = new Lane("K2_4", i++, 120); lines.add(K2_4);
        Lane K2_5 = new Lane("K2_5", i++, 120); lines.add(K2_5);
        Lane K2_6 = new Lane("K2_6", i++, 120); lines.add(K2_6);
        Lane K2_7 = new Lane("K2_7", i++, 100); lines.add(K2_7);
        Lane K2_8 = new Lane("K2_8", i++, 153); lines.add(K2_8); 
        Lane K2_9 = new Lane("K2_9", i++, 181); lines.add(K2_9);
        Lane K2_10 = new Lane("K2_10", i++, 188); lines.add(K2_10);
        Lane K2_11 = new Lane("K2_11", i++, 230); lines.add(K2_11);
        Lane K2_12 = new Lane("K2_12", i++, 164); lines.add(K2_12);
        Lane K2_13 = new Lane("K2_13", i++, 177); lines.add(K2_13);
        Lane K2_14 = new Lane("K2_14", i++, 23); lines.add(K2_14);
        Lane K2_15 = new Lane("K2_15", i++, 230); lines.add(K2_15);
        Lane K2_16 = new Lane("K2_16", i++, 198); lines.add(K2_16);
        Lane K2_17 = new Lane("K2_17", i++, 170); lines.add(K2_17);
        Lane K2_18 = new Lane("K2_18", i++, 45); lines.add(K2_18);
        
        Lane K3_1 = new Lane("K3_1", i++, 120); lines.add(K3_1); 
        Lane K3_2 = new Lane("K3_2", i++, 120); lines.add(K3_2);
        Lane K3_3 = new Lane("K3_3", i++, 120); lines.add(K3_3);
        Lane K3_4 = new Lane("K3_4", i++, 120); lines.add(K3_4);
        Lane K3_5 = new Lane("K3_5", i++, 120); lines.add(K3_5);
        Lane K3_6 = new Lane("K3_6", i++, 120); lines.add(K3_6);
        Lane K3_7 = new Lane("K3_7", i++, 150); lines.add(K3_7);
        Lane K3_8 = new Lane("K3_8", i++, 170); lines.add(K3_8); 
        Lane K3_9 = new Lane("K3_9", i++, 188); lines.add(K3_9);
        Lane K3_10 = new Lane("K3_10", i++, 230); lines.add(K3_10);
        Lane K3_11 = new Lane("K3_11", i++, 230); lines.add(K3_11);
        Lane K3_12 = new Lane("K3_12", i++, 23); lines.add(K3_12);
        Lane K3_13 = new Lane("K3_13", i++, 136); lines.add(K3_13);
        Lane K3_14 = new Lane("K3_14", i++, 159); lines.add(K3_14);
        Lane K3_15 = new Lane("K3_15", i++, 36); lines.add(K3_15);
        Lane K3_16 = new Lane("K3_16", i++, 210); lines.add(K3_16);
        Lane K3_17 = new Lane("K3_17", i++, 210); lines.add(K3_17);
        Lane K3_18 = new Lane("K3_18", i++, 162); lines.add(K3_18);
        
        //FLAGLER
        Lane K4_1 = new Lane("K4_1", i++, 140); lines.add(K4_1); 
        Lane K4_2 = new Lane("K4_2", i++, 140); lines.add(K4_2);
        Lane K4_3 = new Lane("K4_3", i++, 140); lines.add(K4_3);
        Lane K4_4 = new Lane("K4_4", i++, 140); lines.add(K4_4);
        Lane K4_5 = new Lane("K4_5", i++, 140); lines.add(K4_5);
        Lane K4_6 = new Lane("K4_6", i++, 140); lines.add(K4_6);
        Lane K4_7 = new Lane("K4_7", i++, 117); lines.add(K4_7);
        Lane K4_8 = new Lane("K4_8", i++, 45); lines.add(K4_8); 
        Lane K4_9 = new Lane("K4_9", i++, 128); lines.add(K4_9);
        Lane K4_10 = new Lane("K4_10", i++, 140); lines.add(K4_10);
        Lane K4_11 = new Lane("K4_11", i++, 140); lines.add(K4_11);
        Lane K4_12 = new Lane("K4_12", i++, 28); lines.add(K4_12);
        Lane K4_13 = new Lane("K4_13", i++, 121); lines.add(K4_13);
        Lane K4_14 = new Lane("K4_14", i++, 41); lines.add(K4_14);
        Lane K4_15 = new Lane("K4_15", i++, 140); lines.add(K4_15);
        Lane K4_16 = new Lane("K4_16", i++, 140); lines.add(K4_16);
        Lane K4_17 = new Lane("K4_17", i++, 106); lines.add(K4_17);
        
        Lane K5_1 = new Lane("K5_1", i++, 90); lines.add(K5_1); 
        Lane K5_2 = new Lane("K5_2", i++, 90); lines.add(K5_2);
        Lane K5_3 = new Lane("K5_3", i++, 90); lines.add(K5_3);
        Lane K5_4 = new Lane("K5_4", i++, 90); lines.add(K5_4);
        Lane K5_5 = new Lane("K5_5", i++, 90); lines.add(K5_5);
        Lane K5_6 = new Lane("K5_6", i++, 90); lines.add(K5_6);
        Lane K5_7 = new Lane("K5_7", i++, 106); lines.add(K5_7);
        Lane K5_8 = new Lane("K5_8", i++, 28); lines.add(K5_8); 
        Lane K5_9 = new Lane("K5_9", i++, 114); lines.add(K5_9);
        Lane K5_10 = new Lane("K5_10", i++, 140); lines.add(K5_10);
        Lane K5_11 = new Lane("K5_11", i++, 23); lines.add(K5_11);
        Lane K5_12 = new Lane("K5_12", i++, 106); lines.add(K5_12);
        Lane K5_13 = new Lane("K5_13", i++, 23); lines.add(K5_13);
        Lane K5_14 = new Lane("K5_14", i++, 140); lines.add(K5_14);
        Lane K5_15 = new Lane("K5_15", i++, 95); lines.add(K5_15);
        Lane K5_16 = new Lane("K5_16", i++, 14); lines.add(K5_16);
        
        Lane K6_1 = new Lane("K6_1", i++, 80); lines.add(K6_1); 
        Lane K6_2 = new Lane("K6_2", i++, 80); lines.add(K6_2);
        Lane K6_3 = new Lane("K6_3", i++, 80); lines.add(K6_3);
        Lane K6_4 = new Lane("K6_4", i++, 80); lines.add(K6_4);
        Lane K6_5 = new Lane("K6_5", i++, 80); lines.add(K6_5);
        Lane K6_6 = new Lane("K6_6", i++, 80); lines.add(K6_6);
        Lane K6_7 = new Lane("K6_7", i++, 99); lines.add(K6_7);
        Lane K6_8 = new Lane("K6_8", i++, 29); lines.add(K6_8); 
        Lane K6_9 = new Lane("K6_9", i++, 114); lines.add(K6_9);
        Lane K6_10 = new Lane("K6_10", i++, 140); lines.add(K6_10);
        Lane K6_11 = new Lane("K6_11", i++, 23); lines.add(K6_11);
        Lane K6_12 = new Lane("K6_12", i++, 100); lines.add(K6_12);
        Lane K6_13 = new Lane("K6_13", i++, 23); lines.add(K6_13);
        Lane K6_14 = new Lane("K6_14", i++, 140); lines.add(K6_14);
        Lane K6_15 = new Lane("K6_15", i++, 90); lines.add(K6_15);
        Lane K6_16 = new Lane("K6_16", i++, 14); lines.add(K6_16);
//</editor-fold> 
        System.out.println("Number of Lane objects: "+i);
//*************Springs*********
//<editor-fold defaultstate="collapsed" desc="SPRINGs">        
//Point is the 1st coordinate of the coresponding A lane
        LinkedList<Spring> springs = new LinkedList<Spring>();
        Spring SPA1_1 = new Spring(S, "SPA1_1", 39, new int[]{1}, new Point(90, 1380), A1_1); springs.add(SPA1_1);
        Spring SPA1_2 = new Spring(S, "SPA1_2", 40, new int[]{1}, new Point(90, 1400), A1_2); springs.add(SPA1_2);
        Spring SPA1_3 = new Spring(S, "SPA1_3", 41, new int[]{1}, new Point(90, 1420), A1_3); springs.add(SPA1_3);
        Spring SPA1_4 = new Spring(S, "SPA1_4", 42, new int[]{2}, new Point(90, 1440), A1_4); springs.add(SPA1_4);
        
        Spring SPA2_1 = new Spring(S, "SPA2_1", 43, new int[]{1,2}, new Point(400, 1650), A2_1); springs.add(SPA2_1);
        Spring SPA2_2 = new Spring(S, "SPA2_2", 44, new int[]{1}, new Point(420, 1650), A2_2); springs.add(SPA2_2);
        
        Spring SPA3_1 = new Spring(S, "SPA3_1", 45, new int[]{1,2}, new Point(930, 1650), A3_1); springs.add(SPA3_1);
        Spring SPA3_2 = new Spring(S, "SPA3_2", 46, new int[]{1}, new Point(950, 1650), A3_2); springs.add(SPA3_2);
        
        Spring SPA4_1 = new Spring(S, "SPA4_1", 47, new int[]{1,2}, new Point(1480, 1650), A4_1); springs.add(SPA4_1);
        Spring SPA4_2 = new Spring(S, "SPA4_2", 48, new int[]{1}, new Point(1500, 1650), A4_2); springs.add(SPA4_2);        
        
        Spring SPA5_1 = new Spring(S, "SPA5_1", 49, new int[]{1,2}, new Point(1820, 1230), A5_1); springs.add(SPA5_1);
        Spring SPA5_2 = new Spring(S, "SPA5_2", 50, new int[]{1}, new Point(1820, 1250), A5_2); springs.add(SPA5_2);
        Spring SPA5_3 = new Spring(S, "SPA5_3", 51, new int[]{1}, new Point(1820, 1270), A5_3); springs.add(SPA5_3);
        Spring SPA5_4 = new Spring(S, "SPA5_4", 52, new int[]{1}, new Point(1820, 1290), A5_4); springs.add(SPA5_4);
        
        //FLAGLER
        Spring SPA6_1 = new Spring(S, "SPA6_1", 53, new int[]{1}, new Point(1820, 290), A6_1); springs.add(SPA6_1);
        Spring SPA6_2 = new Spring(S, "SPA6_2", 54, new int[]{1}, new Point(1820, 310), A6_2); springs.add(SPA6_2);
        Spring SPA6_3 = new Spring(S, "SPA6_3", 55, new int[]{1}, new Point(1820, 330), A6_3); springs.add(SPA6_3);
        
        Spring SPA7_1 = new Spring(S, "SPA7_1", 56, new int[]{1}, new Point(1430, 100), A7_1); springs.add(SPA7_1);
        Spring SPA7_2 = new Spring(S, "SPA7_2", 57, new int[]{1}, new Point(1450, 100), A7_2); springs.add(SPA7_2);
        Spring SPA7_3 = new Spring(S, "SPA7_3", 58, new int[]{1}, new Point(1460, 100), A7_3); springs.add(SPA7_3);
        
        Spring SPA8_1 = new Spring(S, "SPA8_1", 59, new int[]{1}, new Point(870, 100), A8_1); springs.add(SPA8_1);
        
        Spring SPA9_1 = new Spring(S, "SPA9_1", 60, new int[]{1,2}, new Point(370, 100), A9_1); springs.add(SPA9_1);
        
        Spring SPA10_1 = new Spring(S, "SPA10_1", 61, new int[]{1,2}, new Point(150, 360), A10_1); springs.add(SPA10_1);
        Spring SPA10_2 = new Spring(S, "SPA10_2", 62, new int[]{1,2}, new Point(150, 380), A10_2); springs.add(SPA10_2);
        Spring SPA10_3 = new Spring(S, "SPA10_3", 63, new int[]{1,2}, new Point(150, 400), A10_3); springs.add(SPA10_3);
        
        Spring SPA11_1 = new Spring(S, "SPA11_1", 64, new int[]{1,2,3}, new Point(420, 630), A11_1); springs.add(SPA11_1);
//</editor-fold> 
        
//*************Sinks***********
//<editor-fold defaultstate="collapsed" desc="SINKs"> 
        //Point is the 2nd coordinate of the coresponding V lane
        LinkedList<Sink> sinks = new LinkedList<Sink>();
        // 8th Str
        Sink S_V1_1 = new Sink(S, "S_V1_1", 1, 2, new Point(90, 1250)); sinks.add(S_V1_1);
        Sink S_V1_2 = new Sink(S, "S_V1_2", 1, 1, new Point(90, 1270)); sinks.add(S_V1_2);
        Sink S_V1_3 = new Sink(S, "S_V1_3", 1, 1, new Point(90, 1290)); sinks.add(S_V1_3);
        
        Sink S_V2_1 = new Sink(S, "S_V2_1", 2, 1, new Point(330, 1650)); sinks.add(S_V2_1);
        Sink S_V2_2 = new Sink(S, "S_V2_2", 2, 1, new Point(350, 1650)); sinks.add(S_V2_2);
//        Sink S_V2_1 = new Sink(S, "S_V2_1", 2, 2, new Point(330, 1440)); sinks.add(S_V2_1);
//        Sink S_V2_2 = new Sink(S, "S_V2_2", 2, 3, new Point(350, 1440)); sinks.add(S_V2_2);
        
        Sink S_V3_1 = new Sink(S, "S_V3_1", 3, 3, new Point(850, 1650)); sinks.add(S_V3_1);
        Sink S_V3_2 = new Sink(S, "S_V3_2", 3, 3, new Point(870, 1650)); sinks.add(S_V3_2);
        
        Sink S_V4_1 = new Sink(S, "S_V4_1", 4, 1, new Point(1410, 1650)); sinks.add(S_V4_1);
        Sink S_V4_2 = new Sink(S, "S_V4_2", 4, 3, new Point(1430, 1650)); sinks.add(S_V4_2);
        Sink S_V4_3 = new Sink(S, "S_V4_3", 4, 3, new Point(1450, 1650)); sinks.add(S_V4_3);
        
        Sink S_V5_1 = new Sink(S, "S_V5_1", 5, 1, new Point(1820, 1380)); sinks.add(S_V5_1);
        Sink S_V5_2 = new Sink(S, "S_V5_2", 5, 1, new Point(1820, 1400)); sinks.add(S_V5_2);
        Sink S_V5_3 = new Sink(S, "S_V5_3", 5, 2, new Point(1820, 1420)); sinks.add(S_V5_3);
        
        //temp sinks
        //Sink S_M12_1 = new Sink(S, "S_M12_1", 12, 3, new Point(1480, 530)); sinks.add(S_M12_1);
        //Sink S_M12_2 = new Sink(S, "S_M12_2", 12, 3, new Point(1500, 1230)); sinks.add(S_M12_2);        
        //Sink S_M12_2 = new Sink(S, "S_M12_2", 12, 2, new Point(1500, 420)); sinks.add(S_M12_2);        
        //Sink S_M10_1 = new Sink(S, "S_M10_1", 10, 3, new Point(930, 530)); sinks.add(S_M10_1);
        
        //Flagler Str
      	Sink S_V6_1 = new Sink(S, "S_V6_1", 6, 1, new Point(1820, 360)); sinks.add(S_V6_1);
        Sink S_V6_2 = new Sink(S, "S_V6_2", 6, 1, new Point(1820, 380)); sinks.add(S_V6_2);
        Sink S_V6_3 = new Sink(S, "S_V6_3", 6, 1, new Point(1820, 400)); sinks.add(S_V6_3);
        
        Sink S_V7_1 = new Sink(S, "S_V7_1", 7, 2, new Point(1480, 100)); sinks.add(S_V7_1);
        Sink S_V7_2 = new Sink(S, "S_V7_2", 7, 1, new Point(1500, 100)); sinks.add(S_V7_2);
        Sink S_V7_3 = new Sink(S, "S_V7_3", 7, 1, new Point(1520, 100)); sinks.add(S_V7_3);
        
        Sink S_V8_1 = new Sink(S, "S_V8_1", 8, 1, new Point(930, 100)); sinks.add(S_V8_1);
        
        Sink S_V9_1 = new Sink(S, "S_V9_1", 9, 1, new Point(420, 100)); sinks.add(S_V9_1);
        
        Sink S_V10_1 = new Sink(S, "S_V10_1", 10, 1, new Point(150, 290)); sinks.add(S_V10_1);
        Sink S_V10_2 = new Sink(S, "S_V10_2", 10, 1, new Point(150, 310)); sinks.add(S_V10_2);
        Sink S_V10_3 = new Sink(S, "S_V10_3", 10, 1, new Point(150, 330)); sinks.add(S_V10_3);
        
        Sink S_V11_1 = new Sink(S, "S_V11_1", 11, 1, new Point(370, 630)); sinks.add(S_V11_1);
//</editor-fold>       
//************LineEnds*********
//<editor-fold defaultstate="collapsed" desc=" A Sections ">        
//Point is the 2nd coordinate of the coresponding lane
        int j = 1;
        LinkedList<LaneEnd> lineEnds = new LinkedList<LaneEnd>();
        // 8th Str
        Intersection leI_A1_1 = new Intersection(S, "leI_A1_1", new Point(300, 1380), K1_4, new int[]{1}); lineEnds.add(leI_A1_1);//S.lineEnds[0]
        Intersection leI_A1_2 = new Intersection(S, "leI_A1_2", new Point(300, 1400), K1_5, new int[]{1}); lineEnds.add(leI_A1_2);
        Intersection leI_A1_3 = new Intersection(S, "leI_A1_3", new Point(300, 1420), K1_6, new int[]{1}); lineEnds.add(leI_A1_3);
        //Dissection leD_A1_4 = new Dissection(S, j++, "leD_A1_4", new Point(330, 1440), new Lane[]{V2_1}, new int[]{1}, new int[]{1}); lineEnds.add(leD_A1_4);
        Intersection leI_A1_4 = new Intersection(S, "leI_A1_4", new Point(330,1440), V2_1, new int[]{1}, LaneEnd.LINEEND_GREEN); lineEnds.add(leI_A1_4);
               
        Junction leJ_A2_1 = new Junction(S, "leJ_A2_1", new Point(400, 1530), new Lane[]{M1_1, M1_2}, new int[]{1}); lineEnds.add(leJ_A2_1);
        Intersection leI_A2_2 = new Intersection(S,"leI_A2_2", new Point(420, 1440), M3_4, new int[]{1},LaneEnd.LINEEND_GREEN); lineEnds.add(leI_A2_2);//S.lineEnds[5]
        
        Junction leJ_A3_1 = new Junction(S, "leJ_A3_1", new Point(930, 1560), new Lane[]{M4_1, M4_2}, new int[]{1}); lineEnds.add(leJ_A3_1);
        Dissection leD_A3_2 = new Dissection(S, j++, "leD_A3_2", new Point(950, 1440), new Lane[]{M6_4}, new int[]{1}, new int[]{2}); lineEnds.add(leD_A3_2);
        
        Junction leJ_A4_1 = new Junction(S, "leJ_A4_1", new Point(1480, 1580), new Lane[]{M7_1, M7_2}, new int[]{1}); lineEnds.add(leJ_A4_1);       
        Junction leJ_A4_2 = new Junction(S, "leJ_A4_2", new Point(1500, 1450), new Lane[]{K3_11, K3_12}, new int[]{1}); lineEnds.add(leJ_A4_2);
                                                                                               
        Dissection leD_A5_1 = new Dissection(S, j++, "leD_A5_1", new Point(1500, 1230), new Lane[]{M12_2}, new int[]{1,2}, new int[]{1,2}); lineEnds.add(leD_A5_1);//S.lineEnds[10]
        Intersection leI_A5_2 = new Intersection(S, "leI_A5_2", new Point(1510, 1250), K3_1, new int[]{1}); lineEnds.add(leI_A5_2);
        Intersection leI_A5_3 = new Intersection(S, "leI_A5_3", new Point(1510, 1270), K3_2, new int[]{1}); lineEnds.add(leI_A5_3);
        Junction leJ_A5_4 = new Junction(S, "leJ_A5_4", new Point(1690, 1290), new Lane[]{M8_4_1, M8_4_2, M8_4_3}, new int[]{1,2,3}); lineEnds.add(leJ_A5_4);
      
      	//Flagler Str
        Dissection leD_A6_1 = new Dissection(S, j++, "leD_A6_1", new Point(1520, 290), new Lane[]{K4_1, V7_3}, new int[]{1}, new int[]{1}); lineEnds.add(leD_A6_1);
        Intersection leI_A6_2 = new Intersection(S, "leI_A6_2", new Point(1520, 310), K4_2, new int[]{1}); lineEnds.add(leI_A6_2); //S.lineEnds[15]
        Junction leJ_A6_3 = new Junction(S, "leJ_A6_3", new Point(1620, 330), new Lane[]{M13_3_1, M13_3_2}, new int[]{1,2}); lineEnds.add(leJ_A6_3);
        
        Junction leJ_A7_1 = new Junction(S, "leJ_A7_1", new Point(1430, 280), new Lane[]{K4_14, K4_15}, new int[]{1,2}); lineEnds.add(leJ_A7_1);
        Intersection leI_A7_2 = new Intersection(S, "leI_A7_2", new Point(1450, 280), K4_16, new int[]{2}); lineEnds.add(leI_A7_2);
        Intersection leI_A7_3 = new Intersection(S, "leI_A7_3", new Point(1460, 280), K4_17, new int[]{1}); lineEnds.add(leI_A7_3);
        
        Junction leJ_A8_1 = new Junction(S, "leJ_A8_1", new Point(870, 200), new Lane[]{M16_1_1, M16_1_2}, new int[]{1}); lineEnds.add(leJ_A8_1);//S.lineEnds[20]
        
        Junction leJ_A9_1 = new Junction(S, "leJ_A9_1", new Point(370, 230), new Lane[]{M19_1_1, M19_1_2}, new int[]{1,2}); lineEnds.add(leJ_A9_1);
        
        Junction leJ_A10_1 = new Junction(S, "leJ_A10_1", new Point(270, 360), new Lane[]{M20_1_1, M20_1_2}, new int[]{1,2}); lineEnds.add(leJ_A10_1);
        Intersection leI_A10_2 = new Intersection(S, "leI_A10_2", new Point(350, 380), K6_5, new int[]{1,2}); lineEnds.add(leI_A10_2);
        Junction leJ_A10_3 = new Junction(S, "leJ_A10_3", new Point(350, 400), new Lane[]{K6_6, K6_8}, new int[]{1,2}); lineEnds.add(leJ_A10_3);
        
        //Dissection leD_A11_1 = new Dissection(S, j++, "leD_A11_1", new Point(420, 420), new Lane[]{K6_9, K6_10, K6_11}, new int[]{1,2,3}, new int[]{1}); lineEnds.add(leD_A11_1);
        Junction leJ_A11_1 = new Junction(S, "leJ_A11_1", new Point(420, 420), new Lane[]{K6_9, K6_10, K6_11}, new int[]{1,2,3}); lineEnds.add(leJ_A11_1);//S.lineEnds[25]
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc=" M Sections ">
        
        //Dissection leD_M1_1 = new Dissection(S, j++, "leD_M1_1", new Point(380, 1440), new Lane[]{K1_7}, new int[]{1}, new int[]{1}); lineEnds.add(leD_M1_1);
        //Dissection leD_M1_2 = new Dissection(S, j++, "leD_M1_2", new Point(400, 1440), new Lane[]{K1_8}, new int[]{1}, new int[]{1}); lineEnds.add(leD_M1_2);
        Intersection leI_M1_1 = new Intersection(S, "leI_M1_1", new Point(380, 1440), K1_7, new int[]{1}); lineEnds.add(leI_M1_1);//S.lineEnds[26]
        Intersection leI_M1_2 = new Intersection(S, "leI_M1_2", new Point(400, 1440), K1_8, new int[]{1}); lineEnds.add(leI_M1_2);
        
        Intersection leI_M2_1 = new Intersection(S, "leI_M2_1", new Point(420, 1250), K1_1, new int[]{1}); lineEnds.add(leI_M2_1);
        Intersection leI_M2_2 = new Intersection(S, "leI_M2_2", new Point(420, 1270), K1_2, new int[]{1}); lineEnds.add(leI_M2_2);
        Junction leJ_M2_3 = new Junction(S, "leJ_M2_3", new Point(530, 1290), new Lane[]{M2_3_1, M2_3_2}, new int[]{1}); lineEnds.add(leJ_M2_3);//S.lineEnds[30]
        Intersection leI_M2_3_1 = new Intersection(S, "leI_M2_3_1", new Point(420, 1290), K1_3, new int[]{1}); lineEnds.add(leI_M2_3_1);
        Intersection leI_M2_3_2 = new Intersection(S, "leI_M2_3_2", new Point(420, 1310), K1_9, new int[]{1}); lineEnds.add(leI_M2_3_2);
        
        Junction leJ_M3_1 = new Junction(S, "leJ_M3_1", new Point(700, 1380), new Lane[]{M3_1_1, M3_1_2}, new int[]{1}); lineEnds.add(leJ_M3_1);
        Intersection leI_M3_2 = new Intersection(S, "leI_M3_2", new Point(850, 1400), K2_5, new int[]{1}); lineEnds.add(leI_M3_2);
        Intersection leI_M3_3 = new Intersection(S, "leI_M3_3", new Point(850, 1420), K2_6, new int[]{1}); lineEnds.add(leI_M3_3);//S.lineEnds[35]
        Junction leJ_M3_4 = new Junction(S, "leJ_M3_4", new Point(850, 1440), new Lane[]{K2_7, V3_1}, new int[]{1}); lineEnds.add(leJ_M3_4);
        Intersection leI_M3_1_1 = new Intersection(S, "leI_M3_1_1", new Point(850, 1360), K2_8, new int[]{1}); lineEnds.add(leI_M3_1_1);
        Intersection leI_M3_1_2 = new Intersection(S, "leI_M3_1_2", new Point(850, 1380), K2_4, new int[]{1}); lineEnds.add(leI_M3_1_2);
        
        //Dissection leD_M4_1 = new Dissection(S, j++, "leD_M4_1", new Point(910, 1460), new Lane[]{K2_9}, new int[]{1}, new int[]{2}); lineEnds.add(leD_M4_1);
        //Dissection leD_M4_2 = new Dissection(S, j++, "leD_M4_2", new Point(930, 1460), new Lane[]{K2_10, K2_11}, new int[]{1}, new int[]{1}); lineEnds.add(leD_M4_2);
        
        Intersection leI_M4_1 = new Intersection(S, "leI_M4_1", new Point(910, 1460), K2_9,  new int[]{1}); lineEnds.add(leI_M4_1);
        Junction leJ_M4_2 = new Junction(S, "leJ_M4_2", new Point(930, 1460), new Lane[]{K2_10,K2_11}, new int[]{1}); lineEnds.add(leJ_M4_2);//S.lineEnds[40]
        
        Junction leJ_M5_1 = new Junction(S, "leJ_M5_1", new Point(970, 1250), new Lane[]{K2_1,K2_18}, new int[]{1}); lineEnds.add(leJ_M5_1);
        Intersection leI_M5_2 = new Intersection(S, "leI_M5_2", new Point(970, 1270), K2_2, new int[]{1}); lineEnds.add(leI_M5_2);
        Junction leJ_M5_3 = new Junction(S, "leJ_M5_3", new Point(1110, 1290), new Lane[]{M5_3_1, M5_3_2, M5_3_3}, new int[]{1,2,3}); lineEnds.add(leJ_M5_3);
        Intersection leI_M5_3_1 = new Intersection(S, "leI_M5_3_1", new Point(970, 1290), K2_3, new int[]{1}); lineEnds.add(leI_M5_3_1);
        Intersection leI_M5_3_2 = new Intersection(S, "leI_M5_3_2", new Point(970, 1310), K2_13, new int[]{1}); lineEnds.add(leI_M5_3_2);//S.lineEnds[45]
        Intersection leI_M5_3_3 = new Intersection(S, "leI_M5_3_3", new Point(970, 1330), K2_12, new int[]{1}); lineEnds.add(leI_M5_3_3);
        
        Junction leJ_M6_1 = new Junction(S, "leJ_M6_1", new Point(1180, 1380), new Lane[]{M6_1_1, M6_1_2, M6_1_3}, new int[]{1,2,3}); lineEnds.add(leJ_M6_1);
        Intersection leI_M6_2 = new Intersection(S, "leI_M6_2", new Point(1390, 1400), K3_5, new int[]{1}); lineEnds.add(leI_M6_2);
        Intersection leI_M6_3 = new Intersection(S, "leI_M6_3", new Point(1390, 1420), K3_6, new int[]{1}); lineEnds.add(leI_M6_3);
        Intersection leI_M6_4 = new Intersection(S, "leI_M6_4", new Point(1410, 1440), V4_1, new int[]{1}); lineEnds.add(leI_M6_4);//S.lineEnds[50]
        //Dissection leD_M6_1_1 = new Dissection(S, j++, "leD_M6_1_1", new Point(1390, 1350), new Lane[]{K3_7}, new int[]{1}, new int[]{1}); lineEnds.add(leD_M6_1_1);
        //Dissection leD_M6_1_2 = new Dissection(S, j++, "leD_M6_1_2", new Point(1390, 1365), new Lane[]{K3_8}, new int[]{1}, new int[]{1}); lineEnds.add(leD_M6_1_2);
        Intersection leI_M6_1_1 = new Intersection(S, "leI_M6_1_1", new Point(1390, 1350), K3_7, new int[]{1}); lineEnds.add(leI_M6_1_1);
        Intersection leI_M6_1_2 = new Intersection(S, "leI_M6_1_2", new Point(1390, 1365), K3_8, new int[]{1}); lineEnds.add(leI_M6_1_2);
        Intersection leI_M6_1_3 = new Intersection(S, "leI_M6_1_3", new Point(1390, 1380), K3_4, new int[]{1}); lineEnds.add(leI_M6_1_3);
        
        Intersection leI_M7_1 = new Intersection(S, "leI_M7_1", new Point(1460, 1460), K3_9, new int[]{1}); lineEnds.add(leI_M7_1);
        Intersection leI_M7_2 = new Intersection(S, "leI_M7_2", new Point(1480, 1460), K3_10, new int[]{1}); lineEnds.add(leI_M7_2);//S.lineEnds[55]
                                                                                            
        Intersection leI_M8_4_1 = new Intersection(S, "leI_M8_4_1", new Point(1510, 1290), K3_3, new int[]{1}); lineEnds.add(leI_M8_4_1);
        //Dissection leD_M8_4_2 = new Dissection(S, j++, "leD_M8_4_2", new Point(1510, 1310), new Lane[]{K3_14}, new int[]{1}, new int[]{1}); lineEnds.add(leD_M8_4_2);
        //Dissection leD_M8_4_3 = new Dissection(S, j++, "leD_M8_4_3", new Point(1510, 1330), new Lane[]{K3_13}, new int[]{1}, new int[]{1}); lineEnds.add(leD_M8_4_3);
        Intersection leI_M8_4_2 = new Intersection(S, "leI_M8_4_2", new Point(1510, 1310),K3_14, new int[]{1}); lineEnds.add(leI_M8_4_2);
        Intersection leI_M8_4_3 = new Intersection(S, "leI_M8_4_3", new Point(1510, 1330), K3_13, new int[]{1}); lineEnds.add(leI_M8_4_3);
        
        Junction leJ_M9_1 = new Junction(S, "leJ_M9_1", new Point(870, 1170), new Lane[]{M9_1_1, M9_1_2, M9_1_3}, new int[]{1}); lineEnds.add(leJ_M9_1);
        Intersection leI_M9_1_1 = new Intersection(S, "leI_M9_1_1", new Point(860, 1230), K2_14, new int[]{1}); lineEnds.add(leI_M9_1_1);//S.lineEnds[60]
        Junction leJ_M9_1_2 = new Junction(S, "leJ_M9_1_2", new Point(870, 1230), new Lane[]{K2_15, K2_16}, new int[]{1}); lineEnds.add(leJ_M9_1_2);
        Intersection leI_M9_1_3 = new Intersection(S, "leI_M9_1_3", new Point(890, 1230), K2_17, new int[]{1}); lineEnds.add(leI_M9_1_3);
        //Dissection leD_M9_1_4 = new Dissection(S, j++, "leD_M9_1_4", new Point(870, 1190), new Lane[]{M9_1_1, M9_1_2}, new int[]{1, 2}, new int[]{1}); lineEnds.add(leD_M9_1_4);
       
        Junction leJ_M10_1 = new Junction(S, "leJ_M10_1", new Point(930, 530), new Lane[]{M10_1_1, M10_1_2}, new int[]{1,2}); lineEnds.add(leJ_M10_1);
        Intersection leI_M10_1_1 = new Intersection(S, "leI_M10_1_1", new Point(910, 420), K5_9, new int[]{2}); lineEnds.add(leI_M10_1_1);
        Junction leJ_M10_1_2 = new Junction(S, "leJ_M10_1_2", new Point(930, 420), new Lane[]{K5_10, K5_11}, new int[]{1,2}); lineEnds.add(leJ_M10_1_2);//S.lineEnds[65]
        
        Junction leJ_M11_1 = new Junction(S, "leJ_M11_1", new Point(1430, 1230), new Lane[]{K3_16, K3_15 }, new int[]{1}); lineEnds.add(leJ_M11_1);
        Junction leJ_M11_2 = new Junction(S, "leJ_M11_2", new Point(1450, 1090), new Lane[]{M11_2_1,M11_2_2 }, new int[]{1}); lineEnds.add(leJ_M11_2);
        Intersection leI_M11_2_1 = new Intersection(S, "leI_M11_2_1", new Point(1450, 1230), K3_17, new int[]{1}); lineEnds.add(leI_M11_2_1);
        Intersection leI_M11_2_2 = new Intersection(S, "leI_M11_2_2", new Point(1465, 1230), K3_18, new int[]{1}); lineEnds.add(leI_M11_2_2);
      
      	Junction leJ_M12_1 = new Junction(S, "leJ_M12_1", new Point(1480, 530), new Lane[]{M12_1_1, M12_1_2  }, new int[]{1,2}); lineEnds.add(leJ_M12_1);//S.lineEnds[70]
        Junction leJ_M12_2 = new Junction(S, "leJ_M12_2", new Point(1500, 420), new Lane[]{K4_11, K4_12}, new int[]{1,2}); lineEnds.add(leJ_M12_2);
        Intersection leI_M12_1_1 = new Intersection(S, "leI_M12_1_1", new Point(1470, 420), K4_9, new int[]{1}); lineEnds.add(leI_M12_1_1);
        Intersection leI_M12_1_2 = new Intersection(S, "leI_M12_1_2", new Point(1480, 420), K4_10, new int[]{2}); lineEnds.add(leI_M12_1_2);

        Intersection leI_M13_3_1 = new Intersection(S, "leI_M13_3_1", new Point(1520, 330), K4_3, new int[]{1}); lineEnds.add(leI_M13_3_1);
        Intersection leI_M13_3_2 = new Intersection(S, "leI_M13_3_2", new Point(1520, 345), K4_13, new int[]{2}); lineEnds.add(leI_M13_3_2);//S.lineEnds[75]
        
        Junction leJ_M14_1 = new Junction(S, "leJ_M14_1", new Point(1280, 360), new Lane[]{M14_1_1, M14_1_2}, new int[]{1,2}); lineEnds.add(leJ_M14_1);
        Intersection leI_M14_2 = new Intersection(S, "leI_M14_2", new Point(1380, 380), K4_5, new int[]{1,2}); lineEnds.add(leI_M14_2);
        Junction leJ_M14_3 = new Junction(S, "leJ_M14_3", new Point(1380, 400), new Lane[]{K4_6, K4_8}, new int[]{1,2}); lineEnds.add(leJ_M14_3);
      	Intersection leI_M14_1_1 = new Intersection(S, "leI_M14_1_1", new Point(1380, 345), K4_7, new int[]{2}); lineEnds.add(leI_M14_1_1);
        Intersection leI_M14_1_2 = new Intersection(S, "leI_M14_1_2", new Point(1380, 360), K4_4, new int[]{1,2}); lineEnds.add(leI_M14_1_2);//S.lineEnds[80]
      
      	Junction leJ_M15_1 = new Junction(S, "leJ_M15_1", new Point(940, 290), new Lane[]{K5_1, K5_16}, new int[]{1,2}); lineEnds.add(leJ_M15_1);
        Intersection leI_M15_2 = new Intersection(S, "leI_M15_2", new Point(940, 310), K5_2, new int[]{1,2}); lineEnds.add(leI_M15_2);
        Junction leJ_M15_3 = new Junction(S,"leJ_M15_3", new Point(1000, 330), new Lane[]{M15_3_1, M15_3_2}, new int[]{1,2}); lineEnds.add(leJ_M15_3);
      	Intersection leI_M15_3_1 = new Intersection(S, "leI_M15_3_1", new Point(940, 330), K5_3, new int[]{1}); lineEnds.add(leI_M15_3_1);
        Intersection leI_M15_3_2 = new Intersection(S, "leI_M15_3_2", new Point(940, 340), K5_12, new int[]{2}); lineEnds.add(leI_M15_3_2);//S.lineEnds[85]
        
        Junction leJ_M16_1_1 = new Junction(S, "leJ_M16_1_1", new Point(870, 280), new Lane[]{K5_13, K5_14 }, new int[]{1,2}); lineEnds.add(leJ_M16_1_1);
        Intersection leI_M16_1_2 = new Intersection(S, "leI_M16_1_2", new Point(890, 280), K5_15, new int[]{1}); lineEnds.add(leI_M16_1_2);
        
        Junction leJ_M17_1 = new Junction(S, "leJ_M17_1", new Point(770, 360), new Lane[]{M17_1_1, M17_1_2 }, new int[]{1,2}); lineEnds.add(leJ_M17_1);
        Intersection leI_M17_2 = new Intersection(S, "leI_M17_2", new Point(850, 380), K5_5, new int[]{1,2}); lineEnds.add(leI_M17_2);
        Junction leJ_M17_3 = new Junction(S, "leJ_M17_3", new Point(850, 400), new Lane[]{K5_6, K5_8}, new int[]{1,2}); lineEnds.add(leJ_M17_3);//S.lineEnds[90]
      	Intersection leI_M17_1_1 = new Intersection(S, "leI_M17_1_1", new Point(850, 350), K5_7, new int[]{2}); lineEnds.add(leI_M17_1_1);
        Intersection leI_M17_1_2 = new Intersection(S, "leI_M17_1_2", new Point(850, 360), K5_4, new int[]{1,2}); lineEnds.add(leI_M17_1_2);
        
        Junction leJ_M18_1 = new Junction(S, "leJ_M18_1", new Point(430, 290), new Lane[]{K6_1, K6_16}, new int[]{1,2}); lineEnds.add(leJ_M18_1);
        Intersection leI_M18_2 = new Intersection(S, "leI_M18_2", new Point(430, 310), K6_2, new int[]{1,2}); lineEnds.add(leI_M18_2);
        Junction leJ_M18_3 = new Junction(S, "leJ_M18_3", new Point(500, 330), new Lane[]{M18_3_1, M18_3_2}, new int[]{1,2}); lineEnds.add(leJ_M18_3);//S.lineEnds[95]
      	Intersection leI_M18_3_1 = new Intersection(S, "leI_M18_3_1", new Point(430, 330), K6_3, new int[]{1}); lineEnds.add(leI_M18_3_1);
        Intersection leI_M18_3_2 = new Intersection(S, "leI_M18_3_2", new Point(430, 340), K6_12, new int[]{2}); lineEnds.add(leI_M18_3_2);
        
        Junction leJ_M19_1_1 = new Junction(S, "leJ_M19_1_1", new Point(370, 280), new Lane[]{K6_13, K6_14}, new int[]{1,2}); lineEnds.add(leJ_M19_1_1);
        Intersection leI_M19_1_2 = new Intersection(S, "leI_M19_1_2", new Point(390, 280), K6_15, new int[]{1,2}); lineEnds.add(leI_M19_1_2);
        
        Intersection leI_M20_1_1 = new Intersection(S, "leI_M20_1_1", new Point(350, 350), K6_7, new int[]{2,1}); lineEnds.add(leI_M20_1_1);//S.lineEnds[100]
        Intersection leI_M20_1_2 = new Intersection(S, "leI_M20_1_2", new Point(350, 360), K6_4, new int[]{1,2}); lineEnds.add(leI_M20_1_2);
        
//</editor-fold>  
//<editor-fold defaultstate="collapsed" desc=" K Sections ">       
        Intersection leI_K1_1 = new Intersection(S, "leI_K1_1", new Point(300, 1250), V1_1, new int[]{1}); lineEnds.add(leI_K1_1);//S.lineEnds[102]
        Dissection leD_K1_2 = new Dissection(S, j++, "leD_K1_2", new Point(300, 1270), new Lane[]{V1_2}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K1_2);
        Dissection leD_K1_3 = new Dissection(S, j++, "leD_K1_3", new Point(300, 1290), new Lane[]{V1_3}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K1_3);
        Intersection leI_K1_4 = new Intersection(S, "leI_K1_4", new Point(420, 1380), M3_1, new int[]{1}); lineEnds.add(leI_K1_4);//S.lineEnds[105]
        Intersection leI_K1_5 = new Intersection(S, "leI_K1_5", new Point(420, 1400), M3_2, new int[]{1}); lineEnds.add(leI_K1_5);
        Intersection leI_K1_6 = new Intersection(S, "leI_K1_6", new Point(420, 1420), M3_3, new int[]{1}); lineEnds.add(leI_K1_6);
        Dissection leD_K1_7 = new Dissection(S, j++, "leD_K1_7", new Point(300, 1290), new Lane[]{V1_3}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K1_7);
        Dissection leD_K1_8 = new Dissection(S, j++, "leD_K1_8", new Point(300, 1270), new Lane[]{V1_2}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K1_8);
        //Dissection leD_K1_9 = new Dissection(S, j++, "leD_K1_9", new Point(350, 1440), new Lane[]{V2_2}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K1_9);
        Intersection leI_K1_9 = new Intersection(S, "leI_K1_9", new Point(350, 1440), V2_2, new int[]{1}); lineEnds.add(leI_K1_9);//S.lineEnds[110]
        
        Dissection leD_K2_1 = new Dissection(S, j++, "leD_K2_1", new Point(850, 1250), new Lane[]{M2_1}, new int[]{1}, new int[]{2}); lineEnds.add(leD_K2_1);
        Dissection leD_K2_2 = new Dissection(S, j++, "leD_K2_2", new Point(850, 1270), new Lane[]{M2_2}, new int[]{1}, new int[]{1,2}); lineEnds.add(leD_K2_2);
        Dissection leD_K2_3 = new Dissection(S, j++, "leD_K2_3", new Point(850, 1290), new Lane[]{M2_3}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K2_3);
        Dissection leD_K2_4 = new Dissection(S, j++, "leD_K2_4", new Point(970, 1380), new Lane[]{M6_1}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K2_4);
        Dissection leD_K2_5 = new Dissection(S, j++, "leD_K2_5", new Point(970, 1400), new Lane[]{M6_2}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K2_5);//S.lineEnds[115]
        Intersection leI_K2_6 = new Intersection(S, "leI_K2_6", new Point(970, 1420), M6_3, new int[]{1}); lineEnds.add(leI_K2_6);
        Intersection leI_K2_7 = new Intersection(S, "leI_K2_7", new Point(950, 1440), M6_4, new int[]{1}); lineEnds.add(leI_K2_7);
        //Dissection leD_K2_7 = new Dissection(S, j++, "leD_K2_7", new Point(950, 1440), new Lane[]{M6_4}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K2_7);
        Dissection leD_K2_8 = new Dissection(S, j++, "leD_K2_8", new Point(930, 1230), new Lane[]{M10_1}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K2_8);
        Dissection leD_K2_9 = new Dissection(S, j++, "leD_K2_9", new Point(850, 1290), new Lane[]{M2_3}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K2_9);
        Dissection leD_K2_10 = new Dissection(S, j++, "leD_K2_10", new Point(850, 1270), new Lane[]{M2_2}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K2_10);//S.lineEnds[120]
        Junction leJ_K2_11 = new Junction(S, "leJ_K2_11", new Point(930, 1230), new Lane[]{M10_1}, new int[]{1}); lineEnds.add(leJ_K2_11);
        Junction leJ_K2_12 = new Junction(S, "leJ_K2_12", new Point(870, 1460), new Lane[]{V3_2}, new int[]{1}); lineEnds.add(leJ_K2_12);
        Junction leJ_K2_13 = new Junction(S, "leJ_K2_13", new Point(850, 1440), new Lane[]{V3_1}, new int[]{1}); lineEnds.add(leJ_K2_13);
        Intersection leI_K2_13 = new Intersection(S, "leI_K2_13", new Point(850, 1440), V3_1, new int[]{1}); lineEnds.add(leI_K2_13);/////////////#124
        Dissection leD_K2_14 = new Dissection(S, j++, "leD_K2_14", new Point(850, 1250), new Lane[]{M2_1}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K2_14);
        Junction leJ_K2_15 = new Junction(S, "leJ_K2_15", new Point(870, 1460), new Lane[]{V3_2}, new int[]{1}); lineEnds.add(leJ_K2_15);//S.lineEnds[125]
        Dissection leD_K2_16 = new Dissection(S, j++, "leD_K2_16", new Point(970, 1400), new Lane[]{M6_2}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K2_16);
        Dissection leD_K2_17 = new Dissection(S, j++, "leD_K2_17", new Point(970, 1380), new Lane[]{M6_1}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K2_17);
        Junction leJ_K2_18 = new Junction(S, "leJ_K2_18", new Point(930, 1230), new Lane[]{M10_1}, new int[]{1}); lineEnds.add(leJ_K2_18);
        
        Dissection leD_K3_1 = new Dissection(S, j++, "leD_K3_1", new Point(1390, 1250), new Lane[]{M5_1}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K3_1);
        Intersection leI_K3_2 = new Intersection(S, "leI_K3_2", new Point(1390, 1270), M5_2, new int[]{1}); lineEnds.add(leI_K3_2);//S.lineEnds[130]
        Dissection leD_K3_3 = new Dissection(S, j++, "leD_K3_3", new Point(1390, 1290), new Lane[]{M5_3}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K3_3);
        Dissection leD_K3_4 = new Dissection(S, j++, "leD_K3_4", new Point(1510, 1380), new Lane[]{V5_1}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K3_4);
        Intersection leI_K3_5 = new Intersection(S, "leI_K3_5", new Point(1510, 1400), V5_2, new int[]{1}); lineEnds.add(leI_K3_5);
        Dissection leD_K3_6 = new Dissection(S, j++, "leD_K3_6", new Point(1510, 1420), new Lane[]{V5_3}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K3_6);
        Dissection leD_K3_7 = new Dissection(S, j++, "leD_K3_7", new Point(1480, 1230), new Lane[]{M12_1}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K3_7);//S.lineEnds[135]
        Dissection leD_K3_8 = new Dissection(S, j++, "leD_K3_8", new Point(1500, 1230), new Lane[]{M12_2}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K3_8);
        Dissection leD_K3_9 = new Dissection(S, j++, "leD_K3_9", new Point(1390, 1290), new Lane[]{M5_3}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K3_9);
        Dissection leD_K3_10 = new Dissection(S, j++, "leD_K3_10", new Point(1480, 1230), new Lane[]{M12_1}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K3_10);
        Dissection leD_K3_11 = new Dissection(S, j++, "leD_K3_11", new Point(1500, 1230), new Lane[]{M12_2}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K3_11);
        Dissection leD_K3_12 = new Dissection(S, j++, "leD_K3_12", new Point(1510, 1420), new Lane[]{V5_3}, new int[]{1,2}, new int[]{2}); lineEnds.add(leD_K3_12);//S.lineEnds[140]
        Dissection leD_K3_13 = new Dissection(S, j++, "leD_K3_13", new Point(1450, 1440), new Lane[]{V4_3}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K3_13);
        Dissection leD_K3_14 = new Dissection(S, j++, "leD_K3_14", new Point(1430, 1440), new Lane[]{V4_2}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K3_14);
        Dissection leD_K3_15 = new Dissection(S, j++, "leD_K3_15", new Point(1390, 1250), new Lane[]{M5_1}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K3_15);
        Dissection leD_K3_16 = new Dissection(S, j++, "leD_K3_16", new Point(1430, 1440), new Lane[]{V4_2}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K3_16);
        Dissection leD_K3_17 = new Dissection(S, j++, "leD_K3_17", new Point(1450, 1440), new Lane[]{V4_3}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K3_17);//S.lineEnds[145]
        Dissection leD_K3_18 = new Dissection(S, j++, "leD_K3_18", new Point(1510, 1380), new Lane[]{V5_1}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K3_18);
      
      	Dissection leD_K4_1 = new Dissection(S, j++, "leD_K4_1", new Point(1380, 290), new Lane[]{M15_1}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K4_1);
        Intersection leI_K4_2 = new Intersection(S, "leI_K4_2", new Point(1380, 310), M15_2, new int[]{1}); lineEnds.add(leI_K4_2);
        Dissection leD_K4_3 = new Dissection(S, j++, "leD_K4_3", new Point(1380, 330), new Lane[]{M15_3}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K4_3);
        Dissection leD_K4_4 = new Dissection(S, j++, "leD_K4_4", new Point(1520, 360), new Lane[]{V6_1}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K4_4);//S.lineEnds[150]
        Intersection leI_K4_5 = new Intersection(S, "leI_K4_5", new Point(1520, 380), V6_2, new int[]{1}); lineEnds.add(leI_K4_5);
        Dissection leD_K4_6 = new Dissection(S, j++, "leD_K4_6", new Point(1520, 400), new Lane[]{V6_3}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K4_6);
        Dissection leD_K4_7 = new Dissection(S, j++, "leD_K4_7", new Point(1480, 280), new Lane[]{V7_1}, new int[]{2}, new int[]{1}); lineEnds.add(leD_K4_7);
        Dissection leD_K4_8 = new Dissection(S, j++, "leD_K4_8", new Point(1430, 420), new Lane[]{M11_1}, new int[]{1,2}, new int[]{1,2}); lineEnds.add(leD_K4_8);
        Dissection leD_K4_9 = new Dissection(S, j++, "leD_K4_9", new Point(1380, 330), new Lane[]{M15_3}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K4_9);//S.lineEnds[155]
        Dissection leD_K4_10 = new Dissection(S, j++, "leD_K4_10", new Point(1480, 280), new Lane[]{V7_1}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K4_10);
        Intersection leI_K4_11 = new Intersection(S, "leI_K4_11", new Point(1500, 280), V7_2, new int[]{1}); lineEnds.add(leI_K4_11);
        Dissection leD_K4_12 = new Dissection(S, j++, "leD_K4_12", new Point(1520, 400), new Lane[]{V6_3}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K4_12);
        Dissection leD_K4_13 = new Dissection(S, j++, "leD_K4_13", new Point(1450, 420), new Lane[]{M11_2}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K4_13);
        Dissection leD_K4_14 = new Dissection(S, j++, "leD_K4_14", new Point(1380, 290), new Lane[]{M15_1}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K4_14);//S.lineEnds[160]
        Dissection leD_K4_15 = new Dissection(S, j++, "leD_K4_15", new Point(1430, 420), new Lane[]{M11_1}, new int[]{1,2}, new int[]{1,2}); lineEnds.add(leD_K4_15);
        Dissection leD_K4_16 = new Dissection(S, j++, "leD_K4_16", new Point(1450, 420), new Lane[]{M11_2}, new int[]{1,2}, new int[]{3}); lineEnds.add(leD_K4_16);
        Dissection leD_K4_17 = new Dissection(S, j++, "leD_K4_17", new Point(1520, 360), new Lane[]{V6_1}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K4_17);
        
        Dissection leD_K5_1 = new Dissection(S, j++, "leD_K5_1", new Point(850, 290), new Lane[]{M18_1}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K5_1);
        Intersection leI_K5_2 = new Intersection(S, "leI_K5_2", new Point(850, 310), M18_2, new int[]{1}); lineEnds.add(leI_K5_2);//S.lineEnds[165]
        Dissection leD_K5_3 = new Dissection(S, j++, "leD_K5_3", new Point(850, 330), new Lane[]{M18_3}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K5_3);
        Dissection leD_K5_4 = new Dissection(S, j++, "leD_K5_4", new Point(940, 360), new Lane[]{M14_1}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K5_4);
        Intersection leI_K5_5 = new Intersection(S, "leI_K5_5", new Point(940, 380), M14_2, new int[]{1}); lineEnds.add(leI_K5_5);
        Dissection leD_K5_6 = new Dissection(S, j++, "leD_K5_6", new Point(940, 400), new Lane[]{M14_3}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K5_6);
        Junction leJ_K5_7 = new Junction(S, "leJ_K5_7", new Point(930, 280), new Lane[]{V8_1}, new int[]{3}); lineEnds.add(leJ_K5_7);//S.lineEnds[170]
        Junction leJ_K5_8 = new Junction(S, "leJ_K5_8", new Point(870, 420), new Lane[]{M9_1}, new int[]{1}); lineEnds.add(leJ_K5_8);
        Dissection leD_K5_9 = new Dissection(S, j++, "leD_K5_9", new Point(850, 330), new Lane[]{M18_3}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K5_9);
        Junction leJ_K5_10 = new Junction(S, "leJ_K5_10", new Point(930, 280), new Lane[]{V8_1}, new int[]{1}); lineEnds.add(leJ_K5_10);
        Dissection leD_K5_11 = new Dissection(S, j++, "leD_K5_11", new Point(940, 400), new Lane[]{M14_3}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K5_11);
        Junction leJ_K5_12 = new Junction(S,"leJ_K5_12", new Point(870, 420), new Lane[]{M9_1}, new int[]{1}); lineEnds.add(leJ_K5_12);//S.lineEnds[175]
        Dissection leD_K5_13 = new Dissection(S, j++, "leD_K5_13", new Point(850, 290), new Lane[]{M18_1}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K5_13);
        Junction leJ_K5_14 = new Junction(S, "leJ_K5_14", new Point(870, 420), new Lane[]{M9_1}, new int[]{1}); lineEnds.add(leJ_K5_14);
        Dissection leD_K5_15 = new Dissection(S, j++, "leD_K5_15", new Point(940, 360), new Lane[]{M14_1}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K5_15);
        Junction leJ_K5_16 = new Junction(S, "leJ_K5_16", new Point(930, 280), new Lane[]{V8_1}, new int[]{1}); lineEnds.add(leJ_K5_16);
        
        Dissection leD_K6_1 = new Dissection(S, j++, "leD_K6_1", new Point(350, 290), new Lane[]{V10_1}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K6_1);//S.lineEnds[180]
        Intersection leI_K6_2 = new Intersection(S, "leI_K6_2", new Point(350, 310), V10_2, new int[]{1}); lineEnds.add(leI_K6_2);
        Dissection leD_K6_3 = new Dissection(S, j++, "leD_K6_3", new Point(350, 330), new Lane[]{V10_3}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K6_3);
        Dissection leD_K6_4 = new Dissection(S, j++, "leD_K6_4", new Point(430, 360), new Lane[]{M17_1}, new int[]{1,2}, new int[]{1}); lineEnds.add(leD_K6_4);//j=60
        Intersection leI_K6_5 = new Intersection(S, "leI_K6_5", new Point(430, 380), M17_2, new int[]{1,2}); lineEnds.add(leI_K6_5);
        Dissection leD_K6_6 = new Dissection(S, j++, "leD_K6_6", new Point(430, 400), new Lane[]{M17_3}, new int[]{1,2}, new int[]{1,2}); lineEnds.add(leD_K6_6);//S.lineEnds[185]
        Dissection leD_K6_7 = new Dissection(S, j++, "leD_K6_7", new Point(420, 280), new Lane[]{V9_1}, new int[]{2}, new int[]{1}); lineEnds.add(leD_K6_7);
        Junction leJ_K6_8 = new Junction(S, "leJ_K6_8", new Point(370, 420), new Lane[]{V11_1}, new int[]{2}); lineEnds.add(leJ_K6_8);
        Dissection leD_K6_9 = new Dissection(S, j++, "leD_K6_9", new Point(350, 330), new Lane[]{V10_3}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K6_9);
        Junction leJ_K6_10 = new Junction(S, "leJ_K6_10", new Point(420, 280), new Lane[]{V9_1}, new int[]{1}); lineEnds.add(leJ_K6_10);
        Dissection leD_K6_11 = new Dissection(S, j++, "leD_K6_11", new Point(430, 400), new Lane[]{M17_3}, new int[]{1}, new int[]{1}); lineEnds.add(leD_K6_11);//S.lineEnds[190]
        Junction leJ_K6_12 = new Junction(S, "leJ_K6_12", new Point(370, 420), new Lane[]{V11_1}, new int[]{1}); lineEnds.add(leJ_K6_12);
        Dissection leD_K6_13 = new Dissection(S, j++, "leD_K6_13", new Point(350, 290), new Lane[]{V10_1}, new int[]{2}, new int[]{1}); lineEnds.add(leD_K6_13);
        Junction leJ_K6_14 = new Junction(S, "leJ_K6_14", new Point(370, 420), new Lane[]{V11_1}, new int[]{1,2}); lineEnds.add(leJ_K6_14);
        Dissection leD_K6_15 = new Dissection(S, j++, "leD_K6_15", new Point(430, 360), new Lane[]{M17_1}, new int[]{1,2}, new int[]{1}); lineEnds.add(leD_K6_15);
        Junction leD_K6_16 = new Junction(S, "leJ_K6_16", new Point(420, 280), new Lane[]{V9_1}, new int[]{1}); lineEnds.add(leD_K6_16);//S.lineEnds[195]
      	
//</editor-fold> 
        System.out.println("Number of Dissections: "+j);       
//******EndPoints & Neighbourhood*******
//<editor-fold defaultstate="collapsed" desc=" A LaneEnds">
//defines lane switching possibilities
//          (Left Lane, Right Lane, EndPoint)        
        A1_1.set_N_eP(null, A1_2, leI_A1_1); //0
        A1_2.set_N_eP(A1_1, A1_3, leI_A1_2);
        A1_3.set_N_eP(A1_2, A1_4, leI_A1_3);
        A1_4.set_N_eP(A1_3, null, leI_A1_4); 
              
        A2_1.set_N_eP(null, A2_2, leJ_A2_1);        
        A2_2.set_N_eP(A2_1, null, leI_A2_2);
        
        A3_1.set_N_eP(null, A3_2, leJ_A3_1);        
        A3_2.set_N_eP(A3_1, null, leD_A3_2);
        
        A4_1.set_N_eP(null, A4_2, leJ_A4_1);      
        A4_2.set_N_eP(A4_1, null, leJ_A4_2);
        
        A5_1.set_N_eP(A5_2, null, leD_A5_1); 
        A5_2.set_N_eP(A5_3, A5_1, leI_A5_2);
        A5_3.set_N_eP(A5_4, A5_2, leI_A5_3);
        A5_4.set_N_eP(null, A5_3, leJ_A5_4);
        
        //FLAGLER
        A6_1.set_N_eP(A6_2, null, leD_A6_1);
        A6_2.set_N_eP(A6_3, A6_1, leI_A6_2);
        A6_3.set_N_eP(null, A6_2, leJ_A6_3);

        A7_1.set_N_eP(A7_2, null, leJ_A7_1);
        A7_2.set_N_eP(A7_3, A7_1, leI_A7_2);
        A7_3.set_N_eP(null, A7_2, leI_A7_3);

        A8_1.set_N_eP(null, null, leJ_A8_1);

        A9_1.set_N_eP(null, null, leJ_A9_1);

        A10_1.set_N_eP(null, A10_2, leJ_A10_1);
        A10_2.set_N_eP(A10_1, A10_2, leI_A10_2);
        A10_3.set_N_eP(A10_3, null, leJ_A10_3);

        A11_1.set_N_eP(null, null, leJ_A11_1);//S.lineEnds[25]
//</editor-fold>
        
//<editor-fold defaultstate="collapsed" desc=" V LaneEnds">
        
        V1_1.set_N_eP(V1_2, null, S_V1_1);//S.lineEnds[26]
        V1_2.set_N_eP(V1_3, V1_1, S_V1_2);
        V1_3.set_N_eP(null, V1_2, S_V1_3);
        
        V2_1.set_N_eP(null,null, S_V2_1);          
        V2_2.set_N_eP(null,null, S_V2_2);
        
        V3_1.set_N_eP(V3_2, null, S_V3_1);         
        V3_2.set_N_eP(null, V3_1, S_V3_2);
        
        V4_1.set_N_eP(V4_2, null, S_V4_1);          
        V4_2.set_N_eP(V4_3, V4_1, S_V4_2);
        V4_3.set_N_eP(null, V4_2, S_V4_3);
        
        V5_1.set_N_eP(null, V5_2, S_V5_1);          
        V5_2.set_N_eP(V5_1, V5_3, S_V5_2);
        V5_3.set_N_eP(V5_2, null, S_V5_3);
        
        //FLAGLER
        V6_1.set_N_eP(null, V6_2, S_V6_1);  
        V6_2.set_N_eP(null, null, S_V6_2);
        V6_3.set_N_eP(V6_2, null, S_V6_3);

        V7_1.set_N_eP(null, V7_2, S_V7_1);  
        V7_2.set_N_eP(null, null, S_V7_2);
        V7_3.set_N_eP(V7_2, null, S_V7_3);

        V8_1.set_N_eP(null, null, S_V8_1);

        V9_1.set_N_eP(null, null, S_V9_1);

        V10_1.set_N_eP(V10_2, null, S_V10_1);  
        V10_2.set_N_eP(V10_3, V10_1, S_V10_2);
        V10_3.set_N_eP(null, V10_2, S_V10_3);

        V11_1.set_N_eP(null, null, S_V11_1);
//</editor-fold>
        
//<editor-fold defaultstate="collapsed" desc=" M LaneEnds ">      
       
        M1_1.set_N_eP(null, M1_2, leI_M1_1);//S.lineEnds[51]
        M1_2.set_N_eP(M1_1, null, leI_M1_2);
        
        M2_1.set_N_eP(M2_2, null, leI_M2_1);
        M2_2.set_N_eP(M2_3, M2_1, leI_M2_2);        
        M2_3.set_N_eP(null, M2_2, leJ_M2_3);
        M2_3_1.set_N_eP(M2_3_2, M2_2, leI_M2_3_1);
        M2_3_2.set_N_eP(null, M2_3_1, leI_M2_3_2);
    
        M3_1.set_N_eP(null, M3_2, leJ_M3_1);
        M3_2.set_N_eP(M3_1, M3_3, leI_M3_2);
        M3_3.set_N_eP(M3_2, M3_4, leI_M3_3);
        M3_4.set_N_eP(M3_3, null, leJ_M3_4);
        M3_1_1.set_N_eP(null, M3_1_2, leI_M3_1_1);
        M3_1_2.set_N_eP(M3_1_1, null, leI_M3_1_2);
        
        M4_1.set_N_eP(null, M4_2, leI_M4_1);       
        M4_2.set_N_eP(M4_1, null, leJ_M4_2);
        
        M5_1.set_N_eP(M5_2, null, leJ_M5_1);
        M5_2.set_N_eP(M5_3, M5_1, leI_M5_2);
        M5_3.set_N_eP(null, M5_2, leJ_M5_3);
        M5_3_1.set_N_eP(M5_3_2, M5_2, leI_M5_3_1);
        M5_3_2.set_N_eP(M5_3_3, null, leI_M5_3_2);
        M5_3_3.set_N_eP(null, M5_3_2, leI_M5_3_3);
        
        M6_1.set_N_eP(null, M6_2, leJ_M6_1);
        M6_2.set_N_eP(M6_1, M6_3, leI_M6_2);
        M6_3.set_N_eP(M6_2, M6_4, leI_M6_3);
        M6_4.set_N_eP(M6_3, null, leI_M6_4);
        M6_1_1.set_N_eP(null, M6_1_2, leI_M6_1_1);
        M6_1_2.set_N_eP(M6_1_1, null, leI_M6_1_2);
        M6_1_3.set_N_eP(null, M6_2, leI_M6_1_3);            //partial lane linkage
        
        M7_1.set_N_eP(null, M7_2, leI_M7_1);
        M7_2.set_N_eP(M7_1, A4_2, leI_M7_2);
        
        M8_4_1.set_N_eP(M8_4_2, A5_3, leI_M8_4_1);
        M8_4_2.set_N_eP(M8_4_3, null, leI_M8_4_2);
        M8_4_3.set_N_eP(null, M8_4_2, leI_M8_4_3);
        //M8_4_4.set_N_eP(null, M8_4_1, leD_M8_4_4);        
        
        M9_1.set_N_eP(null, null, leJ_M9_1);
        M9_1_1.set_N_eP(M9_1_2, null, leI_M9_1_1);
        M9_1_2.set_N_eP(M9_1_3, M9_1_1, leJ_M9_1_2);
        M9_1_3.set_N_eP(null, M9_1_2, leI_M9_1_3);
        //M9_1_4.set_N_eP(M9_1_3, null, leD_M9_1_4);
        
        
       // //M10_1.set_N_eP(null, null, S_M10_1); //temp sink
        M10_1.set_N_eP(null, null, leJ_M10_1);
        M10_1_1.set_N_eP(null, null, leI_M10_1_1);
        M10_1_2.set_N_eP(null, null, leJ_M10_1_2);
       
        M11_1.set_N_eP(M11_2, null, leJ_M11_1);
        M11_2.set_N_eP(null, M11_1, leJ_M11_2);
        M11_2_1.set_N_eP(null, M11_1, leI_M11_2_1);
        M11_2_2.set_N_eP(null, null, leI_M11_2_2);
       
        M12_1.set_N_eP(null, M12_2, leJ_M12_1);
        M12_1_1.set_N_eP(null, null, leI_M12_1_1);
      	M12_1_2.set_N_eP(null, null, leI_M12_1_2);
        M12_2.set_N_eP(M12_1, null, leJ_M12_2);
        
        M13_3_1.set_N_eP(null, null, leI_M13_3_1);
      	M13_3_2.set_N_eP(null, null, leI_M13_3_2);
        
        M14_1.set_N_eP(null, M14_2, leJ_M14_1);
        M14_2.set_N_eP(M14_1, M14_3, leI_M14_2);
        M14_3.set_N_eP(M14_2, null, leJ_M14_3);
        M14_1_1.set_N_eP(null, null, leI_M14_1_1);
        M14_1_2.set_N_eP(null, null, leI_M14_1_2);
        
        M15_1.set_N_eP(M15_2, null, leJ_M15_1);
        M15_2.set_N_eP(M15_3, M15_1, leI_M15_2);
        M15_3.set_N_eP(null, M15_2, leJ_M15_3);
        M15_3_1.set_N_eP(null, null, leI_M15_3_1);
        M15_3_2.set_N_eP(null, null, leI_M15_3_2);
        
        M16_1_1.set_N_eP(null, null, leJ_M16_1_1);
      	M16_1_2.set_N_eP(null, null, leI_M16_1_2);
        
        M17_1.set_N_eP(null, M17_2, leJ_M17_1);
        M17_2.set_N_eP(M17_1, M17_3, leI_M17_2);
        M17_3.set_N_eP(M17_2, null, leJ_M17_3);
        M17_1_1.set_N_eP(null, null, leI_M17_1_1);
        M17_1_2.set_N_eP(null, null, leI_M17_1_2);
        
        M18_1.set_N_eP(M18_2, null, leJ_M18_1);
        M18_2.set_N_eP(M18_3, M18_1, leI_M18_2);
        M18_3.set_N_eP(null, M18_2, leJ_M18_3);
        M18_3_1.set_N_eP(null, null, leI_M18_3_1);
        M18_3_2.set_N_eP(null, null, leI_M18_3_2);
        
        M19_1_1.set_N_eP(null, null, leJ_M19_1_1);
      	M19_1_2.set_N_eP(null, null, leI_M19_1_2);
        
        M20_1_1.set_N_eP(null, null, leI_M20_1_1);
      	M20_1_2.set_N_eP(null, A10_2, leI_M20_1_2);  
      
     
        //M12_1.set_N_eP(null, M12_2, S_M12_1);   //temp sink
        //M12_2.set_N_eP(M12_1, null, S_M12_2);   //temp sink
        //M12_3.set_N_eP(M12_2, null, leD_M12_3);
      
      
//</editor-fold>
        
//<editor-fold defaultstate="collapsed" desc=" K LaneEnds">
        
        K1_1.set_N_eP(null, null, leI_K1_1);
        K1_2.set_N_eP(null, null, leD_K1_2);
        K1_3.set_N_eP(null, null, leD_K1_3);
        K1_4.set_N_eP(null, null, leI_K1_4);
        K1_5.set_N_eP(null, null, leI_K1_5);
        K1_6.set_N_eP(null, null, leI_K1_6);
        K1_7.set_N_eP(null, null, leD_K1_3);
        K1_8.set_N_eP(null, null, leD_K1_2);
        K1_9.set_N_eP(null, null, leI_K1_9);
        
        K2_1.set_N_eP(null, null, leD_K2_1);
        K2_2.set_N_eP(null, null, leD_K2_2);
        K2_3.set_N_eP(null, null, leD_K2_3);
        K2_4.set_N_eP(null, null, leD_K2_4);
        K2_5.set_N_eP(null, null, leD_K2_5);
        K2_6.set_N_eP(null, null, leI_K2_6);
        K2_7.set_N_eP(null, null, leI_K2_7);
        K2_8.set_N_eP(null, null, leD_K2_8);
        K2_9.set_N_eP(null, null, leD_K2_9);//
        K2_10.set_N_eP(null, null, leD_K2_10);
        K2_11.set_N_eP(null, null, leJ_K2_11);
        K2_12.set_N_eP(null, null, leJ_K2_12);
        K2_13.set_N_eP(null, null, leJ_K2_13);//
        K2_13.set_N_eP(null, null, leI_K2_13);
        K2_14.set_N_eP(null, null, leD_K2_14);//
        K2_15.set_N_eP(null, null, leJ_K2_15);//
        K2_16.set_N_eP(null, null, leD_K2_16);//
        K2_17.set_N_eP(null, null, leD_K2_17);//
        K2_18.set_N_eP(null, null, leJ_K2_18);//
        
        K3_1.set_N_eP(null, null, leD_K3_1);
        K3_2.set_N_eP(null, null, leI_K3_2);
        K3_3.set_N_eP(null, null, leD_K3_3);
        K3_4.set_N_eP(null, null, leD_K3_4);
        K3_5.set_N_eP(null, null, leI_K3_5);
        K3_6.set_N_eP(null, null, leD_K3_6);
        K3_7.set_N_eP(null, null, leD_K3_7);
        K3_8.set_N_eP(null, null, leD_K3_8);
        K3_9.set_N_eP(null, null, leD_K3_3);
        K3_10.set_N_eP(null, null, leD_K3_7);
        K3_11.set_N_eP(null, null, leD_K3_8);
        K3_12.set_N_eP(null, null, leD_K3_12);
        K3_13.set_N_eP(null, null, leD_K3_13);
        K3_14.set_N_eP(null, null, leD_K3_14);
        K3_15.set_N_eP(null, null, leD_K3_1);
        K3_16.set_N_eP(null, null, leD_K3_14);
        K3_17.set_N_eP(null, null, leD_K3_13);
        K3_18.set_N_eP(null, null, leD_K3_4);
      
     	K4_1.set_N_eP(null, null, leD_K4_1);
        K4_2.set_N_eP(null, null, leI_K4_2);
        K4_3.set_N_eP(null, null, leD_K4_3);
        K4_4.set_N_eP(null, null, leD_K4_4);
        K4_5.set_N_eP(null, null, leI_K4_5);
        K4_6.set_N_eP(null, null, leD_K4_6);
        K4_7.set_N_eP(null, null, leD_K4_7);
        K4_8.set_N_eP(null, null, leD_K4_8);
        K4_9.set_N_eP(null, null, leD_K4_9);
        K4_10.set_N_eP(null, null, leD_K4_10);
        K4_11.set_N_eP(null, null, leI_K4_11);
        K4_12.set_N_eP(null, null, leD_K4_12);
        K4_13.set_N_eP(null, null, leD_K4_13);
        K4_14.set_N_eP(null, null, leD_K4_14);
        K4_15.set_N_eP(null, null, leD_K4_15);
        K4_16.set_N_eP(null, null, leD_K4_16);
        K4_17.set_N_eP(null, null, leD_K4_17);
        
	K5_1.set_N_eP(null, null, leD_K5_1);
        K5_2.set_N_eP(null, null, leI_K5_2);
        K5_3.set_N_eP(null, null, leD_K5_3);
        K5_4.set_N_eP(null, null, leD_K5_4);
        K5_5.set_N_eP(null, null, leI_K5_5);
        K5_6.set_N_eP(null, null, leD_K5_6);
        K5_7.set_N_eP(null, null, leJ_K5_7);
        K5_8.set_N_eP(null, null, leJ_K5_8);
        K5_9.set_N_eP(null, null, leD_K5_9);
        K5_10.set_N_eP(null, null, leJ_K5_10);
        K5_11.set_N_eP(null, null, leD_K5_11);
        K5_12.set_N_eP(null, null, leJ_K5_12);
        K5_13.set_N_eP(null, null, leD_K5_13);
        K5_14.set_N_eP(null, null, leJ_K5_14);
        K5_15.set_N_eP(null, null, leD_K5_15);
        K5_16.set_N_eP(null, null, leJ_K5_16);

	K6_1.set_N_eP(null, null, leD_K6_1);
        K6_2.set_N_eP(null, null, leI_K6_2);
        K6_3.set_N_eP(null, null, leD_K6_3);
        K6_4.set_N_eP(null, null, leD_K6_4);
        K6_5.set_N_eP(null, null, leI_K6_5);
        K6_6.set_N_eP(null, null, leD_K6_6);
        K6_7.set_N_eP(null, null, leD_K6_7);
        K6_8.set_N_eP(null, null, leJ_K6_8);
        K6_9.set_N_eP(null, null, leD_K6_9);
        K6_10.set_N_eP(null, null, leJ_K6_10);
        K6_11.set_N_eP(null, null, leD_K6_11);
        K6_12.set_N_eP(null, null, leJ_K6_12);
        K6_13.set_N_eP(null, null, leD_K6_13);
        K6_14.set_N_eP(null, null, leJ_K6_14);
        K6_15.set_N_eP(null, null, leD_K6_15);
        K6_16.set_N_eP(null, null, leD_K6_16);
//</editor-fold>         
        
        S.lines = lines.toArray(new Lane[lines.size()]);
        S.sinks = sinks.toArray(new Sink[sinks.size()]);
        S.springs = springs.toArray(new Spring[springs.size()]);
        S.lineEnds = lineEnds.toArray(new LaneEnd[lineEnds.size()]);
        //System.out.println(Arrays.toString(S.lineEnds));

//<editor-fold defaultstate="collapsed" desc="Traffic Lights Events">
        //<editor-fold defaultstate="collapsed" desc="SW 8th STR/112th Ave">        
        
        //A1 Straight: events #1
        S.events.add(new TrafficLight_Event(S, S.lineEnds[0], LaneEnd.LINEEND_GREEN, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[1], LaneEnd.LINEEND_GREEN, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[2], LaneEnd.LINEEND_GREEN, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[0], LaneEnd.LINEEND_YELLOW, 68));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[1], LaneEnd.LINEEND_YELLOW, 68));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[2], LaneEnd.LINEEND_YELLOW, 68));       
        S.events.add(new TrafficLight_Event(S, S.lineEnds[0], LaneEnd.LINEEND_RED, 73));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[1], LaneEnd.LINEEND_RED, 73));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[2], LaneEnd.LINEEND_RED, 73)); 
        //M2 Straight: events #1
        S.events.add(new TrafficLight_Event(S, S.lineEnds[28], LaneEnd.LINEEND_GREEN, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[29], LaneEnd.LINEEND_GREEN, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[31], LaneEnd.LINEEND_GREEN, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[28], LaneEnd.LINEEND_YELLOW, 97));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[29], LaneEnd.LINEEND_YELLOW, 97));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[31], LaneEnd.LINEEND_YELLOW, 97));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[28], LaneEnd.LINEEND_RED, 102));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[29], LaneEnd.LINEEND_RED, 102));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[31], LaneEnd.LINEEND_RED, 102));
        //M1 Left(Straight): events #2
        S.events.add(new TrafficLight_Event(S, S.lineEnds[26], LaneEnd.LINEEND_RED, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[27], LaneEnd.LINEEND_RED, 0));        
        S.events.add(new TrafficLight_Event(S, S.lineEnds[26], LaneEnd.LINEEND_GREEN, 73));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[27], LaneEnd.LINEEND_GREEN, 73));        
        S.events.add(new TrafficLight_Event(S, S.lineEnds[26], LaneEnd.LINEEND_YELLOW, 123));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[27], LaneEnd.LINEEND_YELLOW, 123));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[26], LaneEnd.LINEEND_RED, 127));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[27], LaneEnd.LINEEND_RED, 127));
        //M3 Left: events #3
        S.events.add(new TrafficLight_Event(S, S.lineEnds[32], LaneEnd.LINEEND_RED, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[32], LaneEnd.LINEEND_GREEN, 127));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[32], LaneEnd.LINEEND_YELLOW, 155));
        
        //</editor-fold>                
        //<editor-fold defaultstate="collapsed" desc="SW 8th STR/109th Ave">       
        //Cycle = 160sec
        //M3 Straight: events #1
        S.events.add(new TrafficLight_Event(S, S.lineEnds[38], LaneEnd.LINEEND_GREEN, 0));//M3
        S.events.add(new TrafficLight_Event(S, S.lineEnds[34], LaneEnd.LINEEND_GREEN, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[35], LaneEnd.LINEEND_GREEN, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[36], LaneEnd.LINEEND_GREEN, 0));
        //S.events.add(new TrafficLight_Event(S, S.lineEnds[124], LaneEnd.LINEEND_GREEN, 0));//K2_13 - might need to take it out if conflicts with the traffic
                      
        S.events.add(new TrafficLight_Event(S, S.lineEnds[38], LaneEnd.LINEEND_YELLOW, 74));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[34], LaneEnd.LINEEND_YELLOW, 74));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[35], LaneEnd.LINEEND_YELLOW, 74));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[36], LaneEnd.LINEEND_YELLOW, 74));
       // S.events.add(new TrafficLight_Event(S, S.lineEnds[124], LaneEnd.LINEEND_YELLOW, 74));//K2_13
               
        S.events.add(new TrafficLight_Event(S, S.lineEnds[38], LaneEnd.LINEEND_RED, 79));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[34], LaneEnd.LINEEND_RED, 79));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[35], LaneEnd.LINEEND_RED, 79));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[36], LaneEnd.LINEEND_RED, 79));
        //S.events.add(new TrafficLight_Event(S, S.lineEnds[124], LaneEnd.LINEEND_RED, 79));//K2_13 
       //M5 Straight : events #1
        S.events.add(new TrafficLight_Event(S, S.lineEnds[41], LaneEnd.LINEEND_GREEN, 0));//M5
        S.events.add(new TrafficLight_Event(S, S.lineEnds[42], LaneEnd.LINEEND_GREEN, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[44], LaneEnd.LINEEND_GREEN, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[41], LaneEnd.LINEEND_YELLOW, 72));//M5
        S.events.add(new TrafficLight_Event(S, S.lineEnds[42], LaneEnd.LINEEND_YELLOW, 72));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[44], LaneEnd.LINEEND_YELLOW, 72));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[41], LaneEnd.LINEEND_RED, 77));//M5
        S.events.add(new TrafficLight_Event(S, S.lineEnds[42], LaneEnd.LINEEND_RED, 77));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[44], LaneEnd.LINEEND_RED, 77));
        //M4 Straight/Left : events #2
        S.events.add(new TrafficLight_Event(S, S.lineEnds[39], LaneEnd.LINEEND_RED, 0));//M4_1_1
        S.events.add(new TrafficLight_Event(S, S.lineEnds[40], LaneEnd.LINEEND_RED, 0));//M4_1_2            
        S.events.add(new TrafficLight_Event(S, S.lineEnds[39], LaneEnd.LINEEND_GREEN, 77));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[40], LaneEnd.LINEEND_GREEN, 77));        
        S.events.add(new TrafficLight_Event(S, S.lineEnds[39], LaneEnd.LINEEND_YELLOW, 108));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[40], LaneEnd.LINEEND_YELLOW, 108));        
        S.events.add(new TrafficLight_Event(S, S.lineEnds[39], LaneEnd.LINEEND_RED, 112));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[40], LaneEnd.LINEEND_RED, 112));
        //M9 Straight/Left : events #3
        S.events.add(new TrafficLight_Event(S, S.lineEnds[61], LaneEnd.LINEEND_RED, 0));//M9_1_1
        S.events.add(new TrafficLight_Event(S, S.lineEnds[62], LaneEnd.LINEEND_RED, 0));//M9_1_2        
        S.events.add(new TrafficLight_Event(S, S.lineEnds[61], LaneEnd.LINEEND_GREEN, 112));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[62], LaneEnd.LINEEND_GREEN, 112));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[61], LaneEnd.LINEEND_YELLOW, 132));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[62], LaneEnd.LINEEND_YELLOW, 132));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[61], LaneEnd.LINEEND_RED, 136));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[62], LaneEnd.LINEEND_RED, 136));
        //M3 Left : events #4
        S.events.add(new TrafficLight_Event(S, S.lineEnds[37], LaneEnd.LINEEND_RED, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[37], LaneEnd.LINEEND_GREEN, 136));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[37], LaneEnd.LINEEND_YELLOW, 156));
        //M5 Left : events #4
        S.events.add(new TrafficLight_Event(S, S.lineEnds[45], LaneEnd.LINEEND_RED, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[46], LaneEnd.LINEEND_RED, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[45], LaneEnd.LINEEND_GREEN, 136));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[46], LaneEnd.LINEEND_GREEN, 136));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[45], LaneEnd.LINEEND_YELLOW, 156));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[46], LaneEnd.LINEEND_YELLOW, 156));
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="SW 8th STR/107th Ave">
        //M6 Straight: events #1
        S.events.add(new TrafficLight_Event(S, S.lineEnds[53], LaneEnd.LINEEND_GREEN, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[48], LaneEnd.LINEEND_GREEN, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[49], LaneEnd.LINEEND_GREEN, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[53], LaneEnd.LINEEND_YELLOW, 37));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[48], LaneEnd.LINEEND_YELLOW, 37));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[49], LaneEnd.LINEEND_YELLOW, 37));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[53], LaneEnd.LINEEND_RED, 42));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[48], LaneEnd.LINEEND_RED, 42));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[49], LaneEnd.LINEEND_RED, 42));
        //A5 Straight: events #1
        S.events.add(new TrafficLight_Event(S, S.lineEnds[11], LaneEnd.LINEEND_GREEN, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[12], LaneEnd.LINEEND_GREEN, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[56], LaneEnd.LINEEND_GREEN, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[11], LaneEnd.LINEEND_YELLOW, 40));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[12], LaneEnd.LINEEND_YELLOW, 40));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[56], LaneEnd.LINEEND_YELLOW, 40));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[11], LaneEnd.LINEEND_RED, 45));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[12], LaneEnd.LINEEND_RED, 45));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[56], LaneEnd.LINEEND_RED, 45));
        //M7 Left: events #2
        S.events.add(new TrafficLight_Event(S, S.lineEnds[54], LaneEnd.LINEEND_RED, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[54], LaneEnd.LINEEND_GREEN, 45));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[54], LaneEnd.LINEEND_YELLOW, 62));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[54], LaneEnd.LINEEND_RED, 66));
        //M11 Left: events #2
        S.events.add(new TrafficLight_Event(S, S.lineEnds[69], LaneEnd.LINEEND_RED, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[69], LaneEnd.LINEEND_GREEN, 45));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[69], LaneEnd.LINEEND_YELLOW, 57));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[69], LaneEnd.LINEEND_RED, 61));
        //M7 Straight/Right: events #3
        S.events.add(new TrafficLight_Event(S, S.lineEnds[55], LaneEnd.LINEEND_RED, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[9], LaneEnd.LINEEND_RED, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[55], LaneEnd.LINEEND_GREEN, 62));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[9], LaneEnd.LINEEND_GREEN,62));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[55], LaneEnd.LINEEND_YELLOW, 131));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[9], LaneEnd.LINEEND_YELLOW,131));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[55], LaneEnd.LINEEND_RED, 135));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[9], LaneEnd.LINEEND_RED,135));
        //M11 Straight/Right: events #3
        S.events.add(new TrafficLight_Event(S, S.lineEnds[66], LaneEnd.LINEEND_RED, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[68], LaneEnd.LINEEND_RED, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[66], LaneEnd.LINEEND_GREEN, 66));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[68], LaneEnd.LINEEND_GREEN, 66));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[66], LaneEnd.LINEEND_YELLOW, 131));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[68], LaneEnd.LINEEND_YELLOW, 131));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[66], LaneEnd.LINEEND_RED, 136));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[68], LaneEnd.LINEEND_RED, 136));
        //M6 Left: events #4
        S.events.add(new TrafficLight_Event(S, S.lineEnds[51], LaneEnd.LINEEND_RED, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[52], LaneEnd.LINEEND_RED, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[51], LaneEnd.LINEEND_GREEN, 137));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[52], LaneEnd.LINEEND_GREEN, 137));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[51], LaneEnd.LINEEND_YELLOW, 156));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[52], LaneEnd.LINEEND_YELLOW, 156));
        //M8 Left: events #4
        S.events.add(new TrafficLight_Event(S, S.lineEnds[57], LaneEnd.LINEEND_RED, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[58], LaneEnd.LINEEND_RED, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[57], LaneEnd.LINEEND_GREEN, 136));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[58], LaneEnd.LINEEND_GREEN, 136));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[57], LaneEnd.LINEEND_YELLOW, 157));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[58], LaneEnd.LINEEND_YELLOW, 157));
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Flagler STR/112th Ave">
        //A10 Straight: events #1
        S.events.add(new TrafficLight_Event(S, S.lineEnds[101], LaneEnd.LINEEND_GREEN, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[23], LaneEnd.LINEEND_GREEN, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[24], LaneEnd.LINEEND_GREEN, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[101], LaneEnd.LINEEND_YELLOW, 85));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[23], LaneEnd.LINEEND_YELLOW, 85));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[24], LaneEnd.LINEEND_YELLOW, 85));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[101], LaneEnd.LINEEND_RED, 89));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[23], LaneEnd.LINEEND_RED, 89));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[24], LaneEnd.LINEEND_RED, 89));
        //M18 Straight: events #1
        S.events.add(new TrafficLight_Event(S, S.lineEnds[93], LaneEnd.LINEEND_GREEN, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[94], LaneEnd.LINEEND_GREEN, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[96], LaneEnd.LINEEND_GREEN, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[93], LaneEnd.LINEEND_YELLOW, 85));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[94], LaneEnd.LINEEND_YELLOW, 85));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[96], LaneEnd.LINEEND_YELLOW, 85));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[93], LaneEnd.LINEEND_RED, 89));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[94], LaneEnd.LINEEND_RED, 89));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[96], LaneEnd.LINEEND_RED, 89));
        //A11 Straight/Left: events #2
        S.events.add(new TrafficLight_Event(S, S.lineEnds[25], LaneEnd.LINEEND_RED, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[25], LaneEnd.LINEEND_GREEN, 90));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[25], LaneEnd.LINEEND_YELLOW, 115));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[25], LaneEnd.LINEEND_RED, 119));
        //M19 Straight/Left: events #3
        S.events.add(new TrafficLight_Event(S, S.lineEnds[98], LaneEnd.LINEEND_RED, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[99], LaneEnd.LINEEND_RED, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[98], LaneEnd.LINEEND_GREEN, 119));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[99], LaneEnd.LINEEND_GREEN, 119));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[98], LaneEnd.LINEEND_YELLOW, 146));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[99], LaneEnd.LINEEND_YELLOW, 146));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[98], LaneEnd.LINEEND_RED, 150));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[99], LaneEnd.LINEEND_RED, 150));
        //M20 Left: events #4
        S.events.add(new TrafficLight_Event(S, S.lineEnds[100], LaneEnd.LINEEND_RED, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[100], LaneEnd.LINEEND_GREEN, 150));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[100], LaneEnd.LINEEND_YELLOW, 157));
        //M18 Left: events #4
        S.events.add(new TrafficLight_Event(S, S.lineEnds[97], LaneEnd.LINEEND_RED, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[97], LaneEnd.LINEEND_GREEN, 150));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[97], LaneEnd.LINEEND_YELLOW, 157));
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Flagler STR/109th Ave">
        //M17 Straight: events #1
        S.events.add(new TrafficLight_Event(S, S.lineEnds[92], LaneEnd.LINEEND_GREEN, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[89], LaneEnd.LINEEND_GREEN, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[90], LaneEnd.LINEEND_GREEN, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[92], LaneEnd.LINEEND_YELLOW, 79));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[89], LaneEnd.LINEEND_YELLOW, 79));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[90], LaneEnd.LINEEND_YELLOW, 79));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[92], LaneEnd.LINEEND_RED, 83));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[89], LaneEnd.LINEEND_RED, 83));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[90], LaneEnd.LINEEND_RED, 83));
        //M18 Straight: events #1
        S.events.add(new TrafficLight_Event(S, S.lineEnds[81], LaneEnd.LINEEND_GREEN, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[82], LaneEnd.LINEEND_GREEN, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[84], LaneEnd.LINEEND_GREEN, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[81], LaneEnd.LINEEND_YELLOW, 79));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[82], LaneEnd.LINEEND_YELLOW, 79));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[84], LaneEnd.LINEEND_YELLOW, 79));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[81], LaneEnd.LINEEND_RED, 83));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[82], LaneEnd.LINEEND_RED, 83));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[84], LaneEnd.LINEEND_RED, 83));
        //M10 Left events #2
        S.events.add(new TrafficLight_Event(S, S.lineEnds[64], LaneEnd.LINEEND_RED, 0));          
        S.events.add(new TrafficLight_Event(S, S.lineEnds[64], LaneEnd.LINEEND_GREEN, 84));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[64], LaneEnd.LINEEND_YELLOW, 100));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[64], LaneEnd.LINEEND_RED, 104));
        //M16 Left events #2
        S.events.add(new TrafficLight_Event(S, S.lineEnds[87], LaneEnd.LINEEND_RED, 0));          
        S.events.add(new TrafficLight_Event(S, S.lineEnds[87], LaneEnd.LINEEND_GREEN, 84));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[87], LaneEnd.LINEEND_YELLOW, 100));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[87], LaneEnd.LINEEND_RED, 104));
        //M10 Straight: events #3
        S.events.add(new TrafficLight_Event(S, S.lineEnds[65], LaneEnd.LINEEND_RED, 0));          
        S.events.add(new TrafficLight_Event(S, S.lineEnds[65], LaneEnd.LINEEND_GREEN, 105));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[65], LaneEnd.LINEEND_YELLOW, 139));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[65], LaneEnd.LINEEND_RED, 143));
        //M16 Straight: events #3
        S.events.add(new TrafficLight_Event(S, S.lineEnds[86], LaneEnd.LINEEND_RED, 0));          
        S.events.add(new TrafficLight_Event(S, S.lineEnds[86], LaneEnd.LINEEND_GREEN, 105));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[86], LaneEnd.LINEEND_YELLOW, 139));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[86], LaneEnd.LINEEND_RED, 143));
        //M17 Left: events #4
        S.events.add(new TrafficLight_Event(S, S.lineEnds[91], LaneEnd.LINEEND_RED, 0));          
        S.events.add(new TrafficLight_Event(S, S.lineEnds[91], LaneEnd.LINEEND_GREEN, 144));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[91], LaneEnd.LINEEND_YELLOW, 156));
        //M15 Left: events #4
        S.events.add(new TrafficLight_Event(S, S.lineEnds[85], LaneEnd.LINEEND_RED, 0));          
        S.events.add(new TrafficLight_Event(S, S.lineEnds[85], LaneEnd.LINEEND_GREEN, 144));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[85], LaneEnd.LINEEND_YELLOW, 156));        
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Flagler STR/107th Ave">
        //M14 Straight: events #1
        S.events.add(new TrafficLight_Event(S, S.lineEnds[80], LaneEnd.LINEEND_GREEN, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[77], LaneEnd.LINEEND_GREEN, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[78], LaneEnd.LINEEND_GREEN, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[80], LaneEnd.LINEEND_YELLOW, 37));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[77], LaneEnd.LINEEND_YELLOW, 37));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[78], LaneEnd.LINEEND_YELLOW, 37));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[80], LaneEnd.LINEEND_RED, 43));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[77], LaneEnd.LINEEND_RED, 43));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[78], LaneEnd.LINEEND_RED, 43));
        //A6 Straight: events #1
        S.events.add(new TrafficLight_Event(S, S.lineEnds[14], LaneEnd.LINEEND_GREEN, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[15], LaneEnd.LINEEND_GREEN, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[74], LaneEnd.LINEEND_GREEN, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[14], LaneEnd.LINEEND_YELLOW, 43));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[15], LaneEnd.LINEEND_YELLOW, 43));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[74], LaneEnd.LINEEND_YELLOW, 43));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[14], LaneEnd.LINEEND_RED, 48));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[15], LaneEnd.LINEEND_RED, 48));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[74], LaneEnd.LINEEND_RED, 48));
        //M12 Left: events #2
        S.events.add(new TrafficLight_Event(S, S.lineEnds[72], LaneEnd.LINEEND_RED, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[72], LaneEnd.LINEEND_GREEN, 50));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[72], LaneEnd.LINEEND_YELLOW, 70));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[72], LaneEnd.LINEEND_RED, 74));
        //A7 Left: events #2
        S.events.add(new TrafficLight_Event(S, S.lineEnds[19], LaneEnd.LINEEND_RED, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[19], LaneEnd.LINEEND_GREEN, 50));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[19], LaneEnd.LINEEND_YELLOW, 70));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[19], LaneEnd.LINEEND_RED, 74));
        //M12 Straight: events #3
        S.events.add(new TrafficLight_Event(S, S.lineEnds[73], LaneEnd.LINEEND_RED, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[71], LaneEnd.LINEEND_RED, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[73], LaneEnd.LINEEND_GREEN, 76));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[71], LaneEnd.LINEEND_GREEN, 76));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[73], LaneEnd.LINEEND_YELLOW, 134));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[71], LaneEnd.LINEEND_YELLOW, 134));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[73], LaneEnd.LINEEND_RED, 138));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[71], LaneEnd.LINEEND_RED, 138));
        //A7 Straight: events #3
        S.events.add(new TrafficLight_Event(S, S.lineEnds[17], LaneEnd.LINEEND_RED, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[18], LaneEnd.LINEEND_RED, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[17], LaneEnd.LINEEND_GREEN, 76));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[18], LaneEnd.LINEEND_GREEN, 76));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[17], LaneEnd.LINEEND_YELLOW, 134));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[18], LaneEnd.LINEEND_YELLOW, 134));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[17], LaneEnd.LINEEND_RED, 138));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[18], LaneEnd.LINEEND_RED, 138));
        //M14 Left: events #4
        S.events.add(new TrafficLight_Event(S, S.lineEnds[79], LaneEnd.LINEEND_RED, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[79], LaneEnd.LINEEND_GREEN, 140));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[79], LaneEnd.LINEEND_YELLOW, 151));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[79], LaneEnd.LINEEND_RED, 157));
        //M13 Left: events #4
        S.events.add(new TrafficLight_Event(S, S.lineEnds[75], LaneEnd.LINEEND_RED, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[75], LaneEnd.LINEEND_GREEN, 140));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[75], LaneEnd.LINEEND_YELLOW, 155));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[75], LaneEnd.LINEEND_RED, 159));      
        //</editor-fold>
//</editor-fold>
        
//******************Add first Agents********************************************************************
//<editor-fold defaultstate="collapsed" desc="Events: Add First Agents">        
        
        S.events.add(new NewAgent_Event(S, (-1.0 * S.getLanePredictant(SPA1_1.id) * Math.log(S.getDouble())), SPA1_1));
        S.events.add(new NewAgent_Event(S, (-1.0 * S.getLanePredictant(SPA1_2.id) * Math.log(S.getDouble())), SPA1_2));
        S.events.add(new NewAgent_Event(S, (-1.0 * S.getLanePredictant(SPA1_3.id) * Math.log(S.getDouble())), SPA1_3));
        S.events.add(new NewAgent_Event(S, (-1.0 * S.getLanePredictant(SPA1_4.id) * Math.log(S.getDouble())), SPA1_4));        
        
        S.events.add(new NewAgent_Event(S, (-1.0 * S.getLanePredictant(SPA2_1.id) * Math.log(S.getDouble())), SPA2_1));
        S.events.add(new NewAgent_Event(S, (-1.0 * S.getLanePredictant(SPA2_2.id) * Math.log(S.getDouble())), SPA2_2));
        
        S.events.add(new NewAgent_Event(S, (-1.0 * S.getLanePredictant(SPA3_1.id) * Math.log(S.getDouble())), SPA3_1));
        S.events.add(new NewAgent_Event(S, (-1.0 * S.getLanePredictant(SPA3_2.id) * Math.log(S.getDouble())), SPA3_2));
        
        S.events.add(new NewAgent_Event(S, (-1.0 * S.getLanePredictant(SPA4_1.id) * Math.log(S.getDouble())), SPA4_1));
        S.events.add(new NewAgent_Event(S, (-1.0 * S.getLanePredictant(SPA4_2.id) * Math.log(S.getDouble())), SPA4_2));
        
        S.events.add(new NewAgent_Event(S, (-1.0 * S.getLanePredictant(SPA5_1.id) * Math.log(S.getDouble())), SPA5_1));
        S.events.add(new NewAgent_Event(S, (-1.0 * S.getLanePredictant(SPA5_2.id) * Math.log(S.getDouble())), SPA5_2));
        S.events.add(new NewAgent_Event(S, (-1.0 * S.getLanePredictant(SPA5_3.id) * Math.log(S.getDouble())), SPA5_3));
        S.events.add(new NewAgent_Event(S, (-1.0 * S.getLanePredictant(SPA5_4.id) * Math.log(S.getDouble())), SPA5_4));
      
      	S.events.add(new NewAgent_Event(S, (-1.0 * S.getLanePredictant(SPA6_1.id) * Math.log(S.getDouble())), SPA6_1));
        S.events.add(new NewAgent_Event(S, (-1.0 * S.getLanePredictant(SPA6_2.id) * Math.log(S.getDouble())), SPA6_2));
        S.events.add(new NewAgent_Event(S, (-1.0 * S.getLanePredictant(SPA6_3.id) * Math.log(S.getDouble())), SPA6_3));
        
        S.events.add(new NewAgent_Event(S, (-1.0 * S.getLanePredictant(SPA7_1.id) * Math.log(S.getDouble())), SPA7_1));
        S.events.add(new NewAgent_Event(S, (-1.0 * S.getLanePredictant(SPA7_2.id) * Math.log(S.getDouble())), SPA7_2));
        S.events.add(new NewAgent_Event(S, (-1.0 * S.getLanePredictant(SPA7_3.id) * Math.log(S.getDouble())), SPA7_3));
        
        S.events.add(new NewAgent_Event(S, (-1.0 * S.getLanePredictant(SPA8_1.id) * Math.log(S.getDouble())), SPA8_1));
        
        S.events.add(new NewAgent_Event(S, (-1.0 * S.getLanePredictant(SPA9_1.id) * Math.log(S.getDouble())), SPA9_1));
        
        S.events.add(new NewAgent_Event(S, (-1.0 * S.getLanePredictant(SPA10_1.id) * Math.log(S.getDouble())), SPA10_1));
        S.events.add(new NewAgent_Event(S, (-1.0 * S.getLanePredictant(SPA10_2.id) * Math.log(S.getDouble())), SPA10_2));
        S.events.add(new NewAgent_Event(S, (-1.0 * S.getLanePredictant(SPA10_3.id) * Math.log(S.getDouble())), SPA10_3));
        
        S.events.add(new NewAgent_Event(S, (-1.0 * S.getLanePredictant(SPA11_1.id) * Math.log(S.getDouble())), SPA11_1));
        
//</editor-fold>
        System.out.println("Duration of the initialization: " + (System.currentTimeMillis() - t) / 1000 + "sec");
    }
    
    
}
