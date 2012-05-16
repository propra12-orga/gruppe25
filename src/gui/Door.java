/**
 * 
 */
package gui;

/**
 * @author bene
 *
 */
public class Door extends Grafik{
	private int x;
	private int y;
	
	protected Door(int x0, int y0) {
		this.x = x0;
		this.y = y0;
	}
	
	protected int getX() {
		return x;
	}
	
	protected int getY() {
		return y;
	}
}
