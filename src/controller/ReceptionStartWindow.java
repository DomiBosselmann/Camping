package controller;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;


public class ReceptionStartWindow extends JFrame {

	public ReceptionStartWindow(){
		super("Startseite Empfangspersonal");
		init();
		// Display the window.
		this.pack();
		this.setVisible(true);
	}

	private void init() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		MenuBar  menubar = new MenuBar();


		// Set up the tabbed pane
		ReceptionTabbedPane tabbedPane = new ReceptionTabbedPane();


		// fill the layout of the window
		this.setJMenuBar(menubar);
		this.add(tabbedPane, BorderLayout.CENTER);

		

	}
	
}
