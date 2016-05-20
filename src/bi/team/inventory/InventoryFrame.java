package bi.team.inventory;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JLayeredPane;
import javax.swing.border.LineBorder;

import bi.team.items.Item;

import javax.swing.JPanel;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class InventoryFrame extends JLayeredPane {

	/*
	 * initialize variables
	 */
	private JPanel panel_inventory;
	private ArrayList<InventorySlot> invSlotsArray;
	
	// constructor
	public InventoryFrame(int parent_width, int parent_height) {
		
		// instantiate variables
		invSlotsArray = new ArrayList<InventorySlot>();
		
		/*
		 * create the main inventory frame
		 */
		setOpaque(true);
		int width = 600;
		int height = 245;
		setBounds(new Rectangle((parent_width / 2) - (width / 2), (parent_height / 2) - (height / 2) - 40,
				width, height));
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(236, 236, 236));
		setLayout(null);
		setVisible(false);
		
		/*
		 * create inventory slots
		 */
		panel_inventory = new JPanel();
		panel_inventory.setBounds(194, 15, 396, 216);
		panel_inventory.setLayout(new GridBagLayout());
		add(panel_inventory);
		
		/*
		 * create player slot items
		 */
		JLabel lblSlot_Helm = new JLabel("");
		lblSlot_Helm.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblSlot_Helm.setBounds(10, 11, 36, 36);
		add(lblSlot_Helm);
		
		JLabel lblSlot_Necklace = new JLabel("");
		lblSlot_Necklace.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblSlot_Necklace.setBounds(10, 58, 36, 36);
		add(lblSlot_Necklace);
		
		JLabel lblSlot_Chestplate = new JLabel("");
		lblSlot_Chestplate.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblSlot_Chestplate.setBounds(10, 105, 36, 36);
		add(lblSlot_Chestplate);
		
		JLabel lblSlot_Legs = new JLabel("");
		lblSlot_Legs.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblSlot_Legs.setBounds(10, 152, 36, 36);
		add(lblSlot_Legs);
		
		JLabel lblSlot_Boots = new JLabel("");
		lblSlot_Boots.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblSlot_Boots.setBounds(10, 199, 36, 36);
		add(lblSlot_Boots);
		
		JLabel lblSlot_RingOne = new JLabel("");
		lblSlot_RingOne.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblSlot_RingOne.setBounds(56, 199, 36, 36);
		add(lblSlot_RingOne);
		
		JLabel lblSlot_RingTwo = new JLabel("");
		lblSlot_RingTwo.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblSlot_RingTwo.setBounds(102, 199, 36, 36);
		add(lblSlot_RingTwo);
		
		JLabel lblSlot_Trinket = new JLabel("");
		lblSlot_Trinket.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblSlot_Trinket.setBounds(148, 199, 36, 36);
		add(lblSlot_Trinket);
		
		JLabel lblPlayerPicture = new JLabel("");
		lblPlayerPicture.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblPlayerPicture.setBounds(56, 11, 128, 177);
		add(lblPlayerPicture);
		
		// create the inventory slots
		createSlots();
		
	}
	
	// create inventory slots
	public void createSlots() {
		
		// create gridbagconstraints
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = gbc.weighty = 1.0;
		gbc.insets = new Insets(3, 3, 3, 3);
		
		// add inv slots objects to array
		for (int i = 0; i <= 67; i++) {
			invSlotsArray.add(new InventorySlot(i));
		}
		
		// iterate and display
		Iterator<InventorySlot> slots = invSlotsArray.listIterator();
		int x = 0;
		int y = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 11 && slots.hasNext(); j++) {
				gbc.gridx = x++;
				panel_inventory.add(slots.next(), gbc);
			}
			gbc.gridy = y++;
			x = 0;
		}
		
	}
	
	// add an item to inventory
	public void addItem(Item item) {
		
		Iterator<InventorySlot> slots = invSlotsArray.listIterator();
		
		// find next empty inventory slot, then add item to it
		while (slots.hasNext()) {
			InventorySlot slot = slots.next();
			if (slot.isEmpty()) {
				// TODO add item to inventory
				slot.setItem(item);
				break;
			}
		}	
		
	}
}
