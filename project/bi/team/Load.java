package bi.team;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Load {

	// init variables
	private Timer timer;
	private int i = 0;
	private Game parent;

	// constructor
	public Load(Game parent) {
		this.parent = parent;
	}

	public void start() {

		// disable buttons to limit the game to one thread
		parent.disableButtons();

		// reset loading bar
		parent.setProgBar_loading(0);

		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				parent.setProgBar_loading(i++);

				if (i > 100) {
					timer.stop();
					parent.executeTasks();
				}
			}
		};
		
		// timer which triggers the actionlistener every 15ms
		timer = new Timer(15, listener);
		timer.start();

	}

}
