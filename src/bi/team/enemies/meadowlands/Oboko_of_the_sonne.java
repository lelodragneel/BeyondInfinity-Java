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
    damage = 10;
    maxHealth = 90;
    curHealth = 90;
    experienceDrop = 0;
    enemyImage =
        new ImageIcon(getClass().getResource("/images/enemies/meadowlands/oboko-of-the-sonne.png"));
    enemyImage_small = new ImageIcon(
        getClass().getResource("/images/enemies/meadowlands/oboko-of-the-sonne_small.png"));
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
