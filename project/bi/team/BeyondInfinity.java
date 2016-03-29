package bi.team;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class BeyondInfinity extends JFrame implements ActionListener {

	// init variables
	private JPanel contentPane;
	private JLabel lblTitle;
	private JTextField nameField;
	private JButton btnSubmit;
	private JLabel lblOne;

	public BeyondInfinity() {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// TODO textfield validation
				new Game(nameField.getText());
			}
		});
			
		// frame initializing
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 600, 300);
		setTitle("BeyondInfinity - by Lelo");
		getContentPane().setLayout(null);

		// create a root panel
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBounds(0, 0, 594, 271);
		contentPane.setVisible(true);
		contentPane.setBackground(new Color(236, 240, 241));
		getContentPane().add(contentPane);

		// create title label
		lblTitle = new JLabel("Welcome to BeyondInfinity!");
		lblTitle.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblTitle.setBounds(203, 11, 188, 27);
		contentPane.add(lblTitle);

		// create a field to input player name
		nameField = new JTextField();
		nameField.setBounds(213, 139, 167, 20);
		nameField.setColumns(10);
		nameField.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(nameField);

		// create a button to submit player name
		btnSubmit = new JButton("Let's Go!");
		btnSubmit.setBounds(252, 206, 89, 23);
		btnSubmit.addActionListener(this);
		contentPane.add(btnSubmit);

		// create a label asking player to enter name
		lblOne = new JLabel("To start your adventure, enter your name below:");
		lblOne.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblOne.setBounds(162, 108, 270, 20);
		contentPane.add(lblOne);

		// finally show frame
		setVisible(true);

	}

	// actionlistener for the submit button
	public void actionPerformed(ActionEvent e) {

//		if (e.getSource().equals(btnSubmit)) {
//			// safely instantiate the game frame
//			SwingUtilities.invokeLater(new Runnable() {
//				public void run() {
//					// TODO textfield validation
//					new Game(nameField.getText());
//				}
//			});
//			// close this frame
//			dispose();
//		}

	}

	public static void main(String[] args) {

		// safely start welcoming screen
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new BeyondInfinity();
			}
		});
	}

}
