package in.fssa.aviease;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

import in.fssa.aviease.service.TicketsService;

public class TestFindTickets {

	TicketsService ticketService=new TicketsService();
	
	 @Test
	    void testFindAllTickets() {

	        assertDoesNotThrow(() -> {
	        	ticketService.findAll();
	        });
	    }
	 
	 @Test
	    void testFindTicketById() {

	        assertDoesNotThrow(() -> {
	        	ticketService.findById(1);
	        });
	    }
	 
	 @Test
	    void testFindTicketByUserId() {

	        assertDoesNotThrow(() -> {
	        	ticketService.findByUserId(1);
	        });
	    }
	 
	 @Test
	    void testFindTicketByTravelDate() {
		 
		 String dateString = "2023-09-23";
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        LocalDate localDate = LocalDate.parse(dateString, formatter);
	        assertDoesNotThrow(() -> {
	        	
	        	ticketService.findByTravelDate(localDate);
	        });
	    }
	 
	 @Test
	    void testFindTicketByFlightId() {

	        assertDoesNotThrow(() -> {
	        	ticketService.findByFlightId(135);
	        });
	    }
	 
	 
	 @Test
	    void testFindTicketByFlightIdTravelDate() {
		 String dateString = "2023-09-23";
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        LocalDate localDate = LocalDate.parse(dateString, formatter);

	        assertDoesNotThrow(() -> {
	        	ticketService.findByFlightIdTravelDate(135, localDate);
	        });
	    }
	 
	 
	 @Test
	    void testFindSeatByFlightIdTravelDate() {

		 String dateString = "2023-09-23";
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        LocalDate localDate = LocalDate.parse(dateString, formatter);
	        assertDoesNotThrow(() -> {
	        	ticketService.findSeatByFlightIdTravelDate(135, localDate);
	        });
	    }
	 
}
