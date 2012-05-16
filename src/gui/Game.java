package gui;

public class Game {
	
	private Logik l;
	private Menu m;
	private Steuerung s;
	private Grafik g;
	
	public void main(){
		new Game();
	}
	public Game(){
		l = new Logik();
		m = new Menu();
		s = new Steuerung(l);
		g = new Grafik();
		
		g.addActionListener();
	}
}
