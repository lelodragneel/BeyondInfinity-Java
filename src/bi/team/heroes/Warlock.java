package bi.team.heroes;

import java.util.HashMap;

import bi.team.Game;
import bi.team.heroes.attacks.Attack;

/*
 * Class abilities:
 * #1: Shadow Bolt (basic attack)
 * #2: Life Drain (special ability)
 * #3: Dark Infliction (powerful ability) 
 * #4: Hoaxing Clones (special ability)
 * #5: Shadowy Flash (special ability)
 * #6: Demonic Ritual (ultimate ability)
 * 
 * Default Upgradable Stats:
 * Life, Power,
 * Optional: 
 */
public class Warlock extends Hero {

	// constructor
	public Warlock(Game game) {
		
		super(game);
		
		// default class values
		curHealth = 100;
		maxHealth = 100;
		
		// instantiate
		hashAttacks = new HashMap<Integer, Attack>();
		
		// TODO create this class's attacks
	}
	
}
