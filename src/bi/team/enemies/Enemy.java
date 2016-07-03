package bi.team.enemies;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import bi.team.Game;

@SuppressWarnings("serial")
public abstract class Enemy extends JButton implements MouseListener {
  protected Game game;
  protected String name;
  protected boolean alive;
  protected int enemyNumber;
  private int valign;
  protected ImageIcon enemyImage_small;
  protected ImageIcon enemyImage;
  protected double curHealth;
  protected double maxHealth;
  protected double damage;
  protected double protection;
  protected int experienceDrop;
  protected double criticalChance;

  /**
   * Class constructor
   * 
   * @param game The main game
   * @param valign The vertical-alignment SwingConstant
   */
  public Enemy(Game game, int valign) {
    alive = true;
    this.game = game;
    this.valign = valign;

    /* Create a label and configured its settings */
    this.setBackground(new Color(46, 204, 113));
    this.setOpaque(true);
    this.setVerticalAlignment(SwingConstants.BOTTOM);
    this.setHorizontalAlignment(SwingConstants.RIGHT);
    this.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
    this.setFocusable(false);
    this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    this.addMouseListener(this);
  }

  /**
   * Enemy attacks player
   */
  public abstract void attackPlayer();

  /**
   * Prepare the fight
   */
  public abstract void prepareFight();

  @Override
  public void mouseEntered(MouseEvent e) {
    if (alive) {
      this.setBackground(new Color(38, 166, 91));
    } else {
      this.setBackground(new Color(192, 57, 43));
    }
  }

  @Override
  public void mouseExited(MouseEvent e) {
    if (alive) {
      this.setBackground(new Color(46, 204, 113));
    } else {
      this.setBackground(new Color(239, 72, 54));
    }
  }

  @Override
  public void mouseClicked(MouseEvent e) {}

  @Override
  public void mousePressed(MouseEvent e) {

    /* Populate information of selected enemy on map */
    game.getMap().getLblEnemyIcon().setIcon(enemyImage_small);
    game.getMap().getLblEnemyName().setText("<html>" + name + "</html>");

    if (alive) {
      game.getMap().setEnemyFocused(this);
      game.getMap().getBtnChallenge().setEnabled(true);
    } else {
      game.getMap().setEnemyFocused(null);
      game.getMap().getBtnChallenge().setEnabled(false);
    }
  }

  /**
   * Level up the most-recently killed enemy
   */
  public void enemyLevelup() {
    // TODO
  }

  @Override
  public void mouseReleased(MouseEvent e) {}

  /**
   * @return the valign
   */
  public int getValign() {
    return valign;
  }

  /**
   * @return the enemyImage_small
   */
  public ImageIcon getEnemyImage_small() {
    return enemyImage_small;
  }

  /**
   * @return the enemy name
   */
  public String getName() {
    return name;
  }

  /**
   * @return the alive
   */
  public boolean isAlive() {
    return !(curHealth <= 0);
  }

  /**
   * Set enemy alive or dead
   * 
   * @param alive Whether or not the enemy is alive
   */
  public void setAlive(boolean alive) {
    this.alive = alive;
  }

  /**
   * @return the experienceDrop
   */
  public double getExperienceDrop() {
    return ((0.8 * (Math.pow(enemyNumber, 2))) + 210);
  }

  /**
   * @return the enemyNumber
   */
  public int getEnemyNumber() {
    return enemyNumber;
  }

  /**
   * @return the enemyImage
   */
  public ImageIcon getEnemyImage() {
    return enemyImage;
  }

  /**
   * @return the enemy damage
   */
  public double getDamage() {
    return (-0.01 * (Math.pow(enemyNumber, 2)) + (3.3 * enemyNumber));
  }

  /**
   * @return the enemy curHealth
   */
  public double getCurHealth() {
    return Math.round(curHealth);
  }

  /**
   * Set the enemy curHealth
   * 
   * @param curHealth Current enemy health value
   */
  public void setCurHealth(double curHealth) {
    this.curHealth = curHealth;
  }

  /**
   * @return the enemy maxHealth
   */
  public double getMaxHealth() {
    return Math.round((300 - 85 + (enemyNumber * 85)));
  }
}
