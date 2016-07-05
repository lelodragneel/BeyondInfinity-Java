package bi.team.heroes.attacks.barbarian;

import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.text.BadLocationException;

import bi.team.BeyondInfinity;
import bi.team.Game;
import bi.team.heroes.Barbarian;

public class True_assault extends Attack {

  /**
   * Class constructor
   * 
   * @param hero The chosen hero
   * @param game The main game
   */
  public True_assault(Barbarian hero, Game game) {
    super(hero, game);

    name = "True Assault";
    baseDamage = 200;
    maxWarmup = 2;
    curWarmup = 2;
    rageNeeded = 6;
    button.setText(("<html>" + "<table width=\"162\">" + "<tr>"
        + "<td width=\"48\" rowspan=\"2\" align=\"left\">" + "<img src=\""
        + BeyondInfinity.class.getResource("/images/attacks/true_assault.png") + "\">" + "</th>"
        + "<td height=\"26\" align=\"center\"><font size=\"4\">True Assault</font></th>" + "</tr>"
        + "<tr>" + "<td><p align=\"center\">" + rageNeeded + "x <img src=\""
        + BeyondInfinity.class.getResource("/images/rage_mini.png") + "\"></p></td>" + "</tr>"
        + "</table>" + "</html>"));
    repaintTooltip();
  }

  @Override
  public void startAttack() throws BadLocationException, IOException {
    hero.consumeRage(rageNeeded); // Consume rage

    /* Deal damage to enemy */
    double dmg = (baseDamage + hero.getStrength()) * hero.getDmgMultiplier();

    game.getEnemySelected().takeDamage(dmg,
        new ImageIcon(getClass().getResource("/images/attacks/true_assault.png")));

    /* Rage incite set active/inactive */
    Rage_incite rageIncite = (Rage_incite) hero.getAttacksArrayList().get(2);
    if (rageIncite.isActive()) {
      rageIncite.deactivate();
    }
  }

  @Override
  public void repaintTooltip() {
    button.setToolTipText("<html>" + styles + "<body> <table><tr>"
        + "<td valign=\"top\"><img src=\""
        + BeyondInfinity.class.getResource("/images/attacks/true_assault.png") + "\"></td>"
        + "<td><span id=\"title\">" + name + "</span><br><br>"
        + "<span id=\"s01\">Level:</span><b id=\"val\"> " + attackLevel + "</b><br>"
        + "<span id=\"s01\">Cost:</span><b id=\"val\"> " + rageNeeded + "</b>"
        + "<span id=\"s02\"> Rage</span><br>" + "<span id=\"s01\">Cooldown:</span><b id=\"val\"> "
        + maxWarmup + "</b>" + "<span id=\"s02\"> Turns</span><br><br>" + "<p id=\"desc\">"
        + hero.getName() + " assaults an enemy for <b id=\"val\">" + baseDamage
        + "</b> + [<b id=\"val\">" + hero.getStrength() + "</b>] damage.</p><br>"
        + "</td></tr></table>" + "</body><html>");
  }
}
