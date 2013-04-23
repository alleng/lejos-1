package lejos.TowersOfHanoi.ColorGetter;
import java.util.ArrayList;

import lejos.nxt.*;

public class ColorGetter {
	static int pos = 0;
	private static int justPressed;
	private static ArrayList<Integer> red, green, blue;

	public static void main(String[] args) {
		ColorSensor color = new ColorSensor(SensorPort.S1);
		
		red = new ArrayList<Integer>();
		green = new ArrayList<Integer>();
		blue = new ArrayList<Integer>();


		while(true){
			ColorSensor.Color colorResult = color.getRawColor();
			justPressed = Button.waitForAnyPress();
			if(justPressed==Button.ID_ENTER){
				red.add(colorResult.getRed());
				green.add(colorResult.getGreen());
				blue.add(colorResult.getBlue());
			}
			else if(justPressed==Button.ID_RIGHT){
				int redNumber = 0;
				for(Integer RED:red){
					redNumber+=RED;
				}
				redNumber /= red.size();
				
				int greenNumber = 0;
				for(Integer GREEN:green){
					greenNumber+=GREEN;
				}
				greenNumber /= green.size();
				
				int blueNumber = 0;
				for(Integer BLUE:blue){
					blueNumber+=BLUE;
				}
				blueNumber /= blue.size();
				
				System.out.println("RED:"+redNumber+" GREEN:"+greenNumber+" BLUE"+blueNumber);
				
				red = new ArrayList<Integer>();
				green = new ArrayList<Integer>();
				blue = new ArrayList<Integer>();
			}
			else if(justPressed==Button.ID_ESCAPE)break;
		}
	}
}