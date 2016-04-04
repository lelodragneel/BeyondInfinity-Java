package bi.team;

import java.util.Random;

public class Player {

	// initialize variables
	private double curVitality;
	private double maxVitality;				// [90, infinity] any real number
	private double protection;				// [0.01-1] damage multiplied by this number equals the damage avoided
	private double criticalDamage;			// [0.2-2] damage multiplied by this number equals the extra damage dealt
	private double criticalChance;			// [0-100] probability of dealing a criticalDamage. a number generator will guess a number between that range
	private double curEnergy;					
	private double maxEnergy;				// [5-?]
	private double energyRecoverRate;		// [1-?] the energy received at the end of each turn

	// constructor
	Player() {
		maxVitality = 90;
		curVitality = 90;
		criticalDamage = 0.2;
		criticalChance = 10;
		protection = 0.01;
		maxEnergy = 5;
		curEnergy = 5;
		energyRecoverRate = 1;
	}

	// return a new randomly generated number
	public int getRandomNumber() {	
		return new Random().nextInt((100 - 1) + 1) + 1;
	}
	
	// return the current vitality (health)
	public double getCurVitality() {
		return curVitality;
	}

	// set the vitality (health)
	public void setCurVitality(double curVitality) {
		this.curVitality = curVitality;
	}

	// return the maximum vitality (health)
	public double getMaxVitality() {
		return maxVitality;
	}

	// set the maximum vitality (health)
	public void setMaxVitality(double maxVitality) {
		this.maxVitality = maxVitality;
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
		return energyRecoverRate;
	}

	// set the energyRecoverRate
	public void setEnergyRecoverRate(double energyRecoverRate) {
		this.energyRecoverRate = energyRecoverRate;
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
