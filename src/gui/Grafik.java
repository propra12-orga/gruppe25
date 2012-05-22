package gui;

import java.awt.*;

import javax.swing.*;

/**
 * /Hier kommt ein Kommentar hin
 * 
 * @author Aiko
 * 
 */
public class Grafik {

	/* Hier sind die logischen Verknüpfungen der wichtigen Klassen */
	private Logik logic;
	private Eingabe e;
	private Menu m;
	private GameOver over;
	private GameWon won;

	/* Hier kommen die Figur, alle Steine, die Bombe und die Tür rein */
	private Figur fig;
	private Stein[] steine;
	private Door door;
	private Bombe bomb;

	/*
	 * In dieses Array kommen alle zu zeichnenden Objekte, das macht nachher die
	 * draw-Methode sehr viel entspannter. Es gilt: obj[0] -> Figur obj[1 bis
	 * n-3] -> Steine obj[n-2] -> Tür obj[n-1] -> Bombe
	 */
	private Grafik[] obj;
	protected Graphics2D g2;

	// Die Arraywerte, wo was auf dem Spielfeld liegen soll
	private int[][] level;
	private Level mapLevel;

	/*
	 * Dies ist die Anzeige, es wird nicht zwischen Frames, sondern nur zwischen
	 * Panels hin und her geswitcht.
	 */
	private JFrame gameFrame;
	private JPanel gamePanel; // Hier wird das eigentliche Spiel angezeigt
	private Color gameColor;

	/* Diese Methoden inkrementieren die x,y Werte der Figur */
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

	/*
	 * Hier sind Getter-Methoden für die x,y Werte von Figur und Bombe, sowie
	 * der Sprengradius der Bombe, welche in der Logik benötigt werden.
	 */
	protected int getFigX() {
		return fig.readX();
	}

	protected int getFigY() {
		return fig.readY();
	}

	protected int getBombX() {
		return bomb.getXBomb();
	}

	protected int getBombY() {
		return bomb.getXBomb();
	}

	protected int getExplRad() {
		return bomb.readExplRad();
	}

	/* Getter und Setter der Logik-Variable */
	protected void setLogik(Logik lInit) {
		this.logic = lInit;
	}

	protected Logik getLogik() {
		return logic;
	}

	/* Setter der Eingabe-Variable */
	protected void setEingabe(Eingabe eInit) {
		this.e = eInit;
	}

	protected void init() {
		m = new Menu(logic);
		over = new GameOver(logic);
		won = new GameWon(logic);

		m.init();
		over.init();
		won.init();

		initGamePanel(); /*
						 * Wegen Übersichtlichkeit ist die initialisierung des
						 * Gamepanels in einer seperaten Methode. Desweiteren
						 * kann das Gamepanel dann auch später erneut (mit
						 * anderem Level) initialisiert werden.
						 */
	}

	protected void initGamePanel() {
		mapLevel = new Level();
		level = mapLevel.getLevel();
		// try {
		int n = level[0].length; // Anzahl aller Steine + Tür + Figur
		obj = new Grafik[n + 1]; // Hier kommen alle anzuzeigenden Objekte rein
		fig = new Figur(level[0][0], level[1][0], level[0][n - 1],
				level[1][n - 1]); // Übergabe des x- und y-Wertes der Figur.
		door = new Door(level[0][n - 1], level[1][n - 1]);
		steine = new Stein[n - 2];

		obj[0] = fig;
		obj[n - 1] = door;
		obj[n] = bomb;
		for (int i = 1; i < (n - 1); i++) {
			steine[i - 1] = new Stein(level[0][i], level[1][i]);
			obj[i] = steine[i - 1];
		}

		gameColor = Color.BLACK; // Hintergrundfarbe ist schwarz
		gamePanel = new JPanel() {
			private static final long serialVersionUID = 1L; //Eigentlich Scheißegal, aber JPanel will das haben. 

			protected void paintComponent(Graphics g) {
				
				super.paintComponent(g);
				g2 = (Graphics2D) g;

				for (int i = 0; i < obj.length; i++) {
					obj[i].draw();
				}
			}
		};
		gamePanel.addKeyListener(e); // Keylistener Eingabe wird hinzugefügt
		gamePanel.setBackground(gameColor);
	}

	protected void start() {
		gameFrame = new JFrame();
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Das Ding
																	// soll auch
																	// zugehen
		gameFrame.setSize(800, 600); // 800x600 Pixel, wird dann auch auf meinem
										// Netbook angezeigt
		gameFrame.setLayout(null); // Das Layout machen wir schön selber

		gameFrame.setContentPane(m.getPane()); // Beim ersten Aufruf wird der
												// Pane des Menüs angezeigt
		gameFrame.setVisible(true);
	}

	protected void startGame() {
		gameFrame.remove(m.getPane());
		gameFrame.setContentPane(gamePanel); // Änderung des Panels zum
												// game-Panel
		int t = 1000; // So lange verzögern bis zum nächsten Bild (in
					// Millisekunden)
		GrafikThread thread = new GrafikThread();
		thread.start();
		while (logic.getGameStatus()) {

			gamePanel.repaint();
			thread.run(t);
		}
	}

	protected void gameOver() {
		logic.setGameStatus(false);
		gameFrame.remove(gamePanel);
		gameFrame.setContentPane(over.getPane());
	}

	protected void gameWon() {
		logic.setGameStatus(false);
		gameFrame.setContentPane(won.getPane());
		mapLevel.incrementRound();
	}

	protected void backToMenu() {
		logic.setGameStatus(false);
		gameFrame.remove(gamePanel);
		gameFrame.setContentPane(m.getPane());
	}

	protected void setBomb() {
		bomb.setX(fig.getFigX());
		bomb.setY(fig.getFigY());
		bomb.setShow(true);
	}

	protected void bombExploded() {
		logic.checkLife();
	}

	protected void draw() {
		// Diese Methode bleibt leer, sie wird von den Unterklassen
		// überschrieben.
	}
}
