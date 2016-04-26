package bi.team.heroes;

import java.util.HashMap;

import bi.team.Game;
import bi.team.heroes.attacks.Attack;

/*
 * Class abilities:
 * #1: Blow (basic attack)
 * #2: Plunge (powerful attack)
 * #3: Leap (special attack)
 * #4: Edged Strike (powerful attack)
 * #5: Inscribe Blade (buff ability)
 * #6: Abolishment (ultimate ability)
 * 
 * Default Upgradable Stats:
 * Vitality, Dexterity,
 * Optional: 
 */
public class Berserker extends Hero {
	
	// constructor
	public Berserker(Game game) {
		
		super(game);
		
		// default class values
		curHealth = 100;
		maxHealth = 100;
		
		// instantiate
		hashAttacks = new HashMap<Integer, Attack>();
		
		// TODO create this class's attacks
		
	}
	
}
