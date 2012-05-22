
public class Stein {

	
	public static void paint(int a[][]){
	
	    StdDraw.rectangle(400, 400, 400, 400);
	    for(int i=0;i<8;i++){
	    	for(int j=0;j<8;j++){
	    		if(a[i][j]==1){
	    			StdDraw.setPenColor(StdDraw.BLUE);
	    			StdDraw.filledRectangle(i*100+50, j*100+50,50, 50);
	    		}
	    		if(a[i][j]==2){
	    			StdDraw.setPenColor(StdDraw.GREEN);
	    			StdDraw.filledRectangle(i*100+50, j*100+50,50, 50);
	    		}
	    			
	    	}
	    	
	    }
	}
	
	
}