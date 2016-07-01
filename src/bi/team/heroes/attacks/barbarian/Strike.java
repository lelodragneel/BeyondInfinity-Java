package bi.team.heroes.attacks.barbarian;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.text.BadLocationException;

import bi.team.BeyondInfinity;
import bi.team.Game;
import bi.team.heroes.Barbarian;

public class Strike extends Attack {

  /**
   * Class constructor
   * 
   * @param hero The chosen hero
   * @param game The main game
   */
  public Strike(Barbarian hero, Game game) {
    super(hero, game,
        new JButton("<html>" + "<table width=\"162\">" + "<tr>"
            + "<td width=\"48\" rowspan=\"2\" align=\"left\">" + "<img src=\""
            + BeyondInfinity.class.getResource("/images/attacks/strike.png") + "\">" + "</th>"
            + "<td height=\"26\" align=\"center\"><font size=\"4\">Strike</font></th>" + "</tr>"
            + "<tr>" + "<td><p align=\"center\">0x <img src=\""
            + BeyondInfinity.class.getResource("/images/rage_mini.png") + "\"></p></td>" + "</tr>"
            + "</table>" + "</html>"));

    maxWarmup = 0;
    curWarmup = 0;
    rageNeeded = 0;
  }

  @Override
  public void startAttack() throws BadLocationException {
    hero.generateRage(1); // Generate rage

    /* Deal damage to enemy */
    double dmg = hero.getStrength() * hero.getDmgMultiplier() + 100;
    game.getEnemySelected().setCurHealth(game.getEnemySelected().getCurHealth() - dmg);
    
    /* Display events */
    game.getTextArea().setCaretPosition(game.getTextArea().getDocument().getLength());
    game.getTextArea()
        .insertIcon(new ImageIcon(getClass().getResource("/images/attacks/strike.png")));
    doc.insertString(doc.getLength(), dmg + "", game.getaSet());
    game.getTextArea().insertIcon(new ImageIcon(getClass().getResource("/images/enemy.png")));
    doc.insertString(doc.getLength(), "\n", game.getaSet());
  }
}
