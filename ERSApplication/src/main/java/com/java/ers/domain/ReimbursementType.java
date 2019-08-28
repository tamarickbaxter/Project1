package com.java.ers.domain;

/**
 * Class to represent a ReimbursementType, it encapsualtes the 
 * type id and the type. 
 * 
 * @author
 *
 */

public class ReimbursementType {
	
	/** Instance Fields **/
	private int typeId;
	private String type;
	
	/**
	 * Default constructor to create the ReimbursementType Object with 
	 * default values. 
	 */
	public ReimbursementType() {
		super();
	}

	/**
	 * Parameter constructor to create and initialize the ReimbursementType Object
	 * with given type id and type to initialize the fields. 
	 * 
	 * @param typeId of the ReimbursementType Object.
	 * @param type of the ReimbursementType Object.
	 */
	public ReimbursementType(int typeId, String type) {
		super();
		this.typeId = typeId;
		this.type = type;
	}

	/**
	 * Function to get the Type Id of the ReimbursementType Object.
	 * 
	 * @return the typeId
	 */
	public int getTypeId() {
		return typeId;
	}

	/**
	 * Function to set or update the type id of the ReimbursementType Object.
	 * 
	 * @param typeId the typeId to set
	 */
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	/**
	 * Function to get the type of the ReimbursementType Object.
	 * 
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Function to set or update the type of the ReimbursementType Object.
	 * 
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	} 
}
