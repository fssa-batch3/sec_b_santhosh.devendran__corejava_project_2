package in.fssa.aviease.model;

import java.sql.Time;
import java.util.List;

public class Flight extends FlightEntity{
	
    
	public Flight(int id,String src,String destination,String airLinecode,String flightNo,int dayId,boolean flightStatus,Time flighttime,int noOfSeats,double price) {
		
		super.setId(id);
		super.setSrc(src);
		super.setDestination(destination);
		super.setAirlineCode(airLinecode);
		super.setFlightNo(flightNo);
		super.setFlightNo(flightNo);
		super.setDayId(dayId);
		super.setFlightStatus(flightStatus);
		super.setFlightTime(flighttime);
		super.setNoOfSeats(noOfSeats);
		super.setPrice(price);
		
		
	}

	public Flight() {
		
	}

	
	


	

}
