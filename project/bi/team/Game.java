package bi.team;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.Box;

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
	private JPanel panel_middle;
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

	// create the frame
	public Game() {

		// frame initializing
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 890, 480);
		setTitle("BeyondInfinity - Group Project for CS1100");
		setVisible(true);
		getContentPane().setLayout(null);

		// create a root panel
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBounds(0, 0, 884, 451);
		getContentPane().add(contentPane);

		// create left panel for displaying hero info
		panel_left = new JPanel();
		panel_left.setBackground(new Color(143, 188, 143));
		panel_left.setBounds(10, 59, 209, 236);
		contentPane.add(panel_left);
		panel_left.setLayout(null);

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
		panel_right.setBackground(new Color(255, 160, 122));
		panel_right.setBounds(655, 59, 209, 236);
		contentPane.add(panel_right);
		panel_right.setLayout(null);

		// create middle panel for displaying output event changes
		panel_middle = new JPanel();
		panel_middle.setBounds(229, 59, 416, 236);
		contentPane.add(panel_middle);

		// create actions panel for displaying attack buttons
		panel_actions = new JPanel();
		panel_actions.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel_actions.setBounds(10, 306, 854, 68);
		panel_actions.setBackground(new Color(100, 149, 237));
		panel_actions.setLayout(new GridLayout(0, 6, 10, 0));
		contentPane.add(panel_actions);

		// create attack button #1
		btn_Strike = new JButton("Strike");
		btn_Strike.setFocusable(false);
		panel_actions.add(btn_Strike);

		// create attack button #2
		btn_Rejuvenate = new JButton("Rejuvenate");
		btn_Rejuvenate.setFocusable(false);
		panel_actions.add(btn_Rejuvenate);

		// create attack button #3
		btn_HeroicStrike = new JButton("Heroic Strike");
		btn_HeroicStrike.setFocusable(false);
		panel_actions.add(btn_HeroicStrike);

		// create attack button #4
		btn_Evade = new JButton("Evade");
		btn_Evade.setFocusable(false);
		panel_actions.add(btn_Evade);

		// create attack button #5
		btn_ToxicSpit = new JButton("Toxic Spit");
		btn_ToxicSpit.setFocusable(false);
		panel_actions.add(btn_ToxicSpit);

		// create attack button #6
		btn_Annihilate = new JButton("Annihilate");
		btn_Annihilate.setFocusable(false);
		panel_actions.add(btn_Annihilate);

		// create the loading bar
		progBar_loading = new JProgressBar();
		progBar_loading.setBounds(0, 0, 884, 12);
		progBar_loading.setBorder(null);
		contentPane.add(progBar_loading);

		// create the player's health bar
		progBar_playerHealth = new JProgressBar();
		progBar_playerHealth.setBounds(10, 11, 189, 14);
		panel_left.add(progBar_playerHealth);

		// create
		progBar_enemyHealth = new JProgressBar();
		progBar_enemyHealth.setBounds(10, 11, 189, 14);
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
		lbl_playerName = new JLabel(" name");
		lbl_playerName.setBounds(10, 25, 189, 20);
		panel_left.add(lbl_playerName);

		// create the player's picture
		lbl_playerImage = new JLabel("");
		lbl_playerImage.setBounds(10, 56, 189, 169);
		panel_left.add(lbl_playerImage);

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
