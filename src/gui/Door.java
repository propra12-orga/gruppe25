/**
 * 
 */
package gui;

import java.awt.Color;

/**
 * @author bene
 *
 */
public class Door extends Grafik{
	private int x;
	private int y;
	private int width = 50;
	private int height = 50;
	
	protected Door(int x0, int y0) {
		this.x = x0;
		this.y = y0;
	}
	
	protected void draw() {
		g2.setColor(Color.CYAN);
		g2.drawRect(x, y, width, height);
		
		g2.setColor(Color.GREEN);
		g2.fillRect(x+5, y+5, width-10, height-10);
	}
}
