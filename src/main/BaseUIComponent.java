package main;

import org.eclipse.swt.widgets.Shell;

public abstract class BaseUIComponent {
	protected Shell owningShell;

	public abstract void update();

	public abstract void clear();

	public abstract void save();

	public abstract void reset();

	public static Character getSelectedDetails() {
		return CharacterEditorUI.getSelectedDetails();
	}

}
