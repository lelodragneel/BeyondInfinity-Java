package bi.team.heroes.attacks.barbarian;

import javax.swing.JButton;

import bi.team.heroes.Barbarian;

public class Rage_incite extends Attack {
	
	// constructor
	public Rage_incite(Barbarian hero) {
		super(hero, new JButton("Rage Incite"));
		maxWarmup = 3;
		curWarmup = 3;
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
