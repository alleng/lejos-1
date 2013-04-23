package lejos.TowersOfHanoi.Move;

import lejos.nxt.Button;
import lejos.nxt.ColorSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.robotics.navigation.LegacyPilot;

public class Move {
	int pos=0;
	LegacyPilot pilot;
	ColorSensor color;

	NXT_Tower tower_red, tower_green, tower_yellow;

	Move(){
		pilot = new LegacyPilot(0.79f, 1.0f, Motor.A, Motor.B);
		pilot.setMoveSpeed(0.5f);
		color = new ColorSensor(SensorPort.S1);
		
		tower_red = new NXT_Tower(590, 185, 280, 25, 1);
		tower_yellow = new NXT_Tower(650, 410, 340, 25, 3);
		tower_green = new NXT_Tower(315, 300, 310, 25, 2);
	}
	
	public void identifyDirection(int target){
				
		switch (target){
			case 1:
				Left(target);
				break;
			case 2:
				switch(pos){
				case 1:
					Right(target);
					break;
				case 3:
					Left(target);
					break;
				}
				break;
			case 3:
				Right(target);
				break;
			default:
				System.out.println("Error1: False platform");
		}
	}
	
	private void Left(int target){
		System.out.println("from "+pos+" to "+target);
		pos=target;
		
		pilot.travel(100000, true);
		while(!reachedTarget(target)){
			if(Button.ESCAPE.isDown())break;
		}
		pilot.stop();
	}
	
	private void Right(int target){
		System.out.println("from "+pos+" to "+target);
		pos=target;
		
		pilot.travel(-100000, true);
		while(!reachedTarget(target)){
			if(Button.ESCAPE.isDown())break;
		}
		pilot.stop();
	}
	
	public Boolean reachedTarget(int target){
		ColorSensor.Color colorResult = color.getRawColor();
		int red = colorResult.getRed();
		int green = colorResult.getGreen();
		int blue = colorResult.getBlue();

		if(tower_red.getPosition(red, green, blue)==target)return true;
		else if(tower_green.getPosition(red, green, blue)==target)return true;
		else if(tower_yellow.getPosition(red, green, blue)==target)return true;
		else return false;
	}	
}
