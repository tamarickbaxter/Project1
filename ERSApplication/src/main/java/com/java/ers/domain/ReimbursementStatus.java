package com.java.ers.domain;

/**
 * Class to represent the Status of the Reimbursement, it includes
 * status id and status. 
 * 
 * @author
 *
 */

public class ReimbursementStatus {

	/** instance fields **/
	private int statusId;
	private String status;
	
	/**
	 * default constructor to setup and initialize the ReimbursementStatus
	 * object with default values. 
	 */
	public ReimbursementStatus() {
		super();
	}

	/**
	 * Parameter constructor to setup and initialize the ReimbursementStatus
	 * object with given parameter values passed to the constructor as parameter. 
	 * 
	 * @param statusId of the ReimbursementStatus object.
	 * @param status of the ReimbursementStatus object.
	 */
	public ReimbursementStatus(int statusId, String status) {
		super();
		this.statusId = statusId;
		this.status = status;
	}

	/**
	 * Function to get the status id of the ReimbursementStatus object.
	 * 
	 * @return the statusId
	 */
	public int getStatusId() {
		return statusId;
	}

	/**
	 * Function to set or update the status id of the ReimbursementStatus object.
	 * 
	 * @param statusId the statusId to set
	 */
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	/**
	 * Function to get the status of the ReimbursementStatus object.
	 * 
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Function to set or update the status of the ReimbursementStatus object.
	 * 
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}
