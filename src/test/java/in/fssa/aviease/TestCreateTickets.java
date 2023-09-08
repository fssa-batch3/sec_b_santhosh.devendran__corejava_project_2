package in.fssa.aviease;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

import in.fssa.aviease.exception.ValidationException;
import in.fssa.aviease.model.Tickets;
import in.fssa.aviease.service.TicketsService;

public class TestCreateTickets {
	
	 @Test
	     void testCreateTicketWithValidInput() {
	        Tickets ticket = new Tickets();
	        ticket.setId(1);
	        ticket.setUserId(2);
	        ticket.setFlightId(3);
	    //    ticket.setPriceId(4);
	       ticket.setTravelDate(LocalDate.of(2023, 9, 25));
	        
	        TicketsService ts=new TicketsService();

	        assertDoesNotThrow(() -> {
	        	ts.create(ticket);
	            
	        });
	    }

	    @Test
	     void testCreateTicketWithNullObject() {
	    
	    	 TicketsService ts=new TicketsService();
	        Exception exception = assertThrows(ValidationException.class, () -> {
	            ts.create(null);
	        });
	        String expectedMessage = "ERROR try again";
	        String actualMessage = exception.getMessage();
	        assertTrue(expectedMessage.equals(actualMessage));
	    }

	
	}

