package bi.team;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Load {

	private Timer timer;
	private int i;
	private Game parent;
	
	public Load(Game parent) {
		this.parent = parent;
	}
	
	public void start() {

		// disable buttons to limit the game to one thread
		parent.disableButtons();

		// reset loading bar
		parent.setProgBar_loading(0);
		i = 0;

		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (i > 100) {
					timer.stop();
					parent.executeTasks();
				} else
					parent.setProgBar_loading(i++);

			}
		};
		// timer which triggers the actionlistener every 15ms
		timer = new Timer(15, listener);
		timer.start();

	}

}
