package bi.team.heroes.attacks.brutalizer;

import javax.swing.JButton;

import bi.team.heroes.Hero;
import bi.team.heroes.attacks.Attack;

public class WhirlingTorment extends Attack {
	
	public WhirlingTorment(Hero hero) {
		super(hero, new JButton("Whirling Torment"));
	}
	
}
