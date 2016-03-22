package bi.team;

public class ThreadLoadingBar implements Runnable {

	public void run() {

		// disable buttons to limit the game to one thread
		Game.disableButtons();

		// loops once while increasing the loading bar's value
		for (int i = 0; i <= 100; i++) {
			Game.setProgBar_loading(i);
			
			// wait a number of milliseconds
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}

		}

		// re-enable buttons
		Game.enableButtons();

	}

}
