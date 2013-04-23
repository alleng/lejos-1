package lejos.TowersOfHanoi.ComputeAndGrab;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import javax.bluetooth.RemoteDevice;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.comm.BTConnection;
import lejos.nxt.comm.Bluetooth;

public class GrabbingMain {

	public static void main(String[] args) {

		while(true){

			System.out.println("Connecting...");
			RemoteDevice btrd = Bluetooth.getKnownDevice("NXT-Johaness");
			if (btrd == null) {System.out.println("Error1: No Device");}

			BTConnection btc = Bluetooth.connect(btrd);
			if (btc == null) {System.out.println("Error2: Connect Fail");}
			System.out.println("Connected");

			DataOutputStream dos = btc.openDataOutputStream();
			DataInputStream dis = btc.openDataInputStream();
			
			SegmentMove segMove = new SegmentMove(btc, dos, dis);

			int segmentnumber=1;
			segmentnumber = getSegmentnumber();
			
			System.out.println("Connecting...");
			System.out.println("Connected");
			System.out.println("Segmentnumber: "+segmentnumber);

			segMove.segMove(segmentnumber, 1, 3, 2);

			System.out.println("END");
			System.out.println("Continue: 'Enter'");
			System.out.println("Exit: 'Escape'");

			Button.waitForAnyPress();
			if(Button.ESCAPE.isDown())System.exit(0);
			if(Button.ENTER.isDown());
		}
	}

	public static Integer getSegmentnumber(){
		int i=0;

		while(true){
			LCD.clear();

			System.out.println();
			System.out.println();
			System.out.println("Segmentnumber: "+i);
			System.out.println("Up: 'Right'");
			System.out.println("Down: 'Left'");
			System.out.println("Confirm: 'Enter'");
			System.out.println("Exit: 'Escape'");

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

		return i;
	}
}
