package in.fssa.aviease.validator;

import java.time.LocalDate;

import in.fssa.aviease.exception.ValidationException;
import in.fssa.aviease.model.Tickets;

public class TicketsValidator {

	
	public static void validateTicket(Tickets ticket)throws ValidationException{
		
		if(!isTodayOrFuture(ticket.getTravelDate())) {
			throw new ValidationException("check the date date can not be past");
		}
		
	}
	
	 public static boolean isTodayOrFuture(LocalDate date) {
	        LocalDate today = LocalDate.now();
	        return !date.isBefore(today);
	    }
}
