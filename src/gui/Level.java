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
	private static int round = 1;
	private final int[][][] levelPos = {{{0,0},{2,3},{1,10}}};
	
	protected int[][] getLevel() {
		int[][] thisLevel = new int[2][levelPos[0].length];
		for(int i = 0; i < levelPos[0].length; i++){	
			for(int j=0; j<2; j++) {
				thisLevel[j][i] = levelPos[round-1][i][j];
			}
		}
		return thisLevel;
	}
	
	protected void incrementRound() {
		round++;
	}
}

