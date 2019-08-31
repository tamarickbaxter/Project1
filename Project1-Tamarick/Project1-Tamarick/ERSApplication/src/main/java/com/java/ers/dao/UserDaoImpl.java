package com.java.ers.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import com.java.ers.domain.User;
import com.java.ers.utility.ConnectionUtil;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

	@Override
	/**
	 * Function to check the login of the user. If the user exist with the given
	 * login credentials, return true otherwise return false.
	 * 
	 * @param userName of the user
	 * @param password of the user
	 * @return true of login is successful, false otherwise.
	 */
	public boolean login(String userName, String password) {

		boolean valid = false;

		// SQL
		String sql = "SELECT * FROM ERS_Users WHERE  ERS_USERNAME=? AND ERS_PASSWORD=?";

		// using Prepared statement
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			// set parameters
			ps.setString(1, userName);
			ps.setString(2, password);

			// Get the result set
			ResultSet rs = ps.executeQuery();

			// Traverse the Result Set
			while (rs.next()) {
				valid = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return valid;

	}

	@Override
	/**
	 * Function to load the user data into the User Object and return it. If no such
	 * user exist, return null.
	 * 
	 * @param userName of the user
	 * @param password of the user
	 * @return user if user exist, null otherwise.
	 */
	public User getUser(String userName, String password) {
		User user = null;

		// SQL
		String sql = "SELECT * FROM ERS_Users WHERE  ERS_USERNAME=? AND ERS_PASSWORD=?";

		// using Prepared statement
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			// set parameters
			ps.setString(1, userName);
			ps.setString(2, password);

			// Get the result set
			ResultSet rs = ps.executeQuery();

			// Traverse the Result Set
			while (rs.next()) {
				int userId = rs.getInt("ERS_USER_ID");
				String firstName = rs.getString("USER_FIRST_NAME");
				String lastName = rs.getString("USER_LAST_NAME");
				String email = rs.getString("USER_EMAIL");
				int roleId = rs.getInt("USER_ROLE_ID");
				user = new User(userId, userName, password, firstName, lastName, email, roleId);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	@Override
	/**
	 * Function to load the user data into the User Object and return it. If no such
	 * user exist, return null.
	 * 
	 * @param userId of the user
	 * @return user if user exist, null otherwise.
	 */
	public User getUser(int userId) {
		User user = null;

		// SQL
		String sql = "SELECT * FROM ERS_Users WHERE  ERS_USER_ID=?";

		// using Prepared statement
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			// set parameters
			ps.setInt(1, userId);
			
			// Get the result set
			ResultSet rs = ps.executeQuery();

			// Traverse the Result Set
			while (rs.next()) {
				String firstName = rs.getString("USER_FIRST_NAME");
				String lastName = rs.getString("USER_LAST_NAME");
				String email = rs.getString("USER_EMAIL");
				int roleId = rs.getInt("USER_ROLE_ID");
				user = new User(userId, "", "", firstName, lastName, email, roleId);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}
