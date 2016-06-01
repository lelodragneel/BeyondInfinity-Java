package bi.team.heroes.attacks.brutalizer;

import javax.swing.JButton;

import bi.team.Game;
import bi.team.heroes.attacks.Attack;

public class RaiseShield extends Attack {
	
	// constructor
	public RaiseShield(Game game) {
		super(game, new JButton("Raise Shield"));
		maxWarmup = 4;
		curWarmup = 4;
	}

	@Override
	public void startAttack() {
		// TODO Auto-generated method stub
		
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
