package bi.team.heroes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.BadLocationException;

import bi.team.Burn;
import bi.team.Game;
import bi.team.enemies.Enemy;
import bi.team.graphics.PlayerLoad;
import bi.team.heroes.attacks.barbarian.Attack;
import bi.team.heroes.attacks.barbarian.Battle_bash;
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
  private final static String name_male = "Brynjar";
  private final static String name_female = "Alani";
  private PlayerLoad playerLoad;
  private TitledBorder titledBorder_vitality;
  private TitledBorder titledBorder_rage;
  private TitledBorder titledBorder_strength;
  private TitledBorder titledBorder_toughness;
  private TitledBorder titledBorder_riposteChance;
  private JLabel lblVitality;
  private JLabel lblRage;
  private JLabel lblStrength;
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
  private JLabel lblRage_9;
  private JLabel buff_stanceOffensive = new JLabel();
  private JLabel buff_stanceDefensive = new JLabel();
  private JButton btnOffensive;
  private JButton btnDefensive;
  private String offensivePassiveName = "Determination";
  private String defensivePassiveName = "Safeguard";
  private double offensiveDamagePercentage = 15f;
  private double defensiveToughnessPercentage = 15f;
  private int defensiveExtraHealth = 100;
  private ArrayList<JLabel> rageIcons;
  private ImageIcon defensiveIcon;
  private ImageIcon defensiveIcon_small;
  private ImageIcon offensiveIcon;
  private ImageIcon offensiveIcon_small;
  private ImageIcon maleImage;
  private ImageIcon femaleImage;
  private JButton btnUpgrade_vitality;
  private JButton btnUpgrade_rage;
  private JButton btnUpgrade_strength;
  private JButton btnUpgrade_toughness;
  private JButton btnUpgrade_riposteChance;
  private double curVitality = 425;
  private int curRage = 0;
  private int maxRage = 6;
  private double dmgMultiplier = 1;
  private int points_vitality = 1;
  private int points_rage = 1;
  private int points_strength = 1;
  private int points_toughness = 1;
  private int points_riposteChance = 1;
  private final int maxPoints_vitality = 20;
  private final int maxPoints_rage = 4;
  private final int maxPoints_strength = 20;
  private final int maxPoints_toughness = 30;
  private final int maxPoints_riposteChance = 20;

  /**
   * Class constructor
   * 
   * @param game The main game
   */
  public Barbarian(Game game, int sex) {
    super(game, (1 == sex) ? name_male : name_female);

    playerLoad = new PlayerLoad(game, this);
    AttacksArrayList = new ArrayList<Attack>();
    ArrayUpgradeButtons = new ArrayList<JButton>();
    maleImage = new ImageIcon(getClass().getResource("/images/heroes/barbarian_male_big.png"));
    femaleImage = new ImageIcon(getClass().getResource("/images/heroes/barbarian_female_big.png"));
    defensiveIcon = new ImageIcon(getClass().getResource("/images/stance_defensive.png"));
    defensiveIcon_small =
        new ImageIcon(getClass().getResource("/images/stance_defensive_small.png"));
    offensiveIcon = new ImageIcon(getClass().getResource("/images/stance_offensive.png"));
    offensiveIcon_small =
        new ImageIcon(getClass().getResource("/images/stance_offensive_small.png"));
    buff_stanceOffensive
        .setIcon(new ImageIcon(getClass().getResource("/images/buffs/buff_stanceOffensive.png")));
    buff_stanceDefensive
        .setIcon(new ImageIcon(getClass().getResource("/images/buffs/buff_stanceDefensive.png")));

    /* Configure player GUI */
    game.getBar_playerHealth().setMinimum(0);
    game.getBar_playerHealth().setMaximum((int) Math.round(getMaxVitality()));
    game.getBar_playerHealth().setValue((int) Math.round(curVitality));
    game.getBar_playerHealth()
        .setString((int) Math.round(curVitality) + " / " + (int) Math.round(getMaxVitality()));

    /* Create this class's attacks */
    AttacksArrayList.add(new Strike(this, game));
    AttacksArrayList.add(new Heavy_blow(this, game));
    AttacksArrayList.add(new Rage_incite(this, game));
    AttacksArrayList.add(new Vengeance(this, game));
    AttacksArrayList.add(new Battle_bash(this, game));
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
    panel_stances.setBounds(0, 0, 66, 34);
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
    btnOffensive.setToolTipText("<html>" + Game.styles + "<body> <table><tr>"
        + "<td><span id=\"title\">[Stance] Offensive</span><br><br>"
        + "<span id=\"s01\">Cost:</span> <b id=\"val\">1</b>"
        + "<span id=\"s02\"> Rage</span><br><br>" + "<p id=\"desc\">" + getName()
        + " enters the offensive stance, activating <u>Determination</u>.<br><br>"
        + "<u>Determination</u>: " + getName() + "'s attacks deal <b id=\"val\">"
        + offensiveDamagePercentage + "%</b> more damage.</p><br>" + "</td></tr></table>"
        + "</body><html>");
    panel_stances.add(btnOffensive);

    /* Create defensive stance */
    btnDefensive = new JButton("");
    btnDefensive.setBounds(36, 4, 26, 26);
    btnDefensive.setFocusable(false);
    btnDefensive.setBackground(null);
    btnDefensive.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnDefensive.addActionListener(this);
    btnDefensive.setToolTipText("<html>" + Game.styles + "<body> <table><tr>"
        + "<td><span id=\"title\">[Stance] Defensive</span><br><br>"
        + "<span id=\"s01\">Cost:</span> <b id=\"val\">1</b>"
        + "<span id=\"s02\"> Rage</span><br><br>" + "<p id=\"desc\">" + getName()
        + " enters the defensive stance, activating <u>Safeguard</u>.<br><br>"
        + "<u>Safeguard</u>: " + getName() + " gains an additional <b id=\"val\">"
        + defensiveExtraHealth + "</b> vitality, and increases " + game.getLang1()
        + " toughness by <b id=\"val\">" + defensiveToughnessPercentage + "%</b>.</p><br>"
        + "</td></tr></table>" + "</body><html>");
    panel_stances.add(btnDefensive);

    /* ------------- vitality panel ------------- */
    /* Create panel for vitality */
    JPanel panel_vitality = new JPanel();
    titledBorder_vitality =
        new TitledBorder(null, "Vitality [" + points_vitality + "/" + maxPoints_vitality + "]",
            TitledBorder.LEADING, TitledBorder.TOP, null, null);
    panel_vitality.setBorder(titledBorder_vitality);
    panel_vitality.setLayout(null);
    game.getPanel_stats().add(panel_vitality);

    /* Create vitality icon */
    JLabel lblHealhIcon = new JLabel("");
    lblHealhIcon.setBounds(10, 16, 24, 24);
    lblHealhIcon.setIcon(new ImageIcon(getClass().getResource("/images/vitality.png")));
    panel_vitality.add(lblHealhIcon);

    /* Create vitality upgrade button */
    btnUpgrade_vitality = new JButton("+");
    ArrayUpgradeButtons.add(btnUpgrade_vitality);
    btnUpgrade_vitality.setFont(new Font("Tahoma", Font.PLAIN, 16));
    btnUpgrade_vitality.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    btnUpgrade_vitality.setFocusable(false);
    btnUpgrade_vitality.setBounds(170, 16, 28, 28);
    btnUpgrade_vitality.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnUpgrade_vitality.addActionListener(this);
    btnUpgrade_vitality.setVisible(false);
    panel_vitality.add(btnUpgrade_vitality);

    /* Create the label that displays the maximum vitality value */
    lblVitality = new JLabel(getMaxVitality() + "");
    lblVitality.setBounds(44, 16, 116, 24);
    panel_vitality.add(lblVitality);

    /* Create vitality description label */
    JLabel lblVitalityDesc = new JLabel("<html>Your maximum health.</html>");
    lblVitalityDesc.setVerticalAlignment(SwingConstants.TOP);
    lblVitalityDesc.setForeground(Color.DARK_GRAY);
    lblVitalityDesc.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
    lblVitalityDesc.setBounds(10, 44, 188, 34);
    panel_vitality.add(lblVitalityDesc);

    /* ------------- rage panel ------------- */
    /* Create panel for rage */
    JPanel panel_rage = new JPanel();
    titledBorder_rage = new TitledBorder(null, "Rage [" + points_rage + "/" + maxPoints_rage + "]",
        TitledBorder.LEADING, TitledBorder.TOP, null, null);
    panel_rage.setBorder(titledBorder_rage);
    panel_rage.setLayout(null);
    game.getPanel_stats().add(panel_rage);

    /* Create rage icon */
    JLabel lblRageIcon = new JLabel("");
    lblRageIcon.setBounds(10, 16, 24, 24);
    lblRageIcon.setIcon(new ImageIcon(getClass().getResource("/images/rage.png")));
    panel_rage.add(lblRageIcon);

    /* Create rage upgrade button */
    btnUpgrade_rage = new JButton("+");
    ArrayUpgradeButtons.add(btnUpgrade_rage);
    btnUpgrade_rage.setFont(new Font("Tahoma", Font.PLAIN, 16));
    btnUpgrade_rage.setFocusable(false);
    btnUpgrade_rage.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    btnUpgrade_rage.setBounds(170, 16, 28, 28);
    btnUpgrade_rage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnUpgrade_rage.addActionListener(this);
    btnUpgrade_rage.setVisible(false);
    panel_rage.add(btnUpgrade_rage);

    /* Create the label that displays rage value */
    lblRage = new JLabel(maxRage + "");
    lblRage.setBounds(44, 16, 116, 24);
    panel_rage.add(lblRage);

    /* Create rage description label */
    JLabel lblRageDesc = new JLabel("<html>Maximum number of rage to obtain.</html>");
    lblRageDesc.setVerticalAlignment(SwingConstants.TOP);
    lblRageDesc.setForeground(Color.DARK_GRAY);
    lblRageDesc.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
    lblRageDesc.setBounds(10, 44, 188, 34);
    panel_rage.add(lblRageDesc);

    /* ------------- strength panel ------------- */
    /* Create panel for strength */
    JPanel panel_strength = new JPanel();
    titledBorder_strength =
        new TitledBorder(null, "Strength [" + points_strength + "/" + maxPoints_strength + "]",
            TitledBorder.LEADING, TitledBorder.TOP, null, null);
    panel_strength.setBorder(titledBorder_strength);
    panel_strength.setLayout(null);
    game.getPanel_stats().add(panel_strength);

    /* Create strength icon */
    JLabel lblStrengthIcon = new JLabel("");
    lblStrengthIcon.setBounds(10, 16, 24, 24);
    lblStrengthIcon.setIcon(new ImageIcon(getClass().getResource("/images/strength.png")));
    panel_strength.add(lblStrengthIcon);

    /* Create strength upgrade button */
    btnUpgrade_strength = new JButton("+");
    ArrayUpgradeButtons.add(btnUpgrade_strength);
    btnUpgrade_strength.setFont(new Font("Tahoma", Font.PLAIN, 16));
    btnUpgrade_strength.setFocusable(false);
    btnUpgrade_strength.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    btnUpgrade_strength.setBounds(170, 16, 28, 28);
    btnUpgrade_strength.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnUpgrade_strength.addActionListener(this);
    btnUpgrade_strength.setVisible(false);
    panel_strength.add(btnUpgrade_strength);

    /* Create the label that displays strength value */
    lblStrength = new JLabel(String.format("%.2f", getStrength()) + "");
    lblStrength.setBounds(44, 16, 116, 24);
    panel_strength.add(lblStrength);

    /* Create strength description label */
    JLabel lblStrengthDesc = new JLabel("<html>Determines the damage done.</html>");
    lblStrengthDesc.setVerticalAlignment(SwingConstants.TOP);
    lblStrengthDesc.setForeground(Color.DARK_GRAY);
    lblStrengthDesc.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
    lblStrengthDesc.setBounds(10, 44, 188, 34);
    panel_strength.add(lblStrengthDesc);

    /* ------------- toughness panel ------------- */
    /* Create panel for critical damage */
    JPanel panel_toughness = new JPanel();
    titledBorder_toughness =
        new TitledBorder(null, "Toughness [" + points_toughness + "/" + maxPoints_toughness + "]",
            TitledBorder.LEADING, TitledBorder.TOP, null, null);
    panel_toughness.setBorder(titledBorder_toughness);
    panel_toughness.setLayout(null);
    game.getPanel_stats().add(panel_toughness);

    /* Create toughness icon */
    JLabel lblToughnessIcon = new JLabel("");
    lblToughnessIcon.setBounds(10, 16, 24, 24);
    lblToughnessIcon.setIcon(new ImageIcon(getClass().getResource("/images/toughness.png")));
    panel_toughness.add(lblToughnessIcon);

    /* Create toughness upgrade button */
    btnUpgrade_toughness = new JButton("+");
    ArrayUpgradeButtons.add(btnUpgrade_toughness);
    btnUpgrade_toughness.setFont(new Font("Tahoma", Font.PLAIN, 16));
    btnUpgrade_toughness.setFocusable(false);
    btnUpgrade_toughness.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    btnUpgrade_toughness.setBounds(170, 16, 28, 28);
    btnUpgrade_toughness.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnUpgrade_toughness.addActionListener(this);
    btnUpgrade_toughness.setVisible(false);
    panel_toughness.add(btnUpgrade_toughness);

    /* Create the label that displays toughness value */
    lblToughness = new JLabel(String.format("%.2f", getToughness()) + "%");
    lblToughness.setBounds(44, 16, 116, 24);
    panel_toughness.add(lblToughness);

    /* Create toughness description label */
    JLabel lblToughnessDesc =
        new JLabel("<html>The percentage of damage to resist per attack.</html>");
    lblToughnessDesc.setVerticalAlignment(SwingConstants.TOP);
    lblToughnessDesc.setForeground(Color.DARK_GRAY);
    lblToughnessDesc.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
    lblToughnessDesc.setBounds(10, 44, 188, 34);
    panel_toughness.add(lblToughnessDesc);

    /* ------------- riposte_chance panel ------------- */
    /* Create panel for riposte chance */
    JPanel panel_riposteChance = new JPanel();
    titledBorder_riposteChance = new TitledBorder(null,
        "Riposte Chance [" + points_riposteChance + "/" + maxPoints_riposteChance + "]",
        TitledBorder.LEADING, TitledBorder.TOP, null, null);
    panel_riposteChance.setBorder(titledBorder_riposteChance);
    panel_riposteChance.setLayout(null);
    game.getPanel_stats().add(panel_riposteChance);

    /* Create riposte chance icon */
    JLabel lblRiposteChanceIcon = new JLabel("");
    lblRiposteChanceIcon.setBounds(10, 16, 24, 24);
    lblRiposteChanceIcon
        .setIcon(new ImageIcon(getClass().getResource("/images/ripostechance.png")));
    panel_riposteChance.add(lblRiposteChanceIcon);

    /* Create riposte chance upgrade button */
    btnUpgrade_riposteChance = new JButton("+");
    ArrayUpgradeButtons.add(btnUpgrade_riposteChance);
    btnUpgrade_riposteChance.setFont(new Font("Tahoma", Font.PLAIN, 16));
    btnUpgrade_riposteChance.setFocusable(false);
    btnUpgrade_riposteChance.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
    btnUpgrade_riposteChance.setBounds(170, 16, 28, 28);
    btnUpgrade_riposteChance.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnUpgrade_riposteChance.addActionListener(this);
    btnUpgrade_riposteChance.setVisible(false);
    panel_riposteChance.add(btnUpgrade_riposteChance);

    /* Create the label that displays riposte chance value */
    lblRiposteChance = new JLabel(String.format("%.2f", getRiposteChance()) + "%");
    lblRiposteChance.setBounds(44, 16, 116, 24);
    panel_riposteChance.add(lblRiposteChance);

    /* Create riposte chance description label */
    JLabel lblRiposteChanceDesc = new JLabel("<html>The chance to counter an attack.</html>");
    lblRiposteChanceDesc.setVerticalAlignment(SwingConstants.TOP);
    lblRiposteChanceDesc.setForeground(Color.DARK_GRAY);
    lblRiposteChanceDesc.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
    lblRiposteChanceDesc.setBounds(10, 44, 188, 34);
    panel_riposteChance.add(lblRiposteChanceDesc);

    /* ------------------------------------------------- */

    /* Create the barbarian's rage bar */
    JLabel labelRage = new JLabel("Rage");
    labelRage.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    labelRage.setHorizontalAlignment(SwingConstants.CENTER);
    labelRage.setBounds(4, 38, 30, 20);
    game.getPanel_player().add(labelRage);

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

    lblRage_9 = new JLabel("");
    lblRage_9.setBounds(218, 38, 20, 20);
    game.getPanel_player().add(lblRage_9);

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
    rageIcons.add(lblRage_9);

    game.getLblPlayerImage().setIcon(getHeroIcon()); // Draw player image on frame
    repaintRage(); // Repaint rage bar
    game.repaintXpBar(); // Update level & experience visual
    showOffensiveAttacks(); // Display offensive attacks by default
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    /* Stat buttons are clicked */
    if (e.getSource() == btnUpgrade_vitality) {
      upgradeVitality();
    } else if (e.getSource() == btnUpgrade_rage) {
      upgradeRage();
    } else if (e.getSource() == btnUpgrade_strength) {
      upgradeStrength();
    } else if (e.getSource() == btnUpgrade_toughness) {
      upgradeToughness();
    } else if (e.getSource() == btnUpgrade_riposteChance) {
      upgradeRiposteChance();
    }

    /* Stance buttons are clicked */
    if (e.getSource() == btnOffensive) {
      if (haveEnoughRage(1) && !btnOffensive.isSelected()) {
        btnOffensive.setSelected(true);
        btnDefensive.setSelected(false);
        showOffensiveAttacks();
        consumeRage(1);
      }
    } else if (e.getSource() == btnDefensive) {
      if (haveEnoughRage(1) && !btnDefensive.isSelected()) {
        btnDefensive.setSelected(true);
        btnOffensive.setSelected(false);
        showDefensiveAttacks();
        consumeRage(1);
      }
    }

    /* Attack buttons are clicked */
    for (Attack x : AttacksArrayList) {
      if (e.getSource() == x.getButton()) {
        if (x.getCurWarmup() == x.getMaxWarmup()) { // Check cooldown
          if (haveEnoughRage(x.getRageNeeded())) { // Check needed rage to execute
            reduceWarmup();
            x.setCurWarmup(0);
            addExperience(x.getAttackExperience());
            playerLoad.nextTurn(x);
          } else {
            continue;
          }
        } else {
          continue;
        }
      }
    }
  }

  @Override
  public void takeDamage(double damage, ImageIcon attackIcon) {
    double reflectDmg = 0;

    /* Hero takes damage */
    double toughness = getToughness() / 100;
    if (btnDefensive.isSelected()) { // Defensive stance toughness increase
      toughness += toughness * (defensiveToughnessPercentage / 100);
    }
    double dmg = damage - (damage * toughness);

    /* Raise Shield block damage & reflect damage */
    Raise_shield raiseShield = (Raise_shield) AttacksArrayList.get(8);
    if (raiseShield.isActive()) {
      double reflectPercentage = raiseShield.getReflectPercentage() / 100;
      double blockPercentage = raiseShield.getBlockPercentage() / 100;
      double damageBlocked = dmg * blockPercentage;
      dmg -= damageBlocked; // Negate the blocked damage
      reflectDmg = damageBlocked * reflectPercentage;
    }
    dmg = Math.round(dmg * 100.0) / 100.0; // Round damage to 2 decimal places

    setDmgTakenPreviously(dmg);
    setCurHealth(getCurHealth() - dmg);

    game.paintEvent(new ImageIcon(getClass().getResource("/images/impact_toPlayer.png")), dmg + "",
        attackIcon); // Paint event
    if (reflectDmg != 0) { // Inflict reflected damage
      game.getEnemySelected().takeDamage(reflectDmg,
          new ImageIcon(getClass().getResource("/images/attacks/raise_shield.png")));
    }

    raiseShield.reduceTurns();
    game.repaintBuffs();
    game.repaintHealthBars();
    game.repaint(); // Repaint health bars
  }

  @Override
  public void burn() {
    game.repaintBuffs();

    for (Burn x : burnArrayList) { // Apply all active burns to hero
      double burnDmg = x.getBurnDamage();
      burnDmg = Math.round(burnDmg * 100.0) / 100.0; // Round damage to 2 decimal places
      x.reduceTurn();
      setCurHealth(getCurHealth() - burnDmg);

      game.paintEvent(new ImageIcon(getClass().getResource("/images/impact_toPlayer.png")),
          burnDmg + "", new ImageIcon(getClass().getResource("/images/burn.png")));
    }

    Raise_shield raiseShield = (Raise_shield) AttacksArrayList.get(8);
    raiseShield.reduceTurns();
    game.repaintBuffs();
    game.repaintHealthBars();
    game.repaint(); // Repaint health bars
  }

  @Override
  public void attackEnemy(Attack attack) {
    Raise_shield raiseShield = (Raise_shield) AttacksArrayList.get(8);
    Incapacitate incapacitate = (Incapacitate) AttacksArrayList.get(9);
    Shield_bash shieldBash = (Shield_bash) AttacksArrayList.get(10);

    if (turnsStunned <= 0) {
      try {
        attack.startAttack();
      } catch (BadLocationException | IOException e) {
      }
    } else {
      turnsStunned--;
      attack = null;
    }

    /* Reduce attacks cooldowns */
    if (attack instanceof Raise_shield) {
      incapacitate.reduceTurns();
      shieldBash.reduceTurns();
    } else if (attack instanceof Incapacitate) {
      raiseShield.reduceTurns();
      shieldBash.reduceTurns();
    } else if (attack instanceof Shield_bash) {
      raiseShield.reduceTurns();
      incapacitate.reduceTurns();
    } else {
      raiseShield.reduceTurns();
      incapacitate.reduceTurns();
      shieldBash.reduceTurns();
    }

    game.repaintHealthBars();
    game.repaintBuffs();
  }

  @Override
  public void repaintStats() {

    /* Repaint vitality */
    titledBorder_vitality.setTitle("Vitality [" + points_vitality + "/" + maxPoints_vitality + "]");
    lblVitality.setText(getMaxVitality() + "");

    /* Repaint rage */
    titledBorder_rage.setTitle("Rage [" + points_rage + "/" + maxPoints_rage + "]");
    lblRage.setText(getMaxRage() + "");

    /* Repaint strength */
    titledBorder_strength.setTitle("Strength [" + points_strength + "/" + maxPoints_strength + "]");
    lblStrength.setText(String.format("%.2f", getStrength()));

    /* Repaint toughness */
    titledBorder_toughness
        .setTitle("Toughness [" + points_toughness + "/" + maxPoints_toughness + "]");
    lblToughness.setText(String.format("%.2f", getToughness()) + "%");

    /* Repaint riposte chance */
    titledBorder_riposteChance
        .setTitle("Riposte Chance [" + points_riposteChance + "/" + maxPoints_riposteChance + "]");
    lblRiposteChance.setText(String.format("%.2f", getRiposteChance()) + "%");

    game.getLblEnhancementPoints()
        .setText("<html>Enhancement Points: <b>" + enhancementPoints + "</b></html>");
  }

  @Override
  public void repaintBuffTooltips() {
    buff_stanceOffensive.setToolTipText("<html>" + Game.buffStyles + "<body> <table><tr>"
        + "<td><span id=\"title\">" + offensivePassiveName + "</span><br><br>" + "<p id=\"desc\">"
        + getName() + " is dealing <b id=\"val\">" + offensiveDamagePercentage
        + "%</b> more damage.</p><br>" + "</td></tr></table>" + "</body><html>");

    buff_stanceDefensive.setToolTipText("<html>" + Game.buffStyles + "<body> <table><tr>"
        + "<td><span id=\"title\">" + defensivePassiveName + "</span><br><br>" + "<p id=\"desc\">"
        + getName() + " has an additional <b id=\"val\">" + defensiveExtraHealth
        + "</b> vitality, and <b id=\"val\">" + defensiveToughnessPercentage
        + "%</b> increased <span id=\"s02\">Toughness</span>" + ".</p><br>" + "</td></tr></table>"
        + "</body><html>");
  }

  @Override
  public void healHero(double amount) {
    curVitality += amount;

    if (curVitality > getMaxVitality()) {
      curVitality = getMaxVitality();
    }

    game.repaintHealthBars();
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
  public void surrender(boolean ask) {
    int s = 0;
    if (ask) {
      Object[] options = {"Yes", "No Way!"};
      s = JOptionPane.showOptionDialog(game, "Are you sure you want to surrender?", "Concede",
          JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, "");
    }

    if ((game.getEnemySelected() == null) || (!game.getEnemySelected().isAlive())) {
      return;
    }

    if (s == 1) { // Cancel
      return;
    } else { // Surrender
      game.setEnemySelected(null);
      curVitality = getMaxVitality(); // Reset health

      /* Reset rage */
      curRage = 1;
      repaintRage();

      /* Remove enemy from battlefield */
      game.getLblEnemyImage().setIcon(null);
      game.getLblEnemyName().setText("");
      game.getPanel_enemy().setVisible(false);

      game.disableAttackButtons(); // Disable attack buttons
      game.getBtnSurrender().setVisible(false);
      game.getBtnSurrender().setEnabled(false);
      game.repaintUpgradeButtons();
      Game.setTurn(1); // Reset turns
      game.getTextPane().setText(""); // Clear event area
      game.repaintHealthBars(); // Reset health bars
      resetHeroWarmups();
      game.repaint();
    }
  }

  /* Reset all attack warmups */
  public void resetHeroWarmups() {
    for (Attack x : AttacksArrayList) {
      x.resetWarmups();
    }
  }
  
  @Override
  public void setEnemyToFight(Enemy enemy) {
    int s = 0;

    if (game.getEnemySelected() != null) {
      Object[] options = {"Yes", "No Way!"};
      s = JOptionPane.showOptionDialog(game, "Are you sure you want to leave the fight?", "Concede",
          JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, "");
    }

    if (s == 1) {
      return;
    } else {
      curVitality = getMaxVitality(); // Reset health

      /* Reset rage */
      curRage = 1;
      repaintRage();

      /* Prepare player health bar */
      game.getBar_playerHealth().setMaximum(getMaxVitality());
      game.repaintHealthBars();

      /* Show enemy on battlefield */
      game.getLblEnemyImage().setIcon(enemy.getEnemyImage());
      game.getLblEnemyImage().setVerticalAlignment(enemy.getValign());
      game.getLblEnemyName().setText(enemy.getName());

      /* Draw enemy abilities */
      game.getPanel_abilitiesContainer().removeAll();
      for (int i = 0; i < 6; i++) {
        if (i < enemy.getEnemyAbilities().size()) {
          game.getPanel_abilitiesContainer().add(enemy.getEnemyAbilities().get(i));
        }
      }
      game.getPanel_enemy().setVisible(true);;

      game.getTextPane().setText(""); // Clear event area
      game.setEnemySelected(enemy); // Set enemy to fight
      dmgTakenPreviously = 0;
      game.repaintUpgradeButtons();

      resetHeroWarmups();
      Game.setTurn(1); // Reset turns
      game.paintEvent(null, "Now facing:  " + game.getEnemySelected().getName(), null); // Display
                                                                                        // events
    }
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
    btnOffensive.setSelected(true);
    btnDefensive.setSelected(false);

    /* Repaint stance icons */
    btnOffensive.setIcon(offensiveIcon_small);
    btnDefensive.setIcon(defensiveIcon);
    btnOffensive.setBorder(new LineBorder(Color.BLACK, 2));
    btnDefensive.setBorder(new LineBorder(Color.BLACK, 1));

    /* Add & remove buffs & debuffs from array list */
    removeBuff(buff_stanceDefensive);
    addBuff(buff_stanceOffensive, 0);

    try {
      game.repaintHealthBars();
    } catch (Exception e) {
    }
    repaintBuffTooltips();
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
    btnOffensive.setSelected(false);
    btnDefensive.setSelected(true);

    /* Repaint stance icons */
    btnOffensive.setIcon(offensiveIcon);
    btnDefensive.setIcon(defensiveIcon_small);
    btnOffensive.setBorder(new LineBorder(Color.BLACK, 1));
    btnDefensive.setBorder(new LineBorder(Color.BLACK, 2));

    /* Add & remove buffs & debuffs from array list */
    removeBuff(buff_stanceOffensive);
    addBuff(buff_stanceDefensive, 0);

    try {
      game.repaintHealthBars();
    } catch (Exception e) {
    }
    repaintBuffTooltips();
    game.repaint(); // Repaint GUI
    game.revalidate();
  }

  @Override
  public void enableStanceButtons() {
    btnOffensive.setEnabled(true);
    btnDefensive.setEnabled(true);
  }

  @Override
  public void disableStanceButtons() {
    btnOffensive.setEnabled(false);
    btnDefensive.setEnabled(false);
  }


  /**
   * Called when upgrade button is clicked to upgrade vitality
   */
  public void upgradeVitality() {
    if (((points_vitality + 1) <= maxPoints_vitality) && (enhancementPoints > 0)) {
      points_vitality++;
      enhancementPoints -= 1;
    }
    game.repaintHealthBars();
    game.repaintUpgradeButtons();
    repaintTooltips();
    repaintStats();
  }

  /**
   * Called when upgrade button is clicked to upgrade rage
   */
  public void upgradeRage() {
    if (((points_rage + 1) <= maxPoints_rage) && (enhancementPoints > 0)) {
      points_rage++;
      maxRage++;
      repaintRage();
      enhancementPoints -= 1;
    }
    game.repaintUpgradeButtons();
    repaintTooltips();
    repaintStats();
  }

  /**
   * Called when upgrade button is clicked to upgrade strength
   */
  public void upgradeStrength() {
    if (((points_strength + 1) <= maxPoints_strength) && (enhancementPoints > 0)) {
      points_strength++;
      enhancementPoints -= 1;
    }
    game.repaintUpgradeButtons();
    repaintTooltips();
    repaintStats();
  }

  /**
   * Called when upgrade button is clicked to upgrade toughness
   */
  public void upgradeToughness() {
    if (((points_toughness + 1) <= maxPoints_toughness) && (enhancementPoints > 0)) {
      points_toughness++;
      enhancementPoints -= 1;
    }
    game.repaintUpgradeButtons();
    repaintTooltips();
    repaintStats();
  }

  /**
   * Called when upgrade button is clicked to upgrade ripostechance
   */
  public void upgradeRiposteChance() {
    if (((points_riposteChance + 1) <= maxPoints_riposteChance) && (enhancementPoints > 0)) {
      points_riposteChance++;
      enhancementPoints -= 1;
    }
    game.repaintUpgradeButtons();
    repaintTooltips();
    repaintStats();
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
   * @return the maximum vitality
   */
  public int getMaxVitality() {
    return (425 - 75 + (level * 75)) + ((points_vitality * 75) - 75) + getDefensiveExtraHealth();
  }

  /**
   * Return extra health from defensive stance if it's selected
   * 
   * @return defensiveExtraHealth The amount of extra health given by defensive stance
   * @return 0 If defensive stance is not selected
   */
  public int getDefensiveExtraHealth() {
    boolean selected = false;
    try {
      selected = btnDefensive.isSelected();
    } catch (Exception e) {
    }
    if (selected) {
      return defensiveExtraHealth;
    } else {
      return 0;
    }
  }

  /**
   * @return the damage multiplier of the hero
   */
  public double getDmgMultiplier() {
    if (btnOffensive.isSelected()) {
      double multiplier = dmgMultiplier + (offensiveDamagePercentage / 100);
      return multiplier;
    } else {
      return dmgMultiplier;
    }
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
  public double getStrength() {
    return ((-0.01 * (Math.pow(level, 2)) + (3 * level) + 2.2)) + (points_strength * 1.5);
  }

  /**
   * @return the riposteChance
   */
  public double getRiposteChance() {
    return ((Math.pow(Math.E, (level * 0.016)) * 14) - 12)
        + (Math.pow(Math.E, (points_riposteChance * 0.3)));
  }

  @Override
  public double getToughness() {
    return (Math.pow(Math.E, (level * 0.03)) * 2.8) + (points_toughness * 0.25);
  }

  /**
   * @return the array of upgrade buttons
   */
  public ArrayList<JButton> getArrayUpgradeButtons() {
    return ArrayUpgradeButtons;
  }

  @Override
  public double getMaxHealth() {
    return getMaxVitality();
  }
}
