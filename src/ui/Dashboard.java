package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import main.MAIN;

import org.dyno.visual.swing.layouts.Bilateral;
import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;
import org.jdesktop.swingx.JXTaskPane;
import org.jdesktop.swingx.JXTaskPaneContainer;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.skin.DustCoffeeSkin;

import utilities.IconProcess;
import utilities.RegistrationUtilities;
import dao.RoomDAO;

//VS4E -- DO NOT REMOVE THIS LINE!

public class Dashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JSplitPane jSplitePane0;
	private JPanel frequentOption;
	private JMenuItem jMenuItem0;
	private JMenu jMenu0;
	private JMenuBar jMenuBar0;
	private JPanel footer;

	private JXTaskPaneContainer leftMenuContainer;
	public static JTabbedPane mainWindow;
	private JPopupMenu popupMenu = null;

	public Dashboard() {
		initComponents();
		initPopupMenu();
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getFrequentOption(), new Constraints(new Leading(0, 800, 12, 12), new Leading(5, 45, 10, 10)));
		add(getFooter(), new Constraints(new Leading(0, 800, 12, 12), new Leading(530, 45, 10, 10)));
		add(getJSplitePane0(), new Constraints(new Bilateral(0, 12, 199), new Leading(55, 470, 10, 10)));
		setJMenuBar(getJMenuBar0());
		setSize(900, 600);
	}

	private JPopupMenu getPopupMenu() {

		if (popupMenu==null) {

			popupMenu = new JPopupMenu();
			popupMenu.add(refreshButton());

		}

		return popupMenu;
	}

	JButton buttonRefresh = null;
	public JButton refreshButton(){

		if (buttonRefresh==null) {

			buttonRefresh = new JButton("Refresh");
			buttonRefresh.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					studentRegistration.setCollapsed(true);
					serviceRegistration.setCollapsed(true);
				}
			});

		}

		return buttonRefresh;
	}

	private JSplitPane getJSplitePane0() {
		if (jSplitePane0 == null) {
			jSplitePane0 = new JSplitPane();
			jSplitePane0.setDividerLocation(250);
			jSplitePane0.setLeftComponent(getLeftMenu());
			jSplitePane0.setRightComponent(getMainWindow());
		}
		return jSplitePane0;
	}

	private JTabbedPane getMainWindow() {
		if (mainWindow == null) {
			mainWindow = new JTabbedPane();

		}
		return mainWindow;
	}

	private JPanel getFooter() {
		if (footer == null) {
			footer = new JPanel();
			footer.setLayout(new GroupLayout());
		}
		return footer;
	}

	private JMenuBar getJMenuBar0() {
		if (jMenuBar0 == null) {
			jMenuBar0 = new JMenuBar();
			jMenuBar0.add(getJMenu0());
		}
		return jMenuBar0;
	}

	private JMenu getJMenu0() {
		if (jMenu0 == null) {
			jMenu0 = new JMenu();
			jMenu0.setText("File");
			jMenu0.setOpaque(false);
			jMenu0.add(getJMenuItem0());
		}
		return jMenu0;
	}

	private JMenuItem getJMenuItem0() {
		if (jMenuItem0 == null) {
			jMenuItem0 = new JMenuItem();
			jMenuItem0.setText("Exit");
			jMenuItem0.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));

			jMenuItem0.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent event) {
					jMenuItem0ActionActionPerformed(event);
				}
			});
		}
		return jMenuItem0;
	}

	private JPanel getFrequentOption() {
		if (frequentOption == null) {
			frequentOption = new JPanel();
			frequentOption.setLayout(new GroupLayout());
		}
		return frequentOption;
	}

	private JXTaskPaneContainer getLeftMenu() {

		if (leftMenuContainer==null) {

			leftMenuContainer = new JXTaskPaneContainer();
			leftMenuContainer.add(getStudentTaskPane());
			leftMenuContainer.add(getServiceTaskPane());

		}

		return leftMenuContainer;
	}

	private void initPopupMenu() {

		getPopupMenu();

		this.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent e) {
				checkPopup(e);
			}

			public void mouseClicked(MouseEvent e) {
				checkPopup(e);
				System.out.println("EVENT!!!");
			}

			public void mouseReleased(MouseEvent e) {
				checkPopup(e);
			}

			private void checkPopup(MouseEvent e) {
				if (e.isPopupTrigger()) {

					getPopupMenu().show(e.getComponent(), e.getX(), e.getY());
				}
			}

		});

	}

	public boolean processRegistrationChecks() {

		try {

			if (!new RegistrationUtilities().isMendatoryServicesAdded()) {

				processServiceRegistration();
				return false;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

		try {

			Object[] availableRoomNOS = new RoomDAO().availableRoomNOS();

			if (availableRoomNOS==null) {

				processRoomRegistration();
				return false;
			} 

			if (availableRoomNOS.length<1) {

				processRoomRegistration();
				return false;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public void processRoomRegistration() {

		JOptionPane.showMessageDialog(null, "Sorry! No ROOM Available, Please Add ROOMS!");

		if (Dashboard.isNewTab("Add Room")) {

			Dashboard.mainWindow.addTab("Add Room", new RoomForm());

		} else {

			Dashboard.mainWindow.setSelectedIndex(Dashboard.mainWindow.indexOfTab("Add Room"));

		}

	}

	public void processServiceRegistration(){

		JOptionPane.showMessageDialog(null, "Sorry! Services are not Added!");

		if (Dashboard.isNewTab("Mendatory Services")) {

			Dashboard.mainWindow.addTab("Mendatory Services", new MendatoryServicesRegistrationForm());
			System.out.println(Dashboard.mainWindow.indexOfTab("Registration"));

		} else {

			Dashboard.mainWindow.setSelectedIndex(Dashboard.mainWindow.indexOfTab("Mendatory Services"));

		}

	}

	public static boolean isNewTab(String tabTitle) {

		for (int i = 0; i < mainWindow.getTabCount(); i++) {

			if (mainWindow.getTitleAt(i).equals(tabTitle)) {

				return false;

			}

		}

		return true;
	}

	private void jMenuItem0ActionActionPerformed(ActionEvent event) {

		System.exit(ABORT);

	}

	private static void installLnF() {

		final String PREFERRED_LOOK_AND_FEEL = "javax.swing.plaf.metal.MetalLookAndFeel";

		try {
			UIManager.put(SubstanceLookAndFeel.TABBED_PANE_CLOSE_BUTTONS_PROPERTY,Boolean.TRUE);
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
				Dashboard frame = new Dashboard();
				frame.setDefaultCloseOperation(MAIN.EXIT_ON_CLOSE);
				frame.setTitle("Hostel Management System");
				frame.getContentPane().setPreferredSize(frame.getSize());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}

		});
	}

	/*
	 * STUDENT REGISTRATION TASKPANE
	 */
	private JXTaskPane studentRegistration;
	private JXTaskPane getStudentTaskPane() {

		if (studentRegistration==null) {

			ImageIcon iconRegistration = new IconProcess().resizeIcon("/images/Add-Green-Button-icon.png", 30,30);
			studentRegistration = new JXTaskPane("Student",iconRegistration);
			studentRegistration.setCollapsed(true);

			studentRegistration.add(studentRegistration());
			studentRegistration.add(studentSearch());
			studentRegistration.add(studentUpdate());

		}

		return studentRegistration;
	}

	private JButton buttonStudentRegistration;
	public JButton studentRegistration() {

		if (buttonStudentRegistration==null) {

			buttonStudentRegistration = new JButton("Register");

			buttonStudentRegistration.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					openStudentRegistrationTab();
				}

			});

		}

		return buttonStudentRegistration;
	}

	public void openStudentRegistrationTab() {

		if (isNewTab("Registration")) {

			if (processRegistrationChecks()) {

				mainWindow.addTab("Registration", new JScrollPane(new StudentForm()));
				mainWindow.setSelectedIndex(mainWindow.indexOfTab("Registration"));

			}

		} else {

			mainWindow.setSelectedIndex(mainWindow.indexOfTab("Registration"));

		}

	}

	private JButton buttonStudentSearch;
	public JButton studentSearch() {

		if (buttonStudentSearch==null) {

			buttonStudentSearch = new JButton("Search");

			buttonStudentSearch.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					openStudentSearchTab();
				}

			});

		}

		return buttonStudentSearch;
	}

	public void openStudentSearchTab(){

		if (isNewTab("Search")) {

			mainWindow.addTab("Search", new JScrollPane(new SearchStudentForm()));
			mainWindow.setSelectedIndex(mainWindow.indexOfTab("Search"));

		} else {

			mainWindow.setSelectedIndex(mainWindow.indexOfTab("Search"));

		}

	}

	private JButton buttonStudentUpdate;
	public JButton studentUpdate() {

		if (buttonStudentUpdate==null) {

			buttonStudentUpdate = new JButton("Update");

			buttonStudentUpdate.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					openStudentUpdateTab();
				}

			});

		}

		return buttonStudentUpdate;
	}

	public void openStudentUpdateTab(){

		if (isNewTab("Student Update")) {

			mainWindow.addTab("Student Update", new JScrollPane(new UpdateStudentForm()));
			mainWindow.setSelectedIndex(mainWindow.indexOfTab("Student Update"));

		} else {

			mainWindow.setSelectedIndex(mainWindow.indexOfTab("Student Update"));

		}

	}

	/*
	 * SERVICE REGISTRATION TASKPANE
	 */

	private JXTaskPane serviceRegistration;
	private JXTaskPane getServiceTaskPane() {

		if (serviceRegistration==null) {

			ImageIcon iconRegistration = new IconProcess().resizeIcon("/images/Add-Green-Button-icon.png", 30,30);
			serviceRegistration = new JXTaskPane("Service",iconRegistration);
			serviceRegistration.setCollapsed(true);

			serviceRegistration.add(serviceRegistration());
			serviceRegistration.add(studentServiceForm());

		}

		return serviceRegistration;
	}

	private JButton buttonServiceRegistration;
	public JButton serviceRegistration() {

		if (buttonServiceRegistration==null) {

			buttonServiceRegistration = new JButton("Service Registration");
			buttonServiceRegistration.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					openServiceRegistrationTab();
				}

			});

		}

		return buttonServiceRegistration;
	}

	public void openServiceRegistrationTab(){

		if (isNewTab("Service Registration")) {

			mainWindow.addTab("Service Registration", new JScrollPane(new ServiceForm()));
			mainWindow.setSelectedIndex(mainWindow.indexOfTab("Service Registration"));

		} else {

			mainWindow.setSelectedIndex(mainWindow.indexOfTab("Service Registration"));

		}

	}

	private JButton buttonStudentServiceForm;
	public JButton studentServiceForm() {

		if (buttonStudentServiceForm==null) {

			buttonStudentServiceForm = new JButton("Service Selection");
			buttonStudentServiceForm.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					openServiceSelectionTab();
				}

			});

		}

		return buttonStudentServiceForm;
	}

	public void openServiceSelectionTab(){

		if (isNewTab("Service Selection")) {

			mainWindow.addTab("Service Selection", new JScrollPane(new ServiceRegistrationForm()));
			mainWindow.setSelectedIndex(mainWindow.indexOfTab("Service Selection"));

		} else {

			mainWindow.setSelectedIndex(mainWindow.indexOfTab("Service Selection"));

		}

	}

}