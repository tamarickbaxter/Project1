package com.java.ers.domain;

import java.sql.Timestamp;

/**
 * Class the represent a Reimbursement Object, it includes many fields
 * related to the Reimbursement information. 
 * 
 * @author
 *
 */
public class Reimbursement {
	
	/** Instance Fields **/
	private int id;
	private double amount;
	private Timestamp submitted;
	private Timestamp resolved;
	private String description; 
	private int authorId;
	private int resolverId;
	private int statusId;
	private int typeId;
	
	/**
	 * Default constructor to setup and initialize the Reimbursement
	 * Object with default values.  
	 */
	public Reimbursement() {
		super();
	}

	/**
	 * Parameter constructor to setup and initialize the Reimbursement
	 * Object with given parameter values for all the data attributes. 
	 * 
	 * @param id of the Reimbursement Object.
	 * @param amount of the Reimbursement Object.
	 * @param submitted of the Reimbursement Object.
	 * @param resolved of the Reimbursement Object.
	 * @param description of the Reimbursement Object.
	 * @param authorId of the Reimbursement Object.
	 * @param resolverId of the Reimbursement Object.
	 * @param statusId of the Reimbursement Object.
	 * @param typeId of the Reimbursement Object.
	 */
	public Reimbursement(int id, double amount, Timestamp submitted, Timestamp resolved, String description,
			int authorId, int resolverId, int statusId, int typeId) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.authorId = authorId;
		this.resolverId = resolverId;
		this.statusId = statusId;
		this.typeId = typeId;
	}

	/**
	 * Function to get the id of the Reimbursement Object.
	 * 
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Function to set or update the id of the Reimbursement Object.
	 * 
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Function to get the amount of the Reimbursement Object.
	 * 
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * Function to set or update the amount of the Reimbursement Object.
	 * 
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * Function to get the Submitted time stamp of the Reimbursement Object.
	 * 
	 * @return the submitted
	 */
	public Timestamp getSubmitted() {
		return submitted;
	}

	/**
	 * Function to set or update the submitted time stamp of the Reimbursement Object.
	 * 
	 * @param submitted the submitted to set
	 */
	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted;
	}

	/**
	 * Function to get the resolve time stamp of the Reimbursement Object.
	 * 
	 * @return the resolved
	 */
	public Timestamp getResolved() {
		return resolved;
	}

	/**
	 * Function to set or update the resolve time stamp of the Reimbursement Object.
	 * 
	 * @param resolved the resolved to set
	 */
	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}

	/**
	 * Function to get the description of the Reimbursement Object.
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Function to set or update the description of the Reimbursement Object.
	 * 
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Function to get the id of the user who created this Reimbursement Object.
	 * 
	 * @return the authorId
	 */
	public int getAuthorId() {
		return authorId;
	}

	/**
	 * Function to set or update the id of this user who created this Reimbursement Object.
	 * 
	 * @param authorId the authorId to set
	 */
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	/**
	 * Function to get the id of the finance manager who settled or 
	 * resolved  this Reimbursement Object.
	 * 
	 * @return the resolverId
	 */
	public int getResolverId() {
		return resolverId;
	}

	/**
	 * Function to set or update the id of the finance manager who 
	 * settled or resolved this Reimbursement Object.
	 * 
	 * @param resolverId the resolverId to set
	 */
	public void setResolverId(int resolverId) {
		this.resolverId = resolverId;
	}

	/**
	 * function to get the id of the status of the Reimbursement Object.
	 * 
	 * @return the statusId
	 */
	public int getStatusId() {
		return statusId;
	}

	/**
	 * Function to get or set the Id of the status of the Reimbursement Object.
	 * 
	 * @param statusId the statusId to set
	 */
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	/**
	 * Function to get the type of the Reimbursement Object.
	 * 
	 * @return the typeId
	 */
	public int getTypeId() {
		return typeId;
	}

	/**
	 * Function to set or update the type of the Reimbursement Object.
	 * 
	 * @param typeId the typeId to set
	 */
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
}
