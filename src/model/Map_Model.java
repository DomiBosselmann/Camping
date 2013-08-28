package model;

import java.util.ArrayList;
import java.util.Observable;

import Entities.Area;
import Entities.Pitch;
import Entities.PitchGroup;
import Entities.Reservation;

public class Map_Model extends Observable{

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

		/*
		 * Insert fake data here
		 */
		
		Area area1 = new Area("Area 1");
		Area area2 = new Area("Area 2");
		PitchGroup group1 = new PitchGroup("Tent", 7.5f);
		group1.setArea(area1);
		PitchGroup group2 = new PitchGroup("Trailer", 10.5f);
		group2.setArea(area2);
		
		
		
		map[1][1] = new Pitch("A52",5, true, true);
		map[1][1].setGroup(group1);
		map[2][2] = new Pitch("A52",8, false, true);
		map[2][2].setGroup(group1);
		map[3][3] = new Pitch("A42",3, true, true);
		map[3][3].setGroup(group2);
		map[4][4] = new Pitch("A5s2",7, true, false);
		map[4][4].setGroup(group1);
		map[5][5] = new Pitch("BA52",8, false, false);
		map[5][5].setGroup(group2);
		map[5][3] = new Pitch("B52",3, true, true);
		map[5][3].setGroup(group2);
		map[5][4] = new Pitch("A32",10, false, true);
		map[5][4].setGroup(group1);
		map[5][4].setReservation(new Reservation());
		
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
	
	public void delegateSelection(int x, int y){
		//check if this pitch already has been selected
		if(selectedPitches.contains(map[x][y])){
			//has to be unselected
			selectedPitches.remove(map[x][y]);
		} else {
			selectedPitches.add(map[x][y]);
		}
		this.setChanged();
	}

}
