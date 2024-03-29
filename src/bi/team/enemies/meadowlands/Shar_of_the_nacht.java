package bi.team.enemies.meadowlands;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import bi.team.Game;
import bi.team.enemies.Enemy;

@SuppressWarnings("serial")
public class Shar_of_the_nacht extends Enemy {

  /**
   * Class constructor
   * 
   * @param game The main game
   */
  public Shar_of_the_nacht(Game game) {
    super(game, SwingConstants.BOTTOM);
    super.setBorder(new LineBorder(new Color(0, 0, 0), 1));

    name = "Shar of the Nacht";
    enemyNumber = 5;
    curHealth = getMaxHealth();
    enemyImage =
        new ImageIcon(getClass().getResource("/images/enemies/meadowlands/shar-of-the-nacht.png"));
    enemyImage_small = new ImageIcon(
        getClass().getResource("/images/enemies/meadowlands/shar-of-the-nacht_small.png"));
  }

  @Override
  public void attackPlayer() {
    if (turnsStunned <= 0) {

      /* Hero takes damage */
      double dmg = getDamage();
      game.getHero().takeDamage(dmg,
          new ImageIcon(getClass().getResource("/images/basic_damage.png")));
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

  }
  
  @Override
  public void prepareFight() {
    curHealth = getMaxHealth(); // Reset health
    game.repaintHealthBars();
  }
}
