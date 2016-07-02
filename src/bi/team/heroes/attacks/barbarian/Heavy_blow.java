package bi.team.heroes.attacks.barbarian;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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
    super(hero, game, new JButton());

    button.setText(("<html>" + "<table width=\"162\">" + "<tr>"
        + "<td width=\"48\" rowspan=\"2\" align=\"left\">" + "<img src=\""
        + BeyondInfinity.class.getResource("/images/attacks/heavy_blow.png") + "\">" + "</th>"
        + "<td height=\"26\" align=\"center\"><font size=\"4\">Heavy Blow</font></th>" + "</tr>"
        + "<tr>" + "<td><p align=\"center\">1x <img src=\""
        + BeyondInfinity.class.getResource("/images/rage_mini.png") + "\"></p></td>" + "</tr>"
        + "</table>" + "</html>"));
    maxWarmup = 2;
    curWarmup = 2;
    rageNeeded = 1;
  }

  @Override
  public void startAttack() throws BadLocationException {
    hero.consumeRage(rageNeeded); // Consume rage

    /* Deal damage to enemy */
    double dmg = (20 + hero.getStrength()) * hero.getDmgMultiplier();
    game.getEnemySelected().setCurHealth(game.getEnemySelected().getCurHealth() - dmg);

    /* Display events */
    game.getTextArea()
        .insertIcon(new ImageIcon(getClass().getResource("/images/attacks/heavy_blow.png")));
    doc.insertString(doc.getLength(), dmg + "", game.getaSet());
    game.getTextArea().insertIcon(new ImageIcon(getClass().getResource("/images/enemy.png")));
    doc.insertString(doc.getLength(), "\n", game.getaSet());
  }
}
