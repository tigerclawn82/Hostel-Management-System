package ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;

import dao.StudentDAO;

//VS4E -- DO NOT REMOVE THIS LINE!
public class DeleteStudentForm extends JPanel {

	private final class UpdateStudentFormExtension extends UpdateStudentForm {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public JButton getJButton4() {
			
			if (jButton4==null) {
				
				jButton4 = new JButton("Delete Record");
				jButton4.addMouseListener(new MouseAdapter() {

					public void mouseClicked(MouseEvent event) {
						
						try {
							
							if (new StudentDAO().deleteStudent(getUpdateStudentForm0())) {
								
								JOptionPane.showMessageDialog(null, "Yeah! Student Deleted!");
								
							} else {
								
								JOptionPane.showMessageDialog(null, "Sorry! Student Not Deleted!");

							}
							
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
						
					}
				});
				
			}
			
			return jButton4;
		}
	}

	private static final long serialVersionUID = 1L;
	private UpdateStudentForm updateStudentForm0;
	public DeleteStudentForm() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getUpdateStudentForm0(), new Constraints(new Leading(0, 600, 10, 10), new Leading(0, 950, 10, 10)));
		setSize(600, 950);
	}

	public UpdateStudentForm getUpdateStudentForm0() {
		if (updateStudentForm0 == null) {
			updateStudentForm0 = new UpdateStudentFormExtension();
		}
		return updateStudentForm0;
	}

}
