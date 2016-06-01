package bi.team.heroes.attacks.brutalizer;

import javax.swing.JButton;

import bi.team.Game;
import bi.team.heroes.attacks.Attack;

public class Vengeance extends Attack {
	
	// constructor
	public Vengeance(Game game) {
		super(game, new JButton("Vengeance"));
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
