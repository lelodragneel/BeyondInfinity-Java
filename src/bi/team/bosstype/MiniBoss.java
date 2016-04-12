package bi.team.bosstype;

import java.awt.Color;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class MiniBoss extends Boss {

	Border border;
	
	public MiniBoss() {
		super();
		border = new LineBorder(new Color(0, 0, 0), 1);
	}
	
	// return a miniboss border
	public Border getBorder() {
		return border;
	}

}
