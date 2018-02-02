package Robot;


import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.ScannedRobotEvent;

import java.awt.Color;

import robocode.AdvancedRobot;


/**
 * TJ2Robot - a sample robot by Tomas Jegelevičius.
 * <p>
 * This robot moves and shoots
 *
 * @author Tomas Jegelevičius
 */


public class TJ2Robot extends AdvancedRobot {

    int turnDirection = 1;

    @Override
    public void run() {

        setColors(new Color(229, 218, 42), new Color(231, 74, 69),
                new Color(0, 0, 0), new Color(255, 255, 1), Color.pink);

        while (true) {
            setTurnRight(10000);
            setMaxVelocity(5);
            ahead(10000);
        }


    }
    public void onHitRobot(HitRobotEvent e){

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

    public void onHitWall(HitWallEvent e) {
        back(100);
    }

    public void onScannedRobot(ScannedRobotEvent e) {

        if (e.getDistance() < 100) {
            fire(3);
        } else if (e.getDistance() >= 100 && e.getDistance() <= 300) {
            fire(2);
        } else {
            fire(1);
        }
    }

}
