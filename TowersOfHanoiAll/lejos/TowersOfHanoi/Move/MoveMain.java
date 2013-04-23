package lejos.TowersOfHanoi.Move;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import lejos.nxt.Button;
import lejos.nxt.comm.Bluetooth;
import lejos.nxt.comm.NXTConnection;

public class MoveMain {

	public static void main(String[] args) {
		Move move = new Move();
				
		System.out.println("Connecting...");
				
		NXTConnection connection = Bluetooth.waitForConnection();
		DataInputStream dis = connection.openDataInputStream();
		DataOutputStream dos = connection.openDataOutputStream();
		
		System.out.println("Connected");
		
		System.out.println("Moving...");
		
		while(true){			
			int pos=0;
			
			while(true){
				if(Button.ESCAPE.isDown())System.exit(0);
				try {pos = dis.readInt();} 
				catch (IOException e) {e.printStackTrace(); System.out.println("Error2: Reading Failed");}
				if(pos>0 && pos<4)break;
			}
			
			move.identifyDirection(pos);
						
			try {
				dos.writeInt(pos);
				dos.flush();
				} 
			catch (IOException e) {e.printStackTrace(); System.out.println("Error3: Write Failed");}
		}
	}
}
