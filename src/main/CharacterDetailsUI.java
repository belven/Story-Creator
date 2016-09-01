package main;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import main.CharacterRelationship.RelationshipTypes;

public class CharacterDetailsUI extends BaseUIComponent {

	private Text firstNameTextField;
	private Label firstNameLabel;

	private Text secondNameTextField;
	private Label secondNameLabel;

	private Label raceLabel;
	private Combo raceCombo;

	private Label birthplaceLabel;
	private Combo birthplaceCombo;

	private Label factionLabel;
	private Combo factionCombo;

	private Label relationshipsLabel;
	private Table relatedCharactersTable;

	public CharacterDetailsUI(Shell shell) {
		owningShell = shell;

		// First Name
		createFirstNameUI();

		// Second Name
		createSecondNameUI();

		// Place of Birth
		createBirthplaceCombo();

		// Race
		createRaceCombo();

		// Faction
		createFactionCombo();

		// Character Relationships
		createRelationshipsTable();

		owningShell.pack();
	}

	public CharacterDetailsUI(Shell shell, CharacterDetails inSelectedDetails) {
		this(shell);
		update();
	}

	private void createFactionCombo() {
		factionLabel = new Label(owningShell, SWT.LEFT);
		factionLabel.setText("Faction");
		factionLabel.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 2, 1));

		factionCombo = new Combo(owningShell, SWT.READ_ONLY);
		factionCombo.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 2, 1));

		for (Faction f : CharacterEditorUI.getFactions()) {
			factionCombo.add(f.getFactionName());
		}

		factionCombo.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				getSelectedDetails().setFaction(factionCombo.getSelectionIndex());
			}

			public void widgetDefaultSelected(SelectionEvent e) {

			}
		});
	}

	private void createRaceCombo() {
		raceLabel = new Label(owningShell, SWT.LEFT);
		raceLabel.setText("Race");
		raceLabel.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 2, 1));

		raceCombo = new Combo(owningShell, SWT.READ_ONLY);
		raceCombo.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 2, 1));

		for (Race r : CharacterEditorUI.getRaces()) {
			raceCombo.add(r.getRaceName());
		}

		raceCombo.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				getSelectedDetails().setRace(raceCombo.getSelectionIndex());
			}

			public void widgetDefaultSelected(SelectionEvent e) {

			}
		});
	}

	private void createBirthplaceCombo() {
		birthplaceLabel = new Label(owningShell, SWT.LEFT);
		birthplaceLabel.setText("Birthplace");

		Button openLocations = new Button(owningShell, SWT.PUSH);
		openLocations.setText("Open Locations");
		openLocations.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new LocationUI(owningShell);
			}
		});

		birthplaceCombo = new Combo(owningShell, SWT.READ_ONLY);
		birthplaceCombo.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 2, 1));

		for (Location l : CharacterEditorUI.getLocations()) {
			birthplaceCombo.add(l.getName());
		}

		birthplaceCombo.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				getSelectedDetails().setPlaceOfBirth(birthplaceCombo.getSelectionIndex());
			}

			public void widgetDefaultSelected(SelectionEvent e) {

			}
		});
	}

	private void createRelationshipsTable() {
		relationshipsLabel = new Label(owningShell, SWT.LEFT);
		relationshipsLabel.setText("Relationships");
		relationshipsLabel.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 2, 1));

		relatedCharactersTable = new Table(owningShell, SWT.CHECK | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		relatedCharactersTable.setHeaderVisible(true);
		relatedCharactersTable.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 2, 1));

		String[] titles = { "Character Name", "Relationship" };

		for (int loopIndex = 0; loopIndex < titles.length; loopIndex++) {
			TableColumn column = new TableColumn(relatedCharactersTable, SWT.NULL);
			column.setText(titles[loopIndex]);
		}

		for (int loopIndex = 0; loopIndex < titles.length; loopIndex++) {
			relatedCharactersTable.getColumn(loopIndex).pack();
		}
	}

	private void createSecondNameUI() {
		secondNameLabel = new Label(owningShell, SWT.FILL);
		secondNameLabel.setText("Second Name");
		secondNameTextField = new Text(owningShell, SWT.FILL);

		secondNameTextField.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				getSelectedDetails().setSecondName(secondNameTextField.getText());
			}

			@Override
			public void focusGained(FocusEvent e) {

			}
		});
	}

	private void createFirstNameUI() {
		firstNameLabel = new Label(owningShell, SWT.FILL);
		firstNameLabel.setText("First Name");
		firstNameTextField = new Text(owningShell, SWT.FILL);

		firstNameTextField.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				getSelectedDetails().setFirstName(firstNameTextField.getText());
			}

			@Override
			public void focusGained(FocusEvent e) {

			}
		});
	}

	private String getCharacterName(CharacterRelationship cr) {
		return CharacterEditorUI.getCharacterAt(cr.getCharacterB()).toString();
	}

	private RelationshipTypes getRelationshipType(CharacterRelationship cr) {
		return CharacterRelationship.RelationshipTypes.values()[cr.getRelationshipType()];
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

	@Override
	public void update() {
		setFirstName(getSelectedDetails().getFirstName());
		setSecondName(getSelectedDetails().getSecondName());

		birthplaceCombo.select(getSelectedDetails().getPlaceOfBirth());
		raceCombo.select(getSelectedDetails().getRace());
		factionCombo.select(getSelectedDetails().getFaction());

		relatedCharactersTable.removeAll();
		relatedCharactersTable.clearAll();

		for (CharacterRelationship cr : getSelectedDetails().getCharacterRelationships()) {
			TableItem item = new TableItem(relatedCharactersTable, SWT.NULL);
			item.setText(0, getCharacterName(cr));
			item.setText(1, getRelationshipType(cr).name());
		}

		for (int i = 0; i < relatedCharactersTable.getColumns().length; i++) {
			relatedCharactersTable.getColumns()[i].pack();
		}

		relatedCharactersTable.redraw();
		relatedCharactersTable.update();

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public void save() {
		// TODO Auto-generated method stub

	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub

	}
}
