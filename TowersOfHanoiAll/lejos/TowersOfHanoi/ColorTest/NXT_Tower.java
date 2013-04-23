package lejos.TowersOfHanoi.ColorTest;

public class NXT_Tower {
	int nxt_red=0, nxt_green=0, nxt_blue=0, field, pos=0;
	
	NXT_Tower(int nxt_red, int nxt_green, int nxt_blue, int field, int pos){
		this.nxt_red=nxt_red;
		this.nxt_green=nxt_green;
		this.nxt_blue=nxt_blue;
		
		this.field=field;
		
		this.pos=pos;
	}
	
	public Boolean isColor(int red, int green, int blue){
		return (red>(nxt_red-field) && red<(nxt_red+field) && green>(nxt_green-field) && green<(nxt_green+field) && blue>(nxt_blue-field) && blue<(nxt_blue+field));
	}
	
	public int getPosition(int red, int green, int blue){
		if(isColor(red, green, blue))return pos;
		else return 0;
	}
}
