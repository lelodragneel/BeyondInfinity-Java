package bi.team.heroes.attacks.brutalizer;

import javax.swing.JButton;

import bi.team.heroes.Hero;
import bi.team.heroes.attacks.Attack;

public class Incapacitate extends Attack {
	
	public Incapacitate(Hero hero) {
		super(hero, new JButton("Incapacitate"));
	}

	@Override
	public void startAttack() {
		// TODO Auto-generated method stub
		
	}
	
}
