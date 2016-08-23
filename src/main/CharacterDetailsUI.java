package main;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class CharacterDetailsUI {

	public static int labelColumn = 0;
	public static int valueColumn = 1;

	public int ID = 0;

	private Text firstNameTextField;
	private Label firstNameLabel;

	private Text secondNameTextField;
	private Label secondNameLabel;

	private Label birthplaceLabel;
	private Combo birthplaceCombo;

	public CharacterDetailsUI(Shell shell) {
		firstNameLabel = new Label(shell, SWT.LEFT);
		firstNameLabel.setText("First Name");
		firstNameTextField = new Text(shell, 0);

		secondNameLabel = new Label(shell, SWT.LEFT);
		secondNameLabel.setText("Second Name");
		secondNameTextField = new Text(shell, 0);

		birthplaceLabel = new Label(shell, SWT.LEFT);
		birthplaceLabel.setText("Birthplace");
		birthplaceLabel.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 2, 1));

		birthplaceCombo = new Combo(shell, SWT.READ_ONLY);
		birthplaceCombo.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 2, 1));
		birthplaceCombo.add("Test Place 1");
		birthplaceCombo.select(0);

		shell.pack();
	}

	public void copy(CharacterDetailsUI cd) {
		this.setFirstName(cd.getFirstName());
		this.setSecondName(cd.getSecondName());
	}

	public CharacterDetailsUI(Shell shell, int inID, String inFirstName, String inSecondName) {
		this(shell);

		ID = inID;
		setFirstName(inFirstName);
		setSecondName(inSecondName);
	}

	public CharacterDetailsUI(Shell shell, CharacterDetails selectedDetails) {
		this(shell);

		update(selectedDetails);
	}

	void update(CharacterDetails selectedDetails) {
		ID = selectedDetails.getID();
		setFirstName(selectedDetails.getFirstName());
		setSecondName(selectedDetails.getSecondName());
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

	public void setLayoutData(GridData gridData) {
		// TODO Auto-generated method stub

	}
}
