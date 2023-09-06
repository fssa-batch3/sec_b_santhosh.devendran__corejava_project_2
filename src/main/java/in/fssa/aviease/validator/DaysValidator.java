package in.fssa.aviease.validator;

import in.fssa.aviease.dao.DaysDAO;
import in.fssa.aviease.dao.FlightDAO;
import in.fssa.aviease.exception.PersistenceException;
import in.fssa.aviease.exception.ValidationException;
import in.fssa.aviease.model.Days;
import in.fssa.aviease.model.Flight;
import in.fssa.aviease.util.StringUtil;

public class DaysValidator {
	
	public static void validateDays(Days day) throws ValidationException{
		
		if(day == null) {
			throw new ValidationException("invalid days input");
		}
		
		validateFlightNo(day.getFlightNo());
	//	validateFlightNoExists(day.getFlightNo());
		validateAtLeastOneDaySelected(day);
	}
	
	public static void validateAtLeastOneDaySelected(Days days) throws ValidationException {
		
	    if (!days.getMon() && !days.getTue() && !days.getWed() && !days.getThu() && !days.getFri() && !days.getSat() && !days.getSun()) {
	        throw new ValidationException("At least one day must be selected");
	    }
	    
	}

	
	public static void validateId(int id) throws ValidationException{
		if(id < 1) {
			throw new ValidationException("id can not be 0 or negative");
		}
		
		Days days=new Days();
		DaysDAO daysDAO=new DaysDAO();
		
		try {
			days =null;
			days = daysDAO.findById(id);
		} catch (PersistenceException e) {
			throw new ValidationException(e.getMessage());
		}
		
		if(days == null) {
			throw new ValidationException("flight id not found");
		}
	}
	
	public static void validateFlightNo(String flightNo) throws ValidationException{
		StringUtil.rejectIfInvalidString(flightNo, "flight no");
		
	}
	
	public static void validateFlightNoExists(String flightNo) throws ValidationException{
		Flight flight=new Flight();
		
		FlightDAO flightDAO=new FlightDAO();
		
		try {
			flight =null;
			flight = flightDAO.findByFlightNo(flightNo);
		} catch (PersistenceException e) {
			throw new ValidationException(e.getMessage());
		}
		
		if(flight != null) {
			throw new ValidationException("flight number already exists");
		}

	}
	
	public static void validateFlightNoNotExists(String flightNo) throws ValidationException{
		Flight flight=new Flight();
		
		FlightDAO flightDAO=new FlightDAO();
		
		try {
			flight =null;
			flight = flightDAO.findByFlightNo(flightNo);
		} catch (PersistenceException e) {
			throw new ValidationException(e.getMessage());
		}
		
		if(flight == null) {
			throw new ValidationException("flight number not exists");
		}

	}

}
