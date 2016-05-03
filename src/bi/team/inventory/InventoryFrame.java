package bi.team.inventory;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Rectangle;

import javax.swing.JLayeredPane;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class InventoryFrame extends JLayeredPane {

	// constructor
	public InventoryFrame(int parent_width, int parent_height) {
		
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

		// create the inventory slots
		createSlots();
		
	}
	
	// create inventory slots
	public void createSlots() {
		
	}
	
}
