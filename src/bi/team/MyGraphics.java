package bi.team;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import bi.team.heroes.attacks.Attack;

@SuppressWarnings("serial")
public class MyGraphics extends JPanel {

	// init variables
	private Attack attack;
	private int width;

	// constructor
	public MyGraphics(Attack attack) {
		this.attack = attack;
	}

	// paint component to draw the cooldowns on attack buttons
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// TODO cooldown visual for every individual button
		// temporary value
		width = attack.getButton().getWidth();
		
		// paint the cooldown on the jbutton
		this.setOpaque(false);
		g.setColor(new Color(0.2f, 0.28f, 0.37f, 0.15f));
		g.fillRect(0, 0, width, attack.getButton().getHeight());
		g.setFont(new Font("Tahoma Bold", Font.PLAIN, 12));
		repaint();
		
	}

}
