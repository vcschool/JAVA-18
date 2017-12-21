package lt.vcs.robocop;

import robocode.Robot;
import robocode.ScannedRobotEvent;
import robocode.util.Utils;

import java.awt.*;

public class Nameless extends Robot {
    int count = 0;
    double Gturn;
    String trackName;

    @Override
    public void run() {
        while (true) {
            this.turnGunRight(this.Gturn);
            ++this.count;
            if (this.count > 2) {
                this.Gturn = -10.0D;
            }

            if (this.count > 5) {
                this.Gturn = 10.0D;
            }

            if (this.count > 11) {
                this.trackName = null;
            }
        }
    }

    public void onScannedRobot(ScannedRobotEvent e) {
        if (this.trackName == null || e.getName().equals(this.trackName)) {
            if (this.trackName == null) {
                this.trackName = e.getName();
                this.out.println("Tracking " + this.trackName);
            }

            this.count = 0;
            if (e.getDistance() > 150.0D) {
                this.Gturn = Utils.normalRelativeAngleDegrees(e.getBearing() + (this.getHeading() - this.getRadarHeading()));
                this.turnGunRight(this.Gturn);
                this.turnRight(e.getBearing());
                this.ahead(e.getDistance() - 140.0D);
            } else {
                this.Gturn = Utils.normalRelativeAngleDegrees(e.getBearing() + (this.getHeading() - this.getRadarHeading()));
                this.turnGunRight(this.Gturn);
                this.fire(3.0D);
                if (e.getDistance() < 100.0D) {
                    if (e.getBearing() > -90.0D && e.getBearing() <= 90.0D) {
                        this.back(40.0D);
                    } else {
                        this.ahead(40.0D);
                    }
                }

                this.scan();
            }
        }
    }



}




