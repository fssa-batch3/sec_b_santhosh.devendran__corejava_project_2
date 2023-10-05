package in.fssa.aviease.dao;

import java.sql.Connection;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import in.fssa.aviease.exception.PersistenceException;
import in.fssa.aviease.interfaces.TicketsInterface;
import in.fssa.aviease.model.Tickets;
import in.fssa.aviease.util.ConnectionUtil;

public class TicketsDAO implements TicketsInterface{

	@Override
	public List<Tickets> findAll() throws PersistenceException {
		 Connection con = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        List<Tickets> ticketsList = new ArrayList<>();

	        try {
	            String query = "SELECT id, user_id, flight_id, created_at, travel_date,is_active,seat FROM tickets";
	            con = ConnectionUtil.getConnection();
	            ps = con.prepareStatement(query);
	            rs = ps.executeQuery();
	            

	            while (rs.next()) {
	                Tickets ticket = new Tickets();
	                ticket.setId(rs.getInt("id"));
	                ticket.setUserId(rs.getInt("user_id"));
	                ticket.setFlightId(rs.getInt("flight_id"));
	                ticket.setBooked(rs.getTimestamp("created_at").toLocalDateTime());
	                ticket.setTravelDate(rs.getDate("travel_date").toLocalDate());
	                ticket.setActive(rs.getBoolean("is_active"));
	                ticket.setSeat(rs.getInt("seat"));
	                ticketsList.add(ticket);
	            }
	        } catch (SQLException e) {
	            throw new PersistenceException(e.getMessage());
	        } finally {
	            ConnectionUtil.close(con, ps, rs);
	        }

	        return ticketsList;
	    }

	@Override
	public void create(Tickets ticket) throws PersistenceException {
		 Connection con = null;
	        PreparedStatement ps = null;

	        try {
	            String query = "INSERT INTO tickets (user_id, flight_id, travel_date,is_active,seat) VALUES (?, ?, ?,?,?)";
	            con = ConnectionUtil.getConnection();
	            ps = con.prepareStatement(query);
	            
	            ps.setInt(1, ticket.getUserId());
	            ps.setInt(2, ticket.getFlightId());
	            ps.setDate(3, Date.valueOf(ticket.getTravelDate()));
	            ps.setBoolean(4, true);
	            ps.setInt(5, ticket.getSeat());
	            ps.executeUpdate();
	        } catch (SQLException e) {
	            throw new PersistenceException(e.getMessage());
	        } finally {
	            ConnectionUtil.close(con, ps);
	        }
	    }

	@Override
	public void update(int id, Tickets t) throws PersistenceException {
		
	}

	@Override
	public void delete(int id) throws PersistenceException {
		   Connection con = null;
		    PreparedStatement ps = null;

		    try {
		        String query = "UPDATE tickets SET is_active = false WHERE id = ?";
		        con = ConnectionUtil.getConnection();
		        ps = con.prepareStatement(query);
		        ps.setInt(1, id);

		        int rowsAffected = ps.executeUpdate();

		        if (rowsAffected == 0) {
		            throw new PersistenceException("Ticket with ID " + id + " not found.");
		        }
		    } catch (SQLException e) {
		        throw new PersistenceException(e.getMessage());
		    } finally {
		        ConnectionUtil.close(con, ps); 
		    }
	}

	@Override
	public Tickets findById(int id) throws PersistenceException {
		   Connection con = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        Tickets ticket = null;

	        try {
	            String query = "SELECT id, user_id, flight_id, created_at, travel_date,is_active,seat FROM tickets WHERE id = ?";
	            con = ConnectionUtil.getConnection();
	            ps = con.prepareStatement(query);
	            ps.setInt(1, id);

	            rs = ps.executeQuery();

	            if (rs.next()) {
	                ticket = new Tickets();
	                ticket.setId(rs.getInt("id"));
	                ticket.setUserId(rs.getInt("user_id"));
	                ticket.setFlightId(rs.getInt("flight_id"));
	                ticket.setTravelDate(rs.getDate("travel_date").toLocalDate());
	                ticket.setActive(rs.getBoolean("is_active"));
	                ticket.setSeat(rs.getInt("seat"));
	               
	            }
	        } catch (SQLException e) {
	            throw new PersistenceException(e.getMessage());
	        } finally {
	            ConnectionUtil.close(con, ps, rs);
	        }

	        return ticket;
	}

	@Override
	public List<Tickets> findByUserId(int id) throws PersistenceException {
		 Connection con = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        List<Tickets> ticketsList = new ArrayList<>();

	        try {
	            String query = "SELECT id, flight_id, created_at, travel_date, is_active,seat FROM tickets WHERE user_id = ?";
	            con = ConnectionUtil.getConnection();
	            ps = con.prepareStatement(query);
	            ps.setInt(1, id);

	            rs = ps.executeQuery();

	            while (rs.next()) {
	                Tickets ticket = new Tickets();
	                ticket.setId(rs.getInt("id"));
	                ticket.setFlightId(rs.getInt("flight_id"));
	                ticket.setBooked(rs.getTimestamp("created_at").toLocalDateTime());
	                ticket.setTravelDate(rs.getDate("travel_date").toLocalDate());
	                ticket.setActive(rs.getBoolean("is_active"));
	                ticket.setSeat(rs.getInt("seat"));
	                ticketsList.add(ticket);
	            }
	        } catch (SQLException e) {
	            throw new PersistenceException(e.getMessage());
	        } finally {
	            ConnectionUtil.close(con, ps, rs);
	        }

	        return ticketsList;
	}

	@Override
	public List<Tickets> findByTravelDate(LocalDate date) throws PersistenceException {
		 Connection con = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        List<Tickets> ticketsList = new ArrayList<>();

	        try {
	            String query = "SELECT id, flight_id, created_at,seat,travel_date FROM tickets WHERE travel_date = ?";
	            con = ConnectionUtil.getConnection();
	            ps = con.prepareStatement(query);
	            ps.setDate(1, java.sql.Date.valueOf(date));

	            rs = ps.executeQuery();

	            while (rs.next()) {
	                Tickets ticket = new Tickets();
	                ticket.setId(rs.getInt("id"));
	                ticket.setFlightId(rs.getInt("flight_id"));
	                ticket.setBooked(rs.getTimestamp("created_at").toLocalDateTime());
	                ticket.setTravelDate(rs.getDate("travel_date").toLocalDate());
	                ticket.setSeat(rs.getInt("seat"));
	                ticketsList.add(ticket);
	            }
	        } catch (SQLException e) {
	            throw new PersistenceException(e.getMessage());
	        } finally {
	            ConnectionUtil.close(con, ps, rs);
	        }

	        return ticketsList;
	}

	@Override
	public List<Tickets> findByFlightId(int flightId) throws PersistenceException {
		 Connection con = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        List<Tickets> ticketsList = new ArrayList<>();

	        try {
	            String query = "SELECT id, user_id, created_at, travel_date,seat,flight_id,is_active FROM tickets WHERE flight_id = ?";
	            con = ConnectionUtil.getConnection();
	            ps = con.prepareStatement(query);
	            ps.setInt(1, flightId);

	            rs = ps.executeQuery();

	            while (rs.next()) {
	                Tickets ticket = new Tickets();
	                ticket.setId(rs.getInt("id"));
	                ticket.setUserId(rs.getInt("user_id"));
	                ticket.setBooked(rs.getTimestamp("created_at").toLocalDateTime());
	                ticket.setTravelDate(rs.getDate("travel_date").toLocalDate());
	                ticket.setActive(rs.getBoolean("is_active"));
	                ticket.setSeat(rs.getInt("seat"));
	                
	                ticketsList.add(ticket);
	            }
	        } catch (SQLException e) {
	            throw new PersistenceException(e.getMessage());
	        } finally {
	            ConnectionUtil.close(con, ps, rs);
	        }

	        return ticketsList;
	}




	
	@Override
	public List<Tickets> findByFlightIdAndTravelDate(int flightId, LocalDate travelDate) throws PersistenceException {
	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    Tickets ticket = null;
	    
	    List<Tickets> listOfTickets = new ArrayList<>();

	    try {
	        String query = "SELECT id, user_id, flight_id, created_at, travel_date, is_active,seat FROM tickets WHERE flight_id = ? AND travel_date = ? AND is_active = 1";
	        con = ConnectionUtil.getConnection();
	        ps = con.prepareStatement(query);
	        ps.setInt(1, flightId);
	        ps.setDate(2, java.sql.Date.valueOf(travelDate));

	        rs = ps.executeQuery();
	      

	        while (rs.next()) {
	            ticket = new Tickets();
	            ticket.setId(rs.getInt("id"));
	            ticket.setUserId(rs.getInt("user_id"));
	            ticket.setFlightId(rs.getInt("flight_id"));
	            ticket.setBooked(rs.getTimestamp("created_at").toLocalDateTime());
	            ticket.setTravelDate(rs.getDate("travel_date").toLocalDate());
	            ticket.setActive(rs.getBoolean("is_active"));
	            ticket.setSeat(rs.getInt("seat"));
	          
	            listOfTickets.add(ticket);
	        }
	    } catch (SQLException e) {
	        throw new PersistenceException(e.getMessage());
	    } finally {
	        ConnectionUtil.close(con, ps, rs);
	    }

	    return listOfTickets;
	}

	public List<Integer> findSeatByFlightIdAndTravelDate(int flightId, LocalDate travelDate) throws PersistenceException {
	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    
	    List<Integer> listOfSeats = new ArrayList<>();

	    try {
	        String query = "SELECT seat FROM tickets WHERE flight_id = ? AND travel_date = ? AND is_active = 1";
	        con = ConnectionUtil.getConnection();
	        ps = con.prepareStatement(query);
	        ps.setInt(1, flightId);
	        ps.setDate(2, java.sql.Date.valueOf(travelDate));

	        rs = ps.executeQuery();
	      

	        while (rs.next()) {
	        	
	        	Integer temp=rs.getInt("seat");
	           
	        	listOfSeats.add(temp);
	        }
	    } catch (SQLException e) {
	        throw new PersistenceException(e.getMessage());
	    } finally {
	        ConnectionUtil.close(con, ps, rs);
	    }

	    return listOfSeats;
	}
	
}
