package com.ers.dao;

import com.ers.FinanceManager;
import com.ers.Users;

public interface FinanceManagerDao {

	//CREATE
	public void insertUser(FinanceManager u);
	
	//READ
	public Users selectUserByUserId(int id);
	//public HashMap<String,Users> selectAllUsers();
	public boolean userFound(String user);
	
	//UPDATE
	public void updateUser(FinanceManager u);
	
	//DELETE	
	public void deleteUser(FinanceManager u);
}
