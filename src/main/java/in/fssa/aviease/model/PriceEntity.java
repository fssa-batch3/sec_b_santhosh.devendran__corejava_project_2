package in.fssa.aviease.model;


import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class PriceEntity implements Comparable<PriceEntity>{
	
	private int id;
	private LocalDate startDate;
	private LocalDate  endDate;
	private String flightId;
	private Double price;
	
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public LocalDate getStartDate() {
		return startDate;
	}



	public void setStartDate(String startDate){
		
	
		  String formatPattern = "yyyy-MM-dd"; // Format pattern to match your input

	      DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatPattern);
	      LocalDate date = LocalDate.parse(startDate, formatter);
		
	      this.startDate = date;
	}

	public void setStartDateFormat(LocalDate startDate){
	
	      this.startDate = startDate;
	}
	
	public void setEndDateFormat(LocalDate endDate) {
		
		
		this.endDate = endDate;
	}


	public LocalDate getEndDate() {
		return endDate;
	}



	public void setEndDate(String endDate) {
		
		  String formatPattern = "yyyy-MM-dd"; // Format pattern to match your input

	      DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatPattern);
	      LocalDate date = LocalDate.parse(endDate, formatter);
		
		this.endDate = date;
	}



	public String getFlightId() {
		return flightId;
	}



	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}



	public Double getPrice() {
		return price;
	}



	public void setPrice(Double price) {
		this.price = price;
	}



	@Override
	public int compareTo(PriceEntity o) {
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
