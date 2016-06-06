package bi.team;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
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

	// initialize variables
	private JPanel contentPane;
	private JTextField nameField;
	private JButton btnSubmit;
	private JButton btnSex_male;
	private JButton btnSex_female;
	private JToggleButton btnBarbarian;
	private JToggleButton btnElementalist;
	private JToggleButton btnChemist;
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
	private JLabel lblEnterName;
	private JLabel lblChemist;
	private JLabel lblElementalist;
	private JLabel lblBarbarian;
	private JLabel lblSwordsman;
	private JLabel lblWarlock;
	
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
		setBounds(100, 100, 650, 400);
		setTitle("BeyondInfinity");
		getContentPane().setLayout(null);

		// create a root panel
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBounds(0, 0, 644, 371);
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
		nameField.setBounds(240, 65, 163, 22);
		nameField.setColumns(10);
		nameField.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(nameField);

		// create a button to submit player name
		btnSubmit = new JButton("Let's Go!");
		btnSubmit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSubmit.setBounds(277, 337, 89, 23);
		btnSubmit.setFocusable(false);
		btnSubmit.addActionListener(this);
		contentPane.add(btnSubmit);

		// create barbarian button
		btnBarbarian = new JToggleButton("");
		btnBarbarian.setBorder(null);
		btnBarbarian.setIcon(new ImageIcon(BeyondInfinity.class.getResource("/images/heroes/barbarian_male.png")));
		btnBarbarian.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBarbarian.setBackground(null);
		btnBarbarian.setBounds(32, 192, 90, 120);
		btnBarbarian.setFocusable(false);
		btnBarbarian.addActionListener(this);
		contentPane.add(btnBarbarian);

		// create elementalist button
		btnElementalist = new JToggleButton("");
		btnElementalist.setBorder(null);
		btnElementalist.setIcon(new ImageIcon(BeyondInfinity.class.getResource("/images/heroes/elementalist_male.png")));
		btnElementalist.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnElementalist.setBackground(null);
		btnElementalist.setBounds(154, 192, 90, 120);
		btnElementalist.setFocusable(false);
		btnElementalist.addActionListener(this);
		contentPane.add(btnElementalist);

		// create chemist button
		btnChemist = new JToggleButton("");
		btnChemist.setBorder(null);
		btnChemist.setIcon(new ImageIcon(BeyondInfinity.class.getResource("/images/heroes/chemist_male.png")));
		btnChemist.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnChemist.setBackground(null);
		btnChemist.setBounds(276, 192, 90, 120);
		btnChemist.setFocusable(false);
		btnChemist.addActionListener(this);
		contentPane.add(btnChemist);

		// create swordsman button
		btnSwordsman = new JToggleButton("");
		btnSwordsman.setBorder(null);
		btnSwordsman.setIcon(new ImageIcon(BeyondInfinity.class.getResource("/images/heroes/swordsman_male.png")));
		btnSwordsman.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSwordsman.setBackground(null);
		btnSwordsman.setBounds(398, 192, 90, 120);
		btnSwordsman.setFocusable(false);
		btnSwordsman.addActionListener(this);
		contentPane.add(btnSwordsman);

		// create warlock button
		btnWarlock = new JToggleButton("");
		btnWarlock.setBorder(null);
		btnWarlock.setIcon(new ImageIcon(BeyondInfinity.class.getResource("/images/heroes/warlock_male.png")));
		btnWarlock.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnWarlock.setFocusable(false);
		btnWarlock.setBackground((Color) null);
		btnWarlock.setBounds(520, 192, 90, 120);
		btnWarlock.addActionListener(this);
		contentPane.add(btnWarlock);

		/*
		 * create hero type labels
		 */
		lblChemist = new JLabel("<html><b>Merlin</b> the Chemist</html>");
		lblChemist.setHorizontalAlignment(SwingConstants.CENTER);
		lblChemist.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblChemist.setBounds(277, 155, 89, 33);
		contentPane.add(lblChemist);

		lblElementalist = new JLabel("<html><b>Seraph</b> the Elementalist</html>");
		lblElementalist.setHorizontalAlignment(SwingConstants.CENTER);
		lblElementalist.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblElementalist.setBounds(155, 155, 89, 33);
		contentPane.add(lblElementalist);

		lblBarbarian = new JLabel("<html><b>Brynjar</b> the Barbarian</html>");
		lblBarbarian.setHorizontalAlignment(SwingConstants.CENTER);
		lblBarbarian.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblBarbarian.setBounds(33, 155, 89, 33);
		contentPane.add(lblBarbarian);

		lblSwordsman = new JLabel("<html><b>Einar</b> the Swordsman</html>");
		lblSwordsman.setHorizontalAlignment(SwingConstants.CENTER);
		lblSwordsman.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblSwordsman.setBounds(399, 155, 89, 33);
		contentPane.add(lblSwordsman);

		lblWarlock = new JLabel("<html><b>Zardeth</b> the Warlock</html>");
		lblWarlock.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarlock.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblWarlock.setBounds(521, 155, 89, 33);
		contentPane.add(lblWarlock);

		/*
		 * create gift labels
		 */
		lblChooseGift = new JLabel("Choose a Gift:");
		lblChooseGift.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblChooseGift.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseGift.setBounds(267, 337, 109, 20);
		lblChooseGift.setVisible(false);
		contentPane.add(lblChooseGift);

		lblGift_None = new JLabel("None");
		lblGift_None.setHorizontalAlignment(SwingConstants.CENTER);
		lblGift_None.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblGift_None.setBounds(32, 368, 120, 16);
		lblGift_None.setVisible(false);
		contentPane.add(lblGift_None);

		lblGift_RingOfMending = new JLabel("Ring of Mending");
		lblGift_RingOfMending.setHorizontalAlignment(SwingConstants.CENTER);
		lblGift_RingOfMending.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblGift_RingOfMending.setBounds(184, 368, 120, 16);
		lblGift_RingOfMending.setVisible(false);
		contentPane.add(lblGift_RingOfMending);

		lblGift_WillOfVanquish = new JLabel("Will of Vanquish");
		lblGift_WillOfVanquish.setHorizontalAlignment(SwingConstants.CENTER);
		lblGift_WillOfVanquish.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblGift_WillOfVanquish.setBounds(336, 368, 120, 16);
		lblGift_WillOfVanquish.setVisible(false);
		contentPane.add(lblGift_WillOfVanquish);

		lblGift_BlueOrb = new JLabel("Blue Orb");
		lblGift_BlueOrb.setHorizontalAlignment(SwingConstants.CENTER);
		lblGift_BlueOrb.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblGift_BlueOrb.setBounds(488, 368, 120, 16);
		lblGift_BlueOrb.setVisible(false);
		contentPane.add(lblGift_BlueOrb);

		/*
		 * create four gift buttons
		 */
		btnGift_None = new JToggleButton("");
		btnGift_None.setToolTipText("No starting-gift, for those feeling overly confident.");
		btnGift_None.setBounds(62, 388, 60, 60);
		btnGift_None.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGift_None.setFocusable(false);
		btnGift_None.setBackground(null);
		btnGift_None.addActionListener(this);
		btnGift_None.setVisible(false);
		contentPane.add(btnGift_None);

		btnGift_RingOfMending = new JToggleButton("");
		btnGift_RingOfMending.setToolTipText("An equipable ring which boosts the amount of health restored by health potions.");
		btnGift_RingOfMending.setBounds(214, 388, 60, 60);
		btnGift_RingOfMending.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGift_RingOfMending.setFocusable(false);
		btnGift_RingOfMending.setBackground(null);
		btnGift_RingOfMending.addActionListener(this);
		btnGift_RingOfMending.setVisible(false);
		contentPane.add(btnGift_RingOfMending);

		btnGift_WillOfVanquish = new JToggleButton("");
		btnGift_WillOfVanquish.setToolTipText("An equipable trinket that boosts attack damage for two turns upon activation.");
		btnGift_WillOfVanquish.setBounds(366, 388, 60, 60);
		btnGift_WillOfVanquish.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGift_WillOfVanquish.setFocusable(false);
		btnGift_WillOfVanquish.setBackground(null);
		btnGift_WillOfVanquish.addActionListener(this);
		btnGift_WillOfVanquish.setVisible(false);
		contentPane.add(btnGift_WillOfVanquish);

		btnGift_BlueOrb = new JToggleButton("");
		btnGift_BlueOrb.setToolTipText("Your Blue Orb starts off with an additional charge. ");
		btnGift_BlueOrb.setBounds(518, 388, 60, 60);
		btnGift_BlueOrb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGift_BlueOrb.setFocusable(false);
		btnGift_BlueOrb.setBackground(null);
		btnGift_BlueOrb.addActionListener(this);
		btnGift_BlueOrb.setVisible(false);
		contentPane.add(btnGift_BlueOrb);
		
		/*
		 * create gender choice section
		 */
		JLabel lblChooseSex = new JLabel("Choose Sex:");
		lblChooseSex.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblChooseSex.setBounds(160, 97, 70, 26);
		contentPane.add(lblChooseSex);
		
		lblEnterName = new JLabel("Enter name:");
		lblEnterName.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblEnterName.setBounds(160, 64, 70, 22);
		contentPane.add(lblEnterName);
		
		// create button for male
		btnSex_male = new JButton("");
		btnSex_male.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSex_male.setSelected(true);
		btnSex_male.setIcon(new ImageIcon(BeyondInfinity.class.getResource("/images/heroes/male.png")));
		btnSex_male.setToolTipText("Male");
		btnSex_male.setBounds(240, 98, 26, 26);
		btnSex_male.setFocusable(false);
		btnSex_male.setBackground(null);
		btnSex_male.addActionListener(this);
		contentPane.add(btnSex_male);
		
		// create button for female
		btnSex_female = new JButton("");
		btnSex_female.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSex_female.setIcon(new ImageIcon(BeyondInfinity.class.getResource("/images/heroes/female.png")));
		btnSex_female.setToolTipText("Female");
		btnSex_female.setBounds(277, 98, 26, 26);
		btnSex_female.setFocusable(false);
		btnSex_female.setBackground(null);
		btnSex_female.addActionListener(this);
		contentPane.add(btnSex_female);

		// select male by default
		paintSelectedGender(btnSex_male);
		
		/* -------------------------------------- */
		
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

		// check selected gender
		if (e.getSource() == btnSex_male) {
			paintSelectedGender(btnSex_male);
		} else if (e.getSource() == btnSex_female) {
			paintSelectedGender(btnSex_female);
		}
		
		// check selected hero
		if (e.getSource() == btnBarbarian) {
			paintSelectedHero(btnBarbarian);
			showGiftFrame();
		} else if (e.getSource() == btnElementalist) {
			paintSelectedHero(btnElementalist);
			showGiftFrame();
		} else if (e.getSource() == btnChemist) {
			paintSelectedHero(btnChemist);
			showGiftFrame();
		} else if (e.getSource() == btnSwordsman) {
			paintSelectedHero(btnSwordsman);
			showGiftFrame();
		} else if (e.getSource() == btnWarlock) {
			paintSelectedHero(btnWarlock);
			showGiftFrame();
		} else if (e.getSource() == btnSubmit) {

			// create the chosen hero
			if (btnBarbarian.isSelected())
				startGameFrame("barbarian");
			else if (btnChemist.isSelected())
				startGameFrame("chemist");
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
	
	// select & paint gender buttons
	public void paintSelectedGender(JButton selected) {
		
		// unselect
		btnSex_female.setSelected(false);
		btnSex_male.setSelected(false);
		
		// paint
		btnSex_female.setBorder(new LineBorder(Color.BLACK, 1));
		btnSex_male.setBorder(new LineBorder(Color.BLACK, 1));
		
		// configure selected button
		selected.setSelected(true);
		selected.setBorder(new LineBorder(Color.BLACK, 2));
		
		// change heroes accordingly to gender
		if (selected == btnSex_female) {
			
			// change barbarian
			lblBarbarian.setText("<html><b>Alani</b> the Barbarian</html>");
			btnBarbarian.setIcon(new ImageIcon(BeyondInfinity.class.getResource("/images/heroes/barbarian_female.png")));
			btnBarbarian.setToolTipText("Alani the Foolhardy");
			// change elementalist
			lblElementalist.setText("<html><b>Lora</b> the Elementalist</html>");
			btnElementalist.setIcon(new ImageIcon(BeyondInfinity.class.getResource("/images/heroes/elementalist_female.png")));
			btnElementalist.setToolTipText("Lora the Valiant");
			// change swordsman
			lblSwordsman.setText("<html><b>Cira</b> the Swordswomen</html>");
			btnSwordsman.setIcon(new ImageIcon(BeyondInfinity.class.getResource("/images/heroes/swordsman_female.png")));
			btnSwordsman.setToolTipText("Cira the Subjugator");
			// change warlock
			lblWarlock.setText("<html><b>Gina</b> the Warlock</html>");
			btnWarlock.setIcon(new ImageIcon(BeyondInfinity.class.getResource("/images/heroes/warlock_female.png")));
			btnWarlock.setToolTipText("Gina the Darkspring");
			// change chemist
			lblChemist.setText("<html><b>Mira</b> the Chemist</html>");
			btnChemist.setIcon(new ImageIcon(BeyondInfinity.class.getResource("/images/heroes/chemist_female.png")));
			btnChemist.setToolTipText("Mira the Despicable");
			
		} else if (selected == btnSex_male) {	
			// change barbarian
			lblBarbarian.setText("<html><b>Brynjar</b> the Barbarian</html>");
			btnBarbarian.setIcon(new ImageIcon(BeyondInfinity.class.getResource("/images/heroes/barbarian_male.png")));
			btnBarbarian.setToolTipText("Brynjar the Foolhardy");
			// change elementalist
			lblElementalist.setText("<html><b>Seraph</b> the Elementalist</html>");
			btnElementalist.setIcon(new ImageIcon(BeyondInfinity.class.getResource("/images/heroes/elementalist_male.png")));
			btnElementalist.setToolTipText("Seraph the Valiant");
			// change swordsman
			lblSwordsman.setText("<html><b>Einar</b> the Swordsman</html>");
			btnSwordsman.setIcon(new ImageIcon(BeyondInfinity.class.getResource("/images/heroes/swordsman_male.png")));
			btnSwordsman.setToolTipText("Einar the Subjugator");
			// change warlock
			lblWarlock.setText("<html><b>Zardeth</b> the Warlock</html>");
			btnWarlock.setIcon(new ImageIcon(BeyondInfinity.class.getResource("/images/heroes/warlock_male.png")));
			btnWarlock.setToolTipText("Zardeth the Darkspring");
			// change chemist
			lblChemist.setText("<html><b>Merlin</b> the Chemist</html>");
			btnChemist.setIcon(new ImageIcon(BeyondInfinity.class.getResource("/images/heroes/chemist_male.png")));
			btnChemist.setToolTipText("Merlin the Despicable");
		}
		
	}

	// frame for choosing a gift
	public void showGiftFrame() {

		// expand window height, resize & re-position
		setBounds(getX(), getY(), getWidth(), 545);
		contentPane.setBounds(0, 0, 644, 516);
		btnSubmit.setBounds(277, 482, 89, 23);

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
		int giftNum;
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

				new Game(nameField.getText(), chosenHero, giftNum);
			}
		});

		// close this frame
		dispose();

	}
	
	// select & paint hero buttons
	public void paintSelectedHero(JToggleButton selected) {

		// let only one hero be selected
		btnBarbarian.setSelected(false);
		btnElementalist.setSelected(false);
		btnChemist.setSelected(false);
		btnSwordsman.setSelected(false);
		btnWarlock.setSelected(false);
		selected.setSelected(true);

		// unpaint all hero buttons
		btnBarbarian.setBorder(new LineBorder(Color.BLACK, 0));
		btnElementalist.setBorder(new LineBorder(Color.BLACK, 0));
		btnChemist.setBorder(new LineBorder(Color.BLACK, 0));
		btnSwordsman.setBorder(new LineBorder(Color.BLACK, 0));
		btnWarlock.setBorder(new LineBorder(Color.BLACK, 0));
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

		if (btnBarbarian.isSelected())
			return btnBarbarian;
		else if (btnChemist.isSelected())
			return btnChemist;
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
