package bi.team;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Game extends JFrame {

	// init variables
	private static int kills;
	private static boolean turn;
	private JPanel contentPane;
	private JPanel panel_left;
	private JPanel panel_top;
	private JPanel panel_bottom;
	private JPanel panel_right;
	private JPanel panel_actions;
	private JButton btn_Strike;
	private JButton btn_Rejuvenate;
	private JButton btn_HeroicStrike;
	private JButton btn_Evade;
	private JButton btn_ToxicSpit;
	private JButton btn_Annihilate;
	private JProgressBar progBar_loading;
	private JProgressBar progBar_playerHealth;
	private JProgressBar progBar_enemyHealth;
	private JLabel lbl_playerName;
	private JLabel lbl_enemyName;
	private JLabel lbl_playerImage;
	private JLabel lbl_enemyImage;
	private JTextArea textArea;

	// create the frame
	public Game() {

		// frame initializing
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 890, 480);
		setTitle("BeyondInfinity - Group Project for CS1100");
		getContentPane().setLayout(null);
		setVisible(true);

		// create a root panel
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBounds(0, 0, 884, 451);
		contentPane.setVisible(true);
		getContentPane().add(contentPane);

		// create left panel for displaying hero info
		panel_left = new JPanel();
		panel_left.setBackground(new Color(143, 188, 143));
		panel_left.setBounds(10, 59, 209, 236);
		panel_left.setLayout(null);
		panel_left.setVisible(true);
		contentPane.add(panel_left);

		// create top panel to display health bars
		panel_top = new JPanel();
		panel_top.setBounds(10, 23, 854, 27);
		panel_top.setLayout(null);
		panel_top.setVisible(true);
		contentPane.add(panel_top);

		// create bottom panel to display buttons for upgrades
		panel_bottom = new JPanel();
		panel_bottom.setBounds(10, 391, 854, 39);
		panel_bottom.setVisible(true);
		contentPane.add(panel_bottom);

		// create right panel for displaying enemy info
		panel_right = new JPanel();
		panel_right.setBackground(new Color(255, 160, 122));
		panel_right.setBounds(655, 59, 209, 236);
		panel_right.setLayout(null);
		panel_right.setVisible(true);
		contentPane.add(panel_right);

		// create actions panel for displaying attack buttons
		panel_actions = new JPanel();
		panel_actions.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel_actions.setBounds(10, 306, 854, 68);
		panel_actions.setBackground(new Color(100, 149, 237));
		panel_actions.setLayout(new GridLayout(0, 6, 10, 0));
		panel_actions.setVisible(true);
		contentPane.add(panel_actions);

		// create attack button #1
		btn_Strike = new JButton("Strike");
		btn_Strike.setFocusable(false);
		btn_Strike.setVisible(true);
		panel_actions.add(btn_Strike);

		// create attack button #2
		btn_Rejuvenate = new JButton("Rejuvenate");
		btn_Rejuvenate.setFocusable(false);
		btn_Rejuvenate.setVisible(true);
		panel_actions.add(btn_Rejuvenate);

		// create attack button #3
		btn_HeroicStrike = new JButton("Heroic Strike");
		btn_HeroicStrike.setFocusable(false);
		btn_HeroicStrike.setVisible(true);
		panel_actions.add(btn_HeroicStrike);

		// create attack button #4
		btn_Evade = new JButton("Evade");
		btn_Evade.setFocusable(false);
		btn_Evade.setVisible(true);
		panel_actions.add(btn_Evade);

		// create attack button #5
		btn_ToxicSpit = new JButton("Toxic Spit");
		btn_ToxicSpit.setFocusable(false);
		btn_ToxicSpit.setVisible(true);
		panel_actions.add(btn_ToxicSpit);

		// create attack button #6
		btn_Annihilate = new JButton("Annihilate");
		btn_Annihilate.setFocusable(false);
		btn_Annihilate.setVisible(true);
		panel_actions.add(btn_Annihilate);

		// create the loading bar
		progBar_loading = new JProgressBar();
		progBar_loading.setBounds(0, 0, 884, 12);
		progBar_loading.setBorder(null);
		progBar_loading.setVisible(true);
		contentPane.add(progBar_loading);

		// create the player's health bar
		progBar_playerHealth = new JProgressBar();
		progBar_playerHealth.setBounds(10, 11, 189, 14);
		progBar_playerHealth.setVisible(true);
		panel_left.add(progBar_playerHealth);

		// create progress bar to display the enemy's health
		progBar_enemyHealth = new JProgressBar();
		progBar_enemyHealth.setBounds(10, 11, 189, 14);
		progBar_enemyHealth.setVisible(true);
		panel_right.add(progBar_enemyHealth);

		// create label to display enemy's name
		lbl_enemyName = new JLabel(" name");
		lbl_enemyName.setBounds(10, 25, 189, 20);
		lbl_enemyName.setVisible(true);
		panel_right.add(lbl_enemyName);

		// create the enemy's picture
		lbl_enemyImage = new JLabel("");
		lbl_enemyImage.setBounds(10, 56, 189, 169);
		lbl_enemyImage.setVisible(true);
		panel_right.add(lbl_enemyImage);

		// create label to display player's name
		lbl_playerName = new JLabel(" name");
		lbl_playerName.setBounds(10, 25, 189, 20);
		lbl_playerName.setVisible(true);
		panel_left.add(lbl_playerName);

		// create the player's picture
		lbl_playerImage = new JLabel("");
		lbl_playerImage.setBounds(10, 56, 189, 169);
		lbl_playerImage.setVisible(true);
		panel_left.add(lbl_playerImage);

		// create the area which displays event changes
		textArea = new JTextArea(0, 0);
		textArea.setEditable(false);
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(229, 59, 416, 236);
		contentPane.add(scroll);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		// test
		appendMessage("hi");
		appendMessage("hi again");
		appendMessage("hi");
		appendMessage("hi again");

	}

	// append a message to the middle display area
	public void appendMessage(String s) {
		textArea.append(" > " + s + "\n");
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
	public static void toggleTurn() {
		Game.turn = !turn;
	}
}
