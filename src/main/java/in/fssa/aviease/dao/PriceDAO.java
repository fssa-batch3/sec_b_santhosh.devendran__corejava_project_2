package in.fssa.aviease.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Result;

import in.fssa.aviease.exception.PersistenceException;
import in.fssa.aviease.exception.ValidationException;
import in.fssa.aviease.interfaces.PriceInterface;
import in.fssa.aviease.model.Price;
import in.fssa.aviease.util.ConnectionUtil;

public class PriceDAO implements PriceInterface{

	@Override
	public List<Price> findAll() throws PersistenceException {
	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    List<Price> priceList = new ArrayList<>();

	    try {
	        String query = "SELECT id, start_date, end_date, flight_id, price FROM price";
	        con = ConnectionUtil.getConnection();
	        ps = con.prepareStatement(query);
	        rs =  ps.executeQuery();

	        while (rs.next()) {
	            Price price = new Price();
	            price.setId(rs.getInt("id"));
	            price.setStartDateFormat(rs.getDate("start_date").toLocalDate());
	            price.setEndDateFormat(rs.getDate("end_date").toLocalDate());
	            price.setFlightId(rs.getString("flight_id"));
	            price.setPrice(Double.parseDouble(rs.getBigDecimal("price").toString()));
	            priceList.add(price);
	        }
	    } catch (SQLException e) {
	        throw new PersistenceException(e.getMessage());
	    } finally {
	        ConnectionUtil.close(con, ps, rs);
	    }

	    return priceList;
	}


	@Override
	public void create(Price price) throws PersistenceException {
	    Connection con = null;
	    PreparedStatement ps = null;
	    

	    try {
	        String query = "INSERT INTO price (start_date, end_date, flight_id, price) VALUES (?, ?, ?, ?)";
	        con = ConnectionUtil.getConnection();
	        ps = con.prepareStatement(query);
	        ps.setDate(1, Date.valueOf(price.getStartDate())); 
	        ps.setDate(2, Date.valueOf(price.getEndDate()));   
	        ps.setString(3, price.getFlightId());
	        ps.setBigDecimal(4, new BigDecimal(Double.toString(price.getPrice())));
	        int result=ps.executeUpdate();
	        
	        if(result>0) {
	        	System.out.println("price created  sucessfully");
	        }
	        
	    } catch (SQLException e) {
	        throw new PersistenceException(e.getMessage());
	    } finally {
	        ConnectionUtil.close(con, ps);
	    }
	}


	@Override
	public void update(int id, Price price) throws PersistenceException {
	    Connection con = null;
	    PreparedStatement ps = null;

	    try {
	        String query = "UPDATE price SET start_date = ?, end_date = ?, flight_id = ?, price = ? WHERE id = ?";
	        con = ConnectionUtil.getConnection();
	        ps = con.prepareStatement(query);
	        ps.setDate(1, Date.valueOf(price.getStartDate())); 
	        ps.setDate(2, Date.valueOf(price.getEndDate()));  
	        ps.setString(3, price.getFlightId());
	        ps.setBigDecimal(4, new BigDecimal(Double.toString(price.getPrice())));
	        ps.setInt(5, id);
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        throw new PersistenceException(e.getMessage());
	    } finally {
	        ConnectionUtil.close(con, ps);
	    }
	}


	@Override
	public void delete(int id) throws PersistenceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Price findById(int id) throws PersistenceException {
	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    Price price = null;

	    try {
	        String query = "SELECT id, start_date, end_date, flight_id, price FROM price WHERE id = ?";
	        con = ConnectionUtil.getConnection();
	        ps = con.prepareStatement(query);
	        ps.setInt(1, id);
	        rs = ps.executeQuery();

	        if (rs.next()) {
	            price = new Price();
	            price.setId(rs.getInt("id"));
	            price.setStartDateFormat(rs.getDate("start_date").toLocalDate());
	            price.setEndDateFormat(rs.getDate("end_date").toLocalDate());
	            price.setFlightId(rs.getString("flight_id"));
	            price.setPrice(Double.parseDouble(rs.getBigDecimal("price").toString()));
	        }
	    } catch (SQLException e) {
	        throw new PersistenceException(e.getMessage());
	    } finally {
	        ConnectionUtil.close(con, ps, rs);
	    }

	    return price;
	}


	@Override
	public List<Price> findByFlightId(String flightId) throws PersistenceException {
	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    List<Price> priceList = new ArrayList<>();
	    Price price = null;

	    try {
	        String query = "SELECT id, start_date, end_date, flight_id, price FROM price WHERE flight_id = ?";
	        con = ConnectionUtil.getConnection();
	        ps = con.prepareStatement(query);
	        ps.setString(1, flightId);
	        rs = ps.executeQuery();

	        if (rs.next()) {
	            price = new Price();
	            price.setId(rs.getInt("id"));
	            price.setStartDateFormat(rs.getDate("start_date").toLocalDate());
	            price.setEndDateFormat(rs.getDate("end_date").toLocalDate());
	            price.setFlightId(rs.getString("flight_id"));
	            price.setPrice(Double.parseDouble(rs.getBigDecimal("price").toString()));
	            priceList.add(price);
	        }
	    } catch (SQLException e) {
	        throw new PersistenceException(e.getMessage());
	    } finally {
	        ConnectionUtil.close(con, ps, rs);
	    }

	    return priceList;
	}


	@Override
	public Price findByDateAndFlightNo(LocalDate date, String flightNo) throws PersistenceException {
	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    Price price = null;

	    try {
	        String query = "SELECT id, start_date, end_date, flight_id, price FROM price WHERE ? BETWEEN start_date AND end_date AND flight_id = ?";
	        con = ConnectionUtil.getConnection();
	        ps = con.prepareStatement(query);
	        ps.setDate(1, java.sql.Date.valueOf(date));
	        ps.setString(2, flightNo);
	        rs = ps.executeQuery();

	        if (rs.next()) {
	            price = new Price();
	            price.setId(rs.getInt("id"));
	            price.setStartDateFormat(rs.getDate("start_date").toLocalDate());
	            price.setEndDateFormat(rs.getDate("end_date").toLocalDate());
	            price.setFlightId(rs.getString("flight_id"));
	            price.setPrice(Double.parseDouble(rs.getBigDecimal("price").toString()));
	        }
	    } catch (SQLException e) {
	        throw new PersistenceException(e.getMessage());
	    } finally {
	        ConnectionUtil.close(con, ps, rs);
	    }

	    return price;
	}


}
