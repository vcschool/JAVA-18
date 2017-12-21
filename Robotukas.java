package robot;

import robocode.Robot;
import robocode.ScannedRobotEvent;
import robocode.WinEvent;

import java.awt.*;

/**
 * Created by Kristian on 12/21/2017.
 */
public class Robotukas extends Robot {

    @Override
    public void run() {

        setColors(Color.red, Color.black, Color.yellow);
        setBulletColor(Color.blue);
        setScanColor(Color.red);


        while (true) {
            ahead(100);
            turnLeft(45);
            setAdjustGunForRobotTurn(true);
            turnGunRight(360);
            back(150);
            turnGunRight(360);
        }
    }

    public void onScannedRobot(ScannedRobotEvent e) {
        if (e.getDistance() < 200) {
            fire(3);
        } else if (e.getDistance() >= 200 && e.getDistance() <= 400){
            fire(2);
        } else {
            fire(1);
        }
    }

    @Override
    public void onWin(WinEvent event) {
        super.onWin(event);
    }
}
