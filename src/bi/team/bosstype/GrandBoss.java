package bi.team.bosstype;

import java.awt.Color;

import javax.swing.border.LineBorder;

import bi.team.map.Map;

@SuppressWarnings("serial")
public class GrandBoss extends Enemy {

	// initialize variables
	
	// constructor
	public GrandBoss(Map map, int enemyNumber) {
		super(map, enemyNumber);
		super.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
	}
	
}
