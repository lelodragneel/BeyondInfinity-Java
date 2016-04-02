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
	public MapEntry(String s) {
		// create a label and configured its settings
		entry = new JLabel(s);
		entry.setBorder(new LineBorder(new Color(0, 0, 0)));
		entry.setSize(45, 45);
		entry.setFocusable(false);
		entry.setBackground(Color.DARK_GRAY);
		entry.setVerticalAlignment(SwingConstants.BOTTOM);
		entry.setHorizontalAlignment(SwingConstants.CENTER);
		entry.setHorizontalTextPosition(SwingConstants.CENTER);
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
