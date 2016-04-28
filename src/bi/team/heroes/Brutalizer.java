package bi.team.heroes;

import java.util.HashMap;

import bi.team.Game;
import bi.team.heroes.attacks.Attack;
import bi.team.heroes.attacks.brutalizer.*;

/*
 * Class abilities:
 * Stance: Offensive & Defensive
 * #1: Strike (basic attack)					Strike (basic attack)|
 * #2: Heavy Blow (powerful attack)|			Bane Blast (powerful attack)|
 * #3: Rage Incite (buff ability)|				Raise Shield (buff ability)
 * #4: Vengeance (special attack)|				Incapacitate (special attack)
 * #5: Battler Bash (stun ability)|				Shield Bash (special attack)
 * #6: True Assault (ultimate attack)|			Whirling Torment (ultimate attack)| 
 * 
 * Passive: 
 * 
 * Default Upgradable Stats:
 * Vitality, Energy, Sharpness, Toughness, Riposte
*/

public class Brutalizer extends Hero {
	
	// constructor
	public Brutalizer(Game game) {
		
		super(game);
		
		// default class values
		curHealth = 100;
		maxHealth = 100;
		
		// instantiate
		hashAttacks = new HashMap<Integer, Attack>();
		
		// create this class's attacks
		hashAttacks.put(1, new Strike(this));
		hashAttacks.put(2, new HeavyBlow(this));
		hashAttacks.put(3, new RageIncite(this));
		hashAttacks.put(4, new Vengeance(this));
		hashAttacks.put(5, new BattlerBash(this));
		hashAttacks.put(6, new TrueAssault(this));
	}
}
