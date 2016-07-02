package bi.team.heroes.attacks.barbarian;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolTip;
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
    super(hero, game, new JButton() {
      public Point getToolTipLocation(MouseEvent event) {
        return new Point((event.getX() + 20), (event.getY() + 10));
      }
    });

    button.setText("<html>" + "<table width=\"162\">" + "<tr>"
        + "<td width=\"48\" rowspan=\"2\" align=\"left\">" + "<img src=\""
        + BeyondInfinity.class.getResource("/images/attacks/strike.png") + "\">" + "</th>"
        + "<td height=\"26\" align=\"center\"><font size=\"4\">Strike</font></th>" + "</tr>"
        + "<tr>" + "<td><p align=\"center\">0x <img src=\""
        + BeyondInfinity.class.getResource("/images/rage_mini.png") + "\"></p></td>" + "</tr>"
        + "</table>" + "</html>");
    button.setToolTipText("<html>" + styles + "<body> <table style=\"width:100%\"><tr>"
        + "<td valign=\"top\"><img src=\""
        + BeyondInfinity.class.getResource("/images/attacks/strike.png") + "\"></td>"
        + "<td><span id=\"title\">Strike</span><br><br>"
        + "<span id=\"s01\">Level:</span><b id=\"val\"> 1</b><br>"
        + "<span id=\"s01\">Cost:</span><b id=\"val\"> 0</b>" + "<span id=\"s02\"> rage</span><br>"
        + "<span id=\"s01\">Cooldown:</span><b id=\"val\"> 2</b>"
        + "<span id=\"s02\"> turns</span><br><br>"
        + "<p id=\"desc\">A basic attack dealing <b id=\"val\">300</b> damage and generates<b id=\"val\"> 1</b> additional rage.</p><br>"
        + "</td></tr></table>" + "</body><html>");
    maxWarmup = 0;
    curWarmup = 0;
    rageNeeded = 0;
  }

  @Override
  public void startAttack() throws BadLocationException {
    hero.generateRage(1); // Generate rage

    /* Deal damage to enemy */
    double dmg = hero.getStrength() * hero.getDmgMultiplier() + 300;
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
