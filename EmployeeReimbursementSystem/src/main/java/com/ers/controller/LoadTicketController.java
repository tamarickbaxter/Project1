package com.ers.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.Ticket;
import com.ers.Users;
import com.ers.dao.TicketDaoImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoadTicketController {

	/*public static String LoadTicket(HttpServletRequest request, HttpServletResponse response) {
		//retrieving the user object in our session
		Users user = (Users) request.getSession().getAttribute("User");
		TicketDaoImpl td = new TicketDaoImpl();
		Ticket t = td.selectTicketByAuthor(user.getUserId());
		
		try {
			//converting the object pet into JSON for JavaScript to receive
			response.getWriter().write(new ObjectMapper().writeValueAsString(t));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}*/
}
