/**
 * 
 */
package gui;

import java.awt.*;
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
	private int drawCount = 0;
	//private Triangle[] tri;
	
	public Bombe() {
		this.show = false;
		this.r = 10;
		this.explRad = 125;
		/*this.tri = new Triangle[];
		for (i=0; i<n; i++) {
			tri[i] = Triangle(a*Math.random(), b*Math.random(), c*Math.random())
		}*/
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
	protected int getXBomb() {
		return x;
	}
	
	protected int getYBomb() {
		return y;
	}
	
	protected int readExplRad() {
		return explRad;
	}
	
	/* Die draw Methode fragt erst ab, ob die Bombe überhaupt
	 * angezeigt werden darf (über Boolean show). Die Bombe soll blinken, 
	 * braucht also min. zwei Anzeigezustände. */
	protected void draw() {
		if(show) {
			drawCount ++;	//Hier wird gezählt, wie oft die Bombe schon gemalt wurde
			g2.setColor(Color.RED);
			
			if (drawCount <= 80) {	//Entspricht 80*20ms = 2 Sekunden zeit bis zur Explosion
				if((drawCount%20) < 10) {
					g2.drawOval(x+15, y+15, 2*r, 2*r);
				} else {
					g2.fillOval(x+15, y+15, 2*r, 2*r);
				}
			} else {
				super.bombExploded();
				if(drawCount <= 10) {
					g2.setColor(Color.YELLOW);
					g2.fillOval(x-explRad, y-explRad, 2*explRad, 2*explRad);
				} else if (drawCount <= 20) {
					g2.setColor(Color.ORANGE);
					g2.fillOval(x-explRad, y-explRad, 2*explRad, 2*explRad);
				} else if(drawCount <= 30){
					g2.setColor(Color.RED);
					g2.fillOval(x-explRad, y-explRad, 2*explRad, 2*explRad);
				} else {
					drawCount = 0;
					show = false;
				}
			}	
		}		
	}	
}