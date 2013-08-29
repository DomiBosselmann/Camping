package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;

import model.Map_Model;

import org.joda.time.LocalDate;

import view.MapDetails_View;
import view.Map_View;

public class Map_Ctrl extends JComponent {

	private Map_View mapPanel;
	private MapDetails_View detailsPanel;
	private Map_Model mapModel;

	public Map_Ctrl() {
		super();

		init();
	}

	private void init() {
		this.setLayout(new BorderLayout());

		mapModel = new Map_Model();
		mapModel.calcData(null);

		mapPanel = new Map_View(10, 10);
		detailsPanel = new MapDetails_View();
		
		mapPanel.addListeners(new SelectListener());
		detailsPanel.addBookingListener(new CreateBookingListener());

		mapModel.addObserver(detailsPanel);
		mapModel.addObserver(mapPanel);
		mapModel.notifyObservers();

		this.add(mapPanel, BorderLayout.CENTER);
		this.add(detailsPanel, BorderLayout.EAST);
	}

	class SelectListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String actionCommand = arg0.getActionCommand();
			String[] position = actionCommand.split("-");
			int x = Integer.parseInt(position[0]);
			int y = Integer.parseInt(position[1]);
			mapModel.delegateSelection(x, y);
			mapModel.notifyObservers();

		}

	}

	class CreateBookingListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			LocalDate today = new LocalDate();
			LocalDate tomorrow = new LocalDate().plusDays(1);
			
			new Booking_Ctrl().createNewBookingFromTemplate(mapModel.getSelectedPitches(), today, tomorrow);
		}

	}

}
