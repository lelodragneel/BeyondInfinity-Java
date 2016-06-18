package bi.team.heroes.attacks.barbarian;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

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

	}

	@Override
	public void startAttack() throws BadLocationException {
		
		// consume rage
		hero.consumeRage(rageNeeded);
		
		// deal damage to enemy
		double dmg = (20 + hero.getSharpness()) * hero.getDmgMultiplier();
		game.getEnemySelected().setCurHealth(game.getEnemySelected().getCurHealth() - dmg);
		
		// display events
		Document doc = game.getTextArea().getDocument();
		doc.insertString(doc.getLength(), "\n", game.getaSet());
		game.getTextArea().insertIcon(new ImageIcon(getClass().getResource("/images/attacks/heavy_blow.png")));
		doc.insertString(doc.getLength(), dmg + "", game.getaSet());
		game.getTextArea().insertIcon(new ImageIcon(getClass().getResource("/images/enemy.png")));
		
	}

	@Override
	public void activeEffects() {
		
	}

	@Override
	public void turnEffects() {
		// TODO Auto-generated method stub
		
	}
	
}
