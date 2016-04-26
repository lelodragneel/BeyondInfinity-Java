package bi.team.heroes.attacks;

import java.awt.Insets;

import javax.swing.JButton;

import bi.team.MyGraphics;
import bi.team.heroes.Hero;

public abstract class Attack {

	// init variables
	protected JButton button;
	private String name; // Name of attack
	private int turnCooldown; // the amount of turns the attack needs before it can be used again
	private double cooldownTimer; // the how many turns left until attack can used again. 0 for no cooldown
	private double energyCost; // How much energy the attack uses
	private double damage; // How much Damage does the attack do
	private double heal; // How much Healing does the attack do
	private int turnsToEvade; // How many turns you are immune to damage
	protected Hero hero;
	private boolean isAvailable = true;

	// constructor
	public Attack(Hero hero, JButton button) {
		this.hero = hero;
		this.button = button;
		
		button.setFocusable(false);
		button.setMargin(new Insets(0, 0, 0, 0));
		button.add(new MyGraphics(this));
	}
	
	public abstract void startAttack();

	// checks if it can be used and uses it
	public boolean useAttack() {
		if (cooldownTimer <= 0) {
			cooldownTimer = turnCooldown;
			return true;
		}
		// attack is under cooldown
		return false;
	}

	// 'i' is how much to reduce by
	public void reduceCooldown(double i) {
		cooldownTimer -= i;
		// out of bounds checking
		if (cooldownTimer < 0)
			cooldownTimer = 0;
	}

	// for when you attack "You used <Name>"
	public String getName() {
		return name;
	}

	// For when You try to use an attack thats on cooldown "You have to wait
	// <cooldownTimer> turns before u can do that"
	public double getCooldownTimer() {
		return cooldownTimer;
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
	public int getTurnsToEvade() {
		return turnsToEvade;
	}

	// return the turnCooldown
	public int getTurnCooldown() {
		return turnCooldown;
	}
	
	// return this button
	public JButton getButton() {
		return button;
	}

	/**
	 * @return the isAvailable
	 */
	public boolean isAvailable() {
		return isAvailable;
	}
	
}
