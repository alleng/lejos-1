package lejos.TowersOfHanoi.ColorTest;

import lejos.nxt.Button;
import lejos.nxt.ColorSensor;
import lejos.nxt.SensorPort;

public class ColorTest {
	static NXT_Tower tower_red, tower_yellow, tower_green;
	static ColorSensor color;
	
	public static void main(String[] args) {
		tower_red = new NXT_Tower(590, 185, 280, 25, 1);
		tower_yellow = new NXT_Tower(650, 410, 340, 25, 3);
		tower_green = new NXT_Tower(315, 300, 310, 25, 2);
		
		color = new ColorSensor(SensorPort.S1);
		
		Button.waitForAnyPress();
		System.out.println(reachedTarget(1));
		Button.waitForAnyPress();
		System.out.println(reachedTarget(2));
		Button.waitForAnyPress();
		System.out.println(reachedTarget(3));
		Button.waitForAnyPress();
	}

	public static Boolean reachedTarget(int target){
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
