package bi.team.bosstype;

import java.awt.Color;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class GrandBoss extends Enemy {

	Border border;
	
	public GrandBoss() {
		super();
		border = new LineBorder(new Color(0, 0, 0), 2);
	}

	// return a grandboss border
	public Border getBorder() {
		return border;
	}
	
}
