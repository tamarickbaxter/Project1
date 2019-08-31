package com.java.ers.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.java.ers.utility.ConnectionUtil;

/**
 * Class to implement the contract of TypeDao Layer. 
 * 
 * @author
 *
 */

public class TypeDaoImpl implements TypeDao {

	@Override
	/**
	 * Function to get the type of Reimbursement based on the 
	 * id of the type. 
	 * 
	 * @param id of the type
	 * @return type of reimbursement
	 */
	public String getType(int id) {
		
		String type = ""; 
		
		try {
			
			// Get Connection
			Connection connection = ConnectionUtil.getConnection();
			
			// Sql
			String sql = "Select reimb_type from ers_reimbursement_type " + 
			   "Where reimb_type_id=" + id;
			
			// use of statement
			Statement stmt = connection.createStatement();
			
			// Result set
			ResultSet rs = stmt.executeQuery(sql);
			
			// iterate result set. 
			while(rs.next()) {
				type = rs.getString("reimb_type");
			}
			
			// close connection
			connection.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return type;
	}

	@Override
	/**
	 * Function to fetch the id of the given Type. 
	 * 
	 * @param type of reimbursement
	 * @return id of the type
	 */
	public int getTypeId(String type) {
		
		int id = -1; 
		
		try {
			
			// Get Connection
			Connection connection = ConnectionUtil.getConnection();
			
			// SQL
			String sql = "Select reimb_type_id from ers_reimbursement_type " + 
			   "Where reimb_type='" + type + "'";
			
			// use of statement
			Statement stmt = connection.createStatement();
			
			// Result set
			ResultSet rs = stmt.executeQuery(sql);
			
			// iterate result set. 
			while(rs.next()) {
				id = rs.getInt("reimb_type_id");
			}
			
			// close connection
			connection.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return id;
	}
}
