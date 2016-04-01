package bi.team;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class Game extends JFrame implements ActionListener {

	// init variables
	private static int kills;
	// true for player's turn. false for enemy's turn
	private static boolean turn = true;
	private JPanel contentPane;
	private JPanel panel_player;
	private JPanel panel_top;
	private JPanel panel_stats;
	private JPanel panel_enemy;
	private JPanel panel_actions;
	private JProgressBar progBar_loading;
	private JProgressBar progBar_playerHealth;
	private JProgressBar progBar_enemyHealth;
	private JTextArea textArea;
	private JButton btnShowMap;
	private JButton btnUpgradeHealth;
	private JButton btnUpgradeDamage;
	private JButton btnUpgradeArmor;
	private JButton btnUpgradeCritDamage;
	private JButton btnCritChance;
	private String playerName;
	private boolean isMapShown;
	private ArrayList<Attack> attackButtons;
	private Load load;
	private Map map;
	private Player player;

	// create the frame
	public Game(Player player, ArrayList<Attack> attacks) {

		// instantiate objects
		load = new Load(this);
		playerName = player.getName();
		this.player = player;
		this.attackButtons = attacks;

		// frame initializing
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 880, 480);
		setTitle("BeyondInfinity - by Lelo");
		getContentPane().setLayout(null);

		// create a root panel
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBounds(0, 0, 874, 451);
		contentPane.setBackground(new Color(236, 240, 241));
		getContentPane().add(contentPane);

		// create the map object/frame
		map = new Map();
		map.getMapPane().setBounds((contentPane.getWidth() / 2) - (550 / 2), (contentPane.getHeight() / 2) - (320 / 2),
				550, 320);
		contentPane.add(map.getMapPane());

		// create left panel for displaying hero info
		panel_player = new JPanel();
		panel_player.setBackground(new Color(204, 255, 153));
		panel_player.setBounds(10, 59, 209, 236);
		panel_player.setLayout(null);
		contentPane.add(panel_player);

		// create top panel to display health bars
		panel_top = new JPanel();
		panel_top.setBounds(10, 21, 854, 29);
		panel_top.setLayout(null);
		contentPane.add(panel_top);

		// create bottom panel to display buttons for upgrades
		panel_stats = new JPanel();
		panel_stats.setBounds(10, 306, 854, 55);
		contentPane.add(panel_stats);

		/* ------------- health stat subpanel ------------- */
		panel_stats.setLayout(new GridLayout(0, 5, 0, 0));
		// create subpanel (of panel_stats) for health
		JPanel subpanel_health = new JPanel();
		subpanel_health.setBorder(new TitledBorder(null, "Health", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		subpanel_health.setLayout(null);
		panel_stats.add(subpanel_health);

		// create health icon
		JLabel lblHealhIcon = new JLabel("");
		lblHealhIcon.setBounds(10, 16, 30, 28);
		subpanel_health.add(lblHealhIcon);

		// create health upgrade button
		btnUpgradeHealth = new JButton("+");
		btnUpgradeHealth.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpgradeHealth.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnUpgradeHealth.setFocusable(false);
		btnUpgradeHealth.setBounds(132, 16, 28, 28);
		btnUpgradeHealth.setVisible(false);
		subpanel_health.add(btnUpgradeHealth);

		/* ------------- damage stat subpanel ------------- */
		// create subpanel (of panel_stats) for damage
		JPanel subpanel_damage = new JPanel();
		subpanel_damage.setBorder(new TitledBorder(null, "Damage", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		subpanel_damage.setLayout(null);
		panel_stats.add(subpanel_damage);

		// create damage icon
		JLabel lblDamageIcon = new JLabel("");
		lblDamageIcon.setBounds(10, 16, 30, 28);
		subpanel_damage.add(lblDamageIcon);

		// create damage upgrade button
		btnUpgradeDamage = new JButton("+");
		btnUpgradeDamage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpgradeDamage.setFocusable(false);
		btnUpgradeDamage.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnUpgradeDamage.setBounds(132, 16, 28, 28);
		btnUpgradeDamage.setVisible(false);
		subpanel_damage.add(btnUpgradeDamage);

		/* ------------- armor stat subpanel ------------- */
		// create subpanel (of panel_stats) for armor
		JPanel subpanel_armor = new JPanel();
		subpanel_armor.setBorder(new TitledBorder(null, "Armor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		subpanel_armor.setLayout(null);
		panel_stats.add(subpanel_armor);

		// create armor icon
		JLabel lblArmorIcon = new JLabel("");
		lblArmorIcon.setBounds(10, 16, 30, 28);
		subpanel_armor.add(lblArmorIcon);

		// create armor upgrade button
		btnUpgradeArmor = new JButton("+");
		btnUpgradeArmor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpgradeArmor.setFocusable(false);
		btnUpgradeArmor.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnUpgradeArmor.setBounds(132, 16, 28, 28);
		btnUpgradeArmor.setVisible(false);
		subpanel_armor.add(btnUpgradeArmor);

		/* ------------- critical damage stat subpanel ------------- */
		// create subpanel (of panel_stats) for critical damage
		JPanel subpanel_critdamage = new JPanel();
		subpanel_critdamage.setBorder(
				new TitledBorder(null, "Critical Damage", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		subpanel_critdamage.setLayout(null);
		panel_stats.add(subpanel_critdamage);

		// create critical damage icon
		JLabel lblCritDamageIcon = new JLabel("");
		lblCritDamageIcon.setBounds(10, 16, 30, 28);
		subpanel_critdamage.add(lblCritDamageIcon);

		// create critical damage upgrade button
		btnUpgradeCritDamage = new JButton("+");
		btnUpgradeCritDamage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpgradeCritDamage.setFocusable(false);
		btnUpgradeCritDamage.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnUpgradeCritDamage.setBounds(132, 16, 28, 28);
		btnUpgradeCritDamage.setVisible(false);
		subpanel_critdamage.add(btnUpgradeCritDamage);

		/* ------------- critical chance stat subpanel ------------- */
		// create subpanel (of panel_stats) for critical chance
		JPanel subpanel_critchance = new JPanel();
		subpanel_critchance.setBorder(
				new TitledBorder(null, "Critical Chance", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		subpanel_critchance.setLayout(null);
		panel_stats.add(subpanel_critchance);

		// create critical chance icon
		JLabel lblCritChanceIcon = new JLabel("");
		lblCritChanceIcon.setBounds(10, 16, 30, 28);
		subpanel_critchance.add(lblCritChanceIcon);

		// create critical chance upgrade button
		btnCritChance = new JButton("+");
		btnCritChance.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCritChance.setFocusable(false);
		btnCritChance.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnCritChance.setBounds(132, 16, 28, 28);
		btnCritChance.setVisible(false);
		subpanel_critchance.add(btnCritChance);

		// create right panel for displaying enemy info
		panel_enemy = new JPanel();
		panel_enemy.setBackground(new Color(204, 255, 153));
		panel_enemy.setBounds(655, 59, 209, 236);
		panel_enemy.setLayout(null);
		contentPane.add(panel_enemy);

		// create actions panel for displaying attack buttons
		panel_actions = new JPanel();
		panel_actions.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel_actions.setBounds(10, 372, 854, 68);
		panel_actions.setBackground(new Color(135, 211, 124));
		panel_actions.setLayout(new GridLayout(0, 6, 10, 0));
		contentPane.add(panel_actions);

		// loop through all buttons, and add to action listener & panel_actions
		for (int i = 0; i < attackButtons.size(); i++) {
			attackButtons.get(i).getButton().addActionListener(this);
			panel_actions.add(attackButtons.get(i).getButton());
		}

		// create the loading bar
		progBar_loading = new JProgressBar();
		progBar_loading.setBounds(0, 0, 874, 10);
		progBar_loading.setBorder(null);
		progBar_loading.setValue(100);
		progBar_loading.setForeground(new Color(52, 73, 94));
		progBar_loading.setVisible(true);
		contentPane.add(progBar_loading);

		// create the player's health bar
		progBar_playerHealth = new JProgressBar();
		progBar_playerHealth.setBounds(10, 11, 189, 15);
		progBar_playerHealth.setVisible(true);
		progBar_playerHealth.setBorder(null);
		progBar_playerHealth.setForeground(new Color(30, 139, 195));
		progBar_playerHealth.setBorderPainted(false);
		progBar_playerHealth.setValue(100);
		panel_player.add(progBar_playerHealth);

		// create progress bar to display the enemy's health
		progBar_enemyHealth = new JProgressBar();
		progBar_enemyHealth.setBounds(10, 11, 189, 15);
		progBar_enemyHealth.setBorder(null);
		progBar_enemyHealth.setForeground(new Color(236, 100, 75));
		progBar_enemyHealth.setBorderPainted(false);
		progBar_enemyHealth.setValue(100);
		panel_enemy.add(progBar_enemyHealth);

		// create label to display enemy's name
		JLabel lbl_enemyName = new JLabel(" name");
		lbl_enemyName.setBounds(10, 25, 189, 20);
		panel_enemy.add(lbl_enemyName);

		// create the enemy's picture
		JLabel lbl_enemyImage = new JLabel("");
		lbl_enemyImage.setBounds(10, 56, 189, 169);
		panel_enemy.add(lbl_enemyImage);

		// create label to display player's name
		JLabel lbl_playerName = new JLabel(playerName);
		lbl_playerName.setBounds(10, 25, 189, 20);
		panel_player.add(lbl_playerName);

		// create the player's picture
		JLabel lbl_playerImage = new JLabel("");
		lbl_playerImage.setBounds(10, 56, 189, 169);
		panel_player.add(lbl_playerImage);

		// create the area which displays event changes
		textArea = new JTextArea(0, 0);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setBorder(new EmptyBorder(4, 4, 4, 4));
		textArea.setFont(new Font("Comic Sans MS", 0, 12));
		textArea.setBackground(new Color(218, 223, 225));
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(229, 59, 416, 236);
		scroll.setBorder(null);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(scroll);

		// create the button that toggles map
		btnShowMap = new JButton("Map");
		btnShowMap.setBounds(774, 0, 80, 29);
		btnShowMap.setFocusable(false);
		btnShowMap.addActionListener(this);
		panel_top.add(btnShowMap);

		// finally show frame
		setVisible(true);

	}

	// action listener
	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource().equals(attackButtons.get(0).getButton()))
			activateAttack(attackButtons.get(0));
		else if (evt.getSource().equals(attackButtons.get(1).getButton()))
			activateAttack(attackButtons.get(1));
		else if (evt.getSource().equals(attackButtons.get(2).getButton()))
			activateAttack(attackButtons.get(2));
		else if (evt.getSource().equals(attackButtons.get(3).getButton()))
			activateAttack(attackButtons.get(3));
		else if (evt.getSource().equals(attackButtons.get(4).getButton()))
			activateAttack(attackButtons.get(4));
		else if (evt.getSource().equals(attackButtons.get(5).getButton()))
			activateAttack(attackButtons.get(5));
		else if (evt.getSource().equals(btnShowMap))
			toggleMap();

	}

	// toggle the map
	public void toggleMap() {
		isMapShown = !isMapShown;
		map.getMapPane().setVisible(isMapShown);
	}

	// check if button has sufficient energy to be activated
	public void activateAttack(Attack chosenAttack) {
		if (chosenAttack.useAttack(false)) {
			chosenAttack.useAttack(true);
			load.start(chosenAttack.getButton(), chosenAttack);
			cooldownUpkeep();
		} else {
			appendMessage(chosenAttack.getName() + " is on cooldown, try another.");
		}
	}

	public void cooldownUpkeep() {
		for (int i = 0; i < 6; i++)
			attackButtons.get(i).reduceCooldown(player.getEnergyRecoverRate());
	}

	// add 5 energy for each button
	// (this is called when hit by enemy, once per turn)
	// TODO fix cooldowns
	public void regenerateButtons() {
		/*
		 * attack_strike.regenerate(); attack_rejuvenate.regenerate();
		 * attack_heroicStrike.regenerate(); attack_evade.regenerate();
		 * attack_toxicSpit.regenerate(); attack_annihilate.regenerate();
		 */
	}

	// enemy takes damage
	public void attackEnemy(JButton button, Attack attack) {
		// TODO enemy health takes damage
		Double damage = attack.getDamage();
		appendMessage("enemy took " + damage + " damage from " + attack.getName());

		// toggle turns then let enemy attack you
		Game.toggleTurn();
		load.start(null, attack);
	}

	// player takes damage
	public void attackPlayer() {
		appendMessage("you took x damage");

		// TODO you take damage

		// toggle turns
		Game.toggleTurn();
		// regenerate 5 energy for all buttons
		regenerateButtons();
		// re-enable buttons
		enableButtons();
	}

	// set all attack buttons to inactive
	public void disableButtons() {
		for (int i = 0; i < 6; i++)
			attackButtons.get(i).getButton().setEnabled(false);

	}

	// set all attack buttons to active
	public void enableButtons() {
		for (int i = 0; i < 6; i++)
			attackButtons.get(i).getButton().setEnabled(true);

	}

	// append a message to the middle display area
	public void appendMessage(String s) {
		textArea.append("> " + s + "\n");
	}

	// set value for the loading bar
	public void setProgBar_loading(int val) {
		progBar_loading.setValue(val);
		progBar_loading.repaint();
	}

	// return total kills
	public static int getKills() {
		return kills;
	}

	// set total kills
	public static void setKills(int kills) {
		Game.kills = kills;
	}

	// return the current turn
	public static boolean getTurn() {
		return turn;
	}

	// change turn to the other
	// true for player's turn. false for enemy's turn
	public static void toggleTurn() {
		turn = !turn;
	}

	// return the player's name
	public String getPlayerName() {
		return playerName;
	}

	// set the player name
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
}
