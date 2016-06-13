package bi.team.heroes.attacks.barbarian;

import javax.swing.JButton;

import bi.team.Game;
import bi.team.heroes.Barbarian;

public class Charge extends Attack {

	// constructor
	public Charge(Barbarian hero, Game game) {
		super(hero, game, new JButton("Bane Blast"));
		maxWarmup = 3;
		curWarmup = 3;
		rageNeeded = 0;
		damage = 10;
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
