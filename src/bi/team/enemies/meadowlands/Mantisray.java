package bi.team.enemies.meadowlands;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import bi.team.Game;
import bi.team.enemies.Enemy;

@SuppressWarnings("serial")
public class Mantisray extends Enemy {

  /**
   * Class constructor
   * 
   * @param game The main game
   */
  public Mantisray(Game game) {
    super(game, SwingConstants.TOP);
    super.setBorder(new LineBorder(new Color(0, 0, 0), 1));

    name = "Mantisray";
    enemyNumber = 6;
    curHealth = getMaxHealth();
    enemyImage = new ImageIcon(getClass().getResource("/images/enemies/meadowlands/mantisray.png"));
    enemyImage_small =
        new ImageIcon(getClass().getResource("/images/enemies/meadowlands/mantisray_small.png"));
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
  }

  @Override
  public void takeDamage(double damage, ImageIcon attackIcon) {

    /* Enemy takes damage */
    double dmg = damage;
    dmg = Math.round(dmg * 100.0) / 100.0; // Round damage to 2 decimal places
    curHealth = (curHealth - dmg);

    game.paintEvent(attackIcon, dmg + "",
        new ImageIcon(getClass().getResource("/images/impact_toEnemy.png"))); // Paint event
    game.repaintHealthBars();
    game.repaint(); // Repaint health bars
  }

  @Override
  public void prepareFight() {

    curHealth = getMaxHealth(); // Reset health
    game.repaintHealthBars();
  }
}
