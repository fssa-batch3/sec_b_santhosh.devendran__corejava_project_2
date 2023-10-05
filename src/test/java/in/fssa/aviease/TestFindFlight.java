package in.fssa.aviease;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;

import org.junit.jupiter.api.Test;

import in.fssa.aviease.model.Flight;
import in.fssa.aviease.model.FlightEntity;
import in.fssa.aviease.service.FlightService;

public class TestFindFlight {

	FlightService flightService=new FlightService();

	 @Test
	    void testFindAllFlight() {

	        assertDoesNotThrow(() -> {
	        	flightService.findAllFlight();
	        });
	    }
	 
	 @Test
	    void testFindByFlightId() {

	        assertDoesNotThrow(() -> {
	        	flightService.findByFlightId(1);
	        });
	    }
	 
	 @Test
	    void testFindByFlightNo() {

	        assertDoesNotThrow(() -> {
	        	flightService.findByFlightNo("DL101");
	        });
	    }
	 
	 @Test
	    void testFindByAirLineCode() {

	        assertDoesNotThrow(() -> {
	        	flightService.findFlightByAirLineCode("DL");
	        });
	    }
	 
	 @Test
	    void testFindAllFlightBySource() {

	        assertDoesNotThrow(() -> {
	        	flightService.findAllFlightBySource("New York");
	        });
	    }
	 
	 @Test
	    void testFindAllFlightBySourcAndDestination() {

	        assertDoesNotThrow(() -> {
	        	flightService.findAllFlightBySourcAndDestination("New York", "Los Angeles");
	        });
	    }

	 @Test
	    void testfindAllFlightBySourcAndDestinationAndtime() {

	        assertDoesNotThrow(() -> {
	        	flightService.findAllFlightBySourcAndDestinationAndtime("New York", "Los Angeles", "08:00:00");
	        });
	    }

	 
	 @Test
	    void testfindFlightByBinarySearch() {

	        assertDoesNotThrow(() -> {
	        List<Flight> flights=flightService.findAllFlight();
	        
	        FlightEntity.binarySearch(flights, 5);
	        });
	    }

	 
	 
	 
}


