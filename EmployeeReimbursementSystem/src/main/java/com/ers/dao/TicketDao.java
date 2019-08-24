package com.ers.dao;

import java.util.ArrayList;

import com.ers.Ticket;

public interface TicketDao {

	//CREATE
		public void createTicket(Ticket t);
		
		//READ
		public Ticket selectTicketById(int id);
		//public HashMap<String,Users> selectAllUsers();
		public ArrayList<Ticket> selectTicketByStatus(int status);
		
		//UPDATE
		public void updateTicket(Ticket t);
		
		//DELETE	
		public void deleteTicket(Ticket t);
}
