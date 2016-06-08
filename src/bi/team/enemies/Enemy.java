package bi.team.enemies;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import bi.team.map.Map;

@SuppressWarnings("serial")
public abstract class Enemy extends JButton implements MouseListener {

	// initialize variables
	protected String name;
	protected int enemyNumber;
	protected ImageIcon enemyImage_small;
	protected double curVitality;
	protected double maxVitality;
	protected double damage;
	protected double protection;
	protected double criticalChance;
	protected double curEnergy;
	protected double maxEnergy;
	protected double energyRecoveryRate;
	protected boolean alive;
	private Map map;

	// constructor
	public Enemy(Map map) {
		
		// configure variables
		alive = true;
		this.map = map;
		
		// create a label and configured its settings
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
		System.out.println(name);
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
