package in.fssa.aviease.interfaces;


import in.fssa.aviease.exception.PersistenceException;
import in.fssa.aviease.exception.ValidationException;
import in.fssa.aviease.model.Days;

public interface DaysInterface extends Base<Days>{

	public abstract Days findByFlightNo(String flightNo) throws ValidationException, PersistenceException ;
	
}
