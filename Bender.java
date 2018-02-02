package lt.vcs.robot;

import robocode.*;
import robocode.AdvancedRobot;

import java.awt.*;

public class Bender extends AdvancedRobot {

    @Override
    public void run() {
        // Set colors
        setBodyColor(Color.gray);
        setGunColor(Color.black);
        setRadarColor(Color.gray);
        setScanColor(Color.yellow);
        setBulletColor(Color.orange);

        // Loop forever
        while (true) {
            // Tell the game that when we take move,
            // we'll also want to turn right... a lot.
            setTurnRight(1000);
            // Limit our speed to 5
            setMaxVelocity(5);
            // Start moving (and turning)
            ahead(1000);
            // Repeat.
            // Tell the game that when we take move,
            // we'll also want to turn right... a lot.
            setTurnRight(-1000);
            // Limit our speed to 5
            //setMaxVelocity(5);
            // Start moving (and turning)
            ahead(1000);
            // Repeat.
        }
    }


    @Override
    public void onHitRobot(HitRobotEvent event) {
        //reverse and shoot
        back(80);
        fire(1);
        fire(1);
        fire(1);
        fire(1);
        fire(1);
    }

    @Override
    public void onHitWall(HitWallEvent event) {
        // Bounce off!
        back(100);
        turnRight(90);
    }

    @Override
    public void onScannedRobot(ScannedRobotEvent event) {
        fire(2);
    }


}
