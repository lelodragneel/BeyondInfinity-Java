package bi.team.map;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import bi.team.bosstype.Enemy;
import bi.team.bosstype.GrandBoss;
import bi.team.bosstype.GuardianBoss;
import bi.team.bosstype.MiniBoss;
import bi.team.bosstype.SuperBoss;

@SuppressWarnings("serial")
public class Map extends JLayeredPane {

	/*
	 * initialize variables
	 */
	private ArrayList<Enemy> enemyEntries;
	private JPanel panel_map;
	private JPanel panel_enemyHover;
	private JLabel lblEnemyName;
	private JLabel lblEnemyImage;
	
	// constructor
	public Map(int parent_width, int parent_height) {
		
		// create the main map frame
		this.setOpaque(true);
		int width = 700;
		int height = 360;
		this.setBounds(new Rectangle((parent_width / 2) - (width / 2), (parent_height / 2) - (height / 2) - 40,
				width, height));
		this.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.setLayout(null);
		this.setVisible(false);

		// create panel for map grid
		panel_map = new JPanel();
		panel_map.setBounds(4, 4, 536, 348);
		panel_map.setLayout(new GridBagLayout());
		panel_map.setBackground(new Color(236, 236, 236));
		this.add(panel_map);
		
		// create panel to display enemy information
		panel_enemyHover = new JPanel();
		panel_enemyHover.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_enemyHover.setBounds(545, 10, 145, 340);
		this.add(panel_enemyHover);
		panel_enemyHover.setLayout(null);
		
		// create label to display selected enemy name
		lblEnemyName = new JLabel("");
		lblEnemyName.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblEnemyName.setBounds(10, 172, 125, 16);
		panel_enemyHover.add(lblEnemyName);
		
		// create label to display selected enemy image
		lblEnemyImage = new JLabel("");
		lblEnemyImage.setBounds(10, 11, 125, 150);
		panel_enemyHover.add(lblEnemyImage);
		
		// create the actual grid
		createGrid();
		
	}
	
	// display enemy info
	public void showEnemyInfo(Enemy entry) {
		lblEnemyName.setText(entry.getName());
		lblEnemyImage.setIcon(entry.getIcon());
	}

	// create labels for the map grid then add them to the window
	public void createGrid() {

		// initialize variables
		enemyEntries = new ArrayList<Enemy>();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = gbc.weighty = 1.0;
		gbc.insets = new Insets(3, 3, 0, 0);
		
		// create 72 minibosses and 12 superbosses
		for (int i = 0; i < 72; i++) {

			if (i == 6 || i == 13 || i == 20 || i == 27 || i == 34 || i == 41 || i == 48 || i == 55 || i == 62
					|| i == 69) {
				enemyEntries.add(new SuperBoss(this, i));
			} else {
				enemyEntries.add(new MiniBoss(this, i));
			}
			
		}

		// create the 3 guardian bosses, and 1 grand boss (final boss)
		enemyEntries.add(new GuardianBoss(this, 72));
		enemyEntries.add(new GuardianBoss(this, 73));
		enemyEntries.add(new GuardianBoss(this, 74));
		enemyEntries.add(new GrandBoss(this, 75));
		
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
		gbc.gridy = 6;
		gbc.gridx = 1;
		panel_map.add(items.next(), gbc);
		gbc.gridy = 6;
		gbc.gridx = 4;
		panel_map.add(items.next(), gbc);
		gbc.gridy = 6;
		gbc.gridx = 7;
		panel_map.add(items.next(), gbc);
		gbc.gridy = 6;
		gbc.gridx = 10;
		panel_map.add(items.next(), gbc);
		
	}

	// return the mapEntries
	public ArrayList<Enemy> getMapEntries() {
		return enemyEntries;
	}
}
