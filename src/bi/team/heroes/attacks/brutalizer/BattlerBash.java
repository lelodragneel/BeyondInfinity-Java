package bi.team.heroes.attacks.brutalizer;

import javax.swing.JButton;

import bi.team.Game;
import bi.team.heroes.attacks.Attack;

public class BattlerBash extends Attack {
	
	// constructor
	public BattlerBash(Game game) {
		super(game, new JButton("Battler Bash"));
		maxWarmup = 3;
		curWarmup = 3;
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
