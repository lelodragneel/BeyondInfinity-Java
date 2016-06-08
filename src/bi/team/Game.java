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
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

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
	private static boolean turn = true; 	// true for player's turn. false for enemy's turn
	private static JTextArea textArea;
	private JPanel panel_player;
	private JPanel panel_top;
	private JPanel panel_stats;
	private JPanel panel_enemy;
	private JPanel panel_actions;
	private JPanel panel_frameOpacity;
	private JProgressBar progBar_loading;
	private JProgressBar progBar_playerVitality;
	private JProgressBar progBar_enemyVitality;
	private JButton btnShowMap;
	private JButton btnShowInventory;
	private boolean isMapShown;
	private boolean isInvShown;
	private Map map;
	private InventoryFrame inventory;
	private Hero hero;
	private JPanel panel_areaField;
	private JLabel areaWallpaper;
	private JLabel upgradePoints;
	private JLabel label_1;
	
	// create the frame
	public Game(String name, String chosenHero, int giftNum) {

		// TODO initialize gift parameter

		// instantiate objects
		UIManager.put("ProgressBar.selectionForeground", Color.darkGray);

		/*
		 * build frame
		 */
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 1070, 700);
		this.setTitle("[ver. alpha] BeyondInfinity");
		this.getContentPane().setLayout(null);
		this.setBounds(0, 0, 1070, 650);
		this.setBackground(new Color(236, 240, 241));
		this.setLocationRelativeTo(null);
		
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
		panel_frameOpacity.setBounds(0, 0, 1064, 45);
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
		panel_actions.setBounds(10, 542, 1044, 68);
		panel_actions.setBackground(new Color(135, 211, 124));
		panel_actions.setLayout(new GridLayout(0, 6, 10, 0));
		getContentPane().add(panel_actions);

		// create the loading bar
		progBar_loading = new JProgressBar();
		progBar_loading.setBounds(0, 0, 1064, 10);
		progBar_loading.setBorder(null);
		progBar_loading.setValue(100);
		progBar_loading.setForeground(new Color(52, 73, 94));
		getContentPane().add(progBar_loading);

		// create heart for health bar
		JLabel lblHp = new JLabel("HP");
		lblHp.setForeground(Color.WHITE);
		lblHp.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblHp.setBounds(12, 11, 20, 14);
		panel_player.add(lblHp);

		JLabel lblHeart = new JLabel("");
		lblHeart.setIcon(new ImageIcon(Game.class.getResource("/images/heart.png")));
		lblHeart.setBounds(3, 3, 32, 32);
		panel_player.add(lblHeart);

		// create the player's vitality (health) bar
		progBar_playerVitality = new JProgressBar();
		progBar_playerVitality.setFont(new Font("Tahoma", Font.PLAIN, 11));
		progBar_playerVitality.setStringPainted(true);
		progBar_playerVitality.setBounds(14, 11, 204, 16);
		progBar_playerVitality.setBorder(new LineBorder(new Color(0, 0, 0)));
		progBar_playerVitality.setForeground(new Color(30, 139, 195));
		panel_player.add(progBar_playerVitality);

		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Game.class.getResource("/images/heart.png")));
		label_1.setBounds(3, 3, 32, 32);
		panel_enemy.add(label_1);

		// create progress bar to display the enemy's vitality (health)
		progBar_enemyVitality = new JProgressBar();
		progBar_enemyVitality.setFont(new Font("Tahoma", Font.PLAIN, 11));
		progBar_enemyVitality.setStringPainted(true);
		progBar_enemyVitality.setBounds(14, 11, 205, 16);
		progBar_enemyVitality.setBorder(new LineBorder(new Color(0, 0, 0)));
		progBar_enemyVitality.setForeground(new Color(236, 100, 75));
		//progBar_enemyVitality.setValue((int) boss.getTotalHealth());
		panel_enemy.add(progBar_enemyVitality);

		// create label to display enemy's name
		JLabel lbl_enemyName = new JLabel(" name");
		lbl_enemyName.setBounds(13, 46, 189, 20);
		panel_enemy.add(lbl_enemyName);

		// create panel displaying background area and player images
		panel_areaField = new JPanel();
		panel_areaField.setBounds(10, 70, 1044, 333);
		panel_areaField.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(panel_areaField);
		panel_areaField.setLayout(null);
		
		areaWallpaper = new JLabel();
		areaWallpaper.setBounds(0, 0, 1044, 333);
		panel_areaField.add(areaWallpaper);
		areaWallpaper.setIcon(new ImageIcon(getClass().getResource("/images/areas/meadowlands.jpg")));

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
		
		// create the area which displays event changes
		textArea = new JTextArea(0, 0);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setBorder(new EmptyBorder(4, 4, 4, 4));
		textArea.setFont(new Font("Comic Sans MS", 0, 12));
		textArea.setBackground(new Color(218, 223, 225));
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(249, 70, 567, 283);
		scroll.setBorder(null);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		getContentPane().add(scroll);
		
		/*
		 * create the player object
		 */
		if (chosenHero.equals("swordsman"))
			hero = new Swordsman(this);
		else if (chosenHero.equals("elementalist"))
			hero = new Elementalist(this);
		else if (chosenHero.equals("chemist"))
			hero = new Chemist(this);
		else if (chosenHero.equals("barbarian"))
			hero = new Barbarian(this);
		else if (chosenHero.equals("warlock"))
			hero = new Warlock(this);
		else
			System.out.println("[Game.java] Could not create your class");
		
		// finally show frame
		setVisible(true);

		/*
		 * start game.
		 * loop and find first alive enemy
		 */
		//		for(MapEntry x : map.getMapEntries()) {			
		//			if (x.getBoss().isAlive()) {
		//				curEnemy = x.getBoss();
		//				appendMessage("Now facing -> " + curEnemy.getName() + ".");
		//				turn = true;
		//				faceEnemy(curEnemy);
		//				break;
		//			}	
		//		}

	}

	/*
	 * FIGHT METHODS *********************************************
	 */

	// start enemy fight
	//	public void faceEnemy(Enemy enemy) {
	//
	//		
	//		
	//		// TODO load boss icon & health
	//		
	//		enableAttackButtons();
	//		
	//	}	

	// END OF FIGHT METHODS *************************************

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

	// append a message to the middle display area
	public static void appendMessage(String s) {
		textArea.append("> " + s + "\n");
	}
	
	// return the panel_stats
	public JPanel getPanel_stats() {
		return panel_stats;
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

	// return the panel_player
	public JPanel getPanel_player() {
		return panel_player;
	}

	// return the player
	public Hero getHero() {
		return hero;
	}

	// return the progBar_playerVitality
	public JProgressBar getProgBar_playerVitality() {
		return progBar_playerVitality;
	}

	// return the upgradePoints
	public JLabel getUpgradePoints() {
		return upgradePoints;
	}

	// set the upgradePoints
	public void setUpgradePoints(JLabel upgradePoints) {
		this.upgradePoints = upgradePoints;
	}

	// change turn to the other
	// true for player's turn. false for enemy's turn
	public static void toggleTurn() {
		turn = !turn;
	}
}
