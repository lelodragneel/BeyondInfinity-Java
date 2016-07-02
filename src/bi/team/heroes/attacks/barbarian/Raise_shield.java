package bi.team.heroes.attacks.barbarian;

import javax.swing.JButton;

import bi.team.BeyondInfinity;
import bi.team.Game;
import bi.team.heroes.Barbarian;

public class Raise_shield extends Attack {

  /**
   * Class constructor
   * 
   * @param hero The chosen hero
   * @param game The main game
   */
  public Raise_shield(Barbarian hero, Game game) {
    super(hero, game, new JButton());

    button.setText(("<html>" + "<table width=\"162\">" + "<tr>"
        + "<td width=\"48\" rowspan=\"2\" align=\"left\">" + "<img src=\""
        + BeyondInfinity.class.getResource("/images/attacks/raise_shield.png") + "\">" + "</th>"
        + "<td height=\"26\" align=\"center\"><font size=\"4\">Raise Shield</font></th>" + "</tr>"
        + "<tr>" + "<td><p align=\"center\">3x <img src=\""
        + BeyondInfinity.class.getResource("/images/rage_mini.png") + "\"></p></td>" + "</tr>"
        + "</table>" + "</html>"));
    maxWarmup = 2;
    curWarmup = 2;
    rageNeeded = 3;
  }

  @Override
  public void startAttack() {}
}
