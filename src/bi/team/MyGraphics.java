package bi.team;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MyGraphics extends JPanel {

	// init variables
	private Attack button;
	private int width;

	// constructor
	public MyGraphics(Attack button) {
		this.button = button;
	}

	// paint component to draw the cooldowns on attack buttons
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// if cooldownTimer is zero, set width to full
		// this is needed because a multiplication by zero equals zero
		if (button.getCooldownTimer() == 0)
			width = button.getButton().getWidth();
		else if (button.getCooldownTimer() < 0)
			width = 0;
		else {
			// width of button is multiplied by this variable
			double cooldownPercentageValue = Math.abs(button.getCooldownTimer()) / Math.abs(button.getTurnCooldown());
			width = (int) ((1 - cooldownPercentageValue) * button.getButton().getWidth());
		}

		// paint the cooldown on the jbutton
		this.setOpaque(false);
		g.setColor(new Color(0.2f, 0.28f, 0.37f, 0.15f));
		g.fillRect(0, 0, width, button.getButton().getHeight());
		g.setFont(new Font("Tahoma Bold", Font.PLAIN, 12));

	}

}
