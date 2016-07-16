package bi.team.enemies.meadowlands;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import bi.team.BeyondInfinity;
import bi.team.Burn;
import bi.team.Game;
import bi.team.enemies.Enemy;
import bi.team.enemies.EnemyAttack;

@SuppressWarnings("serial")
public class Fuehirch extends Enemy {
  private EnemyAttack ability_1;
  private String abilityName_1 = "Ignite";
  private int abilityMaxCooldown_1 = 3;
  private double burnDamage = 40;
  private int burnDuration = 2;

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

    ability_1 = new EnemyAttack(abilityName_1, abilityMaxCooldown_1);
    ability_1.setText(("<html>" + "<img src=\""
        + BeyondInfinity.class.getResource("/images/attacks/fuehirch/ability_1.png") + "\">"
        + "</html>"));
    enemyAbilities.add(ability_1);

    repaintEnemyAbilities();
  }

  @Override
  public void attackPlayer() {
    if (turnsStunned <= 0) {
      if (enemyAbilities.get(0).getCurCooldown() <= 0) { // Use ability 1
        game.getHero().getBurnArrayList().add(new Burn(burnDuration, burnDamage));
        enemyAbilities.get(0).setCurCooldown(enemyAbilities.get(0).getMaxCooldown());
      } else { // Normal basic attack
        enemyAbilities.get(0).reduceCooldown();

        /* Hero takes damage */
        double dmg = getDamage();
        game.getHero().takeDamage(dmg,
            new ImageIcon(getClass().getResource("/images/basic_damage.png")));
      }
    } else {
      turnsStunned--;
    }

    repaintEnemyAbilities();
    try {
      game.getHero().burn(); // Burn hero check
    } catch (Exception e) {
    }
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
    repaintEnemyAbilities();
    game.repaint(); // Repaint health bars
  }

  @Override
  public void repaintEnemyAbilities() {
    for (EnemyAttack x : enemyAbilities) {
      if (x.getCurCooldown() <= 0) {
        x.setBorder(new LineBorder(new Color(46, 204, 113), 2));
      } else {
        x.setBorder(new LineBorder(new Color(0, 0, 0), 2));
      }
    }
    ability_1.setToolTipText(
        "<html>" + Game.styles + "<body> <table><tr>" + "<td valign=\"top\"><img src=\""
            + BeyondInfinity.class.getResource("/images/attacks/fuehirch/ability_1.png")
            + "\"></td>" + "<td><span id=\"title\">" + abilityName_1 + "</span><br><br>"
            + "<span id=\"s01\">Cooldown:</span><b id=\"val\"> " + abilityMaxCooldown_1 + "</b>"
            + "<span id=\"s02\"> Turns</span><br><br>"
            + "<p id=\"desc\">Burns the opponent for <b id=\"val\">" + burnDamage
            + "</b> burn damage over <b id=\"val\">" + burnDuration + "</b> turns.</p><br>"
            + "</td></tr></table>" + "</body><html>");
    game.repaint();
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
