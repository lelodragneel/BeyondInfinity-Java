package bi.team.heroes.attacks.barbarian;

import javax.swing.ImageIcon;

import bi.team.BeyondInfinity;
import bi.team.Game;
import bi.team.heroes.Barbarian;

public class Strike extends Attack {
  private int rageToGenerate = 1;

  /**
   * Class constructor
   * 
   * @param hero The chosen hero
   * @param game The main game
   */
  public Strike(Barbarian hero, Game game) {
    super(hero, game);

    name = "Strike";
    baseDamage = 0;
    maxWarmup = 0;
    curWarmup = 0;
    rageNeeded = 0;
    button.setText("<html>" + "<table width=\"162\">" + "<tr>"
        + "<td width=\"48\" rowspan=\"2\" align=\"left\">" + "<img src=\""
        + BeyondInfinity.class.getResource("/images/attacks/strike.png") + "\">" + "</th>"
        + "<td height=\"26\" align=\"center\"><font size=\"4\">" + name + "</font></th>" + "</tr>"
        + "<tr>" + "<td><p align=\"center\">" + rageNeeded + "x <img src=\""
        + BeyondInfinity.class.getResource("/images/rage_mini.png") + "\"></p></td>" + "</tr>"
        + "</table>" + "</html>");
    repaintTooltip();
  }

  @Override
  public void startAttack() {
    hero.generateRage(rageToGenerate); // Generate rage

    /* Deal damage to enemy */
    double dmg = hero.getStrength() * hero.getDmgMultiplier();

    game.getEnemySelected().takeDamage(dmg,
        new ImageIcon(getClass().getResource("/images/attacks/strike.png")));

    /* Rage incite set active/inactive */
    Rage_incite rageIncite = (Rage_incite) hero.getAttacksArrayList().get(2);
    rageIncite.reduceTurns();
  }

  /**
   * @return the number of rage generated per turn
   */
  public int getRageToGenerate() {
    return rageToGenerate;
  }

  /**
   * @param rageToGenerate Set number of rage to regenerate per turn
   */
  public void setRageToGenerate(int rageToGenerate) {
    this.rageToGenerate = rageToGenerate;
  }

  @Override
  public void repaintTooltip() {
    button.setToolTipText("<html>" + Game.styles + "<body> <table><tr>"
        + "<td valign=\"top\"><img src=\""
        + BeyondInfinity.class.getResource("/images/attacks/strike.png") + "\"></td>"
        + "<td><span id=\"title\">" + name + "</span><br><br>"
        + "<span id=\"s01\">Level:</span><b id=\"val\"> " + attackLevel + "</b><br>"
        + "<span id=\"s01\">Cost:</span><b id=\"val\"> " + rageNeeded + "</b>"
        + "<span id=\"s02\"> Rage</span><br>" + "<span id=\"s01\">Cooldown:</span><b id=\"val\"> "
        + maxWarmup + "</b>" + "<span id=\"s02\"> Turns</span><br><br>"
        + "<p id=\"desc\">A basic attack dealing <b id=\"val\">[" + hero.getStrength()
        + "]</b> damage and generates<b id=\"val\"> " + rageToGenerate
        + "</b> additional <span id=\"s02\">Rage</span>.</p><br>" + "</td></tr></table>"
        + "</body><html>");
  }
}
