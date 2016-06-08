package bi.team;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import bi.team.enemies.Enemy;
import bi.team.enemies.meadowlands.Alania_defender_of_the_meadow;
import bi.team.enemies.meadowlands.Fuehirch;
import bi.team.enemies.meadowlands.Hawk_stag;
import bi.team.enemies.meadowlands.Mantisray;
import bi.team.enemies.meadowlands.Oboko_of_the_sonne;
import bi.team.enemies.meadowlands.Shar_of_the_nacht;
import bi.team.enemies.meadowlands.Taobu;

@SuppressWarnings("serial")
public class Map extends JLayeredPane implements ActionListener {

	/*
	 * initialize variables
	 */
	private ArrayList<Enemy> enemyEntries;
	private JPanel panel_map;
	private JPanel panel_enemyInfo;
	private JLabel lblEnemyName;
	private JLabel lblEnemyIcon;
	private JButton btnChallenge;
	private Enemy enemySelected;
	private Game game;
	
	// constructor
	public Map(Game game) {
		
		// instantiate variables
		this.game = game;
		
		/*
		 * Create objects of all enemies
		 */
		enemyEntries = new ArrayList<Enemy>();
		enemyEntries.add(new Fuehirch(this));
		enemyEntries.add(new Taobu(this));
		enemyEntries.add(new Hawk_stag(this));
		enemyEntries.add(new Oboko_of_the_sonne(this));
		enemyEntries.add(new Shar_of_the_nacht(this));
		enemyEntries.add(new Mantisray(this));
		enemyEntries.add(new Alania_defender_of_the_meadow(this));
		// TODO create rest of enemies
		
		
		/*
		 * Create the main map frame
		 */
		this.setOpaque(true);
		int width = 715;
		int height = 365;
		this.setBounds(new Rectangle((Math.round(game.getWidth() / 2) - (width / 2)), Math.round((game.getHeight() / 2) - (height / 2) - 40),
				width, height));
		this.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.setLayout(null);
		this.setVisible(false);

		// create panel for map grid
		panel_map = new JPanel();
		panel_map.setBounds(170, 8, 539, 348);
		panel_map.setLayout(new GridBagLayout());
		panel_map.setBackground(new Color(236, 236, 236));
		this.add(panel_map);
		
		// create panel to display enemy information
		panel_enemyInfo = new JPanel();
		panel_enemyInfo.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel_enemyInfo.setBounds(2, 2, 168, 361);
		panel_enemyInfo.setLayout(null);
		this.add(panel_enemyInfo);
		
		// create label to display selected enemy name
		lblEnemyName = new JLabel("");
		lblEnemyName.setVerticalAlignment(SwingConstants.TOP);
		lblEnemyName.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblEnemyName.setBounds(10, 164, 150, 36);
		panel_enemyInfo.add(lblEnemyName);
		
		// create label to display selected enemy image
		lblEnemyIcon = new JLabel("");
		lblEnemyIcon.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblEnemyIcon.setBounds(10, 10, 150, 150);
		panel_enemyInfo.add(lblEnemyIcon);
		
		// create the challenge button
		btnChallenge = new JButton("Challenge");
		btnChallenge.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		btnChallenge.setBounds(39, 260, 90, 90);
		btnChallenge.setFocusable(false);
		btnChallenge.setBackground(null);
		btnChallenge.addActionListener(this);
		btnChallenge.setEnabled(false);
		panel_enemyInfo.add(btnChallenge);
		
		// create the actual grid
		createGrid();
		
	}
	
	// action listener
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnChallenge) {
			game.getHero().prepareFight(enemySelected);
		}
		
	}
	
	// display enemy info
	public void showEnemyInfo(Enemy enemy) {
		lblEnemyName.setText(enemy.getName());
		lblEnemyIcon.setIcon(enemy.getEnemyImage());
		
	}

	// create labels for the map grid then add them to the window
	public void createGrid() {

		// initialize variables
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = gbc.weighty = 1.0;
		gbc.insets = new Insets(2, 2, 2, 2);
		
		// add the created 84 enemies to the gridbag grid
		Iterator<Enemy> items = enemyEntries.listIterator();
		int x = 0;
		int y = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 12 && items.hasNext(); j++) {
				gbc.gridx = x++;
				panel_map.add(items.next(), gbc);
			}
			gbc.gridy = ++y;
			x = 0;
		}
		
		// add the 3 guardian bosses and the grand boss (final boss) to gridbag grid
//		gbc.gridy = 6;
//		gbc.gridx = 1;
//		panel_map.add(items.next(), gbc);
//		gbc.gridy = 6;
//		gbc.gridx = 4;
//		panel_map.add(items.next(), gbc);
//		gbc.gridy = 6;
//		gbc.gridx = 7;
//		panel_map.add(items.next(), gbc);
//		gbc.gridy = 6;
//		gbc.gridx = 10;
//		panel_map.add(items.next(), gbc);
		
	}

	// set the enemySelected
	public void setEnemySelected(Enemy enemySelected) {
		this.enemySelected = enemySelected;
	}

	// return the btnChallenge
	public JButton getBtnChallenge() {
		return btnChallenge;
	}

	// return the lblEnemyName
	public JLabel getLblEnemyName() {
		return lblEnemyName;
	}

	// return the lblEnemyIcon
	public JLabel getLblEnemyIcon() {
		return lblEnemyIcon;
	}

	// return the mapEntries
	public ArrayList<Enemy> getMapEntries() {
		return enemyEntries;
	}

}
