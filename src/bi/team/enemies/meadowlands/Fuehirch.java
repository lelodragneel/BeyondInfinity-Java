package bi.team.enemies.meadowlands;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import bi.team.Game;
import bi.team.enemies.Enemy;

@SuppressWarnings("serial")
public class Fuehirch extends Enemy {

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
    damage = 10;
    maxHealth = 10;
    curHealth = 10;
    experienceDrop = 300;
    enemyImage = new ImageIcon(getClass().getResource("/images/enemies/meadowlands/fuehirch.png"));
    enemyImage_small =
        new ImageIcon(getClass().getResource("/images/enemies/meadowlands/fuehirch_small.png"));
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
