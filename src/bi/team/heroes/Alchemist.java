package bi.team.heroes;

import java.util.ArrayList;

import bi.team.Game;
import bi.team.heroes.attacks.Attack;


public class Alchemist extends Hero {
	
	// constructor
	public Alchemist(Game game) {
		
		super(game);
		
		// instantiate variables
		curHealth = 100;
		maxHealth = 100;
		
		// instantiate
		AttacksArrayList = new ArrayList<Attack>();
		
		// TODO create this class's attacks
		
	}
	
}
