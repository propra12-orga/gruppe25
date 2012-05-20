package gui;

public class Game {
	
	/* Objektvariablen*/
	private Logik l;
	private Eingabe e;
	private Grafik g;
	
	public void main(){
		new Game();
	}
	
	/* Logik und Grafik m�ssen aufeinander zugreifen k�nnen, die Eingabe muss Befehle an die 
	 * Logik geben k�nnen und die Grafik muss ihren Frames die Eingabe als Listener �bergeben 
	 * k�nnen. */
	public Game(){
		g = new Grafik();
		l = new Logik(g);		
		e = new Eingabe(l);	
		
		g.setEingabe(e);
		g.setLogik(l);
		
		l.start();
	}
}
