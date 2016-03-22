package bi.team;

import java.awt.Color;
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

@SuppressWarnings("serial")
public class Game extends JFrame implements ActionListener {

	// init variables
	private static int kills;
	private static boolean turn;
	private JPanel contentPane;
	private JPanel panel_left;
	private JPanel panel_top;
	private JPanel panel_bottom;
	private JPanel panel_right;
	private JPanel panel_actions;
	private static JButton btn_strike;
	private static JButton btn_rejuvenate;
	private static JButton btn_heroicStrike;
	private static JButton btn_evade;
	private static JButton btn_toxicSpit;
	private static JButton btn_annihilate;
	private static JProgressBar progBar_loading;

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
		btn_strike = new JButton("Strike");
		btn_strike.setFocusable(false);
		btn_strike.setVisible(true);
		btn_strike.addActionListener(this);
		panel_actions.add(btn_strike);

		// create attack button #2
		btn_rejuvenate = new JButton("Rejuvenate");
		btn_rejuvenate.setFocusable(false);
		btn_rejuvenate.setVisible(true);
		btn_rejuvenate.addActionListener(this);
		panel_actions.add(btn_rejuvenate);

		// create attack button #3
		btn_heroicStrike = new JButton("Heroic Strike");
		btn_heroicStrike.setFocusable(false);
		btn_heroicStrike.setVisible(true);
		btn_heroicStrike.addActionListener(this);
		panel_actions.add(btn_heroicStrike);

		// create attack button #4
		btn_evade = new JButton("Evade");
		btn_evade.setFocusable(false);
		btn_evade.setVisible(true);
		btn_evade.addActionListener(this);
		panel_actions.add(btn_evade);

		// create attack button #5
		btn_toxicSpit = new JButton("Toxic Spit");
		btn_toxicSpit.setFocusable(false);
		btn_toxicSpit.setVisible(true);
		btn_toxicSpit.addActionListener(this);
		panel_actions.add(btn_toxicSpit);

		// create attack button #6
		btn_annihilate = new JButton("Annihilate");
		btn_annihilate.setFocusable(false);
		btn_annihilate.setVisible(true);
		btn_annihilate.addActionListener(this);
		panel_actions.add(btn_annihilate);

		// create the loading bar
		progBar_loading = new JProgressBar();
		progBar_loading.setBounds(0, 0, 884, 12);
		progBar_loading.setBorder(null);
		progBar_loading.setValue(100);
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
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(scroll);

	}

	// create action listener
	public void actionPerformed(ActionEvent evt) {

		if (evt.getSource().equals(btn_strike)) {
			appendMessage("clicked strike");
			startLoading();
		} else if (evt.getSource().equals(btn_rejuvenate)) {
			appendMessage("clicked rejuvenate");
			startLoading();
		} else if (evt.getSource().equals(btn_heroicStrike)) {
			appendMessage("clicked heroic strike");
			startLoading();
		} else if (evt.getSource().equals(btn_evade)) {
			appendMessage("clicked evade");
			startLoading();
		} else if (evt.getSource().equals(btn_toxicSpit)) {
			appendMessage("clicked toxic spit");
			startLoading();
		} else if (evt.getSource().equals(btn_annihilate)) {
			appendMessage("clicked annihilate");
			startLoading();
		}
	}

	// set all attack buttons to inactive
	public static void disableButtons() {
		btn_strike.setEnabled(false);
		btn_rejuvenate.setEnabled(false);
		btn_heroicStrike.setEnabled(false);
		btn_evade.setEnabled(false);
		btn_toxicSpit.setEnabled(false);
		btn_annihilate.setEnabled(false);
	}

	// set all attack buttons to active
	public static void enableButtons() {
		btn_strike.setEnabled(true);
		btn_rejuvenate.setEnabled(true);
		btn_heroicStrike.setEnabled(true);
		btn_evade.setEnabled(true);
		btn_toxicSpit.setEnabled(true);
		btn_annihilate.setEnabled(true);
	}

	// initiate the loading animation
	public void startLoading() {
		new Thread(new ThreadLoadingBar()).start();
	}

	// append a message to the middle display area
	public void appendMessage(String s) {
		textArea.append(" > " + s + "\n");
	}

	// return the loading bar's value
	// public static int getProgBar_loading() {
	// return progBar_loading.getValue();
	// }

	// set value for the loading bar
	public static void setProgBar_loading(int val) {
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
	public static void toggleTurn() {
		Game.turn = !turn;
	}
}
