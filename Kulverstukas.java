package lt.vcs.robot;

import robocode.*;


import java.awt.*;

public class Kulverstukas extends AdvancedRobot{

    boolean movingForward;
    int turnDirection = 1;

    public void run() {

        setBodyColor(new Color(52, 200, 192));
        setGunColor(new Color(26, 25, 150));
        setRadarColor(new Color(92, 31, 100));
        setBulletColor(new Color(255, 49, 43));
        setScanColor(new Color(38, 255, 254));


        while (true) {
            setAhead(40000);

            movingForward = true;

            setTurnRight(90);

            waitFor(new TurnCompleteCondition(this));

            setTurnLeft(180);

            waitFor(new TurnCompleteCondition(this));

            setTurnRight(180);

            waitFor(new TurnCompleteCondition(this));

        }
    }


    public void onHitWall(HitWallEvent e) {
        reverseDirection();
    }

    public void reverseDirection() {
        if (movingForward) {

            setBack(40000);

            movingForward = false;
        } else {
            setAhead(40000);
            movingForward = true;
        }
    }

    public void onScannedRobot(ScannedRobotEvent e) {
        fire(2);
    }

    public void onHitRobot(HitRobotEvent e) {
        if (e.getBearing() >= 0) {
            turnDirection = 1;
        } else {
            turnDirection = -1;
        }
        turnRight(e.getBearing());

        if (e.getEnergy() > 16) {
            fire(3);
        } else if (e.getEnergy() > 10) {
            fire(2);
        } else if (e.getEnergy() > 4) {
            fire(1);
        } else if (e.getEnergy() > 2) {
            fire(.5);
        } else if (e.getEnergy() > .4) {
            fire(.1);
        }
        ahead(40);
    }

}


