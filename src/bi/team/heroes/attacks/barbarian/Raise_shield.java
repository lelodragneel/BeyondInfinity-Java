package bi.team.heroes.attacks.barbarian;

import javax.swing.JButton;

import bi.team.Game;
import bi.team.heroes.Barbarian;

public class Raise_shield extends Attack {
	
	// constructor
	public Raise_shield(Barbarian hero, Game game) {
		super(hero, game, new JButton("Raise Shield"));
		maxWarmup = 5;
		curWarmup = 5;
		rageNeeded = 0;
	}

	@Override
	public void startAttack() {
		
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
