package in.fssa.aviease.service;

import java.util.List;


import in.fssa.aviease.dao.DaysDAO;
import in.fssa.aviease.exception.PersistenceException;
import in.fssa.aviease.exception.ServiceException;
import in.fssa.aviease.exception.ValidationException;

import in.fssa.aviease.model.Days;
import in.fssa.aviease.validator.DaysValidator;

public class DaysService{

	DaysDAO daysDAO=new DaysDAO();
	
	public List<Days> findAll() throws ServiceException, ValidationException {
		
		try {
			return daysDAO.findAll();
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}


	public void createDays(Days days)throws ServiceException, ValidationException {
		
		try {
			DaysValidator.validateDays(days);
			daysDAO.create(days);
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
		
	}

	
	public void updateDays(int id, Days days) throws ServiceException, ValidationException {
		try {
			DaysValidator.validateId(id);
			DaysValidator.validateDays(days);
			daysDAO.update(id, days);
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
		
	}


	public void delete(int id) throws ServiceException, ValidationException {
		// TODO Auto-generated method stub
		
	}

	
	public Days findDaysById(int id) throws ServiceException, ValidationException {
		
		try {
			DaysValidator.validateId(id);
			return daysDAO.findById(id);
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
		
	}

	
	public Days findDaysByFlightNo(String flightNo) throws ServiceException, ValidationException {
	
		try {
			DaysValidator.validateFlightNoNotExists(flightNo);
			return daysDAO.findByFlightNo(flightNo);
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}

	


}
