package lejos.TowersOfHanoi.SegmentNumberGetter;

import lejos.nxt.Button;
import lejos.nxt.LCD;

public class SegmentNumber{

	public static void main(String[] args) {
		int i=0;
		
		while(true){
			LCD.clear();
			
			System.out.println();
			System.out.println();
			System.out.println("Segmentnumber: "+i);
			System.out.println("Up: Right");
			System.out.println("Down: Left");
			System.out.println("Confirm: Enter");
			System.out.println("Exit: Escape");
			
			Button.waitForAnyPress();
			if(Button.RIGHT.isDown()){
				i++;
			}
			else if(Button.LEFT.isDown()){
				i--;
				if(i<0)i=0;

			}
			else if(Button.ENTER.isDown())break;
			else if(Button.ESCAPE.isDown())System.exit(0);
		}
		
		LCD.clear();
		System.out.println(i);
		Button.waitForAnyPress();
	}
}
