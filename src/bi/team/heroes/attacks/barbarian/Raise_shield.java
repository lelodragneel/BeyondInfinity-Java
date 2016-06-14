package bi.team.heroes.attacks.barbarian;

import javax.swing.JButton;

import bi.team.BeyondInfinity;
import bi.team.Game;
import bi.team.heroes.Barbarian;

public class Raise_shield extends Attack {
	
	// constructor
	public Raise_shield(Barbarian hero, Game game) {
		super(hero, game, new JButton("<html>"
				+ "<table width=\"162\">"
				+ "<tr>"
					+ "<td width=\"48\" rowspan=\"2\" align=\"left\">" + "<img src=\"" + BeyondInfinity.class.getResource("/images/attacks/raise_shield.png") + "\">" + "</th>"
					+ "<td height=\"26\" align=\"center\"><font size=\"4\">Raise Shield</font></th>"
				+ "</tr>"
				+ "<tr>"
					+ "<td><p align=\"center\">3x <img src=\"" + BeyondInfinity.class.getResource("/images/rage_mini.png") + "\"></p></td>"
				+ "</tr>"
			+ "</table>"
			+ "</html>"));
		
		maxWarmup = 5;
		curWarmup = 5;
		rageNeeded = 0;
	}

	@Override
	public void startAttack() {
		
	}

	@Override
	public void activeEffects() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void turnEffects() {
		// TODO Auto-generated method stub
		
	}
	
}
