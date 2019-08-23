package com.ers.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ers.FinanceManager;
import com.ers.Users;

public class UsersDaoImpl implements UsersDao {
	
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
    public Users getUsersByUsername(String userName) {
            Users user = new Users();
            try(Connection conn = DriverManager.getConnection(url, username, password)){
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_Users WHERE ERS_USERNAME = ?");
                ps.setString(1, userName);
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                	if(rs.getInt(7)==1)				//if they are admin type accounts create admin objects
    					user = new FinanceManager(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
    						rs.getString(5),rs.getString(6),rs.getInt(7));		
    				else 		//if they are employee type accounts create employee objects
    					user = new Users(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
    							rs.getString(5),rs.getString(6),rs.getInt(7));	
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return user;
    }
@Override
    public List<Users> getUsersByRole(String Role) {
        List<Users> getUsersByRole = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(url, username, password)){
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_Users WHERE USER_ROLE_ID = ?");
            ps.setString(1, Role);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                getUsersByRole.add(new Users(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6),rs.getInt(7)));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return getUsersByRole;
            }
    public List<Users> getAllUsers() {
        List<Users> getAllUsers = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(url, username, password)){
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_Users");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                getAllUsers.add(new Users(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6),rs.getInt(7)));
                //getAllUsers.add(user);
            }
        } catch (SQLException e) {
        } 
        return getAllUsers;
    }
}
