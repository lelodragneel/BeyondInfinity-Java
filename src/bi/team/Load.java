package bi.team;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import bi.team.heroes.attacks.Attack;

public class Load {

	// init variables
	private Timer timer;
	private int i;
	private Game parent;

	// constructor
	public Load(Game parent) {
		this.parent = parent;
	}

	// TODO implement a new improved double-sided loading bar

	// start animating the loading bar
	public void nextTurn(Attack attack) {

		// disable buttons to prevent simultaneous attacks
		parent.disableAttackButtons();

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
 
					// call attack method
					parent.useAttack(attack);

				}
			}
		};

		// timer which triggers the actionlistener every 15ms
		timer = new Timer(15, listener);
		timer.start();

	}

}
