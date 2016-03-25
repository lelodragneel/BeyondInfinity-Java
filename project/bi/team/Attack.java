package bi.team;

import javax.swing.JButton;

public class Attack {

	// init variables
	private JButton button;
	private double energyRegenRate;
	private double energy = 20;

	// constructor
	public Attack(JButton button) {
		this.button = button;
	}

	// if this button has sufficient energy, activate then subtract energy
	public boolean activate() {
		if (energy == 20) {
			energy = 0;
			return true;
		} else
			return false;
	}

	// return this attack's current energy
	public double getEnergy() {
		return energy;
	}

	// add 5 energy (this method is called once per turn)
	public void regenerate() {
		if (energy <= 15)
			this.energy += 5;
	}

	// return this button
	public JButton getButton() {
		return button;
	}

	// return this attack's regeneration rate
	public double getEnergyRegenRate() {
		return energyRegenRate;
	}


}
