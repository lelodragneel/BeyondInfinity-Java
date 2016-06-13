package bi.team.heroes.attacks.barbarian;

import javax.swing.JButton;

import bi.team.Game;
import bi.team.heroes.Barbarian;

public class Incapacitate extends Attack {
	
	// constructor
	public Incapacitate(Barbarian hero, Game game) {
		super(hero, game, new JButton("Incapacitate"));
		maxWarmup = 4;
		curWarmup = 4;
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
