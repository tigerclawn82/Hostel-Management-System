package utilities;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

public class Utilities {

	public static boolean isNotEmptyFields(JTextField...jTextFields){

		for (int i = 0; i < jTextFields.length; i++) {

			if (jTextFields[i] instanceof JFormattedTextField) {

				if(jTextFields[i].getText().contains(" ")){

					return false;
				}

			} else {

				if(jTextFields[i].getText().equals("")){

					return false;
				}

			}

		}

		return true;

	}

}
