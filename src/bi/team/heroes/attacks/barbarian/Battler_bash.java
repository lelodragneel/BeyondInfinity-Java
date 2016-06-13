package bi.team.heroes.attacks.barbarian;

import javax.swing.JButton;

import bi.team.Game;
import bi.team.heroes.Barbarian;

public class Battler_bash extends Attack {
	
	// constructor
	public Battler_bash(Barbarian hero, Game game) {
		super(hero, new JButton("Battler Bash"));
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
