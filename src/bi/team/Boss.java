package bi.team;

public class Boss {

	// initialize variables
	private double health, totalhealth, damage, energy, energyregeneration;

	// constructor
	public Boss(double totalhealth, double damage, double energy, double energyregeneration) {
		this.totalhealth = totalhealth;
		this.damage = damage;
		this.energy = energy;
		health = totalhealth;
		this.energyregeneration = energyregeneration;
	}
	public void takeDamage(double dam){
		health -= dam;
	}

	// return boss's total health
	public double getTotalHealth() {
		return totalhealth;
	}

	// set boss's total health
	public void setTotalHealth(double health) {
		this.totalhealth = health;
	}

	// return boss's damage
	public double getDamage() {
		return damage;
	}

	// set boss's damage
	public void setDamage(double damage) {
		this.damage = damage;
	}

	// set boss's energy
	public void setEnergy(double energy) {
		this.energy = energy;
	}

	// return boss's energy
	public double getEnergy() {
		return energy;
	}

	// set boss's energy regeneration
	public void setEnergyRegeneration(double energyregeneration) {
		this.energyregeneration = energyregeneration;
	}
	
	// return boss's energy regeneration
	public double getEnergyRegeneration() {
		return energyregeneration;
	}

	// return boss's health
	public double getHealth() {
		return health;
	}

	// return boss's health
	public void setHealth(double health) {
		this.health = health;
	}

}
