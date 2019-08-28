package com.java.ers.dao;

import java.util.List;
import com.java.ers.domain.Reimbursement;

/**
 * class to provide a contract for the ReimbursementDao layer for the interaction
 * between the reimbursement entity and the database. 
 * 
 * @author
 *
 */

public interface ReimbursementDao {
	
	/**
	 * Function to store new Reimbursement object into the database. 
	 * 
	 * @param reimb object going to be stored into database. 
	 * @return true if stored, false otherwise
	 */
	public boolean insertReimbursement(Reimbursement reimb);
	
	/**
	 * Function update the status of the Reimbursement Object inside the database.
	 * 
	 * @param id to identify the reimbursement
	 * @param resId resolver id 
	 * @param statusId to update the status of this reimbursement
	 * @return true if updated, false otherwise
	 */
	public boolean updateStatus(int id, int resId, int statusId);
	
	/**
	 * Function to get the collection of all the Reimbursements for a given user
	 * identified by the user id. The user is the one who submitted this reimbursement.  
	 * 
	 * @param userId to identify the user
	 * @return list of all the reimbursements
	 */
	public List<Reimbursement> getReimbursementsByUserId(int userId);
	
	/**
	 * Function to get the collection of all the Reimbursements stored inside the database. 
	 * 
	 * @return all the reimbursements
	 */
	public List<Reimbursement> getAllReimbursements();
	
	/**
	 * Function to get the List of all the Reimbursements identified by status id. 
	 * 
	 * @param statusId to filter the reimbursements
	 * @return list of all the reimbursements of given status. 
	 */
	public List<Reimbursement> getReimbursementsByStatus(int statusId);
	
	/**
	 * Function to get the next max Id for Reimbursement table. 
	 * 
	 * @return next id
	 */
	public int getNextId();
	
	public void delete();
}
