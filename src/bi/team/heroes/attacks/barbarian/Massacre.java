package bi.team.heroes.attacks.barbarian;

import javax.swing.ImageIcon;

import bi.team.BeyondInfinity;
import bi.team.Game;
import bi.team.heroes.Barbarian;

public class Massacre extends Attack {
  private double healPercentage = 20;

  /**
   * Class constructor
   * 
   * @param hero The chosen hero
   * @param game The main game
   */
  public Massacre(Barbarian hero, Game game) {
    super(hero, game);

    name = "Massacre";
    baseDamage = 150;
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

    /* Deal damage to enemy */
    double dmg = (baseDamage + hero.getStrength()) * hero.getDmgMultiplier();

    game.getEnemySelected().takeDamage(dmg,
        new ImageIcon(getClass().getResource("/images/attacks/massacre.png")));

    /* Heal hero */
    double percentage = getHealPercentage() / 100;
    double missingHealth = hero.getMaxHealth() - hero.getCurHealth();
    double healthToRecover = missingHealth * percentage;
    healthToRecover = Math.round(healthToRecover * 100.0) / 100.0; // Round health to 2 decimal
                                                                   // places
    hero.healHero(healthToRecover);

    game.paintEvent(new ImageIcon(getClass().getResource("/images/health_cross.png")),
        "+" + healthToRecover, new ImageIcon(getClass().getResource("/images/health_cross.png")));

    /* Rage incite set active/inactive */
    Rage_incite rageIncite = (Rage_incite) hero.getAttacksArrayList().get(2);
    rageIncite.reduceTurns();
  }

  @Override
  public void repaintTooltip() {
    button.setToolTipText("<html>" + Game.styles + "<body> <table><tr>"
        + "<td valign=\"top\"><img src=\""
        + BeyondInfinity.class.getResource("/images/attacks/massacre.png") + "\"></td>"
        + "<td><span id=\"title\">" + name + "</span><br><br>"
        + "<span id=\"s01\">Level:</span><b id=\"val\"> " + attackLevel + "</b><br>"
        + "<span id=\"s01\">Cost:</span><b id=\"val\"> " + rageNeeded + "</b>"
        + "<span id=\"s02\"> rage</span><br>" + "<span id=\"s01\">Cooldown:</span><b id=\"val\"> "
        + maxWarmup + "</b>" + "<span id=\"s02\"> turns</span><br><br>" + "<p id=\"desc\">"
        + hero.getName() + " spins to inflict <b id=\"val\">" + baseDamage
        + "</b> + <b id=\"val\">[" + hero.getStrength()
        + "]</b> damage to surrounding enemies, and recovers <b id=\"val\">" + healPercentage
        + "%</b> of " + game.getLang1() + " missing health.</p><br>" + "</td></tr></table>"
        + "</body><html>");
  }

  /**
   * @return the percentage of health to heal
   */
  public double getHealPercentage() {
    return healPercentage;
  }
}
