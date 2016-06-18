package bi.team.enemies;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import bi.team.Game;

@SuppressWarnings("serial")
public abstract class Enemy extends JButton implements MouseListener {

	// initialize variables
	protected Game game;
	protected String name;
	protected boolean alive;
	protected int enemyNumber;
	protected ImageIcon enemyImage_small;
	protected ImageIcon enemyImage;
	// initialize enemy stats
	protected double curHealth;
	protected double maxHealth;
	protected double damage;
	protected double protection;
	protected double experienceDrop;
	protected double criticalChance;
	private int valign;

	// constructor
	public Enemy(Game game, int valign) {
		
		// configure variables
		alive = true;
		this.game = game;
		this.valign = valign;
		
		// create a label and configured its settings
		this.setBackground(new Color(236, 236, 236));
		this.setOpaque(true);
		this.setVerticalAlignment(SwingConstants.BOTTOM);
		this.setHorizontalAlignment(SwingConstants.RIGHT);
		this.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		this.setFocusable(false);
		this.addMouseListener(this);
		
	}
	
	// XXX attack player
	public abstract void attackPlayer();
	
	// prepare gui for battle
	public abstract void prepareFight();
	
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
	}
	@Override
	public void mousePressed(MouseEvent e) {
		game.setEnemySelected(this);
		game.getMap().getLblEnemyIcon().setIcon(enemyImage_small);
		game.getMap().getLblEnemyName().setText("<html>" + name + "</html>");
		game.getMap().getBtnChallenge().setEnabled(true);
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}

	// return the valign
	public int getValign() {
		return valign;
	}

	// return the enemyImage_small
	public ImageIcon getEnemyImage_small() {
		return enemyImage_small;
	}

	// return the name
	public String getName() {
		return name;
	}

	// return the experienceDrop
	public double getExperienceDrop() {
		return experienceDrop;
	}

	// return the enemyNumber
	public int getEnemyNumber() {
		return enemyNumber;
	}

	// return the enemyImage
	public ImageIcon getEnemyImage() {
		return enemyImage;
	}

	// return the damage
	public double getDamage() {
		return damage;
	}

	// return the curHealth
	public double getCurHealth() {
		return curHealth;
	}

	// set the curHealth
	public void setCurHealth(double curHealth) {
		this.curHealth = curHealth;
	}

	// return the maxHealth
	public double getMaxHealth() {
		return maxHealth;
	}

	// set the maxHealth
	public void setMaxHealth(double maxHealth) {
		this.maxHealth = maxHealth;
	}
	
}
