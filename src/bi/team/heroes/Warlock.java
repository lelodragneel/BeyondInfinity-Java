package bi.team.heroes;

import java.util.ArrayList;

import bi.team.Game;
import bi.team.heroes.attacks.Attack;


public class Warlock extends Hero {

	// constructor
	public Warlock(Game game) {
		
		super(game);
		
		// instantiate variables
		AttacksArrayList = new ArrayList<Attack>();
		
		// TODO create this class's attacks
	}

	@Override
	public void enableUpgradeButtons() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disableUpgradeButtons() {
		// TODO Auto-generated method stub
		
	}
	
}
