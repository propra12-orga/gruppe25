

import javax.swing.*;
import java.util.Random;

public class Spielfeld  extends JPanel{
	
	

	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static int[][] build() {
			Random r = new Random();

		    
	//Bildet ein ZufallsSpielfeld gefüllt mit 0 1, ! heist Stein gesetzt
		    
		    int [][]a = new int[8][8];
		    for(int i=0;i<8;i++){
		    	for(int j=0;j<8;j++){
		    			a[i][j]=r.nextInt(2);
		    	}
		    }
		    
		
		int x=0;
		int y=0;
		while(x==0 ||y==0){
			x=r.nextInt(8);
			y=r.nextInt(8);
		}
		a[x][y]=2;
		a[0][0]=0;
		    			
		return a;
	}
	
	
}
