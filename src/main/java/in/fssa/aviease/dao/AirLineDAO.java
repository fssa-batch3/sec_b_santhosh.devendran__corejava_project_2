package in.fssa.aviease.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.fssa.aviease.exception.PersistenceException;
import in.fssa.aviease.interfaces.AirLineInterface;
import in.fssa.aviease.model.AirLine;
import in.fssa.aviease.util.ConnectionUtil;

public class AirLineDAO implements AirLineInterface{

	private String airCode="airline_code";
	private String airName="airline_name";
	@Override
	public List<AirLine> findAll() throws PersistenceException {
		Connection con = null;
		PreparedStatement ps = null;
		List<AirLine> airLineList = new ArrayList<>();
		ResultSet rs = null;

		try {
			String query = "SELECT id, airline_name, airline_code FROM airlines;";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);

			rs = ps.executeQuery(query);

			while (rs.next()) {
				AirLine airLine=new AirLine();
				
				airLine.setId(rs.getInt("id"));
				airLine.setAirLineCode(rs.getString(airCode));
				airLine.setAirLineName(rs.getString(airName));
				
				airLineList.add(airLine);
			}

		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			ConnectionUtil.close(con, ps, rs);
		}

		return airLineList;
	}

	@Override
	public void create(AirLine airline) throws PersistenceException {
		
		        Connection con = null;
		        PreparedStatement ps = null;

		        try {
		            String query = "INSERT INTO airlines (airline_name, airline_code) VALUES (?, ?);";
		            con = ConnectionUtil.getConnection();
		            ps = con.prepareStatement(query);
		            ps.setString(1, airline.getAirLineName());
		            ps.setString(2, airline.getAirLineCode());
		            ps.executeUpdate();
		        } catch (SQLException e) {
		        	e.printStackTrace();
					throw new PersistenceException(e.getMessage());
		        } finally {
		            ConnectionUtil.close(con, ps);
		        }
		
	}

	@Override
	public void update(int id, AirLine t) throws PersistenceException {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			String query = "UPDATE airlines SET airline_name = ?,airline_code = ? Where id = ?";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, t.getAirLineName());
			ps.setString(2, t.getAirLineCode());
			ps.setInt(3,id);

			ps.executeUpdate();


		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException(e.getMessage());
		} finally {
			ConnectionUtil.close(con, ps);
		}
	}

	
	

	@Override
	public AirLine findById(int id) throws PersistenceException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		AirLine airLine = new AirLine();

		try {
		    String query = "SELECT id, airline_name, airline_code FROM airlines WHERE id=?";
		    con = ConnectionUtil.getConnection();
		    ps = con.prepareStatement(query);
		    ps.setInt(1, id); 

		    rs = ps.executeQuery();

		    while (rs.next()) {
		        airLine.setId(rs.getInt("id"));
		        airLine.setAirLineCode(rs.getString(airCode));
		        airLine.setAirLineName(rs.getString(airName));
		    }

		} catch (SQLException e) {
		    throw new PersistenceException(e.getMessage());
		} finally {
		    ConnectionUtil.close(con, ps, rs);
		}

		return airLine;

		
	}

	@Override
	public AirLine findByAirLineCode(String airLineCode) throws PersistenceException {
	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    AirLine airLine = null; 

	    try {
	        String query = "SELECT id, airline_name, airline_code FROM airlines WHERE airline_code = ? ";
	        con = ConnectionUtil.getConnection();
	        ps = con.prepareStatement(query);
	        ps.setString(1, airLineCode);
	        rs = ps.executeQuery();

	        while (rs.next()) {
	        	airLine=new AirLine();
	            airLine.setId(rs.getInt("id"));
	            airLine.setAirLineCode(rs.getString("airline_code"));
	            airLine.setAirLineName(rs.getString("airline_name"));
	        }

	    } catch (SQLException e) {
	        throw new PersistenceException(e.getMessage());
	    } finally {
	        ConnectionUtil.close(con, ps, rs);
	    }

	    return airLine;
	}

	@Override
	public void delete(int id) throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	


}
