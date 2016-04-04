package bi.team;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Map {

	// init variables
	private JLayeredPane mapPane;
	private ArrayList<MapEntry> mapEntries;
	private JPanel panel_bosses;
	private JPanel panel_grandboss;

	// constructor
	public Map(int parent_width, int parent_height) {
		
		// create the main map frame
		mapPane = new JLayeredPane();
		mapPane.setOpaque(true);
		int width = 589;
		int height = 348;
		mapPane.setBounds(new Rectangle((parent_width / 2) - (width / 2), (parent_height / 2) - (height / 2) - 40,
				width, height));
		mapPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		mapPane.setBackground(new Color(236, 236, 236));
		mapPane.setLayout(null);
		mapPane.setVisible(false);

		// create the upper panel for bosses 1-84
		panel_bosses = new JPanel();
		panel_bosses.setOpaque(false);
		panel_bosses.setBorder(new EmptyBorder(1, 1, 1, 1));
		panel_bosses.setBounds(5, 5, 580, 298);
		panel_bosses.setLayout(new GridLayout(7, 12, 3, 3));
		mapPane.add(panel_bosses);

		// create the lower panel for three bodyguard bosses, and the grand boss
		panel_grandboss = new JPanel();
		panel_grandboss.setOpaque(false);
		panel_grandboss.setBorder(new EmptyBorder(1, 1, 1, 1));
		panel_grandboss.setBounds(5, 302, 580, 40);
		panel_grandboss.setLayout(new GridLayout(0, 12, 3, 3));
		mapPane.add(panel_grandboss);

		// create the actual grid
		mapEntries = new ArrayList<MapEntry>();
		createGrid();
	}

	// create labels for the map grid then add them to the window
	public void createGrid() {

		// create the labels for bosses 1-84
		for (int i = 0; i < 84; i++)
			mapEntries.add(new MapEntry(i));

		// create the three bodyguards and grand boss
		mapEntries.add(new MapEntry(84));
		mapEntries.add(new MapEntry(85));
		mapEntries.add(new MapEntry(86));
		mapEntries.add(new MapEntry(87));
		
		// add the created labels to the jlayeredpane, bosses 1-84
		for (int i = 0; i < 84; i++)
			panel_bosses.add(mapEntries.get(i).getEntry());


		// add the three guards and grand boss, along with dummy empty labels
		panel_grandboss.add(new JLabel());
		panel_grandboss.add(mapEntries.get(84).getEntry());
		panel_grandboss.add(new JLabel());
		panel_grandboss.add(new JLabel());
		panel_grandboss.add(mapEntries.get(85).getEntry());
		panel_grandboss.add(new JLabel());
		panel_grandboss.add(new JLabel());
		panel_grandboss.add(mapEntries.get(86).getEntry());
		panel_grandboss.add(new JLabel());
		panel_grandboss.add(new JLabel());
		panel_grandboss.add(mapEntries.get(87).getEntry());

	}

	// return jlayeredpane map
	public JLayeredPane getMapPane() {
		return mapPane;
	}

}
