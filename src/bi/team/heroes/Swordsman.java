package bi.team.heroes;

import java.util.ArrayList;

import bi.team.Game;
import bi.team.heroes.attacks.barbarian.Attack;


public class Swordsman extends Hero {
	
	// constructor
	public Swordsman(Game game) {
		
		super(game);
		
		// instantiate variables
		AttacksArrayList = new ArrayList<Attack>();
		
		// TODO create this class's attacks
		
	}

	@Override
	public void enableButtons() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disableButtons() {
		// TODO Auto-generated method stub
		
	}
	
}
