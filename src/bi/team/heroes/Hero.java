package bi.team.heroes;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import bi.team.Game;
import bi.team.enemies.Enemy;
import bi.team.heroes.attacks.barbarian.Attack;

public abstract class Hero {
  public static int level = 1;
  public static int maxLevel = 60;
  public static double curExperience = 0;
  protected ArrayList<Attack> AttacksArrayList;
  protected ArrayList<JButton> ArrayUpgradeButtons;
  protected Game game;
  protected int enhancementPoints;
  protected JPanel panel_stances;
  protected int healthPoints;

  /**
   * Class constructor
   * 
   * @param game The main game
   */
  public Hero(Game game) {
    this.game = game;
    enhancementPoints = 0;
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
      addEnhancementPoints(1);
      enableUpgradeButtons();
      curExperience = (int) Math.round(d - xpTillLevelup);
    } else { // Add experience
      curExperience += d;
    }
    game.repaintXpBar();
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
   * An enemy dies
   * 
   * @param enemy The enemy to be deemed dead
   */
  public void killEnemy(Enemy enemy) {
    enemy.setAlive(false); // Set enemy dead
    game.getBtnSurrender().setEnabled(false);
    game.getBtnSurrender().setVisible(false);
    addExperience(enemy.getExperienceDrop()); // Give the player experience

    /* Set graphics to kill enemy */
    enemy.setBackground(new Color(239, 72, 54));
    game.getBar_enemyHealth().setString("dead");
    game.getLblEnemyImage().setVerticalAlignment(SwingConstants.BOTTOM);
    game.getLblEnemyImage().setIcon(new ImageIcon(getClass().getResource("/images/grave.png")));
  }

  /**
   * @param enhancementPoints The integer value to add
   */
  public void addEnhancementPoints(int points) {
    enhancementPoints += points;
    game.getLblEnhancementPoints()
        .setText("<html>Enhancement Points: <b>" + enhancementPoints + "</b></html>");
    enableUpgradeButtons();
    showUpgradeButtons();
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
   * Player attacks the enemy
   * 
   * @param attack The attack the player used
   */
  public abstract void attackEnemy(Attack attack);

  /**
   * @return the attacks arraylist
   */
  public ArrayList<Attack> getAttacksArrayList() {
    return AttacksArrayList;
  }

  /**
   * Set all stance buttons to active
   */
  public abstract void enableStanceButtons();

  /**
   * Set all stance buttons to inactive
   */
  public abstract void disableStanceButtons();


  /**
   * @param points The number of health points to add
   */
  public void addHealthPoints(int points) {
    healthPoints += points;
    game.repaintHealthBars();
  }

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
   */
  public abstract void surrender();

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
}
