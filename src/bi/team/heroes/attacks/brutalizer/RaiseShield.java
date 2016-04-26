package bi.team.heroes.attacks.brutalizer;

import javax.swing.JButton;

import bi.team.heroes.Hero;
import bi.team.heroes.attacks.Attack;

public class RaiseShield extends Attack {
	
	public RaiseShield(Hero hero) {
		super(hero, new JButton("Raise Shield"));
	}

	@Override
	public void startAttack() {
		// TODO Auto-generated method stub
		
	}
	
}
