package bi.team.bosstype;

import javax.swing.border.Border;

public abstract class Boss {

	// initialize variables
	private String name;
	private double curVitality;
	private double maxVitality;
	private double damage;
	private double protection;
	private double criticalDamage;
	private double criticalChance;
	private double curEnergy;
	private double maxEnergy;
	private double energyRecoveryRate;
	private boolean alive;

	// constructor
	public Boss() {	
		
		alive = true;
		
	}
	
	public abstract Border getBorder();
	
	// boss takes damage
	public void takeDamage(double dam){
		curVitality -= dam;
	}

	// return boss's total health
	public double getTotalHealth() {
		return maxVitality;
	}

	// set boss's total health
	public void setTotalHealth(double health) {
		this.maxVitality = health;
	}

	// return boss's damage
	public double getDamage() {
		return damage;
	}

	// set boss's damage
	public void setDamage(double damage) {
		this.damage = damage;
	}

	// return boss's health
	public double getHealth() {
		return curVitality;
	}

	// return boss's health
	public void setHealth(double health) {
		this.curVitality = health;
	}
	// return the protection
	public double getProtection() {
		return protection;
	}
	// set the protection
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
	// return the curEnergy
	public double getCurEnergy() {
		return curEnergy;
	}
	// set the curEnergy
	public void setCurEnergy(double curEnergy) {
		this.curEnergy = curEnergy;
	}
	// return the maxEnergy
	public double getMaxEnergy() {
		return maxEnergy;
	}
	// set the maxEnergy
	public void setMaxEnergy(double maxEnergy) {
		this.maxEnergy = maxEnergy;
	}
	// return the energyRecoveryRate
	public double getEnergyRecoveryRate() {
		return energyRecoveryRate;
	}
	// set the energyRecoveryRate
	public void setEnergyRecoveryRate(double energyRecoveryRate) {
		this.energyRecoveryRate = energyRecoveryRate;
	}
	// return the alive
	public boolean isAlive() {
		return alive;
	}
	// set the alive
	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	

}
