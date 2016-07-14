package bi.team;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Burn extends JLabel {
  private int turnsLeft;
  private double burnDamage;

  /**
   * Class constructor
   * 
   * @param burnDuration The number of turns this burn will last for
   * @param damage Total burn damage to deal
   */
  public Burn(int burnDuration, double damage) {
    this.setIcon(new ImageIcon(getClass().getResource("/images/buffs/buff_fire.png")));
    this.burnDamage = damage / burnDuration;
    turnsLeft = burnDuration;
  }

  /**
   * @return the number of turns before this burn ends
   */
  public int getTurnsLeft() {
    return turnsLeft;
  }

  /**
   * @return the amount of burn damage to deal per turn
   */
  public double getBurnDamage() {
    return burnDamage;
  }

  /**
   * Reduce the turnsLeft by 1 after burning the hero
   */
  public void reduceTurn() {
    if (turnsLeft > 0) {
      turnsLeft--;
    }
  }
}
