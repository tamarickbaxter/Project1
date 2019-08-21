package com.ers.dao;

import java.util.HashMap;

import com.ers.Users;

public interface UsersDao {

	//CREATE
			public void insertUser(Users u);
			
			//READ
			public Users selectUserByUserName(String username);
			//public HashMap<String,Users> selectAllUsers();
			
			//UPDATE
			public void updateUser(Users u);
			
			//DELETE	
			public void deleteUser(Users u);
}
