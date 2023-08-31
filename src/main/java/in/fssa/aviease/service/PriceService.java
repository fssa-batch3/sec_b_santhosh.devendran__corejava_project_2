package in.fssa.aviease.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import in.fssa.aviease.dao.PriceDAO;
import in.fssa.aviease.exception.PersistenceException;
import in.fssa.aviease.exception.ServiceException;
import in.fssa.aviease.exception.ValidationException;
import in.fssa.aviease.model.Price;
import in.fssa.aviease.validator.PriceValidator;
public class PriceService {

	
	public List<Price> findAll()throws ServiceException, ValidationException {
		
		List<Price> listOfPrice=new ArrayList<>();
		
		PriceDAO priceDAO=new PriceDAO();
		
		try {
			
			listOfPrice=priceDAO.findAll();
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
		
		
		
		return listOfPrice;
	}


	public void create(Price price) throws ServiceException, ValidationException {
		
		PriceDAO priceDAO=new PriceDAO();
		
		try {
			PriceValidator.validatePrice(price);
			priceDAO.create(price);
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
		
	}


	public void update(int id, Price price)throws ServiceException, ValidationException{
		PriceDAO priceDAO=new PriceDAO();
		
		try {
			PriceValidator.validateId(id);
			PriceValidator.validateIdExists(id);
			PriceValidator.validatePrice(price);
			priceDAO.update(id, price);
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}


	public void delete(int id)throws ServiceException, ValidationException {
		
		
	}

	
	public Price findById(int id) throws ServiceException, ValidationException {
		
		PriceDAO priceDAO=new PriceDAO();
		Price price=new Price();
		
		try {
			PriceValidator.validateId(id);
			PriceValidator.validateIdExists(id);
			price = priceDAO.findById(id);
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
		return price;
	}


	public List<Price> findByFlightId(String id) throws ServiceException, ValidationException {
		PriceDAO priceDAO=new PriceDAO();
		List<Price> listOfPrice=new ArrayList<>();
		
		try {
			PriceValidator.validateString(id, "flight number");
			PriceValidator.ValidateFlightIdExists(id);
			listOfPrice=priceDAO.findByFlightId(id);
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
		
		return listOfPrice;
	}


	public Price findByDateAndFlightNo(LocalDate date, String flightNo)throws ServiceException, ValidationException{
		
		PriceDAO priceDAO=new PriceDAO();
		
		
		try {
			PriceValidator.validateFindDate(date);
			PriceValidator.ValidateFlightIdExists(flightNo);
			return priceDAO.findByDateAndFlightNo(date, flightNo);
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}

}
