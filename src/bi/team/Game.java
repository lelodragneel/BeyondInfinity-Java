package bi.team;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.border.TitledBorder;

import bi.team.bosstype.Enemy;
import bi.team.heroes.Alchemist;
import bi.team.heroes.Brutalizer;
import bi.team.heroes.Elementalist;
import bi.team.heroes.Hero;
import bi.team.heroes.Swordsman;
import bi.team.heroes.Warlock;
import bi.team.heroes.attacks.Attack;
import bi.team.inventory.InventoryFrame;
import bi.team.map.Map;
import bi.team.map.MapEntry;

@SuppressWarnings("serial")
public class Game extends JFrame implements ActionListener {

	/*
	 * initialize variables
	 */
	private static boolean turn = true; 	// true for player's turn. false for enemy's turn
	private JPanel contentPane;
	private JPanel panel_player;
	private JPanel panel_top;
	private JPanel panel_stats;
	private JPanel panel_enemy;
	private JPanel panel_actions;
	private JPanel panel_frameOpacity;
	private JPanel panel_actionsTop;
	private JProgressBar progBar_loading;
	private JProgressBar progBar_playerVitality;
	private JProgressBar progBar_enemyVitality;
	private JProgressBar progBar_playerEnergy;
	private static JTextArea textArea;
	private JButton btnShowMap;
	private JButton btnShowInventory;
	private boolean isMapShown;
	private boolean isInvShown;
	private Map map;
	private InventoryFrame inventory;
	private Hero hero;
	private Enemy curEnemy;
	private JLabel upgradePoints;
	private JProgressBar progBar_enemyEnergy;

	// create the frame
	public Game(String name, String chosenHero, int giftNum) {
	
		// TODO init gift parameter
		
		// instantiate objects
		UIManager.put("ProgressBar.selectionForeground", Color.darkGray);
		
		/*
		 * build frame
		 */
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 1000, 600);
		setTitle("BeyondInfinity - alpha");
		getContentPane().setLayout(null);

		// create a root panel
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBounds(0, 0, 994, 571);
		contentPane.setBackground(new Color(236, 240, 241));
		contentPane.setOpaque(true);
		getContentPane().add(contentPane);

		/*
		 * create the map object/frame
		 */
		map = new Map(getWidth(), getHeight());
		contentPane.add(map);
		
		/*
		 * create the inventory panel
		 */
		inventory = new InventoryFrame(getWidth(), getHeight());
		contentPane.add(inventory);
		
		// create a panel that dims the frame, this is used when toggling map
		panel_frameOpacity = new JPanel();
		panel_frameOpacity.setBounds(0, 11, 994, 19);
		panel_frameOpacity.setBackground(new Color(0, 0, 0, 64));
		panel_frameOpacity.setOpaque(true);
		panel_frameOpacity.setVisible(false);
		contentPane.add(panel_frameOpacity);

		// create left panel for displaying hero info
		panel_player = new JPanel();
		panel_player.setBackground(new Color(204, 255, 153));
		panel_player.setBounds(10, 70, 212, 283);
		panel_player.setLayout(null);
		contentPane.add(panel_player);

		// create top panel to display vitality (health) bars
		panel_top = new JPanel();
		panel_top.setBounds(10, 21, 974, 38);
		panel_top.setLayout(null);
		contentPane.add(panel_top);

		// create the button that toggles map
		btnShowMap = new JButton();
		btnShowMap.setBounds(936, 0, 38, 38);
		btnShowMap.setFocusable(false);
		btnShowMap.setIcon(new ImageIcon(getClass().getResource("/images/map.png")));
		btnShowMap.addActionListener(this);
		panel_top.add(btnShowMap);
		
		// create the button that toggles inventory
		btnShowInventory = new JButton("");
		btnShowInventory.setIcon(new ImageIcon(Game.class.getResource("/images/knapsack.png")));
		btnShowInventory.setBounds(0, 0, 38, 38);
		btnShowInventory.setFocusable(false);
		btnShowInventory.addActionListener(this);
		panel_top.add(btnShowInventory);

		// create bottom panel to display buttons for upgrades
		panel_stats = new JPanel();
		panel_stats.setBounds(10, 364, 974, 87);
		panel_stats.setLayout(new GridLayout(0, 5, 0, 0));
		contentPane.add(panel_stats);

		// create right panel for displaying enemy info
		panel_enemy = new JPanel();
		panel_enemy.setBackground(new Color(204, 255, 153));
		panel_enemy.setBounds(772, 70, 212, 283);
		panel_enemy.setLayout(null);
		contentPane.add(panel_enemy);

		// create actions panel for displaying attack buttons
		panel_actions = new JPanel();
		panel_actions.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel_actions.setBounds(10, 492, 974, 68);
		panel_actions.setBackground(new Color(135, 211, 124));
		panel_actions.setLayout(new GridLayout(0, 6, 10, 0));
		contentPane.add(panel_actions);

		// create the loading bar
		progBar_loading = new JProgressBar();
		progBar_loading.setBounds(0, 0, 994, 10);
		progBar_loading.setBorder(null);
		progBar_loading.setValue(100);
		progBar_loading.setForeground(new Color(52, 73, 94));
		contentPane.add(progBar_loading);

		// create the player's vitality (health) bar
		progBar_playerVitality = new JProgressBar();
		progBar_playerVitality.setFont(new Font("Tahoma", Font.PLAIN, 11));
		progBar_playerVitality.setStringPainted(true);
		progBar_playerVitality.setBounds(11, 11, 189, 18);
		progBar_playerVitality.setBorder(new LineBorder(new Color(0, 0, 0)));
		progBar_playerVitality.setForeground(new Color(30, 139, 195));
		progBar_playerVitality.setString(progBar_playerVitality.getValue() + " / " + progBar_playerVitality.getMaximum());
		panel_player.add(progBar_playerVitality);

		// create progress bar to display the enemy's vitality (health)
		progBar_enemyVitality = new JProgressBar();
		progBar_enemyVitality.setFont(new Font("Tahoma", Font.PLAIN, 11));
		progBar_enemyVitality.setStringPainted(true);
		progBar_enemyVitality.setBounds(11, 11, 189, 18);
		progBar_enemyVitality.setBorder(new LineBorder(new Color(0, 0, 0)));
		progBar_enemyVitality.setForeground(new Color(236, 100, 75));
		//progBar_enemyVitality.setValue((int) boss.getTotalHealth());
		panel_enemy.add(progBar_enemyVitality);

		// create label to display enemy's name
		JLabel lbl_enemyName = new JLabel(" name");
		lbl_enemyName.setBounds(11, 50, 189, 20);
		panel_enemy.add(lbl_enemyName);

		// create the enemy's picture
		JLabel lbl_enemyImage = new JLabel("");
		lbl_enemyImage.setBounds(10, 75, 189, 197);
		panel_enemy.add(lbl_enemyImage);
		
		// create the enemy's energy bar
		progBar_enemyEnergy = new JProgressBar();
		progBar_enemyEnergy.setFont(new Font("Tahoma", Font.PLAIN, 11));
		progBar_enemyEnergy.setStringPainted(true);
		progBar_enemyEnergy.setForeground(Color.YELLOW);
		progBar_enemyEnergy.setBorder(new EmptyBorder(1, 1, 1, 1));
		progBar_enemyEnergy.setBounds(11, 31, 189, 16);
		progBar_enemyEnergy.setValue(100);
		panel_enemy.add(progBar_enemyEnergy);

		// create label to display player's name
		JLabel lbl_playerName = new JLabel(name);
		lbl_playerName.setBounds(11, 50, 189, 20);
		panel_player.add(lbl_playerName);

		// create the player's picture
		JLabel lbl_playerImage = new JLabel("");
		lbl_playerImage.setBounds(10, 75, 189, 197);
		panel_player.add(lbl_playerImage);

		// create the player's energy bar
		progBar_playerEnergy = new JProgressBar();
		progBar_playerEnergy.setBorder(new EmptyBorder(1, 1, 1, 1));
		progBar_playerEnergy.setFont(new Font("Tahoma", Font.PLAIN, 11));
		progBar_playerEnergy.setStringPainted(true);
		progBar_playerEnergy.setForeground(Color.YELLOW);
		progBar_playerEnergy.setBounds(11, 31, 189, 16);
		progBar_playerEnergy.setString(""); // TODO
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
		scroll.setBounds(232, 70, 530, 283);
		scroll.setBorder(null);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(scroll);	
		
		/*
		 * create the top actions panel
		 */
		panel_actionsTop = new JPanel();
		panel_actionsTop.setBounds(10, 462, 974, 30);
		contentPane.add(panel_actionsTop);
		panel_actionsTop.setLayout(null);
		
		// create label for upgrade points
		JLabel lblUpgradePoints = new JLabel("Upgrade Points:");
		lblUpgradePoints.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblUpgradePoints.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUpgradePoints.setBounds(437, 7, 100, 16);
		panel_actionsTop.add(lblUpgradePoints);
		
		// create label to display upgrade points
		upgradePoints = new JLabel("1");
		upgradePoints.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		upgradePoints.setBounds(547, 7, 46, 16);
		panel_actionsTop.add(upgradePoints);
		
		JPanel panel_rage = new JPanel();
		panel_rage.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Rage", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_rage.setLayout(null);

		// create rage icon
		JLabel lblRageIcon = new JLabel("");
		lblRageIcon.setBounds(5, 16, 24, 24);
		lblRageIcon.setIcon(new ImageIcon(Game.class.getResource("/images/rage.png")));
		panel_rage.add(lblRageIcon);
		
		/*
		 * create the player object
		 */
		if (chosenHero.equals("swordsman"))
			hero = new Swordsman(this);
		else if (chosenHero.equals("elementalist"))
			hero = new Elementalist(this);
		else if (chosenHero.equals("alchemist"))
			hero = new Alchemist(this);
		else if (chosenHero.equals("brutalizer"))
			hero = new Brutalizer(this);
		else if (chosenHero.equals("warlock"))
			hero = new Warlock(this);
		else
			System.out.println("[Game.java] Could not create your class");
		
		// finally show frame
		setVisible(true);
		
		// start game
		startFight();
		
	}
	
	/*
	 * FIGHT METHODS *********************************************
	 */
	
	// start enemy fight
	public void startFight() {

		for(MapEntry x : map.getMapEntries()) {			
			if (x.getBoss().isAlive()) {
				curEnemy = x.getBoss();
				appendMessage("Now facing -> " + curEnemy.getName() + ".");
				turn = true;
				break;
			}	
		}
		
		// TODO load boss icon & health
		
		enableAttackButtons();
		
	}	

	// END OF FIGHT METHODS *************************************
	
	// XXX add upgradable stats panels to gui
	public void addUpgradableStats(JPanel panel1, JPanel panel2, JPanel panel3, JPanel panel4, JPanel panel5) {
		panel_stats.add(panel1);
		panel_stats.add(panel2);
		panel_stats.add(panel3);
		panel_stats.add(panel4);
		panel_stats.add(panel5);
	}
	
	// action listener
	public void actionPerformed(ActionEvent evt) {
		
		// clicked map
		if (evt.getSource() == btnShowMap)
			toggleMap();
		// clicked inventory
		if (evt.getSource() == btnShowInventory)
			toggleInventory();
			
		// check if any attacks were clicked
		for (Attack x : hero.getAttacksArrayList()) {
			if (evt.getSource() == x.getButton()) {
				if (x.isAvailable()) {
					// TODO attack is clicked				
				}
				break;
			}
		}

	}

	// toggle the map pane
	public void toggleMap() {

		// toggle between true and false
		isMapShown = !isMapShown;

		if (isMapShown) {
			map.setVisible(true);
			panel_frameOpacity.setVisible(true);
			disableAttackButtons();
			hero.disableUpgradeButtons();
		} else {
			map.setVisible(false);
			panel_frameOpacity.setVisible(false);
			enableAttackButtons();
			hero.enableUpgradeButtons();
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
			hero.disableUpgradeButtons();
		} else {
			inventory.setVisible(false);
			panel_frameOpacity.setVisible(false);
			enableAttackButtons();
			hero.enableUpgradeButtons();
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

	// append a message to the middle display area
	public static void appendMessage(String s) {
		textArea.append("> " + s + "\n");
	}

	// set value for the loading bar
	public void setProgBar_loading(int val) {
		progBar_loading.setValue(val);
	}

	// return the current turn
	public static boolean getTurn() {
		return turn;
	}
	
	// return the panel_actions jpanel
	public JPanel getPanel_actions() {
		return panel_actions;
	}
	
	// return the panel_actionsTop
	public JPanel getPanel_actionsTop() {
		return panel_actionsTop;
	}

	// return the player
	public Hero getHero() {
		return hero;
	}

	// change turn to the other
	// true for player's turn. false for enemy's turn
	public static void toggleTurn() {
		turn = !turn;
	}
}
