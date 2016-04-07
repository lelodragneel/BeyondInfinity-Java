package bi.team.map;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import bi.team.bosstype.Boss;

public class MapEntry implements MouseListener {

	// init variables
	private JLabel entry;
	private Boss boss;
	private Border border;
	
	// constructor
	public MapEntry(int entryNum, Boss boss) {
			
		// create a label and configured its settings
		entry = new JLabel(entryNum + 1 + "");
		entry.setBackground(new Color(236, 236, 236));
		entry.setOpaque(true);
		entry.setVerticalAlignment(SwingConstants.BOTTOM);
		entry.setHorizontalAlignment(SwingConstants.RIGHT);
		entry.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		entry.addMouseListener(this);
		
		// TODO add new and unique borders for each boss classification
		// assign boss type association, and change visual accordingly
		switch (boss.getBossType()) {
			case "miniboss":
				border = new LineBorder(new Color(0, 0, 0), 1);
				break;
			case "superboss":
				border = new LineBorder(new Color(0, 0, 0), 2);
				break;
			case "guardianboss":
				border = new LineBorder(new Color(0, 0, 0), 2);
				break;
			case "grandboss":
				border = new LineBorder(new Color(0, 0, 0), 2);
				break;
			default:
				System.out.println("Something went wrong loading the map!");
		}
		
		// set border
		entry.setBorder(border);
	
	}

	// return the jlabel
	public JLabel getEntry() {
		return entry;
	}

	// below are the mouse listeners for hovering effects
	@Override
	public void mouseEntered(MouseEvent e) {
		entry.setBorder(new LineBorder(Color.DARK_GRAY, 2));	
	}

	@Override
	public void mouseExited(MouseEvent e) {
		entry.setBorder(border);	
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}
	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}

	// return the boss
	public Boss getBoss() {
		return boss;
	}

}
