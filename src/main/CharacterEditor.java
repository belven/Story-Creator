package main;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class CharacterEditor {
	private ArrayList<CharacterDetails> characters = new ArrayList<>();
	Shell characterShell;
	Combo characterList;

	public CharacterEditor(Display display, Shell shell) {
		characterShell = new Shell(shell);
		characterShell.setLayout(new RowLayout());

		characterList = new Combo(characterShell, SWT.READ_ONLY);
		characterList.setEnabled(true);

		characters.add(new CharacterDetails(characterShell, 0, "Jeff", "Rey"));

		for (int i = 0; i < characters.size(); i++) {
			characterList.add(characters.get(i).toString(), i);
			characterList.setData(characters.get(i).toString(), characters.get(i));
		}

		characterList.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				System.out.println(getSelectedDetails().getFirstName());
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				// System.out.println(characterList.getText());
			}
		});

		characterList.select(0);
		characterShell.pack();
		characterShell.open();
	}

	private CharacterDetails getSelectedDetails() {
		return (CharacterDetails) characterList.getData(characterList.getText());
	}
}
