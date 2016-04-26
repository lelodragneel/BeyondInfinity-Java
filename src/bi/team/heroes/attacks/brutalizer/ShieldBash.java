package bi.team.heroes.attacks.brutalizer;

import javax.swing.JButton;

import bi.team.heroes.Hero;
import bi.team.heroes.attacks.Attack;

public class ShieldBash extends Attack {
	
	public ShieldBash(Hero hero) {
		super(hero, new JButton("Shield Bash"));
	}
	
}
