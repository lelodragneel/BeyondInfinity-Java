package bi.team.heroes.attacks.barbarian;

import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.text.BadLocationException;

import bi.team.BeyondInfinity;
import bi.team.Game;
import bi.team.heroes.Barbarian;

public class Heavy_blow extends Attack {

  /**
   * Class constructor
   * 
   * @param hero The chosen hero
   * @param game The main game
   */
  public Heavy_blow(Barbarian hero, Game game) {
    super(hero, game);

    baseDamage = 20;
    maxWarmup = 2;
    curWarmup = 2;
    rageNeeded = 1;
    button.setText(("<html>" + "<table width=\"162\">" + "<tr>"
        + "<td width=\"48\" rowspan=\"2\" align=\"left\">" + "<img src=\""
        + BeyondInfinity.class.getResource("/images/attacks/heavy_blow.png") + "\">" + "</th>"
        + "<td height=\"26\" align=\"center\"><font size=\"4\">Heavy Blow</font></th>" + "</tr>"
        + "<tr>" + "<td><p align=\"center\">1x <img src=\""
        + BeyondInfinity.class.getResource("/images/rage_mini.png") + "\"></p></td>" + "</tr>"
        + "</table>" + "</html>"));
    repaintTooltip();
  }

  @Override
  public void startAttack() throws BadLocationException, IOException {
    hero.consumeRage(rageNeeded); // Consume rage

    /* Deal damage to enemy */
    double dmg = (20 + hero.getStrength()) * hero.getDmgMultiplier();
    game.getEnemySelected().setCurHealth(game.getEnemySelected().getCurHealth() - dmg);

    /* Display events */
    game.getTextPane().setCaretPosition(game.getTextPane().getDocument().getLength());
    game.getEditorKit().insertHTML(game.getDoc(), game.getDoc().getLength(),
        "<center><table><tr><td><img style=\"width:42px; height:42px;\" src=\""
            + getClass().getResource("/images/attacks/heavy_blow.png")
            + "\"></td><td><span style=\"vertical-align:middle; font:12px Comic Sans MS;\">" + dmg
            + "</span></td>" + "<td><img style=\"width:42px; height:42px;\" src=\""
            + getClass().getResource("/images/impact_toEnemy.png")
            + "\"></td></tr></table></center>",
        0, 0, null);

    /* Rage incite set active/inactive */
    Rage_incite rageIncite = (Rage_incite) hero.getAttacksArrayList().get(2);
    if (rageIncite.isActive()) {
      rageIncite.deactivate();
    }
  }

  @Override
  public void repaintTooltip() {
    button.setToolTipText("<html>" + styles + "<body> <table style=\"width:100%\"><tr>"
        + "<td valign=\"top\"><img src=\""
        + BeyondInfinity.class.getResource("/images/attacks/heavy_blow.png") + "\"></td>"
        + "<td><span id=\"title\">Heavy Blow</span><br><br>"
        + "<span id=\"s01\">Level:</span><b id=\"val\"> " + attackLevel + "</b><br>"
        + "<span id=\"s01\">Cost:</span><b id=\"val\"> " + rageNeeded + "</b>"
        + "<span id=\"s02\"> Rage</span><br>" + "<span id=\"s01\">Cooldown:</span><b id=\"val\"> "
        + maxWarmup + "</b>" + "<span id=\"s02\"> Turns</span><br><br>" + "<p id=\"desc\">"
        + hero.getName() + " swings " + game.getLang1()
        + " axe with brute force to deal<b id=\"val\"> " + baseDamage + "</b> + <b id=\"val\"> ["
        + hero.getStrength() + "]</b> damage to all enemies.</p><br>" + "</td></tr></table>"
        + "</body><html>");
  }
}
