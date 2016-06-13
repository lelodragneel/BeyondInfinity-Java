package bi.team.heroes.attacks.barbarian;

import java.awt.Color;
import java.awt.Insets;

import javax.swing.JButton;

import bi.team.Game;
import bi.team.Load;
import bi.team.MyGraphics;
import bi.team.heroes.Barbarian;

public abstract class Attack {

	/*
	 * initialize variables
	 */
	protected JButton button;
	protected String name;
	protected int rageNeeded;
	protected double damage;
	protected boolean isAvailable = true;
	protected double maxWarmup;
	protected double curWarmup;
	protected Game game;
	protected Barbarian hero;
	protected Load load;

	// constructor
	public Attack(Barbarian hero, Game game, JButton button) {
		
		// instantiate objects
		this.hero = hero;
		this.game = game;
		this.button = button;
		name = button.getText();
		button.setBackground(Color.WHITE);
		button.setFocusable(false);
		button.setMargin(new Insets(0, 0, 0, 0));
		button.add(new MyGraphics(this));
		
		// create custom tooltip
		
		
		//button.setToolTipText("<html><p width=\"100\"><img src=\"" + getClass().getResource("/images/energy.png") + "\"></p></html>");
		
	}
	
	// abstract required methods
	public abstract void startAttack();
	public abstract void activeEffects();
	public abstract void turnEffects();
	
	// return the maxWarmup
	public double getMaxWarmup() {
		return maxWarmup;
	}

	// set the maxWarmup
	public void setMaxWarmup(double maxWarmup) {
		this.maxWarmup = maxWarmup;
	}

	// return the curWarmup
	public double getCurWarmup() {
		return curWarmup;
	}

	// set the curWarmup
	public void setCurWarmup(double curWarmup) {
		this.curWarmup = curWarmup;
	}

	// return attack's name
	public String getName() {
		return name;
	}
	
	// return this button
	public JButton getButton() {
		return button;
	}

	// return the rageNeeded
	public int getRageNeeded() {
		return rageNeeded;
	}

	// return the damage
	public double getDamage() {
		return damage;
	}
}



