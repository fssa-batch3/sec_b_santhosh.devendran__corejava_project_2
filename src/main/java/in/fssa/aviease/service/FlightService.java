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
	


	@Override
	public List<Flight> findAll() {
		return flightdao.findAll();
	}


	@Override
	public void create(Flight t) throws Exception {
		
		FlightValidator.validateFlight(t);
		
		flightdao.create(t);
		
	}


	@Override
	public void update(int id, Flight t) throws ValidationException {
		
		FlightValidator.flightIdExist(id);
		FlightValidator.validateFlight(t);
		
		flightdao.update(id, t);
		
	}


	@Override
	public void delete(int id) throws ValidationException {
		
		FlightValidator.flightIdExist(id);
		flightdao.delete(id);
		
	}


	@Override
	public Flight findById(int id) throws ValidationException {
		
		FlightValidator.flightIdExist(id);
	return	flightdao.findById(id);
		
	}


	@Override
	public Flight findByFlightNo(String flightNo) throws ValidationException {
		
		FlightValidator.flightNoExist(flightNo);
		return flightdao.findByFlightNo(flightNo);
	}


	@Override
	public List<Flight> findByAirLineCode(String airLine) throws ValidationException {
		
		FlightValidator.validateString(airLine, "airline");
		
		return flightdao.findByAirLineCode(airLine);
	}


	@Override
	public List<Flight> findAllBySource(String src) throws ValidationException {
		
		FlightValidator.validateString(src, "source");
		
		return flightdao.findAllBySource(src);
	}


	@Override
	public List<Flight> findAllBySourcAndDestination(String src, String des) throws ValidationException {
		
		FlightValidator.validateString(src, "source");
		FlightValidator.validateString(des, "destination");
		
		return flightdao.findAllBySourcAndDestination(src, des);
	}


	@Override
	public List<Flight> findAllBySourcAndDestinationAndtime(String src, String des, String ftime) throws ValidationException {
		
		Time time = Time.valueOf(ftime);
		FlightValidator.validateString(src, "source");
		FlightValidator.validateString(des, "destination");
		FlightValidator.isValidSqlTimeFormat(time);
		
		
		return flightdao.findAllBySourcAndDestinationAndtime(src, des, ftime);
	}

}
