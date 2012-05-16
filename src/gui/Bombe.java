/**
 * 
 */
package gui;

/**
 * @author Aiko
 *
 */
public class Bombe extends Grafik{
	/* Koordinaten des Mittelpunkts der Bombe und der Sprengradius, 
	 * die Werte sind private und werden durch getter- und setter-
	 * Methoden ausgelesen. */
	private int x;
	private int y;
	private int r;
	private boolean show;
	
	public Bombe(int x0, int y0, int r0) {
		this.x = x0;
		this.y = y0;
		this.r = r0;
		this.show = false;
	}
	
	/* Es folgen die Set-Methoden für x,y,r und den Wahrheitswert von show*/
	protected void setX(int xIn) {
		this.x = xIn;
	}
	
	protected void setY(int yIn) {
		this.y = yIn;
	}
	
	protected void setR(int rIn){
		this.r = rIn;
	}
	
	protected void setShow(boolean tf) {	
		this.show = tf;
	}
	
	
	/* Hier sind die Get-Methoden für x,y und r*/
	protected int getX() {
		return x;
	}
	
	protected int getY() {
		return y;
	}
	
	protected int getR() {
		return r;
	}
	
	/* Die draw Methode fragt erst ab, ob die Bombe überhaupt
	 * angezeigt werden darf (über Boolean show)*/
	protected void draw() {
		if(show) {
			
		}	
	}
}
