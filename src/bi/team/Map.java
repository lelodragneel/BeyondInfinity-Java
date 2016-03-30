package bi.team;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLayeredPane;

public class Map {

	// init variables
	private Game game;
	private JLayeredPane mapPane;
	private ArrayList<MapEntry> mapEntry;

	// constructor
	public Map(Game g) {
		game = g;
		mapPane = new JLayeredPane();
		mapPane.setLayout(new GridLayout(8, 10, 0, 0));
		createGrid();
	}

	// create 84 labels for the map grid
	public void createGrid() {
		String s;
		for (int i = 1; i < 85; i++) {
			s = "Boss " + i;
			mapEntry.add(new MapEntry(s));
		}

	}

}
