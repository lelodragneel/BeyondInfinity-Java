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
	private JPanel panel_frameOpacity;
	private JProgressBar progBar_loading;
	private JProgressBar progBar_playerVitality;
	private JProgressBar progBar_enemyVitality;
	private JTextArea textArea;
	private JButton btnShowMap;
	private JButton btnUpgradeVitality;
	private JButton btnUpgradeDamage;
	private JButton btnUpgradeProtection;
	private JButton btnUpgradeCritDamage;
	private JButton btnUpgradeCritChance;
	private boolean isMapShown;
	private ArrayList<Attack> attackButtons;
	private Load load;
	private Map map;
	private Player player;
	private Boss boss;

	// create the frame
	public Game(String name, ArrayList<Attack> attackButtons) {
		
		// instantiate objects
		this.attackButtons = attackButtons;
		load = new Load(this);
		player = new Player();
		boss = new Boss(100,10,10,1);

		// frame initializing
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 900, 510);
		setTitle("BeyondInfinity - alpha");
		getContentPane().setLayout(null);

		// create a root panel
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBounds(0, 0, 894, 481);
		contentPane.setBackground(new Color(236, 240, 241));
		contentPane.setOpaque(true);
		getContentPane().add(contentPane);

		// create the map object/frame in the center minus 30 pixels in y-axis
		map = new Map(getWidth(), getHeight());
		contentPane.add(map.getMapPane());
		
		// create a panel that dims the frame, this is used when toggling map
		panel_frameOpacity = new JPanel();
		panel_frameOpacity.setBounds(0, 0, 894, 481);
		panel_frameOpacity.setBackground(new Color(0, 0, 0, 64));
		panel_frameOpacity.setOpaque(true);
		panel_frameOpacity.setVisible(false);
		contentPane.add(panel_frameOpacity);

		// create left panel for displaying hero info
		panel_player = new JPanel();
		panel_player.setBackground(new Color(204, 255, 153));
		panel_player.setBounds(10, 70, 209, 243);
		panel_player.setLayout(null);
		contentPane.add(panel_player);

		// create top panel to display vitality (health) bars
		panel_top = new JPanel();
		panel_top.setBounds(10, 21, 874, 38);
		panel_top.setLayout(null);
		contentPane.add(panel_top);

		// create the button that toggles map
		btnShowMap = new JButton();
		btnShowMap.setBounds(836, 0, 38, 38);
		btnShowMap.setFocusable(false);
		btnShowMap.setIcon(new ImageIcon(getClass().getResource("/images/map.png")));
		btnShowMap.addActionListener(this);
		panel_top.add(btnShowMap);

		// create bottom panel to display buttons for upgrades
		panel_stats = new JPanel();
		panel_stats.setBounds(10, 324, 874, 68);
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
		lblHealhIcon.setBounds(10, 16, 24, 24);
		lblHealhIcon.setIcon(new ImageIcon(getClass().getResource("/images/heart.png")));
		subpanel_vitality.add(lblHealhIcon);

		// create vitality upgrade button
		btnUpgradeVitality = new JButton("+");
		btnUpgradeVitality.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpgradeVitality.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnUpgradeVitality.setFocusable(false);
		btnUpgradeVitality.setBounds(136, 16, 28, 28);
		btnUpgradeVitality.setVisible(false);
		subpanel_vitality.add(btnUpgradeVitality);

		/* ------------- damage stat subpanel ------------- */
		// create subpanel (of panel_stats) for damage
		JPanel subpanel_damage = new JPanel();
		subpanel_damage.setBorder(new TitledBorder(null, "Damage", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		subpanel_damage.setLayout(null);
		panel_stats.add(subpanel_damage);

		// create damage icon
		JLabel lblDamageIcon = new JLabel("");
		lblDamageIcon.setBounds(10, 16, 24, 24);
		lblDamageIcon.setIcon(new ImageIcon(getClass().getResource("/images/damage.png")));
		subpanel_damage.add(lblDamageIcon);

		// create damage upgrade button
		btnUpgradeDamage = new JButton("+");
		btnUpgradeDamage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpgradeDamage.setFocusable(false);
		btnUpgradeDamage.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnUpgradeDamage.setBounds(136, 16, 28, 28);
		btnUpgradeDamage.setVisible(false);
		subpanel_damage.add(btnUpgradeDamage);

		/* ------------- protection (armor) stat subpanel ------------- */
		// create subpanel (of panel_stats) for protection
		JPanel subpanel_protection = new JPanel();
		subpanel_protection.setBorder(new TitledBorder(null, "Protection", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		subpanel_protection.setLayout(null);
		panel_stats.add(subpanel_protection);

		// create protection icon
		JLabel lblProtectionIcon = new JLabel("");
		lblProtectionIcon.setBounds(10, 16, 24, 24);
		lblProtectionIcon.setIcon(new ImageIcon(getClass().getResource("/images/armor.png")));
		subpanel_protection.add(lblProtectionIcon);

		// create protection upgrade button
		btnUpgradeProtection = new JButton("+");
		btnUpgradeProtection.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpgradeProtection.setFocusable(false);
		btnUpgradeProtection.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnUpgradeProtection.setBounds(136, 16, 28, 28);
		btnUpgradeProtection.setVisible(false);
		subpanel_protection.add(btnUpgradeProtection);

		/* ------------- critical damage stat subpanel ------------- */
		// create subpanel (of panel_stats) for critical damage
		JPanel subpanel_critdamage = new JPanel();
		subpanel_critdamage.setBorder(
				new TitledBorder(null, "Critical Damage", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		subpanel_critdamage.setLayout(null);
		panel_stats.add(subpanel_critdamage);

		// create critical damage icon
		JLabel lblCritDamageIcon = new JLabel("");
		lblCritDamageIcon.setBounds(10, 16, 24, 24);
		lblCritDamageIcon.setIcon(new ImageIcon(getClass().getResource("/images/criticaldamage.png")));
		subpanel_critdamage.add(lblCritDamageIcon);

		// create critical damage upgrade button
		btnUpgradeCritDamage = new JButton("+");
		btnUpgradeCritDamage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpgradeCritDamage.setFocusable(false);
		btnUpgradeCritDamage.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnUpgradeCritDamage.setBounds(136, 16, 28, 28);
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
		lblCritChanceIcon.setBounds(10, 16, 24, 24);
		lblCritChanceIcon.setIcon(new ImageIcon(getClass().getResource("/images/criticalchance.png")));
		subpanel_critchance.add(lblCritChanceIcon);

		// create critical chance upgrade button
		btnUpgradeCritChance = new JButton("+");
		btnUpgradeCritChance.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpgradeCritChance.setFocusable(false);
		btnUpgradeCritChance.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnUpgradeCritChance.setBounds(136, 16, 28, 28);
		btnUpgradeCritChance.setVisible(false);
		subpanel_critchance.add(btnUpgradeCritChance);

		// create right panel for displaying enemy info
		panel_enemy = new JPanel();
		panel_enemy.setBackground(new Color(204, 255, 153));
		panel_enemy.setBounds(675, 70, 209, 243);
		panel_enemy.setLayout(null);
		contentPane.add(panel_enemy);

		// create actions panel for displaying attack buttons
		panel_actions = new JPanel();
		panel_actions.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel_actions.setBounds(10, 403, 874, 68);
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
		progBar_loading.setBounds(0, 0, 894, 10);
		progBar_loading.setBorder(null);
		progBar_loading.setValue(100);
		progBar_loading.setForeground(new Color(52, 73, 94));
		progBar_loading.setVisible(true);
		contentPane.add(progBar_loading);

		// create the player's vitality (health) bar
		progBar_playerVitality = new JProgressBar();
		progBar_playerVitality.setBounds(10, 11, 189, 15);
		progBar_playerVitality.setVisible(true);
		progBar_playerVitality.setBorder(null);
		progBar_playerVitality.setForeground(new Color(30, 139, 195));
		progBar_playerVitality.setBorderPainted(false);
		progBar_playerVitality.setMaximum((int) player.getMaxVitality());
		progBar_playerVitality.setValue((int) player.getMaxVitality());
		panel_player.add(progBar_playerVitality);

		// create progress bar to display the enemy's vitality (health)
		progBar_enemyVitality = new JProgressBar();
		progBar_enemyVitality.setBounds(10, 11, 189, 15);
		progBar_enemyVitality.setBorder(null);
		progBar_enemyVitality.setForeground(new Color(236, 100, 75));
		progBar_enemyVitality.setBorderPainted(false);
		progBar_enemyVitality.setValue((int) boss.getTotalHealth());
		panel_enemy.add(progBar_enemyVitality);

		// create label to display enemy's name
		JLabel lbl_enemyName = new JLabel(" name");
		lbl_enemyName.setBounds(10, 25, 189, 20);
		panel_enemy.add(lbl_enemyName);

		// create the enemy's picture
		JLabel lbl_enemyImage = new JLabel("");
		lbl_enemyImage.setBounds(10, 56, 189, 169);
		panel_enemy.add(lbl_enemyImage);

		// create label to display player's name
		JLabel lbl_playerName = new JLabel(name);
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
		scroll.setBounds(229, 70, 436, 243);
		scroll.setBorder(null);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(scroll);

		// finally show frame
		setVisible(true);

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
			map.getMapPane().setVisible(true);
			panel_frameOpacity.setVisible(true);
			disableAttackButtons();
			disableUpgradeButtons();
		} else {
			map.getMapPane().setVisible(false);
			panel_frameOpacity.setVisible(false);
			enableAttackButtons();
			enableUpgradeButtons();
		}

		// repaint frame to avoid graphical glitches
		repaint();

	}

	// XXX uses an attack
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
		appendMessage("you took " + bossDamage + " damage");
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
		btnUpgradeDamage.setEnabled(true);
		btnUpgradeProtection.setEnabled(true);
		btnUpgradeCritDamage.setEnabled(true);
		btnUpgradeCritChance.setEnabled(true);
	}
	
	// set all upgrade buttons to inactive
	public void disableUpgradeButtons() {
		btnUpgradeVitality.setEnabled(false);
		btnUpgradeDamage.setEnabled(false);
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
}
