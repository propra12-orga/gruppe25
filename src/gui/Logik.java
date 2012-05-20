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
	
	//Zwei Werte für die Pos der Figur
	private int figX;
	private int figY;
	
	//Position der Bombe und der Explosionsradius
	private int bombX;
	private int bombY;
	private int bombExplRad;
	
	//Schrittweite der Figur
	private int figStep = 1; 

	private boolean gameStatus;
	
	public Logik(Grafik gInit) {
		this.g = gInit;
	}
	
	protected boolean getGameStatus() {
		return gameStatus;		
	}
	
	protected void setGameStatus(boolean input) {
		this.gameStatus = input;
	}
	
	/* Die folgenden vier Methoden rufen die Grafik auf und 
	 * Inkrementieren oder Dekrementieren die x und y Werte der Figur, oder 
	 * treffen eine Auswahl im Menü. Hier wird auch durch den übergebenen Wert 
	 * festgelegt, um wieviel (vllt. Pixel?) sich die Figur bewegt. */
	protected void up() {
		if(gameStatus) {
			g.decFigY(figStep);
		}
	}
	
	protected void right() {
		if(gameStatus) {
			g.incFigX(figStep);
		}
	}
	
	protected void down() {
		if(gameStatus) {
			g.incFigY(figStep);
		}
	}
	
	protected void left() {
		if(gameStatus) {
			g.decFigX(figStep);
		}
	}
	
	/* Setzten der Bombe durch drücken der Leertaste. */
	protected void setBomb() {
		if(gameStatus) {
			g.setBomb();
		}
	}
	
	protected void enterPressed() {
		
	}
	
	/* Hiermit verlässt man das Spiel wieder und kehrt zum Menü zurück. */
	protected void toMenu() {
		if(gameStatus) {
			g.backToMenu();
			gameStatus = false;
			g.initGamePanel();
		}
	}
	
	//Falls man die Esc-Taste drückt
	protected void showMenu() {
		g.backToMenu();
	}
	
	//Falls man nach GameOver zum Menü zurück möchte
	protected void returnToMenu() {
		g.initGamePanel();
		g.backToMenu();
	}
	
	/* Und nun gehts los!!*/
	protected void start() {
		g.init();
		g.start();
	}
	
	/* Start aus dem Menü heraus*/
	protected void startPressed() {
		gameStatus = true;
		g.startGame();
	}
	
	/* Start aus dem GameOver-Screen heraus. */
	protected void restartPressed() {
		gameStatus = true;
		g.initGamePanel();
		g.startGame();
	}
	
	/* Im folgenden stehen Methoden, die den Zustand von Figur und Spielfeld überprüfen sollen. */
	protected void checkLife() {
		figX = g.getFigX();
		figY = g.getFigY();
		
		bombX = g.getBombX();
		bombY = g.getBombY();
		bombExplRad = g.getExplRad();
		
		double distance = Math.sqrt((figX-bombX)*(figX-bombX)+(figY-bombY)*(figY-bombY));
		if(distance < bombExplRad) {
			g.gameOver();
			gameStatus = false;
		}
	}
}
