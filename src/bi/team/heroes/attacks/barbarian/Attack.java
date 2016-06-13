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
	protected double damage;
	protected boolean isAvailable = true;
	protected double maxWarmup;
	protected double curWarmup;
	protected Game game;
	protected Barbarian hero;
	protected Load load;

	// constructor
	public Attack(Barbarian hero, JButton button) {
		this.hero = hero;
		this.button = button;
		name = button.getText();
		button.setBackground(Color.WHITE);
		button.setFocusable(false);
		button.setMargin(new Insets(0, 0, 0, 0));
		button.add(new MyGraphics(this));
		
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
	
}
