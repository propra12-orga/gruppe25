package gui;

import java.awt.event.*;

public class StartListener implements ActionListener {
	private Logik l;
	
	protected StartListener(Logik lInit) {
		this.l = lInit;
	}
	
	public void actionPerformed(ActionEvent a) {
		l.startPressed();
	}
}
