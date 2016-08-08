package main;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Startup implements Runnable {

	@Override
	public void run() {
		JFrame frame = new JFrame("test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		JButton jButton = new JButton("Open Character Editor");
		jButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CharacterEditor();
			}
		});

		frame.add(jButton);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(400, 400);
	};

	public static void main(String[] args) {
		Startup se = new Startup();
		// Schedules the application to be run at the correct time in the event
		// queue.
		SwingUtilities.invokeLater(se);
	}
}