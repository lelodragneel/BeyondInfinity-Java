package bi.team;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.ToolTipManager;
import javax.swing.border.LineBorder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


@SuppressWarnings("serial")
public class BeyondInfinity extends JFrame implements ActionListener {

	// init variables
	private JPanel contentPane;
	private JTextField nameField;
	private JButton btnSubmit;
	private JToggleButton btnBrutalizer;
	private JToggleButton btnElementalist;
	private JToggleButton btnAlchemist;
	private JToggleButton btnSwordsman;
	private JToggleButton btnWarlock;
	private String gameFolderPath;
	private String gameFilePath;
	private JLabel lblChooseGift;
	private JLabel lblGift_None;
	private JLabel lblGift_RingOfMending;
	private JLabel lblGift_WillOfVanquish;
	private JLabel lblGift_BlueOrb;
	private JToggleButton btnGift_None;
	private JToggleButton btnGift_RingOfMending;
	private JToggleButton btnGift_WillOfVanquish;
	private JToggleButton btnGift_BlueOrb;

	
	
	// constructor
	public BeyondInfinity() {	

//		final int defaultDismissTimeout = ToolTipManager.sharedInstance().getDismissDelay();
//
//		addMouseListener(new MouseAdapter() {
//
//		  public void mouseEntered(MouseEvent me) {
//		    ToolTipManager.sharedInstance().setInitialDelay(0);;
//		  }
//
//		  public void mouseExited(MouseEvent me) {
//		    ToolTipManager.sharedInstance().setDismissDelay(defaultDismissTimeout);
//		  }
//		});
		
		// frame initializing
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		//setBounds(100, 100, 650, 515);
		setBounds(100, 100, 650, 370);
		setTitle("BeyondInfinity");
		getContentPane().setLayout(null);

		// create a root panel
		contentPane = new JPanel();
		contentPane.setLayout(null);
		//contentPane.setBounds(0, 0, 644, 486);
		contentPane.setBounds(0, 0, 644, 341);
		contentPane.setVisible(true);
		contentPane.setBackground(new Color(236, 240, 241));
		getContentPane().add(contentPane);

		// create title label
		JLabel lblTitle = new JLabel("Welcome to BeyondInfinity!");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblTitle.setBounds(228, 11, 188, 27);
		contentPane.add(lblTitle);

		// create a field to input player name
		nameField = new JTextField();
		nameField.setBounds(238, 109, 167, 20);
		nameField.setColumns(10);
		nameField.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(nameField);

		// create a button to submit player name
		btnSubmit = new JButton("Let's Go!");
		btnSubmit.setBounds(277, 307, 89, 23);
		btnSubmit.setFocusable(false);
		btnSubmit.addActionListener(this);
		contentPane.add(btnSubmit);

		// create a label asking player to enter name
		JLabel lblOne = new JLabel("To start your adventure, enter your name below:");
		lblOne.setHorizontalAlignment(SwingConstants.CENTER);
		lblOne.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblOne.setBounds(187, 78, 272, 20);
		contentPane.add(lblOne);

		// create brutalizer button
		btnBrutalizer = new JToggleButton("");
		btnBrutalizer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBrutalizer.setBackground(null);
		btnBrutalizer.setBounds(72, 187, 90, 90);
		btnBrutalizer.setFocusable(false);
		btnBrutalizer.addActionListener(this);
		contentPane.add(btnBrutalizer);

		// create elementalist button
		btnElementalist = new JToggleButton("");
		btnElementalist.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnElementalist.setBackground(null);
		btnElementalist.setBounds(174, 187, 90, 90);
		btnElementalist.setFocusable(false);
		btnElementalist.addActionListener(this);
		contentPane.add(btnElementalist);

		// create alchemist button
		btnAlchemist = new JToggleButton("");
		btnAlchemist.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAlchemist.setBackground(null);
		btnAlchemist.setBounds(276, 187, 90, 90);
		btnAlchemist.setFocusable(false);
		btnAlchemist.addActionListener(this);
		contentPane.add(btnAlchemist);

		// create swordsman button
		btnSwordsman = new JToggleButton("");
		btnSwordsman.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSwordsman.setBackground(null);
		btnSwordsman.setBounds(377, 187, 90, 90);
		btnSwordsman.setFocusable(false);
		btnSwordsman.addActionListener(this);
		contentPane.add(btnSwordsman);

		// create warlock button
		btnWarlock = new JToggleButton("");
		btnWarlock.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnWarlock.setFocusable(false);
		btnWarlock.setBackground((Color) null);
		btnWarlock.setBounds(479, 187, 90, 90);
		btnWarlock.addActionListener(this);
		contentPane.add(btnWarlock);

		/*
		 * create hero type labels
		 */
		JLabel lblAlchemist = new JLabel("Alchemist");
		lblAlchemist.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlchemist.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblAlchemist.setBounds(277, 167, 89, 16);
		contentPane.add(lblAlchemist);

		JLabel lblElementalist = new JLabel("Elementalist");
		lblElementalist.setHorizontalAlignment(SwingConstants.CENTER);
		lblElementalist.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblElementalist.setBounds(175, 167, 89, 16);
		contentPane.add(lblElementalist);

		JLabel lblBrutalizer = new JLabel("Brutalizer");
		lblBrutalizer.setHorizontalAlignment(SwingConstants.CENTER);
		lblBrutalizer.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblBrutalizer.setBounds(73, 167, 89, 16);
		contentPane.add(lblBrutalizer);

		JLabel lblSwordsman = new JLabel("Swordsman");
		lblSwordsman.setHorizontalAlignment(SwingConstants.CENTER);
		lblSwordsman.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblSwordsman.setBounds(378, 167, 89, 16);
		contentPane.add(lblSwordsman);

		JLabel lblWarlock = new JLabel("Warlock");
		lblWarlock.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarlock.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblWarlock.setBounds(480, 167, 89, 16);
		contentPane.add(lblWarlock);

		/*
		 * create gift labels
		 */
		lblChooseGift = new JLabel("Choose a Gift:");
		lblChooseGift.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblChooseGift.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseGift.setBounds(267, 307, 109, 20);
		lblChooseGift.setVisible(false);
		contentPane.add(lblChooseGift);

		lblGift_None = new JLabel("None");
		lblGift_None.setHorizontalAlignment(SwingConstants.CENTER);
		lblGift_None.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblGift_None.setBounds(32, 338, 120, 16);
		lblGift_None.setVisible(false);
		contentPane.add(lblGift_None);

		lblGift_RingOfMending = new JLabel("Ring of Mending");
		lblGift_RingOfMending.setHorizontalAlignment(SwingConstants.CENTER);
		lblGift_RingOfMending.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblGift_RingOfMending.setBounds(184, 338, 120, 16);
		lblGift_RingOfMending.setVisible(false);
		contentPane.add(lblGift_RingOfMending);

		lblGift_WillOfVanquish = new JLabel("Will of Vanquish");
		lblGift_WillOfVanquish.setHorizontalAlignment(SwingConstants.CENTER);
		lblGift_WillOfVanquish.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblGift_WillOfVanquish.setBounds(336, 338, 120, 16);
		lblGift_WillOfVanquish.setVisible(false);
		contentPane.add(lblGift_WillOfVanquish);

		lblGift_BlueOrb = new JLabel("Blue Orb");
		lblGift_BlueOrb.setHorizontalAlignment(SwingConstants.CENTER);
		lblGift_BlueOrb.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblGift_BlueOrb.setBounds(488, 338, 120, 16);
		lblGift_BlueOrb.setVisible(false);
		contentPane.add(lblGift_BlueOrb);


		/*
		 * create four gift buttons
		 */
		btnGift_None = new JToggleButton("");
		btnGift_None.setToolTipText("No starting-gift, for those feeling overly confident.");
		btnGift_None.setBounds(62, 358, 60, 60);
		btnGift_None.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGift_None.setFocusable(false);
		btnGift_None.setBackground(null);
		btnGift_None.addActionListener(this);
		btnGift_None.setVisible(false);
		contentPane.add(btnGift_None);

		btnGift_RingOfMending = new JToggleButton("");
		btnGift_RingOfMending.setToolTipText("An equipable ring which boosts the amount of health restored by health potions.");
		btnGift_RingOfMending.setBounds(214, 358, 60, 60);
		btnGift_RingOfMending.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGift_RingOfMending.setFocusable(false);
		btnGift_RingOfMending.setBackground(null);
		btnGift_RingOfMending.addActionListener(this);
		btnGift_RingOfMending.setVisible(false);
		contentPane.add(btnGift_RingOfMending);

		btnGift_WillOfVanquish = new JToggleButton("");
		btnGift_WillOfVanquish.setToolTipText("An equipable trinket that boosts attack damage for two turns upon activation.");
		btnGift_WillOfVanquish.setBounds(366, 358, 60, 60);
		btnGift_WillOfVanquish.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGift_WillOfVanquish.setFocusable(false);
		btnGift_WillOfVanquish.setBackground(null);
		btnGift_WillOfVanquish.addActionListener(this);
		btnGift_WillOfVanquish.setVisible(false);
		contentPane.add(btnGift_WillOfVanquish);

		btnGift_BlueOrb = new JToggleButton("");
		btnGift_BlueOrb.setToolTipText("Your Blue Orb starts off with an additional charge. ");
		btnGift_BlueOrb.setBounds(518, 358, 60, 60);
		btnGift_BlueOrb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGift_BlueOrb.setFocusable(false);
		btnGift_BlueOrb.setBackground(null);
		btnGift_BlueOrb.addActionListener(this);
		btnGift_BlueOrb.setVisible(false);
		contentPane.add(btnGift_BlueOrb);

		// finally show frame
		setVisible(true);

		// checks if there has been previous progress
		checkSave();
	}

	// check appdata file status and create directories/files
	public void checkSave() {

		// create a folder path, and file path
		gameFolderPath = System.getenv().get("APPDATA") + "\\beyondInfinity";
		gameFilePath = gameFolderPath + "\\progress.xml";	
		File gameFolder = new File(gameFolderPath);
		File gameFile = new File(gameFilePath);

		// create directory if doesn't exist
		if (!gameFolder.exists()) {		
			if (gameFolder.mkdir()) { 	
				System.out.println("folder created");
			}
		}
		// create save file if doesn't exist
		if (!gameFile.exists() && gameFolder.exists()) {
			try {
				if (gameFile.createNewFile()) { 	// create xml file if doesn't exist
					System.out.println("file created");
					buildSaveFile(gameFile);
				}
			} catch (IOException e) {
				System.out.println("adghdg");
			}

		}

	}

	// build a new xml file under appdata
	public void buildSaveFile(File gameFile) {

		try {

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();

			// root element
			Element rootElement = doc.createElement("beyondinfinity");
			doc.appendChild(rootElement);

			// bosses element
			Element bosses = doc.createElement("bosses");
			rootElement.appendChild(bosses);

			// setting attribute to element
			Attr attr = doc.createAttribute("type");
			attr.setValue("mini");
			bosses.setAttributeNode(attr);

			// bossnum element
			Element bossnum1 = doc.createElement("bossnum");
			Attr attrType1 = doc.createAttribute("number");
			attrType1.setValue("1");
			bossnum1.setAttributeNode(attrType1);
			bossnum1.appendChild(
					doc.createTextNode("filler_1"));
			bosses.appendChild(bossnum1);

			Element bossnum2 = doc.createElement("bossnum");
			Attr attrType2 = doc.createAttribute("number");
			attrType2.setValue("2");
			bossnum2.setAttributeNode(attrType2);
			bossnum2.appendChild(
					doc.createTextNode("filler_2"));
			bosses.appendChild(bossnum2);

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(gameFile);
			transformer.transform(source, result);

			// output to console for testing
			System.out.println("default data written successfully");
			StreamResult consoleResult = new StreamResult(System.out);
			transformer.transform(source, consoleResult);		

		} catch (Exception e) {
			System.out.println("Couldn't create progress.xml file");
		}

	}

	// actionlistener for the submit button
	public void actionPerformed(ActionEvent e) {

		// check selected gift 
		if (e.getSource() == btnGift_None) {
			paintSelectedGift(btnGift_None);
		} else if (e.getSource() == btnGift_RingOfMending) {
			paintSelectedGift(btnGift_RingOfMending);
		} else if (e.getSource() == btnGift_WillOfVanquish) {
			paintSelectedGift(btnGift_WillOfVanquish);
		} else if (e.getSource() == btnGift_BlueOrb) {
			paintSelectedGift(btnGift_BlueOrb);
		}

		// check selected hero
		if (e.getSource() == btnBrutalizer) {
			paintSelectedHero(btnBrutalizer);
			showGiftFrame();
		} else if (e.getSource() == btnElementalist) {
			paintSelectedHero(btnElementalist);
			showGiftFrame();
		} else if (e.getSource() == btnAlchemist) {
			paintSelectedHero(btnAlchemist);
			showGiftFrame();
		} else if (e.getSource() == btnSwordsman) {
			paintSelectedHero(btnSwordsman);
			showGiftFrame();
		} else if (e.getSource() == btnWarlock) {
			paintSelectedHero(btnWarlock);
			showGiftFrame();
		} else if (e.getSource() == btnSubmit) {

			// create the chosen hero
			if (btnBrutalizer.isSelected())
				startGameFrame("brutalizer");
			else if (btnAlchemist.isSelected())
				startGameFrame("alchemist");
			else if (btnElementalist.isSelected())
				startGameFrame("elementalist");
			else if (btnSwordsman.isSelected())
				startGameFrame("swordsman");
			else if (btnWarlock.isSelected())
				startGameFrame("warlock");
			else {
				JOptionPane.showMessageDialog(this, "You forgot to select a hero!", "Alert", JOptionPane.ERROR_MESSAGE);
				return;

			}

		}
	}

	// frame for choosing a gift
	public void showGiftFrame() {

		// expand window height, resize & re-position
		setBounds(getX(), getY(), getWidth(), 515);
		contentPane.setBounds(0, 0, 644, 486);
		btnSubmit.setBounds(277, 452, 89, 23);

		// set gift components visible
		lblChooseGift.setVisible(true);
		lblGift_None.setVisible(true);
		lblGift_RingOfMending.setVisible(true);
		lblGift_BlueOrb.setVisible(true);
		lblGift_WillOfVanquish.setVisible(true);

		btnGift_None.setVisible(true);
		btnGift_RingOfMending.setVisible(true);
		btnGift_WillOfVanquish.setVisible(true);
		btnGift_BlueOrb.setVisible(true);

	}

	// start building the actual frame of the game
	public void startGameFrame(String chosenHero) {

		// get selected gift
		int giftNum = 0;
		if (btnGift_None.isSelected()) {
			giftNum = 1;
		} else if (btnGift_RingOfMending.isSelected()) {
			giftNum = 2;
		} else if (btnGift_WillOfVanquish.isSelected()) {
			giftNum = 3;
		} else if (btnGift_BlueOrb.isSelected()) {
			giftNum = 4;
		} else {
			JOptionPane.showMessageDialog(this, "You forgot to select a starting-gift!");
			return;
		}

		// safely instantiate the game frame
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				// TODO textfield validation

				new Game(nameField.getText(), chosenHero);
			}
		});

		// close this frame
		dispose();

	}

	// select & paint hero buttons
	public void paintSelectedHero(JToggleButton selected) {

		// let only one hero be selected
		btnBrutalizer.setSelected(false);
		btnElementalist.setSelected(false);
		btnAlchemist.setSelected(false);
		btnSwordsman.setSelected(false);
		btnWarlock.setSelected(false);
		selected.setSelected(true);

		// unpaint all hero buttons
		btnBrutalizer.setBorder(new LineBorder(Color.BLACK, 1));
		btnElementalist.setBorder(new LineBorder(Color.BLACK, 1));
		btnAlchemist.setBorder(new LineBorder(Color.BLACK, 1));
		btnSwordsman.setBorder(new LineBorder(Color.BLACK, 1));
		btnWarlock.setBorder(new LineBorder(Color.BLACK, 1));
		selected.setBorder(new LineBorder(Color.BLACK, 2));

	}
	
	// select & paint gift buttons
	public void paintSelectedGift(JToggleButton selected) {

		// let only one gift be selected
		btnGift_None.setSelected(false);
		btnGift_RingOfMending.setSelected(false);
		btnGift_WillOfVanquish.setSelected(false);
		btnGift_BlueOrb.setSelected(false);
		selected.setSelected(true);

		// unpaint all gift buttons
		btnGift_None.setBorder(new LineBorder(Color.BLACK, 1));
		btnGift_RingOfMending.setBorder(new LineBorder(Color.BLACK, 1));
		btnGift_WillOfVanquish.setBorder(new LineBorder(Color.BLACK, 1));
		btnGift_BlueOrb.setBorder(new LineBorder(Color.BLACK, 1));
		selected.setBorder(new LineBorder(Color.BLACK, 2));

	}
	

	// return the selected hero button
	public JToggleButton getSelectedHero() {	

		if (btnBrutalizer.isSelected())
			return btnBrutalizer;
		else if (btnAlchemist.isSelected())
			return btnAlchemist;
		else if (btnElementalist.isSelected())
			return btnElementalist;
		else if (btnSwordsman.isSelected())
			return btnSwordsman;
		else if (btnWarlock.isSelected())
			return btnWarlock;
		else return null;

	}

	// return the selected gift button
	public JToggleButton getSelectedGift() {	

		if (btnGift_None.isSelected()) {
			return btnGift_None;
		} else if (btnGift_RingOfMending.isSelected()) {
			return btnGift_RingOfMending;
		} else if (btnGift_WillOfVanquish.isSelected()) {
			return btnGift_WillOfVanquish;
		} else if (btnGift_BlueOrb.isSelected()) {
			return btnGift_BlueOrb;
		} else return null;

	}

	public static void main(String[] args) {

		// safely start welcoming screen
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new BeyondInfinity();
			}
		});
	}
}
