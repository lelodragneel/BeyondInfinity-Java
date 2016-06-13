package bi.team.heroes.attacks.barbarian;

import javax.swing.JButton;

import bi.team.Game;
import bi.team.heroes.Barbarian;

public class Shield_bash extends Attack {
	
	// constructor
	public Shield_bash(Barbarian hero, Game game) {
		super(hero, game, new JButton("Shield Bash"));
		maxWarmup = 5;
		curWarmup = 5;
		rageNeeded = 0;
		damage = 100;
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
