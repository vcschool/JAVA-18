package Robot;

import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;
import robocode.util.Utils;

import java.awt.*;

public class TjRobot extends Robot {

    double gunTurnAmt;
    String trackName;


    public void run() {
        gunTurnAmt = 10;

        this.setBodyColor(new Color(0, 168, 0));
        this.setGunColor(new Color(11, 56, 11));
        this.setRadarColor(new Color(3, 36, 3));

        this.setScanColor(Color.green);
        this.setBulletColor(Color.red);

        while (true) {


           this.turnGunRight(this.gunTurnAmt);



        }


    }

    public void onScannedRobot(ScannedRobotEvent e) {
        this.ahead(Math.random()*100);




        if (this.getEnergy() < 20) {
            fire(1);
        } else {
            this.fire(3);
        }
        this.scan();




//        System.out.println(e.getBearing());
//        this.trackName = e.getName();
//        this.out.println("Tracking " + this.trackName);
//
//        this.fire(3);


    }

    public void onHitRobot(HitRobotEvent e) {
        this.back(60.0D);


    }
    public void  onHitWall(HitWallEvent wallEvent){
        this.back(40.0D);
        this.turnRight(90);


    }




}
