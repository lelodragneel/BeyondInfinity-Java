package bi.team.enemies.meadowlands;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

import bi.team.enemies.Enemy;
import bi.team.map.Map;

@SuppressWarnings("serial")
public class Mantisray extends Enemy {

	// constructor
	public Mantisray(Map map) {
		super(map);
		super.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		
		// configure variables
		name = "<html>Mantisray</html>";
		enemyNumber = 6;
		enemyImage_small = new ImageIcon(getClass().getResource("/images/enemies/meadowlands/mantisray_small.png"));
		
	}

}
