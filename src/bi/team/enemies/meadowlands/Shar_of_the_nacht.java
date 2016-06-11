package bi.team.enemies.meadowlands;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

import bi.team.Game;
import bi.team.enemies.Enemy;

@SuppressWarnings("serial")
public class Shar_of_the_nacht extends Enemy {

	// constructor
	public Shar_of_the_nacht(Game game) {
		super(game);
		super.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		
		// configure variables
		name = "Shar of the Nacht";
		enemyNumber = 5;
		enemyImage_small = new ImageIcon(getClass().getResource("/images/enemies/meadowlands/shar-of-the-nacht_small.png"));
		
	}

}
