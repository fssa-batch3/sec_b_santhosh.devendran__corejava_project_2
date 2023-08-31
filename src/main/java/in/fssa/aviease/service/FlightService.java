package in.fssa.aviease.service;

import java.sql.Time;


import java.util.List;

import in.fssa.aviease.model.Flight;
import in.fssa.aviease.validator.FlightValidator;
import in.fssa.aviease.dao.FlightDAO;
import in.fssa.aviease.exception.PersistenceException;
import in.fssa.aviease.exception.ServiceException;
import in.fssa.aviease.exception.ValidationException;


public class FlightService {
	
	FlightDAO flightDAO = new FlightDAO();
	

	/**
     * Retrieves a list of all flights.
     *
     * @return A list of all flights.
	 * @throws ServiceException 
	 * @throws PersistenceException 
     */
	public List<Flight> findAllFlight() throws ServiceException, ValidationException{
		try {
			return flightDAO.findAll();
		} catch (PersistenceException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	 /**
     * Creates a new flight.
     *
     * @param flight The flight object to be created.
	 * @throws ServiceException 
     * @throws ValidationException If validation of the flight fails.
	 * @throws  
     */
	public void createFlight(Flight t) throws ServiceException ,ValidationException{
		
		try {
			FlightValidator.validateFlight(t);
			flightDAO.create(t);
		} catch (PersistenceException e) {
			
			throw new ServiceException(e.getMessage());
		}
		
		
		
	}

	/**
     * Updates an existing flight with the provided ID.
     *
     * @param id The ID of the flight to be updated.
     * @param flight The updated flight object.
	 * @throws ServiceException 
     * @throws ValidationException If validation of the ID or flight fails.
     */
	public void updateFlight(int id, Flight t) throws ServiceException ,ValidationException{
		
		try {
			FlightValidator.flightIdExist(id);
			FlightValidator.validateFlight(t);
			flightDAO.update(id, t);
		} catch (PersistenceException e) {
			throw new ServiceException(e.getMessage());
		}
		
		
		
		
	}

	
	 /**
     * Deletes a flight with the provided ID.
     *
     * @param id The ID of the flight to be deleted.
	 * @throws ServiceException 
     * @throws ValidationException If validation of the ID fails.
     */
	public void deleteFlight(int id) throws ServiceException ,ValidationException {
		
		try {
			FlightValidator.flightIdExist(id);
			flightDAO.delete(id);
		} catch (PersistenceException e) {
			throw new ServiceException(e.getMessage());
		}
		
		
	}

	
	 /**
     * Finds a flight by its ID.
     *
     * @param id The ID of the flight to be retrieved.
     * @return The found flight.
	 * @throws ServiceException 
     * @throws ValidationException If validation of the ID fails.
     */
	public Flight findByFlightId(int id) throws ServiceException ,ValidationException{
		
		try {
			FlightValidator.flightIdExist(id);
			return	flightDAO.findById(id);
		} catch (PersistenceException e) {
			throw new ServiceException(e.getMessage());
		} 
	
		
	}


	 /**
     * Finds a flight by its flight number.
     *
     * @param flightNo The flight number of the flight to be retrieved.
     * @return The found flight.
	 * @throws ServiceException 
     * @throws ValidationException If validation of the flight number fails.
     */
	public Flight findByFlightNo(String flightNo) throws ServiceException ,ValidationException{
		
		try {
			FlightValidator.flightNoExist(flightNo);
			return flightDAO.findByFlightNo(flightNo);
		} catch (PersistenceException e) {
			throw new ServiceException(e.getMessage());
		}
		
	}


	 /**
     * Finds flights by airline code.
     *
     * @param airLine The airline code to filter flights by.
     * @return A list of flights matching the airline code.
	 * @throws ServiceException 
     * @throws ValidationException If validation of the airline code fails.
     */
	public List<Flight> findFlightByAirLineCode(String airLine) throws ServiceException,ValidationException{
		
		try {
			FlightValidator.validateString(airLine, "airline");
			return flightDAO.findByAirLineCode(airLine);
		} catch (PersistenceException e) {
			throw new ServiceException(e.getMessage());
		}
		
		
	}


	 /**
     * Finds flights by source.
     *
     * @param src The source location to filter flights by.
     * @return A list of flights departing from the source location.
	 * @throws ServiceException 
     * @throws ValidationException If validation of the source fails.
     */
	public List<Flight> findAllFlightBySource(String src) throws ServiceException ,ValidationException{
		
		try {
			FlightValidator.validateString(src, "source");
			return flightDAO.findAllBySource(src);
		} catch (PersistenceException e) {
			throw new ServiceException(e.getMessage());
		}
		
		
	}


	 /**
     * Finds flights by source and destination.
     *
     * @param src The source location to filter flights by.
     * @param des The destination location to filter flights by.
     * @return A list of flights departing from the source and arriving at the destination.
	 * @throws ServiceException 
     * @throws ValidationException If validation of the source or destination fails.
     */
	public List<Flight> findAllFlightBySourcAndDestination(String src, String des) throws ServiceException ,ValidationException{
		
		
		try {
			FlightValidator.validateString(src, "source");
			FlightValidator.validateString(des, "destination");
			return flightDAO.findAllBySourcAndDestination(src, des);
		} catch (PersistenceException e) {
			throw new ServiceException(e.getMessage());
		}
		
		
	}


	/**
     * Finds flights by source, destination, and departure time.
     *
     * @param src The source location to filter flights by.
     * @param des The destination location to filter flights by.
     * @param ftime The departure time to filter flights by.
     * @return A list of flights departing from the source, arriving at the destination,
     *         and departing at the specified time.
	 * @throws ServiceException 
     * @throws ValidationException If validation of the source, destination, or time fails.
     */
	public List<Flight> findAllFlightBySourcAndDestinationAndtime(String src, String des, String ftime) throws ServiceException ,ValidationException{
		
		Time time = Time.valueOf(ftime);
		try {
			FlightValidator.validateString(des, "destination");
			FlightValidator.isValidSqlTimeFormat(time);
			FlightValidator.validateString(src, "source");
			return flightDAO.findAllBySourcAndDestinationAndtime(src, des, ftime);
		} catch (PersistenceException e) {
			throw new ServiceException(e.getMessage());
		}
		
		
		
		
	}

}
