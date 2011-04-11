package utilities;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class JTextFieldFilter extends PlainDocument {

	private static final long serialVersionUID = 1L;


	protected String acceptedChars = null;
	protected boolean negativeAccepted = false;

	public static JTextFieldFilter filter(String filter) {

		return new JTextFieldFilter(filter);
	}

	public static JTextFieldFilter filter(String... filters) {

		String allFilters = new String();

		for (String filter : filters) {

			allFilters +=filter;

		}

		return new JTextFieldFilter(allFilters);
	}

	public JTextFieldFilter() {

		this(FILTERS.ALPHA_SPACE);

	}

	public JTextFieldFilter(String acceptedchars) {
		acceptedChars = acceptedchars;
	}

	public void setNegativeAccepted(boolean negativeaccepted) {
		if (acceptedChars.equals(FILTERS.ALPHA_SPACE)) {
			negativeAccepted = negativeaccepted;
			acceptedChars += "-";
		}
	}

	public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
		if (str == null)
			return;
		for (int i = 0; i < str.length(); i++) {
			if (acceptedChars.indexOf(String.valueOf(str.charAt(i))) == -1)
				return;
		}

		if (negativeAccepted) {
			if (str.indexOf(".") != -1) {
				if (getText(0, getLength()).indexOf(".") != -1) {
					return;
				}
			}
		}

		if (negativeAccepted && str.indexOf("-") != -1) {
			if (str.indexOf("-") != 0 || offset != 0) {
				return;
			}
		}

		super.insertString(offset, str, attr);
	}
}