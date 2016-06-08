package bi.team.heroes.attacks.barbarian;

import javax.swing.JButton;

import bi.team.heroes.Barbarian;

public class Shield_bash extends Attack {
	
	// constructor
	public Shield_bash(Barbarian hero) {
		super(hero, new JButton("Shield Bash"));
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
