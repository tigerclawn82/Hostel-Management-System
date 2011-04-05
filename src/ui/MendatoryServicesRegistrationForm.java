package ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import msg.Error;
import msg.Success;

import org.dyno.visual.swing.layouts.Bilateral;
import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;

import utilities.RegistrationUtilities;

import dao.ServiceDAO;

//VS4E -- DO NOT REMOVE THIS LINE!
public class MendatoryServicesRegistrationForm extends JPanel {

	MendatoryServicesForm[] forms = null;

	private static final long serialVersionUID = 1L;
	private JButton jButton0;
	private JPanel jPanel0;
	private JPanel jPanel1;

	public MendatoryServicesRegistrationForm() {

		initComponents();
		String[] serviceTitles = {"Mess","Internet","Gas","Electricity"};
		ArrayList<String> notAddedServices = new ArrayList<String>();
		for (String service : serviceTitles) {

			if (!RegistrationUtilities.serviceAdded(service)) {

				notAddedServices.add(service);

			}

		}

		forms = new MendatoryServicesForm[notAddedServices.size()];

		for (int i = 0; i < notAddedServices.size(); i++) {

			forms[i] = new MendatoryServicesForm(notAddedServices.get(i));

		}

		for (int i = 0; i < forms.length; i++) {
			
			if (i%2==0) {
				
				jPanel0.add(forms[i]);
				
			} else {
				
				jPanel1.add(forms[i]);
				
			}
			
		}

	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getJPanel0(), new Constraints(new Leading(3, 315, 10, 10), new Leading(2, 398, 10, 10)));
		add(getJPanel1(), new Constraints(new Bilateral(315, 12, 0), new Leading(5, 395, 12, 12)));
		add(getJButton0(), new Constraints(new Leading(272, 87, 10, 10), new Leading(412, 12, 12)));
		setSize(640, 450);
	}

	private JButton getJButton0() {
		if (jButton0 == null) {
			jButton0 = new JButton();
			jButton0.setText("Save");
			jButton0.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					jButton0MouseMouseClicked(event);
				}
			});
		}
		return jButton0;
	}

	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jPanel1 = new JPanel();
			jPanel1.setLayout(new BoxLayout(jPanel1, BoxLayout.PAGE_AXIS));
		}
		return jPanel1;
	}

	private JPanel getJPanel0() {
		if (jPanel0 == null) {
			jPanel0 = new JPanel();
			jPanel0.setLayout(new BoxLayout(jPanel0, BoxLayout.PAGE_AXIS));
		}
		return jPanel0;
	}

	private void jButton0MouseMouseClicked(MouseEvent event) {

		boolean success = true;

		try {

			for (int i = 0; i < forms.length; i++) {

				if (new ServiceDAO().registerService(forms[i])) {

					success = true;

				} else {

					success = false;
					break;

				}

			}

			if (success) {

				JOptionPane.showMessageDialog(null, Success.SERVICE_REGSISTRATION_SUCCESS);

			} else {

				JOptionPane.showMessageDialog(null, Error.SERVICE_REGISTRATION_FAILED);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
