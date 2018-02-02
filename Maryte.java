package Robot;

import robocode.*;
import robocode.Robot;
import robocode.HitRobotEvent;
import robocode.AdvancedRobot;

import java.awt.*;

public class Maryte extends AdvancedRobot {
    @Override
    public void run() {

        while (true) {
            setBodyColor(Color.RED);
            setRadarColor(Color.YELLOW);
            setBulletColor(Color.RED);
            setScanColor(new Color(255, 200, 200));

            ahead(200);
            turnLeft(45);
            back(150);
            setTurnLeft(40000);
            //turnGunRight(180);
            //ahead(150);
            back(90);
            setTurnRight(30000);
            turnLeft(90);
            ahead(150);
            //turnGunRight(360);
            setTurnRight(40000);
            // Turn the robot 180 degrees to the right
            //turnLeft(90);
            ahead(100);
            //turnLeft(90);
            setTurnRight(10000);

        }
    }

    public void onHitWall(HitWallEvent event) {
        out.println("Ouch, I hit a wall bearing " + event.getBearing() + " degrees.");
        turnLeft(90);
        ahead(200);
    }

    public void onScannedRobot(ScannedRobotEvent event) {
        // Assuming radar and gun are aligned...
        if (event.getDistance() < 100) {
            fire(3);
          //  setTurnLeft(40000);
        } else {
            fire(1);
           // setTurnRight(20000);
        }
    }
}

