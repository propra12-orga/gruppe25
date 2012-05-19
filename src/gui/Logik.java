/**
 * 
 */
package gui;

/**
 * @author bene
 *
 */

public class Logik {
	private Grafik g;
	private int figStep = 1; //Schrittweite der Figur
	private Eingabe e;
	private boolean menuStatus;
	private boolean gameStatus;
	
	public Logik(Grafik gInit) {
		this.g = gInit;
	}
	
	protected void setEingabe(Eingabe eInit) {
		this.e = eInit;
	}
	/* Die folgenden vier Methoden rufen die Grafik auf und 
	 * Inkrementieren oder Dekrementieren die x und y Werte der Figur, oder 
	 * treffen eine Auswahl im Menü. Hier wird auch durch den übergebenen Wert 
	 * festgelegt, um wieviel (vllt. Pixel?) sich die Figur bewegt. */
	protected void up() {

	}
	
	protected void right() {

	}
	
	protected void down() {

	}
	
	protected void left() {

	}
	
	protected void setBomb() {
		
	}
	
	protected void enterPressed() {
		
	}
	
	protected void toMenu() {
		
	}
	
	protected void start() {
		g.init();
		g.setMenuStatus(true);
		this.menuStatus = true;
		
		g.start();
	}
}
