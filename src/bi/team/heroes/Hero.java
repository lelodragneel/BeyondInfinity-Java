package bi.team.heroes;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import bi.team.Game;
import bi.team.heroes.attacks.Attack;

public abstract class Hero {

	// initialize variables
	protected double curHealth;
	protected double maxHealth;					// [90, infinity] any real number
	protected double protection;				// [0.01-1] damage multiplied by this number equals the damage avoided
	protected double criticalDamage;			// [0.2-2] damage multiplied by this number equals the extra damage dealt
	protected double criticalChance;			// [0-100] probability of dealing a criticalDamage. a number generator will guess a number between that range
	protected double curEnergy;					
	protected double maxEnergy;					// [5-?]
	protected double energyRecoveryRate;		// [1-?] the energy received at the end of each turn
	protected HashMap<Integer, Attack> hashAttacks;
	protected Game game;
	
	// constructor
	public Hero(Game game) {

		this.game = game;
	}

	
	
	/**
	 * @return the hashAttacks
	 */
	public Map<Integer, Attack> getHashAttacks() {
		return hashAttacks;
	}

	// return a new randomly generated number
	public int getRandomNumber() {	
		return new Random().nextInt((100 - 1) + 1) + 1;
	}
	
	// return true if player is alive
	public boolean isAlive() {
		return (curHealth > 0);
	}
	
	// return the current vitality (health)
	public double getCurVitality() {
		return curHealth;
	}

	// set the vitality (health)
	public void setCurVitality(double curVitality) {
		this.curHealth = curVitality;
	}

	// return the maximum vitality (health)
	public double getMaxVitality() {
		return maxHealth;
	}

	// set the maximum vitality (health)
	public void setMaxVitality(double maxVitality) {
		this.maxHealth = maxVitality;
	}

	// return the maxEnergy
	public double getMaxEnergy() {
		return maxEnergy;
	}

	// set the maxEnergy
	public void setMaxEnergy(double maxEnergy) {
		this.maxEnergy = maxEnergy;
	}

	// return the curEnergy
	public double getCurEnergy() {
		return curEnergy;
	}

	// set the curEnergy
	public void setCurEnergy(double curEnergy) {
		this.curEnergy = curEnergy;
	}

	// return the energyRecoverRate
	public double getEnergyRecoverRate() {
		return energyRecoveryRate;
	}

	// set the energyRecoverRate
	public void setEnergyRecoverRate(double energyRecoverRate) {
		this.energyRecoveryRate = energyRecoverRate;
	}

	// return the player protection (armor)
	public double getProtection() {
		return protection;
	}

	// set the player's protection (armor)
	public void setProtection(double protection) {
		this.protection = protection;
	}

	// return the criticalDamage
	public double getCriticalDamage() {
		return criticalDamage;
	}

	// set the criticalDamage
	public void setCriticalDamage(double criticalDamage) {
		this.criticalDamage = criticalDamage;
	}

	// return the criticalChance
	public double getCriticalChance() {
		return criticalChance;
	}

	// set the criticalChance
	public void setCriticalChance(double criticalChance) {
		this.criticalChance = criticalChance;
	}

}
