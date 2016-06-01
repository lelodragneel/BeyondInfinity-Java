package bi.team.heroes;

import java.util.ArrayList;

import javax.swing.JButton;

import bi.team.Game;
import bi.team.heroes.attacks.Attack;
import bi.team.heroes.attacks.brutalizer.BattlerBash;
import bi.team.heroes.attacks.brutalizer.Charge;
import bi.team.heroes.attacks.brutalizer.HeavyBlow;
import bi.team.heroes.attacks.brutalizer.Incapacitate;
import bi.team.heroes.attacks.brutalizer.RageIncite;
import bi.team.heroes.attacks.brutalizer.RaiseShield;
import bi.team.heroes.attacks.brutalizer.ShieldBash;
import bi.team.heroes.attacks.brutalizer.Strike;
import bi.team.heroes.attacks.brutalizer.TrueAssault;
import bi.team.heroes.attacks.brutalizer.Vengeance;
import bi.team.heroes.attacks.brutalizer.WhirlingTorment;


public class Brutalizer extends Hero {
	
	/*
	 * initialize variables
	 */
	private JButton btnOffensive;
	private JButton btnDefensive;
	
	// constructor
	public Brutalizer(Game game) {
		
		super(game);
			
		// instantiate variables
		curHealth = 100;
		maxHealth = 100;
		
		// instantiate
		AttacksArrayList = new ArrayList<Attack>();
		
		// create this class's attacks
		AttacksArrayList.add(new Strike(this));
		AttacksArrayList.add(new HeavyBlow(this));
		AttacksArrayList.add(new RageIncite(this));
		AttacksArrayList.add(new Vengeance(this));
		AttacksArrayList.add(new BattlerBash(this));
		AttacksArrayList.add(new TrueAssault(this));
		AttacksArrayList.add(new Strike(this));
		AttacksArrayList.add(new Charge(this));
		AttacksArrayList.add(new RaiseShield(this));
		AttacksArrayList.add(new Incapacitate(this));
		AttacksArrayList.add(new ShieldBash(this));
		AttacksArrayList.add(new WhirlingTorment(this));
		
		/*
		 * create and initialize attack buttons
		 */
		for (Attack x : AttacksArrayList) {
			x.getButton().addActionListener(game);
			x.getButton().setEnabled(false);		
		}
		game.getPanel_actions().add(AttacksArrayList.get(1).getButton());
		game.getPanel_actions().add(AttacksArrayList.get(2).getButton());
		game.getPanel_actions().add(AttacksArrayList.get(3).getButton());
		game.getPanel_actions().add(AttacksArrayList.get(4).getButton());
		game.getPanel_actions().add(AttacksArrayList.get(5).getButton());
		game.getPanel_actions().add(AttacksArrayList.get(6).getButton());
		
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
