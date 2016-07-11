package bi.team.graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Timer;
import javax.swing.text.BadLocationException;

import bi.team.Game;
import bi.team.heroes.Hero;
import bi.team.heroes.attacks.barbarian.Attack;

public class EnemyLoad implements ActionListener {
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
  public EnemyLoad(Game game, Hero hero) {
    this.game = game;
    this.hero = hero;
  }

  /**
   * Start animating the loading bar for ENEMY's turn
   */
  public void nextTurn() {
    game.disableAttackButtons(); // Disable buttons to prevent simultaneous attacks
    game.setProgBar_loading(0); // Reset loading bar
    if (game.getEnemySelected().getTurnsStunned() > 0) {
      i = 0;
    } else {
      i = 100; // Reset count
    }

    timer = new Timer(15, this); // Timer triggering actionlistener every 15ms
    timer.start();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    game.setProgBar_loading(i--); // Increment loading bar value

    if (i < 0) { // Conditional check for who's turn
      timer.stop(); // Stop the loop
      if (!Game.getTurn()) { // If it's enemy's turn
        try { // Enemy attacks the player
          game.getEnemySelected().attackPlayer();
        } catch (BadLocationException | IOException e1) {
        }
        if (!hero.isAlive()) { // Check if hero is dead
          game.getEnemySelected().enemyLevelup();
          hero.surrender(false);
        }
        Game.addTurn(); // Increment turns
        if (hero.getTurnsStunned() > 0) {
          PlayerLoad playerLoad = new PlayerLoad(game, hero);
          playerLoad.nextTurn(attack);
        }
        game.enableAttackButtons(); // Re-enable buttons
        game.repaintUpgradeButtons();
      }
    }
  }
}
