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
import bi.team.enemies.Enemy;
import bi.team.heroes.attacks.barbarian.Attack;
import bi.team.heroes.attacks.barbarian.Battler_bash;
import bi.team.heroes.attacks.barbarian.Charge;
import bi.team.heroes.attacks.barbarian.Heavy_blow;
import bi.team.heroes.attacks.barbarian.Incapacitate;
import bi.team.heroes.attacks.barbarian.Rage_incite;
import bi.team.heroes.attacks.barbarian.Raise_shield;
import bi.team.heroes.attacks.barbarian.Shield_bash;
import bi.team.heroes.attacks.barbarian.Strike;
import bi.team.heroes.attacks.barbarian.True_assault;
import bi.team.heroes.attacks.barbarian.Vengeance;
import bi.team.heroes.attacks.barbarian.Whirling_torment;


public class Barbarian extends Hero implements ActionListener {

	/*
	 * initialize variables
	 */
	private Load load;
	private JLabel lblVitality;
	private JLabel lblRage;
	private JLabel lblSharpness;
	private JLabel lblToughness;
	private JLabel lblRiposteChance;
	private JLabel lblRage_1;
	private JLabel lblRage_2;
	private JLabel lblRage_3;
	private JLabel lblRage_5;
	private JLabel lblRage_6;
	private JLabel lblRage_7;
	private JLabel lblRage_4;
	private JLabel lblRage_8;
	private JButton btnOffensive;
	private JButton btnDefensive;
	private ArrayList<JLabel> rageIcons;
	// initialize hero stats
	private double curVitality;
	private double maxVitality;
	private int curRage;
	private int maxRage;
	private double sharpness;
	private double toughness;
	private double riposteChance;

	// constructor
	public Barbarian(Game game) {
		super(game);

		// instantiate variables
		load = new Load(game, this);
		AttacksArrayList = new ArrayList<Attack>();
		maxVitality = 100;
		curVitality = 100;
		maxRage = 8;
		curRage = 0;
		sharpness = 1;
		toughness = 5;
		riposteChance = 10;

		// configure player GUI
		game.getBar_playerHealth().setMinimum(0);
		game.getBar_playerHealth().setMaximum((int) maxVitality);
		game.getBar_playerHealth().setValue((int) curVitality);
		game.getBar_playerHealth().setString(game.getBar_playerHealth().getValue() + " / " + game.getBar_playerHealth().getMaximum());
		
		// create this class's attacks
		AttacksArrayList.add(new Strike(this, game));
		AttacksArrayList.add(new Heavy_blow(this, game));
		AttacksArrayList.add(new Rage_incite(this, game));
		AttacksArrayList.add(new Vengeance(this, game));
		AttacksArrayList.add(new Battler_bash(this, game));
		AttacksArrayList.add(new True_assault(this, game));
		AttacksArrayList.add(new Strike(this, game));
		AttacksArrayList.add(new Charge(this, game));
		AttacksArrayList.add(new Raise_shield(this, game));
		AttacksArrayList.add(new Incapacitate(this, game));
		AttacksArrayList.add(new Shield_bash(this, game));
		AttacksArrayList.add(new Whirling_torment(this, game));

		/*
		 * create and initialize attack buttons
		 */
		for (Attack x : AttacksArrayList) {
			x.getButton().addActionListener(this);
			x.getButton().setEnabled(false);
		}
		
		/*
		 * create two stance buttons & panel
		 */
		// create panel with green background for stance buttons
		panel_stances = new JPanel();
		panel_stances.setBounds(0, 0, 68, 34);
		panel_stances.setBackground(new Color(135, 211, 124));
		panel_stances.setLayout(null);
		game.getPanel_actionsTop().add(panel_stances);
		
		// create offensive stance
		btnOffensive = new JButton("");
		btnOffensive.setBounds(4, 4, 26, 26);
		btnOffensive.setFocusable(false);
		btnOffensive.addActionListener(this);
		panel_stances.add(btnOffensive);

		// create defensive stance
		btnDefensive = new JButton("");
		btnDefensive.setBounds(36, 4, 26, 26);
		btnDefensive.setFocusable(false);
		btnDefensive.addActionListener(this);
		panel_stances.add(btnDefensive);
		
		
		/* ------------- vitality stat panel ------------- */
		// create panel (of panel_stats) for vitality
		JPanel panel_vitality = new JPanel();
		panel_vitality.setBorder(new TitledBorder(null, "Vitality", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_vitality.setLayout(null);

		// create vitality icon
		JLabel lblHealhIcon = new JLabel("");
		lblHealhIcon.setBounds(10, 16, 24, 24);
		lblHealhIcon.setIcon(new ImageIcon(getClass().getResource("/images/vitality.png")));
		panel_vitality.add(lblHealhIcon);

		// create vitality upgrade button
		btnUpgradeStat_1 = new JButton("+");
		btnUpgradeStat_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpgradeStat_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnUpgradeStat_1.setFocusable(false);
		btnUpgradeStat_1.setBounds(170, 16, 28, 28);
		btnUpgradeStat_1.setVisible(false);
		panel_vitality.add(btnUpgradeStat_1);
		
		// create the label that displays the maximum vitality value
		lblVitality = new JLabel(curVitality + "/" + maxVitality);
		lblVitality.setBounds(44, 16, 116, 24);
		panel_vitality.add(lblVitality);
		
		// create vitality description label
		JLabel lblVitalityDesc = new JLabel("<html>Your maximum health.</html>");
		lblVitalityDesc.setVerticalAlignment(SwingConstants.TOP);
		lblVitalityDesc.setForeground(Color.DARK_GRAY);
		lblVitalityDesc.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblVitalityDesc.setBounds(10, 51, 188, 27);
		panel_vitality.add(lblVitalityDesc);

		/* ------------- rage stat panel ------------- */
		// create panel (of panel_stats) for rage
		JPanel panel_rage = new JPanel();
		panel_rage.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Rage", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_rage.setLayout(null);

		// create rage icon
		JLabel lblRageIcon = new JLabel("");
		lblRageIcon.setBounds(10, 16, 24, 24);
		lblRageIcon.setIcon(new ImageIcon(getClass().getResource("/images/rage.png")));
		panel_rage.add(lblRageIcon);

		// create rage upgrade button
		btnUpgradeStat_2 = new JButton("+");
		btnUpgradeStat_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpgradeStat_2.setFocusable(false);
		btnUpgradeStat_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnUpgradeStat_2.setBounds(170, 16, 28, 28);
		btnUpgradeStat_2.setVisible(false);
		panel_rage.add(btnUpgradeStat_2);
		
		// create the label that displays rage value
		lblRage = new JLabel(curRage + "/" + maxRage);
		lblRage.setBounds(44, 16, 116, 24);
		panel_rage.add(lblRage);
		
		// create rage description label
		JLabel lblRageDesc = new JLabel("<html>FILLER DESCRIPTION.</html>");
		lblRageDesc.setVerticalAlignment(SwingConstants.TOP);
		lblRageDesc.setForeground(Color.DARK_GRAY);
		lblRageDesc.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblRageDesc.setBounds(10, 51, 188, 27);
		panel_rage.add(lblRageDesc);

		/* ------------- sharpness stat panel ------------- */
		// create panel (of panel_stats) for sharpness
		JPanel panel_sharpness = new JPanel();
		panel_sharpness.setBorder(new TitledBorder(null, "Sharpness", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_sharpness.setLayout(null);

		// create sharpness icon
		JLabel lblSharpnessIcon = new JLabel("");
		lblSharpnessIcon.setBounds(10, 16, 24, 24);
		lblSharpnessIcon.setIcon(new ImageIcon(getClass().getResource("/images/sharpness.png")));
		panel_sharpness.add(lblSharpnessIcon);

		// create sharpness upgrade button
		btnUpgradeStat_3 = new JButton("+");
		btnUpgradeStat_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpgradeStat_3.setFocusable(false);
		btnUpgradeStat_3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnUpgradeStat_3.setBounds(170, 16, 28, 28);
		btnUpgradeStat_3.setVisible(false);
		panel_sharpness.add(btnUpgradeStat_3);
		
		// create the label that displays sharpness value
		lblSharpness = new JLabel(sharpness + "");
		lblSharpness.setBounds(44, 16, 116, 24);
		panel_sharpness.add(lblSharpness);
		
		// create sharpness description label
		JLabel lblSharpnessDesc = new JLabel("<html>FILLER DESCRIPTION.</html>");
		lblSharpnessDesc.setVerticalAlignment(SwingConstants.TOP);
		lblSharpnessDesc.setForeground(Color.DARK_GRAY);
		lblSharpnessDesc.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblSharpnessDesc.setBounds(10, 51, 188, 27);
		panel_sharpness.add(lblSharpnessDesc);

		/* ------------- toughness stat panel ------------- */
		// create panel (of panel_stats) for critical damage
		JPanel panel_toughness = new JPanel();
		panel_toughness.setBorder(
				new TitledBorder(null, "Toughness", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_toughness.setLayout(null);

		// create toughness icon
		JLabel lblToughnessIcon = new JLabel("");
		lblToughnessIcon.setBounds(10, 16, 24, 24);
		lblToughnessIcon.setIcon(new ImageIcon(getClass().getResource("/images/toughness.png")));
		panel_toughness.add(lblToughnessIcon);

		// create toughness upgrade button
		btnUpgradeStat_4 = new JButton("+");
		btnUpgradeStat_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpgradeStat_4.setFocusable(false);
		btnUpgradeStat_4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnUpgradeStat_4.setBounds(170, 16, 28, 28);
		btnUpgradeStat_4.setVisible(false);
		panel_toughness.add(btnUpgradeStat_4);
		
		// create the label that displays toughness value
		lblToughness = new JLabel(toughness + "");
		lblToughness.setBounds(44, 16, 116, 24);
		panel_toughness.add(lblToughness);
		
		// create toughness description label
		JLabel lblToughnessDesc = new JLabel("<html>FILLER DESCRIPTION.</html>");
		lblToughnessDesc.setVerticalAlignment(SwingConstants.TOP);
		lblToughnessDesc.setForeground(Color.DARK_GRAY);
		lblToughnessDesc.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblToughnessDesc.setBounds(10, 51, 188, 27);
		panel_toughness.add(lblToughnessDesc);

		/* ------------- riposte chance stat panel ------------- */
		// create panel (of panel_stats) for riposte chance
		JPanel panel_riposteChance = new JPanel();
		panel_riposteChance.setBorder(
				new TitledBorder(null, "Riposte Chance", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_riposteChance.setLayout(null);

		// create riposte chance icon
		JLabel lblRiposteChanceIcon = new JLabel("");
		lblRiposteChanceIcon.setBounds(10, 16, 24, 24);
		lblRiposteChanceIcon.setIcon(new ImageIcon(getClass().getResource("/images/ripostechance.png")));
		panel_riposteChance.add(lblRiposteChanceIcon);

		// create riposte chance upgrade button
		btnUpgradeStat_5 = new JButton("+");
		btnUpgradeStat_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpgradeStat_5.setFocusable(false);
		btnUpgradeStat_5.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnUpgradeStat_5.setBounds(170, 16, 28, 28);
		btnUpgradeStat_5.setVisible(false);
		panel_riposteChance.add(btnUpgradeStat_5);
		
		// create the label that displays riposte chance value
		lblRiposteChance = new JLabel(riposteChance + "%");
		lblRiposteChance.setBounds(44, 16, 116, 24);
		panel_riposteChance.add(lblRiposteChance);
		
		// create riposte chance description label
		JLabel lblRiposteChanceDesc = new JLabel("<html>FILLER DESCRIPTION.</html>");
		lblRiposteChanceDesc.setVerticalAlignment(SwingConstants.TOP);
		lblRiposteChanceDesc.setForeground(Color.DARK_GRAY);
		lblRiposteChanceDesc.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblRiposteChanceDesc.setBounds(10, 51, 188, 27);
		panel_riposteChance.add(lblRiposteChanceDesc);
		
		/*
		 * create barbarian's rage bar
		 */		
		lblRage = new JLabel("Rage");
		lblRage.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblRage.setHorizontalAlignment(SwingConstants.CENTER);
		lblRage.setBounds(4, 38, 30, 20);
		game.getPanel_player().add(lblRage);
		
		lblRage_1 = new JLabel("");
		lblRage_1.setBounds(42, 38, 20, 20);
		game.getPanel_player().add(lblRage_1);
		
		lblRage_2 = new JLabel("");
		lblRage_2.setBounds(64, 38, 20, 20);
		game.getPanel_player().add(lblRage_2);
		
		lblRage_3 = new JLabel("");
		lblRage_3.setBounds(86, 38, 20, 20);
		game.getPanel_player().add(lblRage_3);
		
		lblRage_4 = new JLabel("");
		lblRage_4.setBounds(108, 38, 20, 20);
		game.getPanel_player().add(lblRage_4);
		
		lblRage_5 = new JLabel("");
		lblRage_5.setBounds(130, 38, 20, 20);
		game.getPanel_player().add(lblRage_5);
		
		lblRage_6 = new JLabel("");
		lblRage_6.setBounds(152, 38, 20, 20);
		game.getPanel_player().add(lblRage_6);
		
		lblRage_7 = new JLabel("");
		lblRage_7.setBounds(174, 38, 20, 20);
		game.getPanel_player().add(lblRage_7);
		
		lblRage_8 = new JLabel("");
		lblRage_8.setBounds(196, 38, 20, 20);
		game.getPanel_player().add(lblRage_8);
		
		// add all rage icons into an arraylist
		rageIcons = new ArrayList<JLabel>();
		rageIcons.add(lblRage_1);
		rageIcons.add(lblRage_2);
		rageIcons.add(lblRage_3);
		rageIcons.add(lblRage_4);
		rageIcons.add(lblRage_5);
		rageIcons.add(lblRage_6);
		rageIcons.add(lblRage_7);
		rageIcons.add(lblRage_8);
		
		// paint rage bar
		repaintRage();
		
		/* --------------------------------------------------------- */
		
		// add the 5 upgradable stats to game's frame
		game.getPanel_stats().add(panel_vitality);
		game.getPanel_stats().add(panel_rage);
		game.getPanel_stats().add(panel_sharpness);
		game.getPanel_stats().add(panel_toughness);
		game.getPanel_stats().add(panel_riposteChance);
		
		// display default attacks by default
		showOffensiveAttacks();
		
	}

	/*
	 * XXX ActionListener
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		// stance buttons
		if (e.getSource() == btnOffensive) {
			showOffensiveAttacks();
		} else if (e.getSource() == btnDefensive) {
			showDefensiveAttacks();
		}

		// check if attacks are clicked
		for (Attack x : AttacksArrayList) {
			if (e.getSource() == x.getButton()) {
				// check if ability is on cooldown
				if (x.getCurWarmup() == x.getMaxWarmup()) {
					// check if there's sufficient rage to execute
					if (haveEnoughRage(x.getRageNeeded())) {
						reduceWarmup();
						x.setCurWarmup(0);
						load.nextTurn(x);				
					} else {
						Game.appendMessage("Insufficient rage!");
					}
				} else {
					Game.appendMessage(x.getName() + " is not ready!");
				}
			}
		}

	}
	
	/*
	 * XXX attack the enemy
	 */
	public void attackEnemy(Attack attack) {
		
		// initiate the selected attack
		attack.startAttack();
		
		// paint enemy's health bar
		game.getBar_enemyHealth().setValue((int) game.getEnemySelected().getCurHealth());
		game.getBar_enemyHealth().setString(game.getEnemySelected().getCurHealth() + " / " + game.getEnemySelected().getMaxHealth());
		
		// repaint health bars
		game.repaint();
		
	}
	
	// generate rage
	public void generateRage(int amount) {
		for (int i = 0; i < amount; i++) {
			if ((curRage + 1) <= maxRage) {
				curRage++;
			}
		}
		repaintRage();
	}
	
	// consume rage
	public void consumeRage(int amount) {
		if (haveEnoughRage(amount)) {
			curRage -= amount;
		}
		repaintRage();
	}
	
	// return true/false for neccessary rage consumption
	public boolean haveEnoughRage(int amount) {
		return (amount <= curRage);
	}
	
	// repaint rage graphics
	public void repaintRage() {
		for (int i = 0; i < maxRage; i++) {
			if ((i + 1) <= curRage) {
				rageIcons.get(i).setIcon(new ImageIcon(getClass().getResource("/images/rage_on.png")));
			} else {
				rageIcons.get(i).setIcon(new ImageIcon(getClass().getResource("/images/rage_off.png")));
			}
		}	
	}
	
	// reset all stats, and prepare for fight
	@Override
	public void setEnemyToFight(Enemy enemy) {
		
		// reset health
		double a = maxVitality;
		curVitality = a;
		
		// reset rage
		curRage = 1;
		repaintRage();
		
		// reset health bar
		game.getBar_playerHealth().setMaximum((int) maxVitality);
		game.getBar_playerHealth().setValue((int) maxVitality);
		
		// reset turns
		Game.setTurn(1);
		
		// assign current enemy fighting
		game.setEnemySelected(enemy);
		System.out.println("Now facing => " + enemy.getName());
		
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

	// set all upgrade buttons to active
	@Override
	public void enableButtons() {
		btnUpgradeStat_1.setEnabled(true);
		btnUpgradeStat_2.setEnabled(true);
		btnUpgradeStat_3.setEnabled(true);
		btnUpgradeStat_4.setEnabled(true);
		btnUpgradeStat_5.setEnabled(true);
		btnOffensive.setEnabled(true);
		btnDefensive.setEnabled(true);
	}
	
	// set all upgrade buttons to inactive
	@Override
	public void disableButtons() {
		btnUpgradeStat_1.setEnabled(false);
		btnUpgradeStat_2.setEnabled(false);
		btnUpgradeStat_3.setEnabled(false);
		btnUpgradeStat_4.setEnabled(false);
		btnUpgradeStat_5.setEnabled(false);
		btnOffensive.setEnabled(false);
		btnDefensive.setEnabled(false);
	}
	
	// return the curRage
	public int getCurRage() {
		return curRage;
	}

	// set the curRage
	public void setCurRage(int curRage) {
		this.curRage = curRage;
	}

	// return the maxRage
	public int getMaxRage() {
		return maxRage;
	}

	// set the maxRage
	public void setMaxRage(int maxRage) {
		this.maxRage = maxRage;
	}

	// return the vitality
	@Override
	public double getCurHealth() {
		return curVitality;
	}

	// set the vitality
	@Override
	public void setCurHealth(double vitality) {
		this.curVitality = vitality;
	}

	// return the maxVitality
	@Override
	public double getMaxHealth() {
		return maxVitality;
	}

	// set the maxVitality
	@Override
	public void setMaxHealth(double maxVitality) {
		this.maxVitality = maxVitality;
	}

	// return the sharpness
	@Override
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

	// return the toughness
	public double getToughness() {
		return toughness;
	}

	// set the toughness
	public void setToughness(double toughness) {
		this.toughness = toughness;
	}

}
