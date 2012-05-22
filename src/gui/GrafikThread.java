package gui;

public class GrafikThread extends Thread {
	public void run(int t) {
		try {
			sleep(t);
		} catch (InterruptedException e) {
			System.err.println("Error in Thread.");
		}
	}
}
