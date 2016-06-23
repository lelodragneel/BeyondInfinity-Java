package bi.team.heroes;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import bi.team.Game;
import bi.team.enemies.Enemy;
import bi.team.heroes.attacks.barbarian.Attack;

public abstract class Hero {
  public static int level = 1;
  public static int maxLevel = 60;
  public static int curExperience = 0;
  protected ArrayList<Attack> AttacksArrayList;
  protected Game game;
  protected int enhancementPoints;
  protected JPanel panel_stances;

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
   * @param xp Integer value of experience to add
   */
  public void addExperience(int xp) {
    double xpTillLevelup = (((Math.pow(level, 2)) * 1.2) + 210) - curExperience;

    if ((xp >= xpTillLevelup) && (level != maxLevel)) { // Level up
      level++;
      curExperience = (int) Math.round(xp - xpTillLevelup);
    } else { // Add experience
      curExperience += xp;
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
    addExperience(enemy.getExperienceDrop()); // Give the player experience

    /* Set graphics to kill enemy */
    enemy.setBackground(new Color(239, 72, 54));
    game.getBar_enemyHealth().setString("dead");
    game.getLblEnemyImage().setVerticalAlignment(SwingConstants.BOTTOM);
    game.getLblEnemyImage().setIcon(new ImageIcon(getClass().getResource("/images/grave.png")));
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
   * Set all upgrade buttons to active
   */
  public abstract void enableButtons();

  /**
   * Set all upgrade buttons to inactive
   */
  public abstract void disableButtons();

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
   * Set the maximum health
   * 
   * @param maxHealth The value of maximum health
   */
  public abstract void setMaxHealth(double maxHealth);

  /**
   * @return the sharpness
   */
  public double getSharpness() {
    return 0;
  }

  /**
   * @return the number of enhancements
   */
  public int getEnhancementPoints() {
    return enhancementPoints;
  }

  /**
   * @param enhancementPoints The integer value to set
   */
  public void setEnhancementPoints(int enhancementPoints) {
    this.enhancementPoints = enhancementPoints;
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
