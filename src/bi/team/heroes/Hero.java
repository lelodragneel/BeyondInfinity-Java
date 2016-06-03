package bi.team.heroes;

import java.util.ArrayList;

import javax.swing.JButton;

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

	// constructor
	public Hero(Game game) {
		this.game = game;

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
