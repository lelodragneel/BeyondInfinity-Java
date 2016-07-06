package bi.team.heroes.attacks.barbarian;

import javax.swing.ImageIcon;

import bi.team.BeyondInfinity;
import bi.team.Game;
import bi.team.heroes.Barbarian;

public class Shield_bash extends Attack {
  private int turnsLeft = 0;
  private int turnDuration = 2;

  /**
   * Class constructor
   * 
   * @param hero The chosen hero
   * @param game The main game
   */
  public Shield_bash(Barbarian hero, Game game) {
    super(hero, game);

    name = "Shield Bash";
    baseDamage = 0;
    maxWarmup = 2;
    curWarmup = 2;
    rageNeeded = 4;
    button.setText(("<html>" + "<table width=\"162\">" + "<tr>"
        + "<td width=\"48\" rowspan=\"2\" align=\"left\">" + "<img src=\""
        + BeyondInfinity.class.getResource("/images/attacks/shield_bash.png") + "\">" + "</th>"
        + "<td height=\"26\" align=\"center\"><font size=\"4\">Shield Bash</font></th>" + "</tr>"
        + "<tr>" + "<td><p align=\"center\">" + rageNeeded + "x <img src=\""
        + BeyondInfinity.class.getResource("/images/rage_mini.png") + "\"></p></td>" + "</tr>"
        + "</table>" + "</html>"));
    repaintTooltip();
  }

  @Override
  public void startAttack() {
    hero.consumeRage(rageNeeded); // Consume rage

    turnsLeft = getTurnDuration();
    game.getEnemySelected().addTurnsStunned(turnDuration);

    game.paintEvent(new ImageIcon(getClass().getResource("/images/attacks/shield_bash.png")),
        " active", null);
  }

  @Override
  public void repaintTooltip() {}

  /**
   * Subtract 1 from turnsLeft which determines when this effect ends
   */
  public void reduceTurns() {
    if (turnsLeft <= 0) { // Error checking
      return;
    }

    turnsLeft -= 1;

    if (turnsLeft == 0) {
      game.paintEvent(new ImageIcon(getClass().getResource("/images/attacks/shield_bash.png")),
          " inactive", null);
    }
  }

  /**
   * @return the turn duration to be stunned for
   */
  public int getTurnDuration() {
    return turnDuration;
  }
}
