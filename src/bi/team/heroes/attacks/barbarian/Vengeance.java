package bi.team.heroes.attacks.barbarian;

import javax.swing.JButton;

import bi.team.heroes.Barbarian;

public class Vengeance extends Attack {
	
	// constructor
	public Vengeance(Barbarian hero) {
		super(hero, new JButton("Vengeance"));
		maxWarmup = 4;
		curWarmup = 4;
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
