package bi.team.heroes.attacks.brutalizer;

import javax.swing.JButton;

import bi.team.heroes.Hero;
import bi.team.heroes.attacks.Attack;

public class BattlerBash extends Attack {
	
	public BattlerBash(Hero hero) {
		super(hero, new JButton("Battler Bash"));
	}
	
}
