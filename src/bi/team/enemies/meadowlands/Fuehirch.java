package bi.team.enemies.meadowlands;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.text.BadLocationException;

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
    curHealth = getMaxHealth();
    enemyImage = new ImageIcon(getClass().getResource("/images/enemies/meadowlands/fuehirch.png"));
    enemyImage_small =
        new ImageIcon(getClass().getResource("/images/enemies/meadowlands/fuehirch_small.png"));
  }

  @Override
  public void attackPlayer() throws BadLocationException {

    /* Hero takes damage */
    game.getHero().setCurHealth(game.getHero().getCurHealth() - damage);

    /* Display events */
    game.getTextArea().setCaretPosition(game.getTextArea().getDocument().getLength());
    game.getTextArea().insertIcon(new ImageIcon(getClass().getResource("/images/impact_toPlayer.png")));
    game.getDoc().insertString(game.getDoc().getLength(), " " + damage + " ", game.getaSet());
    game.getTextArea()
        .insertIcon(new ImageIcon(getClass().getResource("/images/basic_damage.png")));
    game.getDoc().insertString(game.getDoc().getLength(), "\n", game.getaSet());

    game.repaintHealthBars();
    game.repaint(); // Repaint health bars
  }

  @Override
  public void prepareFight() {

    /* Prepare enemy health bar */
    game.repaintHealthBars();
  }
}
