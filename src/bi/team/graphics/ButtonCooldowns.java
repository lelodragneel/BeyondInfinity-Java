package bi.team.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import bi.team.heroes.attacks.barbarian.Attack;

@SuppressWarnings("serial")
public class ButtonCooldowns extends JPanel {
  private Attack attack;
  private double width;

  /**
   * Class constructor
   * 
   * @param attack The attack button to draw graphics upon
   */
  public ButtonCooldowns(Attack attack) {
    this.attack = attack;
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    /* Calculate button width according to the cooldowns */
    if ((attack.getCurWarmup() == 0) && (attack.getMaxWarmup() != 0)) {
      width = 0;
    } else if (attack.getCurWarmup() == attack.getMaxWarmup()) {
      width = attack.getButton().getWidth();
    } else {
      width = attack.getButton().getWidth() / (attack.getMaxWarmup() / attack.getCurWarmup());
    }

    /* Paint the cooldown on the button */
    this.setOpaque(false);
    g.setColor(new Color(0.2f, 0.28f, 0.37f, 0.2f));
    g.fillRect(0, 0, (int) width, attack.getButton().getHeight());
    g.setFont(new Font("Tahoma Bold", Font.PLAIN, 12));

    repaint(); // Repaint graphics
  }
}
