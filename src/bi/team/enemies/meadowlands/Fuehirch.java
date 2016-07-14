package bi.team.enemies.meadowlands;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import bi.team.Burn;
import bi.team.Game;
import bi.team.enemies.Enemy;
import bi.team.heroes.attacks.barbarian.Raise_shield;

@SuppressWarnings("serial")
public class Fuehirch extends Enemy {
  private double burnDamage = 40;
  private int burnDuration = 2;
  private int abilityMaxCooldown_1 = 3;
  private int abilityCurCooldown_1 = 3;

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
    curHealth = getMaxHealth();
    enemyImage = new ImageIcon(getClass().getResource("/images/enemies/meadowlands/fuehirch.png"));
    enemyImage_small =
        new ImageIcon(getClass().getResource("/images/enemies/meadowlands/fuehirch_small.png"));
  }

  @Override
  public void attackPlayer() {
    if (turnsStunned <= 0) {
      if (abilityCurCooldown_1 <= 0) { // Use ability 1
        game.getHero().getBurnArrayList().add(new Burn(burnDuration, burnDamage));
        abilityCurCooldown_1 = getAbilityMaxCooldown_1();
      } else { // Normal basic attack
        abilityCurCooldown_1--;

        /* Hero takes damage */
        double dmg = getDamage();
        game.getHero().takeDamage(dmg,
            new ImageIcon(getClass().getResource("/images/basic_damage.png")));
      }
    } else {
      turnsStunned--;
    }

    game.getHero().burn(); // Burn hero check
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

  /**
   * @return the maximum ability cooldown
   */
  public int getAbilityMaxCooldown_1() {
    return abilityMaxCooldown_1;
  }
}
