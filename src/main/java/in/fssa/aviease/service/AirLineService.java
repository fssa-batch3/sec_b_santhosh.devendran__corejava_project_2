package in.fssa.aviease.service;

import java.util.List;

import in.fssa.aviease.dao.AirLineDAO;
import in.fssa.aviease.exception.PersistenceException;
import in.fssa.aviease.exception.ServiceException;
import in.fssa.aviease.exception.ValidationException;
import in.fssa.aviease.model.AirLine;
import in.fssa.aviease.validator.AirLineValidator;

public class AirLineService {

	AirLineDAO airLineDAO=new AirLineDAO(); 

	public List<AirLine> findAll()throws ServiceException ,ValidationException {
		
		
		
		try {
			return airLineDAO.findAll();
		} catch (PersistenceException e) {
			throw new ServiceException(e.getMessage());
		}
		
		
	}


	public void create(AirLine airLine)throws ServiceException ,ValidationException{
		
		try {
			AirLineValidator.validateAirLine(airLine);
			AirLineValidator.idValidator(airLine.getId());
			airLineDAO.create(airLine);
		} catch (PersistenceException e) {
			throw new ServiceException(e.getMessage());
		}
		
	}


	public void update(int id, AirLine airLine) throws ServiceException ,ValidationException{
		
		try {
			AirLineValidator.idValidator(id);
			AirLineValidator.validateAirLine(airLine);
			airLineDAO.update(id, airLine);
		} catch (PersistenceException e) {
			throw new ServiceException(e.getMessage());
		}
		
	}


	public void delete(int id)throws ServiceException ,ValidationException{
		
		try {
			AirLineValidator.idValidator(id);
			AirLineValidator.airLineIdExists(id);
			airLineDAO.delete(id);
		} catch (PersistenceException e) {
			throw new ServiceException(e.getMessage());
		}
		
		
		
	}


	public AirLine findById(int id)throws ServiceException ,ValidationException {
		
		try {
			AirLineValidator.idValidator(id);
			AirLineValidator.airLineIdExists(id);
			return airLineDAO.findById(id);
		} catch (PersistenceException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	
	public AirLine findByAirLineCode(String airLineCode)throws ServiceException ,ValidationException{
		
		try {
			AirLineValidator.AirlineCodeValidator(airLineCode);
			AirLineValidator.airLineCodeExists(airLineCode);
			return airLineDAO.findByAirLineCode(airLineCode);
		} catch (PersistenceException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	
	
}
