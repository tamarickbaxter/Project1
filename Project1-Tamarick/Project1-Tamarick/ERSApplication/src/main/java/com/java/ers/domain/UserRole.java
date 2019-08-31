package com.java.ers.domain;

/**
 * Class to represent a User Role and encapsulates User Role Id
 * and Role
 *  
 * @author
 *
 */

public class UserRole {
	
	private int userRoleId;
	private String userRole;
	
	/**
	 * Constructor to create a UserRole Object from the default values. 
	 */
	public UserRole() {
		super();
	}

	/**
	 * Parameter constructor to setup and initialize the UserRole object
	 * with given parameter values. 
	 * 
	 * @param userRoleId of the UserRole Object 
	 * @param userRole of the UserRole Object
	 */
	public UserRole(int userRoleId, String userRole) {
		super();
		this.userRoleId = userRoleId;
		this.userRole = userRole;
	}

	/**
	 * function to get the User Role Id of the UserRole Object
	 * 
	 * @return the userRoleId
	 */
	public int getUserRoleId() {
		return userRoleId;
	}

	/**
	 * Function to set or update the userRoleId of the UserRole Object
	 * 
	 * @param userRoleId the userRoleId to set
	 */
	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	/**
	 * Function to get the User Role of the UserRole Object
	 * 
	 * @return the userRole
	 */
	public String getUserRole() {
		return userRole;
	}

	/**
	 * Function to set or update the UserRole of the UserRole Object
	 * 
	 * @param userRole the userRole to set
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	} 
}
