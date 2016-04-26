package bi.team.heroes.attacks;

import java.awt.Insets;

import javax.swing.JButton;

import bi.team.MyGraphics;
import bi.team.heroes.Hero;

public abstract class Attack {

	// init variables
	protected JButton button;
	private String name; // Name of attack
	protected Hero hero;
	protected boolean isAvailable = true;

	// constructor
	public Attack(Hero hero, JButton button) {
		
		this.hero = hero;
		this.button = button;	
		button.setFocusable(false);
		button.setMargin(new Insets(0, 0, 0, 0));
		button.add(new MyGraphics(this));
		
	}
	
	public abstract void startAttack();

	// for when you attack "You used <Name>"
	public String getName() {
		return name;
	}
	
	// return this button
	public JButton getButton() {
		return button;
	}

	/**
	 * @return the isAvailable
	 */
	public boolean isAvailable() {
		return isAvailable;
	}
	
}
