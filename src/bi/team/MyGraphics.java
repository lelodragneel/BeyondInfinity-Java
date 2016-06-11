package bi.team;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import bi.team.heroes.attacks.barbarian.Attack;

@SuppressWarnings("serial")
public class MyGraphics extends JPanel {

	// initialize variables
	private Attack attack;
	private int width;

	// constructor
	public MyGraphics(Attack attack) {
		this.attack = attack;
	}

	// paint component to draw the cooldowns on attack buttons
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// TODO cooldown visual
		if (attack.getCurWarmup() == attack.getMaxWarmup()) {
			width = attack.getButton().getWidth();
		} else {
			width = (int) (attack.getButton().getWidth() / (attack.getMaxWarmup() - (attack.getMaxWarmup() / attack.getCurWarmup())));
		}
		
		// paint the cooldown on the jbutton
		this.setOpaque(false);
		g.setColor(new Color(0.2f, 0.28f, 0.37f, 0.15f));
		g.fillRect(0, 0, width, attack.getButton().getHeight());
		g.setFont(new Font("Tahoma Bold", Font.PLAIN, 12));
		repaint();
		
	}

}
