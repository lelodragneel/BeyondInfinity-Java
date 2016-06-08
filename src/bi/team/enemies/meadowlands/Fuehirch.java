package bi.team.enemies.meadowlands;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

import bi.team.Map;
import bi.team.enemies.Enemy;

@SuppressWarnings("serial")
public class Fuehirch extends Enemy {

	// constructor
	public Fuehirch(Map map) {
		super(map);
		super.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		
		// configure variables
		name = "Fuehirch";
		enemyNumber = 1;
		enemyImage_small = new ImageIcon(getClass().getResource("/images/enemies/meadowlands/fuehirch_small.png"));
		
	}

}
