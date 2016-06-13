package bi.team.heroes.attacks.barbarian;

import javax.swing.JButton;

import bi.team.Game;
import bi.team.heroes.Barbarian;

public class True_assault extends Attack {
	
	// constructor
	public True_assault(Barbarian hero, Game game) {
		super(hero, game, new JButton("True Assault"));
		maxWarmup = 6;
		curWarmup = 6;
		rageNeeded = 0;
		damage = 200;
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
