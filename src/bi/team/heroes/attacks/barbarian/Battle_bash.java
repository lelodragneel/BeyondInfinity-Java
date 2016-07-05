package bi.team.heroes.attacks.barbarian;

import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.text.BadLocationException;

import bi.team.BeyondInfinity;
import bi.team.Game;
import bi.team.heroes.Barbarian;

public class Battle_bash extends Attack {

  /**
   * Class constructor
   * 
   * @param hero The chosen hero
   * @param game The main game
   */
  public Battle_bash(Barbarian hero, Game game) {
    super(hero, game);

    name = "Battle Bash";
    baseDamage = 100;
    maxWarmup = 2;
    curWarmup = 2;
    rageNeeded = 4;
    button.setText(("<html>" + "<table width=\"162\">" + "<tr>"
        + "<td width=\"48\" rowspan=\"2\" align=\"left\">" + "<img src=\""
        + BeyondInfinity.class.getResource("/images/attacks/battle_bash.png") + "\">" + "</th>"
        + "<td height=\"26\" align=\"center\"><font size=\"4\">Battle Bash</font></th>" + "</tr>"
        + "<tr>" + "<td><p align=\"center\">" + rageNeeded + "x <img src=\""
        + BeyondInfinity.class.getResource("/images/rage_mini.png") + "\"></p></td>" + "</tr>"
        + "</table>" + "</html>"));
    repaintTooltip();
  }

  @Override
  public void startAttack() throws BadLocationException, IOException {
    hero.consumeRage(rageNeeded); // Consume rage

    /* Deal damage to enemy */
    double dmg = baseDamage * hero.getDmgMultiplier();
    
    game.getEnemySelected().takeDamage(dmg,
        new ImageIcon(getClass().getResource("/images/attacks/battle_bash.png")));

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
        + BeyondInfinity.class.getResource("/images/attacks/battle_bash.png") + "\"></td>"
        + "<td><span id=\"title\">" + name + "</span><br><br>"
        + "<span id=\"s01\">Level:</span><b id=\"val\"> " + attackLevel + "</b><br>"
        + "<span id=\"s01\">Cost:</span><b id=\"val\"> " + rageNeeded + "</b>"
        + "<span id=\"s02\"> Rage</span><br>" + "<span id=\"s01\">Cooldown:</span><b id=\"val\"> "
        + maxWarmup + "</b>" + "<span id=\"s02\"> Turns</span><br><br>"
        + "<p id=\"desc\">Bash an enemy for <b id=\"val\">" + baseDamage + "</b> damage.</p><br>"
        + "</td></tr></table>" + "</body><html>");
  }
}
