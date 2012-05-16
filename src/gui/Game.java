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
		g = new Grafik();
		m = new Menu();
		l = new Logik(g,m);

		s = new Steuerung(l);
		
		g.addActionListener(s);
		m.addActionListener(s);
	}
}
