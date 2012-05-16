package gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Aiko
 * 
 * Diese Klasse soll die Eingaben der Tastatur und eventuell der Maus
 * auslesen und diese an die Logik des Spiels �bergeben. Somit findet
 * die Steuerung der Spielfigur, sowie die Steuerung im Men� statt. 
 *
 *
 * Die Klasse ben�tigt:
 * Aus der Klasse Logik, folgende Methoden:
 * 
 * incrementFigY()
 * incrementFigX()
 * decrementFigy()
 * decrementFigX()
 * 
 * setBomb()
 * toMenu()
 * enter
 * 
 * menuUp()
 * menuDown()
 * menuLeft()
 * menuRight()
 * 
 * Und ansonsten nat�rlich die beiden oben importierten Packages. 
 */
public class Steuerung implements KeyListener{
	
	private Logik logic;
	
	public Steuerung(Logik logicInit){
		this.logic = logicInit;
	}
	
	public void keyPressed(KeyEvent e) {
		char c = e.getKeyChar(); 	  //Liest den Key aus und gibt einen Char zur�ck
		int id = e.getKeyCode();
		
		/* Ich verwende hier switch-case, statt if-else Verzweigungen, 
		 * damit die ganze Syntax einfacher zu lesen wird. 
		 * Hier muss die Logik entscheiden ob ein Men� offen ist und
		 * ob also die Figur bewegt oder durchs Men� gesteuert wird.  */
		switch(c) {
		case 'w':		//w: y++
			logic.up();
			break;
		
		case 's':		//s: y--
			logic.down();
			break;
			
		case 'a':		//a: x--
			logic.left();
			break;
			
		case 'd':		//d: x++
			logic.right();
			break;
		}
		
		switch(id) {
		case (KeyEvent.VK_SPACE):
			logic.setBomb(); 		//Bei Leertaste wird eine Bombe gesetzt
			break;
		case (KeyEvent.VK_ESCAPE):
			logic.toMenu();			//Esc-Taste f�hrt zur�ck zum Menu
			break;
		case (KeyEvent.VK_ENTER):	//Falls wir noch die Enter-Taste implementieren wollen
			logic.enterPressed();
			break;
		}
	}
	
	/* Die folgenden Methoden sind in der Superklasse abstract und 
	 * m�ssen daher �berschrieben werden. */
	public void keyTyped(KeyEvent e) {}	
	public void keyReleased(KeyEvent e) {} 
}