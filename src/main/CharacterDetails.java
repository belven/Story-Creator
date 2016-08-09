package main;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class CharacterDetails extends JPanel {
	private static final long serialVersionUID = 1L;

	public static int labelColumn = 0;
	public static int valueColumn = 1;
	
	public int ID = 0;
	public String firstName = "Test";
	public String secondName = "Name";

	JTextField firstNameTextField = new JTextField(firstName);
	JTextField secondNameTextField = new JTextField(secondName);

	public CharacterDetails() {
		GridBagConstraints constraints = new GridBagConsteraints();
		setLayout(new GridBagLayout();
		
		constraints.gridx = labelColumn;
		constraints.gridy = 0;
		constraints.weightx = 0.5;
		constraints.anchor = GridBagConstraints.WEST;
		
		add(new JLabel("First Name"), constraints);
		
		constraints.gridx = valueColumn;
		add(firstNameTextField, constraints);
		
		constraints.gridy++;
		constraints.gridx = labelColumn;
		add(new JLabel("Second Name"), constraints);
		
		constraints.gridx = valueColumn;
		add(secondNameTextField, constraints);
		
		constraints.gridx = labelColumn;
		constraints.gridy++;
		add(JSeperator(), constraints);
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

	public CharacterDetails(int inID, String inFirstName, String inSecondName) {
		this();
		
		ID = inID;
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
