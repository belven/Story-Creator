package main;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class CharacterDetails {

	public static int labelColumn = 0;
	public static int valueColumn = 1;

	public int ID = 0;

	private Text firstNameTextField;
	private Text secondNameTextField;

	public CharacterDetails(Shell shell) {
		// Shell shell = new Shell();
		firstNameTextField = new Text(shell, 0);
		secondNameTextField = new Text(shell, 0);

		shell.pack();
		// shell.open();
	}

	public void copy(CharacterDetails cd) {
		this.setFirstName(cd.getFirstName());
		this.setSecondName(cd.getSecondName());
	}

	public CharacterDetails(Shell shell, int inID, String inFirstName, String inSecondName) {
		this(shell);

		ID = inID;
		setFirstName(inFirstName);
		setSecondName(inSecondName);
	}

	@Override
	public String toString() {
		return getFirstName() + " " + getSecondName();
	}

	public String getFirstName() {
		return firstNameTextField.getText();
	}

	public void setFirstName(String firstName) {
		firstNameTextField.setText(firstName);
	}

	public String getSecondName() {
		return secondNameTextField.getText();
	}

	public void setSecondName(String secondName) {
		secondNameTextField.setText(secondName);
	}
}
