package bi.team.inventory;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import bi.team.items.Item;

@SuppressWarnings("serial")
public class InventorySlot extends JLabel implements MouseListener {

	/*
	 * initialize variables
	 */
	private Item item;

	// constructor
	public InventorySlot(int entryNum) {
		
		// create a label and configured its settings
		this.setText(entryNum + 1 + "");
		this.setBackground(new Color(236, 236, 236));
		this.setOpaque(true);
		this.setVerticalAlignment(SwingConstants.BOTTOM);
		this.setHorizontalAlignment(SwingConstants.RIGHT);
		this.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		this.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.addMouseListener(this);
		
	}
	
	// return true/false
	public boolean isEmpty() {
		return item == null;
	}
	
	// return this slot's item
	public Item getItem() {
		return item;
	}
	
	// set item for this inventory slot
	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		this.setBackground(Color.LIGHT_GRAY);
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
	
	}
	@Override
	public void mouseExited(MouseEvent arg0) {

	}
	@Override
	public void mousePressed(MouseEvent arg0) {

	}
	@Override
	public void mouseReleased(MouseEvent arg0) {

	}

}
