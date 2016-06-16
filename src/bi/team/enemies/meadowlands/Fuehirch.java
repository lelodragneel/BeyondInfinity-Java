package bi.team.enemies.meadowlands;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

import bi.team.Game;
import bi.team.enemies.Enemy;

@SuppressWarnings("serial")
public class Fuehirch extends Enemy {

	// constructor
	public Fuehirch(Game game) {
		super(game);
		
		// configure variables
		super.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		name = "Fuehirch";
		enemyNumber = 1;
		damage = 10;
		maxHealth = 90;
		curHealth = 90;
		experienceDrop = 0;
		enemyImage_small = new ImageIcon(getClass().getResource("/images/enemies/meadowlands/fuehirch_small.png"));
		
	}

	// attack player
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
	public void prepareFight() {
		game.getBar_enemyHealth().setMaximum((int) maxHealth);
		game.getBar_enemyHealth().setValue((int) maxHealth);
		game.getBar_enemyHealth().setString(game.getEnemySelected().getCurHealth() + " / " + game.getEnemySelected().getMaxHealth());
	}

}
