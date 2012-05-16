/**
 * 
 */
package gui;

/**
 * @author bene
 *
 */
public class Figur extends Grafik{
	private int y;		//x,y Position der Figur
	private int x;
	
	protected Figur(int xInit, int yInit) {
		this.y = yInit;
		this.x = xInit;
	}
	/* Die folgenden vier Methoden sollen die Position der Figur
	 * durch Funktionenaufruf von Grafik ändern. */
	protected void incY(int n) {
		y+=n;
	}
	
	protected void decY(int n) {
		y-=n;
	}
	
	protected void incX(int n) {
		x+=n;
	}
	
	protected void decX(int n) {
		x-=n;
	}
	
	protected int readY(){
		return y;
	}
	
	protected int readX() {
		return x;
	}
}
