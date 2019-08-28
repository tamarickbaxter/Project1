package com.java.ers.dao;

/**
 * Interface to represent StatusDao Layer. 
 * 
 * @author
 *
 */

public interface StatusDao {
	
	/**
	 * Function to get the type of Reimbursement Status based on the 
	 * id of the Status. 
	 * 
	 * @param id of the status
	 * @return status of reimbursement
	 */
	public String getStatus(int id);
	
	/**
	 * Function to fetch the id of the given Status. 
	 * 
	 * @param status of reimbursement
	 * @return id of the status
	 */
	public int getStatusId(String status);
}
