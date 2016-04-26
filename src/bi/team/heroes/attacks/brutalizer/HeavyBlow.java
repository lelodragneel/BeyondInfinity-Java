package bi.team.heroes.attacks.brutalizer;

import javax.swing.JButton;

import bi.team.heroes.Hero;
import bi.team.heroes.attacks.Attack;

public class HeavyBlow extends Attack {
	
	public HeavyBlow(Hero hero) {
		super(hero, new JButton("Heavy Blow"));
	}

	@Override
	public void startAttack() {
		// TODO Auto-generated method stub
		
	}
	
}
