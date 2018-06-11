package aquarium2;

import java.util.*;

public class Aquarium2 {

    public static void main(String[] args) {   


     abstract class RobotVisMachine {}
    //abstract void addParts();


class RobotVis extends RobotVisMachine {
    String modelName;
    int batteryLevel;
    // begint 100, min 1 per minuut o.i.d.
    
    void batteryLevel(){
        while (batteryLevel >= 1 && batteryLevel <= 100) {
        }
    }
 }

/* class TerminatorVis extends RobotVis {
        void recharge (){}
    }

class SchoonmaakVis extends RobotVis {}  */


class Battery {                //extends & implements

    private final long chargeTop = 1000;
    private final long chargeStep = 10;
    private float chargeLevel;

     Battery() {
        chargeLevel = 100;
    }

    public void charge() {
        chargeLevel = chargeFunction(chargeLevel);
    }

    private float chargeFunction(float charge) {
        return charge+chargeStep;
    }

    public void setUp() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                charge();
            }
        }, 0, chargeTop);
    }

    public float getChargeLevel(){
        return chargeLevel;
    }

    public void use(double energy) throws InsufficientChargeException {
        if (chargeLevel < energy) throw new InsufficientChargeException();
        chargeLevel -= energy;
    }

    public long timeToSufficientCharge(double neededEnergy) {
        int clock = 0;
        float charge = chargeLevel;
        while (charge<neededEnergy) {
            charge = chargeFunction(charge);
            clock++;
        }
        return clock*chargeTop;
    }


    class InsufficientChargeException extends Exception {

        public InsufficientChargeException() {
        }
    }
   
}
}
}
 
