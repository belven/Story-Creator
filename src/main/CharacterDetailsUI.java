package main;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
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

	private Label relationshipsLabel;
	private Table relatedCharactersTable;

	public CharacterDetailsUI(Shell shell) {
		// First Name
		firstNameLabel = new Label(shell, SWT.LEFT);
		firstNameLabel.setText("First Name");
		firstNameTextField = new Text(shell, 0);

		// Second Name
		secondNameLabel = new Label(shell, SWT.LEFT);
		secondNameLabel.setText("Second Name");
		secondNameTextField = new Text(shell, 0);

		// Character Relationships
		relationshipsLabel = new Label(shell, SWT.LEFT);
		relationshipsLabel.setText("Relationships");

		relatedCharactersTable = new Table(shell, SWT.CHECK | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		relatedCharactersTable.setHeaderVisible(true);
		String[] titles = { "Character Name", "Relationship" };

		for (int loopIndex = 0; loopIndex < titles.length; loopIndex++) {
			TableColumn column = new TableColumn(relatedCharactersTable, SWT.NULL);
			column.setText(titles[loopIndex]);
		}

		for (int loopIndex = 0; loopIndex < 5; loopIndex++) {
			TableItem item = new TableItem(relatedCharactersTable, SWT.NULL);
			item.setText("Character " + loopIndex);
			item.setText(0, "Character " + loopIndex);
			item.setText(1, "Test");
		}

		for (int loopIndex = 0; loopIndex < titles.length; loopIndex++) {
			relatedCharactersTable.getColumn(loopIndex).pack();
		}

		// Place of Birth
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
