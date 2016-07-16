package bi.team.heroes.attacks.barbarian;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import bi.team.BeyondInfinity;
import bi.team.Game;
import bi.team.heroes.Barbarian;

public class Incapacitate extends Attack {
  private double empowerPercentage = 20;
  private int turnDuration = 1;
  private int turnsLeft = 0;
  private JLabel buff_incapacitate = new JLabel();

  /**
   * Class constructor
   * 
   * @param hero The chosen hero
   * @param game The main game
   */
  public Incapacitate(Barbarian hero, Game game) {
    super(hero, game);

    name = "Incapacitate";
    baseDamage = 0;
    maxWarmup = 2;
    curWarmup = 2;
    rageNeeded = 3;
    button.setText(("<html>" + "<table width=\"162\">" + "<tr>"
        + "<td width=\"48\" rowspan=\"2\" align=\"left\">" + "<img src=\""
        + BeyondInfinity.class.getResource("/images/attacks/incapacitate.png") + "\">" + "</th>"
        + "<td height=\"26\" align=\"center\"><font size=\"4\">Incapacitate</font></th>" + "</tr>"
        + "<tr>" + "<td><p align=\"center\">" + rageNeeded + "x <img src=\""
        + BeyondInfinity.class.getResource("/images/rage_mini.png") + "\"></p></td>" + "</tr>"
        + "</table>" + "</html>"));

    buff_incapacitate
        .setIcon(new ImageIcon(getClass().getResource("/images/buffs/buff_incapacitate.png")));
    repaintTooltip();
  }

  @Override
  public void startAttack() {
    hero.consumeRage(rageNeeded); // Consume rage

    turnsLeft = getTurnDuration();
    hero.setDmgMultiplier(hero.getDmgMultiplier() + (empowerPercentage / 100)); // Dmg multiplier
    game.getEnemySelected().addTurnsStunned(turnDuration); // Stun enemy

    game.paintEvent(new ImageIcon(getClass().getResource("/images/attacks/incapacitate.png")),
        " active", null);
    hero.addBuff(buff_incapacitate);
    game.repaintBuffs();
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
      hero.setDmgMultiplier(hero.getDmgMultiplier() - (empowerPercentage / 100));
      game.paintEvent(new ImageIcon(getClass().getResource("/images/attacks/incapacitate.png")),
          " inactive", null);
      hero.removeBuff(buff_incapacitate);
      game.repaintBuffs();
    }
  }

  /**
   * @return true if this ability is still active
   * @return false if this ability is inactive
   */
  public boolean isActive() {
    return (turnsLeft > 0);
  }

  @Override
  public void repaintTooltip() {
    button.setToolTipText("<html>" + Game.styles + "<body> <table><tr>"
        + "<td valign=\"top\"><img src=\""
        + BeyondInfinity.class.getResource("/images/attacks/incapacitate.png") + "\"></td>"
        + "<td><span id=\"title\">" + name + "</span><br><br>"
        + "<span id=\"s01\">Level:</span><b id=\"val\"> " + attackLevel + "</b><br>"
        + "<span id=\"s01\">Cost:</span><b id=\"val\"> " + rageNeeded + "</b>"
        + "<span id=\"s02\"> rage</span><br>" + "<span id=\"s01\">Cooldown:</span><b id=\"val\"> "
        + maxWarmup + "</b>" + "<span id=\"s02\"> turns</span><br><br>" + "<p id=\"desc\">"
        + "Disable an enemy, rendering him/her unable to attack for <b id=\"val\">" + turnDuration
        + "</b> turn(s) and empowering " + hero.getName() + "'s attacks by <b id=\"val\">"
        + empowerPercentage + "%</b>.</p><br>" + "</td></tr></table>" + "</body><html>");

    buff_incapacitate.setToolTipText("<html>" + Game.buffStyles + "<body> <table><tr>"
        + "<td><span id=\"title\">" + name + "</span><br><br>" + "<p id=\"desc\">" + hero.getName()
        + "Attacks empowered by <b id=\"val\"> " + empowerPercentage + "%</b>.</p><br>"
        + "</td></tr></table>" + "</body><html>");
  }

  /**
   * @return the number of turns Raise Shield lasts for
   */
  public int getTurnDuration() {
    return turnDuration;
  }
}
