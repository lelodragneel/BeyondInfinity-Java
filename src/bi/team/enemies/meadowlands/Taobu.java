package bi.team.enemies.meadowlands;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import bi.team.Game;
import bi.team.enemies.Enemy;

@SuppressWarnings("serial")
public class Taobu extends Enemy {

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
  }

  @Override
  public void attackPlayer() {

    /* Hero takes damage */
    double dmg = getDamage() - (getDamage() * (game.getHero().getToughness() / 100));
    dmg = Math.round(dmg * 100.0) / 100.0; // Round damage to 2 decimal places
    game.getHero().setCurHealth(game.getHero().getCurHealth() - dmg);

    game.repaintHealthBars();
    game.repaint(); // Repaint health bars
  }

  @Override
  public void prepareFight() {

    curHealth = getMaxHealth(); // Reset health
    game.repaintHealthBars();
  }
}
