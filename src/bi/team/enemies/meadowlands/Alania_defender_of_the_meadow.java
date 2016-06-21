package bi.team.enemies.meadowlands;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import bi.team.Game;
import bi.team.enemies.Enemy;

@SuppressWarnings("serial")
public class Alania_defender_of_the_meadow extends Enemy {

  /**
   * Class constructor
   * 
   * @param game The main game
   */
  public Alania_defender_of_the_meadow(Game game) {
    super(game, SwingConstants.BOTTOM);
    super.setBorder(new LineBorder(new Color(0, 0, 0), 2));
    
    name = "Alania Defender of the Meadow";
    enemyNumber = 7;
    damage = 10;
    maxHealth = 90;
    curHealth = 90;
    experienceDrop = 0;
    enemyImage = new ImageIcon(
        getClass().getResource("/images/enemies/meadowlands/alania-defender-of-the-meadow.png"));
    enemyImage_small = new ImageIcon(getClass()
        .getResource("/images/enemies/meadowlands/alania-defender-of-the-meadow_small.png"));
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
