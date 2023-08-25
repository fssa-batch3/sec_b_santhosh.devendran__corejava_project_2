package in.fssa.aviease;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

import org.junit.jupiter.api.Test;

import in.fssa.aviease.exception.ValidationException;
import in.fssa.aviease.model.Flight;
import in.fssa.aviease.service.FlightService;

public class TestCreateFlight {
	
	FlightService flightService=new FlightService();
	
	 public static String generateRandom4DigitString() {
	        Random random = new Random();
	        int randomNumber = random.nextInt(9000) + 1000; // Generate a number between 1000 and 9999
	        return Integer.toString(randomNumber);
	    }

	 @Test
	   public void testCreateFlightWithValidDataInput() {
		 Flight flight=new Flight();
	       
	       flight.setSrc("chennai");
	       flight.setDestination("delhi");
	       flight.setAirlineCode("342");
	       String random4DigitString = generateRandom4DigitString();
	       flight.setFlightNo("a".concat(random4DigitString));
	       flight.setDayId(2);
	       flight.setFlightStatus(true);
	       flight.setFlightTimeString("08:30:00");
	       flight.setNoOfSeats(330);
	       

	        assertDoesNotThrow(() -> {
	        	flightService.createFlight(flight);
	        });
	    }

	    @Test
	    public void testCreateFlightWithInvalidData() {
	        Exception exception = assertThrows(ValidationException.class, () -> {
	        	
	            flightService.createFlight(null);
	        });
	        String expectedMessage = "flight can not be null";
	        String actualMessage = exception.getMessage();
	        assertTrue(expectedMessage.equals(actualMessage));
	    }
	    
	    @Test
	    public void testCreateFlightWithInvalidSrc() {
	        Exception exception = assertThrows(ValidationException.class, () -> {
	        	Flight flight=new Flight();
	 	       
	 	       flight.setSrc("");
	 	       flight.setDestination("delhi");
	 	       flight.setAirlineCode("342");
	 	       flight.setFlightNo("ai76");
	 	       flight.setDayId(2);
	 	       flight.setFlightStatus(true);
	 	       flight.setFlightTimeString("08:30:00");
	 	       flight.setNoOfSeats(330);
	 	       
	 	       flightService.createFlight(flight);
	        });
	        String expectedMessage = "source cannot be Null or Empty";
	        String actualMessage = exception.getMessage();
	        assertTrue(expectedMessage.equals(actualMessage));
	    }
	    
	    @Test
	    public void testCreateFlightWithSrcNull() {
	        Exception exception = assertThrows(ValidationException.class, () -> {
	        	Flight flight=new Flight();
	 	       
	 	       flight.setSrc(null);
	 	       flight.setDestination("delhi");
	 	       flight.setAirlineCode("342");
	 	       flight.setFlightNo("ai76");
	 	       flight.setDayId(2);
	 	       flight.setFlightStatus(true);
	 	       flight.setFlightTimeString("08:30:00");
	 	       flight.setNoOfSeats(330);
	 	       
	 	       flightService.createFlight(flight);
	        });
	        String expectedMessage = "source cannot be Null or Empty";
	        String actualMessage = exception.getMessage();
	        assertTrue(expectedMessage.equals(actualMessage));
	    }
	    
	    @Test
	    public void testCreateFlightWithDesNull() {
	        Exception exception = assertThrows(ValidationException.class, () -> {
	        	Flight flight=new Flight();
	 	       
	 	       flight.setSrc("chennai");
	 	       flight.setDestination(null);
	 	       flight.setAirlineCode("342");
	 	       flight.setFlightNo("ai76");
	 	       flight.setDayId(2);
	 	       flight.setFlightStatus(true);
	 	       flight.setFlightTimeString("08:30:00");
	 	       flight.setNoOfSeats(330);
	 	       
	 	       flightService.createFlight(flight);
	        });
	        String expectedMessage = "destination cannot be Null or Empty";
	        String actualMessage = exception.getMessage();
	        assertTrue(expectedMessage.equals(actualMessage));
	    }
	    
	    @Test
	    public void testCreateFlightWithInvalidDes() {
	        Exception exception = assertThrows(ValidationException.class, () -> {
	        	Flight flight=new Flight();
	 	       
	 	       flight.setSrc("chennai");
	 	       flight.setDestination("");
	 	       flight.setAirlineCode("342");
	 	       flight.setFlightNo("ai76");
	 	       flight.setDayId(2);
	 	       flight.setFlightStatus(true);
	 	       flight.setFlightTimeString("08:30:00");
	 	       flight.setNoOfSeats(330);
	 	       
	 	       flightService.createFlight(flight);
	        });
	        String expectedMessage = "destination cannot be Null or Empty";
	        String actualMessage = exception.getMessage();
	        assertTrue(expectedMessage.equals(actualMessage));
	    }
	    
	    @Test
	    public void testCreateFlightWithAirLineCodeNull() {
	        Exception exception = assertThrows(ValidationException.class, () -> {
	        	Flight flight=new Flight();
	 	       
	 	       flight.setSrc("chennai");
	 	       flight.setDestination("delhi");
	 	       flight.setAirlineCode("");
	 	       flight.setFlightNo("ai76");
	 	       flight.setDayId(2);
	 	       flight.setFlightStatus(true);
	 	       flight.setFlightTimeString("08:30:00");
	 	       flight.setNoOfSeats(330);
	 	       
	 	       flightService.createFlight(flight);
	        });
	        String expectedMessage = "airline code cannot be Null or Empty";
	        String actualMessage = exception.getMessage();
	        assertTrue(expectedMessage.equals(actualMessage));
	    }
	    
	    @Test
	    public void testCreateFlightWithInvalidAirLineCodeNull() {
	        Exception exception = assertThrows(ValidationException.class, () -> {
	        	Flight flight=new Flight();
	 	       
	 	       flight.setSrc("chennai");
	 	       flight.setDestination("delhi");
	 	       flight.setAirlineCode(null);
	 	       flight.setFlightNo("9875");
	 	       flight.setDayId(2);
	 	       flight.setFlightStatus(true);
	 	       flight.setFlightTimeString("08:30:00");
	 	       flight.setNoOfSeats(330);
	 	       
	 	       flightService.createFlight(flight);
	        });
	        String expectedMessage = "airline code cannot be Null or Empty";
	        String actualMessage = exception.getMessage();
	        assertTrue(expectedMessage.equals(actualMessage));
	    }
	    
	    
	    @Test
	    public void testCreateFlightWithFlightNoNull() {
	        Exception exception = assertThrows(ValidationException.class, () -> {
	        	Flight flight=new Flight();
	 	       
	 	       flight.setSrc("chennai");
	 	       flight.setDestination("delhi");
	 	       flight.setAirlineCode("543");
	 	       flight.setFlightNo(null);
	 	       flight.setDayId(2);
	 	       flight.setFlightStatus(true);
	 	       flight.setFlightTimeString("08:30:00");
	 	       flight.setNoOfSeats(330);
	 	       
	 	       flightService.createFlight(flight);
	        });
	        String expectedMessage = "flight number cannot be Null or Empty";
	        String actualMessage = exception.getMessage();
	        assertTrue(expectedMessage.equals(actualMessage));
	    }
	    
	    @Test
	    public void testCreateFlightWithInvalidFlightNoNull() {
	        Exception exception = assertThrows(ValidationException.class, () -> {
	        	Flight flight=new Flight();
	 	       
	 	       flight.setSrc("chennai");
	 	       flight.setDestination("delhi");
	 	       flight.setAirlineCode("676");
	 	       flight.setFlightNo("");
	 	       flight.setDayId(2);
	 	       flight.setFlightStatus(true);
	 	       flight.setFlightTimeString("08:30:00");
	 	       flight.setNoOfSeats(330);
	 	       
	 	       flightService.createFlight(flight);
	        });
	        String expectedMessage = "flight number cannot be Null or Empty";
	        String actualMessage = exception.getMessage();
	        assertTrue(expectedMessage.equals(actualMessage));
	    }
	    
	   


}
