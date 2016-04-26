package bi.team.map;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import bi.team.bosstype.Boss;

public class MapEntry implements MouseListener {

	// init variables
	private JLabel entry;
	private Boss boss;
	
	// constructor
	public MapEntry(int entryNum, Boss boss) {

		this.boss = boss;
		boss.setName("boss" + entryNum);
		
		// create a label and configured its settings
		entry = new JLabel(entryNum + 1 + "");
		entry.setBackground(new Color(236, 236, 236));
		entry.setOpaque(true);
		entry.setVerticalAlignment(SwingConstants.BOTTOM);
		entry.setHorizontalAlignment(SwingConstants.RIGHT);
		entry.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		entry.addMouseListener(this);
		entry.setBorder(boss.getBorder());
	
	}

	// return the map entry
	public JLabel getEntry() {
		return entry;
	}

	// below are the mouse listeners for hovering effects
	@Override
	public void mouseEntered(MouseEvent e) {
		entry.setBackground(Color.LIGHT_GRAY);
	}
	@Override
	public void mouseExited(MouseEvent e) {
		entry.setBackground(new Color(236, 236, 236));
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
