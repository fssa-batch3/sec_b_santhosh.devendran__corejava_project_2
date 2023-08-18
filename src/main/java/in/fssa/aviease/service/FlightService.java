package in.fssa.aviease.service;

import java.sql.Time;
import java.util.List;

import in.fssa.aviease.model.Flight;
import in.fssa.aviease.validator.FlightValidator;
import in.fssa.aviease.Interface.FlightInterface;
import in.fssa.aviease.dao.FlightDAO;
import in.fssa.aviease.exception.ValidationException;

public class FlightService implements FlightInterface{
	
	FlightDAO flightdao = new FlightDAO();
	

	/**
     * Retrieves a list of all flights.
     *
     * @return A list of all flights.
     */
	@Override
	public List<Flight> findAll() {
		return flightdao.findAll();
	}

	 /**
     * Creates a new flight.
     *
     * @param flight The flight object to be created.
     * @throws ValidationException If validation of the flight fails.
     */
	@Override
	public void create(Flight t) throws ValidationException {
		
		FlightValidator.validateFlight(t);
		
		flightdao.create(t);
		
	}

	/**
     * Updates an existing flight with the provided ID.
     *
     * @param id The ID of the flight to be updated.
     * @param flight The updated flight object.
     * @throws ValidationException If validation of the ID or flight fails.
     */
	@Override
	public void update(int id, Flight t) throws ValidationException {
		
		FlightValidator.flightIdExist(id);
		FlightValidator.validateFlight(t);
		
		flightdao.update(id, t);
		
	}

	
	 /**
     * Deletes a flight with the provided ID.
     *
     * @param id The ID of the flight to be deleted.
     * @throws ValidationException If validation of the ID fails.
     */
	@Override
	public void delete(int id) throws ValidationException {
		
		FlightValidator.flightIdExist(id);
		flightdao.delete(id);
		
	}

	
	 /**
     * Finds a flight by its ID.
     *
     * @param id The ID of the flight to be retrieved.
     * @return The found flight.
     * @throws ValidationException If validation of the ID fails.
     */
	@Override
	public Flight findById(int id) throws ValidationException {
		
		FlightValidator.flightIdExist(id);
	return	flightdao.findById(id);
		
	}


	 /**
     * Finds a flight by its flight number.
     *
     * @param flightNo The flight number of the flight to be retrieved.
     * @return The found flight.
     * @throws ValidationException If validation of the flight number fails.
     */
	@Override
	public Flight findByFlightNo(String flightNo) throws ValidationException {
		
		FlightValidator.flightNoExist(flightNo);
		return flightdao.findByFlightNo(flightNo);
	}


	 /**
     * Finds flights by airline code.
     *
     * @param airLine The airline code to filter flights by.
     * @return A list of flights matching the airline code.
     * @throws ValidationException If validation of the airline code fails.
     */
	@Override
	public List<Flight> findByAirLineCode(String airLine) throws ValidationException {
		
		FlightValidator.validateString(airLine, "airline");
		
		return flightdao.findByAirLineCode(airLine);
	}


	 /**
     * Finds flights by source.
     *
     * @param src The source location to filter flights by.
     * @return A list of flights departing from the source location.
     * @throws ValidationException If validation of the source fails.
     */
	@Override
	public List<Flight> findAllBySource(String src) throws ValidationException {
		
		FlightValidator.validateString(src, "source");
		
		return flightdao.findAllBySource(src);
	}


	 /**
     * Finds flights by source and destination.
     *
     * @param src The source location to filter flights by.
     * @param des The destination location to filter flights by.
     * @return A list of flights departing from the source and arriving at the destination.
     * @throws ValidationException If validation of the source or destination fails.
     */
	@Override
	public List<Flight> findAllBySourcAndDestination(String src, String des) throws ValidationException {
		
		FlightValidator.validateString(src, "source");
		FlightValidator.validateString(des, "destination");
		
		return flightdao.findAllBySourcAndDestination(src, des);
	}


	/**
     * Finds flights by source, destination, and departure time.
     *
     * @param src The source location to filter flights by.
     * @param des The destination location to filter flights by.
     * @param ftime The departure time to filter flights by.
     * @return A list of flights departing from the source, arriving at the destination,
     *         and departing at the specified time.
     * @throws ValidationException If validation of the source, destination, or time fails.
     */
	@Override
	public List<Flight> findAllBySourcAndDestinationAndtime(String src, String des, String ftime) throws ValidationException {
		
		Time time = Time.valueOf(ftime);
		FlightValidator.validateString(src, "source");
		FlightValidator.validateString(des, "destination");
		FlightValidator.isValidSqlTimeFormat(time);
		
		
		return flightdao.findAllBySourcAndDestinationAndtime(src, des, ftime);
	}

}
