package bi.team.heroes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.BadLocationException;

import bi.team.Game;
import bi.team.Load;
import bi.team.enemies.Enemy;
import bi.team.heroes.attacks.barbarian.Attack;
import bi.team.heroes.attacks.barbarian.Battler_bash;
import bi.team.heroes.attacks.barbarian.Charge;
import bi.team.heroes.attacks.barbarian.Heavy_blow;
import bi.team.heroes.attacks.barbarian.Incapacitate;
import bi.team.heroes.attacks.barbarian.Massacre;
import bi.team.heroes.attacks.barbarian.Rage_incite;
import bi.team.heroes.attacks.barbarian.Raise_shield;
import bi.team.heroes.attacks.barbarian.Shield_bash;
import bi.team.heroes.attacks.barbarian.Strike;
import bi.team.heroes.attacks.barbarian.True_assault;
import bi.team.heroes.attacks.barbarian.Vengeance;


public class Barbarian extends Hero implements ActionListener {
  private Load load;
  private JLabel lblVitality;
  private JLabel lblRage;
  private JLabel lblSharpness;
  private JLabel lblToughness;
  private JLabel lblRiposteChance;
  private JLabel lblRage_1;
  private JLabel lblRage_2;
  private JLabel lblRage_3;
  private JLabel lblRage_5;
  private JLabel lblRage_6;
  private JLabel lblRage_7;
  private JLabel lblRage_4;
  private JLabel lblRage_8;
  private JButton btnOffensive;
  private JButton btnDefensive;
  private ArrayList<JLabel> rageIcons;
  private double curVitality;
  private double maxVitality;
  private int curRage;
  private int maxRage;
  private double sharpness;
  private double toughness;
  private double riposteChance;
  private ImageIcon maleImage;
  private ImageIcon femaleImage;
  private ImageIcon defensiveIcon;
  private ImageIcon defensiveIcon_small;
  private ImageIcon offensiveIcon;
  private ImageIcon offensiveIcon_small;
  private double dmgMultiplier;

  /**
   * Class constructor
   * 
   * @param game The main game
   */
  public Barbarian(Game game) {
    super(game);

    load = new Load(game, this);
    AttacksArrayList = new ArrayList<Attack>();
    maxVitality = 100;
    curVitality = 100;
    maxRage = 6;
    curRage = 0;
    sharpness = 10;
    toughness = 5;
    riposteChance = 10;
    dmgMultiplier = 1;
    maleImage = new ImageIcon(getClass().getResource("/images/heroes/barbarian_male_big.png"));
    femaleImage = new ImageIcon(getClass().getResource("/images/heroes/barbarian_female_big.png"));
    defensiveIcon = new ImageIcon(getClass().getResource("/images/stance_defensive.png"));
    defensiveIcon_small =
        new ImageIcon(getClass().getResource("/images/stance_defensive_small.png"));
    offensiveIcon = new ImageIcon(getClass().getResource("/images/stance_offensive.png"));
    offensiveIcon_small =
        new ImageIcon(getClass().getResource("/images/stance_offensive_small.png"));

    /* Configure player GUI */
    game.getBar_playerHealth().setMinimum(0);
    game.getBar_playerHealth().setMaximum((int) maxVitality);
    game.getBar_playerHealth().setValue((int) curVitality);
    game.getBar_playerHealth().setString(curVitality + " / " + maxVitality);

    /* Create this class's attacks */
    AttacksArrayList.add(new Strike(this, game));
    AttacksArrayList.add(new Heavy_blow(this, game));
    AttacksArrayList.add(new Rage_incite(this, game));
    AttacksArrayList.add(new Vengeance(this, game));
    AttacksArrayList.add(new Battler_bash(this, game));
    AttacksArrayList.add(new True_assault(this, game));
    AttacksArrayList.add(new Strike(this, game));
    AttacksArrayList.add(new Charge(this, game));
    AttacksArrayList.add(new Raise_shield(this, game));
    AttacksArrayList.add(new Incapacitate(this, game));
    AttacksArrayList.add(new Shield_bash(this, game));
    AttacksArrayList.add(new Massacre(this, game));

    /* Create and initialize attack buttons */
    for (Attack x : AttacksArrayList) {
      x.getButton().addActionListener(this);
      x.getButton().setEnabled(false);
    }

    /* Create panel for stance buttons */
    panel_stances = new JPanel();
    panel_stances.setBounds(0, 0, 68, 34);
    panel_stances.setBackground(new Color(135, 211, 124));
    panel_stances.setLayout(null);
    game.getPanel_actionsTop().add(panel_stances);

    /* Create offensive stance */
    btnOffensive = new JButton("");
    btnOffensive.setBounds(4, 4, 26, 26);
    btnOffensive.setFocusable(false);
    btnOffensive.setBackground(null);
    btnOffensive.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnOffensive.addActionListener(this);
    panel_stances.add(btnOffensive);

    /* Create defensive stance */
    btnDefensive = new JButton("");
    btnDefensive.setBounds(36, 4, 26, 26);
    btnDefensive.setFocusable(false);
    btnDefensive.setBackground(null);
    btnDefensive.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnDefensive.addActionListener(this);
    panel_stances.add(btnDefensive);

    /* ------------- vitality panel ------------- */
    /* Create panel for vitality */
    JPanel panel_vitality = new JPanel();
    panel_vitality.setBorder(
        new TitledBorder(null, "Vitality", TitledBorder.LEADING, TitledBorder.TOP, null, null));
    panel_vitality.setLayout(null);
    game.getPanel_stats().add(panel_vitality);

    /* Create vitality icon */
    JLabel lblHealhIcon = new JLabel("");
    lblHealhIcon.setBounds(10, 16, 24, 24);
    lblHealhIcon.setIcon(new ImageIcon(getClass().getResource("/images/vitality.png")));
    panel_vitality.add(lblHealhIcon);

    /* Create vitality upgrade button */
    btnUpgradeStat_1 = new JButton("+");
    btnUpgradeStat_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
    btnUpgradeStat_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    btnUpgradeStat_1.setFocusable(false);
    btnUpgradeStat_1.setBounds(170, 16, 28, 28);
    btnUpgradeStat_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnUpgradeStat_1.setVisible(false);
    panel_vitality.add(btnUpgradeStat_1);

    /* Create the label that displays the maximum vitality value */
    lblVitality = new JLabel(curVitality + "/" + maxVitality);
    lblVitality.setBounds(44, 16, 116, 24);
    panel_vitality.add(lblVitality);

    /* Create vitality description label */
    JLabel lblVitalityDesc = new JLabel("<html>Your maximum health.</html>");
    lblVitalityDesc.setVerticalAlignment(SwingConstants.TOP);
    lblVitalityDesc.setForeground(Color.DARK_GRAY);
    lblVitalityDesc.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
    lblVitalityDesc.setBounds(10, 51, 188, 27);
    panel_vitality.add(lblVitalityDesc);

    /* ------------- rage panel ------------- */
    /* Create panel for rage */
    JPanel panel_rage = new JPanel();
    panel_rage.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Rage",
        TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
    panel_rage.setLayout(null);
    game.getPanel_stats().add(panel_rage);

    /* Create rage icon */
    JLabel lblRageIcon = new JLabel("");
    lblRageIcon.setBounds(10, 16, 24, 24);
    lblRageIcon.setIcon(new ImageIcon(getClass().getResource("/images/rage.png")));
    panel_rage.add(lblRageIcon);

    /* Create rage upgrade button */
    btnUpgradeStat_2 = new JButton("+");
    btnUpgradeStat_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
    btnUpgradeStat_2.setFocusable(false);
    btnUpgradeStat_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    btnUpgradeStat_2.setBounds(170, 16, 28, 28);
    btnUpgradeStat_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnUpgradeStat_2.setVisible(false);
    panel_rage.add(btnUpgradeStat_2);

    /* Create the label that displays rage value */
    lblRage = new JLabel(curRage + "/" + maxRage);
    lblRage.setBounds(44, 16, 116, 24);
    panel_rage.add(lblRage);

    /* Create rage description label */
    JLabel lblRageDesc = new JLabel("<html>FILLER DESCRIPTION.</html>");
    lblRageDesc.setVerticalAlignment(SwingConstants.TOP);
    lblRageDesc.setForeground(Color.DARK_GRAY);
    lblRageDesc.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
    lblRageDesc.setBounds(10, 51, 188, 27);
    panel_rage.add(lblRageDesc);

    /* ------------- sharpness panel ------------- */
    /* Create panel for sharpness */
    JPanel panel_sharpness = new JPanel();
    panel_sharpness.setBorder(
        new TitledBorder(null, "Sharpness", TitledBorder.LEADING, TitledBorder.TOP, null, null));
    panel_sharpness.setLayout(null);
    game.getPanel_stats().add(panel_sharpness);

    /* Create sharpness icon */
    JLabel lblSharpnessIcon = new JLabel("");
    lblSharpnessIcon.setBounds(10, 16, 24, 24);
    lblSharpnessIcon.setIcon(new ImageIcon(getClass().getResource("/images/sharpness.png")));
    panel_sharpness.add(lblSharpnessIcon);

    /* Create sharpness upgrade button */
    btnUpgradeStat_3 = new JButton("+");
    btnUpgradeStat_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
    btnUpgradeStat_3.setFocusable(false);
    btnUpgradeStat_3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    btnUpgradeStat_3.setBounds(170, 16, 28, 28);
    btnUpgradeStat_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnUpgradeStat_3.setVisible(false);
    panel_sharpness.add(btnUpgradeStat_3);

    /* Create the label that displays sharpness value */
    lblSharpness = new JLabel(sharpness + "");
    lblSharpness.setBounds(44, 16, 116, 24);
    panel_sharpness.add(lblSharpness);

    /* Create sharpness description label */
    JLabel lblSharpnessDesc = new JLabel("<html>FILLER DESCRIPTION.</html>");
    lblSharpnessDesc.setVerticalAlignment(SwingConstants.TOP);
    lblSharpnessDesc.setForeground(Color.DARK_GRAY);
    lblSharpnessDesc.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
    lblSharpnessDesc.setBounds(10, 51, 188, 27);
    panel_sharpness.add(lblSharpnessDesc);

    /* ------------- toughness panel ------------- */
    /* Create panel for critical damage */
    JPanel panel_toughness = new JPanel();
    panel_toughness.setBorder(
        new TitledBorder(null, "Toughness", TitledBorder.LEADING, TitledBorder.TOP, null, null));
    panel_toughness.setLayout(null);
    game.getPanel_stats().add(panel_toughness);

    /* Create toughness icon */
    JLabel lblToughnessIcon = new JLabel("");
    lblToughnessIcon.setBounds(10, 16, 24, 24);
    lblToughnessIcon.setIcon(new ImageIcon(getClass().getResource("/images/toughness.png")));
    panel_toughness.add(lblToughnessIcon);

    /* Create toughness upgrade button */
    btnUpgradeStat_4 = new JButton("+");
    btnUpgradeStat_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
    btnUpgradeStat_4.setFocusable(false);
    btnUpgradeStat_4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    btnUpgradeStat_4.setBounds(170, 16, 28, 28);
    btnUpgradeStat_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnUpgradeStat_4.setVisible(false);
    panel_toughness.add(btnUpgradeStat_4);

    /* Create the label that displays toughness value */
    lblToughness = new JLabel(toughness + "");
    lblToughness.setBounds(44, 16, 116, 24);
    panel_toughness.add(lblToughness);

    /* Create toughness description label */
    JLabel lblToughnessDesc = new JLabel("<html>FILLER DESCRIPTION.</html>");
    lblToughnessDesc.setVerticalAlignment(SwingConstants.TOP);
    lblToughnessDesc.setForeground(Color.DARK_GRAY);
    lblToughnessDesc.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
    lblToughnessDesc.setBounds(10, 51, 188, 27);
    panel_toughness.add(lblToughnessDesc);

    /* ------------- riposte_chance panel ------------- */
    /* Create panel for riposte chance */
    JPanel panel_riposteChance = new JPanel();
    panel_riposteChance.setBorder(new TitledBorder(null, "Riposte Chance", TitledBorder.LEADING,
        TitledBorder.TOP, null, null));
    panel_riposteChance.setLayout(null);
    game.getPanel_stats().add(panel_riposteChance);

    /* Create riposte chance icon */
    JLabel lblRiposteChanceIcon = new JLabel("");
    lblRiposteChanceIcon.setBounds(10, 16, 24, 24);
    lblRiposteChanceIcon
        .setIcon(new ImageIcon(getClass().getResource("/images/ripostechance.png")));
    panel_riposteChance.add(lblRiposteChanceIcon);

    /* Create riposte chance upgrade button */
    btnUpgradeStat_5 = new JButton("+");
    btnUpgradeStat_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
    btnUpgradeStat_5.setFocusable(false);
    btnUpgradeStat_5.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    btnUpgradeStat_5.setBounds(170, 16, 28, 28);
    btnUpgradeStat_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnUpgradeStat_5.setVisible(false);
    panel_riposteChance.add(btnUpgradeStat_5);

    /* Create the label that displays riposte chance value */
    lblRiposteChance = new JLabel(riposteChance + "%");
    lblRiposteChance.setBounds(44, 16, 116, 24);
    panel_riposteChance.add(lblRiposteChance);

    /* Create riposte chance description label */
    JLabel lblRiposteChanceDesc = new JLabel("<html>FILLER DESCRIPTION.</html>");
    lblRiposteChanceDesc.setVerticalAlignment(SwingConstants.TOP);
    lblRiposteChanceDesc.setForeground(Color.DARK_GRAY);
    lblRiposteChanceDesc.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
    lblRiposteChanceDesc.setBounds(10, 51, 188, 27);
    panel_riposteChance.add(lblRiposteChanceDesc);

    /* ------------------------------------------------- */

    /* Create the barbarian's rage bar */
    lblRage = new JLabel("Rage");
    lblRage.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    lblRage.setHorizontalAlignment(SwingConstants.CENTER);
    lblRage.setBounds(4, 38, 30, 20);
    game.getPanel_player().add(lblRage);

    lblRage_1 = new JLabel("");
    lblRage_1.setBounds(42, 38, 20, 20);
    game.getPanel_player().add(lblRage_1);

    lblRage_2 = new JLabel("");
    lblRage_2.setBounds(64, 38, 20, 20);
    game.getPanel_player().add(lblRage_2);

    lblRage_3 = new JLabel("");
    lblRage_3.setBounds(86, 38, 20, 20);
    game.getPanel_player().add(lblRage_3);

    lblRage_4 = new JLabel("");
    lblRage_4.setBounds(108, 38, 20, 20);
    game.getPanel_player().add(lblRage_4);

    lblRage_5 = new JLabel("");
    lblRage_5.setBounds(130, 38, 20, 20);
    game.getPanel_player().add(lblRage_5);

    lblRage_6 = new JLabel("");
    lblRage_6.setBounds(152, 38, 20, 20);
    game.getPanel_player().add(lblRage_6);

    lblRage_7 = new JLabel("");
    lblRage_7.setBounds(174, 38, 20, 20);
    game.getPanel_player().add(lblRage_7);

    lblRage_8 = new JLabel("");
    lblRage_8.setBounds(196, 38, 20, 20);
    game.getPanel_player().add(lblRage_8);

    /* Add all rage icons into an arraylist */
    rageIcons = new ArrayList<JLabel>();
    rageIcons.add(lblRage_1);
    rageIcons.add(lblRage_2);
    rageIcons.add(lblRage_3);
    rageIcons.add(lblRage_4);
    rageIcons.add(lblRage_5);
    rageIcons.add(lblRage_6);
    rageIcons.add(lblRage_7);
    rageIcons.add(lblRage_8);

    game.getLblPlayerImage().setIcon(getHeroIcon()); // Draw player image on frame
    repaintRage(); // Repaint rage bar
    showOffensiveAttacks(); // Display offensive attacks by default
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btnOffensive) {
      showOffensiveAttacks();
    } else if (e.getSource() == btnDefensive) {
      showDefensiveAttacks();
    }

    /* Check if attack buttons are clicked */
    for (Attack x : AttacksArrayList) {
      if (e.getSource() == x.getButton()) {
        if (x.getCurWarmup() == x.getMaxWarmup()) { // Check cooldown
          if (haveEnoughRage(x.getRageNeeded())) { // Check needed rage to execute
            reduceWarmup();
            x.setCurWarmup(0);
            load.nextTurn(x);
          } else {
            continue;
            // try {
            // game.getDoc().insertString(game.getDoc().getLength(), "Insufficient Rage!\n", null);
            // } catch (BadLocationException e1) {
            // }
          }
        } else {
          continue;
          // try {
          // game.getDoc().insertString(game.getDoc().getLength(), x.getName() + " is not ready!",
          // null);
          // } catch (BadLocationException e1) {
          // }
        }
      }
    }
  }

  @Override
  public void attackEnemy(Attack attack) {
    try {
      attack.startAttack();
    } catch (BadLocationException e) {
    }

    /* Paint enemy's health bar */
    game.getBar_enemyHealth().setValue((int) game.getEnemySelected().getCurHealth());
    game.getBar_enemyHealth().setString(
        game.getEnemySelected().getCurHealth() + " / " + game.getEnemySelected().getMaxHealth());

    game.repaint(); // Repaint health bars
  }

  @Override
  public boolean isAlive() {
    if (curVitality <= 0) {
      return false;
    } else {
      return true;
    }
  }

  /**
   * Generate rage
   * 
   * @param amount Amount of rage to generate
   */
  public void generateRage(int amount) {
    for (int i = 0; i < amount; i++) {
      if ((curRage + 1) <= maxRage) {
        curRage++;
      }
    }
    repaintRage();
  }

  /**
   * Consume rage
   * 
   * @param amount Amount of rage to consume
   */
  public void consumeRage(int amount) {
    if (haveEnoughRage(amount)) {
      curRage -= amount;
    }
    repaintRage();
  }

  /**
   * Check if barbarian has enough rage of a given value
   * 
   * @param amount The number of rage to be checked for availability
   * 
   * @return true if there's sufficient rage
   * @return false if there's insufficient rage
   */
  public boolean haveEnoughRage(int amount) {
    return (amount <= curRage);
  }

  /**
   * Repaint rage graphics
   */
  public void repaintRage() {
    for (int i = 0; i < maxRage; i++) {
      if ((i + 1) <= curRage) {
        rageIcons.get(i).setIcon(new ImageIcon(getClass().getResource("/images/rage_on.png")));
      } else {
        rageIcons.get(i).setIcon(new ImageIcon(getClass().getResource("/images/rage_off.png")));
      }
    }
  }

  @Override
  public void surrender() {

    /* Confirm surrender */
    Object[] options = {"Yes", "No Way!"};
    int s = JOptionPane.showOptionDialog(game, "Are you sure you want to surrender?", "Concede",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, "");

    if (s == 1) { // Cancel
      return;
    } else { // Surrender
      game.setEnemySelected(null);

      /* Reset health */
      double a = maxVitality;
      curVitality = a;

      /* Reset rage */
      curRage = 1;
      repaintRage();

      /* Reset health bar */
      game.getBar_playerHealth().setMaximum((int) maxVitality);
      game.getBar_playerHealth().setValue((int) maxVitality);
      game.getBar_playerHealth().setString(curVitality + " / " + maxVitality);

      /* Remove enemy from battlefield */
      game.getLblEnemyImage().setIcon(null);
      game.getLblEnemyName().setText("");
      game.getPanel_enemy().setVisible(false);

      game.disableAttackButtons(); // Disable attack buttons
      Game.setTurn(1); // Reset turns
      game.getTextArea().setText(""); // Clear event area
      game.repaint(); // Repaint
    }
  }

  @Override
  public void setEnemyToFight(Enemy enemy) {

    /* Reset health */
    double a = maxVitality;
    curVitality = a;

    /* Reset rage */
    curRage = 1;
    repaintRage();

    /* Prepare player health bar */
    game.getBar_playerHealth().setMaximum((int) maxVitality);
    game.getBar_playerHealth().setValue((int) maxVitality);
    game.getBar_playerHealth().setString(curVitality + " / " + maxVitality);

    /* Show enemy on battlefield */
    game.getLblEnemyImage().setIcon(enemy.getEnemyImage());
    game.getLblEnemyImage().setVerticalAlignment(enemy.getValign());
    game.getLblEnemyName().setText(enemy.getName() + "");
    game.getPanel_enemy().setVisible(true);


    game.getTextArea().setText(""); // Clear event area
    game.setEnemySelected(enemy); // Set enemy to fight
    Game.setTurn(1); // Reset turns
  }

  /**
   * Toggle offensive attacks
   */
  public void showOffensiveAttacks() {

    /* Add the offensive set of attacks */
    game.getPanel_actions().removeAll();
    for (int i = 0; i < 6; i++) {
      game.getPanel_actions().add(AttacksArrayList.get(i).getButton());
    }

    /* Toggle stance buttons */
    btnOffensive.setSelected(false);
    btnDefensive.setSelected(true);

    /* Repaint stance icons */
    btnOffensive.setIcon(offensiveIcon_small);
    btnDefensive.setIcon(defensiveIcon);
    btnOffensive.setBorder(new LineBorder(Color.BLACK, 2));
    btnDefensive.setBorder(new LineBorder(Color.BLACK, 1));

    game.repaint(); // Repaint GUI
    game.revalidate();
  }

  /**
   * Toggle defensive attacks
   */
  public void showDefensiveAttacks() {

    /* Add the defensive set of attacks */
    game.getPanel_actions().removeAll();
    for (int i = 6; i < 12; i++) {
      game.getPanel_actions().add(AttacksArrayList.get(i).getButton());
    }

    /* Toggle stance buttons */
    btnOffensive.setSelected(true);
    btnDefensive.setSelected(false);

    /* Repaint stance icons */
    btnOffensive.setIcon(offensiveIcon);
    btnDefensive.setIcon(defensiveIcon_small);
    btnOffensive.setBorder(new LineBorder(Color.BLACK, 1));
    btnDefensive.setBorder(new LineBorder(Color.BLACK, 2));

    game.repaint(); // Repaint GUI
    game.revalidate();
  }

  @Override
  public void enableButtons() {
    btnUpgradeStat_1.setEnabled(true);
    btnUpgradeStat_2.setEnabled(true);
    btnUpgradeStat_3.setEnabled(true);
    btnUpgradeStat_4.setEnabled(true);
    btnUpgradeStat_5.setEnabled(true);
    btnOffensive.setEnabled(true);
    btnDefensive.setEnabled(true);
  }

  @Override
  public void disableButtons() {
    btnUpgradeStat_1.setEnabled(false);
    btnUpgradeStat_2.setEnabled(false);
    btnUpgradeStat_3.setEnabled(false);
    btnUpgradeStat_4.setEnabled(false);
    btnUpgradeStat_5.setEnabled(false);
    btnOffensive.setEnabled(false);
    btnDefensive.setEnabled(false);
  }

  /**
   * @return maleImage if hero is male
   * @return femaleImage if hero is female
   */
  public ImageIcon getHeroIcon() {
    if (game.getHeroSex() == 1) {
      return maleImage;
    } else if (game.getHeroSex() == 2) {
      return femaleImage;
    } else {
      System.out.println("[Barbarian.java] Something went wrong retrieving player icon!");
      return null;
    }
  }

  /**
   * @return the dmgMultiplier
   */
  public double getDmgMultiplier() {
    return dmgMultiplier;
  }

  /**
   * Set the dmgMultiplier
   * 
   * @param dmgMultiplier The value which the damage is multiplied by
   */
  public void setDmgMultiplier(double dmgMultiplier) {
    this.dmgMultiplier = dmgMultiplier;
  }

  /**
   * @return the curRage
   */
  public int getCurRage() {
    return curRage;
  }

  /**
   * Set the curRage
   * 
   * @param curRage The number of current rage
   */
  public void setCurRage(int curRage) {
    this.curRage = curRage;
  }

  /**
   * @return the maxRage
   */
  public int getMaxRage() {
    return maxRage;
  }

  /**
   * Set the maxRage
   * 
   * @param maxRage The number of maximum rage
   */
  public void setMaxRage(int maxRage) {
    this.maxRage = maxRage;
  }

  @Override
  public double getCurHealth() {
    return curVitality;
  }

  @Override
  public void setCurHealth(double vitality) {
    this.curVitality = vitality;
  }

  @Override
  public double getMaxHealth() {
    return maxVitality;
  }

  @Override
  public void setMaxHealth(double maxVitality) {
    this.maxVitality = maxVitality;
  }

  @Override
  public double getSharpness() {
    return sharpness;
  }

  /**
   * Set the sharpness
   * 
   * @param sharpness The value of sharpness
   */
  public void setSharpness(double sharpness) {
    this.sharpness = sharpness;
  }

  /**
   * @return the riposteChance
   */
  public double getRiposteChance() {
    return riposteChance;
  }

  /**
   * Set the riposteChance
   * 
   * @param riposteChance The value of riposte chance
   */
  public void setRiposteChance(double riposteChance) {
    this.riposteChance = riposteChance;
  }

  /**
   * @return the toughness
   */
  public double getToughness() {
    return toughness;
  }

  /**
   * Set the toughness
   * 
   * @param toughness The value of toughness
   */
  public void setToughness(double toughness) {
    this.toughness = toughness;
  }
}
