package com.ers.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.FinanceManager;
import com.ers.Users;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HomeController {

	public static String Home(HttpServletRequest request, HttpServletResponse response) {
		//retrieving the user object in our session
		Users user = (Users) request.getSession().getAttribute("User");
//		Users user = new FinanceManager(0,"test2","pass","Bob","Smith","bobsmith@gmail.com",1);

		try {
			//converting the object pet into JSON for JavaScript to receive
			response.getWriter().write(new ObjectMapper().writeValueAsString(user));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
