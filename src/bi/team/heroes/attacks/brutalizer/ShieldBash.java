package bi.team.heroes.attacks.brutalizer;

import javax.swing.JButton;

import bi.team.Game;
import bi.team.heroes.attacks.Attack;

public class ShieldBash extends Attack {
	
	// constructor
	public ShieldBash(Game game) {
		super(game, new JButton("Shield Bash"));
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
