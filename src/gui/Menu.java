/**
 * 
 */
package gui;

/**
 * @author Aiko
 *
 */
public class Menu extends Grafik {
	
	private boolean status;
	private Eingabe e;
	
	protected boolean isStatus() {
		return status;
	}

	protected void setStatus(boolean status) {
		this.status = status;
	}
	
	protected void setSteuerung(Eingabe eInit) {
		this.e = eInit;
	}
}