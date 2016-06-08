package bi.team.enemies.meadowlands;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

import bi.team.enemies.Enemy;
import bi.team.map.Map;

@SuppressWarnings("serial")
public class Alania_defender_of_the_meadow extends Enemy {

	// constructor
	public Alania_defender_of_the_meadow(Map map) {
		super(map);
		super.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		// configure variables
		name = "<html>Alania Defender of the Meadow</html>";
		enemyNumber = 7;
		enemyImage_small = new ImageIcon(getClass().getResource("/images/enemies/meadowlands/alania-defender-of-the-meadow_small.png"));
		
	}

}
