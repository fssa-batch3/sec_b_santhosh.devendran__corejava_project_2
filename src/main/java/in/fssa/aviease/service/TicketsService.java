package in.fssa.aviease.service;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

import in.fssa.aviease.dao.TicketsDAO;
import in.fssa.aviease.exception.PersistenceException;
import in.fssa.aviease.exception.ServiceException;
import in.fssa.aviease.exception.ValidationException;
import in.fssa.aviease.model.Tickets;
import in.fssa.aviease.validator.TicketsValidator;

public class TicketsService {


	public List<Tickets> findAll() throws ServiceException,ValidationException {
		
		List<Tickets> listOfTickets=new ArrayList<>();
		TicketsDAO tD=new TicketsDAO();
		try {
			listOfTickets=tD.findAll();
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
		return listOfTickets;
	}


	public void create(Tickets ticket) throws ServiceException,ValidationException {
		TicketsDAO tD=new TicketsDAO();
		
		try {
			TicketsValidator.validateTicket(ticket);
			
			tD.create(ticket);
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
		
	}


	public void update(int id, Tickets t) throws ServiceException,ValidationException  {
		
		
	}

	
	public void delete(int id)throws ServiceException,ValidationException  {
		
		TicketsDAO tD=new TicketsDAO();
		
		try {
			tD.delete(id);
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
		
	}

	
	public Tickets findById(int id) throws ServiceException,ValidationException {
		
		TicketsDAO tD=new TicketsDAO();
		Tickets ticket=new Tickets();
		try {
			ticket=tD.findById(id);
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
		return ticket;
	}


	public List<Tickets> findByUserId(int id) throws ServiceException,ValidationException  {
		
		List<Tickets> listOfTickets=new ArrayList<>();
		TicketsDAO tD=new TicketsDAO();
		
		try {
			listOfTickets=tD.findByUserId(id);
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
		return listOfTickets;
	}


	public List<Tickets> findByTravelDate(LocalDate date) throws ServiceException,ValidationException {
		List<Tickets> listOfTickets=new ArrayList<>();
		TicketsDAO tD=new TicketsDAO();
		
		try {
			listOfTickets=tD.findByTravelDate(date);
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
		return listOfTickets;
	}

	
	public List<Tickets> findByFlightId(int flightId) throws ServiceException,ValidationException {
		List<Tickets> listOfTickets=new ArrayList<>();
		TicketsDAO tD=new TicketsDAO();
		
		try {
			listOfTickets=tD.findByFlightId(flightId);
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
		return listOfTickets;
	}
	
	public List<Tickets> findByPriceId(int id) throws ServiceException,ValidationException {
		List<Tickets> listOfTickets=new ArrayList<>();
		TicketsDAO tD=new TicketsDAO();
		
		try {
			listOfTickets=tD.findByPriceId(id);
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
		return listOfTickets;
	}

	public List<Tickets> findByFlightIdTravelDate(int flightId,LocalDate date) throws ServiceException {
		List<Tickets> listOfTickets=new ArrayList<>();
		TicketsDAO tD=new TicketsDAO();
		
		try {
			listOfTickets=tD.findByFlightIdAndTravelDate(flightId, date);
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
		return listOfTickets;
	}
	
	

}
