package bi.team.enemies.meadowlands;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

import bi.team.Game;
import bi.team.enemies.Enemy;

@SuppressWarnings("serial")
public class Mantisray extends Enemy {

	// constructor
	public Mantisray(Game game) {
		super(game);
		
		// configure variables
		super.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		name = "Mantisray";
		enemyNumber = 6;
		damage = 10;
		maxHealth = 90;
		curHealth = 90;
		experienceDrop = 0;
		enemyImage = new ImageIcon(getClass().getResource("/images/enemies/meadowlands/mantisray.png"));
		enemyImage_small = new ImageIcon(getClass().getResource("/images/enemies/meadowlands/mantisray_small.png"));
		
	}

	// attack player
	@Override
	public void attackPlayer() {

		// hero takes damage
		game.getHero().setCurHealth(game.getHero().getCurHealth() - damage);
		
		// paint hero's health bar
		game.getBar_playerHealth().setValue((int) game.getHero().getCurHealth());
		game.getBar_playerHealth().setString(game.getHero().getCurHealth() + " / " + game.getHero().getMaxHealth());
		
		// repaint health bars
		game.repaint();
		
	}

	// prepare gui for battle
	@Override
	public void prepareFight() {
		game.getBar_enemyHealth().setMaximum((int) maxHealth);
		game.getBar_enemyHealth().setValue((int) maxHealth);
		game.getBar_enemyHealth().setString(curHealth + " / " + maxHealth);	
	}

}
