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
    damage = 10;
    maxHealth = 90;
    curHealth = 90;
    experienceDrop = 0;
    enemyImage = new ImageIcon(getClass().getResource("/images/enemies/meadowlands/mantisray.png"));
    enemyImage_small =
        new ImageIcon(getClass().getResource("/images/enemies/meadowlands/mantisray_small.png"));
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
