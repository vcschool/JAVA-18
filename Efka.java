package lt.vcs.robot;

import robocode.Robot;
import robocode.Rules;
import robocode.ScannedRobotEvent;

public class Efka extends Robot {
    @Override
    public void run() {
        while (true) {
            ahead (200);
            turnGunRight(360);
            back(100);
            turnGunRight(360);
            fire(1);


        }
    }


    @Override
    public void onScannedRobot(ScannedRobotEvent event) {
        event.getDistance();
        getEnergy();
        fire(Rules.MAX_BULLET_POWER);
    }
}
