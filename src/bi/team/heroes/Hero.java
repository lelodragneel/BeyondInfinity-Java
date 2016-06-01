package bi.team.heroes;

import java.util.ArrayList;
import java.util.Random;

import bi.team.Game;
import bi.team.heroes.attacks.Attack;

public abstract class Hero {

	// initialize variables
	protected double curHealth;
	protected double maxHealth;
	protected ArrayList<Attack> AttacksArrayList;
	protected Game game;
	
	// constructor
	public Hero(Game game) {
		this.game = game;
		
	}
	
	// return the hashAttacks
	public ArrayList<Attack> getAttacksArrayList() {
		return AttacksArrayList;
	}

	// return a new randomly generated number
	public int getRandomNumber() {	
		return new Random().nextInt((100 - 1) + 1) + 1;
	}
	
	// return true if player is alive
	public boolean isAlive() {
		return (curHealth > 0);
	}
	
	// return the current health
	public double getCurHealth() {
		return curHealth;
	}

	// set the health
	public void setCurHealth(double curHealth) {
		this.curHealth = curHealth;
	}

	// return the maximum health
	public double getMaxHealth() {
		return maxHealth;
	}

	// set the maximum health
	public void setMaxHealth(double maxHealth) {
		this.maxHealth = maxHealth;
	}

}
