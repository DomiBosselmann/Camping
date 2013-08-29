package model;

import java.util.ArrayList;
import java.util.Observable;

import entities.Area;
import entities.Pitch;
import entities.PitchGroup;

import Util.ApplicationCore;

public class Map_Model extends Observable {

	private ArrayList<Pitch> selectedPitches;
	private int maxX, maxY;
	private Pitch[][] map;

	public Map_Model() {
		super();
		selectedPitches = new ArrayList<Pitch>();
	}

	/**
	 * Calculates the data from the xml file, which describes all the
	 * information of the
	 * 
	 * @param inputStream
	 *            the actual map information
	 */
	public void calcData(byte[] inputStream) {
		// This fake implementation is used, for the
		// purpose of showing just example data
		maxX = 10;
		maxY = 10;
		map = new Pitch[maxY][maxY];


		int counterX = 0, counterY = 0;

		// use break with a jump mark, to avoid a IndexOutOfBoundsException. It
		// might not be the most elegant solution, but fits for this
		// implementation in every case

		outOfTheLoops: 
		for (Area area : ApplicationCore.provider.getAreas()) {
			for (PitchGroup group : area.getGroups()) {
				for (Pitch pitch : group.getPitches()) {
					map[counterX][counterY] = pitch;
					counterX++;
					if (counterX >= maxX) {
						counterX = 0;
						counterY++;
						if (counterY >= maxY) {
							break outOfTheLoops;
						}
					}
				}
			}
		}

		this.setChanged();
	}

	public ArrayList<Pitch> getSelectedPitches() {
		return selectedPitches;
	}

	public int getMaxX() {
		return maxX;
	}

	public int getMaxY() {
		return maxY;
	}

	public Pitch[][] getMap() {
		return map;
	}

	public void delegateSelection(int x, int y) {
		// check if this pitch already has been selected
		if (selectedPitches.contains(map[x][y])) {
			// has to be unselected
			selectedPitches.remove(map[x][y]);
		} else {
			selectedPitches.add(map[x][y]);
		}
		this.setChanged();
	}

}
