package bi.team.map;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import bi.team.bosstype.Boss;

public class MapEntry extends JLabel implements MouseListener {

	// init variables
	//private JLabel entry;
	private Boss boss;
	
	// constructor
	public MapEntry(int entryNum, Boss boss) {

		this.boss = boss;
		boss.setName("boss" + entryNum);
		
		// create a label and configured its settings
		this.setText(entryNum + 1 + "");
		this.setBackground(new Color(236, 236, 236));
		this.setOpaque(true);
		this.setVerticalAlignment(SwingConstants.BOTTOM);
		this.setHorizontalAlignment(SwingConstants.RIGHT);
		this.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		this.addMouseListener(this);
		this.setBorder(boss.getBorder());
	
	}

//	// return the map entry
//	public JLabel getEntry() {
//		return entry;
//	}

	// below are the mouse listeners for hovering effects
	@Override
	public void mouseEntered(MouseEvent e) {
		this.setBackground(Color.LIGHT_GRAY);
	}
	@Override
	public void mouseExited(MouseEvent e) {
		this.setBackground(new Color(236, 236, 236));
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
