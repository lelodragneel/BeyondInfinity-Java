package bi.team.heroes.attacks.barbarian;

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
    super(hero, game);

    name = "Massacre";
    baseDamage = 0;
    maxWarmup = 2;
    curWarmup = 2;
    rageNeeded = 5;
    button.setText(("<html>" + "<table width=\"162\">" + "<tr>"
        + "<td width=\"48\" rowspan=\"2\" align=\"left\">" + "<img src=\""
        + BeyondInfinity.class.getResource("/images/attacks/massacre.png") + "\">" + "</th>"
        + "<td height=\"26\" align=\"center\"><font size=\"4\">Massacre</font></th>" + "</tr>"
        + "<tr>" + "<td><p align=\"center\">" + rageNeeded + "x <img src=\""
        + BeyondInfinity.class.getResource("/images/rage_mini.png") + "\"></p></td>" + "</tr>"
        + "</table>" + "</html>"));
    repaintTooltip();
  }

  @Override
  public void startAttack() {
    hero.consumeRage(rageNeeded); // Consume rage
    
    /* Rage incite set active/inactive */
    Rage_incite rageIncite = (Rage_incite) hero.getAttacksArrayList().get(2);
    rageIncite.reduceTurns();
  }

  @Override
  public void repaintTooltip() {}
}
