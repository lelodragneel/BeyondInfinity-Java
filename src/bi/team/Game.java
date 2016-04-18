package bi.team;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import bi.team.bosstype.Boss;
import bi.team.map.Map;

@SuppressWarnings("serial")
public class Game extends JFrame implements ActionListener {

	/*
	 * initialize variables
	 */
	private static boolean gameover;
	private static boolean turn = true; 	// true for player's turn. false for enemy's turn
	private JPanel contentPane;
	private JPanel panel_player;
	private JPanel panel_top;
	private JPanel panel_stats;
	private JPanel panel_enemy;
	private JPanel panel_actions;
	private JPanel panel_frameOpacity;
	private JProgressBar progBar_loading;
	private JProgressBar progBar_playerVitality;
	private JProgressBar progBar_enemyVitality;
	private JProgressBar progBar_playerEnergy;
	private JTextArea textArea;
	private JButton btnShowMap;
	private JButton btnUpgradeVitality;
	private JButton btnUpgradeEnergy;
	private JButton btnUpgradeProtection;
	private JButton btnUpgradeCritDamage;
	private JButton btnUpgradeCritChance;
	private boolean isMapShown;
	private ArrayList<Attack> attackButtons;
	private Load load;
	private Map map;
	private Player player;
	private Boss boss;
	private JLabel lblVitality;
	private JLabel lblEnergy;
	private JLabel lblProtection;
	private JLabel lblCritDamage;
	private JLabel lblCritChance;
	private JLabel lblProtectionDesc;
	private JProgressBar progBar_enemyEnergy;

	// create the frame
	public Game(String name, ArrayList<Attack> attackButtons) {

		// instantiate objects
		this.attackButtons = attackButtons;
		load = new Load(this);
		player = new Player();
		UIManager.put("ProgressBar.selectionForeground", Color.darkGray);

		// frame initializing
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 940, 550);
		setTitle("BeyondInfinity - alpha");
		getContentPane().setLayout(null);

		// create a root panel
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBounds(0, 0, 934, 521);
		contentPane.setBackground(new Color(236, 240, 241));
		contentPane.setOpaque(true);
		getContentPane().add(contentPane);

		// create the map object/frame in the center minus 30 pixels in y-axis
		map = new Map(getWidth(), getHeight());
		contentPane.add(map);
		
		// create a panel that dims the frame, this is used when toggling map
		panel_frameOpacity = new JPanel();
		panel_frameOpacity.setBounds(0, 0, 934, 521);
		panel_frameOpacity.setBackground(new Color(0, 0, 0, 64));
		panel_frameOpacity.setOpaque(true);
		panel_frameOpacity.setVisible(false);
		contentPane.add(panel_frameOpacity);

		// create left panel for displaying hero info
		panel_player = new JPanel();
		panel_player.setBackground(new Color(204, 255, 153));
		panel_player.setBounds(10, 70, 209, 263);
		panel_player.setLayout(null);
		contentPane.add(panel_player);

		// create top panel to display vitality (health) bars
		panel_top = new JPanel();
		panel_top.setBounds(10, 21, 914, 38);
		panel_top.setLayout(null);
		contentPane.add(panel_top);

		// create the button that toggles map
		btnShowMap = new JButton();
		btnShowMap.setBounds(876, 0, 38, 38);
		btnShowMap.setFocusable(false);
		btnShowMap.setIcon(new ImageIcon(getClass().getResource("/images/map.png")));
		btnShowMap.addActionListener(this);
		panel_top.add(btnShowMap);

		// create bottom panel to display buttons for upgrades
		panel_stats = new JPanel();
		panel_stats.setBounds(10, 344, 914, 87);
		panel_stats.setLayout(new GridLayout(0, 5, 0, 0));
		contentPane.add(panel_stats);

		/* ------------- vitality (health) stat subpanel ------------- */
		// create subpanel (of panel_stats) for vitality
		JPanel subpanel_vitality = new JPanel();
		subpanel_vitality.setBorder(new TitledBorder(null, "Vitality", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		subpanel_vitality.setLayout(null);
		panel_stats.add(subpanel_vitality);

		// create vitality icon
		JLabel lblHealhIcon = new JLabel("");
		lblHealhIcon.setBounds(5, 16, 24, 24);
		lblHealhIcon.setIcon(new ImageIcon(getClass().getResource("/images/heart.png")));
		subpanel_vitality.add(lblHealhIcon);

		// create vitality upgrade button
		btnUpgradeVitality = new JButton("+");
		btnUpgradeVitality.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpgradeVitality.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnUpgradeVitality.setFocusable(false);
		btnUpgradeVitality.setBounds(140, 10, 28, 28);
		btnUpgradeVitality.setVisible(false);
		subpanel_vitality.add(btnUpgradeVitality);
		
		// create the label that displays the maximum vitality value
		lblVitality = new JLabel(player.getMaxVitality() + "");
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
		panel_stats.add(subpanel_energy);

		// create damage icon
		JLabel lblEnergyIcon = new JLabel("");
		lblEnergyIcon.setBounds(5, 16, 24, 24);
		lblEnergyIcon.setIcon(new ImageIcon(Game.class.getResource("/images/energy.png")));
		subpanel_energy.add(lblEnergyIcon);

		// create damage upgrade button
		btnUpgradeEnergy = new JButton("+");
		btnUpgradeEnergy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpgradeEnergy.setFocusable(false);
		btnUpgradeEnergy.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnUpgradeEnergy.setBounds(140, 10, 28, 28);
		btnUpgradeEnergy.setVisible(false);
		subpanel_energy.add(btnUpgradeEnergy);
		
		// create the label that displays damage value
		lblEnergy = new JLabel(player.getEnergyRecoverRate() + "");
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
		panel_stats.add(subpanel_protection);

		// create protection icon
		JLabel lblProtectionIcon = new JLabel("");
		lblProtectionIcon.setBounds(5, 16, 24, 24);
		lblProtectionIcon.setIcon(new ImageIcon(getClass().getResource("/images/armor.png")));
		subpanel_protection.add(lblProtectionIcon);

		// create protection upgrade button
		btnUpgradeProtection = new JButton("+");
		btnUpgradeProtection.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpgradeProtection.setFocusable(false);
		btnUpgradeProtection.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnUpgradeProtection.setBounds(140, 10, 28, 28);
		btnUpgradeProtection.setVisible(false);
		subpanel_protection.add(btnUpgradeProtection);
		
		// create the label that displays protection value
		lblProtection = new JLabel("-" + player.getProtection() * 100 + "%");
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
		panel_stats.add(subpanel_critdamage);

		// create critical damage icon
		JLabel lblCritDamageIcon = new JLabel("");
		lblCritDamageIcon.setBounds(5, 16, 24, 24);
		lblCritDamageIcon.setIcon(new ImageIcon(getClass().getResource("/images/criticaldamage.png")));
		subpanel_critdamage.add(lblCritDamageIcon);

		// create critical damage upgrade button
		btnUpgradeCritDamage = new JButton("+");
		btnUpgradeCritDamage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpgradeCritDamage.setFocusable(false);
		btnUpgradeCritDamage.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnUpgradeCritDamage.setBounds(140, 10, 28, 28);
		btnUpgradeCritDamage.setVisible(false);
		subpanel_critdamage.add(btnUpgradeCritDamage);
		
		// create the label that displays critical damage value
		lblCritDamage = new JLabel("+" + player.getCriticalDamage() * 100 + "%");
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
		panel_stats.add(subpanel_critchance);

		// create critical chance icon
		JLabel lblCritChanceIcon = new JLabel("");
		lblCritChanceIcon.setBounds(5, 16, 24, 24);
		lblCritChanceIcon.setIcon(new ImageIcon(getClass().getResource("/images/criticalchance.png")));
		subpanel_critchance.add(lblCritChanceIcon);

		// create critical chance upgrade button
		btnUpgradeCritChance = new JButton("+");
		btnUpgradeCritChance.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpgradeCritChance.setFocusable(false);
		btnUpgradeCritChance.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnUpgradeCritChance.setBounds(140, 10, 28, 28);
		btnUpgradeCritChance.setVisible(false);
		subpanel_critchance.add(btnUpgradeCritChance);
		
		// create the label that displays critical chance value
		lblCritChance = new JLabel(player.getCriticalChance() + "%");
		lblCritChance.setBounds(39, 16, 91, 24);
		subpanel_critchance.add(lblCritChance);
		
		// create critical chance description label
		JLabel lblCritChanceDesc = new JLabel("<html>Chances of landing a critical hit.</html>");
		lblCritChanceDesc.setVerticalAlignment(SwingConstants.TOP);
		lblCritChanceDesc.setForeground(Color.DARK_GRAY);
		lblCritChanceDesc.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblCritChanceDesc.setBounds(10, 42, 154, 36);
		subpanel_critchance.add(lblCritChanceDesc);

		// create right panel for displaying enemy info
		panel_enemy = new JPanel();
		panel_enemy.setBackground(new Color(204, 255, 153));
		panel_enemy.setBounds(715, 70, 209, 263);
		panel_enemy.setLayout(null);
		contentPane.add(panel_enemy);

		// create actions panel for displaying attack buttons
		panel_actions = new JPanel();
		panel_actions.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel_actions.setBounds(10, 442, 914, 68);
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
		progBar_loading.setBounds(0, 0, 934, 10);
		progBar_loading.setBorder(null);
		progBar_loading.setValue(100);
		progBar_loading.setForeground(new Color(52, 73, 94));
		contentPane.add(progBar_loading);

		// create the player's vitality (health) bar
		progBar_playerVitality = new JProgressBar();
		progBar_playerVitality.setFont(new Font("Tahoma", Font.PLAIN, 11));
		progBar_playerVitality.setStringPainted(true);
		progBar_playerVitality.setBounds(10, 11, 189, 18);
		progBar_playerVitality.setBorder(new LineBorder(new Color(0, 0, 0)));
		progBar_playerVitality.setForeground(new Color(30, 139, 195));
		progBar_playerVitality.setMaximum((int) player.getMaxVitality());
		progBar_playerVitality.setValue((int) player.getMaxVitality());
		progBar_playerVitality.setString(progBar_playerVitality.getValue() + " / " + progBar_playerVitality.getMaximum());
		panel_player.add(progBar_playerVitality);

		// create progress bar to display the enemy's vitality (health)
		progBar_enemyVitality = new JProgressBar();
		progBar_enemyVitality.setFont(new Font("Tahoma", Font.PLAIN, 11));
		progBar_enemyVitality.setStringPainted(true);
		progBar_enemyVitality.setBounds(10, 11, 189, 18);
		progBar_enemyVitality.setBorder(new LineBorder(new Color(0, 0, 0)));
		progBar_enemyVitality.setForeground(new Color(236, 100, 75));
		//progBar_enemyVitality.setValue((int) boss.getTotalHealth());
		panel_enemy.add(progBar_enemyVitality);

		// create label to display enemy's name
		JLabel lbl_enemyName = new JLabel(" name");
		lbl_enemyName.setBounds(10, 50, 189, 20);
		panel_enemy.add(lbl_enemyName);

		// create the enemy's picture
		JLabel lbl_enemyImage = new JLabel("");
		lbl_enemyImage.setBounds(10, 75, 189, 177);
		panel_enemy.add(lbl_enemyImage);
		
		progBar_enemyEnergy = new JProgressBar();
		progBar_enemyEnergy.setFont(new Font("Tahoma", Font.PLAIN, 11));
		progBar_enemyEnergy.setStringPainted(true);
		progBar_enemyEnergy.setForeground(Color.YELLOW);
		progBar_enemyEnergy.setBorder(new EmptyBorder(1, 1, 1, 1));
		progBar_enemyEnergy.setBounds(10, 31, 189, 16);
		progBar_enemyEnergy.setValue(100);
		panel_enemy.add(progBar_enemyEnergy);

		// create label to display player's name
		JLabel lbl_playerName = new JLabel(name);
		lbl_playerName.setBounds(10, 50, 189, 20);
		panel_player.add(lbl_playerName);

		// create the player's picture
		JLabel lbl_playerImage = new JLabel("");
		lbl_playerImage.setBounds(10, 75, 189, 177);
		panel_player.add(lbl_playerImage);

		// create the player's energy bar
		progBar_playerEnergy = new JProgressBar();
		progBar_playerEnergy.setBorder(new EmptyBorder(1, 1, 1, 1));
		progBar_playerEnergy.setFont(new Font("Tahoma", Font.PLAIN, 11));
		progBar_playerEnergy.setStringPainted(true);
		progBar_playerEnergy.setForeground(Color.YELLOW);
		progBar_playerEnergy.setBounds(10, 31, 189, 16);
		progBar_playerEnergy.setString(player.getCurEnergy() + " / " + player.getMaxEnergy());
		progBar_playerEnergy.setValue(100);
		panel_player.add(progBar_playerEnergy);

		// create the area which displays event changes
		textArea = new JTextArea(0, 0);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setBorder(new EmptyBorder(4, 4, 4, 4));
		textArea.setFont(new Font("Comic Sans MS", 0, 12));
		textArea.setBackground(new Color(218, 223, 225));
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(229, 70, 476, 263);
		scroll.setBorder(null);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(scroll);

		// finally show frame
		setVisible(true);

	}

	// logic method maintaining all the pieces together
	public void gameEngine() {
		
		
	}
	
	// action listener
	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource().equals(btnShowMap))
			toggleMap();
		
		// check if any attacks were clicked
		for (int i = 0; i < 6; i++) {
			if (evt.getSource().equals(attackButtons.get(i).getButton())) {
				activateAttack(attackButtons.get(i));
				break;
			}
		}

	}

	// toggle the map
	public void toggleMap() {

		// toggle between true and false
		isMapShown = !isMapShown;

		if (isMapShown) {
			map.setVisible(true);
			panel_frameOpacity.setVisible(true);
			disableAttackButtons();
			disableUpgradeButtons();
		} else {
			map.setVisible(false);
			panel_frameOpacity.setVisible(false);
			enableAttackButtons();
			enableUpgradeButtons();
		}

		// repaint frame to avoid graphical glitches
		repaint();

	}

	// check if button has sufficient energy to be activated
	public void activateAttack(Attack chosenAttack) {
		if (chosenAttack.useAttack()) {
			load.start(chosenAttack);
			// reduce all button cooldowns except chosenAttack
			reduceButtonCooldowns(chosenAttack);
		} else
			appendMessage(chosenAttack.getName() + " is on cooldown, try another.");

	}

	// FIXME player.getEnergyRecoverRate suspected wrong
	// reduce cooldown values of all buttons
	public void reduceButtonCooldowns(Attack attackUsed) {
		for (int i = 0; i < attackButtons.size(); i++) {
			// do not recover the used attack this turn
			if (!attackButtons.get(i).getButton().equals(attackUsed.getButton()))
				attackButtons.get(i).reduceCooldown(player.getEnergyRecoverRate());
		}
	}

	// XXX enemy takes damage
	public void attackEnemy(Attack attack) {		
		double damage = attack.getDamage();
		appendMessage("enemy took " + damage + " damage from " + attack.getName());
		boss.takeDamage(damage);
		progBar_enemyVitality.setValue((int) (progBar_enemyVitality.getValue() - damage));
		
		// toggle turns then let enemy attack you
		Game.toggleTurn();
		load.start(attack);
	}

	// XXX player takes damage
	public void attackPlayer() {
		double bossDamage = boss.getDamage();
		player.setCurVitality(player.getCurVitality() - bossDamage);
		appendMessage("you took " + bossDamage + " damage.");
		progBar_playerVitality.setValue((int) (progBar_playerVitality.getValue() - bossDamage));
		
		// toggle turns
		Game.toggleTurn();
	}

	// FIXME
	public void checkWinner() {
		if (player.getCurVitality() <= 0)
			appendMessage("You lost :( " + player.getCurVitality());
		else if (boss.getHealth() <= 0)
			appendMessage("Congrats you have killed the boss " + boss.getHealth());
		
	}

	// set all attack buttons to active
	public void enableAttackButtons() {
		for (int i = 0; i < attackButtons.size(); i++)
			attackButtons.get(i).getButton().setEnabled(true);
	}
	
	// set all attack buttons to inactive
	public void disableAttackButtons() {
		for (int i = 0; i < attackButtons.size(); i++)
			attackButtons.get(i).getButton().setEnabled(false);
	}
	
	// set all upgrade buttons to active
	public void enableUpgradeButtons() {
		btnUpgradeVitality.setEnabled(true);
		btnUpgradeEnergy.setEnabled(true);
		btnUpgradeProtection.setEnabled(true);
		btnUpgradeCritDamage.setEnabled(true);
		btnUpgradeCritChance.setEnabled(true);
	}
	
	// set all upgrade buttons to inactive
	public void disableUpgradeButtons() {
		btnUpgradeVitality.setEnabled(false);
		btnUpgradeEnergy.setEnabled(false);
		btnUpgradeProtection.setEnabled(false);
		btnUpgradeCritDamage.setEnabled(false);
		btnUpgradeCritChance.setEnabled(false);
	}

	// append a message to the middle display area
	public void appendMessage(String s) {
		textArea.append("> " + s + "\n");
	}

	// set value for the loading bar
	public void setProgBar_loading(int val) {
		progBar_loading.setValue(val);
	}

	// return gameover t/f
	public static boolean getGameover() {
		return gameover;
	}

	// set t/f for gameover
	public static void setGameover(boolean gameover) {
		Game.gameover = gameover;
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
}
