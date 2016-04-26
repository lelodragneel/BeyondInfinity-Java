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
 * #5: Fade (defensive ability)
 * #6: Bursting Flames (ultimate attack)
 * 
 * Default Upgradable Stats:
 * Health, Power,
 * Optional: 
 */
public class Elementalist extends Hero {
	
	public Elementalist(Game game) {
		super(game);
		
		/*
		 * instantate
		 */
		hashAttacks = new HashMap<Integer, Attack>();
		
		// create this class's attacks
		hashAttacks.put(1, new Whack(this));
		hashAttacks.put(2, new Missile(this));
		hashAttacks.put(3, new Rejuvenate(this));
		hashAttacks.put(4, new MissileDetonation(this));
		hashAttacks.put(5, new Fade(this));
		hashAttacks.put(6, new BurstingFlames(this));
		
	}
	
	
	
}
