package bi.team.heroes;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import bi.team.Burn;
import bi.team.Game;
import bi.team.enemies.Enemy;
import bi.team.graphics.XPAnimation;
import bi.team.heroes.attacks.barbarian.Attack;

public abstract class Hero {
  public static int level = 1;
  public static int maxLevel = 60;
  public static double curExperience = 0;
  private XPAnimation xpAnimation;
  protected ArrayList<Attack> AttacksArrayList;
  protected ArrayList<JButton> ArrayUpgradeButtons;
  protected ArrayList<Burn> burnArrayList = new ArrayList<Burn>();
  protected Game game;
  protected JPanel panel_stances;
  protected int enhancementPoints = 0;
  protected String name;
  protected double dmgTakenPreviously;
  protected int turnsStunned = 0;

  /**
   * Class constructor
   * 
   * @param game The main game
   */
  public Hero(Game game, String name) {
    this.game = game;
    this.name = name;
    xpAnimation = new XPAnimation(game);
  }

  /**
   * Add a buff or debuff to the hero
   * 
   * @param buff The buff/debuff to add
   */
  public void addBuff(JLabel buff) {
    if (game.getBuffsArrayList().size() < 12) {
      game.getBuffsArrayList().add(buff);
    }
    repaintBuffTooltips();
    game.repaintBuffs();
  }

  /**
   * Add a buff or debuff to the hero at a desired index
   * 
   * @param buff The buff/debuff to add
   * @param index The number of the index to place the buff at
   */
  public void addBuff(JLabel buff, int index) {
    if (game.getBuffsArrayList().size() < 12) {
      game.getBuffsArrayList().add(index, buff);
    }
    repaintBuffTooltips();
    game.repaintBuffs();
  }

  /**
   * Remove a buff or debuff from the hero
   * 
   * @param buff The buff/debuff to add
   */
  public void removeBuff(JLabel buff) {
    game.getBuffsArrayList().remove(buff);
    repaintBuffTooltips();
    game.repaintBuffs();
  }

  /**
   * Add experience to player level, and level up if necessary
   * 
   * @param d Integer value of experience to add
   */
  public void addExperience(double d) {
    double xpTillLevelup = (((Math.pow(level, 2)) * 1.2) + 210) - curExperience;

    if ((d >= xpTillLevelup) && (level != maxLevel)) { // Level up
      level++;
      curExperience = (int) Math.round(d - xpTillLevelup);

      game.paintEvent(new ImageIcon(getClass().getResource("/images/levelup.png")),
          "You reached level " + level,
          new ImageIcon(getClass().getResource("/images/levelup.png"))); // Paint level up event
    } else { // Add experience
      curExperience += d;
    }
    xpAnimation.animateXP(d);
    game.repaintXpBar();
    game.repaintHealthBars();
    repaintTooltips();
    repaintStats();
  }

  /**
   * Reduce the warmup of all attacks by 1
   */
  public void reduceWarmup() {
    for (Attack x : AttacksArrayList) {
      if (x.getCurWarmup() >= 0 && x.getCurWarmup() < x.getMaxWarmup()) {
        x.setCurWarmup(x.getCurWarmup() + 1);
      }
    }
  }

  /**
   * Updates the visual of the player attacks & buffs' tooltips
   */
  public void repaintTooltips() {
    for (Attack x : AttacksArrayList) {
      x.repaintTooltip();
    }
  }

  /**
   * An enemy dies
   * 
   * @param enemy The enemy to be deemed dead
   */
  public void killEnemy(Enemy enemy) {
    enemy.setAlive(false); // Set enemy dead
    game.setEnemySelected(null);
    game.getBtnSurrender().setEnabled(false);
    game.getBtnSurrender().setVisible(false);
    addExperience(enemy.getExperienceDrop()); // Give the player experience
    addEnhancementPoints(1); // Player earns enhancement point

    /* Set graphics to kill enemy */
    enemy.setBackground(new Color(239, 72, 54));
    game.getBar_enemyHealth().setString("dead");
    game.getLblEnemyImage().setVerticalAlignment(SwingConstants.BOTTOM);
    game.getLblEnemyImage().setIcon(new ImageIcon(getClass().getResource("/images/grave.png")));
  }

  /**
   * @param enhancementPoints The number of enhancement points to add
   */
  public void addEnhancementPoints(int points) {
    enhancementPoints += points;
    game.getLblEnhancementPoints()
        .setText("<html>Enhancement Points: <b>" + enhancementPoints + "</b></html>");
    game.repaintUpgradeButtons();
  }

  /**
   * Enable hero upgrade buttons
   */
  public void enableUpgradeButtons() {
    for (JButton x : ArrayUpgradeButtons) {
      x.setEnabled(true);
    }
  }

  /**
   * Disable hero upgrade buttons
   */
  public void disableUpgradeButtons() {
    for (JButton x : ArrayUpgradeButtons) {
      x.setEnabled(false);
    }
  }

  /**
   * Show hero upgrade buttons
   */
  public void showUpgradeButtons() {
    for (JButton x : ArrayUpgradeButtons) {
      x.setVisible(true);
    }
  }

  /**
   * Hide hero upgrade buttons
   */
  public void hideUpgradeButtons() {
    for (JButton x : ArrayUpgradeButtons) {
      x.setVisible(false);
    }
  }

  /**
   * Repaints and updates hero-specific buff tooltips if needed
   */
  public abstract void repaintBuffTooltips();

  /**
   * Heal hero
   * 
   * @param amount The amount of health to heal the hero for
   */
  public abstract void healHero(double amount);

  /**
   * Repaints and updates the stats values
   */
  public abstract void repaintStats();

  /**
   * Hero takes damage from enemy
   * 
   * @param damage The number of damage to deal to hero's health
   * @param attackIcon The icon of the attack used
   */
  public abstract void takeDamage(double damage, ImageIcon attackIcon);

  /**
   * Check for active burns and apply damage to hero
   */
  public abstract void burn();

  /**
   * @return the attacks arraylist
   */
  public ArrayList<Attack> getAttacksArrayList() {
    return AttacksArrayList;
  }

  /**
   * Hero attacks the enemy
   * 
   * @param attack The attack to be used on enemy
   */
  public abstract void attackEnemy(Attack attack);

  /**
   * Set all stance buttons to active
   */
  public abstract void enableStanceButtons();

  /**
   * Set all stance buttons to inactive
   */
  public abstract void disableStanceButtons();

  /**
   * Prepare the enemy to battle
   * 
   * @param enemy The enemy to be challenged
   */
  public void setEnemyToFight(Enemy enemy) {}

  /**
   * @return true if hero is alive
   * @return false if hero is dead
   */
  public abstract boolean isAlive();

  /**
   * Surrender
   * 
   * @param ask Boolean whether or not to ask use to confirm surrender
   */
  public abstract void surrender(boolean ask);

  /**
   * @return the vitality
   */
  public abstract double getCurHealth();

  /**
   * Set the current health
   * 
   * @param curHealth The value of current health
   */
  public abstract void setCurHealth(double curHealth);

  /**
   * @return the maxVitality
   */
  public abstract double getMaxHealth();

  /**
   * @return the value of strength
   */
  public abstract double getStrength();

  /**
   * @return the value of toughness
   */
  public abstract double getToughness();

  /**
   * @return the number of enhancements
   */
  public int getEnhancementPoints() {
    return enhancementPoints;
  }

  /**
   * @return the curExperience
   */
  public static double getCurExperience() {
    return curExperience;
  }

  /**
   * @return the name of the hero with the correct gender
   */
  public String getName() {
    return name;
  }

  /**
   * @return the hero level
   */
  public static int getLevel() {
    return level;
  }

  /**
   * Set the hero level
   * 
   * @param level Set the hero level
   */
  public static void setLevel(int level) {
    Hero.level = level;
  }

  /**
   * @return the maximum level a hero can reach
   */
  public static int getMaxLevel() {
    return maxLevel;
  }

  /**
   * @return the damage that was taken last turn
   */
  public double getDmgTakenPreviously() {
    return dmgTakenPreviously;
  }

  /**
   * @param dmgTakenPreviously Set the damage that was taken last turn
   */
  public void setDmgTakenPreviously(double dmgTakenPreviously) {
    this.dmgTakenPreviously = dmgTakenPreviously;
  }

  /**
   * @return the number of turns the hero is stunned for
   */
  public int getTurnsStunned() {
    return turnsStunned;
  }

  /**
   * @param turnsStunned Set the number of turns the hero is stunned for
   */
  public void addTurnsStunned(int turnsStunned) {
    this.turnsStunned += turnsStunned;
  }

  /**
   * @return the array list of the burn effects
   */
  public ArrayList<Burn> getBurnArrayList() {
    return burnArrayList;
  }
}
