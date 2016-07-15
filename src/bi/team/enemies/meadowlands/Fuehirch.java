package bi.team.enemies.meadowlands;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import bi.team.BeyondInfinity;
import bi.team.Burn;
import bi.team.Game;
import bi.team.enemies.Enemy;

@SuppressWarnings("serial")
public class Fuehirch extends Enemy {
  private JLabel ability_1 = new JLabel() {
    public Point getToolTipLocation(MouseEvent event) {
      return new Point((event.getX() + 20), (event.getY() + 10));
    }
  };
  private String abilityName_1 = "Ignite";
  private double burnDamage = 40;
  private int burnDuration = 2;
  private int abilityMaxCooldown_1 = 3;
  private int abilityCurCooldown_1 = 3;

  /**
   * Class constructor
   * 
   * @param game The main game
   */
  public Fuehirch(Game game) {
    super(game, SwingConstants.BOTTOM);
    super.setBorder(new LineBorder(new Color(0, 0, 0), 1));

    name = "Fuehirch";
    enemyNumber = 1;
    curHealth = getMaxHealth();
    enemyImage = new ImageIcon(getClass().getResource("/images/enemies/meadowlands/fuehirch.png"));
    enemyImage_small =
        new ImageIcon(getClass().getResource("/images/enemies/meadowlands/fuehirch_small.png"));
    ability_1.setText(("<html>" + "<img src=\""
        + BeyondInfinity.class.getResource("/images/enemies/meadowlands/ability_1.png") + "\">"
        + "</html>"));
    ability_1.setToolTipText(
        "<html>" + Game.styles + "<body> <table><tr>" + "<td valign=\"top\"><img src=\""
            + BeyondInfinity.class.getResource("/images/enemies/meadowlands/ability_1.png")
            + "\"></td>" + "<td><span id=\"title\">" + abilityName_1 + "</span><br><br>"
            + "<span id=\"s01\">Cooldown:</span><b id=\"val\"> " + abilityMaxCooldown_1 + "</b>"
            + "<span id=\"s02\"> Turns</span><br><br>"
            + "<p id=\"desc\">Burns the opponent for <b id=\"val\">" + burnDamage
            + "</b> burn damage over <b id=\"val\">" + burnDuration + "</b> turns.</p><br>"
            + "</td></tr></table>" + "</body><html>");
    ability_1.setOpaque(true);
    ability_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
    enemyAbilities.add(ability_1);
  }

  @Override
  public void attackPlayer() {
    if (turnsStunned <= 0) {
      if (abilityCurCooldown_1 <= 0) { // Use ability 1
        game.getHero().getBurnArrayList().add(new Burn(burnDuration, burnDamage));
        abilityCurCooldown_1 = getAbilityMaxCooldown_1();
      } else { // Normal basic attack
        abilityCurCooldown_1--;

        /* Hero takes damage */
        double dmg = getDamage();
        game.getHero().takeDamage(dmg,
            new ImageIcon(getClass().getResource("/images/basic_damage.png")));
      }
    } else {
      turnsStunned--;
    }

    repaintEnemyAbilities();
    game.getHero().burn(); // Burn hero check
  }

  @Override
  public void takeDamage(double damage, ImageIcon attackIcon) {

    /* Enemy takes damage */
    double dmg = damage;
    dmg = Math.round(dmg * 100.0) / 100.0; // Round damage to 2 decimal places
    curHealth = (curHealth - dmg);

    game.paintEvent(attackIcon, dmg + "",
        new ImageIcon(getClass().getResource("/images/impact_toEnemy.png"))); // Paint event

    game.repaintBuffs();
    game.repaintHealthBars();
    game.repaint(); // Repaint health bars
  }

  @Override
  public void repaintEnemyAbilities() {
    if (abilityCurCooldown_1 <= 0) {
      ability_1.setBorder(new LineBorder(new Color(46, 204, 113), 2));
    } else {
      ability_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
    }
  }

  @Override
  public void prepareFight() {

    curHealth = getMaxHealth(); // Reset health
    game.repaintHealthBars();
  }

  /**
   * @return the maximum ability cooldown
   */
  public int getAbilityMaxCooldown_1() {
    return abilityMaxCooldown_1;
  }
}
