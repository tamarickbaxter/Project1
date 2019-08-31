package com.java.ers.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.java.ers.utility.ConnectionUtil;

/**
 * Class to implement the contract of the StatusDao layer.
 * 
 * @author
 *
 */
public class StatusDaoImpl implements StatusDao {

	@Override
	/**
	 * Function to get the type of Reimbursement Status based on the id of the
	 * Status.
	 * 
	 * @param id of the status
	 * @return status of reimbursement
	 */
	public String getStatus(int id) {
		String status = "";

		try {

			// Get Connection
			Connection connection = ConnectionUtil.getConnection();

			// SQL
			String sql = "Select reimb_status from ers_reimbursement_status " + 
						"Where reimb_status_id=" + id;

			// use of statement
			Statement stmt = connection.createStatement();

			// Result set
			ResultSet rs = stmt.executeQuery(sql);

			// iterate result set.
			while (rs.next()) {
				status = rs.getString("reimb_status");
			}

			// close connection
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	@Override
	/**
	 * Function to fetch the id of the given Status.
	 * 
	 * @param status of reimbursement
	 * @return id of the status
	 */
	public int getStatusId(String status) {
		int id = -1;

		try {

			// Get Connection
			Connection connection = ConnectionUtil.getConnection();

			// SQL
			String sql = "Select reimb_status_id from ers_reimbursement_status " + 
			"Where reimb_status='" + status + "'";

			// use of statement
			Statement stmt = connection.createStatement();

			// Result set
			ResultSet rs = stmt.executeQuery(sql);

			// iterate result set.
			while (rs.next()) {
				id = rs.getInt("reimb_status_id");
			}

			// close connection
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return id;
	}

}
