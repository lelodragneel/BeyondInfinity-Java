package bi.team;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MyGraphics extends JPanel {

	// init variables
	private Attack button;
	int width;

	// constructor
	public MyGraphics(Attack button) {
		this.button = button;
	}

	// paint component to draw the cooldowns on attack buttons
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		/*       TEMPORARILY DISABLED       */
//		// this is temporary until a mathematical equation is figured out
//		if (button.getEnergy() == 20)
//			width = button.getButton().getWidth();
//		else if (button.getEnergy() == 15)
//			width = button.getButton().getWidth() * 3 / 4;
//		else if (button.getEnergy() == 10)
//			width = button.getButton().getWidth() / 2;
//		else if (button.getEnergy() == 5)
//			width = button.getButton().getWidth() / 4;
//		else
//			width = 0;

		// draw the cooldown animation on the jbutton this.setOpaque(false);
		g.setColor(new Color(0.2f, 0.28f, 0.37f, 0.15f));
		g.fillRect(0, 0, width, button.getButton().getHeight());
		g.setFont(new Font("Tahoma Bold", Font.PLAIN, 12));

	}

}
