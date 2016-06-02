package bi.team.heroes.attacks.barbarian;

import javax.swing.JButton;

import bi.team.Game;
import bi.team.heroes.attacks.Attack;

public class Strike extends Attack {
	
	// constructor
	public Strike(Game game) {
		super(game, new JButton("Strike"));	
		maxWarmup = 1;
		curWarmup = 1;
	}

	@Override
	public void startAttack() {
		Game.appendMessage("used Strike");
		
	}

	@Override
	public void activeEffects() {
		System.out.println("strike active");
		
	}

	@Override
	public void turnEffects() {
		// TODO Auto-generated method stub
		
	}
	
}
