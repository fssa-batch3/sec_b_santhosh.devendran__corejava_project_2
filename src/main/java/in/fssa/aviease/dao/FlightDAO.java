package in.fssa.aviease.dao;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import in.fssa.aviease.exception.PersistenceException;
import in.fssa.aviease.interfaces.FlightInterface;
import in.fssa.aviease.model.Flight;
import in.fssa.aviease.util.ConnectionUtil;

public class FlightDAO implements FlightInterface {

	@Override
	public List<Flight> findAll() throws PersistenceException {
		Connection con = null;
		PreparedStatement ps = null;
		List<Flight> FlightList = new ArrayList<>();
		ResultSet rs = null;

		
		try {
			String query = "SELECT id, src, destination, airline_code, flight_no, flight_status, flight_time, no_of_seats,price FROM flights ";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);

			rs = ps.executeQuery(query);

			while (rs.next()) {

				Flight flight=new Flight();
				flight.setId(rs.getInt("id"));
				flight.setSrc(rs.getString("src"));
				flight.setDestination(rs.getString("destination"));
				flight.setAirlineCode(rs.getString("airline_code"));
				flight.setFlightNo(rs.getString("flight_no"));
				flight.setFlightStatus(rs.getBoolean("flight_status"));
				flight.setFlightTime(rs.getTime("flight_time"));
				flight.setNoOfSeats(rs.getInt("no_of_seats"));
				flight.setPrice(Double.parseDouble(rs.getBigDecimal("price").toString()));
				
				FlightList.add(flight);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new PersistenceException(e.getMessage());
		} finally {
			ConnectionUtil.close(con, ps, rs);
		}

		return FlightList;
	}

	@Override
	public void create(Flight flight) throws PersistenceException {
		 Connection con = null;
		    PreparedStatement ps = null;

		    try {
		        String query = "INSERT INTO flights (src, destination, airline_code, flight_no, flight_status, flight_time, no_of_seats,price) " +
		                       "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		        con = ConnectionUtil.getConnection();
		        ps = con.prepareStatement(query);
		        ps.setString(1, flight.getSrc());
		        ps.setString(2, flight.getDestination());
		        ps.setString(3, flight.getAirlineCode());
		        ps.setString(4, flight.getFlightNo());
		
		        ps.setBoolean(5, flight.isFlightStatus());
		        ps.setTime(6, flight.getFlightTime());
		        ps.setInt(7, flight.getNoOfSeats());
		        ps.setDouble(8, flight.getPrice());
		        ps.executeUpdate();
		    } catch (SQLException e) {
		        e.printStackTrace();
		        if (e.getMessage().contains("Duplicate entry")) {
		        	throw new PersistenceException("Duplicate entry");
		        } else {
		            System.out.println(e.getMessage());
		            throw new PersistenceException(e.getMessage());
		        }
		    } finally {
		        ConnectionUtil.close(con, ps);
		    }
		}
	


	@Override
	public void update(int flightId, Flight newFlight) throws PersistenceException {
	    Connection con = null;
	    PreparedStatement ps = null;

	    try {
	        String query = "UPDATE flights SET src = ?, destination = ?, airline_code = ?, flight_no = ? , flight_status = ?, flight_time = ?, no_of_seats = ?,price = ? WHERE id = ?";
	        con = ConnectionUtil.getConnection();
	        ps = con.prepareStatement(query);
	        ps.setString(1, newFlight.getSrc());
	        ps.setString(2, newFlight.getDestination());
	        ps.setString(3, newFlight.getAirlineCode());
	        ps.setString(4, newFlight.getFlightNo());
	        ps.setBoolean(5, newFlight.isFlightStatus());
	        ps.setTime(6, newFlight.getFlightTime());
	        ps.setInt(7, newFlight.getNoOfSeats());
	        ps.setDouble(8, newFlight.getPrice());
	        ps.setInt(9, flightId);

	        ps.executeUpdate();

	   
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new PersistenceException(e.getMessage());
	    } finally {
	        ConnectionUtil.close(con, ps);
	    }
	}

	@Override
	public void delete(int flightId) throws PersistenceException {
		  Connection con = null;
		    PreparedStatement ps = null;

		    try {
		        String query = "UPDATE flight SET flight_status = ? WHERE id = ?";
		        con = ConnectionUtil.getConnection();
		        ps = con.prepareStatement(query);
		        ps.setBoolean(1, false);  
		        ps.setInt(2, flightId);

		        ps.executeUpdate();

		        System.out.println("Flight Successfully Deactivated :)");

		    } catch (SQLException e) {
		        e.printStackTrace();
		        throw new PersistenceException(e.getMessage());
		    } finally {
		        ConnectionUtil.close(con, ps);
		    }
	}

	@Override
	public Flight findById(int id) throws PersistenceException {
		   Connection con = null;
		    PreparedStatement ps = null;
		    ResultSet rs = null;
		    Flight flight = null;

		    try {
		        String query = "SELECT id, src, destination, airline_code, flight_no, flight_status, flight_time, no_of_seats,price FROM flights WHERE id = ?";
		        con = ConnectionUtil.getConnection();
		        ps = con.prepareStatement(query);
		        ps.setInt(1, id);

		        rs = ps.executeQuery();

		        if (rs.next()) {
		            flight = new Flight();
		            flight.setId(rs.getInt("id"));
		            flight.setSrc(rs.getString("src"));
		            flight.setDestination(rs.getString("destination"));
		            flight.setAirlineCode(rs.getString("airline_code"));
		            flight.setFlightNo(rs.getString("flight_no"));
		            flight.setFlightStatus(rs.getBoolean("flight_status"));
		            flight.setFlightTime(rs.getTime("flight_time"));
		            flight.setNoOfSeats(rs.getInt("no_of_seats"));
		            flight.setPrice(Double.parseDouble(rs.getBigDecimal("price").toString()));
		        }

		    } catch (SQLException e) {
		        throw new PersistenceException(e.getMessage());
		    } finally {
		        ConnectionUtil.close(con, ps, rs);
		    }

		    return flight;
	}

	@SuppressWarnings("null")
	@Override
	public Flight findByFlightNo(String flightNo) throws PersistenceException {
		  Connection con = null;
		    PreparedStatement ps = null;
		    Flight flight = null;
		    ResultSet rs = null;

		    try {
		        String query = "SELECT id, src, destination, airline_code, flight_no, flight_status, flight_time, no_of_seats,price FROM flights WHERE flight_no = ? AND flight_status = 1";
		        con = ConnectionUtil.getConnection();
		        ps = con.prepareStatement(query);
		        ps.setString(1, flightNo);

		        rs = ps.executeQuery();

		        if (rs.next()) {
		           flight =new Flight();
		            flight.setId(rs.getInt("id"));
		            flight.setSrc(rs.getString("src"));
		            flight.setDestination(rs.getString("destination"));
		            flight.setAirlineCode(rs.getString("airline_code"));
		            flight.setFlightNo(rs.getString("flight_no"));
		            flight.setFlightStatus(rs.getBoolean("flight_status"));
		            flight.setFlightTime(rs.getTime("flight_time"));
		            flight.setNoOfSeats(rs.getInt("no_of_seats"));
		            flight.setPrice(Double.parseDouble(rs.getBigDecimal("price").toString()));
		           
		        }

		    } catch (SQLException e) {
		        throw new PersistenceException(e.getMessage());
		    } finally {
		        ConnectionUtil.close(con, ps, rs);
		    }

		    return flight;
	}

	@Override
	public List<Flight> findByAirLineCode(String airLine) throws PersistenceException {
		Connection con = null;
		PreparedStatement ps = null;
		List<Flight> FlightList = new ArrayList<>();
		ResultSet rs = null;

		try {
			String query = "SELECT id, src, destination, airline_code, flight_no, flight_status, flight_time, no_of_seats, price FROM flights WHERE flight_status = 1 AND airline_code = ?";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			 ps.setString(1, airLine);
			rs = ps.executeQuery();

			while (rs.next()) {

				Flight flight=new Flight();
				flight.setId(rs.getInt("id"));
				flight.setSrc(rs.getString("src"));
				flight.setDestination(rs.getString("destination"));
				flight.setAirlineCode(rs.getString("airline_code"));
				flight.setFlightNo(rs.getString("flight_no"));
				flight.setFlightStatus(rs.getBoolean("flight_status"));
				flight.setFlightTime(rs.getTime("flight_time"));
				flight.setNoOfSeats(rs.getInt("no_of_seats"));
				flight.setPrice(Double.parseDouble(rs.getBigDecimal("price").toString()));
				
				FlightList.add(flight);
			}

		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			ConnectionUtil.close(con, ps, rs);
		}

		return FlightList;
	}

	@Override
	public List<Flight> findAllBySource(String src) throws PersistenceException {
		 Connection con = null;
		    PreparedStatement ps = null;
		    List<Flight> flightList = new ArrayList<>();
		    ResultSet rs = null;

		    try {
		        String query = "SELECT id, src, destination, airline_code, flight_no, flight_status, flight_time, no_of_seats,price FROM flights WHERE flight_status = 1 AND src = ?";
		        con = ConnectionUtil.getConnection();
		        ps = con.prepareStatement(query);
		        ps.setString(1, src);

		        rs = ps.executeQuery();

		        while (rs.next()) {
		            Flight flight = new Flight();
		            flight.setId(rs.getInt("id"));
		            flight.setSrc(rs.getString("src"));
		            flight.setDestination(rs.getString("destination"));
		            flight.setAirlineCode(rs.getString("airline_code"));
		            flight.setFlightNo(rs.getString("flight_no"));
		            flight.setFlightStatus(rs.getBoolean("flight_status"));
		            flight.setFlightTime(rs.getTime("flight_time"));
		            flight.setNoOfSeats(rs.getInt("no_of_seats"));
		            flight.setPrice(Double.parseDouble(rs.getBigDecimal("price").toString()));
		            flightList.add(flight);
		        }

		    } catch (SQLException e) {
		        throw new PersistenceException(e.getMessage());
		    } finally {
		        ConnectionUtil.close(con, ps, rs);
		    }

		    return flightList;
	}

	@Override
	public List<Flight> findAllBySourcAndDestination(String src, String des) throws PersistenceException {
		  Connection con = null;
		    PreparedStatement ps = null;
		    List<Flight> flightList = new ArrayList<>();
		    ResultSet rs = null;

		    try {
		        String query = "SELECT id, src, destination, airline_code, flight_no, flight_status, flight_time, no_of_seats,price FROM flights WHERE flight_status = 1 AND src = ? AND destination = ?";
		        con = ConnectionUtil.getConnection();
		        ps = con.prepareStatement(query);
		        ps.setString(1, src);
		        ps.setString(2, des);

		        rs = ps.executeQuery();

		        while (rs.next()) {
		            Flight flight = new Flight();
		            flight.setId(rs.getInt("id"));
		            flight.setSrc(rs.getString("src"));
		            flight.setDestination(rs.getString("destination"));
		            flight.setAirlineCode(rs.getString("airline_code"));
		            flight.setFlightNo(rs.getString("flight_no"));
		            flight.setFlightStatus(rs.getBoolean("flight_status"));
		            flight.setFlightTime(rs.getTime("flight_time"));
		            flight.setNoOfSeats(rs.getInt("no_of_seats"));
		            flight.setPrice(Double.parseDouble(rs.getBigDecimal("price").toString()));
		            flightList.add(flight);
		        }

		    } catch (SQLException e) {
		        throw new PersistenceException(e.getMessage());
		    } finally {
		        ConnectionUtil.close(con, ps, rs);
		    }

		    return flightList;
	}

	@Override
	public List<Flight> findAllBySourcAndDestinationAndtime(String src, String des, String startTime) throws PersistenceException {
		   Connection con = null;
		    PreparedStatement ps = null;
		    List<Flight> flightList = new ArrayList<>();
		    ResultSet rs = null;
		    
		    String timeStr = startTime ;
	        
	        Time time = Time.valueOf(timeStr);

		    try {
		        String query = "SELECT id, src, destination, airline_code, flight_no, flight_status, flight_time, no_of_seats,price FROM flights WHERE flight_status = 1 AND src = ? AND destination = ? AND flight_time >= ?";
		        con = ConnectionUtil.getConnection();
		        ps = con.prepareStatement(query);
		        ps.setString(1, src);
		        ps.setString(2, des);
		        ps.setTime(3, time);

		        rs = ps.executeQuery();

		        while (rs.next()) {
		            Flight flight = new Flight();
		            flight.setId(rs.getInt("id"));
		            flight.setSrc(rs.getString("src"));
		            flight.setDestination(rs.getString("destination"));
		            flight.setAirlineCode(rs.getString("airline_code"));
		            flight.setFlightNo(rs.getString("flight_no"));
		            flight.setFlightStatus(rs.getBoolean("flight_status"));
		            flight.setFlightTime(rs.getTime("flight_time"));
		            flight.setNoOfSeats(rs.getInt("no_of_seats"));
		            flight.setPrice(Double.parseDouble(rs.getBigDecimal("price").toString()));
		            flightList.add(flight);
		        }

		    } catch (SQLException e) {
		        throw new PersistenceException(e.getMessage());
		    } finally {
		        ConnectionUtil.close(con, ps, rs);
		    }

		    return flightList;
	}

}
