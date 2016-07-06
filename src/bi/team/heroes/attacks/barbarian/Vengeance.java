package bi.team.heroes.attacks.barbarian;

import javax.swing.ImageIcon;

import bi.team.BeyondInfinity;
import bi.team.Game;
import bi.team.heroes.Barbarian;

public class Vengeance extends Attack {
  private double vengeancePercentage = 30.0;

  /**
   * Class constructor
   * 
   * @param hero The chosen hero
   * @param game The main game
   */
  public Vengeance(Barbarian hero, Game game) {
    super(hero, game);

    name = "Vengeance";
    baseDamage = 35;
    maxWarmup = 2;
    curWarmup = 2;
    rageNeeded = 4;
    button.setText(("<html>" + "<table width=\"162\">" + "<tr>"
        + "<td width=\"48\" rowspan=\"2\" align=\"left\">" + "<img src=\""
        + BeyondInfinity.class.getResource("/images/attacks/vengeance.png") + "\">" + "</th>"
        + "<td height=\"26\" align=\"center\"><font size=\"4\">Vengeance</font></th>" + "</tr>"
        + "<tr>" + "<td><p align=\"center\">" + rageNeeded + "x <img src=\""
        + BeyondInfinity.class.getResource("/images/rage_mini.png") + "\"></p></td>" + "</tr>"
        + "</table>" + "</html>"));
    repaintTooltip();
  }

  @Override
  public void startAttack() {
    hero.consumeRage(rageNeeded); // Consume rage

    /* Deal damage to enemy */
    double dmg = (baseDamage
        + (hero.getDmgTakenPreviously() * (vengeancePercentage / 100)) * hero.getDmgMultiplier());

    game.getEnemySelected().takeDamage(dmg,
        new ImageIcon(getClass().getResource("/images/attacks/vengeance.png")));

    /* Rage incite set active/inactive */
    Rage_incite rageIncite = (Rage_incite) hero.getAttacksArrayList().get(2);
    rageIncite.reduceTurns();
  }

  @Override
  public void repaintTooltip() {
    button
        .setToolTipText("<html>" + styles + "<body> <table><tr>" + "<td valign=\"top\"><img src=\""
            + BeyondInfinity.class.getResource("/images/attacks/vengeance.png") + "\"></td>"
            + "<td><span id=\"title\">" + name + "</span><br><br>"
            + "<span id=\"s01\">Level:</span><b id=\"val\"> " + attackLevel + "</b><br>"
            + "<span id=\"s01\">Cost:</span><b id=\"val\"> " + rageNeeded + "</b>"
            + "<span id=\"s02\"> Rage</span><br>"
            + "<span id=\"s01\">Cooldown:</span><b id=\"val\"> " + maxWarmup + "</b>"
            + "<span id=\"s02\"> Turns</span><br><br>" + "<p id=\"desc\">" + "Fueled by vengeance, "
            + hero.getName() + " deals <b id=\"val\">" + baseDamage + "</b> + <b id=\"val\">"
            + vengeancePercentage + "%</b> of the damage taken from the last turn.</p><br>"
            + "</td></tr></table>" + "</body><html>");
  }

  /**
   * @return the value of the percentage of damage for Vengeance
   */
  public double getVengeancePercentage() {
    return vengeancePercentage;
  }

  /**
   * @param vengeancePercentage Set the value for the percentage of damage for Vengeance
   */
  public void setVengeancePercentage(double vengeancePercentage) {
    this.vengeancePercentage = vengeancePercentage;
  }
}
