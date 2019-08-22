package com.ers.controller;

import javax.servlet.http.HttpServletRequest;

import com.ers.Users;
import com.ers.dao.FinanceManagerDaoImpl;

public class LoginController {

	public static String Login(HttpServletRequest request) {
		
		String uname = request.getParameter("username");
		String password = request.getParameter("password");
		
		FinanceManagerDaoImpl fm = new FinanceManagerDaoImpl();
		Users user = new Users();
		if(fm.userFound(uname)) {
			user = fm.selectUserByUsername(uname);
		//we are retrieving an existing record by the username
		//that the user provided on the login page and storing it into 
		//a user object
		
			if(uname.equals(user.getUsername()) && password.equals(user.getPassword())) {
				//we are setting the session to the current logged in user
				request.getSession().setAttribute("User", user);
				
				return "/html/Home.html";
			}
		}
		
		return "/html/Login.html";		
		
	}
}
