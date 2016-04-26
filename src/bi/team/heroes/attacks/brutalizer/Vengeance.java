package bi.team.heroes.attacks.brutalizer;

import javax.swing.JButton;

import bi.team.heroes.Hero;
import bi.team.heroes.attacks.Attack;

public class Vengeance extends Attack {
	
	public Vengeance(Hero hero) {
		super(hero, new JButton("Vengeance"));
	}
	
}
