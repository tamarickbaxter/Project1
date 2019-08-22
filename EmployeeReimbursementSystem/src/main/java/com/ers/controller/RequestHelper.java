package com.ers.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.controller.HomeController;
import com.ers.controller.LoginController;
//import com.ers.controller.ProfileController;

public class RequestHelper {

public static String process(HttpServletRequest request, HttpServletResponse response) {
	
		switch(request.getRequestURI()) {
		//depending on the URI that comes with the request, this 
		//method chooses the corresponding controller and calls
		//the method within that controller
		
		case "/EmployeeReimbursementSystem/html/Login.do":
			return LoginController.Login(request);
		
		case "/EmployeeReimbursementSystem/html/Home.do":
			return HomeController.Home(request, response);
						
//		case "/EmployeeReimburesmentSystem/html/Submit.do":
//			return ProfileController.Submit(request);
			
		default:
			return "/html/Login.html";
		}
	}
}
