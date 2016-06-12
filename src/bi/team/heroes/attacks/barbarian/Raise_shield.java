package bi.team.heroes.attacks.barbarian;

import javax.swing.JButton;

import bi.team.heroes.Barbarian;

public class Raise_shield extends Attack {
	
	// constructor
	public Raise_shield(Barbarian hero) {
		super(hero, new JButton("Raise Shield"));
		maxWarmup = 5;
		curWarmup = 5;
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
