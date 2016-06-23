package bi.team.heroes.attacks.barbarian;

import javax.swing.JButton;

import bi.team.BeyondInfinity;
import bi.team.Game;
import bi.team.heroes.Barbarian;

public class Battler_bash extends Attack {

  /**
   * Class constructor
   * 
   * @param hero The chosen hero
   * @param game The main game
   */
  public Battler_bash(Barbarian hero, Game game) {
    super(hero, game,
        new JButton("<html>" + "<table width=\"162\">" + "<tr>"
            + "<td width=\"48\" rowspan=\"2\" align=\"left\">" + "<img src=\""
            + BeyondInfinity.class.getResource("/images/attacks/battler_bash.png") + "\">" + "</th>"
            + "<td height=\"26\" align=\"center\"><font size=\"4\">Battler Bash</font></th>"
            + "</tr>" + "<tr>" + "<td><p align=\"center\">4x <img src=\""
            + BeyondInfinity.class.getResource("/images/rage_mini.png") + "\"></p></td>" + "</tr>"
            + "</table>" + "</html>"));

    maxWarmup = 2;
    curWarmup = 2;
    rageNeeded = 4;
  }

  @Override
  public void startAttack() {
    hero.consumeRage(rageNeeded); // Consume rage
  }
}
