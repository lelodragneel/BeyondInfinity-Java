package bi.team.bosstype;

import java.awt.Color;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class GuardianBoss extends Boss {

	Border border;
	
	public GuardianBoss() {
		super();
		border = new LineBorder(new Color(0, 0, 0), 2);
	}

	// return a guardianboss border
	public Border getBorder() {
		return border;
	}

}
