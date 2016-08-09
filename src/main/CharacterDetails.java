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
		firstNameTextField.setText(firstName);
		firstNameTextField.setText(secondName);
		update();
	}
	
	public void update() {
		validate();
		repaint();
	}

	public CharacterDetails(String inFirstName, String inSecondName) {
		this();
		firstName = inFirstName;
		secondName = inSecondName;

		firstNameTextField.setText(firstName);
		secondNameTextField.setText(secondName);
		update();
	}

	@Override
	public String toString() {
		return firstName + " " + secondName;
	}
}
