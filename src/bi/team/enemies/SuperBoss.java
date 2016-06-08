package bi.team.bosstype;

import java.awt.Color;

import javax.swing.border.LineBorder;

import bi.team.map.Map;

@SuppressWarnings("serial")
public class SuperBoss extends Enemy {

	// initialize variables
	
	// constructor
	public SuperBoss(Map map, int enemyNumber) {
		super(map, enemyNumber);
		super.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		// configure variables
		name = super.getText();
		//enemyImage = new ImageIcon(BeyondInfinity.class.getResource("images/enemies/"));
		
	}
	
}
