package com.java.ers.domain;

/**
 * Class to represent the User of the ERS System. User class will
 * encapsulates the Person and login credentials of the user. 
 * 
 * @author
 *
 */

public class User {
	
	/** Instance fields **/
	private int userId;
	private String userName;
	private String password; 
	private String firstName;
	private String lastName;
	private String email; 
	private int userRoleId;
	
	
	/**
	 * Default constructor to setup the User object with default values.   
	 */
	public User() {
		super();
	}
	
	/**
	 * Parameter constructor to setup and initialize the User Object with
	 * given parameter values passed to the constructor as parameter. 
	 * 
	 * @param userId of the User Object.
	 * @param userName of the User Object.
	 * @param password of the User Object.
	 * @param firstName of the User Object.
	 * @param lastName of the User Object.
	 * @param email of the User Object.
	 * @param userRoleId of the User Object.
	 */
	public User(int userId, String userName, String password, String firstName, String lastName, String email,
			int userRoleId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userRoleId = userRoleId;
	}
	
	/**
	 * Function to get the User Id of the User Object.
	 * 
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	
	/**
	 * Function to set or update User Id of the User Object.
	 * 
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	/**
	 * Function to get the User Name of the User Object.
	 * 
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * Function to set or update the user name of the User Object.
	 * 
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/** 
	 * Function to get the password of the User Object.
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Function to set or update the password of the User Object.
	 * 
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Function to get the first name of the User Object.
	 * 
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Function to set or update the first name of the User Object.
	 * 
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Function to get the last name of the User Object.
	 * 
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Function to set or update the last name of the User Object.
	 *  
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Function to get the email of the User Object.
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Function to set or update the Email of the User Object.
	 * 
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Function to get the RoleId of the User Object.
	 * 
	 * @return the userRoleId
	 */
	public int getUserRoleId() {
		return userRoleId;
	}
	
	/**
	 * Function to set or update the Role Id of the User Object.
	 * 
	 * @param userRoleId the userRoleId to set
	 */
	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}	
}
