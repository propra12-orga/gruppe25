


public class GameEngine {

	public static int x;
	public static int y;

	public static void start(){
		
	 		int a[][]=Spielfeld.build();
		  
	 	
	 		
	 		
	 		StdDraw.setCanvasSize(800,800);
	 		StdDraw.setXscale(0, 800);
	 		StdDraw.setYscale(0, 800);

 			Stein.paint(a);

 		 	
 			Spieler.paint(50,50);
 			
	 		
	 		StdDraw.setPenColor(Draw.BLACK); 
	 		StdDraw.show(100);	
	 
	 		
	 		
	 		
	 		
	}
	
	
	

}
