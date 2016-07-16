package bi.team.heroes.attacks.barbarian;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import bi.team.BeyondInfinity;
import bi.team.Game;
import bi.team.heroes.Barbarian;

public class Rage_incite extends Attack {
  private double attackMultiplier = 1;
  private boolean active = false;
  private JLabel buff_rageIncite = new JLabel();

  /**
   * Class constructor
   * 
   * @param hero The chosen hero
   * @param game The main game
   */
  public Rage_incite(Barbarian hero, Game game) {
    super(hero, game);

    name = "Rage Incite";
    baseDamage = 0;
    maxWarmup = 2;
    curWarmup = 2;
    rageNeeded = 5;
    button.setText(("<html>" + "<table width=\"162\">" + "<tr>"
        + "<td width=\"48\" rowspan=\"2\" align=\"left\">" + "<img src=\""
        + BeyondInfinity.class.getResource("/images/attacks/rage_incite.png") + "\">" + "</th>"
        + "<td height=\"26\" align=\"center\"><font size=\"4\">" + name + "</font></th>" + "</tr>"
        + "<tr>" + "<td><p align=\"center\">" + rageNeeded + "x <img src=\""
        + BeyondInfinity.class.getResource("/images/rage_mini.png") + "\"></p></td>" + "</tr>"
        + "</table>" + "</html>"));
    buff_rageIncite
        .setIcon(new ImageIcon(getClass().getResource("/images/buffs/buff_rageIncite.png")));
    repaintTooltip();
  }

  @Override
  public void startAttack() {
    hero.consumeRage(rageNeeded); // Consume rage

    active = true;
    hero.setDmgMultiplier(hero.getDmgMultiplier() + attackMultiplier); // Increase dmg

    game.paintEvent(new ImageIcon(getClass().getResource("/images/attacks/rage_incite.png")),
        " active", null);
    hero.addBuff(buff_rageIncite);
  }

  /**
   * Deactivate the damage multiplier of Rage Incite
   */
  public void reduceTurns() {
    if (!active) { // Error checking
      return;
    }

    hero.setDmgMultiplier(hero.getDmgMultiplier() - attackMultiplier); // Remove multiplier
    active = false;

    game.paintEvent(new ImageIcon(getClass().getResource("/images/attacks/rage_incite.png")),
        " inactive", null);
    hero.removeBuff(buff_rageIncite);
  }

  @Override
  public void repaintTooltip() {
    button.setToolTipText(
        "<html>" + Game.styles + "<body> <table><tr>" + "<td valign=\"top\"><img src=\""
            + BeyondInfinity.class.getResource("/images/attacks/rage_incite.png") + "\"></td>"
            + "<td><span id=\"title\">" + name + "</span><br><br>"
            + "<span id=\"s01\">Level:</span><b id=\"val\"> " + attackLevel + "</b><br>"
            + "<span id=\"s01\">Cost:</span><b id=\"val\"> " + rageNeeded + "</b>"
            + "<span id=\"s02\"> rage</span><br>"
            + "<span id=\"s01\">Cooldown:</span><b id=\"val\"> " + maxWarmup + "</b>"
            + "<span id=\"s02\"> turns</span><br><br>" + "<p id=\"desc\">" + hero.getName()
            + " uses " + game.getLang1() + " <span id=\"s02\">Rage</span> to double the damage of "
            + game.getLang1() + " next attack.</p><br>" + "</td></tr></table>" + "</body><html>");

    buff_rageIncite.setToolTipText("<html>" + Game.buffStyles + "<body> <table><tr>"
        + "<td><span id=\"title\">" + name + "</span><br><br>" + "<p id=\"desc\">"
        + "The next attack will deal double the damage.</p><br>" + "</td></tr></table>"
        + "</body><html>");
  }

  /**
   * @return the value which the damage is multiplied by
   */
  public double getAttackMultiplier() {
    return attackMultiplier;
  }

  /**
   * @param attackMultiplier The value which the damage is multiplied by
   */
  public void setAttackMultiplier(double attackMultiplier) {
    this.attackMultiplier = attackMultiplier;
  }
}
