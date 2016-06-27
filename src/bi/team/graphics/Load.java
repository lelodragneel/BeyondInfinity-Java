package bi.team.graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import bi.team.Game;
import bi.team.heroes.Hero;
import bi.team.heroes.attacks.barbarian.Attack;

public class Load implements ActionListener {
  private Timer timer;
  private int i;
  private Game game;
  private Attack attack;
  private Hero hero;

  /**
   * Class constructor
   * 
   * @param game The main game
   * @param hero The chosen hero
   */
  public Load(Game game, Hero hero) {
    this.game = game;
    this.hero = hero;
  }

  /**
   * Start animating the loading bar for PLAYER's turn
   * 
   * @param attack The attack the player clicked
   */
  public void nextTurn(Attack attack) {
    this.attack = attack;

    game.disableAttackButtons(); // Disable buttons to prevent simultaneous attacks
    game.setProgBar_loading(0); // Reset loading bar
    i = 0; // Reset count

    timer = new Timer(15, this); // Timer triggering actionlistener every 15ms
    timer.start();
  }

  /**
   * Start animating the loading bar for ENEMY's turn
   */
  public void nextTurn() {
    game.disableAttackButtons(); // Disable buttons to prevent simultaneous attacks
    game.setProgBar_loading(0); // Reset loading bar
    i = 0; // Reset count

    timer = new Timer(15, this); // Timer triggering actionlistener every 15ms
    timer.start();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    game.setProgBar_loading(i++); // Increment loading bar value

    if (i > 100) { // Conditional check for who's turn
      timer.stop(); // Stop the loop
      if (Game.getTurn()) { // If it's player's turn
        hero.attackEnemy(attack); // Player attacks enemy
        if (!game.getEnemySelected().isAlive()) { // Check if enemy is dead
          hero.killEnemy(game.getEnemySelected());
        } else {
          Game.addTurn(); // Increment turn
          nextTurn();
        }
      } else { // If it's enemy's turn
        game.getEnemySelected().attackPlayer(); // Enemy attacks the player
        if (!hero.isAlive()) { // Check if hero is dead
          game.enemyLevelup();
        }
        Game.addTurn(); // Increment turns
        game.enableAttackButtons(); // Re-enable buttons
      }
    }
  }
}
