package sweetwaterCity;

public class Probabilities {

    private static double[] Predictants = new double[] {6,2,20,5,4,6,3,5,7,1,10};

    public  static int getDirection(int id, int oldDirection, int seed) 
    {

        switch(id){
            //A1_1
            case 1: return(seed<80?2 : 1);
            //M3 _1_1
            case 2: return(6);
            //M3_2_1
            case 3: return(oldDirection==2? (seed<60? 1 : 2) : 6);
            //M4
            case 4: return(3);
            //M5:
            case 5:
            case 6: return(2);
            case 7: return (seed<60? 3 : seed<70? 6 :seed<80?2 : seed<85?7:3);
            //M6:
            case 8: if(oldDirection==2) return 7;
            case 9:
            case 10:
            case 11: return(seed<13?6 : seed<36?5 : seed<40?4 : seed<86?3 : seed<95?2 : 1);
            //M6 > K2
            case 12:
            case 13: return(4);
            case 14: return(3);
            //M81_1_1
            case 15: return(seed<60? 6 : 1);
            //M11_1
            case 16: return(seed<50?1 : 2);
            //A4 > K1
            case 17: 
            case 18: return(3);
            //A5 > K1
            case 19: return(3);
            //M11 _1/_2
            case 20:
            case 21: return(2);
            //M12
            case 22: if(oldDirection==2) return 4;
            case 23:
            case 24: return (seed<9?1 : seed<98?2 : 3);
            //M13
            case 25:
            case 26: return(2);
            //M2
            case 27:
            case 28: return(seed<5?1 : 2);
            case 29:
            case 30: return(3);

            //K1
            //5-7
            case 31:
            case 32:
            case 33: return(seed<96?2 : 1);
            //12-15
            case 34: 
            case 35: 
            case 36: return(3);
            case 37: return(2);
            //16:
            case 38: return(2);
            case 39: return(10);


            default: System.out.println("!!!!!!!!!!!!!!!!Probabilities: An ID of a Dissection was not found!!!!!!!!!!!!!!!!"); return -1;
        }

    }

    public static int getNewDirection(int springID, int seed) {
            switch(springID){
                    // 8th STR
                    //A1
                    case 39:
                    case 40: 
                    case 41:
                    case 42: return(seed<97? 1 : 2);//return(seed<41?1 : seed<98?2 : 3);
                    //A2
                    case 43:
                    case 44: return(seed<41?1 : seed<98?2 : 3);
                    //A3
                    case 45:
                    case 46: return(seed<90?1 : 6);
                    //A4 
                    case 47:
                    case 48: return(seed<10?5 : seed<13?4 : seed<35? 3 : seed<70?2 : 1);
                    //A5
                    case 49:
                    case 50:
                    case 51:
                    case 52: return(seed<3?4 : seed<2?4 : seed<84?1 : 2);
                    
                    //FLAGLER
                    //A6
                    case 53:
                    case 54:
                    case 55: return(seed<90?1:2);
                    //A7
                    case 56:
                    case 57:
                    case 58: return(seed<97? 1 : 2);
                    //A8
                    case 59: return(seed<90?1 : 6);
                    //A9
                    case 60: return(seed<90?1 : 6);
                    //A10
                    case 61:
                    case 62:
                    case 63: return(seed<3?4 : seed<2?4 : seed<84?1 : 2);
                    //A11
                    case 64: return(seed<90?1 : 6);
//                    //A1
//                    case 39:
//                    case 40: return(seed<41?1 : seed<98?2 : 3);
//                    //A2
//                    case 41:
//                    case 42:
//                    case 43: return(seed<97? 1 : 2);
//                    //A3
//                    case 44: return(seed<90?1 : 6);
//                    //A4ed<90?1 : 
//                    case 45:
//                    case 46: return(seed<10?5 : seed<13?4 : seed<35? 3 : seed<70?2 : 1);
//                    //A5
//                    case 47:
//                    case 48: return(seed<3?4 : seed<2?4 : seed<84?1 : 2);
//                    //A6
//                    case 49:
//                    case 50:
//                    case 51: return(seed<90?1:2);

                    default: System.out.println("!!!!!!!!!!!!!!!!Probabilities: An ID of a spring was not found!!!!!!!!!!!!!!!!"); return -1;
            }
    }



    public static double getLanePredictant(int springID) {
            switch(springID){
            //A1
            case 39:
            case 40: 
            case 41:
            case 42: return(Predictants[0]*4);
            //A2            
            case 43:
            case 44: return(Predictants[1]*2);
            //A3
            case 45: 
            case 46: return(Predictants[2]*2);
            //A4
            case 47:
            case 48: return(Predictants[3]*2);
            //A5
            case 49:
            case 50:
            case 51:
            case 52: return(Predictants[4]*4);
            //A6
            case 53:
            case 54:
            case 55: return(Predictants[5]*3);
            //A7
            case 56:
            case 57:
            case 58: return(Predictants[6]*3);
            //A8
            case 59: return(Predictants[7]);
            //A9
            case 60: return(Predictants[8]);
            //A10
            case 61:
            case 62:
            case 63: return(Predictants[9]*3);
            //A11
            case 64: return(Predictants[10]);
//                //A1
//            case 39:
//            case 40: return(Predictants[0]*2);
//            //A2
//            case 41:
//            case 42:
//            case 43: return(Predictants[1]*3);
//            //A3
//            case 44: return(Predictants[2]);
//            //A4
//            case 45:
//            case 46: return(Predictants[3]*2);
//            //A5
//            case 47:
//            case 48: return(Predictants[4]*2);
//            //A6
//            case 49:
//            case 50:
//            case 51: return(Predictants[5]*3);

            default: System.out.println("!!!!!!!!!!!!!!!!Probabilities: An ID of a spring was not found!!!!!!!!!!!!!!!!"); return 1;
    }
    }

    public static void updatePredictant(int springID, int carsPerMinute) {
            double newPredictant;
            if(carsPerMinute==0) newPredictant=0;
            else newPredictant = 60.0/(double)carsPerMinute;
            Predictants[springID-1]=newPredictant;
    }

    public static double getPred(int i) {
            return Predictants[i];
    }
	

}
