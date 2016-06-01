package bi.team.heroes.attacks.brutalizer;

import javax.swing.JButton;

import bi.team.Game;
import bi.team.heroes.attacks.Attack;

public class WhirlingTorment extends Attack {
	
	// constructor
	public WhirlingTorment(Game game) {
		super(game, new JButton("Whirling Torment"));
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
