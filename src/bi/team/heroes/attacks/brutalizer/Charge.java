package bi.team.heroes.attacks.brutalizer;

import javax.swing.JButton;

import bi.team.heroes.Hero;
import bi.team.heroes.attacks.Attack;

public class Charge extends Attack {

	public Charge(Hero hero) {
		super(hero, new JButton("Bane Blast"));
	}

	@Override
	public void startAttack() {
		// TODO Auto-generated method stub
		
	}
	
}
