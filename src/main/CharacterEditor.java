package main;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class CharacterEditor extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	private JComboBox<CharacterDetails> characters;
	private CharacterDetails selectedCharacter = new CharacterDetails();

	public CharacterEditor() {
		super("Characters");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		add(characters = createCharacterList());
		add(selectedCharacter);
		
		characters.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if (arg0.getStateChange() == ItemEvent.SELECTED) {
					selectedCharacter.copy((CharacterDetails) characters.getSelectedItem());
				}
			}
		});

		pack();
		setVisible(true);
		setSize(400, 400);
	}

	private JComboBox<CharacterDetails> createCharacterList() {
		return new JComboBox<CharacterDetails>(new CharacterDetails[] { new CharacterDetails("Jeff", "Rey"), new CharacterDetails("Jeff", "Rey") });
	}
}
