package main;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class CharacterDetails extends JPanel {
	private static final long serialVersionUID = 1L;

	public String firstName = "Test";
	public String secondName = "Name";

	JTextField firstNameTextField = new JTextField(firstName);
	JTextField secondNameTextField = new JTextField(secondName);

	public CharacterDetails() {
		add(firstNameTextField);
		add(secondNameTextField);
	}
	
	public void copy(CharacterDetails cd) {
		this.firstName = cd.firstName;
		this.secondName = cd.secondName;
	}

	public CharacterDetails(String inFirstName, String inSecondName) {
		this();
		firstName = inFirstName;
		secondName = inSecondName;

		firstNameTextField.setText(firstName);
		secondNameTextField.setText(secondName);

		firstNameTextField.repaint();
		secondNameTextField.repaint();
		firstNameTextField.validate();
		secondNameTextField.validate();
	}

	@Override
	public String toString() {
		return firstName + " " + secondName;
	}
}