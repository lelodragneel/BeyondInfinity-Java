package bi.team.heroes.attacks.barbarian;

import javax.swing.JButton;

import bi.team.Game;
import bi.team.heroes.attacks.Attack;

public class Heavy_blow extends Attack {
	
	// constructor
	public Heavy_blow(Game game) {
		super(game, new JButton("Heavy Blow"));
		maxWarmup = 2;
		curWarmup = 2;
	}

	@Override
	public void startAttack() {
		Game.appendMessage("used HeavyBlow");
		
	}

	@Override
	public void activeEffects() {
		System.out.println("heavyblow active");
		
	}

	@Override
	public void turnEffects() {
		// TODO Auto-generated method stub
		
	}
	
}
