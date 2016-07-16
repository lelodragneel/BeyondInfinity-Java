package bi.team.enemies.meadowlands;

import java.awt.Color;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import bi.team.BeyondInfinity;
import bi.team.Game;
import bi.team.enemies.Enemy;
import bi.team.enemies.EnemyAttack;

@SuppressWarnings("serial")
public class Taobu extends Enemy {
  private EnemyAttack ability_1;
  private EnemyAttack ability_2;
  private String abilityName_1 = "[Passive] Agile";
  private String abilityName_2 = "Swipe";
  private int abilityMaxCooldown_1 = 0;
  private int abilityMaxCooldown_2 = 2;
  private int passiveDodgePercentage = 20;
  private double swipeDamage = 20;

  /**
   * Class constructor
   * 
   * @param game The main game
   */
  public Taobu(Game game) {
    super(game, SwingConstants.TOP);
    super.setBorder(new LineBorder(new Color(0, 0, 0), 1));

    name = "Taobu";
    enemyNumber = 2;
    curHealth = getMaxHealth();
    enemyImage = new ImageIcon(getClass().getResource("/images/enemies/meadowlands/taobu.png"));
    enemyImage_small =
        new ImageIcon(getClass().getResource("/images/enemies/meadowlands/taobu_small.png"));

    ability_1 = new EnemyAttack(abilityName_1, abilityMaxCooldown_1);
    ability_1.setText(("<html>" + "<img src=\""
        + BeyondInfinity.class.getResource("/images/attacks/taobu/ability_1.png") + "\">"
        + "</html>"));
    enemyAbilities.add(ability_1);

    ability_2 = new EnemyAttack(abilityName_2, abilityMaxCooldown_2);
    ability_2.setText(("<html>" + "<img src=\""
        + BeyondInfinity.class.getResource("/images/attacks/taobu/ability_2.png") + "\">"
        + "</html>"));
    enemyAbilities.add(ability_2);

    repaintEnemyAbilities();
  }

  @Override
  public void attackPlayer() {
    if (turnsStunned <= 0) {
      if (enemyAbilities.get(1).getCurCooldown() <= 0) { // Use ability 2

        /* Hero takes damage */
        double dmg = swipeDamage + getDamage();
        game.getHero().takeDamage(dmg,
            new ImageIcon(getClass().getResource("/images/attacks/taobu/ability_2.png")));
        enemyAbilities.get(1).setCurCooldown(enemyAbilities.get(1).getMaxCooldown());
      } else { // Normal basic attack
        enemyAbilities.get(1).reduceCooldown();

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
    Random random = new Random();
    boolean dodge = ((random.nextInt(100 - 1 + 1) + 1) <= passiveDodgePercentage); // Dodge chance

    if (dodge) { // Enemy dodged attack
      game.paintEvent(attackIcon, "dodged",
          new ImageIcon(getClass().getResource("/images/impact_toEnemy.png"))); // Paint event
    } else {

      /* Enemy takes damage */
      double dmg = damage;
      dmg = Math.round(dmg * 100.0) / 100.0; // Round damage to 2 decimal places
      curHealth = (curHealth - dmg);

      game.paintEvent(attackIcon, dmg + "",
          new ImageIcon(getClass().getResource("/images/impact_toEnemy.png"))); // Paint event
    }

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
            + BeyondInfinity.class.getResource("/images/attacks/taobu/ability_1.png") + "\"></td>"
            + "<td><span id=\"title\">" + abilityName_1 + "</span><br><br>"
            + "<p id=\"desc\">Taobus are extremely agile, giving them <b id=\"val\">"
            + passiveDodgePercentage + "%</b> increased dodge chance.</p><br>"
            + "</td></tr></table>" + "</body><html>");
    ability_2.setToolTipText(
        "<html>" + Game.styles + "<body> <table><tr>" + "<td valign=\"top\"><img src=\""
            + BeyondInfinity.class.getResource("/images/attacks/taobu/ability_2.png") + "\"></td>"
            + "<td><span id=\"title\">" + abilityName_2 + "</span><br><br>"
            + "<span id=\"s01\">Cooldown:</span><b id=\"val\"> " + abilityMaxCooldown_2 + "</b>"
            + "<span id=\"s02\"> turns</span><br><br>"
            + "<p id=\"desc\">The Taobu claws an enemy dealing <b id=\"val\">" + swipeDamage
            + "</b> + <b id=\"val\">[" + getDamage() + "]</b> damage.</p><br>"
            + "</td></tr></table>" + "</body><html>");
  }

  @Override
  public void prepareFight() {
    curHealth = getMaxHealth(); // Reset health
    game.repaintHealthBars();
  }
}
