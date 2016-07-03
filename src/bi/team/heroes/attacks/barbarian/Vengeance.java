package bi.team.heroes.attacks.barbarian;

import bi.team.BeyondInfinity;
import bi.team.Game;
import bi.team.heroes.Barbarian;

public class Vengeance extends Attack {

  /**
   * Class constructor
   * 
   * @param hero The chosen hero
   * @param game The main game
   */
  public Vengeance(Barbarian hero, Game game) {
    super(hero, game);

    baseDamage = 0;
    maxWarmup = 2;
    curWarmup = 2;
    rageNeeded = 4;
    button.setText(("<html>" + "<table width=\"162\">" + "<tr>"
        + "<td width=\"48\" rowspan=\"2\" align=\"left\">" + "<img src=\""
        + BeyondInfinity.class.getResource("/images/attacks/vengeance.png") + "\">" + "</th>"
        + "<td height=\"26\" align=\"center\"><font size=\"4\">Vengeance</font></th>" + "</tr>"
        + "<tr>" + "<td><p align=\"center\">4x <img src=\""
        + BeyondInfinity.class.getResource("/images/rage_mini.png") + "\"></p></td>" + "</tr>"
        + "</table>" + "</html>"));
    repaintTooltip();
  }

  @Override
  public void startAttack() {}

  @Override
  public void repaintTooltip() {}
}
