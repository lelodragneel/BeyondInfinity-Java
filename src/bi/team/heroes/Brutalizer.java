package bi.team.heroes;

import java.util.HashMap;

import javax.swing.JButton;

import bi.team.Game;
import bi.team.heroes.attacks.Attack;
import bi.team.heroes.attacks.brutalizer.*;


public class Brutalizer extends Hero {
	
	/*
	 * initialize variables
	 */
	private JButton btnOffensive;
	private JButton btnDefensive;
	
	// constructor
	public Brutalizer(Game game) {
		
		super(game);
		
		// default class values
		curHealth = 100;
		maxHealth = 100;
		
		// instantiate
		hashAttacks = new HashMap<Integer, Attack>();
		
		// create this class's attacks
		hashAttacks.put(1, new Strike(this));
		hashAttacks.put(2, new HeavyBlow(this));
		hashAttacks.put(3, new RageIncite(this));
		hashAttacks.put(4, new Vengeance(this));
		hashAttacks.put(5, new BattlerBash(this));
		hashAttacks.put(6, new TrueAssault(this));
		hashAttacks.put(7, new Strike(this));
		hashAttacks.put(8, new Charge(this));
		hashAttacks.put(9, new RaiseShield(this));
		hashAttacks.put(10, new Incapacitate(this));
		hashAttacks.put(11, new ShieldBash(this));
		hashAttacks.put(12, new WhirlingTorment(this));
		
		/*
		 * create and initialize attack buttons
		 */
		for (java.util.Map.Entry<Integer, Attack> x : hashAttacks.entrySet()) {
			x.getValue().getButton().addActionListener(game);
			x.getValue().getButton().setEnabled(false);		
		}
		game.getPanel_actions().add(hashAttacks.get(1).getButton());
		game.getPanel_actions().add(hashAttacks.get(2).getButton());
		game.getPanel_actions().add(hashAttacks.get(3).getButton());
		game.getPanel_actions().add(hashAttacks.get(4).getButton());
		game.getPanel_actions().add(hashAttacks.get(5).getButton());
		game.getPanel_actions().add(hashAttacks.get(6).getButton());
		
		// create offensive stance
		btnOffensive = new JButton("");
		btnOffensive.setBounds(2, 0, 30, 30);
		btnOffensive.setFocusable(false);
		game.getPanel_actionsTop().add(btnOffensive);
		
		// create defensive stance
		btnDefensive = new JButton("");
		btnDefensive.setBounds(34, 0, 30, 30);
		btnDefensive.setFocusable(false);
		game.getPanel_actionsTop().add(btnDefensive);
		
	}
}
