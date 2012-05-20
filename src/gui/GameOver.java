package gui;

import java.awt.*;
import javax.swing.*;

public class GameOver {
	
	private Logik logic;
	private JPanel gameOver;
	private JButton[] buttons;
	
	protected GameOver(Logik lInit) {
		this.logic = lInit;
	}
	
	protected void init() {
		gameOver = new JPanel();
		gameOver.setBackground(Color.BLACK);
		gameOver.setLayout(null);
		
		buttons = new JButton[2];
		buttons[0] = new JButton("Zurück zum Menü");
		buttons[1] = new JButton("Nochmal versuchen");
		
		buttons[0].setSize(250, 50);
		buttons[0].setLocation(100, 375);
		buttons[1].setSize(250, 50);
		buttons[1].setLocation(450, 375);
		
		
		buttons[0].addActionListener(new ReturnListener(logic));
		buttons[1].addActionListener(new ReStartListener(logic));
		
		for(int i=0; i<buttons.length; i++) {
			gameOver.add(buttons[i]);
		}
	}
	
	protected JPanel getPane() {
		return gameOver;
	}
}
