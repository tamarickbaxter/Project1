package com.ers.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ers.FinanceManager;
import com.ers.Users;

public class FinanceManagerDaoImpl implements FinanceManagerDao {
	
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
	public void insertUser(FinanceManager f) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO ERS_Users Values(?,?,?,?,?,?,?)");
			ps.setInt(1,f.getUserId());
			ps.setString(2,f.getUsername());
			ps.setString(3,f.getPassword());
			ps.setString(4,f.getFirstName());
			ps.setString(5,f.getLastName());
			ps.setString(6,f.getEmail());
			ps.setInt(7,f.getRoleId());
			System.out.println("connected, now executing");
			ps.executeUpdate();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public Users selectUserByUserId(int id) {
		Users temp = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)){			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_Users WHERE ERS_USER_ID=?"); //putting in a native SQL native query utilizing a prepared statement
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getInt(7)==1)				//if they are admin type accounts create admin objects
					temp = new FinanceManager(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6),rs.getInt(7));		
				else 		//if they are employee type accounts create employee objects
					temp = new Users(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
							rs.getString(5),rs.getString(6),rs.getInt(7));	
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	public Users selectUserByUsername(String name) {
		Users temp = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)){			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_Users WHERE ERS_USERNAME=?"); //putting in a native SQL native query utilizing a prepared statement
			ps.setString(1,name);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getInt(7)==1)				//if they are admin type accounts create admin objects
					temp = new FinanceManager(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6),rs.getInt(7));		
				else 		//if they are employee type accounts create employee objects
					temp = new Users(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
							rs.getString(5),rs.getString(6),rs.getInt(7));	
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}
	@Override
	public boolean userFound(String name) {
		Users temp = null;
		ArrayList<String> possible = new ArrayList<String>(); 
		try(Connection conn = DriverManager.getConnection(url, username, password)){			
			PreparedStatement ps = conn.prepareStatement("SELECT ERS_USERNAME FROM ERS_USERS"); //putting in a native SQL native query utilizing a prepared statement
			//ps.setString(1,username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				possible.add(rs.getString(1));	
			}
			if(possible.contains(name)) 
				return true;				
			else
				return false;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}return false;		
	}
	
	
	@Override
	public void updateUser(FinanceManager u) {

		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			PreparedStatement ps = conn.prepareStatement("UPDATE ERS_Users SET ERS_USERNAME =?," + 
					" ERS_PASSWORD =?, USER_FIRST_NAME =?, USER_LAST_NAME =?, USER_EMAIL =?, USER_ROLE_ID =? WHERE ERS_USER_ID=?");
			
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getFirstName());
			ps.setString(4, u.getLastName());
			ps.setString(5, u.getEmail());
			ps.setInt(6, u.getRoleId());
			ps.setInt(7, u.getUserId());
			ps.executeUpdate();
			conn.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	@Override
	public void deleteUser(FinanceManager f) {

		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			PreparedStatement ps = conn.prepareStatement("DELETE FROM ERS_Users WHERE ERS_USER_ID=?");
			ps.setInt(1,f.getUserId());
			ps.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
