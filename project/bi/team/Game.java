package bi.team;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JFrame {

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
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBounds(0, 0, 874, 441);
		getContentPane().add(contentPane);

		// create left panel for displaying hero info
		JPanel panel_left = new JPanel();
		panel_left.setBounds(10, 59, 230, 292);
		contentPane.add(panel_left);

		// create top panel to display health bars
		JPanel panel_top = new JPanel();
		panel_top.setBounds(10, 11, 854, 39);
		panel_top.setLayout(null);
		contentPane.add(panel_top);

		// create bottom panel with buttons for upgrades
		JPanel panel_bottom = new JPanel();
		panel_bottom.setBounds(10, 362, 854, 68);
		contentPane.add(panel_bottom);

		// create right panel for displaying enemy info
		JPanel panel_right = new JPanel();
		panel_right.setBounds(633, 59, 231, 292);
		contentPane.add(panel_right);

		// create middle panel to output event changes
		JPanel panel_middle = new JPanel();
		panel_middle.setBounds(250, 59, 373, 292);
		contentPane.add(panel_middle);

	}
}
