package main;

import javax.swing.SwingUtilities;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Startup implements Runnable {

	@Override
	public void run() {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new RowLayout());

		Button openCharacters = new Button(shell, SWT.PUSH);
		openCharacters.setText("Open Character Editor");
		openCharacters.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new CharacterEditor(display, shell);
			}
		});

		shell.pack();
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		display.dispose();
	};

	public static void main(String[] args) {
		Startup se = new Startup();
		SwingUtilities.invokeLater(se);
	}
}