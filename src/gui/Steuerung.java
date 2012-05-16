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
 * Die Klasse benötigt:
 * Aus der Klasse Logik, folgende Methoden:
 * 
 * static incrementFigY()
 * static incrementFigX()
 * static decrementFigy()
 * static decrementFigX()
 * 
 * static setBomb()
 * static toMenu()
 * static enter
 * 
 * static menuUp()
 * static menuDown()
 * static menuLeft()
 * static menuRight()
 * 
 * Und ansonsten natürlich die beiden oben importierten Packages. 
 */
public class Steuerung implements KeyListener{
	
	public void keyPressed(KeyEvent e) {
		char c = e.getKeyChar(); 	  //Liest den Key aus und gibt einen Char zurück
		int id = e.getKeyCode(); 	  //Gibt den zu einer Tastenkombination zugehörigen int-Wert aus
		
		/* Ich verwende hier switch-case, statt if-else Verzweigungen, 
		 * damit die ganze Syntax einfacher zu lesen wird. 
		 * Dieser Teil der Steuerung, nur für gedrückte Keys habe ich
		 * für die Ingame Steuerung angedacht. */
		switch(c) {
		case 'w':		//w: y++
			Logik.incrementFigY();
			break;
		
		case 's':		//s: y--
			Logik.decrementFigY();
			break;
			
		case 'a':		//a: x--
			Logik.decrementFigX();
			break;
			
		case 'd':		//d: x++
			Logik.incrementFigX();
			break;
		}
	}
	
	public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		int id = e.getKeyCode();
		
		switch(id) {
		case (KeyEvent.VK_SPACE):
			Logik.setBomb(); 	//Bei Leertaste wird eine Bombe gesetzt
			break;
		case (KeyEvent.VK_ESCAPE):
			Logik.toMenu();		//Esc-Taste führt zurück zum Menu
			break;
		case (KeyEvent.VK_ENTER):	//Falls wir noch die Enter-Taste implementieren wollen
			Logik.enterPressed();
			break;
		}
		
		switch(c){	//Dies habe ich hier für die Menüsteuerung hingepackt (auch WASD)
		case 'w':
			Logik.menuUp();
			break;
		case 's':
			Logik.menuDown();
			break;
		case 'a':
			Logik.menuLeft();
			break;
		case 'd':
			Logik.menuRight();
			break;
		}
	}
	
	public void keyReleased(KeyEvent e) {} //Die Methode ist in der Superklasse abstract und muss daher überschrieben werden. 
}