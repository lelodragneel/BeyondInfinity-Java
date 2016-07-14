package bi.team.enemies.meadowlands;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import bi.team.Game;
import bi.team.enemies.Enemy;

@SuppressWarnings("serial")
public class Oboko_of_the_sonne extends Enemy {

  /**
   * Class constructor
   * 
   * @param game The main game
   */
  public Oboko_of_the_sonne(Game game) {
    super(game, SwingConstants.BOTTOM);
    super.setBorder(new LineBorder(new Color(0, 0, 0), 1));

    name = "Oboko of the Sonne";
    enemyNumber = 4;
    curHealth = getMaxHealth();
    enemyImage =
        new ImageIcon(getClass().getResource("/images/enemies/meadowlands/oboko-of-the-sonne.png"));
    enemyImage_small = new ImageIcon(
        getClass().getResource("/images/enemies/meadowlands/oboko-of-the-sonne_small.png"));
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
    
    game.repaintBuffs();
    game.repaintHealthBars();
    game.repaint(); // Repaint health bars
  }

  @Override
  public void prepareFight() {

    curHealth = getMaxHealth(); // Reset health
    game.repaintHealthBars();
  }
}
