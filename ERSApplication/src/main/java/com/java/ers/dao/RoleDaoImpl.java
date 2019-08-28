package com.java.ers.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.java.ers.utility.ConnectionUtil;

public class RoleDaoImpl implements RoleDao {
	
	@Override
	/**
	 * Function to get the User Role based on the 
	 * id of the role. 
	 * 
	 * @param id of the user role
	 * @return user role of reimbursement
	 */
	public String getRole(int id) {
		String role = "";

		try {

			// Get Connection
			Connection connection = ConnectionUtil.getConnection();

			// SQL
			String sql = "Select USER_ROLE from USER_ROLES " + 
						"Where ERS_USER_ROLE_ID=" + id;

			// use of statement
			Statement stmt = connection.createStatement();

			// Result set
			ResultSet rs = stmt.executeQuery(sql);

			// iterate result set.
			while (rs.next()) {
				role = rs.getString("USER_ROLE");
			}

			// close connection
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return role;
	}
	
	/**
	 * Function to fetch the id of the given User Role. 
	 * 
	 * @param Role of the user
	 * @return id of the user role
	 */
	@Override
	public int getRoleId(String role) {
		int id = -1;

		try {

			// Get Connection
			Connection connection = ConnectionUtil.getConnection();

			// SQL
			String sql = "Select ERS_USER_ROLE_ID from USER_ROLES " + 
			"Where USER_ROLE='" + role + "'";

			// use of statement
			Statement stmt = connection.createStatement();

			// Result set
			ResultSet rs = stmt.executeQuery(sql);

			// iterate result set.
			while (rs.next()) {
				id = rs.getInt("ERS_USER_ROLE_ID");
			}

			// close connection
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return id;
	}
	
}
