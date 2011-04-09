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

	public static boolean invalidCharacters(JTextField...jTextField){

		String[] invalidCharacters = {"|",":","!","@","#","$","%","^","&","*","(",")"};

		for (int i = 0; i < jTextField.length; i++) {
			
			for (int j = 0; j < invalidCharacters.length; j++) {

				if(jTextField[i].getText().contains(invalidCharacters[j])){

					return false;
				}
			}
		}

		return true;
	}
	

	public static boolean checkCharacters(JTextField...jTextFields){

		for (int i = 0; i < jTextFields.length; i++) {

			for (int j = 0; j < 26; j++) {

				char character = (char)('A'+j);

				if (jTextFields[i].getText().toUpperCase().contains(String.valueOf(character))) {

					return false;

				}
			}

		}

		return true;
	}
	

}
