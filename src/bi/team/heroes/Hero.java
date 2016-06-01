package bi.team.heroes;

import java.util.ArrayList;

import bi.team.Game;
import bi.team.heroes.attacks.Attack;

public abstract class Hero {

	/*
	 * initialize variables
	 */
	protected ArrayList<Attack> AttacksArrayList;
	protected Game game;

	// constructor
	public Hero(Game game) {
		this.game = game;

	}

	// return the attacks arraylist
	public ArrayList<Attack> getAttacksArrayList() {
		return AttacksArrayList;
	}

}
