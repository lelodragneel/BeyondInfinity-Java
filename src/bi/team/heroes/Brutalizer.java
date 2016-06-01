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
	private JLabel lblRage;
	private JLabel lblSharpness;
	private JLabel lblToughness;
	private JLabel lblRiposteChance;
	private JLabel lblSharpnessDesc;

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

		/* ------------- vitality stat panel ------------- */
		// create panel (of panel_stats) for vitality
		JPanel panel_vitality = new JPanel();
		panel_vitality.setBorder(new TitledBorder(null, "Vitality", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_vitality.setLayout(null);

		// create vitality icon
		JLabel lblHealhIcon = new JLabel("");
		lblHealhIcon.setBounds(5, 16, 24, 24);
		lblHealhIcon.setIcon(new ImageIcon(getClass().getResource("/images/vitality.png")));
		panel_vitality.add(lblHealhIcon);

		// create vitality upgrade button
		btnUpgradeStat_1 = new JButton("+");
		btnUpgradeStat_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpgradeStat_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnUpgradeStat_1.setFocusable(false);
		btnUpgradeStat_1.setBounds(156, 12, 28, 28);
		btnUpgradeStat_1.setVisible(false);
		panel_vitality.add(btnUpgradeStat_1);
		
		// create the label that displays the maximum vitality value
		lblVitality = new JLabel();
		lblVitality.setBounds(39, 16, 91, 24);
		panel_vitality.add(lblVitality);
		
		// create vitality description label
		JLabel lblVitalityDesc = new JLabel("<html>Your maximum health.</html>");
		lblVitalityDesc.setVerticalAlignment(SwingConstants.TOP);
		lblVitalityDesc.setForeground(Color.DARK_GRAY);
		lblVitalityDesc.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblVitalityDesc.setBounds(10, 42, 154, 36);
		panel_vitality.add(lblVitalityDesc);

		/* ------------- rage stat panel ------------- */
		// create panel (of panel_stats) for rage
		JPanel panel_rage = new JPanel();
		panel_rage.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Rage", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_rage.setLayout(null);

		// create rage icon
		JLabel lblRageIcon = new JLabel("");
		lblRageIcon.setBounds(5, 16, 24, 24);
		lblRageIcon.setIcon(new ImageIcon(Game.class.getResource("/images/rage.png")));
		panel_rage.add(lblRageIcon);

		// create damage upgrade button
		btnUpgradeStat_2 = new JButton("+");
		btnUpgradeStat_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpgradeStat_2.setFocusable(false);
		btnUpgradeStat_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnUpgradeStat_2.setBounds(156, 11, 28, 28);
		btnUpgradeStat_2.setVisible(false);
		panel_rage.add(btnUpgradeStat_2);
		
		// create the label that displays damage value
		lblRage = new JLabel(""); // TODO
		lblRage.setBounds(39, 16, 91, 24);
		panel_rage.add(lblRage);
		
		// create damage description label
		JLabel lblRageDesc = new JLabel("<html>FILLER DESCRIPTION.</html>");
		lblRageDesc.setVerticalAlignment(SwingConstants.TOP);
		lblRageDesc.setForeground(Color.DARK_GRAY);
		lblRageDesc.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblRageDesc.setBounds(10, 42, 154, 36);
		panel_rage.add(lblRageDesc);

		/* ------------- sharpness stat panel ------------- */
		// create panel (of panel_stats) for protection
		JPanel panel_sharpness = new JPanel();
		panel_sharpness.setBorder(new TitledBorder(null, "Sharpness", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_sharpness.setLayout(null);

		// create protection icon
		JLabel lblSharpnessIcon = new JLabel("");
		lblSharpnessIcon.setBounds(5, 16, 24, 24);
		lblSharpnessIcon.setIcon(new ImageIcon(getClass().getResource("/images/sharpness.png")));
		panel_sharpness.add(lblSharpnessIcon);

		// create sharpness upgrade button
		btnUpgradeStat_3 = new JButton("+");
		btnUpgradeStat_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpgradeStat_3.setFocusable(false);
		btnUpgradeStat_3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnUpgradeStat_3.setBounds(156, 11, 28, 28);
		btnUpgradeStat_3.setVisible(false);
		panel_sharpness.add(btnUpgradeStat_3);
		
		// create the label that displays protection value
		lblSharpness = new JLabel(""); // TODO
		lblSharpness.setBounds(39, 16, 91, 24);
		panel_sharpness.add(lblSharpness);
		
		// create protection description label
		lblSharpnessDesc = new JLabel("<html>FILLER DESCRIPTION.</html>");
		lblSharpnessDesc.setVerticalAlignment(SwingConstants.TOP);
		lblSharpnessDesc.setForeground(Color.DARK_GRAY);
		lblSharpnessDesc.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblSharpnessDesc.setBounds(10, 42, 154, 36);
		panel_sharpness.add(lblSharpnessDesc);

		/* ------------- toughness stat panel ------------- */
		// create panel (of panel_stats) for critical damage
		JPanel panel_toughness = new JPanel();
		panel_toughness.setBorder(
				new TitledBorder(null, "Toughness", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_toughness.setLayout(null);

		// create critical damage icon
		JLabel lblToughnessIcon = new JLabel("");
		lblToughnessIcon.setBounds(5, 16, 24, 24);
		lblToughnessIcon.setIcon(new ImageIcon(getClass().getResource("/images/toughness.png")));
		panel_toughness.add(lblToughnessIcon);

		// create critical damage upgrade button
		btnUpgradeStat_4 = new JButton("+");
		btnUpgradeStat_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpgradeStat_4.setFocusable(false);
		btnUpgradeStat_4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnUpgradeStat_4.setBounds(156, 11, 28, 28);
		btnUpgradeStat_4.setVisible(false);
		panel_toughness.add(btnUpgradeStat_4);
		
		// create the label that displays critical damage value
		lblToughness = new JLabel(""); // TODO
		lblToughness.setBounds(39, 16, 91, 24);
		panel_toughness.add(lblToughness);
		
		// create critical damage description label
		JLabel lblToughnessDesc = new JLabel("<html>FILLER DESCRIPTION.</html>");
		lblToughnessDesc.setVerticalAlignment(SwingConstants.TOP);
		lblToughnessDesc.setForeground(Color.DARK_GRAY);
		lblToughnessDesc.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblToughnessDesc.setBounds(10, 42, 154, 36);
		panel_toughness.add(lblToughnessDesc);

		/* ------------- riposte chance stat panel ------------- */
		// create panel (of panel_stats) for critical chance
		JPanel panel_riposteChance = new JPanel();
		panel_riposteChance.setBorder(
				new TitledBorder(null, "Riposte Chance", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_riposteChance.setLayout(null);

		// create critical chance icon
		JLabel lblRiposteChanceIcon = new JLabel("");
		lblRiposteChanceIcon.setBounds(5, 16, 24, 24);
		lblRiposteChanceIcon.setIcon(new ImageIcon(getClass().getResource("/images/ripostechance.png")));
		panel_riposteChance.add(lblRiposteChanceIcon);

		// create critical chance upgrade button
		btnUpgradeStat_5 = new JButton("+");
		btnUpgradeStat_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpgradeStat_5.setFocusable(false);
		btnUpgradeStat_5.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnUpgradeStat_5.setBounds(156, 12, 28, 28);
		btnUpgradeStat_5.setVisible(false);
		panel_riposteChance.add(btnUpgradeStat_5);
		
		// create the label that displays critical chance value
		lblRiposteChance = new JLabel(""); // TODO
		lblRiposteChance.setBounds(39, 16, 91, 24);
		panel_riposteChance.add(lblRiposteChance);
		
		// create critical chance description label
		JLabel lblRiposteChanceDesc = new JLabel("<html>FILLER DESCRIPTION.</html>");
		lblRiposteChanceDesc.setVerticalAlignment(SwingConstants.TOP);
		lblRiposteChanceDesc.setForeground(Color.DARK_GRAY);
		lblRiposteChanceDesc.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblRiposteChanceDesc.setBounds(10, 42, 154, 36);
		panel_riposteChance.add(lblRiposteChanceDesc);
		
		/* --------------------------------------------------------- */
		
		// display the 5 upgradable stats
		game.addUpgradableStats(panel_vitality, panel_rage, panel_sharpness, panel_toughness, panel_riposteChance);
		
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
