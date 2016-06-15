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
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.StyledDocument;

import bi.team.enemies.Enemy;
import bi.team.enemies.meadowlands.Alania_defender_of_the_meadow;
import bi.team.enemies.meadowlands.Fuehirch;
import bi.team.enemies.meadowlands.Hawk_stag;
import bi.team.enemies.meadowlands.Mantisray;
import bi.team.enemies.meadowlands.Oboko_of_the_sonne;
import bi.team.enemies.meadowlands.Shar_of_the_nacht;
import bi.team.enemies.meadowlands.Taobu;
import bi.team.heroes.Barbarian;
import bi.team.heroes.Chemist;
import bi.team.heroes.Elementalist;
import bi.team.heroes.Hero;
import bi.team.heroes.Swordsman;
import bi.team.heroes.Warlock;
import bi.team.heroes.attacks.barbarian.Attack;
import bi.team.inventory.InventoryFrame;

@SuppressWarnings("serial")
public class Game extends JFrame implements ActionListener {

	/*
	 * initialize variables
	 */
	private static int turn = 1;
	private static int level = 1;
	private static JTextPane textArea;
	private static StyledDocument doc;
	private JPanel panel_player;
	private JPanel panel_top;
	private JPanel panel_stats;
	private JPanel panel_enemy;
	private JPanel panel_actions;
	private JPanel panel_frameOpacity;
	private JPanel panel_areaField;
	private JPanel panel_actionsTop;
	private JLabel areaWallpaper;
	private JLabel upgradePoints;
	private JLabel lblUpgradePoints;
	private JProgressBar bar_loading;
	private JProgressBar bar_playerHealth;
	private JProgressBar bar_enemyHealth;
	private JProgressBar bar_XPBar;
	private JButton btnShowMap;
	private JButton btnShowInventory;
	private boolean isMapShown;
	private boolean isInvShown;
	private Map map;
	private InventoryFrame inventory;
	private Hero hero;
	private ArrayList<Enemy> enemyEntries;
	private Enemy enemySelected;
	private JLabel lblLevel_current;
	private JLabel lblLevel_next;
	
	// create the frame
	public Game(String name, int chosenHero, int giftNum) {

		// TODO instantiate gift parameter

		// health bar esthetics
		UIManager.put("ProgressBar.selectionForeground", Color.darkGray);
		
		/*
		 * build frame
		 */
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 1070, 700);
		this.setTitle("[ver. alpha] BeyondInfinity");
		this.getContentPane().setLayout(null);
		this.setBounds(0, 0, 1070, 654);
		this.setBackground(new Color(236, 240, 241));
		this.setLocationRelativeTo(null);
			
		/*
		 * Create objects of all enemies
		 */
		enemyEntries = new ArrayList<Enemy>();
		enemyEntries.add(new Fuehirch(this));
		enemyEntries.add(new Taobu(this));
		enemyEntries.add(new Hawk_stag(this));
		enemyEntries.add(new Oboko_of_the_sonne(this));
		enemyEntries.add(new Shar_of_the_nacht(this));
		enemyEntries.add(new Mantisray(this));
		enemyEntries.add(new Alania_defender_of_the_meadow(this));
		
		/*
		 * create the map object/frame
		 */
		map = new Map(this);
		getContentPane().add(map);

		/*
		 * create the inventory panel
		 */
		inventory = new InventoryFrame(getWidth(), getHeight());
		getContentPane().add(inventory);

		// create a panel that dims the frame, this is used when toggling map
		panel_frameOpacity = new JPanel();
		panel_frameOpacity.setBounds(0, 0, 1064, 19);
		panel_frameOpacity.setBackground(new Color(0, 0, 0, 64));
		panel_frameOpacity.setOpaque(true);
		panel_frameOpacity.setVisible(false);
		getContentPane().add(panel_frameOpacity);

		// create left panel for displaying hero info
		panel_player = new JPanel();
		panel_player.setBounds(10, 70, 228, 65);
		panel_player.setBackground(new Color(204, 255, 153));
		panel_player.setBorder(new LineBorder(Color.BLACK, 1));
		panel_player.setLayout(null);
		getContentPane().add(panel_player);

		// create top panel to display vitality (health) bars
		panel_top = new JPanel();
		panel_top.setBounds(10, 21, 1044, 38);
		panel_top.setLayout(null);
		getContentPane().add(panel_top);

		// create the button that toggles map
		btnShowMap = new JButton();
		btnShowMap.setBounds(1006, 0, 38, 38);
		btnShowMap.setFocusable(false);
		btnShowMap.setIcon(new ImageIcon(getClass().getResource("/images/map.png")));
		btnShowMap.addActionListener(this);
		panel_top.add(btnShowMap);

		// create the button that toggles inventory
		btnShowInventory = new JButton();
		btnShowInventory.setIcon(new ImageIcon(Game.class.getResource("/images/knapsack.png")));
		btnShowInventory.setBounds(0, 0, 38, 38);
		btnShowInventory.setFocusable(false);
		btnShowInventory.addActionListener(this);
		panel_top.add(btnShowInventory);
		
		// create experience bar
		bar_XPBar = new JProgressBar();
		bar_XPBar.setForeground(new Color(126, 52, 157));
		bar_XPBar.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		bar_XPBar.setString("20 / 100 XP");
		bar_XPBar.setValue(20);
		bar_XPBar.setBorder(new LineBorder(new Color(0, 0, 0)));
		bar_XPBar.setStringPainted(true);
		bar_XPBar.setBounds(322, 12, 400, 14);
		panel_top.add(bar_XPBar);
		
		/*
		 * create two icons for levels
		 */
		// current level
		lblLevel_current = new JLabel(level + "");
		lblLevel_current.setForeground(Color.WHITE);
		lblLevel_current.setHorizontalTextPosition(JLabel.CENTER);
		lblLevel_current.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblLevel_current.setIcon(new ImageIcon(getClass().getResource("/images/xpcircle.png")));
		lblLevel_current.setBounds(274, 0, 38, 38);
		panel_top.add(lblLevel_current);
		
		// next level
		lblLevel_next = new JLabel((level + 1) + "");
		lblLevel_next.setForeground(Color.WHITE);
		lblLevel_next.setHorizontalTextPosition(JLabel.CENTER);
		lblLevel_next.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblLevel_next.setIcon(new ImageIcon(getClass().getResource("/images/xpcircle.png")));
		lblLevel_next.setBounds(732, 0, 38, 38);
		panel_top.add(lblLevel_next);
		
		// create bottom panel to display buttons for upgrades
		panel_stats = new JPanel();
		panel_stats.setBounds(10, 414, 1044, 87);
		panel_stats.setLayout(new GridLayout(0, 5, 0, 0));
		getContentPane().add(panel_stats);

		// create right panel for displaying enemy info
		panel_enemy = new JPanel();
		panel_enemy.setBackground(new Color(204, 255, 153));
		panel_enemy.setBounds(826, 70, 228, 65);
		panel_enemy.setBorder(new LineBorder(Color.BLACK, 1));
		panel_enemy.setLayout(null);
		getContentPane().add(panel_enemy);

		// create actions panel for displaying attack buttons
		panel_actions = new JPanel();
		panel_actions.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel_actions.setBounds(10, 542, 1044, 72);
		panel_actions.setBackground(new Color(135, 211, 124));
		panel_actions.setLayout(new GridLayout(0, 6, 10, 0));
		getContentPane().add(panel_actions);
		
		// create top actions panel
		panel_actionsTop = new JPanel();
		panel_actionsTop.setBounds(10, 508, 1044, 34);
		panel_actionsTop.setLayout(null);
		getContentPane().add(panel_actionsTop);
		
		// create label to display upgrade points
		lblUpgradePoints = new JLabel("Upgrade points:");
		lblUpgradePoints.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblUpgradePoints.setBounds(854, 9, 100, 16);
		panel_actionsTop.add(lblUpgradePoints);

		// create the loading bar
		bar_loading = new JProgressBar();
		bar_loading.setBounds(0, 0, 1064, 10);
		bar_loading.setBorder(null);
		bar_loading.setValue(100);
		bar_loading.setForeground(new Color(52, 73, 94));
		getContentPane().add(bar_loading);

		/*
		 * create two heart icons for health bars
		 */
		// player's health icon
		JLabel lblHeartPlayer = new JLabel("HP");
		lblHeartPlayer.setForeground(Color.WHITE);
		lblHeartPlayer.setHorizontalTextPosition(JLabel.CENTER);
		lblHeartPlayer.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblHeartPlayer.setBounds(3, 3, 32, 32);
		lblHeartPlayer.setIcon(new ImageIcon(getClass().getResource("/images/heart.png")));
		panel_player.add(lblHeartPlayer);
		// enemy's health icon
		JLabel lblHeartEnemy = new JLabel("HP");
		lblHeartEnemy.setForeground(Color.WHITE);
		lblHeartEnemy.setHorizontalTextPosition(JLabel.CENTER);
		lblHeartEnemy.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblHeartEnemy.setBounds(3, 3, 32, 32);
		lblHeartEnemy.setIcon(new ImageIcon(getClass().getResource("/images/heart.png")));
		panel_enemy.add(lblHeartEnemy);

		// create the player's vitality (health) bar
		bar_playerHealth = new JProgressBar();
		bar_playerHealth.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		bar_playerHealth.setStringPainted(true);
		bar_playerHealth.setBounds(14, 11, 204, 16);
		bar_playerHealth.setBorder(new LineBorder(new Color(0, 0, 0)));
		bar_playerHealth.setForeground(new Color(30, 139, 195));
		panel_player.add(bar_playerHealth);

		// create progress bar to display the enemy's vitality (health)
		bar_enemyHealth = new JProgressBar();
		bar_enemyHealth.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		bar_enemyHealth.setStringPainted(true);
		bar_enemyHealth.setBounds(14, 11, 205, 16);
		bar_enemyHealth.setBorder(new LineBorder(new Color(0, 0, 0)));
		bar_enemyHealth.setForeground(new Color(236, 100, 75));
		panel_enemy.add(bar_enemyHealth);

		// create label to display enemy's name
		JLabel lbl_enemyName = new JLabel(" name");
		lbl_enemyName.setBounds(13, 46, 189, 20);
		panel_enemy.add(lbl_enemyName);

		// create panel displaying player images
		panel_areaField = new JPanel();
		panel_areaField.setBounds(10, 70, 1044, 333);
		panel_areaField.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_areaField.setLayout(null);
		getContentPane().add(panel_areaField);
		
		/*
		 * create the area which displays event changes
		 */
		textArea = new JTextPane();
		textArea.setEditable(false);
		textArea.setOpaque(false);
		textArea.setBorder(null);
		textArea.setFont(new Font("Comic Sans MS", 0, 14));
		textArea.setAutoscrolls(true);
		textArea.setBounds(297, 20, 450, 293);
		textArea.setContentType("text/html");
		doc = textArea.getStyledDocument();
		// create scrolling for text area
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setAutoscrolls(true);
		scroll.setBounds(297, 20, 450, 293);
		scroll.setOpaque(false);
		scroll.setBorder(null);
		scroll.getViewport().setOpaque(false);
		panel_areaField.add(scroll);

		// create label to display area image
		areaWallpaper = new JLabel();
		areaWallpaper.setBounds(0, 0, 1044, 333);
		areaWallpaper.setIcon(new ImageIcon(getClass().getResource("/images/areas/meadowlands.jpg")));
		panel_areaField.add(areaWallpaper);

		// create the enemy's picture
		JLabel lbl_enemyImage = new JLabel("");
		lbl_enemyImage.setBounds(825, 75, 209, 230);
		panel_areaField.add(lbl_enemyImage);

		// create label to display player's name
		JLabel lbl_playerName = new JLabel(name);
		lbl_playerName.setBounds(0, 76, 140, 20);
		panel_areaField.add(lbl_playerName);

		// create the player's picture
		JLabel lbl_playerImage = new JLabel("");
		lbl_playerImage.setBounds(10, 75, 208, 230);
		panel_areaField.add(lbl_playerImage);

		// create selected hero
		if (chosenHero == 1)
			this.hero = new Barbarian(this);
		else if (chosenHero == 2) 
			this.hero = new Chemist(this);
		else if (chosenHero == 3) 
			this.hero = new Elementalist(this);
		else if (chosenHero == 4) 
			this.hero = new Swordsman(this);
		else if (chosenHero == 5) 
			this.hero = new Warlock(this);
		
		// finally show frame
		setVisible(true);

	}

	// XXX action listener
	public void actionPerformed(ActionEvent evt) {

		// clicked map
		if (evt.getSource() == btnShowMap)
			toggleMap();
		// clicked inventory
		if (evt.getSource() == btnShowInventory)
			toggleInventory();

	}

	// toggle the map pane
	public void toggleMap() {

		// toggle between true and false
		isMapShown = !isMapShown;

		if (isMapShown) {
			map.getLblEnemyIcon().setIcon(null);
			map.getLblEnemyName().setText("");
			map.getBtnChallenge().setEnabled(false);
			map.setVisible(true);
			panel_frameOpacity.setVisible(true);
			disableAttackButtons();
			hero.disableButtons();
			btnShowInventory.setEnabled(false);
		} else {
			map.setVisible(false);
			panel_frameOpacity.setVisible(false);
			enableAttackButtons();
			hero.enableButtons();
			btnShowInventory.setEnabled(true);
		}

		// repaint frame to avoid graphical glitches
		repaint();

	}

	// toggle the inventory pane
	public void toggleInventory() {

		// toggle between true and false
		isInvShown = !isInvShown;

		if (isInvShown) {
			inventory.setVisible(true);
			panel_frameOpacity.setVisible(true);
			disableAttackButtons();
			hero.disableButtons();
		} else {
			inventory.setVisible(false);
			panel_frameOpacity.setVisible(false);
			enableAttackButtons();
			hero.enableButtons();
		}

		// repaint frame to avoid graphical glitches
		repaint();

	}

	// set all attack buttons to active
	public void enableAttackButtons() {
		for (Attack x : hero.getAttacksArrayList())
			x.getButton().setEnabled(true);
	}

	// set all attack buttons to inactive
	public void disableAttackButtons() {
		for (Attack x : hero.getAttacksArrayList())
			x.getButton().setEnabled(false);
	}
	
	// return the panel_stats
	public JPanel getPanel_stats() {
		return panel_stats;
	}

	// set value for the loading bar
	public void setProgBar_loading(int val) {
		bar_loading.setValue(val);
	}

	// even number = player turn (returns true)
	// odd number = enemy turn (returns false)
	public static boolean getTurn() {
		if (turn == 1)
			return true;
		else
			return (turn % 2) != 0;
	}
	
	// return turn number
	public static void addTurn() {
		turn += 1;
	}
	
	// set the turn
	public static void setTurn(int turn) {
		Game.turn = turn;
	}

	// return the panel_actions jpanel
	public JPanel getPanel_actions() {
		return panel_actions;
	}
	
	// return the enemySelected
	public Enemy getEnemySelected() {
		return enemySelected;
	}

	// set the enemySelected
	public void setEnemySelected(Enemy enemySelected) {
		this.enemySelected = enemySelected;
	}
	// return the panel_player
	public JPanel getPanel_player() {
		return panel_player;
	}

	// return the lblUpgradePoints
	public JLabel getLblUpgradePoints() {
		return lblUpgradePoints;
	}

	// return the level
	public static int getLevel() {
		return level;
	}

	// set the level
	public static void setLevel(int level) {
		Game.level = level;
	}

	// set the lblUpgradePoints
	public void setLblUpgradePoints(JLabel lblUpgradePoints) {
		this.lblUpgradePoints = lblUpgradePoints;
	}

	// return the player
	public Hero getHero() {
		return hero;
	}

	// return the textArea
	public JTextPane getTextArea() {
		return textArea;
	}

	// return the doc
	public StyledDocument getDoc() {
		return doc;
	}

	// return the bar_playerHealth
	public JProgressBar getBar_playerHealth() {
		return bar_playerHealth;
	}

	// return the bar_enemyHealth
	public JProgressBar getBar_enemyHealth() {
		return bar_enemyHealth;
	}

	// return the enemyEntries
	public ArrayList<Enemy> getEnemyEntries() {
		return enemyEntries;
	}

	// return the upgradePoints
	public JLabel getUpgradePoints() {
		return upgradePoints;
	}

	// return the panel_actionsTop
	public JPanel getPanel_actionsTop() {
		return panel_actionsTop;
	}

	// return the bar_XPBar
	public JProgressBar getBar_XPBar() {
		return bar_XPBar;
	}

	// set the upgradePoints
	public void setUpgradePoints(JLabel upgradePoints) {
		this.upgradePoints = upgradePoints;
	}

	// return the map
	public Map getMap() {
		return map;
	}
}
