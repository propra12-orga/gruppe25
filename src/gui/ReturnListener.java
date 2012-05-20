package gui;

import java.awt.event.*;

public class ReturnListener implements ActionListener{
	private Logik l;
	
	protected ReturnListener(Logik lInit) {
		this.l = lInit;
	}
	
	public void actionPerformed(ActionEvent a) {
		l.returnToMenu();
	}
}
