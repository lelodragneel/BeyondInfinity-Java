package bi.team;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLayeredPane;
import javax.swing.border.LineBorder;

public class Map {

	// init variables
	private JLayeredPane mapPane;
	private ArrayList<MapEntry> mapEntries;

	// constructor
	public Map() {
		mapPane = new JLayeredPane();
		mapPane.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		mapPane.setLayout(new GridLayout(7, 12, 0, 0));
		mapPane.setOpaque(true);
		mapPane.setVisible(false);
		mapEntries = new ArrayList<MapEntry>();
		createGrid();
	}

	// create 84 labels for the map grid then add them to jlayeredpane
	public void createGrid() {

		// create the actual labels for the grid
		String s;
		for (int i = 1; i < 85; i++) {
			s = "Boss " + i;
			mapEntries.add(new MapEntry(s));
		}

		// add the created labels to the jlayeredpane
		for (MapEntry x : mapEntries)
			mapPane.add(x.getEntry());

	}

	// return jlayeredpane map
	public JLayeredPane getMapPane() {
		return mapPane;
	}

}
