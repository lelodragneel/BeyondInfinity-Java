package bi.team.bosstype;

import java.awt.Color;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class SuperBoss extends Boss {

	Border border;
	
	public SuperBoss() {
		super();
		border = new LineBorder(new Color(0, 0, 0), 2);
	}

	// return a superboss border
	public Border getBorder() {
		return border;
	}
	
}
