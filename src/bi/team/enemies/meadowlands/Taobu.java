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
    enemyNumber = 3;
    damage = 10;
    maxHealth = 90;
    curHealth = 90;
    experienceDrop = 0;
    enemyImage = new ImageIcon(getClass().getResource("/images/enemies/meadowlands/taobu.png"));
    enemyImage_small =
        new ImageIcon(getClass().getResource("/images/enemies/meadowlands/taobu_small.png"));
  }

  @Override
  public void attackPlayer() {

    /* Hero takes damage */
    game.getHero().setCurHealth(game.getHero().getCurHealth() - damage);

    /* Paint hero's health bar */
    game.getBar_playerHealth().setValue((int) game.getHero().getCurHealth());
    game.getBar_playerHealth()
        .setString(game.getHero().getCurHealth() + " / " + game.getHero().getMaxHealth());

    game.repaint(); // Repaint health bars
  }

  @Override
  public void prepareFight() {

    /* Prepare enemy health bar */
    game.getBar_enemyHealth().setMaximum((int) maxHealth);
    game.getBar_enemyHealth().setValue((int) maxHealth);
    game.getBar_enemyHealth().setString(curHealth + " / " + maxHealth);
  }
}
