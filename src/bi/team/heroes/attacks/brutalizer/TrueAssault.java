package bi.team.heroes.attacks.brutalizer;

import javax.swing.JButton;

import bi.team.Game;
import bi.team.heroes.attacks.Attack;

public class TrueAssault extends Attack {
	
	// constructor
	public TrueAssault(Game game) {
		super(game, new JButton("True Assault"));
		maxWarmup = 5;
		curWarmup = 5;
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
