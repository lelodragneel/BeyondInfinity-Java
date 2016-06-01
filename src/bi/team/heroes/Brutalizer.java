package bi.team.heroes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import bi.team.Game;
import bi.team.Load;
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


public class Brutalizer extends Hero implements ActionListener {

	/*
	 * initialize variables
	 */
	private Load load;
	private JButton btnOffensive;
	private JButton btnDefensive;
	private double curVitality;
	private double maxVitality;
	private double curRage;
	private double maxRage;
	private double sharpness;
	private double riposteChance;

	// constructor
	public Brutalizer(Game game) {

		super(game);

		// instantiate variables
		load = new Load(game);
		curVitality = 100;
		maxVitality = 100;
		AttacksArrayList = new ArrayList<Attack>();

		// create this class's attacks
		AttacksArrayList.add(new Strike(game));
		AttacksArrayList.add(new HeavyBlow(game));
		AttacksArrayList.add(new RageIncite(game));
		AttacksArrayList.add(new Vengeance(game));
		AttacksArrayList.add(new BattlerBash(game));
		AttacksArrayList.add(new TrueAssault(game));
		AttacksArrayList.add(new Strike(game));
		AttacksArrayList.add(new Charge(game));
		AttacksArrayList.add(new RaiseShield(game));
		AttacksArrayList.add(new Incapacitate(game));
		AttacksArrayList.add(new ShieldBash(game));
		AttacksArrayList.add(new WhirlingTorment(game));

		/*
		 * create and initialize attack buttons
		 */
		for (Attack x : AttacksArrayList) {
			x.getButton().addActionListener(this);
			x.getButton().setEnabled(false);		
		}

		// create offensive stance
		btnOffensive = new JButton("");
		btnOffensive.setBounds(2, 0, 30, 30);
		btnOffensive.setFocusable(false);
		btnOffensive.addActionListener(this);
		game.getPanel_actionsTop().add(btnOffensive);

		// create defensive stance
		btnDefensive = new JButton("");
		btnDefensive.setBounds(34, 0, 30, 30);
		btnDefensive.setFocusable(false);
		btnDefensive.addActionListener(this);
		game.getPanel_actionsTop().add(btnDefensive);

		// display default attacks
		showOffensiveAttacks();

	}

	/*
	 * XXX ActionListener
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnOffensive) {
			showOffensiveAttacks();
		} else if (e.getSource() == btnDefensive) {
			showDefensiveAttacks();
		}

		// check if attacks are clicked
		for (Attack x : AttacksArrayList) {		
			if (e.getSource() == x.getButton())

				// check if ability is on cooldown
				if (x.getCurWarmup() == 1) {
					load.nextTurn(x);
				} else {
					Game.appendMessage(x.getName() + " is not ready!");
				}

		}

	}

	// show offensive attacks and remove defensive attacks
	public void showOffensiveAttacks() {

		// remove buttons
		game.getPanel_actions().removeAll();

		// add new buttons
		for (int i = 0; i < 6; i++) {
			game.getPanel_actions().add(AttacksArrayList.get(i).getButton());
		}

		// toggle stance buttons
		btnOffensive.setEnabled(false);
		btnDefensive.setEnabled(true);

		// repaint GUI
		game.repaint();
		game.revalidate();
	}

	// show defensive attacks and remove offensive attacks
	public void showDefensiveAttacks() {

		// remove buttons
		game.getPanel_actions().removeAll();

		// add new buttons
		for (int i = 6; i < 12; i++) {
			game.getPanel_actions().add(AttacksArrayList.get(i).getButton());
		}

		// toggle stance buttons
		btnOffensive.setEnabled(true);
		btnDefensive.setEnabled(false);

		// repaint GUI
		game.repaint();
		game.revalidate();
	}

	// return the curRage
	public double getCurRage() {
		return curRage;
	}

	// set the curRage
	public void setCurRage(double curRage) {
		this.curRage = curRage;
	}

	// return the maxRage
	public double getMaxRage() {
		return maxRage;
	}

	// set the maxRage
	public void setMaxRage(double maxRage) {
		this.maxRage = maxRage;
	}

	// return the vitality
	public double getCurVitality() {
		return curVitality;
	}

	// set the vitality
	public void setCurVitality(double vitality) {
		this.curVitality = vitality;
	}

	// return the maxVitality
	public double getMaxVitality() {
		return maxVitality;
	}

	// set the maxVitality
	public void setMaxVitality(double maxVitality) {
		this.maxVitality = maxVitality;
	}

	// return the rage
	public double getRage() {
		return curRage;
	}

	// set the rage
	public void setRage(double rage) {
		this.curRage = rage;
	}

	// return the sharpness
	public double getSharpness() {
		return sharpness;
	}

	// set the sharpness
	public void setSharpness(double sharpness) {
		this.sharpness = sharpness;
	}

	// return the riposteChance
	public double getRiposteChance() {
		return riposteChance;
	}

	// set the riposteChance
	public void setRiposteChance(double riposteChance) {
		this.riposteChance = riposteChance;
	}

}
