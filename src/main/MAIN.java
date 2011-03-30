package main;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.dyno.visual.swing.layouts.GroupLayout;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.skin.DustCoffeeSkin;

import ui.BillingRecordForm;
import ui.FineRecordForm;
import ui.LoginForm;
import ui.MendatoryServicesRegistrationForm;
import ui.MessRecordForm;
import ui.RoomForm;
import ui.SearchStudentForm;
import ui.ServiceForm;
import ui.ServiceRegistrationForm;
import ui.StudentForm;
import ui.UpdateStudentForm;

//VS4E -- DO NOT REMOVE THIS LINE!
public class MAIN extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final String PREFERRED_LOOK_AND_FEEL = null;

	public MAIN() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		setSize(600, 400);
	}

	private static void installLnF() {
		try {
			String lnfClassname = PREFERRED_LOOK_AND_FEEL;
			if (lnfClassname == null)
				lnfClassname = UIManager.getCrossPlatformLookAndFeelClassName();
			UIManager.setLookAndFeel(lnfClassname);
		} catch (Exception e) {
			System.err.println("Cannot install " + PREFERRED_LOOK_AND_FEEL
					+ " on this platform:" + e.getMessage());
		}
	}

	/**
	 * Main entry of the class.
	 * Note: This class is only created so that you can easily preview the result at runtime.
	 * It is not expected to be managed by the designer.
	 * You can modify it as you like.
	 */
	public static void main(String[] args) {
		installLnF();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				
				SubstanceLookAndFeel.setSkin(new DustCoffeeSkin());
				
				MAIN frame = new MAIN();
				frame.setDefaultCloseOperation(MAIN.EXIT_ON_CLOSE);
				frame.setTitle("MAIN");
				frame.setContentPane(new JScrollPane(new ServiceRegistrationForm()));
				frame.getContentPane().setPreferredSize(frame.getSize());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}

}
