package bi.team.enemies.meadowlands;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

import bi.team.enemies.Enemy;
import bi.team.map.Map;

@SuppressWarnings("serial")
public class Taobu extends Enemy {

	// constructor
	public Taobu(Map map) {
		super(map);
		super.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		
		// configure variables
		name = "Taobu";
		enemyNumber = 3;
		enemyImage_small = new ImageIcon(getClass().getResource("/images/enemies/meadowlands/taobu_small.png"));
		
	}

}
