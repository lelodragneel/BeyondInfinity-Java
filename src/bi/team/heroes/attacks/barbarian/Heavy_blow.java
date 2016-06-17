package bi.team.heroes.attacks.barbarian;

import javax.swing.JButton;

import bi.team.BeyondInfinity;
import bi.team.Game;
import bi.team.heroes.Barbarian;

public class Heavy_blow extends Attack {
	
	// constructor
	public Heavy_blow(Barbarian hero, Game game) {
		super(hero, game, new JButton("<html>"
				+ "<table width=\"162\">"
				+ "<tr>"
					+ "<td width=\"48\" rowspan=\"2\" align=\"left\">" + "<img src=\"" + BeyondInfinity.class.getResource("/images/attacks/heavy_blow.png") + "\">" + "</th>"
					+ "<td height=\"26\" align=\"center\"><font size=\"4\">Heavy Blow</font></th>"
				+ "</tr>"
				+ "<tr>"
					+ "<td><p align=\"center\">1x <img src=\"" + BeyondInfinity.class.getResource("/images/rage_mini.png") + "\"></p></td>"
				+ "</tr>"
			+ "</table>"
			+ "</html>"));
		
		maxWarmup = 2;
		curWarmup = 2;
		rageNeeded = 1;
		damage = 20;
	}

	@Override
	public void startAttack() {
		
	}

	@Override
	public void activeEffects() {
		System.out.println("heavyblow active");
		
	}

	@Override
	public void turnEffects() {
		// TODO Auto-generated method stub
		
	}
	
}
