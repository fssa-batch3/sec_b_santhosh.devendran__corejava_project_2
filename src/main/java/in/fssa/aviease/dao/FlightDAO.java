package in.fssa.aviease.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import in.fssa.aviease.Interface.FlightInterface;
import in.fssa.aviease.model.Flight;
import in.fssa.aviease.model.User;
import in.fssa.aviease.util.ConnectionUtil;

public class FlightDAO implements FlightInterface {

	@Override
	public List<Flight> findAll() {
		Connection con = null;
		PreparedStatement ps = null;
		List<Flight> FlightList = new ArrayList<>();
		ResultSet rs = null;

		try {
			String query = "SELECT * FROM flight WHERE flight_status= 1 ";
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
				flight.setDayId(rs.getInt("day_id"));
				flight.setFlightStatus(rs.getBoolean("flight_status"));
				flight.setFlightTime(rs.getTime("flight_time"));
				flight.setNoOfSeats(rs.getInt("no_of_seats"));
				
				FlightList.add(flight);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		} finally {
			ConnectionUtil.close(con, ps, rs);
		}

		return FlightList;
	}

	@Override
	public void create(Flight flight) {
		 Connection con = null;
		    PreparedStatement ps = null;

		    try {
		        String query = "INSERT INTO flight (src, destination, airline_code, flight_no, day_id, flight_status, flight_time, no_of_seats) " +
		                       "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		        con = ConnectionUtil.getConnection();
		        ps = con.prepareStatement(query);
		        ps.setString(1, flight.getSrc());
		        ps.setString(2, flight.getDestination());
		        ps.setString(3, flight.getAirlineCode());
		        ps.setString(4, flight.getFlightNo());
		        ps.setInt(5, flight.getDayId());
		        ps.setBoolean(6, flight.isFlightStatus());
		        ps.setTime(7, flight.getFlightTime());
		        ps.setInt(8, flight.getNoOfSeats());
		        ps.executeUpdate();
		    } catch (SQLException e) {
		        e.printStackTrace();
		        if (e.getMessage().contains("Duplicate entry")) {
		            throw new RuntimeException("Duplicate constraint");
		        } else {
		            System.out.println(e.getMessage());
		            throw new RuntimeException(e);
		        }
		    } finally {
		        ConnectionUtil.close(con, ps);
		    }
		}
	


	@Override
	public void update(int flightId, Flight newFlight) {
	    Connection con = null;
	    PreparedStatement ps = null;

	    try {
	        String query = "UPDATE flight SET src = ?, destination = ?, airline_code = ?, flight_no = ? ,day_id = ?, flight_status = ?, flight_time = ?, no_of_seats = ? WHERE id = ?";
	        con = ConnectionUtil.getConnection();
	        ps = con.prepareStatement(query);
	        ps.setString(1, newFlight.getSrc());
	        ps.setString(2, newFlight.getDestination());
	        ps.setString(3, newFlight.getAirlineCode());
	        ps.setString(4, newFlight.getFlightNo());
	        ps.setInt(5, newFlight.getDayId());
	        ps.setBoolean(6, newFlight.isFlightStatus());
	        ps.setTime(7, newFlight.getFlightTime());
	        ps.setInt(8, newFlight.getNoOfSeats());
	        ps.setInt(9, flightId);

	        ps.executeUpdate();

	        System.out.println("Flight Successfully Updated :)");

	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println(e.getMessage());
	        throw new RuntimeException(e);
	    } finally {
	        ConnectionUtil.close(con, ps);
	    }
	}

	@Override
	public void delete(int flightId) {
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
		        System.out.println(e.getMessage());
		        throw new RuntimeException(e);
		    } finally {
		        ConnectionUtil.close(con, ps);
		    }
	}

	@Override
	public Flight findById(int id) {
		   Connection con = null;
		    PreparedStatement ps = null;
		    ResultSet rs = null;
		    Flight flight = null;

		    try {
		        String query = "SELECT * FROM flight WHERE id = ?";
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
		            flight.setDayId(rs.getInt("day_id"));
		            flight.setFlightStatus(rs.getBoolean("flight_status"));
		            flight.setFlightTime(rs.getTime("flight_time"));
		            flight.setNoOfSeats(rs.getInt("no_of_seats"));
		        }

		    } catch (SQLException e) {
		        System.out.println(e.getMessage());
		        throw new RuntimeException(e);
		    } finally {
		        ConnectionUtil.close(con, ps, rs);
		    }

		    return flight;
	}

	@Override
	public Flight findByFlightNo(String flightNo) {
		  Connection con = null;
		    PreparedStatement ps = null;
		    Flight flight = null;
		    ResultSet rs = null;

		    try {
		        String query = "SELECT * FROM flight WHERE flight_no = ? AND flight_status = 1";
		        con = ConnectionUtil.getConnection();
		        ps = con.prepareStatement(query);
		        ps.setString(1, flightNo);

		        rs = ps.executeQuery();

		        if (rs.next()) {
		           
		            flight.setId(rs.getInt("id"));
		            flight.setSrc(rs.getString("src"));
		            flight.setDestination(rs.getString("destination"));
		            flight.setAirlineCode(rs.getString("airline_code"));
		            flight.setFlightNo(rs.getString("flight_no"));
		            flight.setDayId(rs.getInt("day_id"));
		            flight.setFlightStatus(rs.getBoolean("flight_status"));
		            flight.setFlightTime(rs.getTime("flight_time"));
		            flight.setNoOfSeats(rs.getInt("no_of_seats"));

		           
		        }

		    } catch (SQLException e) {
		        System.out.println(e.getMessage());
		        throw new RuntimeException(e);
		    } finally {
		        ConnectionUtil.close(con, ps, rs);
		    }

		    return flight;
	}

	@Override
	public List<Flight> findByAirLineCode(String airLine) {
		Connection con = null;
		PreparedStatement ps = null;
		List<Flight> FlightList = new ArrayList<>();
		ResultSet rs = null;

		try {
			String query = "SELECT * FROM flight WHERE airline_code=? and flight_status= 1 ";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			 ps.setString(1, airLine);
			rs = ps.executeQuery(query);

			while (rs.next()) {

				Flight flight=new Flight();
				flight.setId(rs.getInt("id"));
				flight.setSrc(rs.getString("src"));
				flight.setDestination(rs.getString("destination"));
				flight.setAirlineCode(rs.getString("airline_code"));
				flight.setFlightNo(rs.getString("flight_no"));
				flight.setDayId(rs.getInt("day_id"));
				flight.setFlightStatus(rs.getBoolean("flight_status"));
				flight.setFlightTime(rs.getTime("flight_time"));
				flight.setNoOfSeats(rs.getInt("no_of_seats"));
				
				FlightList.add(flight);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		} finally {
			ConnectionUtil.close(con, ps, rs);
		}

		return FlightList;
	}

	@Override
	public List<Flight> findAllBySource(String src) {
		 Connection con = null;
		    PreparedStatement ps = null;
		    List<Flight> flightList = new ArrayList<>();
		    ResultSet rs = null;

		    try {
		        String query = "SELECT * FROM flight WHERE flight_status = 1 AND src = ?";
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
		            flight.setDayId(rs.getInt("day_id"));
		            flight.setFlightStatus(rs.getBoolean("flight_status"));
		            flight.setFlightTime(rs.getTime("flight_time"));
		            flight.setNoOfSeats(rs.getInt("no_of_seats"));
		            flightList.add(flight);
		        }

		    } catch (SQLException e) {
		        System.out.println(e.getMessage());
		        throw new RuntimeException();
		    } finally {
		        ConnectionUtil.close(con, ps, rs);
		    }

		    return flightList;
	}

	@Override
	public List<Flight> findAllBySourcAndDestination(String src, String des) {
		  Connection con = null;
		    PreparedStatement ps = null;
		    List<Flight> flightList = new ArrayList<>();
		    ResultSet rs = null;

		    try {
		        String query = "SELECT * FROM flight WHERE flight_status = 1 AND src = ? AND destination = ?";
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
		            flight.setDayId(rs.getInt("day_id"));
		            flight.setFlightStatus(rs.getBoolean("flight_status"));
		            flight.setFlightTime(rs.getTime("flight_time"));
		            flight.setNoOfSeats(rs.getInt("no_of_seats"));
		            flightList.add(flight);
		        }

		    } catch (SQLException e) {
		        System.out.println(e.getMessage());
		        throw new RuntimeException();
		    } finally {
		        ConnectionUtil.close(con, ps, rs);
		    }

		    return flightList;
	}

	@Override
	public List<Flight> findAllBySourcAndDestinationAndtime(String src, String des, String startTime) {
		   Connection con = null;
		    PreparedStatement ps = null;
		    List<Flight> flightList = new ArrayList<>();
		    ResultSet rs = null;
		    
		    String timeStr = startTime ;
	        
	        Time time = Time.valueOf(timeStr);

		    try {
		        String query = "SELECT * FROM flight WHERE flight_status = 1 AND src = ? AND destination = ? AND flight_time >= ?";
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
		            flight.setDayId(rs.getInt("day_id"));
		            flight.setFlightStatus(rs.getBoolean("flight_status"));
		            flight.setFlightTime(rs.getTime("flight_time"));
		            flight.setNoOfSeats(rs.getInt("no_of_seats"));
		            flightList.add(flight);
		        }

		    } catch (SQLException e) {
		        System.out.println(e.getMessage());
		        throw new RuntimeException();
		    } finally {
		        ConnectionUtil.close(con, ps, rs);
		    }

		    return flightList;
	}

}
