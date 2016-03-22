package bi.team;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class Game extends JFrame {

	// init variables
	private static int kills;
	private static String turn;

	private JPanel contentPane;
	private JPanel panel_left;
	private JPanel panel_top;
	private JPanel panel_bottom;
	private JPanel panel_right;
	private JPanel panel_middle;
	private JPanel panel_actions;

	/**
	 * Create the frame.
	 */
	public Game() {

		// frame initializing
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 890, 480);
		setTitle("BeyondInfinity - Group Project for CS1100");
		setVisible(true);

		// create a root panel
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBounds(0, 0, 874, 441);
		getContentPane().add(contentPane);

		// create left panel for displaying hero info
		panel_left = new JPanel();
		panel_left.setBounds(10, 59, 230, 292);
		contentPane.add(panel_left);

		// create top panel to display health bars
		panel_top = new JPanel();
		panel_top.setBounds(10, 11, 854, 39);
		panel_top.setLayout(null);
		contentPane.add(panel_top);

		// create bottom panel to display buttons for upgrades
		panel_bottom = new JPanel();
		panel_bottom.setBounds(10, 362, 854, 68);
		contentPane.add(panel_bottom);

		// create right panel for displaying enemy info
		panel_right = new JPanel();
		panel_right.setBounds(633, 59, 231, 292);
		contentPane.add(panel_right);

		// create middle panel for displaying output event changes
		panel_middle = new JPanel();
		panel_middle.setBounds(250, 59, 373, 236);
		contentPane.add(panel_middle);

		// create actions panel for displaying action buttons
		panel_actions = new JPanel();
		panel_actions.setBounds(250, 306, 373, 45);
		contentPane.add(panel_actions);

	}

	// return total kills
	public static int getKills() {
		return kills;
	}

	// set total kills
	public static void setKills(int kills) {
		Game.kills = kills;
	}

	public static String getTurn() {
		return turn;
	}

	public static void setTurn(String turn) {
		Game.turn = turn;
	}

}
