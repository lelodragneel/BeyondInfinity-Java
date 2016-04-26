package bi.team.heroes.attacks.brutalizer;

import javax.swing.JButton;

import bi.team.heroes.Hero;
import bi.team.heroes.attacks.Attack;

public class BaneBlast extends Attack {

	public BaneBlast(Hero hero) {
		super(hero, new JButton("Bane Blast"));
	}
	
}
