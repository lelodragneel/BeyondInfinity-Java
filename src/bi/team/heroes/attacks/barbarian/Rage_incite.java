package bi.team.heroes.attacks.barbarian;

import javax.swing.ImageIcon;
import javax.swing.text.BadLocationException;

import bi.team.BeyondInfinity;
import bi.team.Game;
import bi.team.heroes.Barbarian;

public class Rage_incite extends Attack {

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
    hero.setDmgMultiplier(hero.getDmgMultiplier() + 1); // Increase dmg by 100%

    /* Display events */
    game.getTextArea()
        .insertIcon(new ImageIcon(getClass().getResource("/images/attacks/rage_incite.png")));
    doc.insertString(doc.getLength(), "activated", game.getaSet());
    doc.insertString(doc.getLength(), "\n", game.getaSet());
  }

  @Override
  public void repaintTooltip() {}
}
