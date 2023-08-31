package in.fssa.aviease.validator;

import in.fssa.aviease.dao.AirLineDAO;
import in.fssa.aviease.exception.PersistenceException;
import in.fssa.aviease.exception.ValidationException;
import in.fssa.aviease.model.AirLine;
import in.fssa.aviease.util.StringUtil;

public class AirLineValidator {
	
	public static void validateAirLine(AirLine airLine) throws ValidationException {
		
		if(airLine == null) {
			throw new ValidationException("invalid airline input");
		}
		
		StringUtil.rejectIfInvalidString(airLine.getAirLineCode(), "Airline code");
		StringUtil.rejectIfInvalidString(airLine.getAirLineName(), "Airline name");
		
	}
	
	public static void airLineIdExists(int airLineId) throws ValidationException {
		AirLineDAO airLineDAO=new AirLineDAO();
		AirLine airLine=new AirLine();
		try {
			airLine = airLineDAO.findById(airLineId);
		} catch (PersistenceException e) {
			throw new ValidationException(e.getMessage());
		}
		
		if(airLine == null) {
			throw new ValidationException("airline id not exist");
		}
		
		
	}
	
	public static void idValidator(int id) throws ValidationException {
		if(id < 1) {
			throw new ValidationException("id can not be 0 or negative number");
		}
	}
	
	public static void AirlineCodeValidator(String airLineCode) throws ValidationException{
		StringUtil.rejectIfInvalidString(airLineCode, "airLine code");
	}

	public static void airLineCodeExists(String airLineCode) throws ValidationException {
		
		
		AirLineDAO airLineDAO=new AirLineDAO();
		AirLine airLine=new AirLine();
		try {
			airLine = airLineDAO.findByAirLineCode(airLineCode);
		} catch (PersistenceException e) {
			throw new ValidationException(e.getMessage());
		}
		
		if(airLine == null) {
			throw new ValidationException("airline code not exist");
		}
		
		
	}
}
