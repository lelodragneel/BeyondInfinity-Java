package bi.team.heroes.attacks.barbarian;

import javax.swing.JButton;

import bi.team.Game;
import bi.team.heroes.Barbarian;

public class Whirling_torment extends Attack {
	
	// constructor
	public Whirling_torment(Barbarian hero, Game game) {
		super(hero, new JButton("Whirling Torment"));
		maxWarmup = 6;
		curWarmup = 6;
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
