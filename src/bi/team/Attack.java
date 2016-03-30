package bi.team;

import java.awt.Insets;

import javax.swing.JButton;

public class Attack {

	// init variables
	private JButton button;
	private String name; // Name of attack
	private int turnCoolDown; // the amount of turns the attack needs before it can be used again
	private int coolDownTimer; // the how many turns left until attack can used again
	private double energyCost; // How much energy the attack uses
	private double damage; // How much Damage does the attack do
	private double heal; // How much Healing does the attack do
	private int turnEvade; // How many turns you are immune to damage

	// constructor
	public Attack(String name, double damage, double energyCost, int coolDown, double heal, int turnEvade) {
		this.name = name;
		this.damage = damage;
		this.energyCost = energyCost;
		this.turnCoolDown = coolDown;
		this.heal = heal;
		this.turnEvade = turnEvade;

		// create a button and configure it
		button = new JButton(name);
		button.setFocusable(false);
		button.setMargin(new Insets(0, 0, 0, 0));
		//button.add(new MyGraphics(this));
	}

	// checks if it can be used and uses it
	public boolean useAttack() {
		if (coolDownTimer > 0) {
			coolDownTimer = turnCoolDown;
			return true;
		}
		return false; // attack is under cooldown
	}
	// for when you attack "You used <Name>"
	public String getName() {
		return name;
	}
	// For when You try to use an attack thats on cooldown "You have to wait <CoolDownTimer> turns before u can do that"
	public int getCoolDownTimer() {
		return coolDownTimer;
	}
	// To Subtract from Players Energy Pool
	public double getEnergyCost() {
		return energyCost;
	}
	// How much damage you did/subtract from bosses health
	public double getDamage() {
		return damage;
	}
	// How much you heal yourself
	public double getHeal() {
		return heal;
	}
	// Are u still immune to damage
	public int getTurnEvade() {
		return turnEvade;
	}

	// return this button
	public JButton getButton() {
		return button;
	}
}
