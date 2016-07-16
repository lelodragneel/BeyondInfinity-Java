package bi.team.enemies;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.text.BadLocationException;

import bi.team.Burn;
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
  protected double protection;
  protected int experienceDrop;
  protected double criticalChance;
  protected ArrayList<Burn> enemyBurnArrayList = new ArrayList<Burn>();
  protected ArrayList<EnemyAttack> enemyAbilities = new ArrayList<EnemyAttack>();
  protected int turnsStunned = 0;
  protected Burn burn;
  protected EnemyAttack enemyAttack;

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
   * Add a buff or debuff to the enemy
   * 
   * @param buff The buff/debuff to add
   */
  public void addBuff(JLabel buff) {
    if (game.getEnemyBuffsArrayList().size() < 12) {
      game.getEnemyBuffsArrayList().add(buff);
    }
    game.repaintBuffs();
  }

  /**
   * Add a buff or debuff to the enemy at a desired index
   * 
   * @param buff The buff/debuff to add
   * @param index The number of the index to place the buff at
   */
  public void addBuff(JLabel buff, int index) {
    if (game.getEnemyBuffsArrayList().size() < 12) {
      game.getEnemyBuffsArrayList().add(index, buff);
    }
    game.repaintBuffs();
  }

  /**
   * Remove a buff or debuff from the enemy
   * 
   * @param buff The buff/debuff to add
   */
  public void removeBuff(JLabel buff) {
    game.getEnemyBuffsArrayList().remove(buff);
    game.repaintBuffs();
  }

  /**
   * Repaint the enemy abilities' tooltips and border colors
   */
  public abstract void repaintEnemyAbilities();

  /**
   * Enemy attacks player
   */
  public abstract void attackPlayer() throws BadLocationException, IOException;

  /**
   * Enemy takes damage from hero
   * 
   * @param damage The number of damage to deal to enemy's health
   * @param attackIcon The icon of the attack used
   */
  public abstract void takeDamage(double damage, ImageIcon attackIcon);

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
   * Check for active burns and apply damage to enemy
   */
  public void burn() {
    game.repaintBuffs();

    for (Burn x : enemyBurnArrayList) { // Apply all active burns to enemy
      double burnDmg = x.getBurnDamage();
      burnDmg = Math.round(burnDmg * 100.0) / 100.0; // Round damage to 2 decimal places
      x.reduceTurn();
      setCurHealth(getCurHealth() - burnDmg);

      game.paintEvent(new ImageIcon(getClass().getResource("/images/burn.png")), burnDmg + "",
          new ImageIcon(getClass().getResource("/images/impact_toEnemy.png")));
    }

    game.repaintBuffs();
    game.repaintHealthBars();
    game.repaint(); // Repaint health bars
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
   * @return the jlabels representing the enemy's abilities
   */
  public ArrayList<EnemyAttack> getEnemyAbilities() {
    return enemyAbilities;
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

  /**
   * @return the number of turns this enemy is stunned for
   */
  public int getTurnsStunned() {
    return turnsStunned;
  }

  /**
   * @param turnsStunned Set the number of turns this enemy is stunned for
   */
  public void addTurnsStunned(int turnsStunned) {
    this.turnsStunned += turnsStunned;
  }

  /**
   * @return the burn array list
   */
  public ArrayList<Burn> getEnemyBurnArrayList() {
    return enemyBurnArrayList;
  }
}
