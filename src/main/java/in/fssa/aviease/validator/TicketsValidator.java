package in.fssa.aviease.validator;

import in.fssa.aviease.exception.ValidationException;
import in.fssa.aviease.model.Tickets;

public class TicketsValidator {

public static void validateTicket(Tickets ticket)throws ValidationException{
		
		if(ticket == null) {
			throw new ValidationException("ERROR try again");
		}
		
	}


	

}
