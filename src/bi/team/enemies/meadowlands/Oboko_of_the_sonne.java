package bi.team.enemies.meadowlands;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

import bi.team.Game;
import bi.team.enemies.Enemy;

@SuppressWarnings("serial")
public class Oboko_of_the_sonne extends Enemy {

	// constructor
	public Oboko_of_the_sonne(Game game) {
		super(game);
		super.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		
		// configure variables
		name = "Oboko of the Sonne";
		enemyNumber = 4;
		enemyImage_small = new ImageIcon(getClass().getResource("/images/enemies/meadowlands/oboko-of-the-sonne_small.png"));
		
	}

}
