package bi.team.heroes.attacks.barbarian;

import java.io.IOException;

import javax.swing.text.BadLocationException;

import bi.team.BeyondInfinity;
import bi.team.Game;
import bi.team.heroes.Barbarian;

public class Rage_incite extends Attack {
  private double attackMultiplier = 1;
  private boolean active = false;

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
    repaintTooltip();
  }

  @Override
  public void startAttack() throws BadLocationException, IOException {
    hero.consumeRage(rageNeeded); // Consume rage
    active = true;
    hero.setDmgMultiplier(hero.getDmgMultiplier() + attackMultiplier); // Increase dmg

    /* Display events */
    game.getTextPane().setCaretPosition(game.getTextPane().getDocument().getLength());
    game.getEditorKit().insertHTML(game.getDoc(), game.getDoc().getLength(),
        "<center><table><tr><td><img style=\"width:42px; height:42px;\" src=\""
            + getClass().getResource("/images/attacks/rage_incite.png")
            + "\"></td><td><span style=\"vertical-align:middle; font:12px Comic Sans MS;\"> active</span></td></tr></table></center>",
        0, 0, null);
  }

  /**
   * Deactivate the damage multiplier of Rage Incite
   * 
   * @throws IOException
   * @throws BadLocationException
   */
  public void deactivate() throws BadLocationException, IOException {
    hero.setDmgMultiplier(hero.getDmgMultiplier() - attackMultiplier); // Remove multiplier
    active = false;

    /* Display events */
    game.getTextPane().setCaretPosition(game.getTextPane().getDocument().getLength());
    game.getEditorKit().insertHTML(game.getDoc(), game.getDoc().getLength(),
        "<center><table><tr><td><img style=\"width:42px; height:42px;\" src=\""
            + getClass().getResource("/images/attacks/rage_incite.png")
            + "\"></td><td><span style=\"vertical-align:middle; font:12px Comic Sans MS;\"> inactive</span></td></tr></table></center>",
        0, 0, null);
  }

  @Override
  public void repaintTooltip() {
    button.setToolTipText("<html>" + styles + "<body> <table><tr>"
        + "<td valign=\"top\"><img src=\""
        + BeyondInfinity.class.getResource("/images/attacks/rage_incite.png") + "\"></td>"
        + "<td><span id=\"title\">" + name + "</span><br><br>"
        + "<span id=\"s01\">Level:</span><b id=\"val\"> " + attackLevel + "</b><br>"
        + "<span id=\"s01\">Cost:</span><b id=\"val\"> " + rageNeeded + "</b>"
        + "<span id=\"s02\"> Rage</span><br>" + "<span id=\"s01\">Cooldown:</span><b id=\"val\"> "
        + maxWarmup + "</b>" + "<span id=\"s02\"> Turns</span><br><br>" + "<p id=\"desc\">"
        + hero.getName() + " uses " + game.getLang1()
        + " <span id=\"s02\">Rage</span> to double the damage of " + game.getLang1()
        + " next attack.</p><br>" + "</td></tr></table>" + "</body><html>");
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

  /**
   * @return the boolean of whether or not Rage Incite is active
   */
  public boolean isActive() {
    return active;
  }
}
