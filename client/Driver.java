package client;
import javax.swing.SwingUtilities;

import view.MainFrame;

public class Driver {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				new MainFrame();

			}
		});
	}

}



