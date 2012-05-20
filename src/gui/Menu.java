/**
 * 
 */
package gui;

import java.awt.*;
import javax.swing.*;
/**
 * @author Aiko
 *
 */
public class Menu {
	
	private Logik logic;
	private JPanel menu;
	private JButton[] buttons;
	private BorderLayout layout;
	
	protected Menu(Logik lInit) {
		this.logic = lInit;
	}
	
	protected JPanel getPane() {
		return menu;
	}
	
	protected void init() {
		layout = new BorderLayout();
		menu = new JPanel(layout);
		menu.setLayout(null);
		
		buttons = new JButton[1];
		buttons[0] = new JButton("Spiel Starten!!");
		buttons[0].addActionListener(new StartListener(logic));
		buttons[0].setSize(200, 50);
		buttons[0].setLocation(300, 275);
		
		for(int i = 0; i<buttons.length; i++) {
			menu.add(buttons[i]);
		}
	}
}