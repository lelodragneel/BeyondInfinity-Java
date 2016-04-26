package bi.team;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import bi.team.heroes.attacks.Attack;

public class Load implements ActionListener {

	// initialize variables
	private Timer timer;
	private int i;
	private Game parent;
	private Attack attack;

	// constructor
	public Load(Game parent) {
		this.parent = parent;
	}

	// TODO implement a new improved double-sided loading bar

	// start animating the loading bar for PLAYER's turn
	public void nextTurn(Attack attack) {
		
		this.attack = attack;

		// disable buttons to prevent simultaneous attacks
		parent.disableAttackButtons();

		// reset loading bar
		parent.setProgBar_loading(0);

		// reset count
		i = 0;

		// timer which triggers the actionlistener every 15ms
		timer = new Timer(15, this);
		timer.start();

	}
	
	// start animating the loading bar for ENEMY's turn
	public void nextTurn() {

		// disable buttons to prevent simultaneous attacks
		parent.disableAttackButtons();
		// reset loading bar
		parent.setProgBar_loading(0);

		// reset count
		i = 0;

		// timer which triggers the actionlistener every 15ms
		timer = new Timer(15, this);
		timer.start();

	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// increment loading bar value
		parent.setProgBar_loading(i++);

		// conditional check for who's turn
		if (i > 100) {

			// stop the loop
			timer.stop();

			// perform attacks
			if (Game.getTurn()) {
				parent.playerAttacking(attack);
				// change turns
				Game.toggleTurn();
				nextTurn();
			} else {
				// change turns
				Game.toggleTurn();
				parent.enemyAttacking();
				// re-enable buttons
				parent.enableAttackButtons();
			}
			
		}
		

	}

}
