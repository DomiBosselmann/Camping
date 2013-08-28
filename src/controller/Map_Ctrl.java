package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.event.ChangeListener;

import view.MapDetails_View;
import view.Map_View;

import model.Map_Model;

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
			System.out
					.println("Later I will call "
							+ "an instance of a booking form and "
							+ "attach the pitches an the "
							+ "date of the booking here");
			//TODO check if all pitches are free
		}

	}

}
