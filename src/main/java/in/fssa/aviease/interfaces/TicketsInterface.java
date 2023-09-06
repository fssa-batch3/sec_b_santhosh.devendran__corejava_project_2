package in.fssa.aviease.interfaces;

import java.time.LocalDate;

import java.util.List;

import in.fssa.aviease.exception.PersistenceException;
import in.fssa.aviease.model.Tickets;

public interface TicketsInterface extends Base<Tickets>{
	
	public abstract List<Tickets> findByUserId(int id) throws PersistenceException;
	public abstract List<Tickets> findByTravelDate(LocalDate id) throws PersistenceException;
	public abstract List<Tickets> findByFlightId(int flightId) throws PersistenceException;
	public abstract List<Tickets> findByPriceId(int id) throws PersistenceException;
	List<Tickets> findByFlightIdAndTravelDate(int flightId, LocalDate travelDate) throws PersistenceException;
	
}
