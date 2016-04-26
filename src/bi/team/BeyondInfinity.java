package bi.team;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import bi.team.heroes.Alchemist;
import bi.team.heroes.Warlock;
import bi.team.heroes.Berserker;
import bi.team.heroes.Brutalizer;
import bi.team.heroes.Elementalist;
import bi.team.heroes.Hero;
import java.awt.Cursor;

@SuppressWarnings("serial")
public class BeyondInfinity extends JFrame implements ActionListener {

	// init variables
	private JTextField nameField;
	private JButton btnSubmit;
	private JButton btnBrutalizer;
	private JButton btnElementalist;
	private JButton btnAlchemist;
	private JButton btnBerserker;
	private JButton btnWarlock;
	private Hero hero;

	// constructor
	public BeyondInfinity() {
		
		System.out.println("test");
		System.out.println("test \t");

		// frame initializing
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 650, 370);
		setTitle("BeyondInfinity - by Lelo & Ree11");
		getContentPane().setLayout(null);

		// create a root panel
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBounds(0, 0, 644, 335);
		contentPane.setVisible(true);
		contentPane.setBackground(new Color(236, 240, 241));
		getContentPane().add(contentPane);

		// create title label
		JLabel lblTitle = new JLabel("Welcome to BeyondInfinity!");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblTitle.setBounds(228, 11, 188, 27);
		contentPane.add(lblTitle);

		// create a field to input player name
		nameField = new JTextField();
		nameField.setBounds(238, 109, 167, 20);
		nameField.setColumns(10);
		nameField.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(nameField);

		// create a button to submit player name
		btnSubmit = new JButton("Let's Go!");
		btnSubmit.setBounds(276, 299, 89, 23);
		btnSubmit.setFocusable(false);
		btnSubmit.addActionListener(this);
		contentPane.add(btnSubmit);

		// create a label asking player to enter name
		JLabel lblOne = new JLabel("To start your adventure, enter your name below:");
		lblOne.setHorizontalAlignment(SwingConstants.CENTER);
		lblOne.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblOne.setBounds(187, 78, 270, 20);
		contentPane.add(lblOne);

		// create brutalizer button
		btnBrutalizer = new JButton("");
		btnBrutalizer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBrutalizer.setBackground(null);
		btnBrutalizer.setBounds(73, 187, 90, 90);
		btnBrutalizer.setFocusable(false);
		btnBrutalizer.addActionListener(this);
		contentPane.add(btnBrutalizer);

		// create elementalist button
		btnElementalist = new JButton("");
		btnElementalist.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnElementalist.setBackground(null);
		btnElementalist.setBounds(175, 187, 90, 90);
		btnElementalist.setFocusable(false);
		btnElementalist.addActionListener(this);
		contentPane.add(btnElementalist);

		// create alchemist button
		btnAlchemist = new JButton("");
		btnAlchemist.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAlchemist.setBackground(null);
		btnAlchemist.setBounds(276, 187, 90, 90);
		btnAlchemist.setFocusable(false);
		btnAlchemist.addActionListener(this);
		contentPane.add(btnAlchemist);

		// create berserker button
		btnBerserker = new JButton("");
		btnBerserker.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBerserker.setBackground(null);
		btnBerserker.setBounds(378, 187, 90, 90);
		btnBerserker.setFocusable(false);
		btnBerserker.addActionListener(this);
		contentPane.add(btnBerserker);
		
		// create warlock button
		btnWarlock = new JButton("");
		btnWarlock.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnWarlock.setFocusable(false);
		btnWarlock.setBackground((Color) null);
		btnWarlock.setBounds(480, 187, 90, 90);
		btnWarlock.addActionListener(this);
		contentPane.add(btnWarlock);
		
		/*
		 * create hero type labels
		 */
		JLabel lblAlchemist = new JLabel("Alchemist");
		lblAlchemist.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlchemist.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblAlchemist.setBounds(277, 167, 89, 16);
		contentPane.add(lblAlchemist);
		
		JLabel lblElementalist = new JLabel("Elementalist");
		lblElementalist.setHorizontalAlignment(SwingConstants.CENTER);
		lblElementalist.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblElementalist.setBounds(175, 167, 89, 16);
		contentPane.add(lblElementalist);
		
		JLabel lblBrutalizer = new JLabel("Brutalizer");
		lblBrutalizer.setHorizontalAlignment(SwingConstants.CENTER);
		lblBrutalizer.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblBrutalizer.setBounds(73, 167, 89, 16);
		contentPane.add(lblBrutalizer);
		
		JLabel lblBerserker = new JLabel("Berserker");
		lblBerserker.setHorizontalAlignment(SwingConstants.CENTER);
		lblBerserker.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblBerserker.setBounds(378, 167, 89, 16);
		contentPane.add(lblBerserker);
		
		JLabel lblWarlock = new JLabel("Warlock");
		lblWarlock.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarlock.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblWarlock.setBounds(480, 167, 89, 16);
		contentPane.add(lblWarlock);

		// finally show frame
		setVisible(true);
	}

	// TODO implement race picker
	
	// actionlistener for the submit button
	public void actionPerformed(ActionEvent e) {

		System.out.println("done");
		
		if (e.getSource() == btnBrutalizer) {
			paintSelectedButton(btnBrutalizer);
		} else if (e.getSource() == btnElementalist) {
			paintSelectedButton(btnElementalist);
		} else if (e.getSource() == btnAlchemist) {
			paintSelectedButton(btnAlchemist);
		} else if (e.getSource() == btnBerserker) {
			paintSelectedButton(btnBerserker);
		} else if (e.getSource() == btnWarlock) {
			paintSelectedButton(btnWarlock);
		} else if (e.getSource() == btnSubmit) {

			// create the chosen hero
			if (btnBrutalizer.isSelected())
				startGameFrame("brutalizer");
			else if (btnAlchemist.isSelected())
				startGameFrame("alchemist");
			else if (btnElementalist.isSelected())
				startGameFrame("elementalist");
			else if (btnBerserker.isSelected())
				startGameFrame("berserker");
			else if (btnWarlock.isSelected())
				startGameFrame("warlock");
			else {
				JOptionPane.showMessageDialog(this, "You forgot to select a hero!", "Alert", JOptionPane.ERROR_MESSAGE);
				return;
			}
			

		}
	}
	
	// start building the actual frame of the game
	public void startGameFrame(String chosenHero) {
		
		// safely instantiate the game frame
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				// TODO textfield validation
				
				new Game(nameField.getText(), chosenHero);
			}
		});
		
		// close this frame
		dispose();
		
	}

	// toggle button animation when clicked
	public void paintSelectedButton(JButton selected) {
		// unpaint all the buttons
		btnBrutalizer.setBorder(new LineBorder(Color.BLACK, 1));
		btnElementalist.setBorder(new LineBorder(Color.BLACK, 1));
		btnAlchemist.setBorder(new LineBorder(Color.BLACK, 1));
		btnBerserker.setBorder(new LineBorder(Color.BLACK, 1));
		btnWarlock.setBorder(new LineBorder(Color.BLACK, 1));

		// paint the selected button
		selected.setBorder(new LineBorder(Color.BLACK, 2));
		
		// actually select the button
		selected.setSelected(true);
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
