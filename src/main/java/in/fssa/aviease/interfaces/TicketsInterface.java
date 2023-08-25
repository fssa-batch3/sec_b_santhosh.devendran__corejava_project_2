package in.fssa.aviease.interfaces;

import java.time.LocalDate;
import java.util.List;

import in.fssa.aviease.exception.ValidationException;
import in.fssa.aviease.model.Tickets;

public interface TicketsInterface extends Base<Tickets>{
	
	public abstract List<Tickets> findByUserId(int id) throws ValidationException;
	public abstract List<Tickets> findByTravelDate(LocalDate id) throws ValidationException;
	public abstract List<Tickets> findByFlightId(int flightId) throws ValidationException;
	public abstract List<Tickets> findByFlightIdAndTravelDate(int id) throws ValidationException;
	public abstract Tickets findByPriceId(int id) throws ValidationException;
	
}
