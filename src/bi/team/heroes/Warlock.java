package bi.team.heroes;

import java.util.ArrayList;

import bi.team.Game;
import bi.team.heroes.attacks.barbarian.Attack;


public class Warlock extends Hero {
	
	public Warlock(Game game, int sex) {
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
	
}
