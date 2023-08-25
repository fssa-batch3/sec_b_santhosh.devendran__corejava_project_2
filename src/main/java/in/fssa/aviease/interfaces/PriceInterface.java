package in.fssa.aviease.interfaces;

import java.time.LocalDate;

import in.fssa.aviease.exception.ValidationException;
import in.fssa.aviease.model.Price;

public interface PriceInterface extends Base<Price>{
	
	public abstract Price findByPriceId(int id) throws ValidationException;
	public abstract Price findByDateAndFlightNo(LocalDate date,String flightNo) throws ValidationException;

}
