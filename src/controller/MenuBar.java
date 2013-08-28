package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import controller.Guest_Ctrl;


public class MenuBar extends JMenuBar {

	public MenuBar() {
		super();
		init();
	}

	private void init() {
		JMenu formatMenu;
		JMenuItem menuItem;

		formatMenu = new JMenu("Neues Objekt anlegen");
		formatMenu.setMnemonic(KeyEvent.VK_N);
		menuItem = new JMenuItem("Gast");
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Guest_Ctrl().createNewGuest();
			}
		});
		menuItem.setMnemonic(KeyEvent.VK_G);
		formatMenu.add(menuItem);
		menuItem = new JMenuItem("Angesteller");
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Employee_Ctrl().createNewEmployee();
			}
		});
		menuItem.setMnemonic(KeyEvent.VK_A);
		formatMenu.add(menuItem);
		menuItem = new JMenuItem("Buchung");
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Booking_Ctrl().createNewBooking();
			}
		});
		menuItem.setMnemonic(KeyEvent.VK_B);
		formatMenu.add(menuItem);
		menuItem = new JMenuItem("Chipkarte");
		menuItem.addActionListener(new functionNotAvailableListener());
		menuItem.setMnemonic(KeyEvent.VK_C);
		formatMenu.add(menuItem);
		menuItem = new JMenuItem("Rechnung");
		menuItem.addActionListener(new functionNotAvailableListener());
		menuItem.setMnemonic(KeyEvent.VK_R);
		formatMenu.add(menuItem);
		menuItem = new JMenuItem("Reservierung");
		menuItem.addActionListener(new functionNotAvailableListener());
		menuItem.setMnemonic(KeyEvent.VK_S);
		formatMenu.add(menuItem);
		menuItem = new JMenuItem("Aufgabe");
		menuItem.setMnemonic(KeyEvent.VK_F);
		menuItem.addActionListener(new functionNotAvailableListener());
		formatMenu.add(menuItem);
		menuItem = new JMenuItem("Anlage");
		menuItem.setMnemonic(KeyEvent.VK_L);
		menuItem.addActionListener(new functionNotAvailableListener());
		formatMenu.add(menuItem);
		this.add(formatMenu);

		formatMenu = new JMenu("Drucken");
		formatMenu.setMnemonic(KeyEvent.VK_D);
		menuItem.addActionListener(new functionNotAvailableListener());
		this.add(formatMenu);

		formatMenu = new JMenu("Import");
		formatMenu.setMnemonic(KeyEvent.VK_I);
		menuItem.addActionListener(new functionNotAvailableListener());
		this.add(formatMenu);

		formatMenu = new JMenu("Export");
		formatMenu.setMnemonic(KeyEvent.VK_E);
		menuItem.addActionListener(new functionNotAvailableListener());
		this.add(formatMenu);

		formatMenu = new JMenu("Einstellungen");
		formatMenu.setMnemonic(KeyEvent.VK_G);
		menuItem.addActionListener(new functionNotAvailableListener());
		this.add(formatMenu);

		formatMenu = new JMenu("Suchen nach");
		formatMenu.setMnemonic(KeyEvent.VK_S);
		menuItem = new JMenuItem("Gast");
		menuItem.setMnemonic(KeyEvent.VK_G);
		menuItem.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Search with JOptionPane und dropdown von entities");
			}	
		});
		formatMenu.add(menuItem);
		menuItem = new JMenuItem("Angesteller");
		menuItem.setMnemonic(KeyEvent.VK_A);
		menuItem.addActionListener(new functionNotAvailableListener());
		formatMenu.add(menuItem);
		menuItem = new JMenuItem("Buchung");
		menuItem.setMnemonic(KeyEvent.VK_B);
		menuItem.addActionListener(new functionNotAvailableListener());
		formatMenu.add(menuItem);
		menuItem = new JMenuItem("Chipkarte");
		menuItem.setMnemonic(KeyEvent.VK_C);
		menuItem.addActionListener(new functionNotAvailableListener());
		formatMenu.add(menuItem);
		menuItem = new JMenuItem("Rechnung");
		menuItem.setMnemonic(KeyEvent.VK_R);
		menuItem.addActionListener(new functionNotAvailableListener());
		formatMenu.add(menuItem);
		menuItem = new JMenuItem("Reservierung");
		menuItem.setMnemonic(KeyEvent.VK_S);
		menuItem.addActionListener(new functionNotAvailableListener());
		formatMenu.add(menuItem);
		menuItem = new JMenuItem("Aufgabe");
		menuItem.setMnemonic(KeyEvent.VK_F);
		menuItem.addActionListener(new functionNotAvailableListener());
		formatMenu.add(menuItem);
		this.add(formatMenu);
	}

	class functionNotAvailableListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane
					.showMessageDialog(
							MenuBar.this,
							"Diese Funktion wurde in der aktuellen Version \n"
									+ "dieses Projekt leider noch nicht implementiert. \n"
									+ "Bei Rückfragen melden Sie sich bitte bei den \n"
									+ "Entwicklern Marius Obert und Dominique Bosselmann.",
							"Implementierungsende", JOptionPane.WARNING_MESSAGE);
		}
	}

}
