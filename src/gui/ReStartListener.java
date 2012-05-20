package gui;

import java.awt.event.*;

public class ReStartListener implements ActionListener {
	private Logik l;
	
	protected ReStartListener(Logik lInit) {
		this.l = lInit;
	}
	
	public void actionPerformed(ActionEvent a) {
		l.restartPressed();
	}
}
