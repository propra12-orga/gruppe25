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
	private Menu m;
	private int figStep = 1;
	
	public Logik(Grafik gInit, Menu mInit) {
		this.g = gInit;
		this.m = mInit;
	}
	
	/* Die folgenden vier Methoden rufen die Figur in der Grafik auf und 
	 * Inkrementieren oder Dekrementieren dessen x und y Wert. Hier wird 
	 * auch durch den übergebenen Wert festgelegt, um wieviel (vllt Pixel)
	 * sich die Figur bewegt. */
	protected void up() {
		if(m.isStatus()) ;//selektor rauf
		else g.decFigY(figStep); //y-Achse zeigt nach unten
	}
	
	protected void right() {
		if(m.isStatus()); //selektor rechts
		else g.incFigX(figStep);
	}
	
	protected void down() {
		if(m.isStatus()); //selektor runter
		else g.incFigY(figStep);
	}
	
	protected void left() {
		if(m.isStatus()); //selektor links
		else g.decFigX(figStep);
	}
	
	protected void setBomb() {
		
	}
	
	protected void enterPressed() {
		
	}
	
	protected void toMenu() {
		
	}
}
