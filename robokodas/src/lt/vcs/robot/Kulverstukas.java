package lt.vcs.robot;

import robocode.*;

public class Kulverstukas extends Robot{

    boolean movingForward;

    @Override
    public void run() {
        while(true) {
            ahead(200);
            turnGunRight(180);
            turnRight(45);

        }
    }

    @Override
    public void onScannedRobot(ScannedRobotEvent event) {
        fire(2);
    }

    @Override

    public void onHitWall(HitWallEvent e) {

        turnLeft(180);

    }








}
