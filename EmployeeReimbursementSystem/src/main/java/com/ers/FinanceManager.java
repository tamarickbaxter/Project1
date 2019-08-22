package com.ers;

import com.ers.dao.FinanceManagerDaoImpl;

public class FinanceManager extends Users{
	int userId;
	String username,
		password,
		firstName,
		lastName,
		email;
	int roleId = 1;
	
	public FinanceManager() {
		userId = 0;
		username = "default";
		password = "password";
		
	}

	public FinanceManager(int userId, String username, String password, String firstName, String lastName,
			String email, int roleId) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.roleId = roleId;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getRoleId() {
		return roleId;
	}
	
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	@Override
	public String toString() {
		return "FinanceManager [userId=" + userId + ", username=" + username + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", roleId=" + roleId + "]";
	}
	
	protected boolean login(String usr, String pass) {
		FinanceManagerDaoImpl fm = new FinanceManagerDaoImpl();
		FinanceManager temp = (FinanceManager)fm.selectUserByUsername(usr);
		
		if(temp.getPassword()==pass)
			return true;
		else
			return false;
	}
	
	
	
	
	
	
	
}
