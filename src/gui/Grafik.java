/**
 * 
 */
package gui;

/** /Hier kommt ein Kommentar hin
 * @author bene
 *
 */
public class Grafik {
	
	private Steuerung s;
	private int x0 = 0;
	private int y0 = 0;
	private Figur fig = new Figur(x0, y0); //erstmal um eine Figur zu haben, kann ersetzt werden
	
	/* Diese Methoden inkrementieren die x,y Werte der Figur*/
	protected void incFigX(int i) {
		fig.incX(i);
	}
	
	protected void decFigX(int i) {
		fig.decX(i);
	}
	
	protected void incFigY(int i) {
		fig.incY(i);
	}
	
	protected void decFigY(int i) {
		fig.decY(i);
	}
	
	protected void setSteuerung(Steuerung sInit) {
		this.s = sInit;
	}
}
