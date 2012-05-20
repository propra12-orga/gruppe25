package gui;

import java.awt.*;
import javax.swing.*;

/** /Hier kommt ein Kommentar hin
 * @author Aiko
 *
 */
public class Grafik {
	
	/* Hier sind die logischen Verknüpfungen der wichtigen Klassen*/
	private Logik l;
	private Eingabe e;
	private Menu m;
	
	/* Hier kommen die Figur, alle Steine, die Bombe und die Tür rein*/
	private Figur fig; 
	private Stein[] steine;
	private Door door;
	private Bombe bomb;
	
	/* In dieses Array kommen alle zu zeichnenden Objekte, das macht nachher die draw-Methode
	 * sehr viel entspannter. Es gilt:
	 * obj[0] -> Figur
	 * obj[1 bis n-3] -> Steine
	 * obj[n-2] -> Tür
	 * obj[n-1] -> Bombe*/
	private Grafik[] obj;
	
	//Die Arraywerte, wo was auf dem Spielfeld liegen soll
	private int[][] level;	
	
	/* Dies ist die Anzeige, es wird nicht zwischen Frames, sondern 
	   nur zwischen Panels hin und her geswitcht. */
	private JFrame gameFrame;	
	private JPanel gamePanel; //Hier wird das eigentliche Spiel angezeigt
	private Color gameColor;
	
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
	
	/* Hier sind Getter-Methoden für die x,y Werte von Figur und Bombe, sowie der Sprengradius 
	 * der Bombe, welche in der Logik benötigt werden. */
	protected int getFigX() {
		return fig.readX();
	}
	
	protected int getFigY() {
		return fig.readY();
	}
	
	protected int getBombX() {
		return bomb.getX();
	}
	
	protected int getBombY() {
		return bomb.getX();
	}
	
	protected int getExplRad() {
		return bomb.getExplRad();
	}
	
	/* Getter und Setter der Logik-Variable*/
	protected void setLogik(Logik lInit) {
		this.l = lInit;
	}
	
	protected Logik getLogik() {
		return l;
	}
	
	/* Setter der Eingabe-Variable*/
	protected void setEingabe(Eingabe eInit) {
		this.e = eInit;
	}
	
	protected void setLevel(int[][] levelIn) {
		this.level = levelIn;
	}
	
	protected void init() {
		m = new Menu(l); 
		
		int n = level[0].length; //Anzahl aller Steine + Tür + Figur
		obj = new Grafik[n+1]; //Hier kommen alle anzuzeigenden Objekte rein 
		fig = new Figur(level[0][0], level[1][0]); //Übergabe des x- und y-Wertes der Figur. 
		door = new Door(level[0][n], level[1][n]);
		steine = new Stein[n-2];
		
		obj[0] = fig;
		obj[n] = door;
		obj[n+1] = bomb;
		for(int i=1; i<n; i++) {
			steine[i-1] = new Stein(level[0][i], level[1][i]);
			obj[i] = steine[i-1];
		}	
		
		initGamePanel(); /* Wegen Übersichtlichkeit ist die initialisierung des Gamepanels in 
		 				    einer seperaten Methode. */
	}
	
	protected void initGamePanel() {
		gameColor = Color.BLACK;
		gamePanel = new JPanel();
		gamePanel.addKeyListener(e);
		gamePanel.setBackground(gameColor);
	}
	
	protected void start() {
		gameFrame  = new JFrame();
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Das Ding soll auch zugehen
		gameFrame.setSize(800,600);	//800x600 Pixel, wird dann auch auf meinem Netbook angezeigt
		gameFrame.setLayout(null); //Das Layout machen wir schön selber
		
		gameFrame.setContentPane(m.getPane());	//Beim ersten Aufruf wird der Pane des Menüs angezeigt
		gameFrame.setVisible(true);
	}
	
	protected void startGame() {
		gameFrame.setContentPane(gamePanel);
		while(l.getGameStatus()) {
			
			for(int i = 0; i<obj.length; i++) {
				obj[i].draw();
			}
			
		}
	}
	
	protected void gameOver() {
		
	}
	
	protected void backToMenu() {
		gameFrame.setContentPane(m.getPane());
	}
	
	protected void setBomb() {
		bomb.setX(fig.getFigX());
		bomb.setY(fig.getFigY());
		bomb.setShow(true);
	}
	
	protected void draw() {
		//Diese Methode bleibt leer, sie wird von den Unterklassen überschrieben. 
	}
}
