package bi.team;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class BeyondInfinity extends JFrame implements ActionListener {

	// init variables
	private JTextField nameField;
	private JButton btnSubmit;
	private JButton btnWarrior;
	private JButton btnMage;
	private JButton btnRanger;
	private JButton btnCleric;
	private ArrayList<Attack> heroAttacks;
	private boolean classChosen;

	// constructor
	public BeyondInfinity() {

		// instantiate variables
		heroAttacks = new ArrayList<Attack>();

		// frame initializing
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 600, 300);
		setTitle("BeyondInfinity - by Lelo & Ree11");
		getContentPane().setLayout(null);

		// create a root panel
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBounds(0, 0, 594, 271);
		contentPane.setVisible(true);
		contentPane.setBackground(new Color(236, 240, 241));
		getContentPane().add(contentPane);

		// create title label
		JLabel lblTitle = new JLabel("Welcome to BeyondInfinity!");
		lblTitle.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblTitle.setBounds(203, 11, 188, 27);
		contentPane.add(lblTitle);

		// create a field to input player name
		nameField = new JTextField();
		nameField.setBounds(213, 109, 167, 20);
		nameField.setColumns(10);
		nameField.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(nameField);

		// create a button to submit player name
		btnSubmit = new JButton("Let's Go!");
		btnSubmit.setBounds(252, 206, 89, 23);
		btnSubmit.addActionListener(this);
		contentPane.add(btnSubmit);

		// create a label asking player to enter name
		JLabel lblOne = new JLabel("To start your adventure, enter your name below:");
		lblOne.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblOne.setBounds(162, 78, 270, 20);
		contentPane.add(lblOne);

		// create a label asking player to pick a class 
		JLabel lblPickAClass = new JLabel("Pick A Class!");
		lblPickAClass.setHorizontalAlignment(SwingConstants.CENTER);
		lblPickAClass.setBounds(252, 140, 89, 14);
		contentPane.add(lblPickAClass);

		// create warrior button
		btnWarrior = new JButton("Warrior");
		btnWarrior.setBackground(null);
		btnWarrior.setBounds(102, 165, 89, 23);
		btnWarrior.setFocusable(false);
		btnWarrior.addActionListener(this);
		contentPane.add(btnWarrior);

		// create mage button
		btnMage = new JButton("Mage");
		btnMage.setBackground(null);
		btnMage.setBounds(201, 165, 89, 23);
		btnMage.setFocusable(false);
		btnMage.addActionListener(this);
		contentPane.add(btnMage);

		// create ranger button
		btnRanger = new JButton("Ranger");
		btnRanger.setBackground(null);
		btnRanger.setBounds(300, 165, 89, 23);
		btnRanger.setFocusable(false);
		btnRanger.addActionListener(this);
		contentPane.add(btnRanger);

		// create cleric button
		btnCleric = new JButton("Cleric");
		btnCleric.setBackground(null);
		btnCleric.setBounds(399, 165, 89, 23);
		btnCleric.setFocusable(false);
		btnCleric.addActionListener(this);
		contentPane.add(btnCleric);

		// finally show frame
		setVisible(true);
	}

	// TODO implement a more efficient storage system for attacks
	
	// actionlistener for the submit button
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnWarrior)){
			classChosen = true;
			animateSelectedButton(btnWarrior);
			heroAttacks.clear();
			heroAttacks.add(new Attack("Swing", 99.0, 1.0, 0, 1.0, 1));				// Basic Attack
			heroAttacks.add(new Attack("Cleave", 15.0, 1.0, 2, 1.0, 1));			// Secondary Attack
			heroAttacks.add(new Attack("Healing Potion", 0, 1.0, 2, 1.0, 1)); 		// Health
			heroAttacks.add(new Attack("Block", 0, 1.0, 2, 1.0, 1));				// Evade
			heroAttacks.add(new Attack("Offensive Stance", 0, 1.0, 2, 1.0, 1));		// Increase Damage
			heroAttacks.add(new Attack("True Strike", 30.0, 1.0, 4, 1.0, 1));		// Ultimate Attack
		}else if(e.getSource().equals(btnMage)){
			classChosen = true;
			animateSelectedButton(btnMage);
			heroAttacks.clear();
			heroAttacks.add(new Attack("Wack with Staff", 5.0, 1.0, 0, 1.0, 1));	// Basic Attack
			heroAttacks.add(new Attack("Magic Missile", 15.0, 1.0, 2, 1.0, 1));		// Secondary Attack
			heroAttacks.add(new Attack("Rejuvenate Self", 0, 1.0, 2, 1.0, 1));		// Rejuvenate Self
			heroAttacks.add(new Attack("Invisibility", 0, 1.0, 2, 1.0, 1));			// Evade
			heroAttacks.add(new Attack("Magic Armour", 0, 1.0, 2, 1.0, 1));			// Increase Defense
			heroAttacks.add(new Attack("Fireball", 30.0, 1.0, 4, 1.0, 1));			// Ultimate Attack
		}else if(e.getSource().equals(btnRanger)){
			classChosen = true;
			animateSelectedButton(btnRanger);
			heroAttacks.clear();
			heroAttacks.add(new Attack("Bow & Arrow", 5.0, 1.0, 0, 1.0, 1));		// Basic Attack
			heroAttacks.add(new Attack("Rapid Fire", 15.0, 1.0, 2, 1.0, 1));		// Secondary Attack
			heroAttacks.add(new Attack("Nature's Healing", 0.0, 1.0, 2, 1.0, 1));	// Heal
			heroAttacks.add(new Attack("Lay Bear Trap", 0.0, 1.0, 2, 1.0, 1));		// Evade i.e. caught in a bear trap
			heroAttacks.add(new Attack("Vital Shot", 0.0, 1.0, 2, 1.0, 1));			// Increase Crit & Crit Chance
			heroAttacks.add(new Attack("True Shot", 30.0, 1.0, 4, 1.0, 1));			// Ultimate Attack
		}else if(e.getSource().equals(btnCleric)){
			classChosen = true;
			animateSelectedButton(btnCleric);
			heroAttacks.clear();
			heroAttacks.add(new Attack("Smite", 5.0, 1.0, 0, 1.0, 1));				// Basic Attack
			heroAttacks.add(new Attack("Drain Life", 15.0, 1.0, 2, 1.0, 1));		// Secondary Attack + Shit Heal
			heroAttacks.add(new Attack("Regenerate Body", 0.0, 1.0, 2, 1.0, 1));	// Greater Heal
			heroAttacks.add(new Attack("Blinding Light", 0.0, 1.0, 2, 1.0, 1));		// Evade
			heroAttacks.add(new Attack("Divine Favor", 0.0, 1.0, 2, 1.0, 1));		// Increase All Stats
			heroAttacks.add(new Attack("Divine Intervention", 30.0, 1.0, 4, 1.0, 1));// Ultimate Attack
		}else if (e.getSource().equals(btnSubmit)) {
			
			// error checking. check if user has selected a class
			if(classChosen) {
				// safely instantiate the game frame
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						
						// TODO textfield validation
						
						new Game(nameField.getText(), heroAttacks);
					}
				});
				// close this frame
				dispose();
			} else if (!classChosen) {
				JOptionPane.showMessageDialog(null, "Please Select a class", "Alert", JOptionPane.ERROR_MESSAGE);
			}		
		}

	}

	// toggle button animation when clicked
	public void animateSelectedButton(JButton selected) {
		// unpaint all the buttons
		btnWarrior.setBackground(null);
		btnMage.setBackground(null);
		btnRanger.setBackground(null);
		btnCleric.setBackground(null);
		
		// paint the selected button
		selected.setBackground(Color.GRAY);
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
