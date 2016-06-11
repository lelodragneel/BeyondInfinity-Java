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
		super.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		// configure variables
		name = "Alania Defender of the Meadow";
		enemyNumber = 7;
		enemyImage_small = new ImageIcon(getClass().getResource("/images/enemies/meadowlands/alania-defender-of-the-meadow_small.png"));
		
	}

}
