package in.fssa.aviease.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TicketsEntity implements Comparable<TicketsEntity>{

	private int id;
	private int UserId;
	private int FlightId;
	private int priceId;
	private LocalDateTime booked;

	
	public LocalDateTime getBooked() {
		return booked;
	}



	public void setBooked(LocalDateTime booked) {
		this.booked = booked;
	}



	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}


	private LocalDate travelDate;
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getUserId() {
		return UserId;
	}



	public void setUserId(int userId) {
		UserId = userId;
	}



	public int getFlightId() {
		return FlightId;
	}



	public void setFlightId(int flightId) {
		FlightId = flightId;
	}



	public int getPriceId() {
		return priceId;
	}



	public void setPriceId(int priceId) {
		this.priceId = priceId;
	}



	public LocalDate getTravelDate() {
		return travelDate;
	}



	public void setTravelDate(String travelDate) {
		
		String formatPattern = "yyyy-MM-dd"; // Format pattern to match your input

	      DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatPattern);
	      LocalDate date = LocalDate.parse(travelDate, formatter);
		this.travelDate = date;
	}


	@Override
	public int compareTo(TicketsEntity o) {
		if (this.getId() == o.getId()) {
			return 0;
		} else {
			if (this.getId() < (o.getId())) {
				return -1;
			} else {
				return 1;
			}
		}
	}
}
