package bi.team.heroes.attacks.brutalizer;

import javax.swing.JButton;

import bi.team.Game;
import bi.team.heroes.attacks.Attack;

public class Incapacitate extends Attack {
	
	// constructor
	public Incapacitate(Game game) {
		super(game, new JButton("Incapacitate"));
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
