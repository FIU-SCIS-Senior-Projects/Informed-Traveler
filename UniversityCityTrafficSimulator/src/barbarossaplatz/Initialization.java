package barbarossaplatz;

import java.awt.Point;
import java.util.LinkedList;
import entities.*;
import events.NewAgent_Event;
import events.TrafficLight_Event;
import simulation.Simulation;

public class Initialization {

    public static void initialize(Simulation S) {
        double t = System.currentTimeMillis();
        System.out.println("Initialization of the model");

        //***********Lines***************
        LinkedList<Lane> lines = new LinkedList<Lane>();
  /*1*/ Lane A1_1 = new Lane("A1_1", 1, 50); lines.add(A1_1);
        Lane A1_2 = new Lane("A1_2", 2, 50); lines.add(A1_2);
        Lane V1_1 = new Lane("V1_1", 3, 150); lines.add(V1_1);
        Lane V1_2 = new Lane("V1_2", 4, 150); lines.add(V1_2);

        Lane V2_1 = new Lane("V2_1", 5, 100); lines.add(V2_1);

        Lane A2_1_1 = new Lane("A2_1_1", 6, 125);lines.add(A2_1_1);
        Lane A2_2_1 = new Lane("A2_2_1", 7, 125);lines.add(A2_2_1);
        Lane A2_3_1 = new Lane("A2_3_1", 8, 125);lines.add(A2_3_1);
        Lane A2_1_2 = new Lane("A2_1_2", 9, 25); lines.add(A2_1_2);
 /*10*/ Lane A2_2_2 = new Lane("A2_2_2", 10, 25);lines.add(A2_2_2);
        Lane A2_3_2 = new Lane("A2_3_2", 11, 25);lines.add(A2_3_2);
        Lane V3_1 = new Lane("V3_1", 12, 145);lines.add(V3_1);
        Lane V3_2 = new Lane("V3_2", 13, 145);lines.add(V3_2);

        Lane A3_1_1 = new Lane("A3_1_1", 14, 65); lines.add(A3_1_1);
        Lane A3_1_2 = new Lane("A3_1_2", 15, 27); lines.add(A3_1_2);
        Lane V4_1 = new Lane("V4_1", 16, 58);lines.add(V4_1);

        Lane A4_1 = new Lane("A4_1", 17, 255);
        lines.add(A4_1);
        Lane A4_2 = new Lane("A4_2", 18, 255);
        lines.add(A4_2);
        Lane V5_1 = new Lane("V5_1", 19, 85);
        lines.add(V5_1);
 /*20*/ Lane V5_2 = new Lane("V5_2", 20, 85);
        lines.add(V5_2);

        Lane A5_1 = new Lane("A5_1", 21, 150);
        lines.add(A5_1);
        Lane A5_2 = new Lane("A5_2", 22, 150);
        lines.add(A5_2);
        Lane V6_1 = new Lane("V6_1", 23, 150);
        lines.add(V6_1);
        Lane V6_2 = new Lane("V6_2", 24, 150);
        lines.add(V6_2);

        Lane V7_1 = new Lane("V7_1", 25, 90);
        lines.add(V7_1);

        Lane A6_1 = new Lane("A6_1", 26, 200);
        lines.add(A6_1);
        Lane A6_2 = new Lane("A6_2", 27, 200);
        lines.add(A6_2);
        Lane A6_3 = new Lane("A6_3", 28, 200);
        lines.add(A6_3);
        Lane V8_1 = new Lane("V8_1", 29, 180);
        lines.add(V8_1);
 /*30*/ Lane V8_2 = new Lane("V8_2", 30, 180);
        lines.add(V8_2);

        //*******************************
        Lane M1_1 = new Lane("M1_1", 31, 100);
        lines.add(M1_1);
        Lane M1_2 = new Lane("M1_2", 32, 100);
        lines.add(M1_2);

        Lane M2_1 = new Lane("M2_1", 33, 110);
        lines.add(M2_1);
        Lane M2_2 = new Lane("M2_2", 34, 110);
        lines.add(M2_2);
        Lane M2_3 = new Lane("M2_3", 35, 110);
        lines.add(M2_3);
        Lane M2_4 = new Lane("M2_4", 36, 110);
        lines.add(M2_4);

        Lane M3_1_1 = new Lane("M3_1_1", 37, 60);
        lines.add(M3_1_1);
        Lane M3_1_2 = new Lane("M3_1_2", 38, 31);
        lines.add(M3_1_2);
        Lane M3_2_1 = new Lane("M3_2_1", 39, 60);
        lines.add(M3_2_1);
        /*40*/ Lane M3_2_2 = new Lane("M3_2_2", 40, 31);
        lines.add(M3_2_2);

        Lane M4_1 = new Lane("M4_1", 41, 85);
        lines.add(M4_1);
        Lane M4_2 = new Lane("M4_2", 42, 85);
        lines.add(M4_2);

        Lane M5_1 = new Lane("M5_1", 43, 75);
        lines.add(M5_1);
        Lane M5_2 = new Lane("M5_2", 44, 75);
        lines.add(M5_2);
        Lane M5_3 = new Lane("M5_3", 45, 75);
        lines.add(M5_3);

        Lane M6_1_1 = new Lane("M6_1_1", 46, 89);
        lines.add(M6_1_1);
        Lane M6_1_2 = new Lane("M6_1_2", 47, 40);
        lines.add(M6_1_2);
        Lane M6_2_1 = new Lane("M6_2_1", 48, 89);
        lines.add(M6_2_1);
        Lane M6_2_2 = new Lane("M6_2_2", 49, 40);
        lines.add(M6_2_2);
        Lane M6_3_1 = new Lane("M6_3_1", 50, 89);
        lines.add(M6_3_1);
        Lane M6_3_2 = new Lane("M6_3_2", 51, 40);
        lines.add(M6_3_2);
        Lane M6_4 = new Lane("M6_4", 52, 40);
        lines.add(M6_4);
        Lane M6_5 = new Lane("M6_5", 53, 40);
        lines.add(M6_3_2);

        Lane M7_1_1 = new Lane("M7_1_1", 54, 40);
        lines.add(M7_1_1);
        Lane M7_2_1 = new Lane("M7_2_1", 55, 40);
        lines.add(M7_2_1);
        Lane M7_1_2 = new Lane("M7_1_2", 56, 14);
        lines.add(M7_1_2);
        Lane M7_2_2 = new Lane("M7_2_2", 57, 23);
        lines.add(M7_2_2);

        Lane M81_1_1 = new Lane("M81_1_1", 58, 106);
        lines.add(M81_1_1);
        Lane M81_1_2 = new Lane("M81_1_2", 59, 35);
        lines.add(M81_1_2);

        Lane M82_1_1 = new Lane("M82_1_1", 60, 15);
        lines.add(M82_1_1);
        Lane M82_1_2 = new Lane("M82_1_2", 61, 82);
        lines.add(M82_1_2);
        Lane M82_1_3 = new Lane("M82_1_3", 62, 17);
        lines.add(M82_1_3);

        Lane M9_1 = new Lane("M9_1", 63, 107); lines.add(M9_1);

        Lane M10_1 = new Lane("M10_1", 64, 151); lines.add(M10_1);
        Lane M10_2 = new Lane("M10_2", 65, 158); lines.add(M10_2);

        Lane M11_1 = new Lane("M11_1", 66, 150);
        lines.add(M11_1);
        Lane M11_2 = new Lane("M11_2", 67, 150);
        lines.add(M11_2);
        Lane M11_3 = new Lane("M11_3", 68, 150);
        lines.add(M11_3);

        Lane M12_1_1 = new Lane("M12_1_1", 69, 8);
        lines.add(M12_1_1);
        Lane M12_1_2 = new Lane("M12_1_2", 70, 80);
        lines.add(M12_1_2);
        Lane M12_2 = new Lane("M12_2", 71, 80);
        lines.add(M12_2);
        Lane M12_3 = new Lane("M12_3", 72, 80);
        lines.add(M12_3);

        Lane M13_1 = new Lane("M13_1", 73, 92);
        lines.add(M13_1);
        Lane M13_2 = new Lane("M13_2", 74, 92);
        lines.add(M13_2);
        Lane M13_3 = new Lane("M13_3", 75, 92);
        lines.add(M13_3);

        Lane M14_1 = new Lane("M14_1", 76, 144);
        lines.add(M14_1);

//**********************************
        //M3 > M5
        Lane K2_1_1 = new Lane("K2_1_1", 77, 40);
        lines.add(K2_1_1);
        Lane K2_2_1 = new Lane("K2_2_1", 78, 40);
        lines.add(K2_2_1);
        Lane K2_1_2 = new Lane("K2_1_2", 79, 18);
        lines.add(K2_1_2);
        Lane K2_2_2 = new Lane("K2_2_2", 80, 13);
        lines.add(K2_2_2);
        //M3 > M1
        Lane K2_3 = new Lane("K2_3", 81, 42);
        lines.add(K2_3);
        Lane K2_4 = new Lane("K2_4", 82, 42);
        lines.add(K2_4);
        //M2 > M5
        Lane K2_5 = new Lane("K2_5", 83, 13);
        lines.add(K2_5);
        Lane K2_6 = new Lane("K2_6", 84, 22);
        lines.add(K2_6);
        //M2 > M4
        Lane K2_7 = new Lane("K2_7", 85, 42);
        lines.add(K2_7);
        Lane K2_8 = new Lane("K2_8", 86, 42);
        lines.add(K2_8);
        //M13 > M5
        Lane K2_9_1 = new Lane("K2_9_1", 87, 36);
        lines.add(K2_9_1);
        Lane K2_9_2 = new Lane("K2_9_2", 88, 50);
        lines.add(K2_9_2);
        Lane K2_10_1 = new Lane("K2_10_1", 89, 36);
        lines.add(K2_10_1);
        Lane K2_10_2 = new Lane("K2_10_2", 90, 50);
        lines.add(K2_10_2);
        Lane K2_11 = new Lane("K2_11", 91, 86);
        lines.add(K2_11);
        //M13 > M4
        Lane K2_12 = new Lane("K2_12", 92, 19);
        lines.add(K2_12);

        //M1 > M10
        Lane K1_1 = new Lane("K1_1", 93, 73);
        lines.add(K1_1);
        Lane K1_2 = new Lane("K1_2", 94, 73);
        lines.add(K1_2);
        //M6 > M10
        Lane K1_3 = new Lane("K1_3", 95, 25);
        lines.add(K1_3);
        Lane K1_4 = new Lane("K1_4", 96, 25);
        lines.add(K1_4);
        //M6 > V6, V7, M11, M2
        Lane K1_5 = new Lane("K1_5", 97, 33);
        lines.add(K1_5);
        Lane K1_6 = new Lane("K1_6", 98, 33);
        lines.add(K1_6);
        Lane K1_7 = new Lane("K1_7", 99, 33);
        lines.add(K1_7);
        Lane K1_8 = new Lane("K1_8", 100, 31);
        lines.add(K1_8);
        //A4 > V6, V7, M11, M2
        Lane K1_9 = new Lane("K1_9", 101, 50);
        lines.add(K1_9);
        Lane K1_10 = new Lane("K1_10", 102, 45);
        lines.add(K1_10);
        Lane K1_11 = new Lane("K1_11", 103, 25);
        lines.add(K1_11);
        //M6, A4 > V6
        Lane K1_12 = new Lane("K1_12", 104, 39);
        lines.add(K1_12);
        //A5 > V7, M11, M2
        Lane K1_13 = new Lane("K1_13", 105, 40);
        lines.add(K1_13);
        Lane K1_14 = new Lane("K1_14", 106, 40);
        lines.add(K1_14);
        Lane K1_15 = new Lane("K1_15", 107, 12);
        lines.add(K1_15);
        //M6, A4 > V7
        Lane K1_16 = new Lane("K1_16", 108, 48);
        lines.add(K1_16);
        //M6, A4 > M11
        Lane K1_17 = new Lane("K1_17", 109, 45);
        lines.add(K1_17);
        Lane K1_18 = new Lane("K1_18", 110, 45);
        lines.add(K1_18);
        Lane K1_19 = new Lane("K1_19", 111, 45);
        lines.add(K1_19);
        //A5 > M11
        Lane K1_20 = new Lane("K1_20", 112, 20);
        lines.add(K1_20);
        //M6 > M2,A4
        Lane K1_21 = new Lane("K1_21", 113, 22);
        lines.add(K1_21);
        Lane K1_22 = new Lane("K1_22", 114, 30);
        lines.add(K1_22);
        Lane K1_23 = new Lane("K1_23", 115, 32);
        lines.add(K1_23);
        Lane K1_24 = new Lane("K1_24", 116, 42);
        lines.add(K1_24);

        //A5 > M2
        Lane K1_25 = new Lane("K1_25", 117, 43); lines.add(K1_25);
        Lane K1_26 = new Lane("K1_26", 118, 40); lines.add(K1_26);
        Lane K1_27 = new Lane("K1_27", 119, 39); lines.add(K1_27);

	//********************************
        LinkedList<Spring> springs = new LinkedList<Spring>();
        //*************Springs***********
        Spring SPA1_1 = new Spring(S, "SPA1_1", 39, new int[]{1, 2}, new Point(2210, 832), A1_1);springs.add(SPA1_1);
        Spring SPA1_2 = new Spring(S, "SPA1_2", 40, new int[]{1, 2, 3}, new Point(2210, 806), A1_2);springs.add(SPA1_2);

        Spring SPA2_1 = new Spring(S, "SPA2_1", 41, new int[]{1, 2}, new Point(1365, 13), A2_1_1); springs.add(SPA2_1);
        Spring SPA2_2 = new Spring(S, "SPA2_2", 42, new int[]{1, 2}, new Point(1339, 13), A2_2_1); springs.add(SPA2_2);
        Spring SPA2_3 = new Spring(S, "SPA2_3", 43, new int[]{1, 2}, new Point(1313, 13), A2_3_1); springs.add(SPA2_3);

        Spring SPA3_1 = new Spring(S, "SPA3_1", 44, new int[]{2, 6}, new Point(598, 273), A3_1_1); springs.add(SPA3_1);

        Spring SPA4_1 = new Spring(S, "SPA4_1", 45, new int[]{1, 2, 3, 4, 5}, new Point(32, 377), A4_1); springs.add(SPA4_1);
        Spring SPA4_2 = new Spring(S, "SPA4_2", 46, new int[]{1, 2, 3, 4, 5}, new Point(32, 403), A4_2); springs.add(SPA4_2);

        Spring SPA5_1 = new Spring(S, "SPA5_1", 47, new int[]{1, 2, 3, 4}, new Point(208, 1040), A5_1);  springs.add(SPA5_1);
        Spring SPA5_2 = new Spring(S, "SPA5_2", 48, new int[]{1, 2, 3, 4}, new Point(208, 1066), A5_2);  springs.add(SPA5_2);

        Spring SPA6_1 = new Spring(S, "SPA6_1", 49, new int[]{1, 2}, new Point(1332, 2054), A6_1);     springs.add(SPA6_1);
        Spring SPA6_2 = new Spring(S, "SPA6_2", 50, new int[]{1, 2}, new Point(1358, 2054), A6_2);     springs.add(SPA6_2);
        Spring SPA6_3 = new Spring(S, "SPA6_3", 51, new int[]{1, 2}, new Point(1384, 2054), A6_3);     springs.add(SPA6_3);

        LinkedList<Sink> sinks = new LinkedList<Sink>();
	//*************Sinks***********

        Sink S_V1_1 = new Sink(S, "S_V1_1", 1, 3, new Point(2175, 936));
        sinks.add(S_V1_1);
        Sink S_V1_2 = new Sink(S, "S_V1_2", 1, 3, new Point(2175, 962));
        sinks.add(S_V1_2);
        Sink S_V2_1 = new Sink(S, "S_V2_1", 2, 3, new Point(1777, 468));
        sinks.add(S_V2_1);
        Sink S_V3_1 = new Sink(S, "S_V3_1", 3, 2, new Point(1537, 13));
        sinks.add(S_V3_1);
        Sink S_V3_2 = new Sink(S, "S_V3_2", 3, 2, new Point(1563, 13));
        sinks.add(S_V3_2);
        Sink S_V4_1 = new Sink(S, "S_V4_1", 4, 1, new Point(820, 250));
        sinks.add(S_V4_1);
        Sink S_V5_1 = new Sink(S, "S_V5_1", 5, 6, new Point(65, 364));
        sinks.add(S_V5_1);
        Sink S_V5_2 = new Sink(S, "S_V5_2", 5, 6, new Point(91, 351));
        sinks.add(S_V5_2);
        Sink S_V6_1 = new Sink(S, "S_V6_1", 6, 5, new Point(208, 1014));
        sinks.add(S_V6_1);
        Sink S_V6_2 = new Sink(S, "S_V6_2", 6, 5, new Point(208, 988));
        sinks.add(S_V6_2);
        Sink S_V7_1 = new Sink(S, "S_V7_1", 7, 4, new Point(533, 1248));
        sinks.add(S_V7_1);
        Sink S_V8_1 = new Sink(S, "S_V8_1", 8, 2, new Point(1306, 2054));
        sinks.add(S_V8_1);
        Sink S_V8_2 = new Sink(S, "S_V8_2", 8, 2, new Point(1280, 2054));
        sinks.add(S_V8_2);

        LinkedList<LaneEnd> lineEnds = new LinkedList<LaneEnd>();
	//************LineEnds*************
        //Name succeeding Lines	  leadingToDirections	relevant Directions
        //A1, M3, M4
  /*1*/ Dissection leD_A1_1 = new Dissection(S, 1, "leD_A1_1", new Point(1777, 832), new Lane[]{M3_1_1}, new int[]{1}, new int[]{3});
        lineEnds.add(leD_A1_1);
        Junction leJ_A1_2 = new Junction(S, "leJ_A1_2", new Point(1777, 806), new Lane[]{M3_2_1, V2_1}, new int[]{1, 2, 3});
        lineEnds.add(leJ_A1_2);

        Dissection leD_M3_1_1 = new Dissection(S, 2, "leD_M3_1_1", new Point(1574, 832), new Lane[]{M3_1_2}, new int[]{1}, null);
        lineEnds.add(leD_M3_1_1);
        Dissection leD_M3_2_1 = new Dissection(S, 3, "leD_M3_2_1", new Point(1574, 806), new Lane[]{M3_2_2, K2_1_1, K2_2_1}, new int[]{1, 2}, null);
        lineEnds.add(leD_M3_2_1);
        Intersection leI_M3_1_2 = new Intersection(S, "leI_M3_1_2", new Point(1469, 832), K2_4, new int[]{6}, LaneEnd.LINEEND_RED);
        lineEnds.add(leI_M3_1_2);
        Intersection leI_M3_2_2 = new Intersection(S, "leI_M3_2_2", new Point(1469, 806), K2_3, new int[]{6}, LaneEnd.LINEEND_RED);
        lineEnds.add(leI_M3_2_2);

        Intersection leI_M4_1 = new Intersection(S, "leI_M4_1", new Point(1755, 936), V1_1, new int[]{3});
        lineEnds.add(leI_M4_1);
        Dissection leD_M4_2 = new Dissection(S, 24, "leD_M4_2", new Point(1755, 962), new Lane[]{V1_2}, new int[]{3, 4}, new int[]{4});
        lineEnds.add(leD_M4_2);
        //M5, M7, A2, M6
        Dissection leD_M5_1 = new Dissection(S, 4, "leD_M5_1", new Point(1326, 468), new Lane[]{M7_1_1, M7_2_1}, new int[]{1}, null);
        lineEnds.add(leD_M5_1);
 /*10*/ Dissection leD_M5_2 = new Dissection(S, 5, "leD_M5_2", new Point(1352, 468), new Lane[]{V3_1}, new int[]{2}, null);
        lineEnds.add(leD_M5_2);
        Dissection leD_M5_3 = new Dissection(S, 6, "leD_M5_3", new Point(1378, 468), new Lane[]{V3_2}, new int[]{2}, null);
        lineEnds.add(leD_M5_3);

        Intersection leI_M7_1_1 = new Intersection(S, "leI_M7_1_1", new Point(1196, 461), M7_1_2, new int[]{1, 2, 3, 4}, LaneEnd.LINEEND_RED);
        lineEnds.add(leI_M7_1_1);
        Intersection leI_M7_2_1 = new Intersection(S, "leI_M7_2_1", new Point(1196, 435), M7_2_2, new int[]{2, 3, 4, 5, 6}, LaneEnd.LINEEND_RED);
        lineEnds.add(leI_M7_2_1);

        Dissection leD_A2_1_1 = new Dissection(S, 7, "leD_A2_1_1", new Point(1202, 403), new Lane[]{A2_1_2}, new int[]{1}, null);
        lineEnds.add(leD_A2_1_1);
        Dissection leD_A2_2_1 = new Dissection(S, 8, "leD_A2_2_1", new Point(1176, 403), new Lane[]{A2_2_2}, new int[]{1}, null);
        lineEnds.add(leD_A2_2_1);
        Dissection leD_A2_3_1 = new Dissection(S, 9, "leD_A2_3_1", new Point(1150, 403), new Lane[]{A2_3_2, M81_1_1}, new int[]{1, 2}, null);
        lineEnds.add(leD_A2_3_1);
        Intersection leI_A2_1_2 = new Intersection(S, "leI_A2_1_2", new Point(1150, 468), M6_1_1, new int[]{1, 2, 3, 4});
        lineEnds.add(leI_A2_1_2);
        Intersection leI_A2_2_2 = new Intersection(S, "leI_A2_2_2", new Point(1124, 468), M6_2_1, new int[]{2, 3, 4, 5, 6});
        lineEnds.add(leI_A2_2_2);
        Intersection leI_A2_3_2 = new Intersection(S, "leI_A2_3_2", new Point(1098, 468), M6_3_1, new int[]{2, 3, 4, 5, 6});
        lineEnds.add(leI_A2_3_2);

        /*20*/ Junction leJ_M6_1_1 = new Junction(S, "leJ_M6_1_1", new Point(916, 655), new Lane[]{M6_4, M6_1_2}, new int[]{1, 2, 3});
        lineEnds.add(leJ_M6_1_1);
        Intersection leI_M6_2_1 = new Intersection(S, "leJ_M6_2_1", new Point(890, 655), M6_2_2, new int[]{2, 3, 4});
        lineEnds.add(leI_M6_2_1);
        Junction leJ_M6_3_1 = new Junction(S, "leJ_M6_3_1", new Point(864, 655), new Lane[]{M6_3_2, M6_5}, new int[]{2, 3, 4, 5, 6});
        lineEnds.add(leJ_M6_3_1);

        Intersection leI_M6_5 = new Intersection(S, "leI_M6_5", new Point(812, 780), K1_3, new int[]{6}, LaneEnd.LINEEND_RED);
        lineEnds.add(leI_M6_5);
        Junction leJ_M6_3_2 = new Junction(S, "leJ_M6_3_2", new Point(838, 780), new Lane[]{K1_4, K1_5}, new int[]{3, 4, 5, 6}, LaneEnd.LINEEND_RED);
        lineEnds.add(leJ_M6_3_2);
        Dissection leD_M6_2_2 = new Dissection(S, 10, "leD_M6_2_2", new Point(864, 780), new Lane[]{K1_6}, new int[]{2, 3}, new int[]{6}, LaneEnd.LINEEND_RED);
        lineEnds.add(leD_M6_2_2);
        Dissection leD_M6_1_2 = new Dissection(S, 11, "leD_M6_1_2", new Point(890, 780), new Lane[]{K1_7}, new int[]{1, 2, 3}, new int[]{6}, LaneEnd.LINEEND_RED);
        lineEnds.add(leD_M6_1_2);
        Dissection leD_M6_4 = new Dissection(S, 12, "leD_M6_4", new Point(916, 780), new Lane[]{K1_8}, new int[]{1}, new int[]{6}, LaneEnd.LINEEND_RED);
        lineEnds.add(leD_M6_4);
        //M8, V4, A3, M9, M10
        Dissection leD_M81_1_1 = new Dissection(S, 14, "leD_M81_1_1", new Point(793, 448), new Lane[]{M81_1_2, V4_1}, new int[]{7}, null);
        lineEnds.add(leD_M81_1_1);
        Intersection leI_M81_1_2 = new Intersection(S, "leI_M81_1_2", new Point(676, 461), M9_1, new int[]{6});
        lineEnds.add(leI_M81_1_2);

        /*30*/ Intersection leI_M82_1_1 = new Intersection(S, "leI_M82_1_1", new Point(780, 474), M82_1_2, new int[]{1});
        lineEnds.add(leI_M82_1_1);
        Dissection leD_M82_1_2 = new Dissection(S, 13, "leD_M82_1_2", new Point(1053, 435), new Lane[]{M82_1_3}, new int[]{1}, null, LaneEnd.LINEEND_RED);
        lineEnds.add(leD_M82_1_2);

        Junction leJ_A3_1_1 = new Junction(S, "leJ_A3_1_1", new Point(760, 429), new Lane[]{M82_1_1, A3_1_2}, new int[]{1, 6});
        lineEnds.add(leJ_A3_1_1);

        Intersection leI_M10_1 = new Intersection(S, "leI_M10_1", new Point(299, 530), V5_1, new int[]{6});
        lineEnds.add(leI_M10_1);
        Intersection leI_M10_2 = new Intersection(S, "leI_M10_2", new Point(318, 520), V5_2, new int[]{6});
        lineEnds.add(leI_M10_2);
        //A4, A5, M11
        Dissection leD_A4_1 = new Dissection(S, 15, "leD_A4_1", new Point(741, 864), new Lane[]{K1_9, K1_10}, new int[]{1, 2, 3}, new int[]{4, 5}, LaneEnd.LINEEND_RED);
        lineEnds.add(leD_A4_1);
        Dissection leD_A4_2 = new Dissection(S, 16, "leD_A4_2", new Point(741, 890), new Lane[]{K1_11}, new int[]{3, 4, 5}, new int[]{1, 2}, LaneEnd.LINEEND_RED);
        lineEnds.add(leD_A4_2);

        Dissection leD_A5_1 = new Dissection(S, 17, "leD_A5_1", new Point(715, 981), new Lane[]{K1_13}, new int[]{1, 2, 3}, new int[]{4}, LaneEnd.LINEEND_RED);
        lineEnds.add(leD_A5_1);
        Junction leJ_A5_2 = new Junction(S, "leJ_A5_2", new Point(715, 1007), new Lane[]{K1_14, K1_15}, new int[]{1, 2, 3, 4}, LaneEnd.LINEEND_RED);
        lineEnds.add(leJ_A5_2);

        Dissection leD_M11_1 = new Dissection(S, 18, "leI_M11_1", new Point(1144, 1495), new Lane[]{M12_1_1}, new int[]{1}, null, LaneEnd.LINEEND_RED);
        lineEnds.add(leD_M11_1);
        /*40*/ Dissection leI_M11_2 = new Dissection(S, 19, "leI_M11_2", new Point(1118, 1495), new Lane[]{V8_1}, new int[]{2}, new int[]{1});
        lineEnds.add(leI_M11_2);
        Dissection leI_M11_3 = new Dissection(S, 20, "leI_M11_3", new Point(1092, 1495), new Lane[]{V8_2}, new int[]{2}, new int[]{1});
        lineEnds.add(leI_M11_3);
        //A6, M12, M13, M14
        Intersection leI_A6_1 = new Intersection(S, "leI_A6_1", new Point(1170, 1495), M12_1_2, new int[]{1});
        lineEnds.add(leI_A6_1);
        Intersection leI_A6_2 = new Intersection(S, "leI_A6_2", new Point(1196, 1495), M12_2, new int[]{1, 2});
        lineEnds.add(leI_A6_2);
        Intersection leI_A6_3 = new Intersection(S, "leI_A6_3", new Point(1222, 1495), M12_3, new int[]{1, 2});
        lineEnds.add(leI_A6_3);

        Dissection leD_M12_1_2 = new Dissection(S, 21, "leI_M12_1_2", new Point(1371, 1317), new Lane[]{M13_1}, new int[]{1}, null);
        lineEnds.add(leD_M12_1_2);
        Dissection leD_M12_2 = new Dissection(S, 22, "leI_M12_2", new Point(1397, 1317), new Lane[]{M13_2}, new int[]{1}, null);
        lineEnds.add(leD_M12_2);
        Dissection leD_M12_3 = new Dissection(S, 23, "leI_M12_3", new Point(1423, 1317), new Lane[]{M13_3, M14_1}, new int[]{1, 2}, null);
        lineEnds.add(leD_M12_3);

        Dissection leD_M13_1 = new Dissection(S, 25, "leI_M13_1", new Point(1371, 1007), new Lane[]{K2_9_1}, new int[]{1, 2}, new int[]{3}, LaneEnd.LINEEND_RED);
        lineEnds.add(leD_M13_1);
        Dissection leD_M13_2 = new Dissection(S, 26, "leI_M13_2", new Point(1397, 1007), new Lane[]{K2_10_1}, new int[]{1, 2}, new int[]{3}, LaneEnd.LINEEND_RED);
        lineEnds.add(leD_M13_2);
        /*50*/ Junction leJ_M13_3 = new Junction(S, "leJ_M13_3", new Point(1423, 1007), new Lane[]{K2_11, K2_12}, new int[]{1, 2, 3}, LaneEnd.LINEEND_RED);
        lineEnds.add(leJ_M13_3);

        //M1, M2
        Intersection leI_M1_1 = new Intersection(S, "leI_M1_1", new Point(988, 832), K1_2, new int[]{6}, LaneEnd.LINEEND_RED);
        lineEnds.add(leI_M1_1);
        Intersection leI_M1_2 = new Intersection(S, "leI_M1_2", new Point(988, 806), K1_1, new int[]{6}, LaneEnd.LINEEND_RED);
        lineEnds.add(leI_M1_2);

        Dissection leD_M2_1 = new Dissection(S, 27, "leD_M2_1", new Point(1326, 884), new Lane[]{K2_5}, new int[]{1}, null, LaneEnd.LINEEND_RED);
        lineEnds.add(leD_M2_1);
        Dissection leD_M2_2 = new Dissection(S, 28, "leD_M2_2", new Point(1326, 910), new Lane[]{K2_6}, new int[]{1}, null, LaneEnd.LINEEND_RED);
        lineEnds.add(leD_M2_2);
        Dissection leD_M2_3 = new Dissection(S, 29, "leD_M2_3", new Point(1326, 936), new Lane[]{K2_7}, new int[]{2}, null, LaneEnd.LINEEND_RED);
        lineEnds.add(leD_M2_3);
        Dissection leD_M2_4 = new Dissection(S, 30, "leD_M2_4", new Point(1326, 962), new Lane[]{K2_8}, new int[]{2}, null, LaneEnd.LINEEND_RED);
        lineEnds.add(leD_M2_4);

	//K2        //				      Name	Coordinates  succeedingLines leadingToDirections relevant Directions
        Intersection leI_K2_1 = new Intersection(S, "leI_K2_1", new Point(1371, 715), M5_1, new int[]{1});
        lineEnds.add(leI_K2_1);
        Intersection leI_K2_2 = new Intersection(S, "leI_K2_2", new Point(1397, 715), M5_2, new int[]{1, 2});
        lineEnds.add(leI_K2_2);
        Intersection leI_K2_3 = new Intersection(S, "leI_K2_3", new Point(1423, 715), M5_3, new int[]{2});
        lineEnds.add(leI_K2_3);
        /*60*/ Intersection leI_K2_4 = new Intersection(S, "leI_K2_4", new Point(1452, 741), K2_1_2, new int[]{1, 2}, LaneEnd.LINEEND_RED);
        lineEnds.add(leI_K2_4);
        Intersection leI_K2_5 = new Intersection(S, "leI_K2_5", new Point(1463, 731), K2_2_2, new int[]{1, 2}, LaneEnd.LINEEND_RED);
        lineEnds.add(leI_K2_5);

        Intersection leI_K2_6 = new Intersection(S, "leI_K2_6", new Point(1326, 806), M1_2, new int[]{6});
        lineEnds.add(leI_K2_6);
        Intersection leI_K2_7 = new Intersection(S, "leI_K2_7", new Point(1326, 832), M1_1, new int[]{6});
        lineEnds.add(leI_K2_7);

        Intersection leI_K2_8 = new Intersection(S, "leI_K2_8", new Point(1371, 884), K2_9_2, new int[]{1, 2});
        lineEnds.add(leI_K2_8);
        Intersection leI_K2_9 = new Intersection(S, "leI_K2_9", new Point(1397, 884), K2_10_2, new int[]{1, 2});
        lineEnds.add(leI_K2_9);

        Intersection leI_K2_10 = new Intersection(S, "leI_K2_10", new Point(1469, 936), M4_1, new int[]{3});
        lineEnds.add(leI_K2_10);
        Intersection leI_K2_11 = new Intersection(S, "leI_K2_11", new Point(1469, 962), M4_2, new int[]{3});
        lineEnds.add(leI_K2_11);

	//"Leading To" benutzen um die Autos auf spuren zu lenken, die nicht so viele andere Spuren kreuzen..?
        //K1
        //				       Name,succeeding Lines,leadingToDirections, relevant Directions
        Intersection leI_K1_1 = new Intersection(S, "leI_K1_1", new Point(741, 832), M10_1, new int[]{6});
        lineEnds.add(leI_K1_1);
        Intersection leI_K1_2 = new Intersection(S, "leI_K1_2", new Point(741, 806), M10_2, new int[]{6});
        lineEnds.add(leI_K1_2);
        Intersection leI_K1_3 = new Intersection(S, "leI_K1_3", new Point(715, 929), V6_2, new int[]{5});
        lineEnds.add(leI_K1_3);
        Intersection leI_K1_4 = new Intersection(S, "leI_K1_4", new Point(754, 1027), V7_1, new int[]{4});
        lineEnds.add(leI_K1_4);
        Dissection leD_K1_5 = new Dissection(S, 31, "leD_K1_5", new Point(864, 1040), new Lane[]{M11_3}, new int[]{3}, null);
        lineEnds.add(leD_K1_5);
        Dissection leD_K1_6 = new Dissection(S, 32, "leD_K1_6", new Point(890, 1040), new Lane[]{M11_2}, new int[]{3}, null);
        lineEnds.add(leD_K1_6);
        Dissection leD_K1_7 = new Dissection(S, 33, "leD_K1_7", new Point(916, 1040), new Lane[]{M11_1}, new int[]{3}, null);
        lineEnds.add(leD_K1_7);

        Intersection leI_K1_8 = new Intersection(S, "leI_K1_8", new Point(988, 884), M2_1, new int[]{1});
        lineEnds.add(leI_K1_8);
        Intersection leI_K1_9 = new Intersection(S, "leI_K1_9", new Point(988, 910), M2_2, new int[]{1, 2});
        lineEnds.add(leI_K1_9);
        Intersection leI_K1_10 = new Intersection(S, "leI_K1_10", new Point(988, 936), M2_3, new int[]{2});
        lineEnds.add(leI_K1_10);
        Intersection leI_K1_11 = new Intersection(S, "leI_K1_11", new Point(988, 962), M2_4, new int[]{2});
        lineEnds.add(leI_K1_11);

        Dissection leD_K1_12 = new Dissection(S, 34, "leD_K1_12", new Point(838, 890), new Lane[]{K1_17, K1_16, K1_12}, new int[]{3, 4, 5}, new int[]{1, 2});
        lineEnds.add(leD_K1_12);
        Dissection leD_K1_13 = new Dissection(S, 35, "leD_K1_13", new Point(864, 890), new Lane[]{K1_24, K1_18}, new int[]{3}, new int[]{4, 5});
        lineEnds.add(leD_K1_13);
        Dissection leD_K1_14 = new Dissection(S, 36, "leD_K1_14", new Point(890, 890), new Lane[]{K1_22, K1_23, K1_19}, new int[]{1, 2, 3}, new int[]{4, 5});
        lineEnds.add(leD_K1_14);
        Dissection leD_K1_15 = new Dissection(S, 37, "leD_K1_15", new Point(916, 884), new Lane[]{K1_21}, new int[]{1}, new int[]{3, 4, 5});
        lineEnds.add(leD_K1_15);

        Dissection leD_K1_16 = new Dissection(S, 38, "leD_K1_16", new Point(858, 949), new Lane[]{K1_25, K1_26}, new int[]{1, 2}, new int[]{3});
        lineEnds.add(leD_K1_16);
        Junction leJ_K1_17 = new Junction(S, "leJ_K1_17", new Point(864, 975), new Lane[]{K1_27, K1_20}, new int[]{1, 2, 3});
        lineEnds.add(leJ_K1_17);

        Intersection leI_M12_1_1 = new Intersection(S, "leI_M12_1_1", new Point(1170, 1495), M12_1_2, new int[]{1, 2});
        lineEnds.add(leI_M12_1_1);

        //****************endPoints & Neighbourhood******************
        A1_1.set_N_eP(null, A1_2, leD_A1_1);
        A1_2.set_N_eP(A1_1, null, leJ_A1_2);
        V1_1.set_N_eP(null, V1_2, S_V1_1);
        V1_2.set_N_eP(V1_1, null, S_V1_2);

        V2_1.set_N_eP(null, null, S_V2_1);

        A2_1_1.set_N_eP(null, A2_2_1, leD_A2_1_1);
        A2_2_1.set_N_eP(A2_1_1, A2_3_1, leD_A2_2_1);
        A2_3_1.set_N_eP(A2_2_1, null, leD_A2_3_1);
        A2_1_2.set_N_eP(null, A2_2_2, leI_A2_1_2);
        A2_2_2.set_N_eP(A2_1_2, A2_3_2, leI_A2_2_2);
        A2_3_2.set_N_eP(A2_2_2, null, leI_A2_3_2);
        V3_1.set_N_eP(null, V3_2, S_V3_1);
        V3_2.set_N_eP(V3_1, null, S_V3_2);

        A3_1_1.set_N_eP(null, null, leJ_A3_1_1);
        A3_1_2.set_N_eP(null, null, leI_M81_1_2);
        V4_1.set_N_eP(null, null, S_V4_1);

        A4_1.set_N_eP(null, A4_2, leD_A4_1);
        A4_2.set_N_eP(A4_1, null, leD_A4_2);
        V5_1.set_N_eP(null, V5_2, S_V5_1);
        V5_2.set_N_eP(V5_1, null, S_V5_2);

        A5_1.set_N_eP(null, A5_2, leD_A5_1);
        A5_2.set_N_eP(A5_1, null, leJ_A5_2);
        V6_1.set_N_eP(null, V6_2, S_V6_1);
        V6_2.set_N_eP(V6_1, null, S_V6_2);

        V7_1.set_N_eP(null, null, S_V7_1);

        A6_1.set_N_eP(null, A6_2, leI_A6_1);
        A6_2.set_N_eP(A6_1, A6_3, leI_A6_2);
        A6_3.set_N_eP(A6_2, null, leI_A6_3);
        V8_1.set_N_eP(null, V8_2, S_V8_1);
        V8_2.set_N_eP(V8_1, null, S_V8_2);

        //*******************************
        M1_1.set_N_eP(M1_2, null, leI_M1_1);
        M1_2.set_N_eP(null, M1_1, leI_M1_2);

        M2_1.set_N_eP(null, M2_2, leD_M2_1);
        M2_2.set_N_eP(M2_1, M2_3, leD_M2_2);
        M2_3.set_N_eP(M2_2, M2_4, leD_M2_3);
        M2_4.set_N_eP(M2_3, null, leD_M2_4);

        M3_1_1.set_N_eP(null, M3_2_1, leD_M3_1_1);
        M3_1_2.set_N_eP(null, M3_2_2, leI_M3_1_2);
        M3_2_1.set_N_eP(M3_1_1, null, leD_M3_2_1);
        M3_2_2.set_N_eP(M3_1_2, null, leI_M3_2_2);

        M4_1.set_N_eP(null, M4_2, leI_M4_1);
        M4_2.set_N_eP(M4_1, null, leD_M4_2);

        M5_1.set_N_eP(null, M5_2, leD_M5_1);
        M5_2.set_N_eP(M5_1, M5_3, leD_M5_2);
        M5_3.set_N_eP(M5_2, null, leD_M5_3);

        M6_1_1.set_N_eP(null, M6_2_1, leJ_M6_1_1);
        M6_1_2.set_N_eP(M6_4, M6_2_2, leD_M6_1_2);
        M6_2_1.set_N_eP(M6_1_1, M6_3_1, leI_M6_2_1);
        M6_2_2.set_N_eP(M6_1_2, M6_3_2, leD_M6_2_2);
        M6_3_1.set_N_eP(M6_2_1, null, leJ_M6_3_1);
        M6_3_2.set_N_eP(M6_2_2, M6_5, leJ_M6_3_2);
        M6_4.set_N_eP(null, M6_1_2, leD_M6_4);
        M6_5.set_N_eP(M6_3_2, null, leI_M6_5);

        M7_1_1.set_N_eP(null, M7_2_1, leI_M7_1_1);
        M7_2_1.set_N_eP(M7_1_1, null, leI_M7_2_1);
        M7_1_2.set_N_eP(null, M7_2_2, leI_A2_1_2);
        M7_2_2.set_N_eP(null, null, leI_A2_2_2);

        M81_1_1.set_N_eP(null, null, leD_M81_1_1);
        M81_1_2.set_N_eP(null, null, leI_M81_1_2);

        M82_1_1.set_N_eP(null, null, leI_M82_1_1);
        M82_1_2.set_N_eP(null, null, leD_M82_1_2);
        M82_1_3.set_N_eP(null, null, leI_A2_3_2);

        M9_1.set_N_eP(null, null, leI_M10_2);

        M10_1.set_N_eP(null, M10_2, leI_M10_1);
        M10_2.set_N_eP(M10_1, null, leI_M10_2);

        M11_1.set_N_eP(null, M11_2, leD_M11_1);
        M11_2.set_N_eP(M11_1, M11_3, leI_M11_2);
        M11_3.set_N_eP(M11_2, null, leI_M11_3);

        M12_1_1.set_N_eP(null, null, leI_M12_1_1);
        M12_1_2.set_N_eP(null, M12_2, leD_M12_1_2);
        M12_2.set_N_eP(M12_1_2, M12_3, leD_M12_2);
        M12_3.set_N_eP(M12_2, null, leD_M12_3);

        M13_1.set_N_eP(null, M13_2, leD_M13_1);
        M13_2.set_N_eP(M13_1, M13_3, leD_M13_2);
        M13_3.set_N_eP(M13_2, null, leJ_M13_3);

        M14_1.set_N_eP(null, null, leD_M4_2);

		//**********************************
        //M3 > M5
        K2_1_1.set_N_eP(null, K2_2_1, leI_K2_4);
        K2_2_1.set_N_eP(K2_1_1, null, leI_K2_5);
        K2_1_2.set_N_eP(null, K2_2_2, leI_K2_2);
        K2_2_2.set_N_eP(K2_1_2, null, leI_K2_3);
        //M3 > M1
        K2_3.set_N_eP(K2_4, null, leI_K2_6);
        K2_4.set_N_eP(null, K2_3, leI_K2_7);
        //M2 > M5
        K2_5.set_N_eP(null, K2_6, leI_K2_8);
        K2_6.set_N_eP(K2_5, null, leI_K2_9);
        //M2 > M4
        K2_7.set_N_eP(null, K2_8, leI_K2_10);
        K2_8.set_N_eP(K2_7, null, leI_K2_11);
        //M13 > M5
        K2_9_1.set_N_eP(null, K2_10_1, leI_K2_8);
        K2_9_2.set_N_eP(null, K2_10_2, leI_K2_1);
        K2_10_1.set_N_eP(K2_9_1, null, leI_K2_9);
        K2_10_2.set_N_eP(K2_9_2, null, leI_K2_2);
        K2_11.set_N_eP(null, null, leI_K2_3);
        //M13 > M4
        K2_12.set_N_eP(null, null, leI_K2_11);

        //M1 > M10
        K1_1.set_N_eP(K1_2, null, leI_K1_2);
        K1_2.set_N_eP(null, K1_1, leI_K1_1);
        //M6 > M10
        K1_3.set_N_eP(K1_4, null, leI_K1_2);
        K1_4.set_N_eP(null, K1_3, leI_K1_1);
        //M6 > V6, V7, M11, M2
        K1_5.set_N_eP(K1_6, null, leD_K1_12);
        K1_6.set_N_eP(K1_7, K1_5, leD_K1_13);
        K1_7.set_N_eP(K1_8, K1_6, leD_K1_14);
        K1_8.set_N_eP(null, K1_7, leD_K1_15);
        //A4 > V6, V7, M11, M2
        K1_9.set_N_eP(null, K1_10, leD_K1_15);
        K1_10.set_N_eP(K1_9, null, leD_K1_14);
        K1_11.set_N_eP(null, null, leD_K1_12);
        //M6, A4 > V6
        K1_12.set_N_eP(null, null, leI_K1_3);
        //A5 > V7, M11, M2
        K1_13.set_N_eP(null, K1_14, leD_K1_16);
        K1_14.set_N_eP(K1_13, null, leJ_K1_17);
        K1_15.set_N_eP(null, null, leI_K1_4);
        //M6, A4 > V7
        K1_16.set_N_eP(null, null, leI_K1_4);
        //M6, A4 > M11
        K1_17.set_N_eP(K1_18, null, leD_K1_5);
        K1_18.set_N_eP(K1_19, K1_17, leD_K1_6);
        K1_19.set_N_eP(null, K1_18, leD_K1_7);
        //A5 > M11
        K1_20.set_N_eP(K1_18, null, leD_K1_5);
        //M6 > M2,A4
        K1_21.set_N_eP(null, null, leI_K1_8);
        K1_22.set_N_eP(null, K1_23, leI_K1_9);
        K1_23.set_N_eP(K1_22, K1_24, leI_K1_10);
        K1_24.set_N_eP(K1_23, null, leI_K1_11);

        //A5 > M2
        K1_25.set_N_eP(null, K1_26, leI_K1_8);
        K1_26.set_N_eP(K1_25, K1_27, leI_K1_9);
        K1_27.set_N_eP(K1_26, null, leI_K1_10);
        //********************************

        //******************************************************************************************
        S.lines = lines.toArray(new Lane[lines.size()]);
        S.sinks = sinks.toArray(new Sink[sinks.size()]);
        S.springs = springs.toArray(new Spring[springs.size()]);
        S.lineEnds = lineEnds.toArray(new LaneEnd[lineEnds.size()]);

	//******************Add first Events********************************************************************
        //M6
        S.events.add(new TrafficLight_Event(S, S.lineEnds[22], LaneEnd.LINEEND_GREEN, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[23], LaneEnd.LINEEND_GREEN, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[24], LaneEnd.LINEEND_GREEN, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[25], LaneEnd.LINEEND_GREEN, 0));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[26], LaneEnd.LINEEND_GREEN, 0));

        S.events.add(new TrafficLight_Event(S, S.lineEnds[22], LaneEnd.LINEEND_YELLOW, 39));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[23], LaneEnd.LINEEND_YELLOW, 39));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[24], LaneEnd.LINEEND_YELLOW, 39));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[25], LaneEnd.LINEEND_YELLOW, 39));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[26], LaneEnd.LINEEND_YELLOW, 39));

        S.events.add(new TrafficLight_Event(S, S.lineEnds[22], LaneEnd.LINEEND_RED, 41));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[23], LaneEnd.LINEEND_RED, 41));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[24], LaneEnd.LINEEND_RED, 41));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[25], LaneEnd.LINEEND_RED, 41));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[26], LaneEnd.LINEEND_RED, 41));

        //A4
        S.events.add(new TrafficLight_Event(S, S.lineEnds[34], LaneEnd.LINEEND_GREEN, 44));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[35], LaneEnd.LINEEND_GREEN, 44));

        S.events.add(new TrafficLight_Event(S, S.lineEnds[34], LaneEnd.LINEEND_YELLOW, 71));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[35], LaneEnd.LINEEND_YELLOW, 71));

        S.events.add(new TrafficLight_Event(S, S.lineEnds[34], LaneEnd.LINEEND_RED, 73));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[35], LaneEnd.LINEEND_RED, 73));

        //A5
        S.events.add(new TrafficLight_Event(S, S.lineEnds[36], LaneEnd.LINEEND_GREEN, 75));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[37], LaneEnd.LINEEND_GREEN, 75));

        S.events.add(new TrafficLight_Event(S, S.lineEnds[36], LaneEnd.LINEEND_YELLOW, 101));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[37], LaneEnd.LINEEND_YELLOW, 101));

        S.events.add(new TrafficLight_Event(S, S.lineEnds[36], LaneEnd.LINEEND_RED, 103));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[37], LaneEnd.LINEEND_RED, 103));

        //M1
        S.events.add(new TrafficLight_Event(S, S.lineEnds[50], LaneEnd.LINEEND_GREEN, 53));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[51], LaneEnd.LINEEND_GREEN, 53));

        S.events.add(new TrafficLight_Event(S, S.lineEnds[50], LaneEnd.LINEEND_YELLOW, 77));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[51], LaneEnd.LINEEND_YELLOW, 77));

        S.events.add(new TrafficLight_Event(S, S.lineEnds[50], LaneEnd.LINEEND_RED, 79));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[51], LaneEnd.LINEEND_RED, 79));

        //M2L
        S.events.add(new TrafficLight_Event(S, S.lineEnds[52], LaneEnd.LINEEND_GREEN, 78));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[53], LaneEnd.LINEEND_GREEN, 78));

        S.events.add(new TrafficLight_Event(S, S.lineEnds[52], LaneEnd.LINEEND_YELLOW, 107));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[53], LaneEnd.LINEEND_YELLOW, 107));

        S.events.add(new TrafficLight_Event(S, S.lineEnds[52], LaneEnd.LINEEND_RED, 108));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[53], LaneEnd.LINEEND_RED, 108));

        //M2G
        S.events.add(new TrafficLight_Event(S, S.lineEnds[54], LaneEnd.LINEEND_GREEN, 49));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[55], LaneEnd.LINEEND_GREEN, 49));

        S.events.add(new TrafficLight_Event(S, S.lineEnds[54], LaneEnd.LINEEND_YELLOW, 107));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[55], LaneEnd.LINEEND_YELLOW, 107));

        S.events.add(new TrafficLight_Event(S, S.lineEnds[54], LaneEnd.LINEEND_RED, 109));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[55], LaneEnd.LINEEND_RED, 109));

        //A6
        S.events.add(new TrafficLight_Event(S, S.lineEnds[41], LaneEnd.LINEEND_YELLOW, 5));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[42], LaneEnd.LINEEND_YELLOW, 5));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[43], LaneEnd.LINEEND_YELLOW, 5));

        S.events.add(new TrafficLight_Event(S, S.lineEnds[41], LaneEnd.LINEEND_RED, 7));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[42], LaneEnd.LINEEND_RED, 7));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[43], LaneEnd.LINEEND_RED, 7));

        S.events.add(new TrafficLight_Event(S, S.lineEnds[41], LaneEnd.LINEEND_GREEN, 19));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[42], LaneEnd.LINEEND_GREEN, 19));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[43], LaneEnd.LINEEND_GREEN, 19));

        //M11
        S.events.add(new TrafficLight_Event(S, S.lineEnds[38], LaneEnd.LINEEND_GREEN, 8));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[38], LaneEnd.LINEEND_YELLOW, 17));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[38], LaneEnd.LINEEND_RED, 18));

        //M13
        S.events.add(new TrafficLight_Event(S, S.lineEnds[47], LaneEnd.LINEEND_GREEN, 13));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[48], LaneEnd.LINEEND_GREEN, 13));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[49], LaneEnd.LINEEND_GREEN, 13));

        S.events.add(new TrafficLight_Event(S, S.lineEnds[47], LaneEnd.LINEEND_YELLOW, 41));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[48], LaneEnd.LINEEND_YELLOW, 41));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[49], LaneEnd.LINEEND_YELLOW, 41));

        S.events.add(new TrafficLight_Event(S, S.lineEnds[47], LaneEnd.LINEEND_RED, 44));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[48], LaneEnd.LINEEND_RED, 44));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[49], LaneEnd.LINEEND_RED, 44));

        //M3G
        S.events.add(new TrafficLight_Event(S, S.lineEnds[4], LaneEnd.LINEEND_GREEN, 48));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[5], LaneEnd.LINEEND_GREEN, 48));

        S.events.add(new TrafficLight_Event(S, S.lineEnds[4], LaneEnd.LINEEND_YELLOW, 73));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[5], LaneEnd.LINEEND_YELLOW, 73));

        S.events.add(new TrafficLight_Event(S, S.lineEnds[4], LaneEnd.LINEEND_RED, 75));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[5], LaneEnd.LINEEND_RED, 75));

        //M3R
        S.events.add(new TrafficLight_Event(S, S.lineEnds[59], LaneEnd.LINEEND_GREEN, 46));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[60], LaneEnd.LINEEND_GREEN, 46));

        S.events.add(new TrafficLight_Event(S, S.lineEnds[59], LaneEnd.LINEEND_YELLOW, 76));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[60], LaneEnd.LINEEND_YELLOW, 76));

        S.events.add(new TrafficLight_Event(S, S.lineEnds[59], LaneEnd.LINEEND_RED, 77));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[60], LaneEnd.LINEEND_RED, 77));

        //M7, M8.2
        S.events.add(new TrafficLight_Event(S, S.lineEnds[11], LaneEnd.LINEEND_GREEN, 78));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[12], LaneEnd.LINEEND_GREEN, 78));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[30], LaneEnd.LINEEND_GREEN, 78));

        S.events.add(new TrafficLight_Event(S, S.lineEnds[11], LaneEnd.LINEEND_YELLOW, 96));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[12], LaneEnd.LINEEND_YELLOW, 96));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[30], LaneEnd.LINEEND_YELLOW, 96));

        S.events.add(new TrafficLight_Event(S, S.lineEnds[11], LaneEnd.LINEEND_RED, 98));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[12], LaneEnd.LINEEND_RED, 98));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[30], LaneEnd.LINEEND_RED, 98));

        //A2
        S.events.add(new TrafficLight_Event(S, S.lineEnds[13], LaneEnd.LINEEND_GREEN, 101));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[14], LaneEnd.LINEEND_GREEN, 101));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[15], LaneEnd.LINEEND_GREEN, 101));

        S.events.add(new TrafficLight_Event(S, S.lineEnds[13], LaneEnd.LINEEND_YELLOW, 74));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[14], LaneEnd.LINEEND_YELLOW, 74));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[15], LaneEnd.LINEEND_YELLOW, 74));

        S.events.add(new TrafficLight_Event(S, S.lineEnds[13], LaneEnd.LINEEND_RED, 76));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[14], LaneEnd.LINEEND_RED, 76));
        S.events.add(new TrafficLight_Event(S, S.lineEnds[15], LaneEnd.LINEEND_RED, 76));

	//******************************************************************************************
        //******************Add first Agents********************************************************************
        S.events.add(new NewAgent_Event(S, (-1.0 * S.getLanePredictant(SPA1_1.id) * Math.log(S.getDouble())), SPA1_1));
        S.events.add(new NewAgent_Event(S, (-1.0 * S.getLanePredictant(SPA1_2.id) * Math.log(S.getDouble())), SPA1_2));
        S.events.add(new NewAgent_Event(S, (-1.0 * S.getLanePredictant(SPA2_1.id) * Math.log(S.getDouble())), SPA2_1));
        S.events.add(new NewAgent_Event(S, (-1.0 * S.getLanePredictant(SPA2_2.id) * Math.log(S.getDouble())), SPA2_2));
        S.events.add(new NewAgent_Event(S, (-1.0 * S.getLanePredictant(SPA2_3.id) * Math.log(S.getDouble())), SPA2_3));
        S.events.add(new NewAgent_Event(S, (-1.0 * S.getLanePredictant(SPA3_1.id) * Math.log(S.getDouble())), SPA3_1));
        S.events.add(new NewAgent_Event(S, (-1.0 * S.getLanePredictant(SPA4_1.id) * Math.log(S.getDouble())), SPA4_1));
        S.events.add(new NewAgent_Event(S, (-1.0 * S.getLanePredictant(SPA4_2.id) * Math.log(S.getDouble())), SPA4_2));
        S.events.add(new NewAgent_Event(S, (-1.0 * S.getLanePredictant(SPA5_1.id) * Math.log(S.getDouble())), SPA5_1));
        S.events.add(new NewAgent_Event(S, (-1.0 * S.getLanePredictant(SPA5_2.id) * Math.log(S.getDouble())), SPA5_2));
        S.events.add(new NewAgent_Event(S, (-1.0 * S.getLanePredictant(SPA6_1.id) * Math.log(S.getDouble())), SPA6_1));
        S.events.add(new NewAgent_Event(S, (-1.0 * S.getLanePredictant(SPA6_2.id) * Math.log(S.getDouble())), SPA6_2));
        S.events.add(new NewAgent_Event(S, (-1.0 * S.getLanePredictant(SPA6_3.id) * Math.log(S.getDouble())), SPA6_3));

	//******************************************************************************************
        System.out.println("Duration of the initialization: " + (System.currentTimeMillis() - t) / 1000 + "sec");

    }

}
