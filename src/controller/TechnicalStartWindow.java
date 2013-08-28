package controller;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;


public class TechnicalStartWindow extends JFrame {

	public TechnicalStartWindow(){
		super("Startseite Technischer Angestellter");
		init();
		// Display the window.
		this.pack();
		this.setVisible(true);
	}

	private void init() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		MenuBar  menubar = new MenuBar();


		// Set up the details panel 
		Task_Ctrl aufgabenPanel = new Task_Ctrl();

		// fill the layout of the window
		this.setJMenuBar(menubar);
		this.add(aufgabenPanel, BorderLayout.CENTER);

		

	}
	
}
