package in.fssa.aviease.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.fssa.aviease.exception.PersistenceException;
import in.fssa.aviease.interfaces.UserInterface;
import in.fssa.aviease.model.User;
import in.fssa.aviease.util.ConnectionUtil;


public class UserDAO implements UserInterface{

	@Override
	public List<User> findAll() throws PersistenceException {
		Connection con = null;
		PreparedStatement ps = null;
		List<User> userList = new ArrayList<>();
		ResultSet rs = null;

		try {
			String query = "SELECT id, first_name, last_name, email, mobile_number, password FROM users";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);

			rs = ps.executeQuery(query);

			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setFirstname(rs.getString("first_name"));
				user.setLastname(rs.getString("last_name"));
				user.setEmail(rs.getString("email"));
				user.setMobileNo(rs.getLong("mobile_number"));
				user.setPassword(rs.getString("password"));

				userList.add(user);
			}

		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			ConnectionUtil.close(con, ps, rs);
		}

		return userList;

	}

	@Override
	public void create(User user) throws PersistenceException {

		
		Connection con = null;
		PreparedStatement ps = null;
		

		try {
			String query = "INSERT INTO users (first_name, last_name, email, password,mobile_number) VALUES (?, ?, ?, ?,?);";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1,user.getFirstname() );
			ps.setString(2,user.getLastname() );
			ps.setString(3,user.getEmail() );
			ps.setString(4,user.getPassword() );
			ps.setLong(5,user.getMobileNo() );
			ps.executeUpdate();
	
			

		} catch (SQLException e) {
			 e.printStackTrace();
			if (e.getMessage().contains("Duplicate entry")) {
				throw new RuntimeException("Duplicate constraint");
			} else {
				throw new PersistenceException(e.getMessage());
			}
		} finally {
			ConnectionUtil.close(con, ps);
		}

	
	}



	@Override
	public void update(int id, User newUser) throws PersistenceException {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			String query = "UPDATE users SET first_name = ?,last_name = ? Where id = ?";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, newUser.getFirstname());
			ps.setString(2, newUser.getLastname());
			ps.setInt(3,id);

			ps.executeUpdate();

			System.out.println("User Successfully Updated :)");

		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException(e.getMessage());
		} finally {
			ConnectionUtil.close(con, ps);
		}
	}

	
	
	@Override
	public void delete(int id) {
		
	}
	
	

	@Override
	public User findById(int id) throws PersistenceException {
		
		Connection con = null;
		PreparedStatement ps = null;
		User user = null;
		ResultSet rs = null;

		try {
			String query = "SELECT id, first_name, last_name, email, mobile_number, password FROM users WHERE id = ?";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);			
			ps.setInt(1, id);
			rs = ps.executeQuery();
	

			if (rs.next()) {

				user = new User();

				user.setId(rs.getInt("id"));
				user.setFirstname(rs.getString("first_name"));
				user.setLastname(rs.getString("last_name"));
				user.setEmail(rs.getString("email"));
				user.setMobileNo(rs.getLong("mobile_number"));
				user.setPassword(rs.getString("password"));

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new PersistenceException(e.getMessage());
		} finally {
			ConnectionUtil.close(con, ps, rs);
		}

		return user;

	}

	@Override
	public User findByEmail(String email) throws PersistenceException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;

		try {
			String query = "SELECT id, first_name, last_name, email, mobile_number, password FROM users WHERE email = ?";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();

			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setFirstname(rs.getString("first_name"));
				user.setLastname(rs.getString("last_name"));
				user.setEmail(rs.getString("email"));
				user.setMobileNo(rs.getLong("mobile_number"));
				user.setPassword(rs.getString("password"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException(e.getMessage());
		} finally {
			ConnectionUtil.close(con, ps, rs);
		}

		return user;
	}

	@Override
	public User findByMobileNo(long mobileNo) throws PersistenceException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		User user = null;

		try {
			String query = "SELECT id, first_name, last_name, email, mobile_number, password FROM users WHERE mobile_number = ?";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			ps.setLong(1, mobileNo);
			rs = ps.executeQuery();

			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setFirstname(rs.getString("first_name"));
				user.setLastname(rs.getString("last_name"));
				user.setEmail(rs.getString("email"));
				user.setMobileNo(rs.getLong("mobile_number"));
				user.setPassword(rs.getString("password"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException(e.getMessage());
		} finally {
			ConnectionUtil.close(con, ps, rs);
		}

		return user;
	}

	@Override
	public int count() throws PersistenceException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;

		
		try {
			String query = "SELECT * FROM users";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new PersistenceException(e.getMessage());
		} finally {
			ConnectionUtil.close(con, ps, rs);
		}
		return count;
	}

}
