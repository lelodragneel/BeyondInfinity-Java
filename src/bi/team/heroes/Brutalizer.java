package bi.team.heroes;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

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
	private JLabel lblVitality;
	private JLabel lblEnergy;
	private JLabel lblProtection;
	private JLabel lblCritDamage;
	private JLabel lblCritChance;
	private JLabel lblProtectionDesc;

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

		/* ------------- vitality (health) stat subpanel ------------- */
		// create subpanel (of panel_stats) for vitality
		JPanel subpanel_vitality = new JPanel();
		subpanel_vitality.setBorder(new TitledBorder(null, "Vitality", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		subpanel_vitality.setLayout(null);

		// create vitality icon
		JLabel lblHealhIcon = new JLabel("");
		lblHealhIcon.setBounds(5, 16, 24, 24);
		lblHealhIcon.setIcon(new ImageIcon(getClass().getResource("/images/heart.png")));
		subpanel_vitality.add(lblHealhIcon);

		// create vitality upgrade button
		btnUpgradeStat_1 = new JButton("+");
		btnUpgradeStat_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpgradeStat_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnUpgradeStat_1.setFocusable(false);
		btnUpgradeStat_1.setBounds(156, 12, 28, 28);
		btnUpgradeStat_1.setVisible(false);
		subpanel_vitality.add(btnUpgradeStat_1);
		
		// create the label that displays the maximum vitality value
		lblVitality = new JLabel();
		lblVitality.setBounds(39, 16, 91, 24);
		subpanel_vitality.add(lblVitality);
		
		// create vitality description label
		JLabel lblVitalityDesc = new JLabel("<html>Your maximum amount of health.</html>");
		lblVitalityDesc.setVerticalAlignment(SwingConstants.TOP);
		lblVitalityDesc.setForeground(Color.DARK_GRAY);
		lblVitalityDesc.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblVitalityDesc.setBounds(10, 42, 154, 36);
		subpanel_vitality.add(lblVitalityDesc);

		/* ------------- damage stat subpanel ------------- */
		// create subpanel (of panel_stats) for damage
		JPanel subpanel_energy = new JPanel();
		subpanel_energy.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Energy", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		subpanel_energy.setLayout(null);

		// create damage icon
		JLabel lblEnergyIcon = new JLabel("");
		lblEnergyIcon.setBounds(5, 16, 24, 24);
		lblEnergyIcon.setIcon(new ImageIcon(Game.class.getResource("/images/energy.png")));
		subpanel_energy.add(lblEnergyIcon);

		// create damage upgrade button
		btnUpgradeStat_2 = new JButton("+");
		btnUpgradeStat_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpgradeStat_2.setFocusable(false);
		btnUpgradeStat_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnUpgradeStat_2.setBounds(156, 11, 28, 28);
		btnUpgradeStat_2.setVisible(false);
		subpanel_energy.add(btnUpgradeStat_2);
		
		// create the label that displays damage value
		lblEnergy = new JLabel(""); // TODO
		lblEnergy.setBounds(39, 16, 91, 24);
		subpanel_energy.add(lblEnergy);
		
		// create damage description label
		JLabel lblEnergyDesc = new JLabel("<html>The amount of energy you regain every turn.</html>");
		lblEnergyDesc.setVerticalAlignment(SwingConstants.TOP);
		lblEnergyDesc.setForeground(Color.DARK_GRAY);
		lblEnergyDesc.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblEnergyDesc.setBounds(10, 42, 154, 36);
		subpanel_energy.add(lblEnergyDesc);

		/* ------------- protection (armor) stat subpanel ------------- */
		// create subpanel (of panel_stats) for protection
		JPanel subpanel_protection = new JPanel();
		subpanel_protection.setBorder(new TitledBorder(null, "Protection", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		subpanel_protection.setLayout(null);

		// create protection icon
		JLabel lblProtectionIcon = new JLabel("");
		lblProtectionIcon.setBounds(5, 16, 24, 24);
		lblProtectionIcon.setIcon(new ImageIcon(getClass().getResource("/images/armor.png")));
		subpanel_protection.add(lblProtectionIcon);

		// create protection upgrade button
		btnUpgradeStat_3 = new JButton("+");
		btnUpgradeStat_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpgradeStat_3.setFocusable(false);
		btnUpgradeStat_3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnUpgradeStat_3.setBounds(156, 11, 28, 28);
		btnUpgradeStat_3.setVisible(false);
		subpanel_protection.add(btnUpgradeStat_3);
		
		// create the label that displays protection value
		lblProtection = new JLabel(""); // TODO
		lblProtection.setBounds(39, 16, 91, 24);
		subpanel_protection.add(lblProtection);
		
		// create protection description label
		lblProtectionDesc = new JLabel("<html>Percentage of the damage deflected.</html>");
		lblProtectionDesc.setVerticalAlignment(SwingConstants.TOP);
		lblProtectionDesc.setForeground(Color.DARK_GRAY);
		lblProtectionDesc.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblProtectionDesc.setBounds(10, 42, 154, 36);
		subpanel_protection.add(lblProtectionDesc);

		/* ------------- critical damage stat subpanel ------------- */
		// create subpanel (of panel_stats) for critical damage
		JPanel subpanel_critdamage = new JPanel();
		subpanel_critdamage.setBorder(
				new TitledBorder(null, "Critical Damage", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		subpanel_critdamage.setLayout(null);

		// create critical damage icon
		JLabel lblCritDamageIcon = new JLabel("");
		lblCritDamageIcon.setBounds(5, 16, 24, 24);
		lblCritDamageIcon.setIcon(new ImageIcon(getClass().getResource("/images/criticaldamage.png")));
		subpanel_critdamage.add(lblCritDamageIcon);

		// create critical damage upgrade button
		btnUpgradeStat_4 = new JButton("+");
		btnUpgradeStat_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpgradeStat_4.setFocusable(false);
		btnUpgradeStat_4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnUpgradeStat_4.setBounds(156, 11, 28, 28);
		btnUpgradeStat_4.setVisible(false);
		subpanel_critdamage.add(btnUpgradeStat_4);
		
		// create the label that displays critical damage value
		lblCritDamage = new JLabel(""); // TODO
		lblCritDamage.setBounds(39, 16, 91, 24);
		subpanel_critdamage.add(lblCritDamage);
		
		// create critical damage description label
		JLabel lblCritDamageDesc = new JLabel("<html>Percentage of the extra damage dealt by critical hits.</html>");
		lblCritDamageDesc.setVerticalAlignment(SwingConstants.TOP);
		lblCritDamageDesc.setForeground(Color.DARK_GRAY);
		lblCritDamageDesc.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblCritDamageDesc.setBounds(10, 42, 154, 36);
		subpanel_critdamage.add(lblCritDamageDesc);

		/* ------------- critical chance stat subpanel ------------- */
		// create subpanel (of panel_stats) for critical chance
		JPanel subpanel_critchance = new JPanel();
		subpanel_critchance.setBorder(
				new TitledBorder(null, "Critical Chance", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		subpanel_critchance.setLayout(null);

		// create critical chance icon
		JLabel lblCritChanceIcon = new JLabel("");
		lblCritChanceIcon.setBounds(5, 16, 24, 24);
		lblCritChanceIcon.setIcon(new ImageIcon(getClass().getResource("/images/criticalchance.png")));
		subpanel_critchance.add(lblCritChanceIcon);

		// create critical chance upgrade button
		btnUpgradeStat_5 = new JButton("+");
		btnUpgradeStat_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpgradeStat_5.setFocusable(false);
		btnUpgradeStat_5.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnUpgradeStat_5.setBounds(156, 12, 28, 28);
		btnUpgradeStat_5.setVisible(false);
		subpanel_critchance.add(btnUpgradeStat_5);
		
		// create the label that displays critical chance value
		lblCritChance = new JLabel(""); // TODO
		lblCritChance.setBounds(39, 16, 91, 24);
		subpanel_critchance.add(lblCritChance);
		
		// create critical chance description label
		JLabel lblCritChanceDesc = new JLabel("<html>Chances of landing a critical hit.</html>");
		lblCritChanceDesc.setVerticalAlignment(SwingConstants.TOP);
		lblCritChanceDesc.setForeground(Color.DARK_GRAY);
		lblCritChanceDesc.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblCritChanceDesc.setBounds(10, 42, 154, 36);
		subpanel_critchance.add(lblCritChanceDesc);
		
		// show the 5 upgradable stats
		game.addUpgradableStats(subpanel_vitality, subpanel_energy, subpanel_protection, subpanel_critdamage, subpanel_critchance);
		
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
