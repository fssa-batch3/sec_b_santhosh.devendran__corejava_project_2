package in.fssa.aviease.validator;

import java.sql.Time;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import in.fssa.aviease.exception.PersistenceException;
import in.fssa.aviease.exception.ValidationException;
import in.fssa.aviease.model.Flight;
import in.fssa.aviease.dao.FlightDAO;
import in.fssa.aviease.util.StringUtil;

public class FlightValidator {

	/**
     * Validates the provided Flight object.
     *
     * @param flight The Flight object to be validated.
     * @throws ValidationException If validation of the flight fails.
     */
	public static void validateFlight(Flight flight) throws ValidationException {
		if(flight == null ) {
			
			throw new ValidationException("flight can not be null");
		}
		
		if(flight.getPrice()<1.0) {
			throw new ValidationException("price can not be 0 or negative");
		}

		StringUtil.rejectIfInvalidString(flight.getSrc(), "source");
		StringUtil.rejectIfInvalidString(flight.getDestination(), "destination");
		StringUtil.rejectIfInvalidString(flight.getAirlineCode(), "airline code");
		StringUtil.rejectIfInvalidString(flight.getFlightNo(), "flight number");
		validateInt(flight.getNoOfSeats(), "seats");
		isValidSqlTimeFormat(flight.getFlightTime());
		
		
	}
	

	/**
     * Validates an integer value.
     *
     * @param in The integer value to be validated.
     * @param inName The name of the integer value for error messages.
     * @throws ValidationException If validation of the integer value fails.
     */
	public static void validateInt(int in, String inName) throws ValidationException {

		if (in < 1) {

			throw new ValidationException(inName.concat("can not be 0 or negative"));
		}
	}
	
	/**
     * Validates a string value.
     *
     * @param in The string value to be validated.
     * @param inName The name of the string value for error messages.
     * @throws ValidationException If validation of the string value fails.
     */
	public static void validateString(String in, String inName) throws ValidationException {

		StringUtil.rejectIfInvalidString(in, inName);
	}

	/**
     * Validates a Time object's format according to SQL time format.
     *
     * @param time The Time object to be validated.
     * @throws ValidationException If validation of the Time object fails.
     */
	public static void isValidSqlTimeFormat(Time time) throws ValidationException {

		String timePattern = "^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$";

		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
		String timeString = timeFormat.format(time.toLocalTime());

		Pattern pattern = Pattern.compile(timePattern);
		Matcher matcher = pattern.matcher(timeString);

		if (!matcher.matches()) {
			throw new ValidationException("Invalid time format");
		}
	}

	/**
     * Validates the non-existence of a flight with the given flight number.
     *
     * @param flightNo The flight number to be validated.
     * @throws ValidationException If a flight with the given number already exists.
     */
	public static void flightNoNotExist(String flightNo) throws ValidationException {

		FlightDAO fdao = new FlightDAO();
		Flight check = new Flight();

		try {
			check = fdao.findByFlightNo(flightNo);
		} catch (PersistenceException e) {
			throw new ValidationException(e.getMessage());
		}

		if (check != null) {
			throw new ValidationException("flight already exist");

		}

	}
	
	/**
     * Validates the existence of a flight with the given flight number.
     *
     * @param flightNo The flight number to be validated.
     * @throws ValidationException If a flight with the given number does not exist.
     */
	public static void flightNoExist(String flightNo) throws ValidationException {

		FlightDAO flightDAO = new FlightDAO();
		Flight check = new Flight();

		try {
			check = flightDAO.findByFlightNo(flightNo);
		} catch (PersistenceException e) {
			throw new ValidationException(e.getMessage());
		}

		if (check == null) {
			throw new ValidationException("flight not exist");

		}

	}
	
	 /**
     * Validates the existence of a flight with the given flight ID.
     *
     * @param flightId The flight ID to be validated.
     * @throws ValidationException If a flight with the given ID does not exist.
     */
	public static void flightIdExist(int flightId) throws ValidationException {

		FlightDAO flightDAO = new FlightDAO();
		Flight check = new Flight();

		try {
			check = flightDAO.findById(flightId);
		} catch (PersistenceException e) {
			throw new ValidationException(e.getMessage());
		}

		if (check == null) {
			throw new ValidationException("flight already not exist");

		}

	}
	
	
	

}
