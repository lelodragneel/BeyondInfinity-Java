package bi.team.map;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JLayeredPane;
import javax.swing.border.LineBorder;

import bi.team.bosstype.GuardianBoss;
import bi.team.bosstype.MiniBoss;
import bi.team.bosstype.SuperBoss;

@SuppressWarnings("serial")
public class Map extends JLayeredPane {

	// initialize variables
	private ArrayList<MapEntry> mapEntries;
	
	// constructor
	public Map(int parent_width, int parent_height) {
		
		// create the main map frame
		setOpaque(true);
		int width = 600;
		int height = 370;
		setBounds(new Rectangle((parent_width / 2) - (width / 2), (parent_height / 2) - (height / 2) - 40,
				width, height));
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(236, 236, 236));
		setLayout(new GridBagLayout());
		setVisible(false);	

		// create the actual grid
		createGrid();
		
	}

	// create labels for the map grid then add them to the window
	public void createGrid() {

		// initialize variables
		mapEntries = new ArrayList<MapEntry>();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = gbc.weighty = 1.0;
		gbc.insets = new Insets(3, 3, 3, 3);
		
		// create 72 minibosses and 12 superbosses
		for (int i = 0; i < 84; i++) {

			if (i == 6 || i == 13 || i == 20 || i == 27 || i == 34 || i == 41 || i == 48 || i == 55 || i == 62
					|| i == 69 || i == 76 || i == 83)
				mapEntries.add(new MapEntry(i, new SuperBoss()));
			else
				mapEntries.add(new MapEntry(i, new MiniBoss()));
			
		}

		// create the 3 guardian bosses, and 1 grand boss (final boss)
		mapEntries.add(new MapEntry(84, new GuardianBoss()));
		mapEntries.add(new MapEntry(85, new GuardianBoss()));
		mapEntries.add(new MapEntry(86, new GuardianBoss()));
		mapEntries.add(new MapEntry(87, new GuardianBoss()));
		
		// add the created 84 bosses to the gridbag grid
		Iterator<MapEntry> items = mapEntries.listIterator();
		int x = 0;
		int y = 0;
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 12 && items.hasNext(); j++) {
				gbc.gridx = x++;
				add(items.next().getEntry(), gbc);
			}
			gbc.gridy = y++;
			x = 0;
		}
		
		// add the 3 guardian bosses and the grand boss (final boss) to gridbag grid
		gbc.gridy = 9;
		gbc.gridx = 1;
		add(items.next().getEntry(), gbc);
		gbc.gridy = 9;
		gbc.gridx = 4;
		add(items.next().getEntry(), gbc);
		gbc.gridy = 9;
		gbc.gridx = 7;
		add(items.next().getEntry(), gbc);
		gbc.gridy = 9;
		gbc.gridx = 10;
		add(items.next().getEntry(), gbc);
		
	}
	
}
