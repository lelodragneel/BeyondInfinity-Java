package bi.team;

import java.awt.Insets;

import javax.swing.JButton;

public class Attack {

	// init variables
	private JButton button;
	private String name;        // Name of attack
	private int turnCoolDown;   // the amount of turns the attack needs before it can 
	private int coolDownTimer;  // the how many turns left untill attack can used again
	private double energyCost;	// How much energy the attack uses
	private double damage;      // How much Damage does the attack do
	private double heal;		// How much Healing does the attack do
	private int turnEvade;		// How many turns u are immune to damage


	// constructor
	public Attack(String name, double damage, double energyCost, int coolDown, double heal, int turnEvade) {
		makeButton();
		this.name = name;
		this.damage = damage;
		this.energyCost = energyCost;
		this.turnCoolDown = coolDown;
		this.heal = heal;
		this.turnEvade = turnEvade;
	}
	//temp
	public Attack(JButton thing){
		button = thing;
		this.name = "Generic Attack";
		this.damage = 10;
		this.energyCost = 1;
		this.turnCoolDown = 0;
		this.heal = 0;
		this.turnEvade = 0;
	}

	// makes button
	public void makeButton(){
		button = new JButton(name);
		button.setFocusable(false);
		button.setMargin(new Insets(0, 0, 0, 0));
		//button.add(new MyGraphics(this));
	}

	//checks if it can be used and uses it
	public boolean canBeUsed(){
		if(coolDownTimer > 0){
			coolDownTimer = turnCoolDown;
			return true;
		}
		return false; // attack is under cooldown
	}

	// return this button
	public JButton getButton() {
		return button;
	}

	/**
	// if this button has sufficient energy, activate then subtract energy
	public boolean isAvailable() {// return true if u can click the button

	}

	// return this attack's current energy
	public double getEnergy() {
		return ;
	}

	// add 5 energy (this method is called once per turn)
	public void regenerate() {
		if (energy <= 15)
			this.energy += 5;
	}

	// return this attack's regeneration rate
	public double getEnergyRegenRate() {
		return energyRegenRate;
	}
	 */

}
