package bi.team.heroes.attacks.barbarian;

import bi.team.BeyondInfinity;
import bi.team.Game;
import bi.team.heroes.Barbarian;

public class Raise_shield extends Attack {
  private boolean active = false;
  private int turnActivated;
  private int turnDuration;
  private double blockPercentage;
  private double reflectPercentage;

  /**
   * Class constructor
   * 
   * @param hero The chosen hero
   * @param game The main game
   */
  public Raise_shield(Barbarian hero, Game game) {
    super(hero, game);

    name = "Raise Shield";
    baseDamage = 0;
    maxWarmup = 2;
    curWarmup = 2;
    rageNeeded = 3;
    button.setText(("<html>" + "<table width=\"162\">" + "<tr>"
        + "<td width=\"48\" rowspan=\"2\" align=\"left\">" + "<img src=\""
        + BeyondInfinity.class.getResource("/images/attacks/raise_shield.png") + "\">" + "</th>"
        + "<td height=\"26\" align=\"center\"><font size=\"4\">Raise Shield</font></th>" + "</tr>"
        + "<tr>" + "<td><p align=\"center\">" + rageNeeded + "x <img src=\""
        + BeyondInfinity.class.getResource("/images/rage_mini.png") + "\"></p></td>" + "</tr>"
        + "</table>" + "</html>"));
    repaintTooltip();
  }

  @Override
  public void startAttack() {

    turnActivated = Game.getTurnNum();

  }

  @Override
  public void repaintTooltip() {}

  /**
   * @return the turn which Raise Shield was activated
   */
  public int getTurnActivated() {
    return turnActivated;
  }

  /**
   * @return the number of turns Raise Shield lasts for
   */
  public int getTurnDuration() {
    return turnDuration;
  }
}
