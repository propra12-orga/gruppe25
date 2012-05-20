package gui;

import java.awt.*;
import javax.swing.*;

public class GameWon {
	
	private Logik logic;
	private JPanel gameWon;
	private JButton[] buttons;
	
	protected GameWon(Logik lInit) {
		this.logic = lInit;
	}
	
	protected void init() {
		gameWon = new JPanel();
		gameWon.setBackground(Color.LIGHT_GRAY);
		gameWon.setLayout(null);
		
		buttons = new JButton[1];
		buttons[0] = new JButton("Zurück zum Menü");
		
		buttons[0].setSize(300, 50);
		buttons[0].setLocation(150, 375);		
		
		buttons[0].addActionListener(new ReturnListener(logic));
		
		for(int i=0; i<buttons.length; i++) {
			gameWon.add(buttons[i]);
		}
	}
	
	protected JPanel getPane() {
		return gameWon;
	}
}
