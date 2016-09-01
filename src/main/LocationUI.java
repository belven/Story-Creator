package main;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class LocationUI {
	final public static int labelColumn = 0;
	final public static int valueColumn = 1;

	Shell owningShell;

	public Location selectedLocation;

	private Text locationNameTextField;
	private Label locationNameLabel;

	private Text locationDescriptionTextField;
	private Label locationDescriptionLabel;

	private Label locationsLabel;
	private Combo locationsCombo;

	public LocationUI(Shell shell) {
		createShell(shell);

		createLocationsCombo();
		createLocationNameUI();
		createLocationDescriptionUI();

		if (CharacterDetailsUI.getSelectedDetails() != null) {
			update(CharacterEditorUI.getLocations().get(CharacterDetailsUI.getSelectedDetails().getPlaceOfBirth()));
		}

		owningShell.pack();
		owningShell.open();
	}

	private void createShell(Shell shell) {
		owningShell = new Shell(shell);
		owningShell.setLayout(new GridLayout(2, true));
		owningShell.setLayoutData(new RowData(50, 50));
		owningShell.setText("Locations Details");
	}

	private void createLocationNameUI() {
		locationNameLabel = new Label(owningShell, SWT.FILL);
		locationNameLabel.setText("Location Name");
		locationNameTextField = new Text(owningShell, SWT.FILL);

		locationNameTextField.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				selectedLocation.setName(locationNameTextField.getText());
			}

			@Override
			public void focusGained(FocusEvent e) {

			}
		});
	}

	private void createLocationDescriptionUI() {
		locationDescriptionLabel = new Label(owningShell, SWT.FILL);
		locationDescriptionLabel.setText("Location Description");
		locationDescriptionTextField = new Text(owningShell, SWT.FILL);

		locationDescriptionTextField.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				selectedLocation.setName(locationDescriptionTextField.getText());
			}

			@Override
			public void focusGained(FocusEvent e) {

			}
		});
	}

	public LocationUI(Shell shell, Location inSelectedLocation) {
		this(shell);
		selectedLocation = inSelectedLocation;
		update(selectedLocation);
	}

	void update(Location selectedLocation) {
		this.selectedLocation = selectedLocation;

		setLocationName(selectedLocation.getName());
		setLocationDescription(selectedLocation.getDescription());

		locationsCombo.select(selectedLocation.getID());
	}

	private void setLocationDescription(String description) {
		locationDescriptionTextField.setText(description);
	}

	private void setLocationName(String name) {
		locationNameTextField.setText(name);
	}

	private void createLocationsCombo() {
		locationsLabel = new Label(owningShell, SWT.LEFT);
		locationsLabel.setText("Locations");
		locationsLabel.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 2, 1));

		locationsCombo = new Combo(owningShell, SWT.READ_ONLY);
		locationsCombo.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 2, 1));

		for (Location l : CharacterEditorUI.getLocations()) {
			locationsCombo.add(l.getName());
		}

		locationsCombo.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				update(CharacterEditorUI.getLocations().get(locationsCombo.getSelectionIndex()));
			}

			public void widgetDefaultSelected(SelectionEvent e) {

			}
		});
	}

	@Override
	public String toString() {
		return getLocationName();
	}

	private String getLocationName() {
		return locationNameTextField.getText();
	}

}
