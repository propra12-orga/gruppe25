package gui;

public class Game {
	
	/* Objektvariablen*/
	private Logik l;
	private Menu m;
	private Steuerung s;
	private Grafik g;
	
	public void main(){
		new Game();
	}
	
	/* Hier passiert die Voodoo Magie*/
	public Game(){
		g = new Grafik();
		m = new Menu();
		l = new Logik(g,m);		//Logik muss Grafik und Menu überwachen und anweisen
		s = new Steuerung(l);	//Die Steuerung hat nun die Möglichkeit Eingaben weiter zu leiten
		
		g.setSteuerung(s);
		m.setSteuerung(s);
		/* Sowohl sie Grafik als auch das Menü müssen auf Eingaben reagieren...
		 * bin mir aber noch nicht sicher ob wir die brauchen (Aiko)*/
		//g.addActionListener(s);	
		//m.addActionListener(s);
	}
}
