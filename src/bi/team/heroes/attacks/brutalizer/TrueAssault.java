package bi.team.heroes.attacks.brutalizer;

import javax.swing.JButton;

import bi.team.heroes.Hero;
import bi.team.heroes.attacks.Attack;

public class TrueAssault extends Attack {
	
	public TrueAssault(Hero hero) {
		super(hero, new JButton("True Assault"));
	}
	
}
