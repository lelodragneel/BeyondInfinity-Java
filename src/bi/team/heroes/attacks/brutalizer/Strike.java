package bi.team.heroes.attacks.brutalizer;

import javax.swing.JButton;

import bi.team.heroes.Hero;
import bi.team.heroes.attacks.Attack;

/*
 * For: Berserker
 * ID: #1; Wack; basic attack
 * 
 * 
 */
public class Strike extends Attack {
	
	public Strike(Hero hero) {
		super(hero, new JButton("Strike"));

	}
	
}
