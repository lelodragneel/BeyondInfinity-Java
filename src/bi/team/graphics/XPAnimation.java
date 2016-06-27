package bi.team.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import bi.team.Game;

public class XPAnimation implements ActionListener {
  private Timer timer;
  private int i;
  private JLabel lblXPEarned;
  private int alpha;

  /**
   * Class constructor
   */
  public XPAnimation(Game game) {
    this.game = game;
    timer = new Timer(20, this);

    /* Initialize the XP label */
    lblXPEarned = new JLabel("");
    lblXPEarned.setForeground(new Color(102, 51, 153, 255));
    lblXPEarned.setHorizontalAlignment(SwingConstants.CENTER);
    lblXPEarned.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
    lblXPEarned.setBounds(499, 28, 46, 16);
    game.getPanel_top().add(lblXPEarned);
  }

  /**
   * Start the earned experience fading animation
   * 
   * @param xp The number of experience earned
   */
  public void animateXP(double xp) {
    timer.stop();
    i = 100;
    lblXPEarned.setText("+" + xp + " xp");
    lblXPEarned.setForeground(new Color(102, 51, 153, 255));

    timer.start();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (i < 0) {
      timer.stop();
    } else if (i <= 50) {
      alpha = (int) Math.round(i * 5.1);
      lblXPEarned.setForeground(new Color(102, 51, 153, alpha));
    }
    i--;
  }
}
