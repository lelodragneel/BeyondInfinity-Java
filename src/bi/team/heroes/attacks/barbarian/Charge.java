package bi.team.heroes.attacks.barbarian;

import bi.team.BeyondInfinity;
import bi.team.Game;
import bi.team.heroes.Barbarian;

public class Charge extends Attack {

  /**
   * Class constructor
   * 
   * @param hero The chosen hero
   * @param game The main game
   */
  public Charge(Barbarian hero, Game game) {
    super(hero, game);

    button.setText(("<html>" + "<table width=\"162\">" + "<tr>"
        + "<td width=\"48\" rowspan=\"2\" align=\"left\">" + "<img src=\""
        + BeyondInfinity.class.getResource("/images/attacks/charge.png") + "\">" + "</th>"
        + "<td height=\"26\" align=\"center\"><font size=\"4\">Charge</font></th>" + "</tr>"
        + "<tr>" + "<td><p align=\"center\">1x <img src=\""
        + BeyondInfinity.class.getResource("/images/rage_mini.png") + "\"></p></td>" + "</tr>"
        + "</table>" + "</html>"));
    maxWarmup = 2;
    curWarmup = 2;
    rageNeeded = 1;
  }

  @Override
  public void startAttack() {}
}
