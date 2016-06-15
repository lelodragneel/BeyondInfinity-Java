package bi.team.heroes.attacks.barbarian;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.text.BadLocationException;

import bi.team.BeyondInfinity;
import bi.team.Game;
import bi.team.heroes.Barbarian;

public class Strike extends Attack {
	
	// constructor
	public Strike(Barbarian hero, Game game) {
		super(hero, game, new JButton("<html>"
				+ "<table width=\"162\">"
					+ "<tr>"
						+ "<td width=\"48\" rowspan=\"2\" align=\"left\">" + "<img src=\"" + BeyondInfinity.class.getResource("/images/attacks/strike.png") + "\">" + "</th>"
						+ "<td height=\"26\" align=\"center\"><font size=\"4\">Strike</font></th>"
					+ "</tr>"
					+ "<tr>"
						+ "<td><p align=\"center\">0x <img src=\"" + BeyondInfinity.class.getResource("/images/rage_mini.png") + "\"></p></td>"
					+ "</tr>"
				+ "</table>"
				+ "</html>"));
		
		maxWarmup = 0;
		curWarmup = 0;
		rageNeeded = 0;
		
		System.out.println(button.getWidth());
		
	}

	@Override
	public void startAttack() throws BadLocationException {
		
		// generate rage
		hero.generateRage(1);
		
		// deal damage to enemy
		game.getEnemySelected().setCurHealth(game.getEnemySelected().getCurHealth() - hero.getSharpness());
		
		// display events
		game.getTextArea().insertIcon(new ImageIcon(getClass().getResource("/images/attacks/strike.png")));
		game.getDoc().insertString(game.getDoc().getLength(), (" " + hero.getSharpness() + " ") , null);
		//game.getTextArea().insertIcon(new ImageIcon(getClass().getResource("/images/attacks/strike.png")));
		game.getDoc().insertString(game.getDoc().getLength(), ("\n") , null);
		
	}

	@Override
	public void activeEffects() {
		System.out.println("strike active");
		
	}

	@Override
	public void turnEffects() {
		// TODO Auto-generated method stub
		
	}
	
}
