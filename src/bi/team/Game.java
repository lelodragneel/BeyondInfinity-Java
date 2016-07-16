package bi.team;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

import bi.team.enemies.Enemy;
import bi.team.enemies.meadowlands.Alania_defender_of_the_meadow;
import bi.team.enemies.meadowlands.Fuehirch;
import bi.team.enemies.meadowlands.Hawk_stag;
import bi.team.enemies.meadowlands.Mantisray;
import bi.team.enemies.meadowlands.Oboko_of_the_sonne;
import bi.team.enemies.meadowlands.Shar_of_the_nacht;
import bi.team.enemies.meadowlands.Taobu;
import bi.team.heroes.Barbarian;
import bi.team.heroes.Chemist;
import bi.team.heroes.Elementalist;
import bi.team.heroes.Hero;
import bi.team.heroes.Swordsman;
import bi.team.heroes.Warlock;
import bi.team.heroes.attacks.barbarian.Attack;
import bi.team.inventory.InventoryFrame;

@SuppressWarnings("serial")
public class Game extends JFrame implements ActionListener {
  private static int turn = 1;
  private static JTextPane textPane;
  public static final String styles =
      "<style>" + "body {font-family: Comic Sans MS; background: #ECF0F1; width:300px;}"
          + "#title {color: #282830; font-size: 12px;}" + "#desc {font-size: 10px; color: #282830;}"
          + "#s01 {color: #60646D; font-size: 10px;}"
          + "#s02 {font-size: 10px; color: #282830; font-style: italic;}"
          + "#val {font-size: 10px; color: #5659C9;}" + "</style>";
  public static final String buffStyles =
      "<style>" + "body {font-family: Comic Sans MS; background: #ECF0F1; width:200px;}"
          + "#title {color: #282830; font-size: 12px;}" + "#desc {font-size: 10px; color: #282830;}"
          + "#s01 {color: #60646D; font-size: 10px;}"
          + "#s02 {font-size: 10px; color: #282830; font-style: italic;}"
          + "#val {font-size: 10px; color: #5659C9;}" + "</style>";
  private SimpleAttributeSet aSet;
  private HTMLDocument doc;
  private HTMLEditorKit editorKit;
  private JPanel panel_player;
  private JPanel panel_top;
  private JPanel panel_stats;
  private JPanel panel_enemy;
  private JPanel panel_actions;
  private JPanel panel_frameOpacity;
  private JPanel panel_areaField;
  private JPanel panel_actionsTop;
  private JPanel panel_playerBuffs;
  private JLabel areaWallpaper;
  private JLabel upgradePoints;
  private JLabel lblEnhancementPoints;
  private JLabel buff_stun = new JLabel();
  private ArrayList<JLabel> slotLabelsArrayList = new ArrayList<JLabel>();
  private ArrayList<JLabel> buffsArrayList = new ArrayList<JLabel>();
  private ArrayList<JLabel> badgesArrayList = new ArrayList<JLabel>();
  private ArrayList<JLabel> enemySlotLabelsArrayList = new ArrayList<JLabel>();
  private ArrayList<JLabel> enemyBuffsArrayList = new ArrayList<JLabel>();
  private ArrayList<JLabel> enemyBadgesArrayList = new ArrayList<JLabel>();
  private JProgressBar bar_loading;
  private JProgressBar bar_playerHealth;
  private JProgressBar bar_enemyHealth;
  private JProgressBar bar_XPBar;
  private JButton btnShowMap;
  private JButton btnShowInventory;
  private JButton btnSurrender;
  private boolean isMapShown;
  private boolean isInvShown;
  private Map map;
  private InventoryFrame inventory;
  private Hero hero;
  private ArrayList<Enemy> enemyEntries;
  private Enemy enemySelected;
  private JLabel lblLevel_current;
  private JLabel lblLevel_next;
  private JLabel lblEnemyName;
  private JLabel lblPlayerName;
  private JLabel lblEnemyImage;
  private JLabel lblPlayerImage;
  private int heroSex;
  private final String lang1;
  private JPanel panel_enemyBuffs;
  private JLabel buffSlot_1;
  private JLabel buffSlot_2;
  private JLabel buffSlot_3;
  private JLabel buffSlot_4;
  private JLabel buffSlot_5;
  private JLabel buffSlot_6;
  private JLabel buffSlot_7;
  private JLabel buffSlot_8;
  private JLabel buffSlot_9;
  private JLabel buffSlot_10;
  private JLabel buffSlot_11;
  private JLabel buffSlot_12;
  private JLabel slotPicture_1;
  private JLabel slotPicture_2;
  private JLabel slotPicture_3;
  private JLabel slotPicture_4;
  private JLabel slotPicture_5;
  private JLabel slotPicture_6;
  private JLabel slotPicture_7;
  private JLabel slotPicture_8;
  private JLabel slotPicture_9;
  private JLabel slotPicture_10;
  private JLabel slotPicture_11;
  private JLabel slotPicture_12;
  private JLabel enemyBuffSlot_1;
  private JLabel enemyBuffSlot_2;
  private JLabel enemyBuffSlot_3;
  private JLabel enemyBuffSlot_4;
  private JLabel enemyBuffSlot_5;
  private JLabel enemyBuffSlot_6;
  private JLabel enemyBuffSlot_7;
  private JLabel enemyBuffSlot_8;
  private JLabel enemyBuffSlot_9;
  private JLabel enemyBuffSlot_10;
  private JLabel enemyBuffSlot_11;
  private JLabel enemyBuffSlot_12;
  private JLabel enemySlotPicture_1;
  private JLabel enemySlotPicture_2;
  private JLabel enemySlotPicture_3;
  private JLabel enemySlotPicture_4;
  private JLabel enemySlotPicture_5;
  private JLabel enemySlotPicture_6;
  private JLabel enemySlotPicture_7;
  private JLabel enemySlotPicture_8;
  private JLabel enemySlotPicture_9;
  private JLabel enemySlotPicture_10;
  private JLabel enemySlotPicture_11;
  private JLabel enemySlotPicture_12;
  private JPanel panel_abilitiesContainer;

  /**
   * Class constructor
   * 
   * @param name Name of the player
   * @param chosenHero Chosen hero integer
   * @param heroSex Gender of the chosen hero
   * @param giftNum Chosen gift
   */
  public Game(String name, int chosenHero, int heroSex, int giftNum) {
    this.heroSex = heroSex;
    lang1 = (heroSex == 1) ? "his" : "her";
    buff_stun.setToolTipText("<html>" + Game.buffStyles + "<body> <table><tr>" + "<td><br>"
        + "<p id=\"desc\">Stunned and unable to attack.</p><br>" + "</td></tr></table>"
        + "</body><html>");
    buff_stun.setIcon(new ImageIcon(getClass().getResource("/images/buffs/buff_stun.png")));
    UIManager.put("ProgressBar.selectionForeground", new Color(236, 236, 236)); // Health bar
                                                                                // esthetics

    /* Configure tooltips delays */
    ToolTipManager.sharedInstance().setInitialDelay(500); // Show tooltips after x seconds
    ToolTipManager.sharedInstance().setDismissDelay(30000); // Dismiss tooltips in x seconds

    /* Build frame */
    this.setResizable(false);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setBounds(100, 100, 1160, 680);
    this.setTitle("[ver. alpha] BeyondInfinity");
    getContentPane().setLayout(null);
    this.setBounds(0, 0, 1140, 680);
    this.setBackground(new Color(236, 240, 241));
    this.setLocationRelativeTo(null);

    /* Create objects of all enemies */
    enemyEntries = new ArrayList<Enemy>();
    enemyEntries.add(new Fuehirch(this));
    enemyEntries.add(new Taobu(this));
    enemyEntries.add(new Hawk_stag(this));
    enemyEntries.add(new Oboko_of_the_sonne(this));
    enemyEntries.add(new Shar_of_the_nacht(this));
    enemyEntries.add(new Mantisray(this));
    enemyEntries.add(new Alania_defender_of_the_meadow(this));

    /* Create the map object/frame */
    map = new Map(this);
    getContentPane().add(map);

    /* Create the inventory panel */
    inventory = new InventoryFrame(getWidth(), getHeight());
    getContentPane().add(inventory);

    /* Create a panel that dims the frame, this is used when toggling map */
    panel_frameOpacity = new JPanel();
    panel_frameOpacity.setBounds(0, 11, 1134, 21);
    panel_frameOpacity.setBackground(new Color(0, 0, 0, 64));
    panel_frameOpacity.setOpaque(true);
    panel_frameOpacity.setVisible(false);
    getContentPane().add(panel_frameOpacity);

    /* Create left panel for displaying hero info */
    panel_player = new JPanel();
    panel_player.setBounds(20, 80, 285, 65);
    panel_player.setBackground(new Color(204, 255, 153));
    panel_player.setBorder(new LineBorder(Color.BLACK, 1));
    panel_player.setLayout(null);
    getContentPane().add(panel_player);

    /* Create top panel to display vitality (health) bars */
    panel_top = new JPanel();
    panel_top.setBounds(10, 21, 1114, 48);
    panel_top.setLayout(null);
    getContentPane().add(panel_top);

    /* Create the button that toggles map */
    btnShowMap = new JButton();
    btnShowMap.setBounds(1076, 0, 38, 38);
    btnShowMap.setFocusable(false);
    btnShowMap.setIcon(new ImageIcon(getClass().getResource("/images/map.png")));
    btnShowMap.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnShowMap.addActionListener(this);
    panel_top.add(btnShowMap);

    /* Create the button that toggles inventory */
    btnShowInventory = new JButton();
    btnShowInventory.setIcon(new ImageIcon(Game.class.getResource("/images/talent.png")));
    btnShowInventory.setBounds(1028, 0, 38, 38);
    btnShowInventory.setFocusable(false);
    btnShowInventory.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnShowInventory.addActionListener(this);
    panel_top.add(btnShowInventory);

    /* Create experience bar */
    bar_XPBar = new JProgressBar();
    bar_XPBar.setForeground(new Color(155, 89, 182));
    bar_XPBar.setFont(new Font("Comic Sans MS", Font.BOLD, 10));
    bar_XPBar.setString("");
    bar_XPBar.setValue(20);
    bar_XPBar.setBorder(new LineBorder(new Color(0, 0, 0)));
    bar_XPBar.setStringPainted(true);
    bar_XPBar.setBounds(347, 12, 420, 14);
    panel_top.add(bar_XPBar);

    /* Create icon for current level */
    lblLevel_current = new JLabel(Hero.getLevel() + "");
    lblLevel_current.setForeground(Color.WHITE);
    lblLevel_current.setHorizontalTextPosition(JLabel.CENTER);
    lblLevel_current.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
    lblLevel_current.setIcon(new ImageIcon(getClass().getResource("/images/xpcircle.png")));
    lblLevel_current.setBounds(299, 0, 38, 38);
    panel_top.add(lblLevel_current);

    /* Create icon for next level */
    lblLevel_next = new JLabel((Hero.getLevel() + 1) + "");
    lblLevel_next.setForeground(Color.WHITE);
    lblLevel_next.setHorizontalTextPosition(JLabel.CENTER);
    lblLevel_next.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
    lblLevel_next.setIcon(new ImageIcon(getClass().getResource("/images/xpcircle.png")));
    lblLevel_next.setBounds(777, 0, 38, 38);
    panel_top.add(lblLevel_next);

    /* Create the music pause/resume button */
    JButton btnMusicToggle = new JButton("");
    btnMusicToggle.setBounds(0, 0, 38, 38);
    btnMusicToggle.setFocusable(false);
    panel_top.add(btnMusicToggle);

    /* Create the volume slider */
    JSlider volumeSlider = new JSlider();
    volumeSlider.setBounds(38, 6, 140, 26);
    panel_top.add(volumeSlider);

    /* Create bottom panel to display buttons for upgrades */
    panel_stats = new JPanel();
    panel_stats.setBounds(10, 436, 1114, 87);
    panel_stats.setLayout(new GridLayout(0, 5, 0, 0));
    getContentPane().add(panel_stats);

    /* Create right panel for displaying enemy info */
    panel_enemy = new JPanel();
    panel_enemy.setBackground(new Color(204, 255, 153));
    panel_enemy.setBounds(829, 80, 285, 87);
    panel_enemy.setBorder(new LineBorder(Color.BLACK, 1));
    panel_enemy.setLayout(null);
    panel_enemy.setVisible(false);
    getContentPane().add(panel_enemy);

    /* Create actions panel for displaying attack buttons */
    panel_actions = new JPanel();
    panel_actions.setBorder(new EmptyBorder(10, 10, 10, 10));
    panel_actions.setBounds(10, 568, 1114, 72);
    panel_actions.setBackground(new Color(135, 211, 124));
    panel_actions.setLayout(new GridLayout(0, 6, 10, 0));
    getContentPane().add(panel_actions);

    /* Create top actions panel */
    panel_actionsTop = new JPanel();
    panel_actionsTop.setBounds(10, 534, 1114, 34);
    panel_actionsTop.setLayout(null);
    getContentPane().add(panel_actionsTop);

    /* Create label to display upgrade points */
    lblEnhancementPoints = new JLabel("<html>Enhancement Points: <b>0</b></html>");
    lblEnhancementPoints.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
    lblEnhancementPoints.setBounds(482, 9, 150, 16);
    panel_actionsTop.add(lblEnhancementPoints);

    /* Create the surrender button */
    btnSurrender = new JButton("");
    btnSurrender.setBounds(1080, 0, 34, 34);
    btnSurrender.setFocusable(false);
    btnSurrender.addActionListener(this);
    btnSurrender.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnSurrender.setIcon(new ImageIcon(getClass().getResource("/images/suicide.png")));
    btnSurrender.setVisible(false);
    panel_actionsTop.add(btnSurrender);

    /* Create the loading bar */
    bar_loading = new JProgressBar();
    bar_loading.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
    bar_loading.setDoubleBuffered(true);
    bar_loading.setBounds(0, 0, 1134, 10);
    bar_loading.setBorder(null);
    bar_loading.setValue(100);
    bar_loading.setForeground(new Color(52, 73, 94));
    getContentPane().add(bar_loading);

    /* Create player health icon */
    JLabel lblHeartPlayer = new JLabel("");
    lblHeartPlayer.setForeground(Color.WHITE);
    lblHeartPlayer.setHorizontalTextPosition(JLabel.CENTER);
    lblHeartPlayer.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
    lblHeartPlayer.setBounds(2, 3, 32, 32);
    lblHeartPlayer.setIcon(new ImageIcon(getClass().getResource("/images/heart.png")));
    panel_player.add(lblHeartPlayer);

    /* Create enemy health icon */
    JLabel lblHeartEnemy = new JLabel("");
    lblHeartEnemy.setForeground(Color.WHITE);
    lblHeartEnemy.setHorizontalTextPosition(JLabel.CENTER);
    lblHeartEnemy.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
    lblHeartEnemy.setBounds(2, 3, 32, 32);
    lblHeartEnemy.setIcon(new ImageIcon(getClass().getResource("/images/heart.png")));
    panel_enemy.add(lblHeartEnemy);

    /* Create the player health bar */
    bar_playerHealth = new JProgressBar();
    bar_playerHealth.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
    bar_playerHealth.setStringPainted(true);
    bar_playerHealth.setBounds(26, 11, 249, 16);
    bar_playerHealth.setString("");
    bar_playerHealth.setBorder(new LineBorder(new Color(0, 0, 0)));
    bar_playerHealth.setForeground(new Color(68, 108, 179));
    panel_player.add(bar_playerHealth);

    /* Create the enemy health bar */
    bar_enemyHealth = new JProgressBar();
    bar_enemyHealth.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
    bar_enemyHealth.setStringPainted(true);
    bar_enemyHealth.setBounds(26, 11, 249, 16);
    bar_enemyHealth.setString("");
    bar_enemyHealth.setBorder(new LineBorder(new Color(0, 0, 0)));
    bar_enemyHealth.setForeground(new Color(68, 108, 179));
    panel_enemy.add(bar_enemyHealth);

    /* Create subpanel to hold a gridlayout panel for enemy abilities */
    JPanel subpanel_enemyAbilities = new JPanel();
    subpanel_enemyAbilities.setBounds(1, 40, 283, 45);
    subpanel_enemyAbilities.setLayout(new BorderLayout(0, 0));
    panel_enemy.add(subpanel_enemyAbilities);

    /* Create panel to display enemy abilities */
    panel_abilitiesContainer = new JPanel();
    panel_abilitiesContainer.setLayout(new GridLayout(0, 6, 1, 0));
    panel_abilitiesContainer.setBackground(new Color(204, 255, 153));
    subpanel_enemyAbilities.add(panel_abilitiesContainer, BorderLayout.CENTER);

    /* Build panel for displaying player buffs & debuffs */
    panel_playerBuffs = new JPanel();
    panel_playerBuffs.setBounds(262, 184, 71, 226);
    panel_playerBuffs.setOpaque(false);
    panel_playerBuffs.setLayout(new GridLayout(6, 2, 1, 1));
    getContentPane().add(panel_playerBuffs);

    /* Create player buff slot 1 */
    JPanel buffContainer_1 = new JPanel();
    buffContainer_1.setOpaque(false);
    buffContainer_1.setLayout(null);
    panel_playerBuffs.add(buffContainer_1);

    JPanel badgePanel_1 = new JPanel();
    badgePanel_1.setOpaque(false);
    badgePanel_1.setBounds(15, 16, 20, 20);
    badgePanel_1.setLayout(null);
    buffContainer_1.add(badgePanel_1);

    buffSlot_1 = new JLabel("");
    buffSlot_1.setBounds(0, 0, 20, 20);
    buffSlot_1.setHorizontalTextPosition(SwingConstants.CENTER);
    buffSlot_1.setHorizontalAlignment(SwingConstants.CENTER);
    buffSlot_1.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    buffSlot_1.setIcon(new ImageIcon(getClass().getResource("/images/buffs/circle.png")));
    badgePanel_1.add(buffSlot_1);

    slotPicture_1 = new JLabel("");
    slotPicture_1.setHorizontalAlignment(SwingConstants.CENTER);
    slotPicture_1.setBounds(0, 0, 35, 36);
    buffContainer_1.add(slotPicture_1);

    /* Create player buff slot 7 */
    JPanel buffContainer_7 = new JPanel();
    buffContainer_7.setOpaque(false);
    buffContainer_7.setLayout(null);
    panel_playerBuffs.add(buffContainer_7);

    JPanel badgePanel_7 = new JPanel();
    badgePanel_7.setLayout(null);
    badgePanel_7.setOpaque(false);
    badgePanel_7.setBounds(15, 16, 20, 20);
    buffContainer_7.add(badgePanel_7);

    buffSlot_7 = new JLabel("");
    buffSlot_7.setHorizontalTextPosition(SwingConstants.CENTER);
    buffSlot_7.setHorizontalAlignment(SwingConstants.CENTER);
    buffSlot_7.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    buffSlot_7.setIcon(new ImageIcon(getClass().getResource("/images/buffs/circle.png")));
    buffSlot_7.setBounds(0, 0, 20, 20);
    badgePanel_7.add(buffSlot_7);

    slotPicture_7 = new JLabel("");
    slotPicture_7.setHorizontalAlignment(SwingConstants.CENTER);
    slotPicture_7.setBounds(0, 0, 35, 36);
    buffContainer_7.add(slotPicture_7);

    /* Create player buff slot 2 */
    JPanel buffContainer_2 = new JPanel();
    buffContainer_2.setOpaque(false);
    buffContainer_2.setLayout(null);
    panel_playerBuffs.add(buffContainer_2);

    JPanel badgePanel_2 = new JPanel();
    badgePanel_2.setLayout(null);
    badgePanel_2.setOpaque(false);
    badgePanel_2.setBounds(15, 16, 20, 20);
    buffContainer_2.add(badgePanel_2);

    buffSlot_2 = new JLabel("");
    buffSlot_2.setHorizontalTextPosition(SwingConstants.CENTER);
    buffSlot_2.setHorizontalAlignment(SwingConstants.CENTER);
    buffSlot_2.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    buffSlot_2.setIcon(new ImageIcon(getClass().getResource("/images/buffs/circle.png")));
    buffSlot_2.setBounds(0, 0, 20, 20);
    badgePanel_2.add(buffSlot_2);

    slotPicture_2 = new JLabel("");
    slotPicture_2.setHorizontalAlignment(SwingConstants.CENTER);
    slotPicture_2.setBounds(0, 0, 35, 36);
    buffContainer_2.add(slotPicture_2);

    /* Create player buff slot 8 */
    JPanel buffContainer_8 = new JPanel();
    buffContainer_8.setOpaque(false);
    buffContainer_8.setLayout(null);
    panel_playerBuffs.add(buffContainer_8);

    JPanel badgePanel_8 = new JPanel();
    badgePanel_8.setLayout(null);
    badgePanel_8.setOpaque(false);
    badgePanel_8.setBounds(15, 16, 20, 20);
    buffContainer_8.add(badgePanel_8);

    buffSlot_8 = new JLabel("");
    buffSlot_8.setHorizontalTextPosition(SwingConstants.CENTER);
    buffSlot_8.setHorizontalAlignment(SwingConstants.CENTER);
    buffSlot_8.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    buffSlot_8.setIcon(new ImageIcon(getClass().getResource("/images/buffs/circle.png")));
    buffSlot_8.setBounds(0, 0, 20, 20);
    badgePanel_8.add(buffSlot_8);

    slotPicture_8 = new JLabel("");
    slotPicture_8.setHorizontalAlignment(SwingConstants.CENTER);
    slotPicture_8.setBounds(0, 0, 35, 36);
    buffContainer_8.add(slotPicture_8);

    /* Create player buff slot 3 */
    JPanel buffContainer_3 = new JPanel();
    buffContainer_3.setOpaque(false);
    buffContainer_3.setLayout(null);
    panel_playerBuffs.add(buffContainer_3);

    JPanel badgePanel_3 = new JPanel();
    badgePanel_3.setLayout(null);
    badgePanel_3.setOpaque(false);
    badgePanel_3.setBounds(15, 16, 20, 20);
    buffContainer_3.add(badgePanel_3);

    buffSlot_3 = new JLabel("");
    buffSlot_3.setHorizontalTextPosition(SwingConstants.CENTER);
    buffSlot_3.setHorizontalAlignment(SwingConstants.CENTER);
    buffSlot_3.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    buffSlot_3.setIcon(new ImageIcon(getClass().getResource("/images/buffs/circle.png")));
    buffSlot_3.setBounds(0, 0, 20, 20);
    badgePanel_3.add(buffSlot_3);

    slotPicture_3 = new JLabel("");
    slotPicture_3.setHorizontalAlignment(SwingConstants.CENTER);
    slotPicture_3.setBounds(0, 0, 35, 36);
    buffContainer_3.add(slotPicture_3);

    /* Create player buff slot 9 */
    JPanel buffContainer_9 = new JPanel();
    buffContainer_9.setOpaque(false);
    buffContainer_9.setLayout(null);
    panel_playerBuffs.add(buffContainer_9);

    JPanel badgePanel_9 = new JPanel();
    badgePanel_9.setLayout(null);
    badgePanel_9.setOpaque(false);
    badgePanel_9.setBounds(15, 16, 20, 20);
    buffContainer_9.add(badgePanel_9);

    buffSlot_9 = new JLabel("");
    buffSlot_9.setHorizontalTextPosition(SwingConstants.CENTER);
    buffSlot_9.setHorizontalAlignment(SwingConstants.CENTER);
    buffSlot_9.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    buffSlot_9.setIcon(new ImageIcon(getClass().getResource("/images/buffs/circle.png")));
    buffSlot_9.setBounds(0, 0, 20, 20);
    badgePanel_9.add(buffSlot_9);

    slotPicture_9 = new JLabel("");
    slotPicture_9.setHorizontalAlignment(SwingConstants.CENTER);
    slotPicture_9.setBounds(0, 0, 35, 36);
    buffContainer_9.add(slotPicture_9);

    /* Create player buff slot 4 */
    JPanel buffContainer_4 = new JPanel();
    buffContainer_4.setOpaque(false);
    buffContainer_4.setLayout(null);
    panel_playerBuffs.add(buffContainer_4);

    JPanel badgePanel_4 = new JPanel();
    badgePanel_4.setLayout(null);
    badgePanel_4.setOpaque(false);
    badgePanel_4.setBounds(15, 16, 20, 20);
    buffContainer_4.add(badgePanel_4);

    buffSlot_4 = new JLabel("");
    buffSlot_4.setHorizontalTextPosition(SwingConstants.CENTER);
    buffSlot_4.setHorizontalAlignment(SwingConstants.CENTER);
    buffSlot_4.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    buffSlot_4.setIcon(new ImageIcon(getClass().getResource("/images/buffs/circle.png")));
    buffSlot_4.setBounds(0, 0, 20, 20);
    badgePanel_4.add(buffSlot_4);

    slotPicture_4 = new JLabel("");
    slotPicture_4.setHorizontalAlignment(SwingConstants.CENTER);
    slotPicture_4.setBounds(0, 0, 35, 36);
    buffContainer_4.add(slotPicture_4);

    /* Create player buff slot 10 */
    JPanel buffContainer_10 = new JPanel();
    buffContainer_10.setOpaque(false);
    buffContainer_10.setLayout(null);
    panel_playerBuffs.add(buffContainer_10);

    JPanel badgePanel_10 = new JPanel();
    badgePanel_10.setLayout(null);
    badgePanel_10.setOpaque(false);
    badgePanel_10.setBounds(15, 16, 20, 20);
    buffContainer_10.add(badgePanel_10);

    buffSlot_10 = new JLabel("");
    buffSlot_10.setHorizontalTextPosition(SwingConstants.CENTER);
    buffSlot_10.setHorizontalAlignment(SwingConstants.CENTER);
    buffSlot_10.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    buffSlot_10.setIcon(new ImageIcon(getClass().getResource("/images/buffs/circle.png")));
    buffSlot_10.setBounds(0, 0, 20, 20);
    badgePanel_10.add(buffSlot_10);

    slotPicture_10 = new JLabel("");
    slotPicture_10.setHorizontalAlignment(SwingConstants.CENTER);
    slotPicture_10.setBounds(0, 0, 35, 36);
    buffContainer_10.add(slotPicture_10);

    /* Create player buff slot 5 */
    JPanel buffContainer_5 = new JPanel();
    buffContainer_5.setOpaque(false);
    buffContainer_5.setLayout(null);
    panel_playerBuffs.add(buffContainer_5);

    JPanel badgePanel_5 = new JPanel();
    badgePanel_5.setLayout(null);
    badgePanel_5.setOpaque(false);
    badgePanel_5.setBounds(15, 16, 20, 20);
    buffContainer_5.add(badgePanel_5);

    buffSlot_5 = new JLabel("");
    buffSlot_5.setHorizontalTextPosition(SwingConstants.CENTER);
    buffSlot_5.setHorizontalAlignment(SwingConstants.CENTER);
    buffSlot_5.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    buffSlot_5.setIcon(new ImageIcon(getClass().getResource("/images/buffs/circle.png")));
    buffSlot_5.setBounds(0, 0, 20, 20);
    badgePanel_5.add(buffSlot_5);

    slotPicture_5 = new JLabel("");
    slotPicture_5.setHorizontalAlignment(SwingConstants.CENTER);
    slotPicture_5.setBounds(0, 0, 35, 36);
    buffContainer_5.add(slotPicture_5);

    /* Create player buff slot 11 */
    JPanel buffContainer_11 = new JPanel();
    buffContainer_11.setOpaque(false);
    buffContainer_11.setLayout(null);
    panel_playerBuffs.add(buffContainer_11);

    JPanel badgePanel_11 = new JPanel();
    badgePanel_11.setLayout(null);
    badgePanel_11.setOpaque(false);
    badgePanel_11.setBounds(15, 16, 20, 20);
    buffContainer_11.add(badgePanel_11);

    buffSlot_11 = new JLabel("");
    buffSlot_11.setHorizontalTextPosition(SwingConstants.CENTER);
    buffSlot_11.setHorizontalAlignment(SwingConstants.CENTER);
    buffSlot_11.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    buffSlot_11.setIcon(new ImageIcon(getClass().getResource("/images/buffs/circle.png")));
    buffSlot_11.setBounds(0, 0, 20, 20);
    badgePanel_11.add(buffSlot_11);

    slotPicture_11 = new JLabel("");
    slotPicture_11.setHorizontalAlignment(SwingConstants.CENTER);
    slotPicture_11.setBounds(0, 0, 35, 36);
    buffContainer_11.add(slotPicture_11);

    /* Create player buff slot 6 */
    JPanel buffContainer_6 = new JPanel();
    buffContainer_6.setOpaque(false);
    buffContainer_6.setLayout(null);
    panel_playerBuffs.add(buffContainer_6);

    JPanel badgePanel_6 = new JPanel();
    badgePanel_6.setLayout(null);
    badgePanel_6.setOpaque(false);
    badgePanel_6.setBounds(15, 16, 20, 20);
    buffContainer_6.add(badgePanel_6);

    buffSlot_6 = new JLabel("");
    buffSlot_6.setHorizontalTextPosition(SwingConstants.CENTER);
    buffSlot_6.setHorizontalAlignment(SwingConstants.CENTER);
    buffSlot_6.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    buffSlot_6.setIcon(new ImageIcon(getClass().getResource("/images/buffs/circle.png")));
    buffSlot_6.setBounds(0, 0, 20, 20);
    badgePanel_6.add(buffSlot_6);

    slotPicture_6 = new JLabel("");
    slotPicture_6.setHorizontalAlignment(SwingConstants.CENTER);
    slotPicture_6.setBounds(0, 0, 35, 36);
    buffContainer_6.add(slotPicture_6);

    /* Create player buff slot 12 */
    JPanel buffContainer_12 = new JPanel();
    buffContainer_12.setOpaque(false);
    buffContainer_12.setLayout(null);
    panel_playerBuffs.add(buffContainer_12);

    JPanel badgePanel_12 = new JPanel();
    badgePanel_12.setLayout(null);
    badgePanel_12.setOpaque(false);
    badgePanel_12.setBounds(15, 16, 20, 20);
    buffContainer_12.add(badgePanel_12);

    buffSlot_12 = new JLabel("");
    buffSlot_12.setHorizontalTextPosition(SwingConstants.CENTER);
    buffSlot_12.setHorizontalAlignment(SwingConstants.CENTER);
    buffSlot_12.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    buffSlot_12.setIcon(new ImageIcon(getClass().getResource("/images/buffs/circle.png")));
    buffSlot_12.setBounds(0, 0, 20, 20);
    badgePanel_12.add(buffSlot_12);

    slotPicture_12 = new JLabel("");
    slotPicture_12.setHorizontalAlignment(SwingConstants.CENTER);
    slotPicture_12.setBounds(0, 0, 35, 36);
    buffContainer_12.add(slotPicture_12);

    /* Add all slots to arraylist */
    slotLabelsArrayList.add(slotPicture_1);
    slotLabelsArrayList.add(slotPicture_2);
    slotLabelsArrayList.add(slotPicture_3);
    slotLabelsArrayList.add(slotPicture_4);
    slotLabelsArrayList.add(slotPicture_5);
    slotLabelsArrayList.add(slotPicture_6);
    slotLabelsArrayList.add(slotPicture_7);
    slotLabelsArrayList.add(slotPicture_8);
    slotLabelsArrayList.add(slotPicture_9);
    slotLabelsArrayList.add(slotPicture_10);
    slotLabelsArrayList.add(slotPicture_11);
    slotLabelsArrayList.add(slotPicture_12);
    badgesArrayList.add(buffSlot_1);
    badgesArrayList.add(buffSlot_2);
    badgesArrayList.add(buffSlot_3);
    badgesArrayList.add(buffSlot_4);
    badgesArrayList.add(buffSlot_5);
    badgesArrayList.add(buffSlot_6);
    badgesArrayList.add(buffSlot_7);
    badgesArrayList.add(buffSlot_8);
    badgesArrayList.add(buffSlot_9);
    badgesArrayList.add(buffSlot_10);
    badgesArrayList.add(buffSlot_11);
    badgesArrayList.add(buffSlot_12);

    /* Build panel for displaying enemy buffs & debuffs */
    panel_enemyBuffs = new JPanel();
    panel_enemyBuffs.setBounds(800, 184, 71, 226);
    panel_enemyBuffs.setOpaque(false);
    panel_enemyBuffs.setLayout(new GridLayout(6, 2, 2, 2));
    getContentPane().add(panel_enemyBuffs);

    /* Create enemy buff slot 7 */
    JPanel enemyBuffContainer_7 = new JPanel();
    enemyBuffContainer_7.setOpaque(false);
    enemyBuffContainer_7.setLayout(null);
    panel_enemyBuffs.add(enemyBuffContainer_7);

    JPanel enemyBadgePanel_7 = new JPanel();
    enemyBadgePanel_7.setLayout(null);
    enemyBadgePanel_7.setOpaque(false);
    enemyBadgePanel_7.setBounds(15, 16, 20, 20);
    enemyBuffContainer_7.add(enemyBadgePanel_7);

    enemyBuffSlot_7 = new JLabel("");
    enemyBuffSlot_7.setHorizontalTextPosition(SwingConstants.CENTER);
    enemyBuffSlot_7.setHorizontalAlignment(SwingConstants.CENTER);
    enemyBuffSlot_7.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    enemyBuffSlot_7.setIcon(new ImageIcon(getClass().getResource("/images/buffs/circle.png")));
    enemyBuffSlot_7.setBounds(0, 0, 20, 20);
    enemyBadgePanel_7.add(enemyBuffSlot_7);

    enemySlotPicture_7 = new JLabel("");
    enemySlotPicture_7.setHorizontalAlignment(SwingConstants.CENTER);
    enemySlotPicture_7.setBounds(0, 0, 35, 36);
    enemyBuffContainer_7.add(enemySlotPicture_7);

    /* Create enemy buff slot 1 */
    JPanel enemyBuffContainer_1 = new JPanel();
    enemyBuffContainer_1.setOpaque(false);
    enemyBuffContainer_1.setLayout(null);
    panel_enemyBuffs.add(enemyBuffContainer_1);

    JPanel enemyBadgePanel_1 = new JPanel();
    enemyBadgePanel_1.setOpaque(false);
    enemyBadgePanel_1.setBounds(15, 16, 20, 20);
    enemyBadgePanel_1.setLayout(null);
    enemyBuffContainer_1.add(enemyBadgePanel_1);

    enemyBuffSlot_1 = new JLabel("");
    enemyBuffSlot_1.setBounds(0, 0, 20, 20);
    enemyBuffSlot_1.setHorizontalTextPosition(SwingConstants.CENTER);
    enemyBuffSlot_1.setHorizontalAlignment(SwingConstants.CENTER);
    enemyBuffSlot_1.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    enemyBuffSlot_1.setIcon(new ImageIcon(getClass().getResource("/images/buffs/circle.png")));
    enemyBadgePanel_1.add(enemyBuffSlot_1);

    enemySlotPicture_1 = new JLabel("");
    enemySlotPicture_1.setBounds(0, 0, 35, 36);
    enemySlotPicture_1.setHorizontalAlignment(SwingConstants.CENTER);
    enemyBuffContainer_1.add(enemySlotPicture_1);

    /* Create player buff slot 8 */
    JPanel enemyBuffContainer_8 = new JPanel();
    enemyBuffContainer_8.setOpaque(false);
    enemyBuffContainer_8.setLayout(null);
    panel_enemyBuffs.add(enemyBuffContainer_8);

    JPanel enemyBadgePanel_8 = new JPanel();
    enemyBadgePanel_8.setLayout(null);
    enemyBadgePanel_8.setOpaque(false);
    enemyBadgePanel_8.setBounds(15, 16, 20, 20);
    enemyBuffContainer_8.add(enemyBadgePanel_8);

    enemyBuffSlot_8 = new JLabel("");
    enemyBuffSlot_8.setHorizontalTextPosition(SwingConstants.CENTER);
    enemyBuffSlot_8.setHorizontalAlignment(SwingConstants.CENTER);
    enemyBuffSlot_8.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    enemyBuffSlot_8.setIcon(new ImageIcon(getClass().getResource("/images/buffs/circle.png")));
    enemyBuffSlot_8.setBounds(0, 0, 20, 20);
    enemyBadgePanel_8.add(enemyBuffSlot_8);

    enemySlotPicture_8 = new JLabel("");
    enemySlotPicture_8.setHorizontalAlignment(SwingConstants.CENTER);
    enemySlotPicture_8.setBounds(0, 0, 35, 36);
    enemyBuffContainer_8.add(enemySlotPicture_8);

    /* Create enemy buff slot 2 */
    JPanel enemyBuffContainer_2 = new JPanel();
    enemyBuffContainer_2.setOpaque(false);
    enemyBuffContainer_2.setLayout(null);
    panel_enemyBuffs.add(enemyBuffContainer_2);

    JPanel enemyBadgePanel_2 = new JPanel();
    enemyBadgePanel_2.setLayout(null);
    enemyBadgePanel_2.setOpaque(false);
    enemyBadgePanel_2.setBounds(15, 16, 20, 20);
    enemyBuffContainer_2.add(enemyBadgePanel_2);

    enemyBuffSlot_2 = new JLabel("");
    enemyBuffSlot_2.setHorizontalTextPosition(SwingConstants.CENTER);
    enemyBuffSlot_2.setHorizontalAlignment(SwingConstants.CENTER);
    enemyBuffSlot_2.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    enemyBuffSlot_2.setIcon(new ImageIcon(getClass().getResource("/images/buffs/circle.png")));
    enemyBuffSlot_2.setBounds(0, 0, 20, 20);
    enemyBadgePanel_2.add(enemyBuffSlot_2);

    enemySlotPicture_2 = new JLabel("");
    enemySlotPicture_2.setHorizontalAlignment(SwingConstants.CENTER);
    enemySlotPicture_2.setBounds(0, 0, 35, 36);
    enemyBuffContainer_2.add(enemySlotPicture_2);

    /* Create player buff slot 3 */
    JPanel enemyBuffContainer_9 = new JPanel();
    enemyBuffContainer_9.setOpaque(false);
    enemyBuffContainer_9.setLayout(null);
    panel_enemyBuffs.add(enemyBuffContainer_9);

    JPanel enemyBadgePanel_9 = new JPanel();
    enemyBadgePanel_9.setLayout(null);
    enemyBadgePanel_9.setOpaque(false);
    enemyBadgePanel_9.setBounds(15, 16, 20, 20);
    enemyBuffContainer_9.add(enemyBadgePanel_9);

    enemyBuffSlot_9 = new JLabel("");
    enemyBuffSlot_9.setHorizontalTextPosition(SwingConstants.CENTER);
    enemyBuffSlot_9.setHorizontalAlignment(SwingConstants.CENTER);
    enemyBuffSlot_9.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    enemyBuffSlot_9.setIcon(new ImageIcon(getClass().getResource("/images/buffs/circle.png")));
    enemyBuffSlot_9.setBounds(0, 0, 20, 20);
    enemyBadgePanel_9.add(enemyBuffSlot_9);

    enemySlotPicture_9 = new JLabel("");
    enemySlotPicture_9.setHorizontalAlignment(SwingConstants.CENTER);
    enemySlotPicture_9.setBounds(0, 0, 35, 36);
    enemyBuffContainer_9.add(enemySlotPicture_9);

    /* Create enemy buff slot 3 */
    JPanel enemyBuffContainer_3 = new JPanel();
    enemyBuffContainer_3.setOpaque(false);
    enemyBuffContainer_3.setLayout(null);
    panel_enemyBuffs.add(enemyBuffContainer_3);

    JPanel enemyBadgePanel_3 = new JPanel();
    enemyBadgePanel_3.setLayout(null);
    enemyBadgePanel_3.setOpaque(false);
    enemyBadgePanel_3.setBounds(15, 16, 20, 20);
    enemyBuffContainer_3.add(enemyBadgePanel_3);

    enemyBuffSlot_3 = new JLabel("");
    enemyBuffSlot_3.setHorizontalTextPosition(SwingConstants.CENTER);
    enemyBuffSlot_3.setHorizontalAlignment(SwingConstants.CENTER);
    enemyBuffSlot_3.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    enemyBuffSlot_3.setIcon(new ImageIcon(getClass().getResource("/images/buffs/circle.png")));
    enemyBuffSlot_3.setBounds(0, 0, 20, 20);
    enemyBadgePanel_3.add(enemyBuffSlot_3);

    enemySlotPicture_3 = new JLabel("");
    enemySlotPicture_3.setHorizontalAlignment(SwingConstants.CENTER);
    enemySlotPicture_3.setBounds(0, 0, 35, 36);
    buffContainer_3.add(enemySlotPicture_3);

    /* Create player buff slot 10 */
    JPanel enemyBuffContainer_10 = new JPanel();
    enemyBuffContainer_10.setOpaque(false);
    enemyBuffContainer_10.setLayout(null);
    panel_enemyBuffs.add(enemyBuffContainer_10);

    JPanel enemyBadgePanel_10 = new JPanel();
    enemyBadgePanel_10.setLayout(null);
    enemyBadgePanel_10.setOpaque(false);
    enemyBadgePanel_10.setBounds(15, 16, 20, 20);
    enemyBuffContainer_10.add(enemyBadgePanel_10);

    enemyBuffSlot_10 = new JLabel("");
    enemyBuffSlot_10.setHorizontalTextPosition(SwingConstants.CENTER);
    enemyBuffSlot_10.setHorizontalAlignment(SwingConstants.CENTER);
    enemyBuffSlot_10.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    enemyBuffSlot_10.setIcon(new ImageIcon(getClass().getResource("/images/buffs/circle.png")));
    enemyBuffSlot_10.setBounds(0, 0, 20, 20);
    enemyBadgePanel_10.add(enemyBuffSlot_10);

    enemySlotPicture_10 = new JLabel("");
    enemySlotPicture_10.setHorizontalAlignment(SwingConstants.CENTER);
    enemySlotPicture_10.setBounds(0, 0, 35, 36);
    enemyBuffContainer_10.add(enemySlotPicture_10);

    /* Create enemy buff slot 4 */
    JPanel enemyBuffContainer_4 = new JPanel();
    enemyBuffContainer_4.setOpaque(false);
    enemyBuffContainer_4.setLayout(null);
    panel_enemyBuffs.add(enemyBuffContainer_4);

    JPanel enemyBadgePanel_4 = new JPanel();
    enemyBadgePanel_4.setLayout(null);
    enemyBadgePanel_4.setOpaque(false);
    enemyBadgePanel_4.setBounds(15, 16, 20, 20);
    enemyBuffContainer_4.add(enemyBadgePanel_4);

    enemyBuffSlot_4 = new JLabel("");
    enemyBuffSlot_4.setHorizontalTextPosition(SwingConstants.CENTER);
    enemyBuffSlot_4.setHorizontalAlignment(SwingConstants.CENTER);
    enemyBuffSlot_4.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    enemyBuffSlot_4.setIcon(new ImageIcon(getClass().getResource("/images/buffs/circle.png")));
    enemyBuffSlot_4.setBounds(0, 0, 20, 20);
    enemyBadgePanel_4.add(enemyBuffSlot_4);

    enemySlotPicture_4 = new JLabel("");
    enemySlotPicture_4.setHorizontalAlignment(SwingConstants.CENTER);
    enemySlotPicture_4.setBounds(0, 0, 35, 36);
    enemyBuffContainer_4.add(enemySlotPicture_4);

    /* Create player buff slot 11 */
    JPanel enemyBuffContainer_11 = new JPanel();
    enemyBuffContainer_11.setOpaque(false);
    enemyBuffContainer_11.setLayout(null);
    panel_enemyBuffs.add(enemyBuffContainer_11);

    JPanel enemyBadgePanel_11 = new JPanel();
    enemyBadgePanel_11.setLayout(null);
    enemyBadgePanel_11.setOpaque(false);
    enemyBadgePanel_11.setBounds(15, 16, 20, 20);
    enemyBuffContainer_11.add(enemyBadgePanel_11);

    enemyBuffSlot_11 = new JLabel("");
    enemyBuffSlot_11.setHorizontalTextPosition(SwingConstants.CENTER);
    enemyBuffSlot_11.setHorizontalAlignment(SwingConstants.CENTER);
    enemyBuffSlot_11.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    enemyBuffSlot_11.setIcon(new ImageIcon(getClass().getResource("/images/buffs/circle.png")));
    enemyBuffSlot_11.setBounds(0, 0, 20, 20);
    enemyBadgePanel_11.add(enemyBuffSlot_11);

    enemySlotPicture_11 = new JLabel("");
    enemySlotPicture_11.setHorizontalAlignment(SwingConstants.CENTER);
    enemySlotPicture_11.setBounds(0, 0, 35, 36);
    enemyBuffContainer_11.add(enemySlotPicture_11);

    /* Create enemy buff slot 5 */
    JPanel enemyBuffContainer_5 = new JPanel();
    enemyBuffContainer_5.setOpaque(false);
    enemyBuffContainer_5.setLayout(null);
    panel_enemyBuffs.add(enemyBuffContainer_5);

    JPanel enemyBadgePanel_5 = new JPanel();
    enemyBadgePanel_5.setLayout(null);
    enemyBadgePanel_5.setOpaque(false);
    enemyBadgePanel_5.setBounds(15, 16, 20, 20);
    enemyBuffContainer_5.add(enemyBadgePanel_5);

    enemyBuffSlot_5 = new JLabel("");
    enemyBuffSlot_5.setHorizontalTextPosition(SwingConstants.CENTER);
    enemyBuffSlot_5.setHorizontalAlignment(SwingConstants.CENTER);
    enemyBuffSlot_5.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    enemyBuffSlot_5.setIcon(new ImageIcon(getClass().getResource("/images/buffs/circle.png")));
    enemyBuffSlot_5.setBounds(0, 0, 20, 20);
    enemyBadgePanel_5.add(enemyBuffSlot_5);

    enemySlotPicture_5 = new JLabel("");
    enemySlotPicture_5.setHorizontalAlignment(SwingConstants.CENTER);
    enemySlotPicture_5.setBounds(0, 0, 35, 36);
    enemyBuffContainer_5.add(enemySlotPicture_5);

    /* Create player buff slot 12 */
    JPanel enemyBuffContainer_12 = new JPanel();
    enemyBuffContainer_12.setOpaque(false);
    enemyBuffContainer_12.setLayout(null);
    panel_enemyBuffs.add(enemyBuffContainer_12);

    JPanel enemyBadgePanel_12 = new JPanel();
    enemyBadgePanel_12.setLayout(null);
    enemyBadgePanel_12.setOpaque(false);
    enemyBadgePanel_12.setBounds(15, 16, 20, 20);
    enemyBuffContainer_12.add(enemyBadgePanel_12);

    enemyBuffSlot_12 = new JLabel("");
    enemyBuffSlot_12.setHorizontalTextPosition(SwingConstants.CENTER);
    enemyBuffSlot_12.setHorizontalAlignment(SwingConstants.CENTER);
    enemyBuffSlot_12.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    enemyBuffSlot_12.setIcon(new ImageIcon(getClass().getResource("/images/buffs/circle.png")));
    enemyBuffSlot_12.setBounds(0, 0, 20, 20);
    enemyBadgePanel_12.add(enemyBuffSlot_12);

    enemySlotPicture_12 = new JLabel("");
    enemySlotPicture_12.setHorizontalAlignment(SwingConstants.CENTER);
    enemySlotPicture_12.setBounds(0, 0, 35, 36);
    enemyBuffContainer_12.add(enemySlotPicture_12);

    /* Create enemy buff slot 6 */
    JPanel enemyBuffContainer_6 = new JPanel();
    enemyBuffContainer_6.setOpaque(false);
    enemyBuffContainer_6.setLayout(null);
    panel_enemyBuffs.add(enemyBuffContainer_6);

    JPanel enemyBadgePanel_6 = new JPanel();
    enemyBadgePanel_6.setLayout(null);
    enemyBadgePanel_6.setOpaque(false);
    enemyBadgePanel_6.setBounds(15, 16, 20, 20);
    enemyBuffContainer_6.add(enemyBadgePanel_6);

    enemyBuffSlot_6 = new JLabel("");
    enemyBuffSlot_6.setHorizontalTextPosition(SwingConstants.CENTER);
    enemyBuffSlot_6.setHorizontalAlignment(SwingConstants.CENTER);
    enemyBuffSlot_6.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    enemyBuffSlot_6.setIcon(new ImageIcon(getClass().getResource("/images/buffs/circle.png")));
    enemyBuffSlot_6.setBounds(0, 0, 20, 20);
    enemyBadgePanel_6.add(enemyBuffSlot_6);

    enemySlotPicture_6 = new JLabel("");
    enemySlotPicture_6.setHorizontalAlignment(SwingConstants.CENTER);
    enemySlotPicture_6.setBounds(0, 0, 35, 36);
    enemyBuffContainer_6.add(enemySlotPicture_6);

    /* Add label buff slots to enemy array list */
    enemySlotLabelsArrayList.add(enemySlotPicture_1);
    enemySlotLabelsArrayList.add(enemySlotPicture_2);
    enemySlotLabelsArrayList.add(enemySlotPicture_3);
    enemySlotLabelsArrayList.add(enemySlotPicture_4);
    enemySlotLabelsArrayList.add(enemySlotPicture_5);
    enemySlotLabelsArrayList.add(enemySlotPicture_6);
    enemySlotLabelsArrayList.add(enemySlotPicture_7);
    enemySlotLabelsArrayList.add(enemySlotPicture_8);
    enemySlotLabelsArrayList.add(enemySlotPicture_9);
    enemySlotLabelsArrayList.add(enemySlotPicture_10);
    enemySlotLabelsArrayList.add(enemySlotPicture_11);
    enemySlotLabelsArrayList.add(enemySlotPicture_12);
    enemyBadgesArrayList.add(enemyBuffSlot_1);
    enemyBadgesArrayList.add(enemyBuffSlot_2);
    enemyBadgesArrayList.add(enemyBuffSlot_3);
    enemyBadgesArrayList.add(enemyBuffSlot_4);
    enemyBadgesArrayList.add(enemyBuffSlot_5);
    enemyBadgesArrayList.add(enemyBuffSlot_6);
    enemyBadgesArrayList.add(enemyBuffSlot_7);
    enemyBadgesArrayList.add(enemyBuffSlot_8);
    enemyBadgesArrayList.add(enemyBuffSlot_9);
    enemyBadgesArrayList.add(enemyBuffSlot_10);
    enemyBadgesArrayList.add(enemyBuffSlot_11);
    enemyBadgesArrayList.add(enemyBuffSlot_12);

    /* Create panel for displaying area wallpaper */
    panel_areaField = new JPanel();
    panel_areaField.setBounds(10, 70, 1114, 353);
    panel_areaField.setBorder(new LineBorder(new Color(0, 0, 0)));
    panel_areaField.setLayout(null);
    getContentPane().add(panel_areaField);

    /* Create the area which displays event changes */
    textPane = new JTextPane();
    textPane.setEditable(false);
    textPane.setOpaque(false);
    textPane.setBorder(null);
    textPane.setFont(new Font("Comic Sans MS", 0, 14));
    textPane.setAutoscrolls(true);
    textPane.setBounds(297, 20, 450, 293);
    textPane.setContentType("text/html");
    doc = (HTMLDocument) textPane.getDocument();
    editorKit = (HTMLEditorKit) textPane.getEditorKit();

    /* Create scrolling for text area */
    JScrollPane scroll = new JScrollPane(textPane);
    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
    scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    scroll.setAutoscrolls(true);
    scroll.setBounds(390, 0, 333, 342);
    scroll.setOpaque(false);
    scroll.setBorder(null);
    scroll.getViewport().setOpaque(false);
    panel_areaField.add(scroll);

    /* Create the enemy's picture */
    lblEnemyImage = new JLabel("");
    lblEnemyImage.setHorizontalAlignment(SwingConstants.CENTER);
    lblEnemyImage.setBounds(861, 120, 200, 222);
    panel_areaField.add(lblEnemyImage);

    /* Create label to display player's name */
    lblPlayerName = new JLabel(name);
    lblPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
    lblPlayerName.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
    lblPlayerName.setBounds(10, 77, 285, 20);
    panel_areaField.add(lblPlayerName);

    /* Create the player's picture */
    lblPlayerImage = new JLabel("");
    lblPlayerImage.setHorizontalAlignment(SwingConstants.CENTER);
    lblPlayerImage.setVerticalAlignment(SwingConstants.BOTTOM);
    lblPlayerImage.setBounds(52, 120, 200, 222);
    panel_areaField.add(lblPlayerImage);

    /* Create the enemy's name */
    lblEnemyName = new JLabel("");
    lblEnemyName.setHorizontalAlignment(SwingConstants.CENTER);
    lblEnemyName.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
    lblEnemyName.setBounds(819, 99, 285, 20);
    panel_areaField.add(lblEnemyName);

    /* Create label to display area image */
    areaWallpaper = new JLabel();
    areaWallpaper.setBounds(0, 0, 1114, 353);
    areaWallpaper.setIcon(new ImageIcon(getClass().getResource("/images/areas/meadowlands.jpg")));
    panel_areaField.add(areaWallpaper);

    /* Create selected hero */
    if (chosenHero == 1) {
      this.hero = new Barbarian(this, heroSex);
    } else if (chosenHero == 2) {
      this.hero = new Chemist(this, heroSex);
    } else if (chosenHero == 3) {
      this.hero = new Elementalist(this, heroSex);
    } else if (chosenHero == 4) {
      this.hero = new Swordsman(this, heroSex);
    } else if (chosenHero == 5) {
      this.hero = new Warlock(this, heroSex);
    }

    setVisible(true); // Finally, show frame
  }

  @Override
  public void actionPerformed(ActionEvent evt) {
    if (evt.getSource() == btnShowMap) {
      toggleMap();
    } else if (evt.getSource() == btnShowInventory) {
      toggleInventory();
    } else if (evt.getSource() == btnSurrender) {
      hero.surrender(true);
    }
  }

  /**
   * Updates the visual of the hero buffs & debuffs
   */
  public void repaintBuffs() {

    /* Check player burn */
    try { // Remove expired burns
      int size = hero.getBurnArrayList().size();
      for (int i = 0; i < size; i++) {
        if (hero.getBurnArrayList().get(i).getTurnsLeft() <= 0) {
          int index = buffsArrayList.indexOf(hero.getBurnArrayList().get(i));
          hero.getBurnArrayList().remove(i);
          buffsArrayList.remove(index);
          slotLabelsArrayList.get(index).setIcon(null);
          slotLabelsArrayList.get(index).setToolTipText("");
          badgesArrayList.get(index).setText("");
        }
      }
      for (int i = 0; i < hero.getBurnArrayList().size(); i++) { // Add burn label to buff slot
        if (!buffsArrayList.contains(hero.getBurnArrayList().get(i))) {
          buffsArrayList.add(hero.getBurnArrayList().get(i));
        }
      }
    } catch (Exception e) {
    }

    /* Check enemy burn */
    try { // Remove expired burns
      int size = enemySelected.getEnemyBurnArrayList().size();
      for (int i = 0; i < size; i++) {
        if (enemySelected.getEnemyBurnArrayList().get(i).getTurnsLeft() <= 0) {
          int index = enemyBuffsArrayList.indexOf(enemySelected.getEnemyBurnArrayList().get(i));
          enemySelected.getEnemyBurnArrayList().remove(i);
          enemyBuffsArrayList.remove(index);
          enemySlotLabelsArrayList.get(index).setIcon(null);
          enemySlotLabelsArrayList.get(index).setToolTipText("");
          enemyBadgesArrayList.get(index).setText("");
        }
      }
      for (int i = 0; i < enemySelected.getEnemyBurnArrayList().size(); i++) { // Add burn label to
                                                                               // buff slot
        if (!enemyBuffsArrayList.contains(enemySelected.getEnemyBurnArrayList().get(i))) {
          enemyBuffsArrayList.add(enemySelected.getEnemyBurnArrayList().get(i));
        }
      }
    } catch (Exception e) {
    }

    /* Repaint player buffs */
    for (int i = 0; i < slotLabelsArrayList.size(); i++) {
      if (i < buffsArrayList.size()) {
        slotLabelsArrayList.get(i).setIcon(buffsArrayList.get(i).getIcon());
        slotLabelsArrayList.get(i).setToolTipText(buffsArrayList.get(i).getToolTipText());
        slotLabelsArrayList.get(i).setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        if (buffsArrayList.get(i) instanceof Burn) {
          badgesArrayList.get(i).setText(((Burn) buffsArrayList.get(i)).getTurnsLeft() + "");
          badgesArrayList.get(i).setVisible(true);
        }
      } else {
        slotLabelsArrayList.get(i).setIcon(null);
        slotLabelsArrayList.get(i).setToolTipText("");
        slotLabelsArrayList.get(i).setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        badgesArrayList.get(i).setText("");
        badgesArrayList.get(i).setVisible(false);
      }
    }

    /* Repaint enemy buffs */
    for (int i = 0; i < enemySlotLabelsArrayList.size(); i++) {
      if (i < enemyBuffsArrayList.size()) {
        enemySlotLabelsArrayList.get(i).setIcon(enemyBuffsArrayList.get(i).getIcon());
        enemySlotLabelsArrayList.get(i).setToolTipText(enemyBuffsArrayList.get(i).getToolTipText());
        enemySlotLabelsArrayList.get(i).setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      } else {
        enemySlotLabelsArrayList.get(i).setIcon(null);
        enemySlotLabelsArrayList.get(i).setToolTipText("");
        enemySlotLabelsArrayList.get(i)
            .setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        enemyBadgesArrayList.get(i).setText("");
        enemyBadgesArrayList.get(i).setVisible(false);
      }
    }

    /* Check stun */
    try { // Player
      if (hero.getTurnsStunned() > 0) {
        if (!buffsArrayList.contains(buff_stun)) { // Add stun buff icon
          hero.addBuff(buff_stun);
        }
        for (int i = 0; i < buffsArrayList.size(); i++) { // Add badge to stun buff
          if (buffsArrayList.get(i) == buff_stun) {
            badgesArrayList.get(i).setVisible(true);
            badgesArrayList.get(i).setText(hero.getTurnsStunned() + "");
          }
        }
      } else {
        if (buffsArrayList.contains(buff_stun)) { // Remove stun buff icon
          int index = buffsArrayList.indexOf(buff_stun);
          hero.removeBuff(buff_stun);
          badgesArrayList.get(index).setText("");
          badgesArrayList.get(index).setVisible(false);
        }
      }
    } catch (Exception e) {
    }
    try { // Enemy
      if (enemySelected.getTurnsStunned() > 0) {
        if (!enemyBuffsArrayList.contains(buff_stun)) { // Add stun buff icon
          enemySelected.addBuff(buff_stun);
        }
        for (int i = 0; i < enemyBuffsArrayList.size(); i++) { // Add badge to stun buff
          if (enemyBuffsArrayList.get(i) == buff_stun) {
            enemyBadgesArrayList.get(i).setVisible(true);
            enemyBadgesArrayList.get(i).setText(enemySelected.getTurnsStunned() + "");
          }
        }
      } else {
        if (enemyBuffsArrayList.contains(buff_stun)) { // Remove stun buff icon
          int index = enemyBuffsArrayList.indexOf(buff_stun);
          enemySelected.removeBuff(buff_stun);
          enemyBadgesArrayList.get(index).setText("");
          enemyBadgesArrayList.get(index).setVisible(false);
        }
      }
    } catch (Exception e) {
    }
  }

  /**
   * Toggle the map pane
   */
  public void toggleMap() {

    // Toggle between true and false
    isMapShown = !isMapShown;

    if (isMapShown) { // Open map
      map.setEnemyFocused(null);
      map.getLblEnemyIcon().setIcon(null);
      map.getLblEnemyName().setText("");
      map.getBtnChallenge().setEnabled(false);
      map.setVisible(true);
      panel_frameOpacity.setVisible(true);
      disableAttackButtons();
      hero.disableStanceButtons();
      btnShowInventory.setEnabled(false);
      btnSurrender.setEnabled(false);
      repaintUpgradeButtons();
    } else { // Close map
      map.setEnemyFocused(null);
      map.setVisible(false);
      panel_frameOpacity.setVisible(false);
      hero.enableStanceButtons();
      btnShowInventory.setEnabled(true);
      repaintUpgradeButtons();
      if (enemySelected != null) { // If a fight is active
        btnSurrender.setVisible(true);
        btnSurrender.setEnabled(true);
        enableAttackButtons();
      }
    }
    repaint(); // Repaint frame to avoid graphical glitches
  }

  /**
   * Toggle the inventory pane
   */
  public void toggleInventory() {
    isInvShown = !isInvShown; // Toggle between true and false

    if (isInvShown) {
      repaintUpgradeButtons();
      inventory.setVisible(true);
      panel_frameOpacity.setVisible(true);
      disableAttackButtons();
      hero.disableStanceButtons();
    } else {
      repaintUpgradeButtons();
      inventory.setVisible(false);
      panel_frameOpacity.setVisible(false);
      enableAttackButtons();
      hero.enableStanceButtons();
    }
    repaint(); // Repaint frame to avoid graphical glitches
  }

  /**
   * Set all attack buttons to active
   */
  public void enableAttackButtons() {
    for (Attack x : hero.getAttacksArrayList())
      x.getButton().setEnabled(true);
  }

  /**
   * Set all attack buttons to inactive
   */
  public void disableAttackButtons() {
    for (Attack x : hero.getAttacksArrayList())
      x.getButton().setEnabled(false);
  }

  /**
   * Updates the visual of the player level & experience bar
   */
  public void repaintXpBar() {

    /* Update experience bar */
    bar_XPBar.setMaximum((int) Math.round(getMaximumXp()));
    bar_XPBar.setValue((int) Math.round(Hero.curExperience));
    bar_XPBar.setString(
        (int) Math.round(Hero.curExperience) + " / " + (int) Math.round(getMaximumXp()) + " XP");

    /* Update level indicators */
    lblLevel_current.setText(Hero.getLevel() + "");
    if ((Hero.getLevel() + 1) >= Hero.getMaxLevel()) {
      lblLevel_next.setText(Hero.getMaxLevel() + "");
    } else {
      lblLevel_next.setText((Hero.getLevel() + 1) + "");
    }
    repaint();
  }

  /**
   * Updates the visual of the upgrade buttons
   */
  public void repaintUpgradeButtons() {
    if (hero.getEnhancementPoints() >= 1) {
      hero.showUpgradeButtons();
      if ((isMapShown) || (enemySelected != null)) {
        hero.disableUpgradeButtons();
      } else {
        hero.enableUpgradeButtons();
      }
    } else {
      hero.hideUpgradeButtons();
    }
    repaint();
  }

  /**
   * Updates the visual of the player & enemy health bars
   */
  public void repaintHealthBars() {

    /* Paint hero health bar */
    bar_playerHealth.setMaximum((int) Math.round(hero.getMaxHealth()));
    if (hero.getCurHealth() <= 0) {
      bar_playerHealth.setValue(0);
      bar_playerHealth.setString("dead");
    } else {
      bar_playerHealth.setValue((int) Math.round(hero.getCurHealth()));
      bar_playerHealth.setString(
          (int) Math.round(hero.getCurHealth()) + " / " + (int) Math.round(hero.getMaxHealth()));
    }

    /* Paint enemy health bar */
    if (enemySelected != null) {
      bar_enemyHealth.setMaximum((int) enemySelected.getMaxHealth());
      if (enemySelected.getCurHealth() <= 0) {
        bar_enemyHealth.setValue(0);
        bar_enemyHealth.setString("dead");
      } else {
        bar_enemyHealth.setValue((int) Math.round(enemySelected.getCurHealth()));
        bar_enemyHealth.setString((int) Math.round(enemySelected.getCurHealth()) + " / "
            + (int) Math.round(enemySelected.getMaxHealth()));
      }
    }
    repaint();
  }

  /**
   * Paint event in the middle of the screen
   * 
   */
  public void paintEvent(ImageIcon leftImage, String msg, ImageIcon rightImage) {
    String left = "";
    String right = "";

    if (leftImage != null) {
      left = "<img style=\"width:42px; height:42px;\" src=\"" + leftImage + "\">";
    }
    if (rightImage != null) {
      right = "<img style=\"width:42px; height:42px;\" src=\"" + rightImage + "\">";
    }

    String html = ("<center><table><tr><td>" + left
        + "</td><td><span style=\"vertical-align:middle; font:12px Comic Sans MS;\">" + msg
        + "</span></td><td>" + right + "</td></tr></table></center>");

    /* Display events */
    textPane.setCaretPosition(textPane.getDocument().getLength());
    try {
      editorKit.insertHTML(doc, doc.getLength(), html, 0, 0, null);
    } catch (BadLocationException | IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * @return an integer of the maximum experience of the hero's current level
   */
  public double getMaximumXp() {
    return ((Math.pow(Hero.getLevel(), 2)) * 1.2) + 210;
  }

  /**
   * @return the panel_stats
   */
  public JPanel getPanel_stats() {
    return panel_stats;
  }

  /**
   * @return the top panel
   */
  public JPanel getPanel_top() {
    return panel_top;
  }

  /**
   * Set value for the loading bar
   * 
   * @param val Progress bar integer value
   */
  public void setBar_loading(int val) {
    bar_loading.setValue(val);
  }

  /**
   * @return the loading bar
   */
  public JProgressBar getBar_loading() {
    return bar_loading;
  }

  /**
   * @return the lblEnemyName
   */
  public JLabel getLblEnemyName() {
    return lblEnemyName;
  }

  /**
   * @return the lblPlayerName
   */
  public JLabel getLblPlayerName() {
    return lblPlayerName;
  }

  /**
   * @return the stun buff
   */
  public JLabel getBuff_stun() {
    return buff_stun;
  }

  /**
   * @return true if it's an even number
   * @return false if it's an even number
   */
  public static boolean getTurn() {
    if (turn == 1) {
      return true;
    } else {
      return (turn % 2) != 0;
    }
  }

  /**
   * @return the number of the current turn the player is on
   */
  public static int getTurnNum() {
    return turn;
  }

  /**
   * Increment turn by 1
   */
  public static void addTurn() {
    turn += 1;
  }

  /**
   * @return the panel_enemy
   */
  public JPanel getPanel_enemy() {
    return panel_enemy;
  }

  /**
   * Set the turn
   * 
   * @param turn Integer value
   */
  public static void setTurn(int turn) {
    Game.turn = turn;
  }

  /**
   * @return the aSet
   */
  public SimpleAttributeSet getaSet() {
    return aSet;
  }

  /**
   * @return the panel that displays all enemy abilities in a grid
   */
  public JPanel getPanel_abilitiesContainer() {
    return panel_abilitiesContainer;
  }

  /**
   * @return the lblEnemyImage
   */
  public JLabel getLblEnemyImage() {
    return lblEnemyImage;
  }

  /**
   * @return the lblPlayerImage
   */
  public JLabel getLblPlayerImage() {
    return lblPlayerImage;
  }

  /**
   * @return the panel_actions
   */
  public JPanel getPanel_actions() {
    return panel_actions;
  }

  /**
   * @return the enemySelected
   */
  public Enemy getEnemySelected() {
    return enemySelected;
  }

  /**
   * @return the surrender button
   */
  public JButton getBtnSurrender() {
    return btnSurrender;
  }

  /**
   * Set enemy
   * 
   * @param enemySelected Enemy object currently fighting
   */
  public void setEnemySelected(Enemy enemySelected) {
    this.enemySelected = enemySelected;
  }

  /**
   * @return the panel_player
   */
  public JPanel getPanel_player() {
    return panel_player;
  }

  /**
   * @return the number of enhancement points
   */
  public JLabel getLblEnhancementPoints() {
    return lblEnhancementPoints;
  }

  /**
   * Set the the number of enhancement points
   * 
   * @param lblUpgradePoints Set a string from upgrade points
   */
  public void setLblUpgradePoints(JLabel lblUpgradePoints) {
    this.lblEnhancementPoints = lblUpgradePoints;
  }

  /**
   * @return the player
   */
  public Hero getHero() {
    return hero;
  }

  /**
   * @return the textArea
   */
  public JTextPane getTextPane() {
    return textPane;
  }

  /**
   * @return the bar_playerHealth
   */
  public JProgressBar getBar_playerHealth() {
    return bar_playerHealth;
  }

  /**
   * @return the bar_enemyHealth
   */
  public JProgressBar getBar_enemyHealth() {
    return bar_enemyHealth;
  }

  /**
   * @return the enemyEntries
   */
  public ArrayList<Enemy> getEnemyEntries() {
    return enemyEntries;
  }

  /**
   * @return the upgradePoints
   */
  public JLabel getUpgradePoints() {
    return upgradePoints;
  }

  /**
   * @return the panel_actionsTop
   */
  public JPanel getPanel_actionsTop() {
    return panel_actionsTop;
  }

  /**
   * @return the bar_XPBar
   */
  public JProgressBar getBar_XPBar() {
    return bar_XPBar;
  }

  /**
   * @return the array of player the buffs/debuffs
   */
  public ArrayList<JLabel> getBuffsArrayList() {
    return buffsArrayList;
  }

  /**
   * @return the array of enemy the buffs/debuffs
   */
  public ArrayList<JLabel> getEnemyBuffsArrayList() {
    return enemyBuffsArrayList;
  }

  /**
   * @return the heroSex
   */
  public int getHeroSex() {
    return heroSex;
  }

  /**
   * @return the HTMLDocument
   */
  public HTMLDocument getDoc() {
    return doc;
  }

  /**
   * @return the HTMLEditorKit
   */
  public HTMLEditorKit getEditorKit() {
    return editorKit;
  }

  /**
   * Set the upgradePoints
   * 
   * @param upgradePoints Integer for earned upgrade points
   */
  public void setUpgradePoints(JLabel upgradePoints) {
    this.upgradePoints = upgradePoints;
  }

  /**
   * @return the map
   */
  public Map getMap() {
    return map;
  }

  /**
   * @return a string ("his" / "her") according to the hero's gender
   */
  public String getLang1() {
    return lang1;
  }
}
