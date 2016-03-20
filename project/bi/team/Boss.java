package bi.team;

public class Boss {

	// initialize variables
	private double health, totalhealth, damage, energy, totalenergy;

	// constructor
	public Boss(double totalhealth, double totaldamage, double energy) {

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

	// return boss's total energy
	public double getTotalEnergy() {
		return totalenergy;
	}

	// set boss's total energy
	public void setTotalEnergy(double energy) {
		this.totalenergy = energy;
	}

	// return boss's energy
	public double getEnergy() {
		return energy;
	}

	// set boss's energy
	public void setEnergy(double energy) {
		this.energy = energy;
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
