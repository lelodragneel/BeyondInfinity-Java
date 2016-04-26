package bi.team.heroes.attacks.elementalist;

import javax.swing.JButton;

import bi.team.heroes.Hero;
import bi.team.heroes.attacks.Attack;

public class Whack extends Attack {
	
	public Whack(Hero hero) {
		super(hero, new JButton("Whack"));
	}
	
	@Override
	public void startAttack() {
		
	}
	
}
