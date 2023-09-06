package in.fssa.aviease.interfaces;

import java.time.LocalDate;

import java.util.List;

import in.fssa.aviease.exception.PersistenceException;
import in.fssa.aviease.model.Price;

public interface PriceInterface extends Base<Price>{
	
	public abstract Price findByDateAndFlightNo(LocalDate date,String flightNo) throws  PersistenceException;
	public abstract List<Price> findByFlightId(String flightId) throws PersistenceException;
	 
	
}
