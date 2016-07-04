package bi.team.heroes.attacks.barbarian;

import java.io.IOException;

import javax.swing.text.BadLocationException;

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

    baseDamage = 0;
    maxWarmup = 0;
    curWarmup = 0;
    rageNeeded = 0;
    button.setText("<html>" + "<table width=\"162\">" + "<tr>"
        + "<td width=\"48\" rowspan=\"2\" align=\"left\">" + "<img src=\""
        + BeyondInfinity.class.getResource("/images/attacks/strike.png") + "\">" + "</th>"
        + "<td height=\"26\" align=\"center\"><font size=\"4\">Strike</font></th>" + "</tr>"
        + "<tr>" + "<td><p align=\"center\">0x <img src=\""
        + BeyondInfinity.class.getResource("/images/rage_mini.png") + "\"></p></td>" + "</tr>"
        + "</table>" + "</html>");
    repaintTooltip();
  }

  @Override
  public void startAttack() throws BadLocationException, IOException {
    hero.generateRage(rageToGenerate); // Generate rage

    /* Deal damage to enemy */
    double dmg = hero.getStrength() * hero.getDmgMultiplier() + 200;
    game.getEnemySelected().setCurHealth(game.getEnemySelected().getCurHealth() - dmg);

    /* Display events */
    game.getTextPane().setCaretPosition(game.getTextPane().getDocument().getLength());
    game.getEditorKit().insertHTML(game.getDoc(), game.getDoc().getLength(),
        "<center><table><tr><td><img style=\"width:42px; height:42px;\" src=\""
            + getClass().getResource("/images/attacks/strike.png")
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
    button.setToolTipText("<html>" + styles + "<body> <table style=\"width:100%\"><tr>"
        + "<td valign=\"top\"><img src=\""
        + BeyondInfinity.class.getResource("/images/attacks/strike.png") + "\"></td>"
        + "<td><span id=\"title\">Strike</span><br><br>"
        + "<span id=\"s01\">Level:</span><b id=\"val\"> " + attackLevel + "</b><br>"
        + "<span id=\"s01\">Cost:</span><b id=\"val\"> " + rageNeeded + "</b>"
        + "<span id=\"s02\"> Rage</span><br>" + "<span id=\"s01\">Cooldown:</span><b id=\"val\"> "
        + maxWarmup + "</b>" + "<span id=\"s02\"> Turns</span><br><br>"
        + "<p id=\"desc\">A basic attack dealing<b id=\"val\"> [" + hero.getStrength()
        + "]</b> damage and generates<b id=\"val\"> " + rageToGenerate
        + "</b> additional <span id=\"s02\">Rage</span>.</p><br>" + "</td></tr></table>"
        + "</body><html>");
  }
}
