package bi.team.heroes;

import java.util.HashMap;

import bi.team.Game;
import bi.team.heroes.attacks.Attack;
import bi.team.heroes.attacks.elementalist.*;

/*
 * Class abilities:
 * #1: Whack (basic attack)
 * #2: *elemental* Missile (powerful attack)
 * #3: Rejuvenate (healing ability)
 * #4: Missle Detonation (special attack)
 * #5: Arcane Blast (powerful ability)
 * #6: Bursting Flames (ultimate attack)
 * 
 * Passive: Freezing Pulse (freeze every 4 turns)
 * 
 * Default Upgradable Stats:
 * Health, Mana, Intellect, Absorption, Immobilize Chance
 */
public class Elementalist extends Hero {
	
	// constructor
	public Elementalist(Game game) {
		
		super(game);
		
		// default class values
		curHealth = 100;
		maxHealth = 100;
		
		// instantiate
		hashAttacks = new HashMap<Integer, Attack>();
		
		// create this class's attacks
		hashAttacks.put(1, new Whack(this));
		hashAttacks.put(2, new Missile(this));
		hashAttacks.put(3, new Rejuvenate(this));
		hashAttacks.put(4, new MissileDetonation(this));
		hashAttacks.put(5, new ArcaneBlast(this));
		hashAttacks.put(6, new BurstingFlames(this));
		
	}
	
	
	
}
