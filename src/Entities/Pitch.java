package entities;

import java.util.ArrayList;

import org.joda.time.DateMidnight;
import org.joda.time.LocalDate;

public class Pitch extends Property {

	private String pitchId;
	private int size;
	private boolean waterSupplied;
	private boolean powerSupplied;
	private ArrayList<Reservation> reservations;
	private ArrayList<Task> tasks;
	private PitchGroup group;

	public Pitch() {
		super();
	}

	public Pitch(String pitchId, int size, boolean waterSupplied,
			boolean powerSupplied) {
		super();
		reservations = new ArrayList<Reservation>();
		tasks = new ArrayList<Task>();
		reservations = new ArrayList<Reservation>();
		tasks = new ArrayList<Task>();
		this.pitchId = pitchId;
		this.size = size;
		this.waterSupplied = waterSupplied;
		this.powerSupplied = powerSupplied;
	}

	public String getPitchId() {
		return pitchId;
	}

	public void setWaterSupplied(boolean waterSupplied) {
		this.waterSupplied = waterSupplied;
	}

	public void setPowerSupplied(boolean powerSupplied) {
		this.powerSupplied = powerSupplied;
	}

	public void setPitchId(String id) {
		this.pitchId = id;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public boolean isWaterSupplied() {
		return waterSupplied;
	}

	public void setWaterSupply(boolean waterSupply) {
		this.waterSupplied = waterSupply;
	}

	public boolean isPowerSupplied() {
		return powerSupplied;
	}

	public void setPowerSupply(boolean powerSupply) {
		this.powerSupplied = powerSupply;
	}

	public ArrayList<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(ArrayList<Reservation> reservations) {
		this.reservations = reservations;
	}

	public boolean addReservation(Reservation reservation) {
		return reservations.add(reservation);
	}

	public boolean removeReservations(Reservation reservation) {
		return reservations.remove(reservation);
	}

	/*public Pitch_Status getStatusForPeriode(LocalDate start, LocalDate finsh) {
		int numberDays = 0, numberInService = 0, numberBooked = 0;
		// iterate over all days
		for (LocalDate i = start; !(i.isAfter(finsh)); i = i.plusDays(1)) {
			numberDays++;
			
			// check if the pitch for that day is booked
			for (Reservation reservation : reservations) {
				boolean isInBetween = (reservation.getStartDate().compareTo(i) * i
						.compareTo(reservation.getFinishDate())) >= 0;
				if (isInBetween) {
					numberBooked++;
				}
			}
			// check if the pitch for that day is going to be in service
			for (Task task : tasks) {
				boolean isInBetween = (task.getStartDate().compareTo(i) * i
						.compareTo(task.getFinishDate())) >= 0;
				if (isInBetween) {
					numberInService++;
				}
			}
		}
		if(numberBooked == numberInService && numberBooked == 0){
			return Pitch_Status.Available;
		} else if(numberBooked == numberDays){
			return Pitch_Status.Booked;
		} else if(numberInService == numberDays){
			return Pitch_Status.Service;
		} else{
			return Pitch_Status.NotAvailable;
		}
	}*/
    
    public Pitch_Status getStatusForPeriode (LocalDate startDate, LocalDate finishDate) {
        Pitch_Status status;
        
        for (LocalDate date = startDate; date.isBefore(finishDate); date = date.plusDays(1)) {
            if (status == null) {
                status = getStatusForDate(date);
            } else {
                if (status != getStatusForDate()) {
                    return Pitch_Status.NotAvailable;
                }
            }
        }
        
        return status;
    }
    
    private Pitch_Status getStatusForDate(LocalDate date) {
        // check if the pitch for that day is booked
        for (Reservation reservation : reservations) {
            boolean isInBetween = (reservation.getStartDate().compareTo(date) * date
                                   .compareTo(reservation.getFinishDate())) >= 0;
            if (isInBetween) {
                return Pitch_Status.Booked;
            }
        }
        
        // check if the pitch for that day is going to be in service
        for (Task task : tasks) {
            boolean isInBetween = (task.getStartDate().compareTo(date) * date
                                   .compareTo(task.getFinishDate())) >= 0;
            if (isInBetween) {
                return Pitch_Status.Service;
            }
        }
        
        return Pitch_Status.Available;
    }


	public PitchGroup getGroup() {
		return group;
	}

	public void setGroup(PitchGroup group) {
		this.group = group;
	}

	public float calcPrice(LocalDate startDate, LocalDate finishDate) {
        float price = 0;
        
		for (LocalDate date = startDate; date.isBefore(finishDate); date = date.plusDays(1)) {
            price += calcPrice(date);
        }
        
        return price;
	}
    
    private float calcPrice(LocalDate date) {
        
        float price = group.getPrice();
        
		if (powerSupplied) {
			price += 2.5f;
		}
		if (waterSupplied) {
			price += 2.5f;
		}
		if (isInSeason(date)) {
			price += 2f;
		}
        
		return price;
    }
    
    // Config Klasse!
    private boolean isInSeason (LocalDate date) {
        LocalDate referenceYear = new LocalDate();
		LocalDate seasonStart = new LocalDate(referenceYear.getYear(), 5, 1);
		LocalDate seasonEnd = new LocalDate(referenceYear.getYear(), 9, 15);
                
        return (seasonStart.compareTo(startDate) * startDate
                .compareTo(seasonEnd)) >= 0;
    }

	@Override
	public String toString() {
		return pitchId;
	}

	public ArrayList<Task> getTasks() {
		return tasks;
	}

	public void setTasks(ArrayList<Task> tasks) {
		this.tasks = tasks;
	}

}
