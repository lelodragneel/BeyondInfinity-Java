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
	private JPanel contentPane;
	private JLabel lblTitle;
	private JTextField nameField;
	private JButton btnSubmit;
	private JLabel lblOne;
	private JButton btnWarrior;
	private JButton btnMage;
	private JButton btnRanger;
	private JButton btnCleric;
	// initialize
	private ArrayList<Attack> heroAttacks;
	private Boolean classChosen = false;

	public BeyondInfinity() {

		//instantiate
		heroAttacks = new ArrayList<Attack>();

		// frame initializing
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 600, 300);
		setTitle("BeyondInfinity - by Lelo & Ree11");
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
		lblOne = new JLabel("To start your adventure, enter your name below:");
		lblOne.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblOne.setBounds(162, 78, 270, 20);
		contentPane.add(lblOne);

		JLabel lblPickAClass = new JLabel("Pick A Class!");
		lblPickAClass.setHorizontalAlignment(SwingConstants.CENTER);
		lblPickAClass.setBounds(252, 140, 89, 14);
		contentPane.add(lblPickAClass);

		btnWarrior = new JButton("Warrior");
		btnWarrior.setBounds(102, 165, 89, 23);
		btnWarrior.addActionListener(this);
		contentPane.add(btnWarrior);

		btnMage = new JButton("Mage");
		btnMage.setBounds(201, 165, 89, 23);
		btnMage.addActionListener(this);
		contentPane.add(btnMage);

		btnRanger = new JButton("Ranger");
		btnRanger.setBounds(300, 165, 89, 23);
		btnRanger.addActionListener(this);
		contentPane.add(btnRanger);

		btnCleric = new JButton("Cleric");
		btnCleric.setBounds(399, 165, 89, 23);
		btnCleric.addActionListener(this);
		contentPane.add(btnCleric);

		// finally show frame
		setVisible(true);
	}

	public ArrayList<Attack> getheroAttacks() {
		return heroAttacks;
	}

	// actionlistener for the submit button
	//String name, double damage, double energyCost, int coolDown, double heal, int turnEvade
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnWarrior)){
			heroAttacks.clear();
			heroAttacks.add(new Attack("Swing", 1.0, 1.0, 1, 1.0, 1));				// Basic Attack
			heroAttacks.add(new Attack("Cleave", 1.0, 1.0, 2, 1.0, 1));				// Secondary Attack
			heroAttacks.add(new Attack("Healing Potion", 1.0, 1.0, 2, 1.0, 1)); 	// Health
			heroAttacks.add(new Attack("Block", 1.0, 1.0, 2, 1.0, 1));				// Evade
			heroAttacks.add(new Attack("Offensive Stance", 1.0, 1.0, 2, 1.0, 1));	// Increase Damage
			heroAttacks.add(new Attack("True Strike", 1.0, 1.0, 2, 1.0, 1));		// Ultimate Attack
			classChosen = true;
		}else if(e.getSource().equals(btnMage)){
			heroAttacks.clear();
			heroAttacks.add(new Attack("Wack with Staff", 1.0, 1.0, 1, 1.0, 1));	// Basic Attack
			heroAttacks.add(new Attack("Magic Missile", 1.0, 1.0, 2, 1.0, 1));		// Secondary Attack
			heroAttacks.add(new Attack("Rejuvenate Self", 1.0, 1.0, 2, 1.0, 1));	// Rejuvenate Self
			heroAttacks.add(new Attack("Invisibility", 1.0, 1.0, 2, 1.0, 1));		// Evade
			heroAttacks.add(new Attack("Magic Armour", 1.0, 1.0, 2, 1.0, 1));		// Increase Defense
			heroAttacks.add(new Attack("Fireball", 1.0, 1.0, 2, 1.0, 1));			// Ultimate Attack
			classChosen = true;
		}else if(e.getSource().equals(btnRanger)){
			heroAttacks.clear();
			heroAttacks.add(new Attack("Bow & Arrow", 1.0, 1.0, 1, 1.0, 1));		// Basic Attack
			heroAttacks.add(new Attack("Rapid Fire", 1.0, 1.0, 2, 1.0, 1));			// Secondary Attack
			heroAttacks.add(new Attack("Nature's Healing", 1.0, 1.0, 2, 1.0, 1));	// Heal
			heroAttacks.add(new Attack("Lay Bear Trap", 1.0, 1.0, 2, 1.0, 1));		// Evade i.e. caught in a bear trap
			heroAttacks.add(new Attack("Vital Shot", 1.0, 1.0, 2, 1.0, 1));			// Increase Crit & Crit Chance
			heroAttacks.add(new Attack("True Shot", 1.0, 1.0, 2, 1.0, 1));			// Ultimate Attack
			classChosen = true;
		}else if(e.getSource().equals(btnCleric)){
			heroAttacks.clear();
			heroAttacks.add(new Attack("Smite", 1.0, 1.0, 1, 1.0, 1));				// Basic Attack
			heroAttacks.add(new Attack("Drain Life", 1.0, 1.0, 2, 1.0, 1));			// Secondary Attack + Shit Heal
			heroAttacks.add(new Attack("Regenerate Body", 1.0, 1.0, 2, 1.0, 1));	// Greater Heal
			heroAttacks.add(new Attack("Blinding Light", 1.0, 1.0, 2, 1.0, 1));		// Evade
			heroAttacks.add(new Attack("Divine Favor", 1.0, 1.0, 2, 1.0, 1));		// Increase All Stats
			heroAttacks.add(new Attack("Divine Intervention", 1.0, 1.0, 2, 1.0, 1));// Ultimate Attack
			classChosen = true;
		}else if (e.getSource().equals(btnSubmit) && classChosen) {
			// safely instantiate the game frame
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					// TODO textfield validation //double maxHealth, double maxEnergy, double energyRecoverRate
					Player player = new Player(nameField.getText(),100,100,1.0);
					new Game(player, heroAttacks);
				}
			});
			// close this frame
			dispose();
		}else if (e.getSource().equals(btnSubmit) && !classChosen){
			JOptionPane.showMessageDialog(null, "Please Select a class", "Alert", JOptionPane.ERROR_MESSAGE);
		} 

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
