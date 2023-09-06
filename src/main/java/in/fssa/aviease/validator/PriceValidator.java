package in.fssa.aviease.validator;

import java.time.LocalDate;
import in.fssa.aviease.dao.FlightDAO;
import in.fssa.aviease.dao.PriceDAO;
import in.fssa.aviease.exception.PersistenceException;
import in.fssa.aviease.exception.ValidationException;
import in.fssa.aviease.model.Flight;
import in.fssa.aviease.model.Price;
import in.fssa.aviease.util.StringUtil;

public class PriceValidator {
	
	public static void validatePrice(Price price)throws ValidationException{
		if(price == null ) {
			throw new ValidationException("invalid user input");
			}
		
		StringUtil.rejectIfInvalidString(price.getFlightId(), "flight no");
		
		validateStsrtDateEndDate(price.getStartDate(),price.getEndDate());
	}
	
	
	public static void validateId(int id)throws ValidationException{
		if(id<1) {
			throw new ValidationException("id can not be 0 or negative");
		}
	}
	
	public static void ValidateFlightIdExists(String flightNo) throws ValidationException{
		FlightDAO flightDAO=new FlightDAO();
		
	Flight flight=new Flight();
		
		
		try {
			flight=null;
			flight=flightDAO.findByFlightNo(flightNo);
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ValidationException(e.getMessage());
		}
		
		if(flight == null) {
			throw new ValidationException("flight not found check the flight no");
		}
		
		
	}
	
	public static void validateString(String string , String input) throws ValidationException{
		
		StringUtil.rejectIfInvalidString(string, input);
	}
	
	public static void validateIdExists(int id)throws ValidationException{
		PriceDAO priceDAO=new PriceDAO();
		Price price=new Price();
		
		
		try {
			price=null;
			price=priceDAO.findById(id);
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ValidationException(e.getMessage());
		}
		
		if(price == null) {
			throw new ValidationException("price id not found check the price ID");
		}
		
	}
	
	public static void validateFindDate(LocalDate date)throws ValidationException{
		LocalDate currentDate = LocalDate.now();

        if (date.isBefore(currentDate)) {
            throw new ValidationException("Start date cannot be before the current date");
        }
	}
	
	public static void validateStsrtDateEndDate(LocalDate startDate,LocalDate endDate) throws ValidationException{
		
		  LocalDate currentDate = LocalDate.now();

	        if (startDate.isBefore(currentDate)) {
	            throw new ValidationException("Start date cannot be before the current date");
	        }

	        if (endDate.isBefore(startDate)) {
	            throw new ValidationException("End date cannot be before the start date");
	        }
		
	}

}
