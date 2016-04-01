package bi.team;

public class Player {

	// initialize variables
	private double curHealth;
	private double maxHealth;
	private double maxEnergy;
	private double curEnergy;
	private double energyRecoverRate;
	private String name;

	// constructor
	Player(String name, double maxHealth, double maxEnergy, double energyRecoverRate) {
		this.setName(name);
		this.maxEnergy = maxEnergy;
		this.maxHealth = maxHealth;
		curHealth = maxHealth;
		this.energyRecoverRate = energyRecoverRate;

	}

	// return the curHhealth
	public double getCurHhealth() {
		return curHealth;
	}
	public void takeDamage(double dam){
		curHealth -= dam;
	}

	// set the curHhealth
	public void setCurHhealth(double curHhealth) {
		this.curHealth = curHhealth;
	}

	// return the maxHealth
	public double getMaxHealth() {
		return maxHealth;
	}

	// set the maxHealth
	public void setMaxHealth(double maxHealth) {
		this.maxHealth = maxHealth;
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

	// return the name
	public String getName() {
		return name;
	}

	// set the name
	public void setName(String name) {
		this.name = name;
	}

}
