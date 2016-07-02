package bi.team.heroes.attacks.barbarian;

import javax.swing.JButton;

import bi.team.BeyondInfinity;
import bi.team.Game;
import bi.team.heroes.Barbarian;

public class Massacre extends Attack {

  /**
   * Class constructor
   * 
   * @param hero The chosen hero
   * @param game The main game
   */
  public Massacre(Barbarian hero, Game game) {
    super(hero, game, new JButton());

    button.setText(("<html>" + "<table width=\"162\">" + "<tr>"
        + "<td width=\"48\" rowspan=\"2\" align=\"left\">" + "<img src=\""
        + BeyondInfinity.class.getResource("/images/attacks/massacre.png") + "\">" + "</th>"
        + "<td height=\"26\" align=\"center\"><font size=\"4\">Massacre</font></th>" + "</tr>"
        + "<tr>" + "<td><p align=\"center\">5x <img src=\""
        + BeyondInfinity.class.getResource("/images/rage_mini.png") + "\"></p></td>" + "</tr>"
        + "</table>" + "</html>"));
    maxWarmup = 2;
    curWarmup = 2;
    rageNeeded = 5;
  }

  @Override
  public void startAttack() {}
}
