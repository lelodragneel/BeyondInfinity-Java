package bi.team.enemies.meadowlands;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

import bi.team.enemies.Enemy;
import bi.team.map.Map;

@SuppressWarnings("serial")
public class Shar_of_the_nacht extends Enemy {

	// constructor
	public Shar_of_the_nacht(Map map) {
		super(map);
		super.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		
		// configure variables
		name = "<html>Shar of the Nacht</html>";
		enemyNumber = 5;
		enemyImage_small = new ImageIcon(getClass().getResource("/images/enemies/meadowlands/shar-of-the-nacht_small.png"));
		
	}

}
