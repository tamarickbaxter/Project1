package com.ers.dao;

import java.util.HashMap;
import java.util.List;

import com.ers.Users;

public interface UsersDao {

			//CREATE
			//public void insertUser(Users u);
			
			//READ
			public Users getUsersByUsername(String username);
			public List<Users> getUsersByRole(String Role);
		    public List<Users> getAllUsers();
			
			//UPDATE
			//public void updateUser(Users u);
			
			
			//DELETE	
			//public void deleteUser(Users u);
}
