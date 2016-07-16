package bi.team.enemies;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class EnemyAttack extends JLabel {
  private String abilityName;
  private int maxCooldown;
  private int curCooldown;

  public EnemyAttack(String name, int maxCooldown) {
    this.abilityName = name;
    this.maxCooldown = maxCooldown;
    this.setOpaque(true);
    this.setBorder(new LineBorder(new Color(0, 0, 0), 2));
  }

  @Override
  public Point getToolTipLocation(MouseEvent event) {
    return new Point((event.getX() + 20), (event.getY() + 10));
  }

  /**
   * Reduce curCooldown by 1
   */
  public void reduceCooldown() {
    curCooldown--;
    if (curCooldown < 0) { // Error check below 0
      curCooldown = 0;
    }
  }

  /**
   * @return abilityName The name of the ability
   */
  public String toString() {
    return abilityName;
  }

  /**
   * @return the current cooldown of this ability
   */
  public int getCurCooldown() {
    return curCooldown;
  }

  /**
   * @param curCooldown Set the current cooldown of this ability
   */
  public void setCurCooldown(int curCooldown) {
    this.curCooldown = curCooldown;
  }

  /**
   * @return the maximum cooldown of this ability
   */
  public int getMaxCooldown() {
    return maxCooldown;
  }
}
