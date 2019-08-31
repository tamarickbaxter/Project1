package com.java.ers.dao;

/*
 * Interface to represents the ImbursementType database layer. 
 */

public interface TypeDao {

	/**
	 * Function to get the type of Reimbursement based on the 
	 * id of the type. 
	 * 
	 * @param id of the type
	 * @return type of reimbursement
	 */
	public String getType(int id);
	
	/**
	 * Function to fetch the id of the given Type. 
	 * 
	 * @param type of reimbursement
	 * @return id of the type
	 */
	public int getTypeId(String type);
}
