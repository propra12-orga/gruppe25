/**
 * 
 */
package gui;

/**
 * @author bene
 *
 */
public class Menu {
	
	private boolean status;
	private Steuerung s;
	
	protected boolean isStatus() {
		return status;
	}

	protected void setStatus(boolean status) {
		this.status = status;
	}
	
	protected void setSteuerung(Steuerung sInit) {
		this.s = sInit;
	}
}