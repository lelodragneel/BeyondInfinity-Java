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
	private Game game;
	protected String name;
	protected boolean alive;
	protected int enemyNumber;
	protected ImageIcon enemyImage_small;
	// initialize enemy stats
	protected double curVitality;
	protected double maxVitality;
	protected double damage;
	protected double protection;
	protected double criticalChance;

	// constructor
	public Enemy(Game game) {
		
		// configure variables
		alive = true;
		this.game = game;
		
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
	public void attackPlayer() {
		curVitality -= damage;
		game.getBar_playerHealth().setValue((int)( curVitality - damage));
		game.getBar_playerHealth().setString(game.getBar_playerHealth().getValue() + " / " + game.getBar_playerHealth().getMaximum());
	}
	
	// prepare gui for battle
	public void prepareFight() {
		game.getBar_enemyHealth().setMaximum((int) maxVitality);
		game.getBar_enemyHealth().setValue((int) maxVitality);
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
	
	// return the name
	public String getName() {
		return name;
	}

	// return the enemyNumber
	public int getEnemyNumber() {
		return enemyNumber;
	}

	// return the enemyImage
	public ImageIcon getEnemyImage() {
		return enemyImage_small;
	}
	
}