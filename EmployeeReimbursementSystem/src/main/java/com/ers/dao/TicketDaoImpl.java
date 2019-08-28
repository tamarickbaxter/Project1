package com.ers.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ers.FinanceManager;
import com.ers.Ticket;
import com.ers.Users;

public class TicketDaoImpl implements TicketDao{
	
	static{
	       try {
	           Class.forName("oracle.jdbc.driver.OracleDriver");
	       } catch (ClassNotFoundException e) {
	           e.printStackTrace();
	       }
	   }
	
	private static String url = "jdbc:oracle:thin:@db0715bootcamp.c0szar4trj1r.us-east-2.rds.amazonaws.com:1521:ORCL";
	private static String username = "dbMaster";
	private static String password = "p4ssw0rd";

	@Override
	public void createTicket(Ticket t) {
		
	}

	@Override
	public Ticket selectTicketById(int id) {
		Ticket temp = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)){			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_ID=?"); //putting in a native SQL native query utilizing a prepared statement
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
					temp = new Ticket(rs.getInt(1),rs.getDouble(2),rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getInt(9));		
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	public ArrayList<Ticket> selectTicketByAuthor(int authorId) {
		Ticket temp = null;
		ArrayList<Ticket> ticketList = new ArrayList<Ticket>();
		//System.out.println("ID :"+authorId+" inselectTicketByAuthor");
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_AUTHOR=?"); //putting in a native SQL native query utilizing a prepared statement
			ps.setInt(1,authorId);
			ResultSet rs = ps.executeQuery();	
			while(rs.next()) {
				temp = new Ticket(rs.getInt(1),rs.getDouble(2),rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getInt(9));
				ticketList.add(temp);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ticketList;
	}

	@Override
	public ArrayList<Ticket> selectTicketByStatus(int status) {
		Ticket temp = null;
		ArrayList<Ticket> ticketList = new ArrayList<Ticket>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_STATUS_ID=?"); //putting in a native SQL native query utilizing a prepared statement
			ps.setInt(1,status);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
					temp = new Ticket(rs.getInt(1),rs.getDouble(2),rs.getString(3),rs.getString(4),
							rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getInt(9));	
					ticketList.add(temp);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ticketList;
	}
	
	public ArrayList<Ticket> selectTicketByStatus(int status, Users user) {
		Ticket temp = null;
		ArrayList<Ticket> ticketList = new ArrayList<Ticket>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_STATUS_ID=?"); //putting in a native SQL native query utilizing a prepared statement
			ps.setInt(1,status);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if(user.getUserId() != rs.getInt(6)) {
					temp = new Ticket(rs.getInt(1),rs.getDouble(2),rs.getString(3),rs.getString(4),
							rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getInt(9));	
					ticketList.add(temp);
				}
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ticketList;
	}

	@Override
	public void updateTicket(Ticket t) {
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			PreparedStatement ps = conn.prepareStatement("UPDATE ERS_REIMBURSEMENT SET REIMB_AMOUNT =?," + 
					" REIMB_SUBMITTED =?, REIMB_RESOLVED =?, REIMB_DESCRIPTION =?, REIMB_AUTHOR =?, "
					+ "REIMB_RESOLVER =?, REIMB_STATUS_ID =?, REIMB_TYPE_ID =? WHERE REIMB_ID=?");
						
			ps.setDouble(1, t.getAmount());
			ps.setString(2, t.getTimestamp());
			ps.setString(3, t.getResolved());
			ps.setString(4, t.getDescription());
			ps.setInt(6, t.getAuthor());
			ps.setInt(7, t.getResolver());
			ps.setInt(8, t.getStatus());
			ps.setInt(9, t.getType());
			ps.setInt(10, t.getId());
			ps.executeUpdate();
			conn.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void approveTicket(int t, Users u) {
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			PreparedStatement ps = conn.prepareStatement("UPDATE ERS_REIMBURSEMENT SET REIMB_RESOLVED = CURRENT_TIMESTAMP,"
					+ "REIMB_RESOLVER =?, REIMB_STATUS_ID =? WHERE REIMB_ID=?");
						
			ps.setInt(1, u.getUserId());
			ps.setInt(2, 1);
			ps.setInt(3, t);
			ps.executeUpdate();
			conn.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void denyTicket(int t, Users u) {
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			PreparedStatement ps = conn.prepareStatement("UPDATE ERS_REIMBURSEMENT SET REIMB_RESOLVED = CURRENT_TIMESTAMP,"
					+ "REIMB_RESOLVER =?, REIMB_STATUS_ID =? WHERE REIMB_ID=?");
						
			ps.setInt(1, u.getUserId());
			ps.setInt(2, 2);
			ps.setInt(3, t);
			ps.executeUpdate();
			conn.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteTicket(Ticket t) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			PreparedStatement ps = conn.prepareStatement("DELETE FROM ERS_REIMBURSEMENT WHERE REIMB_ID=?");
			ps.setInt(1,t.getId());
			ps.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
