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
	 * Methoden ausgelesen. Desweiteren Bool'sche Werte für den Zustand 
	 * der Sichtbarkeit auf der Karte und für den Zustand (explodiert oder nicht)
	 * der Bombe. */
	private int x;
	private int y;
	private int r;
	private int explRad;
	private boolean show;
	private boolean blewUp;
	//private Triangle[] tri;
	
	public Bombe() {
		//this.r =
		//this.explRad = 
		this.show = false;
		this.blewUp = false;
		/*this.tri = new Triangle[];
		for (i=0; i<n; i++) {
			tri[i] = Triangle(a*Math.random(), b*Math.random(), c*Math.random())
		}*/
	}
	
	protected boolean isBlewUp() {
		return blewUp;
	}
	
	/* Es folgen die Set-Methoden für x,y,r und den Wahrheitswert von show*/
	protected void setX(int xIn) {
		this.x = xIn;
	}
	
	protected void setY(int yIn) {
		this.y = yIn;
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
	
	protected int getExplRad() {
		return explRad;
	}
	
	/* Die draw Methode fragt erst ab, ob die Bombe überhaupt
	 * angezeigt werden darf (über Boolean show)*/
	protected void draw() {
		if(show) {
			
		}	
	}
}
