package bi.team.heroes.attacks.barbarian;

import javax.swing.ImageIcon;

import bi.team.BeyondInfinity;
import bi.team.Game;
import bi.team.heroes.Barbarian;

public class Charge extends Attack {
  private double strengthBuff = 10.0;

  /**
   * Class constructor
   * 
   * @param hero The chosen hero
   * @param game The main game
   */
  public Charge(Barbarian hero, Game game) {
    super(hero, game);

    name = "Charge";
    baseDamage = 10;
    maxWarmup = 2;
    curWarmup = 2;
    rageNeeded = 1;
    button.setText(("<html>" + "<table width=\"162\">" + "<tr>"
        + "<td width=\"48\" rowspan=\"2\" align=\"left\">" + "<img src=\""
        + BeyondInfinity.class.getResource("/images/attacks/charge.png") + "\">" + "</th>"
        + "<td height=\"26\" align=\"center\"><font size=\"4\">Charge</font></th>" + "</tr>"
        + "<tr>" + "<td><p align=\"center\">" + rageNeeded + "x <img src=\""
        + BeyondInfinity.class.getResource("/images/rage_mini.png") + "\"></p></td>" + "</tr>"
        + "</table>" + "</html>"));
    repaintTooltip();
  }

  @Override
  public void startAttack() {
    hero.consumeRage(rageNeeded); // Consume rage

    /* Deal damage to enemy */
    double dmg = (baseDamage + hero.getStrength() + (hero.getStrength() * (strengthBuff / 100)))
        * hero.getDmgMultiplier();

    game.getEnemySelected().takeDamage(dmg,
        new ImageIcon(getClass().getResource("/images/attacks/charge.png")));

    /* Rage incite set active/inactive */
    Rage_incite rageIncite = (Rage_incite) hero.getAttacksArrayList().get(2);
    rageIncite.reduceTurns();
  }

  @Override
  public void repaintTooltip() {
    button
        .setToolTipText("<html>" + Game.styles + "<body> <table><tr>" + "<td valign=\"top\"><img src=\""
            + BeyondInfinity.class.getResource("/images/attacks/charge.png") + "\"></td>"
            + "<td><span id=\"title\">" + name + "</span><br><br>"
            + "<span id=\"s01\">Level:</span><b id=\"val\"> " + attackLevel + "</b><br>"
            + "<span id=\"s01\">Cost:</span><b id=\"val\"> " + rageNeeded + "</b>"
            + "<span id=\"s02\"> Rage</span><br>"
            + "<span id=\"s01\">Cooldown:</span><b id=\"val\"> " + maxWarmup + "</b>"
            + "<span id=\"s02\"> Turns</span><br><br>" + "<p id=\"desc\">" + hero.getName()
            + " raises " + game.getLang1() + " <span id=\"s02\">Strength</span> by <b id=\"val\">"
            + strengthBuff + "%</b> to deal <b id=\"val\">" + baseDamage + "</b> + [<b id=\"val\">"
            + hero.getStrength() + "</b>] damage to an enemy.</p><br>" + "</td></tr></table>"
            + "</body><html>");
  }

  /**
   * @return the percentage of strengthBuff
   */
  public double getStrengthBuff() {
    return strengthBuff;
  }

  /**
   * @param strengthBuff Set the percentage for strengthBuff
   */
  public void setStrengthBuff(double strengthBuff) {
    this.strengthBuff = strengthBuff;
  }
}
