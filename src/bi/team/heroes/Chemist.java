package bi.team.heroes;

import java.util.ArrayList;

import bi.team.Game;
import bi.team.enemies.Enemy;
import bi.team.heroes.attacks.barbarian.Attack;


public class Chemist extends Hero {

	public Chemist(Game game, int sex) {
		super(game);
		
		// instantiate variables
		AttacksArrayList = new ArrayList<Attack>();
		
		// TODO create this class's attacks
		
	}

	@Override
	public void enableStanceButtons() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disableStanceButtons() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnemyToFight(Enemy enemy) {
		// TODO Auto-generated method stub
		
	}
	
}
