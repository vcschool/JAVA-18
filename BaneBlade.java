import robocode.HitRobotEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;

public class BaneBlade extends Robot {

    public BaneBlade(){

    }
    @Override
    public void run () {
        while (true) {
            turnGunLeft(360);
            ahead(400);
            turnLeft(90);
            }
        }

    @Override
    public void onScannedRobot (ScannedRobotEvent event) {
        fire(2);
    }

    @Override
    public void onHitRobot(HitRobotEvent event){
        fire(3);
        back(60);
    }

}