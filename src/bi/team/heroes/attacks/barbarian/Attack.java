package bi.team.heroes.attacks.barbarian;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.text.BadLocationException;

import bi.team.Game;
import bi.team.graphics.ButtonCooldowns;
import bi.team.heroes.Barbarian;

public abstract class Attack {
  protected String name;
  protected JButton button;
  protected int rageNeeded;
  protected int maxWarmup;
  protected int curWarmup;
  protected Game game;
  protected Barbarian hero;
  protected double experienceEarned;
  protected int attackLevel = 1;
  protected double baseDamage;
  protected final String styles =
      "<style>" + "body {font-family: Comic Sans MS; background: #ECF0F1; width:300px;}"
          + "#title {color: #282830; font-size: 12px;}" + "#desc {font-size: 10px; color: #282830;}"
          + "#s01 {color: #60646D; font-size: 10px;}"
          + "#s02 {font-size: 10px; color: #282830; font-style: italic;}"
          + "#val {font-size: 10px; color: #5659C9;}" + "</style>";

  /**
   * Class constructor
   * 
   * @param hero The chosen hero
   * @param game The main game
   * @param button The attack button
   */
  @SuppressWarnings("serial")
  public Attack(Barbarian hero, Game game) {
    this.hero = hero;
    this.game = game;
    button = new JButton() {
      public Point getToolTipLocation(MouseEvent event) {
        return new Point((event.getX() + 20), (event.getY() + 10));
      }
    };
    this.name = button.getText();

    /* Configure attack button */
    button.setBackground(Color.WHITE);
    button.setFocusable(false);
    button.setMargin(new Insets(0, 0, 0, 0));
    button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    button.add(new ButtonCooldowns(this));
  }

  /**
   * @return the number of experience to earn for executing attack
   */
  public double getAttackExperience() {
    if (rageNeeded == 0) {
      return 0.2;
    } else {
      return Math.pow(rageNeeded, 1.1) / 2;
    }
  }

  /**
   * Execute player attack
   * 
   * @throws BadLocationException
   * @throws IOException 
   */
  public abstract void startAttack() throws BadLocationException, IOException;

  /**
   * Repaints the tooltip with updated values
   */
  public abstract void repaintTooltip();

  /**
   * 
   * @return the maximum warmup
   */
  public int getMaxWarmup() {
    return maxWarmup;
  }

  /**
   * Set the maximum warmup
   * 
   * @param maxWarmup The maximum warmup value
   */
  public void setMaxWarmup(int maxWarmup) {
    this.maxWarmup = maxWarmup;
  }

  /**
   * @return the current warmup
   */
  public int getCurWarmup() {
    return curWarmup;
  }

  /**
   * Set the current warmup
   * 
   * @param curWarmup The current warmup value
   */
  public void setCurWarmup(int curWarmup) {
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

  /**
   * @return the base attack damage of the attack
   */
  public double getBaseDamage() {
    return baseDamage;
  }

  /**
   * @param attackDamage Set base attack damage of the attack
   */
  public void setBaseDamage(double attackDamage) {
    this.baseDamage = attackDamage;
  }
}


