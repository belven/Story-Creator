package main;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class CharacterEditor {
	private ArrayList<CharacterDetails> characters = new ArrayList<>();
	Shell characterShell;
	Combo characterList;
	CharacterDetailsUI characterDetailsUI;

	public CharacterEditor(Display display, Shell shell) {
		characterShell = new Shell(shell);
		characterShell.setLayout(new GridLayout(2, true));
		characterShell.setLayoutData(new RowData(50, 50));

		characterList = new Combo(characterShell, SWT.READ_ONLY);
		characterList.setEnabled(true);
		characterList.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 2, 1));

		characterDetailsUI = new CharacterDetailsUI(characterShell);
		characterDetailsUI.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));

		characters.add(new CharacterDetails(0, "Jeff", "Rey"));

		for (int i = 0; i < characters.size(); i++) {
			characterList.add(characters.get(i).toString(), i);
			characterList.setData(characters.get(i).toString(), characters.get(i));
		}

		characterList.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				characterDetailsUI.update(getSelectedDetails());
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				characterDetailsUI.update(getSelectedDetails());
			}
		});

		characterList.select(0);
		characterDetailsUI.update(getSelectedDetails());

		characterShell.pack();
		characterShell.open();
	}

	private CharacterDetails getSelectedDetails() {
		return (CharacterDetails) characterList.getData(characterList.getText());
	}
}
