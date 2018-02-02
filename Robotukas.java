package robot;

import robocode.HitRobotEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;
import robocode.util.Utils;

import java.awt.*;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Robotukas extends Robot {

    private static final double TURNING_RADIUS = 45;
    double r = 114.5450131316624;
    double d = 2 * r; // turning diameter
    byte moveDirection = 1;

    @Override
    public void run() {

        setColors(Color.red, Color.black, Color.yellow);
        setBulletColor(Color.red);
        setScanColor(Color.black);

        while (true) {
            avoidWall();
            ahead(100);
            turnLeft(45);
            setAdjustGunForRobotTurn(true);
            turnGunRight(270);
            back(150);
            turnGunRight(360);
            if (getVelocity() == 0)
                moveDirection *= -2;
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

    public void onHitRobot(HitRobotEvent e) {
        if (e.getBearing() > -90 && e.getBearing() < 90) {
            back(100);
        }
        else {
            ahead(100);
        }
        if (e.getBearing() > -10 && e.getBearing() < 10) {
            fire(3);
        }
        if (e.isMyFault()) {
            turnRight(10);
        }
    }

    public void goTo(double x, double y) {
        x -= getX();
        y -= getY();

        double angleToTarget = Math.atan2(x, y);
        double targetAngle = Utils.normalRelativeAngle(angleToTarget - getHeading());
        double distance = Math.hypot(x, y);

        double turnAngle = Math.atan(Math.tan(targetAngle));
        turnRight(turnAngle);
        if(targetAngle == turnAngle) {
            ahead(distance);
        } else {
            back(distance);
        }
    }

    public void avoidWall() {

        double TOP = getBattleFieldHeight() - 18.0;
        double RIGHT = getBattleFieldWidth() - 18.0;
        double BOTTOM = 18.0;
        double LEFT = 18.0;

        double N = 2.0 * Math.PI;
        double E = Math.PI / 2.0;
        double S = Math.PI;
        double W = 3.0 * Math.PI / 2.0;

        double s = 8.0;
        double x = getX();
        double y = getY();
        double a = 90; // whatever angle you wish to travel, we can smooth it!
        boolean clockwise = true; // your choice!

        if (clockwise) {
            if (S < a) { // left wall
                if (shouldSmooth(a - S, LEFT - x, s)) {
                    a = smooth(a - S, LEFT - x, s) + S;
                }
            } else if (a < S) { // right wall
                if (shouldSmooth(a, x - RIGHT, s)) {
                    a = smooth(a, x - RIGHT, s);
                }
            }
            if (W < a || a < E) { // top wall
                if (shouldSmooth(a + E, y - TOP, s)) {
                    a = smooth(a + E, y - TOP, s) - E;
                }
            } else if (E < a && a < W) { // bottom wall
                if (shouldSmooth(a - E, BOTTOM - y, s)) {
                    a = smooth(a - E, BOTTOM - y, s) + E;
                }
            }
        } else {
            if (S < a) { // left wall
                if (shouldSmooth(N - a, LEFT - x, s)) {
                    a = N - smooth(N - a, LEFT - x, s);
                }
            } else if (a < S) { // right wall
                if (shouldSmooth(S - a, x - RIGHT, s)) {
                    a = S - smooth(S - a, x - RIGHT, s);
                }
            }
            if (W < a || a < E) { // top wall
                if (shouldSmooth(E - a, y - TOP, s)) {
                    a = E - smooth(E - a, y - TOP, s);
                }
            } else if (E < a && a < W) { // bottom wall
                if (shouldSmooth(W - a, BOTTOM - y, s)) {
                    a = W - smooth(W - a, BOTTOM - y, s);
                }
            }
        }
    }

    private boolean shouldSmooth(double a, double x, double s) {
        double nextX = x + s * sin(a);
        if (nextX < -d) { // shortcut, unnecessary code
            return false;
        }
        if (0.0 <= nextX) { // shortcut, unnecessary code
            return true;
        }
        return 0.0 < nextX + r * (cos(a) + 1.0);
    }

    private double smooth(double a, double x, double s) {
        double nextX = x + s * sin(a);
        if (0.0 <= nextX) { // NOT a shortcut, necessary code
            return Math.PI;
        }
        return Math.acos(-nextX / TURNING_RADIUS - 1.0);
    }
}
