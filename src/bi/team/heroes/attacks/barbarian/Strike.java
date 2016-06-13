package bi.team.heroes.attacks.barbarian;

import javax.swing.JButton;

import bi.team.Game;
import bi.team.heroes.Barbarian;

public class Strike extends Attack {
	
	// constructor
	public Strike(Barbarian hero, Game game) {
		super(hero, game, new JButton("Strike"));	
		maxWarmup = 0;
		curWarmup = 0;
		rageNeeded = 0;
	}

	@Override
	public void startAttack() {
		hero.generateRage(1);
		game.getEnemySelected().setCurHealth(game.getEnemySelected().getCurHealth() - hero.getSharpness());
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
