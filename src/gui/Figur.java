/**
 * 
 */
package gui;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * @author bene
 *
 */
public class Figur extends Grafik{
	private int y;		//x,y Position der Figur
	private int x;
	private int xDoor;
	private int yDoor;
	private int r;
	
	protected Figur(int xInit, int yInit, int xDoorInit, int yDoorInit) {
		this.y = yInit;
		this.x = xInit;
		this.xDoor = xDoorInit;
		this.yDoor = yDoorInit;
		this.r =15;
	}
	/* Die folgenden vier Methoden sollen die Position der Figur
	 * durch Funktionenaufruf von Grafik ändern. Hierbei wird auch überprüft, ob 
	 * sich die Figur schon in der Tür befindet. */
	protected void incY(int n) {
		y+=n;
		if(((y-yDoor)*(y-yDoor)) < (25*25)) {
			if(((x-xDoor)*(x-xDoor)) < (25*25)) {
				super.gameWon();
			}
		}
	}
	
	protected void decY(int n) {
		y-=n;
		if(((y-yDoor)*(y-yDoor)) < (25*25)) {
			if(((x-xDoor)*(x-xDoor)) < (25*25)) {
				super.gameWon();
			}
		}
	}
	
	protected void incX(int n) {
		x+=n;
		if(((x-xDoor)*(x-xDoor)) < (25*25)) {
			if(((y-yDoor)*(y-yDoor)) < (25*25)) {
				super.gameWon();
			}
		}
	}
	
	protected void decX(int n) {
		x-=n;
		if(((x-xDoor)*(x-xDoor)) < (25*25)) {
			if(((y-yDoor)*(y-yDoor)) < (25*25)) {
				super.gameWon();
			}
		}
	}
	
	/* Return Methoden für die x,y Werte*/
	protected int readY(){
		return y;
	}
	
	protected int readX() {
		return x;
	}
	
	/* Hier geschieht die Anzeige*/
	protected void draw() {
		g2.setColor(Color.ORANGE);
		g2.drawOval(x-10, y-10, 2*r, 2*r);
	}
}
