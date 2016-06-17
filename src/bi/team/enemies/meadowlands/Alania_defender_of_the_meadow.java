package bi.team.enemies.meadowlands;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

import bi.team.Game;
import bi.team.enemies.Enemy;

@SuppressWarnings("serial")
public class Alania_defender_of_the_meadow extends Enemy {

	// constructor
	public Alania_defender_of_the_meadow(Game game) {
		super(game);
		
		// configure variables
		super.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		name = "Alania Defender of the Meadow";
		enemyNumber = 7;
		damage = 10;
		maxHealth = 90;
		curHealth = 90;
		experienceDrop = 0;
		enemyImage = new ImageIcon(getClass().getResource("/images/enemies/meadowlands/alania-defender-of-the-meadow.png"));
		enemyImage_small = new ImageIcon(getClass().getResource("/images/enemies/meadowlands/alania-defender-of-the-meadow_small.png"));
		
	}

	// attack player
	@Override
	public void attackPlayer() {

		// hero takes damage
		game.getHero().setCurHealth(game.getHero().getCurHealth() - damage);
		
		// paint hero's health bar
		game.getBar_playerHealth().setValue((int) game.getHero().getCurHealth());
		game.getBar_playerHealth().setString(game.getBar_playerHealth().getValue() + " / " + game.getBar_playerHealth().getMaximum());
		
		// repaint health bars
		game.repaint();
		
	}

	// prepare gui for battle
	@Override
	public void prepareFight() {
		game.getBar_enemyHealth().setMaximum((int) maxHealth);
		game.getBar_enemyHealth().setValue((int) maxHealth);
		game.getBar_enemyHealth().setString(game.getEnemySelected().getCurHealth() + " / " + game.getEnemySelected().getMaxHealth());
	}

}
