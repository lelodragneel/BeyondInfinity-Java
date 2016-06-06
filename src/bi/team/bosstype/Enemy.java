package bi.team.bosstype;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import bi.team.map.Map;

@SuppressWarnings("serial")
public abstract class Enemy extends JButton implements MouseListener {

	// initialize variables
	private String name;
	private double curVitality;
	private double maxVitality;
	private double damage;
	private double protection;
	private double criticalDamage;
	private double criticalChance;
	private double curEnergy;
	private double maxEnergy;
	private double energyRecoveryRate;
	private boolean alive;
	protected int enemyNumber;
	private Enemy enemy;
	private Map map;

	// constructor
	public Enemy(Map map, int enemyNumber) {
		
		alive = true;
	
		this.map = map;
		
		// create a label and configured its settings
		this.setText(enemyNumber + 1 + "");
		this.setBackground(new Color(236, 236, 236));
		this.setOpaque(true);
		this.setVerticalAlignment(SwingConstants.BOTTOM);
		this.setHorizontalAlignment(SwingConstants.RIGHT);
		this.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		this.setFocusable(false);
		this.addMouseListener(this);
		
	}
	
	// mouse listeners for hovering effects
	@Override
	public void mouseEntered(MouseEvent e) {
		this.setBackground(Color.LIGHT_GRAY);
	}
	@Override
	public void mouseExited(MouseEvent e) {
		this.setBackground(new Color(236, 236, 236));
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		map.showEnemyInfo(this);
	}
	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println(super.getText());
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}

	// return the enemy
	public Enemy getEnemy() {
		return enemy;
	}
	
	
	// boss takes damage
	public void takeDamage(double dam){
		curVitality -= dam;
	}

	// return boss's total health
	public double getTotalHealth() {
		return maxVitality;
	}

	// set boss's total health
	public void setTotalHealth(double health) {
		this.maxVitality = health;
	}

	// return boss's damage
	public double getDamage() {
		return damage;
	}

	// set boss's damage
	public void setDamage(double damage) {
		this.damage = damage;
	}

	// return boss's health
	public double getHealth() {
		return curVitality;
	}

	// return boss's health
	public void setHealth(double health) {
		this.curVitality = health;
	}
	// return the protection
	public double getProtection() {
		return protection;
	}
	// set the protection
	public void setProtection(double protection) {
		this.protection = protection;
	}
	// return the criticalDamage
	public double getCriticalDamage() {
		return criticalDamage;
	}
	// set the criticalDamage
	public void setCriticalDamage(double criticalDamage) {
		this.criticalDamage = criticalDamage;
	}
	// return the criticalChance
	public double getCriticalChance() {
		return criticalChance;
	}
	// set the criticalChance
	public void setCriticalChance(double criticalChance) {
		this.criticalChance = criticalChance;
	}
	// return the curEnergy
	public double getCurEnergy() {
		return curEnergy;
	}
	// set the curEnergy
	public void setCurEnergy(double curEnergy) {
		this.curEnergy = curEnergy;
	}
	// return the maxEnergy
	public double getMaxEnergy() {
		return maxEnergy;
	}
	// set the maxEnergy
	public void setMaxEnergy(double maxEnergy) {
		this.maxEnergy = maxEnergy;
	}
	// return the energyRecoveryRate
	public double getEnergyRecoveryRate() {
		return energyRecoveryRate;
	}
	// set the energyRecoveryRate
	public void setEnergyRecoveryRate(double energyRecoveryRate) {
		this.energyRecoveryRate = energyRecoveryRate;
	}
	// return the alive
	public boolean isAlive() {
		return alive;
	}
	// set the alive
	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	

}
