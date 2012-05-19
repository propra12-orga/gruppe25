/**
 * 
 */
package gui;

/** /Hier kommt ein Kommentar hin
 * @author Aiko
 *
 */
public class Grafik {
	
	private Logik l;
	private Eingabe e;
	private Menu m;
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
	
	/* Setzt den Anzeigestatus des Menüs*/
	protected void setMenuStatus(boolean tf) {
		m.setStatus(tf);
	}
	
	protected void setLogik(Logik lInit) {
		this.l = lInit;
	}
	
	protected void setEingabe(Eingabe eInit) {
		this.e = eInit;
	}
	
	protected void init() {
		m = new Menu(); 
	}
	
	protected void start() {
		
	}
}
