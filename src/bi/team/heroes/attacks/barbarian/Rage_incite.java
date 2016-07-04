package bi.team.heroes.attacks.barbarian;

import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.text.BadLocationException;

import bi.team.BeyondInfinity;
import bi.team.Game;
import bi.team.heroes.Barbarian;

public class Rage_incite extends Attack {
  double attackMultiplier = 1;
  boolean active = false;

  /**
   * Class constructor
   * 
   * @param hero The chosen hero
   * @param game The main game
   */
  public Rage_incite(Barbarian hero, Game game) {
    super(hero, game);

    baseDamage = 0;
    maxWarmup = 2;
    curWarmup = 2;
    rageNeeded = 5;
    button.setText(("<html>" + "<table width=\"162\">" + "<tr>"
        + "<td width=\"48\" rowspan=\"2\" align=\"left\">" + "<img src=\""
        + BeyondInfinity.class.getResource("/images/attacks/rage_incite.png") + "\">" + "</th>"
        + "<td height=\"26\" align=\"center\"><font size=\"4\">Rage Incite</font></th>" + "</tr>"
        + "<tr>" + "<td><p align=\"center\">5x <img src=\""
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
            + "\"></td><td><span style=\"vertical-align:middle; font:12px Comic Sans MS;\"> used</span></td></tr></table></center>",
        0, 0, null);
  }

  @Override
  public void repaintTooltip() {}

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
