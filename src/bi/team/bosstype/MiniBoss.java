package bi.team.bosstype;

import java.awt.Color;

import javax.swing.border.LineBorder;

import bi.team.map.Map;

@SuppressWarnings("serial")
public class MiniBoss extends Enemy {

	// initialize variables
	
	// constructor
	public MiniBoss(Map map, int enemyNumber) {
		super(map, enemyNumber);
		super.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		
	}

}
