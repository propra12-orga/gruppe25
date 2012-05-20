package gui;

public class Game {
	
	/* Objektvariablen*/
	private Logik l;
	private Eingabe e;
	private Grafik g;
	
	public void main(){
		new Game();
	}
	
	/* Logik und Grafik müssen aufeinander zugreifen können, die Eingabe muss Befehle an die 
	 * Logik geben können und die Grafik muss ihren Frames die Eingabe als Listener übergeben 
	 * können. */
	public Game(){
		g = new Grafik();
		l = new Logik(g);		
		e = new Eingabe(l);	
		
		g.setEingabe(e);
		g.setLogik(l);
		
		l.start();
	}
}
