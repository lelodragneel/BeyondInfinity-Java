package bi.team.heroes.attacks.barbarian;

import javax.swing.JButton;

import bi.team.heroes.Barbarian;

public class Charge extends Attack {

	// constructor
	public Charge(Barbarian hero) {
		super(hero, new JButton("Bane Blast"));
		maxWarmup = 2;
		curWarmup = 2;
	}

	@Override
	public void startAttack() {
		load.nextTurn(this);
		
	}

	@Override
	public void activeEffects() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void turnEffects() {
		// TODO Auto-generated method stub
		
	}
	
}
