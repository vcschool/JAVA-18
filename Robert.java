package lt.vcs.manvydas.robotas;
import java.awt.Color;

import java.awt.Color;

import robocode.Robot;
import robocode.Rules;
import robocode.ScannedRobotEvent;

public class Robert extends Robot{
	

	public void run() {
		setAllColors(Color.red);
		while(true) {
			turnGunLeft(360);
			ahead(150);
			turnRight(90);
			turnGunRight(360);
			back(150);
			turnRight(90);
		}
	}
	
	@Override
	public void scan() {
		// TODO Auto-generated method stub
		super.scan();
	}
	
	@Override
	public void setBodyColor(Color color) {
		// TODO Auto-generated method stub
		super.setBodyColor(color);
	}
	
	@Override
	public void onScannedRobot(ScannedRobotEvent event) {
		fire(Rules.MAX_BULLET_POWER);
		
	}
	
}
