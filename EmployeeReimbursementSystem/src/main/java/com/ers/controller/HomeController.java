package com.ers.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.Ticket;
import com.ers.Users;
import com.ers.dao.FinanceManagerDaoImpl;
import com.ers.dao.TicketDaoImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HomeController {

	public static String Home(HttpServletRequest request, HttpServletResponse response) {
		//retrieving the user object in our session
		Users user = (Users) request.getSession().getAttribute("User");
		//System.out.println(user);

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
	
	  public static String LoadTickets(HttpServletRequest request, HttpServletResponse response) {
		//retrieving the user object in our session
		Users user = (Users) request.getSession().getAttribute("User");
		TicketDaoImpl td = new TicketDaoImpl();
		ArrayList<Ticket> tList = td.selectTicketByAuthor(user.getUserId());
		//System.out.println("Full List: "+tList);
		try {
			//converting the object pet into JSON for JavaScript to receive
			response.getWriter().write(new ObjectMapper().writeValueAsString(tList));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	  
	  public static String LoadPendingTickets(HttpServletRequest request, HttpServletResponse response) {
			//retrieving the user object in our session
			Users user = (Users) request.getSession().getAttribute("User");
			TicketDaoImpl td = new TicketDaoImpl();
			ArrayList<Ticket> tList = td.selectTicketByStatus(0,user);
			//System.out.println("Full List: "+tList);
			try {
				//converting the object pet into JSON for JavaScript to receive
				response.getWriter().write(new ObjectMapper().writeValueAsString(tList));
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return null;
		}
	  
	  public static String Approve(HttpServletRequest request, HttpServletResponse response) {
			
		  	Users user = (Users) request.getSession().getAttribute("User");
		  	int id = Integer.parseInt(request.getParameter("ticketId"));
			TicketDaoImpl td = new TicketDaoImpl();		
			td.approveTicket(id, user);	
			return "/html/Home.html";
	  }
	  
	  public static String Deny(HttpServletRequest request, HttpServletResponse response) {
			
		  	Users user = (Users) request.getSession().getAttribute("User");
		  	int id = Integer.parseInt(request.getParameter("ticketId"));
			TicketDaoImpl td = new TicketDaoImpl();		
			td.denyTicket(id, user);	
			return "/html/Home.html";
	  }
	
}
