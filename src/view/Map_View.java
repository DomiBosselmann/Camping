package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.Map_Model;

import org.joda.time.LocalDate;

import entities.Pitch;
import entities.Pitch_Status;


public class Map_View extends JPanel implements Observer {

	private int numberHorizontal, numberVertical;

	private JButton[][] fields;

	public Map_View(int numberHorizontal, int numberVertical) {
		super();
		this.numberHorizontal = numberHorizontal;
		this.numberVertical = numberVertical;
		init();

	}

	private void init() {
		this.setLayout(new GridLayout(numberHorizontal, numberVertical, 0, 0));

		fields = new JButton[numberHorizontal][numberVertical];

		for (int i = 0; i < fields.length; i++) {
			for (int j = 0; j < fields[i].length; j++) {
				fields[i][j] = new JButton();
				fields[i][j].setSize(30, 30);
				this.add(fields[i][j]);
				fields[i][j].setText("");
				fields[i][j].setBackground(Color.LIGHT_GRAY);
			}
		}
	}

	/**
	 * This function has to be called before the first call of the update
	 * function
	 * 
	 * @param al
	 *            the ActionListener, which will be attached to all buttons
	 */
	public void addListeners(ActionListener al) {
		for (int i = 0; i < fields.length; i++) {
			for (int j = 0; j < fields[i].length; j++) {
				fields[i][j].setActionCommand(i + "-" + j);
				fields[i][j].addActionListener(al);
			}
		}
	}

	@Override
	public void update(Observable model, Object arg) {
		Map_Model mapModel = (Map_Model) model;
		LocalDate today = new LocalDate();
		LocalDate tomorrow = new LocalDate().plusDays(1);
		
		Pitch[][] map = mapModel.getMap();
		ArrayList<Pitch> selection = mapModel.getSelectedPitches();

		for (int i = 0; i < fields.length; i++) {
			for (int j = 0; j < fields[i].length; j++) {
				// check if the spot is a pitch
				if (map[i][j] == null) {
					fields[i][j].setBackground(Color.BLACK);
					// remove all ActionListeners
					for (ActionListener al : fields[i][j].getActionListeners()) {
						fields[i][j].removeActionListener(al);
					}
					// check if the pitch is selected
				} else if (selection.contains(map[i][j])) {
					// check the availability
					if (map[i][j].getStatusForPeriode(today, tomorrow).equals(
							Pitch_Status.Available)) {
						// is available
						fields[i][j].setBackground(Color.BLUE);
					} else {
						// is reserved
						fields[i][j].setBackground(Color.RED);
					}
					// so the pitch has to be unselected
				} else {
					// check the availability
					if (map[i][j].getStatusForPeriode(today, tomorrow).equals(
							Pitch_Status.Available)) {
						// is available
						fields[i][j].setBackground(Color.WHITE);
					} else {
						// is reserved
						fields[i][j].setBackground(Color.ORANGE);
					}
				}
			}
		}

	}
}
