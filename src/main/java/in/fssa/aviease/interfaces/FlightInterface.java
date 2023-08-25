package in.fssa.aviease.interfaces;

import java.util.List;

import in.fssa.aviease.exception.ValidationException;
import in.fssa.aviease.model.Flight;

public interface FlightInterface extends Base<Flight> {
	
	public abstract Flight findByFlightNo(String flightNo) throws ValidationException;
	
	public abstract List<Flight> findByAirLineCode(String airLine) throws ValidationException;
	
	public abstract List<Flight> findAllBySource(String src) throws ValidationException;
	
	public abstract List<Flight> findAllBySourcAndDestination(String src,String des) throws ValidationException;
	
	public abstract List<Flight> findAllBySourcAndDestinationAndtime(String src,String des,String time) throws ValidationException;
	


}
