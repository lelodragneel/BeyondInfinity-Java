package bi.team.heroes;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import bi.team.Game;
import bi.team.heroes.attacks.Attack;

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
	protected JButton btnUpgradeStat_6;
	protected JButton btnUpgradeStat_7;
	protected JButton btnUpgradeStat_8;
	protected JButton btnUpgradeStat_9;
	protected JButton btnUpgradeStat_10;
	protected JLabel lblUpgradePoints;
	protected JPanel panel_actionsTop;
	protected JPanel panel_stances;

	// constructor
	public Hero(Game game) {
		this.game = game;

		/*
		 * create top actions panel
		 */
		// create background painted panel for stance buttons
		
		panel_actionsTop = new JPanel();
		panel_actionsTop.setBounds(10, 462, 974, 30);
		panel_actionsTop.setLayout(null);
		game.getContentPane().add(panel_actionsTop);
		
		panel_stances = new JPanel();
		panel_stances.setBounds(0, 0, 72, 30);
		panel_stances.setBackground(new Color(135, 211, 124));
		panel_actionsTop.add(panel_stances);
		
		// create label for upgrade points
		JLabel labelUpgradePoints = new JLabel("Upgrade Points:");
		labelUpgradePoints.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		labelUpgradePoints.setHorizontalAlignment(SwingConstants.RIGHT);
		labelUpgradePoints.setBounds(443, 7, 94, 16);
		panel_actionsTop.add(labelUpgradePoints);
		
		// create label to display upgrade points
		lblUpgradePoints = new JLabel("0");
		lblUpgradePoints.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblUpgradePoints.setBounds(547, 7, 46, 16);
		panel_actionsTop.add(lblUpgradePoints);
		
		
	}

	
	// return the attacks arraylist
	public ArrayList<Attack> getAttacksArrayList() {
		return AttacksArrayList;
	}

	// set all upgrade buttons to active
	public abstract void enableUpgradeButtons();

	// set all upgrade buttons to inactive
	public abstract void disableUpgradeButtons();
}
