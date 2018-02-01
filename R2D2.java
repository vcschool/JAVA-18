package lt.vcs.robot;

import robocode.*;
import robocode.Robot;

import java.awt.*;

public class R2D2 extends Robot {

    @Override
    public void onWin(WinEvent event) {
        super.onWin(event);
        turnGunRight(900);
    }

    @Override
    public void setAllColors(Color color) {
        super.setAllColors(color);
    }

    @Override
    public void run() {
        setAllColors(Color.getHSBColor(255, 255, 0));
        while (true) {

            double moveAmount = Math.max(getBattleFieldWidth(), getBattleFieldHeight());
            boolean peek = false;
            turnLeft(getHeading() % 90);
            ahead(moveAmount);

            peek = true;
            turnGunRight(90);
            turnRight(90);
            fire(0.5);


            while (true) {
                peek = true;
                ahead(moveAmount);
                peek = false;
                turnRight(90);


            }
        }
    }

    public void onHitRobot(HitRobotEvent e) {
        turnGunLeft(90);
        fire(3);
        turnGunRight(90);
        if (e.getBearing() > -90 && e.getBearing() < 90) {
            turnGunRight(0);

        } else {
            ahead(100);
        }
    }

    public void onScannedRobot(ScannedRobotEvent e) {
        double distance = e.getDistance();

        if (distance < 100) {
            fire(3);
        } else if (distance < 200) {
            fire(1.5);
        } else if (distance < 400) {
            fire(1.0);
        } else {
            fire(0.5);
        }
    }
}





