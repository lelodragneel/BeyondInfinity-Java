package bi.team.heroes.attacks.elementalist;

import javax.swing.JButton;

import bi.team.heroes.Hero;
import bi.team.heroes.attacks.Attack;

public class Missile extends Attack {
	
	public Missile(Hero hero) {
		super(hero, new JButton("Missile"));
	}

	@Override
	public void startAttack() {
		// TODO Auto-generated method stub
		
	}
	
}
