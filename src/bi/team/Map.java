package bi.team;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import bi.team.enemies.Enemy;
import bi.team.heroes.Hero;

@SuppressWarnings("serial")
public class Map extends JLayeredPane implements ActionListener {
  private JPanel panel_map;
  private JPanel panel_enemyInfo;
  private JLabel lblEnemyName;
  private JLabel lblEnemyIcon;
  private JButton btnChallenge;
  private Game game;
  private Enemy enemyFocused;

  /**
   * Class constructor
   * 
   * @param game The main game
   */
  public Map(Game game) {
    this.game = game;

    /* Create the main map frame */
    this.setOpaque(true);
    int width = 715;
    int height = 365;
    this.setBounds(new Rectangle((Math.round(game.getWidth() / 2) - (width / 2)),
        Math.round((game.getHeight() / 2) - (height / 2) - 40), width, height));
    this.setBorder(new LineBorder(new Color(0, 0, 0)));
    this.setLayout(null);
    this.setVisible(false);

    /* Create panel for map grid */
    panel_map = new JPanel();
    panel_map.setBounds(170, 8, 539, 348);
    panel_map.setLayout(new GridBagLayout());
    panel_map.setBackground(new Color(236, 236, 236));
    this.add(panel_map);

    /* Create panel to display enemy information */
    panel_enemyInfo = new JPanel();
    panel_enemyInfo.setBorder(new LineBorder(new Color(0, 0, 0), 0));
    panel_enemyInfo.setBounds(2, 2, 168, 361);
    panel_enemyInfo.setLayout(null);
    this.add(panel_enemyInfo);

    /* Create label to display selected enemy name */
    lblEnemyName = new JLabel("");
    lblEnemyName.setVerticalAlignment(SwingConstants.TOP);
    lblEnemyName.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
    lblEnemyName.setBounds(10, 164, 150, 36);
    panel_enemyInfo.add(lblEnemyName);

    /* Create label to display selected enemy image */
    lblEnemyIcon = new JLabel("");
    lblEnemyIcon.setBorder(new LineBorder(new Color(0, 0, 0)));
    lblEnemyIcon.setBounds(10, 10, 150, 150);
    lblEnemyIcon.setHorizontalAlignment(SwingConstants.CENTER);
    lblEnemyIcon.setVerticalAlignment(SwingConstants.CENTER);
    panel_enemyInfo.add(lblEnemyIcon);

    /* Create the challenge button */
    btnChallenge = new JButton("Challenge");
    btnChallenge.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
    btnChallenge.setBounds(39, 260, 90, 90);
    btnChallenge.setFocusable(false);
    btnChallenge.setBackground(null);
    btnChallenge.addActionListener(this);
    btnChallenge.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnChallenge.setEnabled(false);
    panel_enemyInfo.add(btnChallenge);

    createGrid(); // Create the actual grid
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btnChallenge) {
      if (enemyFocused == null) {
        return;
      } else {
      game.getHero().setEnemyToFight(enemyFocused);
      game.setEnemySelected(enemyFocused);
      enemyFocused.prepareFight();
      game.toggleMap();
      }
    }
  }

  /**
   * Display enemy info
   * 
   * @param enemy The enemy selected
   */
  public void showEnemyInfo(Enemy enemy) {
    lblEnemyName.setText(enemy.getName());
    lblEnemyIcon.setIcon(enemy.getEnemyImage_small());
  }

  /**
   * Create labels for the map grid then add them to the window
   */
  public void createGrid() {
    GridBagConstraints gbc;
    Iterator<Enemy> items;
    int x = 0;
    int y = 0;

    /* Create map constraints */
    gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.BOTH;
    gbc.weightx = gbc.weighty = 1.0;
    gbc.insets = new Insets(2, 2, 2, 2);

    /* Add enemies to the gridbag map */
    items = game.getEnemyEntries().listIterator();
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 12 && items.hasNext(); j++) {
        gbc.gridx = x++;
        panel_map.add(items.next(), gbc);
      }
      gbc.gridy = ++y;
      x = 0;
    }

    // add the 3 guardian bosses and the grand boss (final boss) to gridbag grid
    // gbc.gridy = 6;
    // gbc.gridx = 1;
    // panel_map.add(items.next(), gbc);
    // gbc.gridy = 6;
    // gbc.gridx = 4;
    // panel_map.add(items.next(), gbc);
    // gbc.gridy = 6;
    // gbc.gridx = 7;
    // panel_map.add(items.next(), gbc);
    // gbc.gridy = 6;
    // gbc.gridx = 10;
    // panel_map.add(items.next(), gbc);
  }

  /**
   * @return the btnChallenge
   */
  public JButton getBtnChallenge() {
    return btnChallenge;
  }

  /**
   * @return the lblEnemyName
   */
  public JLabel getLblEnemyName() {
    return lblEnemyName;
  }

  /**
   * @return the lblEnemyIcon
   */
  public JLabel getLblEnemyIcon() {
    return lblEnemyIcon;
  }

  /**
   * @return the game
   */
  public Hero getHero() {
    return game.getHero();
  }

  /**
   * @return the enemy focused
   */
  public Enemy getEnemyFocused() {
    return enemyFocused;
  }

  /**
   * @param enemyFocused The enemy selected from map
   */
  public void setEnemyFocused(Enemy enemyFocused) {
    this.enemyFocused = enemyFocused;
  }
}
