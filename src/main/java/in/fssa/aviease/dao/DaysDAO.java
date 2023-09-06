package in.fssa.aviease.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import in.fssa.aviease.exception.PersistenceException;
import in.fssa.aviease.interfaces.DaysInterface;
import in.fssa.aviease.model.Days;
import in.fssa.aviease.util.ConnectionUtil;

import java.util.ArrayList;

public class DaysDAO implements DaysInterface{

	private String flight="flight_no";
	
	
	@Override
	public List<Days> findAll() throws PersistenceException {
		  Connection con = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        List<Days> daysList = new ArrayList<>();

	        try {
	            String query = "SELECT id, flight_no, sun, mon, tue, wed, thu, fri, sat FROM days";
	            con = ConnectionUtil.getConnection();
	            ps = con.prepareStatement(query);
	            rs = ps.executeQuery();

	            while (rs.next()) {
	                Days day = new Days();
	                day.setId(rs.getInt("id"));
	                day.setFlightNo(rs.getString(flight));
	                day.setSun(rs.getBoolean("sun"));
	                day.setMon(rs.getBoolean("mon"));
	                day.setTue(rs.getBoolean("tue"));
	                day.setWed(rs.getBoolean("wed"));
	                day.setThu(rs.getBoolean("thu"));
	                day.setFri(rs.getBoolean("fri"));
	                day.setSat(rs.getBoolean("sat"));
	                daysList.add(day);
	            }
	        } catch (SQLException e) {
	            throw new PersistenceException(e.getMessage());
	        } finally {
	            ConnectionUtil.close(con, ps, rs);
	        }

	        return daysList;
	    }

	@Override
	public void create(Days days) throws PersistenceException {
		  Connection con = null;
	        PreparedStatement ps = null;

	        try {
	            String query = "INSERT INTO days (flight_no, sun, mon, tue, wed, thu, fri, sat) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	            con = ConnectionUtil.getConnection();
	            ps = con.prepareStatement(query);
	            ps.setString(1, days.getFlightNo());
	            ps.setBoolean(2, days.getSun());
	            ps.setBoolean(3, days.getMon());
	            ps.setBoolean(4, days.getTue());
	            ps.setBoolean(5, days.getWed());
	            ps.setBoolean(6, days.getThu());
	            ps.setBoolean(7, days.getFri());
	            ps.setBoolean(8, days.getSat());

	            ps.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new PersistenceException(e.getMessage());
	        } finally {
	            ConnectionUtil.close(con, ps);
	        }
	    }


	@Override
	public void update(int id, Days days) throws PersistenceException {
		   Connection con = null;
	        PreparedStatement ps = null;

	        try {
	            String query = "UPDATE days SET flight_no = ?, sun = ?, mon = ?, tue = ?, wed = ?, thu = ?, fri = ?, sat = ? WHERE id = ?";
	            con = ConnectionUtil.getConnection();
	            ps = con.prepareStatement(query);
	            ps.setString(1,days.getFlightNo());
	            ps.setBoolean(2, days.getSun());
	            ps.setBoolean(3, days.getMon());
	            ps.setBoolean(4, days.getTue());
	            ps.setBoolean(5, days.getWed());
	            ps.setBoolean(6,  days.getThu());
	            ps.setBoolean(7, days.getFri());
	            ps.setBoolean(8, days.getSat());
	            ps.setInt(9, id);

	            ps.executeUpdate();

	            

	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new PersistenceException(e.getMessage());
	        } finally {
	            ConnectionUtil.close(con, ps);
	        }
	    }

	

	@Override
	public void delete(int id) throws PersistenceException {
		
	}

	@Override
	public Days findById(int id) throws PersistenceException {
		
	        Connection con = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        Days day = null;

	        try {
	            String query = "SELECT id, flight_no, sun, mon, tue, wed, thu, fri, sat FROM days WHERE id = ?";
	            con = ConnectionUtil.getConnection();
	            ps = con.prepareStatement(query);
	            ps.setInt(1, id);
	            rs = ps.executeQuery();

	            if (rs.next()) {
	                day = new Days();
	                day.setId(rs.getInt("id"));
	                day.setFlightNo(rs.getString(flight));
	                day.setSun(rs.getBoolean("sun"));
	                day.setMon(rs.getBoolean("mon"));
	                day.setTue(rs.getBoolean("tue"));
	                day.setWed(rs.getBoolean("wed"));
	                day.setThu(rs.getBoolean("thu"));
	                day.setFri(rs.getBoolean("fri"));
	                day.setSat(rs.getBoolean("sat"));
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new PersistenceException(e.getMessage());
	        } finally {
	            ConnectionUtil.close(con, ps, rs);
	        }

	        return day;
	}

	@Override
	public Days findByFlightNo(String flightNo) throws PersistenceException {
		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Days day = null;

        try {
            String query = "SELECT id, flight_no, sun, mon, tue, wed, thu, fri, sat FROM days WHERE flight_no = ?";
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, flightNo);
            rs = ps.executeQuery();

            if (rs.next()) {
                day = new Days();
                day.setId(rs.getInt("id"));
                day.setFlightNo(rs.getString(flight));
                day.setSun(rs.getBoolean("sun"));
                day.setMon(rs.getBoolean("mon"));
                day.setTue(rs.getBoolean("tue"));
                day.setWed(rs.getBoolean("wed"));
                day.setThu(rs.getBoolean("thu"));
                day.setFri(rs.getBoolean("fri"));
                day.setSat(rs.getBoolean("sat"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new PersistenceException(e.getMessage());
        } finally {
            ConnectionUtil.close(con, ps, rs);
        }

        return day;
	}



}
