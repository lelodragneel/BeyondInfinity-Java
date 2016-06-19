package bi.team.enemies;

import java.awt.Color;
import java.awt.Cursor;
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
	private int valign;
	protected ImageIcon enemyImage_small;
	protected ImageIcon enemyImage;
	// initialize enemy stats
	protected double curHealth;
	protected double maxHealth;
	protected double damage;
	protected double protection;
	protected double experienceDrop;
	protected double criticalChance;

	// constructor
	public Enemy(Game game, int valign) {
		
		// configure variables
		alive = true;
		this.game = game;
		this.valign = valign;
		
		// create a label and configured its settings
		this.setBackground(new Color(46, 204, 113));
		this.setOpaque(true);
		this.setVerticalAlignment(SwingConstants.BOTTOM);
		this.setHorizontalAlignment(SwingConstants.RIGHT);
		this.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		this.setFocusable(false);
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.addMouseListener(this);
		
	}
	
	// XXX attack player
	public abstract void attackPlayer();
	
	// prepare gui for battle
	public abstract void prepareFight();
	
	// mouse listeners for hovering effects
	@Override
	public void mouseEntered(MouseEvent e) {
		if (alive) {
			this.setBackground(new Color(38, 166, 91));
		} else {
			this.setBackground(new Color(192, 57, 43));
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {
		if (alive) {
			this.setBackground(new Color(46, 204, 113));			
		} else {
			this.setBackground(new Color(239, 72, 54));
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	@Override
	public void mousePressed(MouseEvent e) {
		
		// set enemy name & image on map
		game.getMap().getLblEnemyIcon().setIcon(enemyImage_small);
		game.getMap().getLblEnemyName().setText("<html>" + name + "</html>");
		
		if (alive) {
			// set this as selected enemy
			game.setEnemySelected(this);
			// enable challenge button
			game.getMap().getBtnChallenge().setEnabled(true);
		} else {
			game.getMap().getBtnChallenge().setEnabled(false);
		}
		
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

	// return the alive
	public boolean isAlive() {
		return !(curHealth <= 0);
	}

	// set the alive
	public void setAlive(boolean alive) {
		this.alive = alive;
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
