package bi.team.heroes.attacks.barbarian;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import bi.team.BeyondInfinity;
import bi.team.Game;
import bi.team.heroes.Barbarian;

public class Rage_incite extends Attack {
	
	// constructor
	public Rage_incite(Barbarian hero, Game game) {
		super(hero, game, new JButton("<html>"
				+ "<table width=\"162\">"
				+ "<tr>"
					+ "<td width=\"48\" rowspan=\"2\" align=\"left\">" + "<img src=\"" + BeyondInfinity.class.getResource("/images/attacks/rage_incite.png") + "\">" + "</th>"
					+ "<td height=\"26\" align=\"center\"><font size=\"4\">Rage Incite</font></th>"
				+ "</tr>"
				+ "<tr>"
					+ "<td><p align=\"center\">5x <img src=\"" + BeyondInfinity.class.getResource("/images/rage_mini.png") + "\"></p></td>"
				+ "</tr>"
			+ "</table>"
			+ "</html>"));
		
		maxWarmup = 2;
		curWarmup = 2;
		rageNeeded = 5;

	}

	@Override
	public void startAttack() throws BadLocationException {
		
		// consume rage
		hero.consumeRage(rageNeeded);
		
		// increase damage by 100%
		hero.setDmgMultiplier(hero.getDmgMultiplier() + 1);
		
		// display events
		Document doc = game.getTextArea().getDocument();
		doc.insertString(doc.getLength(), "\n", game.getaSet());
		game.getTextArea().insertIcon(new ImageIcon(getClass().getResource("/images/attacks/rage_incite.png")));
		doc.insertString(doc.getLength(), " activated", game.getaSet());
		
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
