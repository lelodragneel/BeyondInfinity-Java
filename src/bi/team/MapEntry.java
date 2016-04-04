package bi.team;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class MapEntry {

	// init variables
	private JLabel entry;
	private boolean completed = false;

	// constructor
	public MapEntry(int s) {
		// create a label and configured its settings
		entry = new JLabel(s+1 + "");
		entry.setBorder(new LineBorder(new Color(0, 0, 0)));
		entry.setBackground(new Color(236, 236, 236));
		entry.setOpaque(true);
		entry.setVerticalAlignment(SwingConstants.BOTTOM);
		entry.setHorizontalAlignment(SwingConstants.RIGHT);
		entry.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
	}

	// return the jlabel
	public JLabel getEntry() {
		return entry;
	}

	// return whether or not this boss is defeated
	public boolean isCompleted() {
		return completed;
	}

	// set whether or not this boss got defeated
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

}
