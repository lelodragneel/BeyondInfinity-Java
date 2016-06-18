package bi.team.heroes;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

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
	
	// hero kills enemy
	public void killEnemy(Enemy enemy) {
		
		// set enemy to dead
		enemy.setAlive(false);
		
		// set red background to enemy's map entry
		enemy.setBackground(new Color(239, 72, 54));
		
		// set enemy's health bar to dead
		game.getBar_enemyHealth().setString("dead");
		
		// replace enemy icon to grave on battlefield
		game.getLblEnemyImage().setVerticalAlignment(SwingConstants.BOTTOM);
		game.getLblEnemyImage().setIcon(new ImageIcon(getClass().getResource("/images/grave.png")));
		
		
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
	
	// check if hero is alive/dead
	public abstract boolean isAlive();
	
	// surrender
	public abstract void surrender();
	
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
