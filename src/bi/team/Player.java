package bi.team;

public class Player {
	
	private double curHhealth, maxHealth, maxEnergy, curEnergy, energyRecoverRate;
	private String name;
	Player(String name, double maxHealth, double maxEnergy, double energyRecoverRate){
		this.name = name;
		this.maxEnergy = maxEnergy;
		this.maxHealth = maxHealth;
		this.energyRecoverRate = energyRecoverRate;
		
	}

	public String getName() {
		return name;
	}

	public double getCurHhealth() {
		return curHhealth;
	}

	public void setCurHhealth(double curHhealth) {
		this.curHhealth = curHhealth;
	}

	public double getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(double maxHealth) {
		this.maxHealth = maxHealth;
	}

	public double getMaxEnergy() {
		return maxEnergy;
	}

	public void setMaxEnergy(double maxEnergy) {
		this.maxEnergy = maxEnergy;
	}

	public double getCurEnergy() {
		return curEnergy;
	}

	public void setCurEnergy(double curEnergy) {
		this.curEnergy = curEnergy;
	}

	public double getEnergyRecoverRate() {
		return energyRecoverRate;
	}

	public void setEnergyRecoverRate(double energyRecoverRate) {
		this.energyRecoverRate = energyRecoverRate;
	}
}
