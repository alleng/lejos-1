package lejos.TowersOfHanoi.ComputeAndGrab;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import lejos.nxt.comm.BTConnection;

public class SegmentMove {
	GrabAndDrop gd;
	BTConnection btc;
	DataOutputStream dos;
	DataInputStream dis;
	
	SegmentMove(BTConnection btc, DataOutputStream dos, DataInputStream dis){
		this.btc = btc;
		this.dos=dos;
		this.dis=dis;
		
		gd = new GrabAndDrop();
		gd.up();
	}
	
	public void segMove(int segmentnumber, int fromFundament, int toFundament, int usingFundament){
		if(segmentnumber>1){
			segMove( segmentnumber-1, fromFundament, usingFundament, toFundament);
			grabAndMove(fromFundament, toFundament);
			segMove( segmentnumber-1, usingFundament, toFundament, fromFundament);
		}
		else{
			grabAndMove(fromFundament, toFundament);
		}
	}	
	
	public void grabAndMove(int fromFundament, int toFundament){
		move(fromFundament);
		gd.grab();
		move(toFundament);
		gd.drop();
	}
	
	public void	move(int toFundament){
		
		try {
			dos.writeInt(toFundament);
			dos.flush();
			} 
		catch (IOException e) {e.printStackTrace(); System.out.println("Error3: Write Fail");}
		
		try{
			while(true){
				if(dis.readInt()==toFundament)break;
				else{
					try {Thread.sleep(500);} 
					catch (InterruptedException e) {e.printStackTrace();}
				}	
			}
		}
		catch (IOException e) {e.printStackTrace(); System.out.println("Error4: Read Fail");}
	}
}