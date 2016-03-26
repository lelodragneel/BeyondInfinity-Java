package bi.team;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import java.awt.Insets;

@SuppressWarnings("serial")
public class Game extends JFrame implements ActionListener {

	// init variables
	private static int kills;
	// true for player's turn. false for enemy's turn
	private static boolean turn = true;
	private JPanel contentPane;
	private JPanel panel_left;
	private JPanel panel_top;
	private JPanel panel_bottom;
	private JPanel panel_right;
	private JPanel panel_actions;
	private Attack attack_strike;
	private Attack attack_rejuvenate;
	private Attack attack_heroicStrike;
	private Attack attack_evade;
	private Attack attack_toxicSpit;
	private Attack attack_annihilate;
	private JProgressBar progBar_loading;
	private JProgressBar progBar_playerHealth;
	private JProgressBar progBar_enemyHealth;
	private JLabel lbl_playerName;
	private JLabel lbl_enemyName;
	private JLabel lbl_playerImage;
	private JLabel lbl_enemyImage;
	private JTextArea textArea;
	private String playerName;

	private Load load;

	// create the frame
	public Game(String name) {

		// instantiate objects
		load = new Load(this);
		playerName = name;

		// frame initializing
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 890, 480);
		setTitle("BeyondInfinity - by Lelo");
		getContentPane().setLayout(null);

		// create a root panel
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBounds(0, 0, 884, 451);
		contentPane.setBackground(new Color(236, 240, 241));
		getContentPane().add(contentPane);

		// create left panel for displaying hero info
		panel_left = new JPanel();
		panel_left.setBackground(new Color(204, 255, 153));
		panel_left.setBounds(10, 59, 209, 236);
		panel_left.setLayout(null);
		contentPane.add(panel_left);

		// create top panel to display health bars
		panel_top = new JPanel();
		panel_top.setBounds(10, 23, 854, 27);
		panel_top.setLayout(null);
		contentPane.add(panel_top);

		// create bottom panel to display buttons for upgrades
		panel_bottom = new JPanel();
		panel_bottom.setBounds(10, 391, 854, 39);
		contentPane.add(panel_bottom);

		// create right panel for displaying enemy info
		panel_right = new JPanel();
		panel_right.setBackground(new Color(204, 255, 153));
		panel_right.setBounds(655, 59, 209, 236);
		panel_right.setLayout(null);
		contentPane.add(panel_right);

		// create actions panel for displaying attack buttons
		panel_actions = new JPanel();
		panel_actions.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel_actions.setBounds(10, 306, 864, 68);
		panel_actions.setBackground(new Color(135, 211, 124));
		panel_actions.setLayout(new GridLayout(0, 6, 10, 0));
		contentPane.add(panel_actions);

		// create attack button #1
		attack_strike = new Attack(new JButton("Strike"));
		attack_strike.getButton().setFocusable(false);
		attack_strike.getButton().setMargin(new Insets(0, 0, 0, 0));
		attack_strike.getButton().add(new MyGraphics(attack_strike));
		attack_strike.getButton().addActionListener(this);
		panel_actions.add(attack_strike.getButton());

		// create attack button #2
		attack_rejuvenate = new Attack(new JButton("Rejuvenate"));
		attack_rejuvenate.getButton().setFocusable(false);
		attack_rejuvenate.getButton().setMargin(new Insets(0, 0, 0, 0));
		attack_rejuvenate.getButton().add(new MyGraphics(attack_rejuvenate));
		attack_rejuvenate.getButton().addActionListener(this);
		panel_actions.add(attack_rejuvenate.getButton());

		// create attack button #3
		attack_heroicStrike = new Attack(new JButton("Heroic Strike"));
		attack_heroicStrike.getButton().setFocusable(false);
		attack_heroicStrike.getButton().setMargin(new Insets(0, 0, 0, 0));
		attack_heroicStrike.getButton().add(new MyGraphics(attack_heroicStrike));
		attack_heroicStrike.getButton().addActionListener(this);
		panel_actions.add(attack_heroicStrike.getButton());

		// create attack button #4
		attack_evade = new Attack(new JButton("Evade"));
		attack_evade.getButton().setFocusable(false);
		attack_evade.getButton().setMargin(new Insets(0, 0, 0, 0));
		attack_evade.getButton().add(new MyGraphics(attack_evade));
		attack_evade.getButton().addActionListener(this);
		panel_actions.add(attack_evade.getButton());

		// create attack button #5
		attack_toxicSpit = new Attack(new JButton("Toxic Spit"));
		attack_toxicSpit.getButton().setFocusable(false);
		attack_toxicSpit.getButton().setMargin(new Insets(0, 0, 0, 0));
		attack_toxicSpit.getButton().add(new MyGraphics(attack_toxicSpit));
		attack_toxicSpit.getButton().addActionListener(this);
		panel_actions.add(attack_toxicSpit.getButton());

		// create attack button #6
		attack_annihilate = new Attack(new JButton("Annihilate"));
		attack_annihilate.getButton().setFocusable(false);
		attack_annihilate.getButton().setMargin(new Insets(0, 0, 0, 0));
		attack_annihilate.getButton().add(new MyGraphics(attack_annihilate));
		attack_annihilate.getButton().addActionListener(this);
		panel_actions.add(attack_annihilate.getButton());

		// create the loading bar
		progBar_loading = new JProgressBar();
		progBar_loading.setBounds(0, 0, 884, 10);
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
		panel_left.add(progBar_playerHealth);

		// create progress bar to display the enemy's health
		progBar_enemyHealth = new JProgressBar();
		progBar_enemyHealth.setBounds(10, 11, 189, 15);
		progBar_enemyHealth.setBorder(null);
		progBar_enemyHealth.setForeground(new Color(236, 100, 75));
		progBar_enemyHealth.setBorderPainted(false);
		progBar_enemyHealth.setValue(100);
		panel_right.add(progBar_enemyHealth);

		// create label to display enemy's name
		lbl_enemyName = new JLabel(" name");
		lbl_enemyName.setBounds(10, 25, 189, 20);
		panel_right.add(lbl_enemyName);

		// create the enemy's picture
		lbl_enemyImage = new JLabel("");
		lbl_enemyImage.setBounds(10, 56, 189, 169);
		panel_right.add(lbl_enemyImage);

		// create label to display player's name
		lbl_playerName = new JLabel(playerName);
		lbl_playerName.setBounds(10, 25, 189, 20);
		panel_left.add(lbl_playerName);

		// create the player's picture
		lbl_playerImage = new JLabel("");
		lbl_playerImage.setBounds(10, 56, 189, 169);
		panel_left.add(lbl_playerImage);

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

		// finally show frame
		setVisible(true);

	}

	// create action listener
	public void actionPerformed(ActionEvent evt) {

		if (evt.getSource().equals(attack_strike.getButton())) {
			activateAttack(attack_strike);
		} else if (evt.getSource().equals(attack_rejuvenate.getButton())) {
			activateAttack(attack_rejuvenate);
		} else if (evt.getSource().equals(attack_heroicStrike.getButton())) {
			activateAttack(attack_heroicStrike);
		} else if (evt.getSource().equals(attack_evade.getButton())) {
			activateAttack(attack_evade);
		} else if (evt.getSource().equals(attack_toxicSpit.getButton())) {
			activateAttack(attack_toxicSpit);
		} else if (evt.getSource().equals(attack_annihilate.getButton())) {
			activateAttack(attack_annihilate);
		}
	}

	// check if button has sufficient energy to be activated
	public void activateAttack(Attack attack) {
		if (attack.activate())
			load.start(attack.getButton());
	}

	// add 5 energy for each button
	// (this is called when hit by enemy, once per turn)
	public void regenerateButtons() {
		attack_strike.regenerate();
		attack_rejuvenate.regenerate();
		attack_heroicStrike.regenerate();
		attack_evade.regenerate();
		attack_toxicSpit.regenerate();
		attack_annihilate.regenerate();
	}

	// enemy takes damage
	public void attackEnemy(JButton button) {
		appendMessage("enemy took x damage");

		// TODO enemy health takes damage

		// toggle turns then let enemy attack you
		Game.toggleTurn();
		load.start(null);
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
		attack_strike.getButton().setEnabled(false);
		attack_rejuvenate.getButton().setEnabled(false);
		attack_heroicStrike.getButton().setEnabled(false);
		attack_evade.getButton().setEnabled(false);
		attack_toxicSpit.getButton().setEnabled(false);
		attack_annihilate.getButton().setEnabled(false);
	}

	// set all attack buttons to active
	public void enableButtons() {
		attack_strike.getButton().setEnabled(true);
		attack_rejuvenate.getButton().setEnabled(true);
		attack_heroicStrike.getButton().setEnabled(true);
		attack_evade.getButton().setEnabled(true);
		attack_toxicSpit.getButton().setEnabled(true);
		attack_annihilate.getButton().setEnabled(true);
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
		if (turn)
			turn = false;
		else
			turn = true;
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
