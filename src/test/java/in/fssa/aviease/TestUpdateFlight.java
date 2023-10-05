package in.fssa.aviease;

import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import in.fssa.aviease.exception.ValidationException;
import in.fssa.aviease.model.Flight;
import in.fssa.aviease.service.FlightService;

public class TestUpdateFlight {

	FlightService flightService=new FlightService();
	 @Test
	     void testCreateFlightWithInvalidid() {
	        Exception exception = assertThrows(ValidationException.class, () -> {
	        	Flight flight=new Flight();
	 	       
	 	       flight.setSrc("chennai");
	 	       flight.setDestination("delhi");
	 	       flight.setAirlineCode("342");
	 	       flight.setFlightNo("ai76");
	 	       flight.setDayId(2);
	 	       flight.setFlightStatus(true);
	 	       flight.setFlightTimeString("08:30:00");
	 	       flight.setPrice(299.00);
	 	       flight.setNoOfSeats(330);
	 	       
	 	      flightService.updateFlight(398,flight);
	        });
	        String expectedMessage = "flight already not exist";
	        String actualMessage = exception.getMessage();
	        assertTrue(expectedMessage.equals(actualMessage));
	    }
	    
}

