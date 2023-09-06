package in.fssa.aviease.util;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import io.github.cdimascio.dotenv.Dotenv;

public class ConnectionUtil {

	
	  /**
     * Establishes a database connection using environment variables.
     *
     * @return A Connection object representing the database connection.
     * @throws RuntimeException If connection setup or configuration fails.
     */
	public static Connection getConnection() {
		
		String url;
        String userName;
        String passWord;

//        
            url = System.getenv("DATABASE_HOSTNAME");
            userName = System.getenv("DATABASE_USERNAME");
            passWord = System.getenv("DATABASE_PASSWORD");
//     
//        	 url ="jdbc:mysql://localhost:3306/aviease";
//    		userName ="root";
//    		 passWord ="123456";
    		
        
		
		
		Connection connection = null;
		
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			//connection = DriverManager.getConnection(url, userName, password);
			Class.forName("com.mysql.cj.jdbc.Driver");
			 connection = DriverManager.getConnection(url,userName,passWord);

			 
		} catch (Exception e) {

			e.printStackTrace();
			throw new RuntimeException(e);

		}

		return connection;

	}
	
	  /**
     * Closes the database connection and PreparedStatement.
     *
     * @param connection The Connection object to be closed.
     * @param ps The PreparedStatement object to be closed.
     */

	public static void close(Connection connection, PreparedStatement ps) {

		try {
			if (ps != null) {
				ps.close();
			}
			if (connection != null) {
				connection.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	 /**
     * Closes the database connection, PreparedStatement, and ResultSet.
     *
     * @param connection The Connection object to be closed.
     * @param ps The PreparedStatement object to be closed.
     * @param rs The ResultSet object to be closed.
     */
	public static void close(Connection connection, PreparedStatement ps, ResultSet rs) {

		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (connection != null) {
				connection.close();
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	

}
