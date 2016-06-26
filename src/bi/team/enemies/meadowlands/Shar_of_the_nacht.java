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
    damage = 10;
    curHealth = getMaxHealth();
    enemyImage =
        new ImageIcon(getClass().getResource("/images/enemies/meadowlands/shar-of-the-nacht.png"));
    enemyImage_small = new ImageIcon(
        getClass().getResource("/images/enemies/meadowlands/shar-of-the-nacht_small.png"));
  }

  @Override
  public void attackPlayer() {

    /* Hero takes damage */
    game.getHero().setCurHealth(game.getHero().getCurHealth() - damage);

    game.repaintHealthBars();
    game.repaint(); // Repaint health bars
  }

  @Override
  public void prepareFight() {

    /* Prepare enemy health bar */
    game.repaintHealthBars();
  }
}
