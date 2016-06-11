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
		super.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		
		// configure variables
		name = "Fuehirch";
		enemyNumber = 1;
		damage = 10;
		maxHealth = 90;
		curHealth = 90;
		enemyImage_small = new ImageIcon(getClass().getResource("/images/enemies/meadowlands/fuehirch_small.png"));
		
	}

	// attack player
	public void attackPlayer() {
		game.getHero().setCurHealth(game.getHero().getCurHealth() - damage);
		game.getBar_playerHealth().setValue((int) game.getHero().getCurHealth());
		game.getBar_playerHealth().setString(game.getBar_playerHealth().getValue() + " / " + game.getBar_playerHealth().getMaximum());
		
	}

}
