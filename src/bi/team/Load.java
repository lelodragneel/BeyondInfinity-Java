package bi.team;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import bi.team.heroes.Hero;
import bi.team.heroes.attacks.barbarian.Attack;

public class Load implements ActionListener {

	// initialize variables
	private Timer timer;
	private int i;
	private Game game;
	private Attack attack;
	private Hero hero;

	// constructor
	public Load(Game game, Hero hero) {
		this.game = game;
		this.hero = hero;
	}

	// TODO implement a new improved double-sided loading bar

	// start animating the loading bar for PLAYER's turn
	public void nextTurn(Attack attack) {
		
		this.attack = attack;

		// disable buttons to prevent simultaneous attacks
		game.disableAttackButtons();
		// reset loading bar
		game.setProgBar_loading(0);

		// reset count
		i = 0;

		// timer which triggers the actionlistener every 15ms
		timer = new Timer(15, this);
		timer.start();

	}
	
	// start animating the loading bar for ENEMY's turn
	public void nextTurn() {

		// disable buttons to prevent simultaneous attacks
		game.disableAttackButtons();
		// reset loading bar
		game.setProgBar_loading(0);

		// reset count
		i = 0;

		// timer which triggers the actionlistener every 15ms
		timer = new Timer(15, this);
		timer.start();

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// increment loading bar value
		game.setProgBar_loading(i++);

		// conditional check for who's turn
		if (i > 100) {

			// stop the loop
			timer.stop();

			// perform attacks
			if (Game.getTurn()) {
				// player attacks enemy
				hero.attackEnemy(attack);
				// change turns
				Game.addTurn();
				nextTurn();
			} else {
				// enemy attacks the player
				game.getEnemySelected().attackPlayer();
				// check if hero is dead
				if (!hero.isAlive()) {
					game.resurrectLatestEnemy();
				}
				// change turns
				Game.addTurn();
				// re-enable buttons
				game.enableAttackButtons();
			}
			
		}
		

	}

}
