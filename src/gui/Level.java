/**
 * 
 */
package gui;


/**
 * @author Aiko
 *
 * Im int[2][n] dieser Klasse werden x und y Werte gespeichert, dabei gilt:
 * xi = int[0][i]
 * yi = int[1][i]
 * 
 * Hier sind x0, y0 die Startwerte der Figur und x(n-1), y(n-1) die Werte der Tür und
 * alle dazwischenliegenden sind Werte der Steine.  
 */
public class Level {
	//private static int round = 1;
	private Grafik g;
	private int[][] level;
	public Level(Grafik gInit) {
		//round++;
		this.g = gInit;
		g.setLevel(level);
	}
}

