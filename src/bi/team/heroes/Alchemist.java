package bi.team.heroes;

import java.util.HashMap;

import bi.team.Game;
import bi.team.heroes.attacks.Attack;

/*
 * Class abilities:
 * #1: Poisonous Dart (basic attack)
 * #2: Noxious Splash (powerful attack)
 * #3: Toxic Solvent (powerful attack)
 * #4: Illusive Mix (special attack)
 * #5: Diseased Corruption (special attack)
 * #6: Life Potion (ultimate ability)
 * 
 * Passive: Replenishment
 * 
 * Default Upgradable Stats:
 * Sanity, Energy, Lunacy, Invulnerability, Infliction
 */
public class Alchemist extends Hero {
	
	// constructor
	public Alchemist(Game game) {
		
		super(game);
		
		// default class values
		curHealth = 100;
		maxHealth = 100;
		
		// instantiate
		hashAttacks = new HashMap<Integer, Attack>();
		
		// TODO create this class's attacks
		
	}
	
}
