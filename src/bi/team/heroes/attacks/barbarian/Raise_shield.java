package bi.team.heroes.attacks.barbarian;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import bi.team.BeyondInfinity;
import bi.team.Game;
import bi.team.heroes.Barbarian;

public class Raise_shield extends Attack {
  private int turnsLeft = 0;
  private int turnDuration = 2;
  private double blockPercentage = 20;
  private double reflectPercentage = 50;
  private JLabel buff_raiseShield = new JLabel();

  /**
   * Class constructor
   * 
   * @param hero The chosen hero
   * @param game The main game
   */
  public Raise_shield(Barbarian hero, Game game) {
    super(hero, game);

    name = "Raise Shield";
    baseDamage = 0;
    maxWarmup = 2;
    curWarmup = 2;
    rageNeeded = 3;
    button.setText(("<html>" + "<table width=\"162\">" + "<tr>"
        + "<td width=\"48\" rowspan=\"2\" align=\"left\">" + "<img src=\""
        + BeyondInfinity.class.getResource("/images/attacks/raise_shield.png") + "\">" + "</th>"
        + "<td height=\"26\" align=\"center\"><font size=\"4\">Raise Shield</font></th>" + "</tr>"
        + "<tr>" + "<td><p align=\"center\">" + rageNeeded + "x <img src=\""
        + BeyondInfinity.class.getResource("/images/rage_mini.png") + "\"></p></td>" + "</tr>"
        + "</table>" + "</html>"));

    buff_raiseShield
        .setIcon(new ImageIcon(getClass().getResource("/images/buffs/buff_raiseShield.png")));
    repaintTooltip();
  }

  @Override
  public void startAttack() {
    hero.consumeRage(rageNeeded); // Consume rage

    turnsLeft = getTurnDuration();

    game.paintEvent(new ImageIcon(getClass().getResource("/images/attacks/raise_shield.png")),
        " active", null);
    hero.addBuff(buff_raiseShield);
  }

  @Override
  public void repaintTooltip() {
    button.setToolTipText("<html>" + Game.styles + "<body> <table><tr>"
        + "<td valign=\"top\"><img src=\""
        + BeyondInfinity.class.getResource("/images/attacks/raise_shield.png") + "\"></td>"
        + "<td><span id=\"title\">" + name + "</span><br><br>"
        + "<span id=\"s01\">Level:</span><b id=\"val\"> " + attackLevel + "</b><br>"
        + "<span id=\"s01\">Cost:</span><b id=\"val\"> " + rageNeeded + "</b>"
        + "<span id=\"s02\"> rage</span><br>" + "<span id=\"s01\">Cooldown:</span><b id=\"val\"> "
        + maxWarmup + "</b>" + "<span id=\"s02\"> turns</span><br><br>" + "<p id=\"desc\">"
        + "Over the next <b id=\"val\">" + turnDuration + "</b> turns, " + hero.getName()
        + "'s shield will block <b id=\"val\">" + blockPercentage
        + "%</b> incoming damage, and reflects <b id=\"val\">" + reflectPercentage
        + "%</b> of the blocked damage back to the attacker.</p><br>" + "</td></tr></table>"
        + "</body><html>");

    buff_raiseShield.setToolTipText("<html>" + Game.buffStyles + "<body> <table><tr>"
        + "<td><span id=\"title\">" + name + "</span><br><br>" + "<p id=\"desc\">" + hero.getName()
        + " is blocking <b id=\"val\">" + blockPercentage
        + "%</b> incoming damage, and reflecting <b id=\"val\">" + reflectPercentage
        + "%</b> of the blocked damage.</p><br>" + "</td></tr></table>" + "</body><html>");
  }

  /**
   * @return true if this ability is still active
   * @return false if this ability is inactive
   */
  public boolean isActive() {
    return (turnsLeft > 0);
  }

  /**
   * Subtract 1 from turnsLeft which determines when this effect ends
   */
  public void reduceTurns() {
    if (turnsLeft <= 0) { // Error checking
      return;
    }

    turnsLeft -= 1;

    if (turnsLeft == 0) {
      game.paintEvent(new ImageIcon(getClass().getResource("/images/attacks/raise_shield.png")),
          " inactive", null);
      hero.removeBuff(buff_raiseShield);
    }
  }

  /**
   * @return the number of turns Raise Shield lasts for
   */
  public int getTurnDuration() {
    return turnDuration;
  }

  /**
   * @return the blockPercentage
   */
  public double getBlockPercentage() {
    return blockPercentage;
  }

  /**
   * @param blockPercentage the blockPercentage to set
   */
  public void setBlockPercentage(double blockPercentage) {
    this.blockPercentage = blockPercentage;
  }

  /**
   * @return the percentage of damage to reflect to enemy
   */
  public double getReflectPercentage() {
    return reflectPercentage;
  }

  /**
   * @param reflectPercentage Set the percentage of damage to reflect to enemy
   */
  public void setReflectPercentage(double reflectPercentage) {
    this.reflectPercentage = reflectPercentage;
  }
}
