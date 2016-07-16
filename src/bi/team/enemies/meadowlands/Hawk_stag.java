package bi.team.enemies.meadowlands;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import bi.team.BeyondInfinity;
import bi.team.Game;
import bi.team.enemies.Enemy;
import bi.team.enemies.EnemyAttack;

@SuppressWarnings("serial")
public class Hawk_stag extends Enemy {
	private EnemyAttack ability_1;
	private String abilityName_1 = "Charge";
	private int abilityMaxCooldown_1 = 3;
	private double chargeDamage = 20;

  /**
   * Class constructor
   * 
   * @param game The main game
   */
  public Hawk_stag(Game game) {
    super(game, SwingConstants.BOTTOM);
    super.setBorder(new LineBorder(new Color(0, 0, 0), 1));

    name = "Hawk Stag";
    enemyNumber = 3;
    curHealth = getMaxHealth();
    enemyImage = new ImageIcon(getClass().getResource("/images/enemies/meadowlands/hawk-stag.png"));
    enemyImage_small =
        new ImageIcon(getClass().getResource("/images/enemies/meadowlands/hawk-stag_small.png"));
    
    ability_1 = new EnemyAttack(abilityName_1, abilityMaxCooldown_1);
    ability_1.setText(("<html>" + "<img src=\""
        + BeyondInfinity.class.getResource("/images/attacks/hawk_stag/ability_1.png") + "\">"
        + "</html>"));
    enemyAbilities.add(ability_1);
    
    repaintEnemyAbilities();
  }

  @Override
  public void attackPlayer() {
    if (turnsStunned <= 0) {
        if (enemyAbilities.get(0).getCurCooldown() <= 0) { // Use ability 1
            game.getHero().addTurnsStunned(1);
            enemyAbilities.get(0).setCurCooldown(enemyAbilities.get(0).getMaxCooldown());
            
            double dmg = chargeDamage + getDamage();
            game.getHero().takeDamage(dmg,
                    new ImageIcon(getClass().getResource("/images/attacks/hawk_stag/ability_1.png")));
          } else { // Normal basic attack
            enemyAbilities.get(0).reduceCooldown();
    	
      /* Hero takes damage */
      double dmg = getDamage();
      game.getHero().takeDamage(dmg,
          new ImageIcon(getClass().getResource("/images/basic_damage.png")));
         }
    } else {
      turnsStunned--;
    }
    
    repaintEnemyAbilities();
    try {
      game.getHero().burn(); // Burn hero check
    } catch (Exception e) {
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
    repaintEnemyAbilities();
    game.repaint(); // Repaint health bars
  }

  @Override
  public void repaintEnemyAbilities() {

  }
  
  @Override
  public void prepareFight() {
    curHealth = getMaxHealth(); // Reset health
    game.repaintHealthBars();
  }
}
