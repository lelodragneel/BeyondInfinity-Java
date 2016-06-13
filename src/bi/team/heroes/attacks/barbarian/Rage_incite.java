package bi.team.heroes.attacks.barbarian;

import javax.swing.JButton;

import bi.team.Game;
import bi.team.heroes.Barbarian;

public class Rage_incite extends Attack {
	
	// constructor
	public Rage_incite(Barbarian hero, Game game) {
		super(hero, game, new JButton("Rage Incite"));
		maxWarmup = 3;
		curWarmup = 3;
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
