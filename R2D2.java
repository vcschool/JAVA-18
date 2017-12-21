package lt.vcs.robot;

import robocode.Robot;
import robocode.ScannedRobotEvent;

import java.awt.*;

public class R2D2 extends Robot {

    @Override
    public void run() {
        setColors(Color.red, Color.BLACK, Color.BLACK);
        while (true) {

            ahead(200);
            fire(1.0);
            back(200);
            fire(1.0);
            turnRight(180);
            turnGunLeft(360);
            ahead(200);
            fire(1.0);
            back(100);
            turnRadarLeft(360);
            fire(1.0);
            ahead(200);
            fire(1.0);

        }



    }
    public void onScannedRobot (ScannedRobotEvent event){
        fire(2.0);
    }
}
