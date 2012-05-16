package gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Aiko
 * 
 * Diese Klasse soll die Eingaben der Tastatur und eventuell der Maus
 * auslesen und diese an die Logik des Spiels übergeben. Somit findet
 * die Steuerung der Spielfigur, sowie die Steuerung im Menü statt. 
 *
 *
 * Die Klasse benötigt:
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
 * Und ansonsten natürlich die beiden oben importierten Packages. 
 */
public class Steuerung implements KeyListener{
	
	private Logik logic;
	
	public Steuerung(Logik logicInit){
		this.logic = logicInit;
	}
	
	public void keyPressed(KeyEvent e) {
		char c = e.getKeyChar(); 	  //Liest den Key aus und gibt einen Char zurück
		
		/* Ich verwende hier switch-case, statt if-else Verzweigungen, 
		 * damit die ganze Syntax einfacher zu lesen wird. 
		 * Dieser Teil der Steuerung, nur für gedrückte Keys habe ich
		 * für die Ingame Steuerung angedacht. */
		switch(c) {
		case 'w':		//w: y++
			logic.incrementFigY();
			break;
		
		case 's':		//s: y--
			logic.decrementFigY();
			break;
			
		case 'a':		//a: x--
			logic.decrementFigX();
			break;
			
		case 'd':		//d: x++
			logic.incrementFigX();
			break;
		}
	}
	
	public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		int id = e.getKeyCode();
		
		switch(id) {
		case (KeyEvent.VK_SPACE):
			logic.setBomb(); 	//Bei Leertaste wird eine Bombe gesetzt
			break;
		case (KeyEvent.VK_ESCAPE):
			logic.toMenu();		//Esc-Taste führt zurück zum Menu
			break;
		case (KeyEvent.VK_ENTER):	//Falls wir noch die Enter-Taste implementieren wollen
			logic.enterPressed();
			break;
		}
		
		switch(c){	//Dies habe ich hier für die Menüsteuerung hingepackt (auch WASD)
		case 'w':
			logic.menuUp();
			break;
		case 's':
			logic.menuDown();
			break;
		case 'a':
			logic.menuLeft();
			break;
		case 'd':
			logic.menuRight();
			break;
		}
	}
	
	public void keyReleased(KeyEvent e) {} //Die Methode ist in der Superklasse abstract und muss daher überschrieben werden. 
}