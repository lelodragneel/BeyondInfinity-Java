package bi.team.heroes;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import bi.team.Game;
import bi.team.enemies.Enemy;
import bi.team.heroes.attacks.barbarian.Attack;

public abstract class Hero {

	/*
	 * initialize variables
	 */
	protected ArrayList<Attack> AttacksArrayList;
	protected Game game;
	protected JButton btnUpgradeStat_1;
	protected JButton btnUpgradeStat_2;
	protected JButton btnUpgradeStat_3;
	protected JButton btnUpgradeStat_4;
	protected JButton btnUpgradeStat_5;
	protected JPanel panel_stances;
	protected ImageIcon heroImage;
	// initialize hero stats
	protected int turnsStunned;

	// constructor
	public Hero(Game game) {
		
		// instantiate variable
		this.game = game;
		
	}
	
	// reduce all attacks warmup by 1
	public void reduceWarmup() {
		for (Attack x: AttacksArrayList) {
			if (x.getCurWarmup() >= 0 && x.getCurWarmup() < x.getMaxWarmup()) {
				x.setCurWarmup(x.getCurWarmup() + 1);
			}
		}
	}
	
	// XXX attack the enemy
	public abstract void attackEnemy(Attack attack);
	
	// return the attacks arraylist
	public ArrayList<Attack> getAttacksArrayList() {
		return AttacksArrayList;
	}

	// set all upgrade buttons to active
	public abstract void enableButtons();

	// set all upgrade buttons to inactive
	public abstract void disableButtons();
	
	// start battle
	public void setEnemyToFight(Enemy enemy) {
	}
	
	// initialize the player icon
	public abstract void initializePlayerIcon();
	
	// return the vitality
	public abstract double getCurHealth();

	// set the vitality
	public abstract void setCurHealth(double curHealth);

	// return the maxVitality
	public abstract double getMaxHealth();

	// set the maxVitality
	public abstract void setMaxHealth(double maxHealth);
	
	// [barbarian override] get sharpness
	public double getSharpness(){
		return 0;	
	}
}
