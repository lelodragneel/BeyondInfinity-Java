package bi.team;

import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {

		// start game
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Game();
			}
		});

	}

}
