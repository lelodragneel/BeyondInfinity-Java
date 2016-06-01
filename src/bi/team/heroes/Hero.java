package bi.team.heroes;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

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

	// constructor
	public Hero(Game game) {
		this.game = game;

	}

	protected JPanel panel1;
	protected JPanel panel2;
	protected JPanel panel3;
	protected JPanel panel4;
	protected JPanel panel5;
	
	// return the attacks arraylist
	public ArrayList<Attack> getAttacksArrayList() {
		return AttacksArrayList;
	}

	// set all upgrade buttons to active
	public void enableUpgradeButtons() {
		btnUpgradeStat_1.setEnabled(true);
		btnUpgradeStat_2.setEnabled(true);
		btnUpgradeStat_3.setEnabled(true);
		btnUpgradeStat_4.setEnabled(true);
		btnUpgradeStat_5.setEnabled(true);
	}
	
	// set all upgrade buttons to inactive
	public void disableUpgradeButtons() {
		btnUpgradeStat_1.setEnabled(false);
		btnUpgradeStat_2.setEnabled(false);
		btnUpgradeStat_3.setEnabled(false);
		btnUpgradeStat_4.setEnabled(false);
		btnUpgradeStat_5.setEnabled(false);
	}
}
