package bi.team.enemies.meadowlands;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

import bi.team.Game;
import bi.team.enemies.Enemy;

@SuppressWarnings("serial")
public class Hawk_stag extends Enemy {

	// constructor
	public Hawk_stag(Game game) {
		super(game);
		super.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		
		// configure variables
		name = "Hawk Stag";
		enemyNumber = 2;
		enemyImage_small = new ImageIcon(getClass().getResource("/images/enemies/meadowlands/hawk-stag_small.png"));
		
	}

}
