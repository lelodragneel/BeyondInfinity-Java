package bi.team.heroes;

import java.util.HashMap;

import bi.team.Game;
import bi.team.heroes.attacks.Attack;

/*
 * Class abilities:
 * #1: Shadow Bolt (basic attack)
 * #2: Harvest Life (life steal)
 * #3: Dark Infliction (powerful ability) 
 * #4: Terrorize (fear ability)
 * #5: Shadowy Flash (escape ability)
 * #6: Devastation (ultimate ability)
 * 
 * Passive: Demonic Companion (imp companion, shares damage)
 * 
 * Default Upgradable Stats:
 * Life, Mana, Spell Damage, Resistance, Imp
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
