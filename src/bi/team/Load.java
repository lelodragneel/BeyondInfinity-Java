package bi.team;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Load {

	// init variables
	private Timer timer;
	private int i;
	private Game parent;

	// constructor
	public Load(Game parent) {
		this.parent = parent;
	}

	// start animating the loading bar
	public void start(Attack attack) {

		// disable buttons to prevent simultaneous attacks
		parent.disableButtons();

		// reset loading bar
		parent.setProgBar_loading(0);

		// reset count
		i = 0;

		// the actionlistener controlled by the timer
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// increment loading bar value
				parent.setProgBar_loading(i++);

				// conditional check for who's turn
				if (i > 100) {
					
					// stop the loop
					timer.stop();
					parent.checkWinner();
					
					// if it's the player's turn
					if (Game.getTurn() == true) 
						parent.attackEnemy(attack);
					else { 	// else it's the enemy's turn
						if (Game.getTurn() == false) {
							parent.attackPlayer();
							// re-enable buttons
							parent.enableButtons();
						}
					}
				}
			}
		};

		// timer which triggers the actionlistener every 15ms
		timer = new Timer(15, listener);
		timer.start();

	}

}
