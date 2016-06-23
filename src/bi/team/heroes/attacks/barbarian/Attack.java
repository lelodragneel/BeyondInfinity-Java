package bi.team.heroes.attacks.barbarian;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.text.BadLocationException;

import bi.team.Game;
import bi.team.MyGraphics;
import bi.team.heroes.Barbarian;

public abstract class Attack {
  private JButton button;
  private String name;
  protected int rageNeeded;
  protected double maxWarmup;
  protected double curWarmup;
  protected Game game;
  protected Barbarian hero;

  /**
   * Class constructor
   * 
   * @param hero The chosen hero
   * @param game The main game
   * @param button The attack button
   */
  public Attack(Barbarian hero, Game game, JButton button) {
    this.hero = hero;
    this.game = game;
    this.button = button;
    this.name = button.getText();

    /* Configure attack button */
    button.setBackground(Color.WHITE);
    button.setFocusable(false);
    button.setMargin(new Insets(0, 0, 0, 0));
    button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    button.add(new MyGraphics(this));
  }

  /**
   * Execute player attack
   * 
   * @throws BadLocationException
   */
  public abstract void startAttack() throws BadLocationException;

  /**
   * 
   * @return the maximum warmup
   */
  public double getMaxWarmup() {
    return maxWarmup;
  }

  /**
   * Set the maximum warmup
   * 
   * @param maxWarmup The maximum warmup value
   */
  public void setMaxWarmup(double maxWarmup) {
    this.maxWarmup = maxWarmup;
  }

  /**
   * @return the current warmup
   */
  public double getCurWarmup() {
    return curWarmup;
  }

  /**
   * Set the current warmup
   * 
   * @param curWarmup The current warmup value
   */
  public void setCurWarmup(double curWarmup) {
    this.curWarmup = curWarmup;
  }

  /**
   * @return the attack name
   */
  public String getName() {
    return name;
  }

  /**
   * @return the attack button
   */
  public JButton getButton() {
    return button;
  }

  /**
   * @return the rage needed to execute this attack
   */
  public int getRageNeeded() {
    return rageNeeded;
  }

}


