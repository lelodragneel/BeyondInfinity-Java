package bi.team.heroes.attacks.barbarian;

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
  public void startAttack() throws BadLocationException {
    hero.consumeRage(rageNeeded); // Consume rage
    active = true;
    hero.setDmgMultiplier(hero.getDmgMultiplier() + attackMultiplier); // Increase dmg

    /* Display events */
    game.getTextArea()
        .insertIcon(new ImageIcon(getClass().getResource("/images/attacks/rage_incite.png")));
    game.getDoc().insertString(game.getDoc().getLength(), "activated", game.getaSet());
    game.getDoc().insertString(game.getDoc().getLength(), "\n", game.getaSet());
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

  /**
   * @param active Set the boolean of whether or not Rage Incite is active
   */
  public void setActive(boolean active) {
    this.active = active;
  }
}
