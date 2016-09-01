package main;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Shell;

public class CharacterEditorUI {
	private static ArrayList<CharacterDetails> characters = new ArrayList<>();
	private static ArrayList<CharacterRelationship> characterRelationships = new ArrayList<>();
	private static ArrayList<Location> locations = new ArrayList<>();
	private static ArrayList<Faction> factions = new ArrayList<>();
	private static ArrayList<Race> races = new ArrayList<>();

	Shell characterShell;
	public static Combo characterList;
	public static CharacterDetailsUI characterDetailsUI;

	public CharacterEditorUI(Shell shell) {
		getDetailsFromDatabase();

		createShell(shell);

		createCharacterList();
		createCharacterDeatilsUI();

		characterShell.pack();
		characterShell.open();
	}

	public static CharacterDetails getCharacterAt(int index) {
		return characters.get(index);
	}

	public static ArrayList<Race> getRaces() {
		return races;
	}

	public static void setRaces(ArrayList<Race> races) {
		CharacterEditorUI.races = races;
	}

	private void getDetailsFromDatabase() {
		locations.add(new Location(0, "Test Location 1"));
		locations.add(new Location(1, "Test Location 2"));
		locations.add(new Location(2, "Test Location 3"));

		factions.add(new Faction(0, "Faction A"));
		factions.add(new Faction(1, "Faction B"));
		factions.add(new Faction(2, "Faction C"));

		races.add(new Race(0, "Race A"));
		races.add(new Race(1, "Race B"));
		races.add(new Race(2, "Race C"));

		characterRelationships.add(new CharacterRelationship(0, 1, 2, 0));

		characters.add(new CharacterDetails(0, "Jeff", "Rey", 0, 1, 2));
		characters.add(new CharacterDetails(0, "James", "Rey", 2, 1, 0));

		setUpRelationships();
	}

	private void setUpRelationships() {
		for (CharacterDetails cd : characters) {
			for (CharacterRelationship cr : characterRelationships) {
				if (cr.getCharacterA() == cd.getID()) {
					cd.getCharacterRelationships().add(cr);
				}
			}
		}
	}

	private void createCharacterDeatilsUI() {
		characterDetailsUI = new CharacterDetailsUI(characterShell);
		characterDetailsUI.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));

		for (int i = 0; i < characters.size(); i++) {
			characterList.add(characters.get(i).toString(), i);
			characterList.setData(characters.get(i).toString(), characters.get(i));
		}

		characterList.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				characterDetailsUI.update();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				characterDetailsUI.update();
			}
		});

		characterList.select(0);
		characterDetailsUI.update();
	}

	private void createCharacterList() {
		characterList = new Combo(characterShell, SWT.READ_ONLY);
		characterList.setEnabled(true);
		characterList.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 2, 1));
	}

	private void createShell(Shell shell) {
		characterShell = new Shell(shell);
		characterShell.setLayout(new GridLayout(2, true));
		characterShell.setLayoutData(new RowData(50, 50));
		characterShell.setText("Character Details");
	}

	public static CharacterDetails getSelectedDetails() {
		return (CharacterDetails) characterList.getData(characterList.getText());
	}

	public static ArrayList<CharacterRelationship> getCharacterRelationships() {
		return characterRelationships;
	}

	public static void setCharacterRelationships(ArrayList<CharacterRelationship> inCharacterRelationships) {
		characterRelationships = inCharacterRelationships;
	}

	public static ArrayList<Location> getLocations() {
		return locations;
	}

	public static void setLocations(ArrayList<Location> inLocations) {
		locations = inLocations;
	}

	public static ArrayList<Faction> getFactions() {
		return factions;
	}

	public static void setFactions(ArrayList<Faction> factions) {
		CharacterEditorUI.factions = factions;
	}
}
