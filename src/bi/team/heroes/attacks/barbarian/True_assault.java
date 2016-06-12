package bi.team.heroes.attacks.barbarian;

import javax.swing.JButton;

import bi.team.heroes.Barbarian;

public class True_assault extends Attack {
	
	// constructor
	public True_assault(Barbarian hero) {
		super(hero, new JButton("True Assault"));
		maxWarmup = 6;
		curWarmup = 6;
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
