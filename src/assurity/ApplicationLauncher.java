package assurity;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import assurity.ui.ApplicationForm;

/**
 *
 * @author Mohammad Ahmad
 * November, 2018
 *
 */
public class ApplicationLauncher {

	public static void main(String[] args) {

		ApplicationForm app = new ApplicationForm();
		app.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}
