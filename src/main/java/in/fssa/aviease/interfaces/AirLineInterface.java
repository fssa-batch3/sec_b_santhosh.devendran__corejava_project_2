package in.fssa.aviease.interfaces;

import in.fssa.aviease.exception.PersistenceException;
import in.fssa.aviease.exception.ValidationException;
import in.fssa.aviease.model.AirLine;


public interface AirLineInterface extends Base<AirLine>{

	public abstract AirLine findByAirLineCode(String airLineCode) throws PersistenceException ;
}
