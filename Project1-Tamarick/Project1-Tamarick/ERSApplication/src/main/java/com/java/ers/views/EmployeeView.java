package com.java.ers.views;

import java.text.SimpleDateFormat;
import java.util.List;

import com.java.ers.dao.ReimbursementDao;
import com.java.ers.dao.ReimbursementDaoImpl;
import com.java.ers.dao.StatusDao;
import com.java.ers.dao.StatusDaoImpl;
import com.java.ers.dao.TypeDao;
import com.java.ers.dao.TypeDaoImpl;
import com.java.ers.dao.UserDao;
import com.java.ers.dao.UserDaoImpl;
import com.java.ers.domain.Reimbursement;
import com.java.ers.domain.User;

public class EmployeeView {
	
	/**
	 * Function to collect all the employee reimbursements as an html table
	 * 
	 * @param userId employee id
	 * @return html output
	 */
	public String getReimbursements(int userId) {
		
		// Create Reimbursement Object
		ReimbursementDao reDao = new ReimbursementDaoImpl();
		UserDao userDao = new UserDaoImpl();
		StatusDao statusDao = new StatusDaoImpl();
		TypeDao typeDao = new TypeDaoImpl();
		
		List<Reimbursement> list = reDao.getReimbursementsByUserId(userId);
		User user = userDao.getUser(userId);
		
		String html = "<h3>Welcome: " + user.getFirstName() + " " + user.getLastName() + "</h3> ";
		html += "<a href='RequestHandlerServlet?type=logout' class='btn btn-warning btn-lg'>Logout</a><br /><br />";		
		html += "<table class='table table-striped'>";
		html += "<thead>";
		html += "<tr>";
		html += "<th>Amount</th>";
		html += "<th>Submitted</th>";
		html += "<th>Resolved</th>";
		html += "<th>Description</th>";
		html += "<th>Resolved By</th>";
		html += "<th>Status</th>";
		html += "<th>Type</th>";
		html += "</tr>";
		html += "</thead>";
		
		html += "<tbody>";
		
		SimpleDateFormat fmt = new SimpleDateFormat("MM/dd/yyyy");
		
		for(Reimbursement r: list) {
			
			String submitted = fmt.format(r.getSubmitted());
			String resolved = ""; 
			String resolver = ""; 
			
			if(r.getResolved() != null) {
				resolved = fmt.format(r.getResolved());
			}
			
			if(r.getResolverId() != 0) {
				User obj = userDao.getUser(r.getResolverId());
				resolver = obj.getFirstName() + " " + obj.getLastName(); 
			}
			
			html += "<tr>";
			html += "<td>" + r.getAmount() + "</td>";
			html += "<td>"+submitted+"</td>";
			html += "<td>"+resolved+"</td>";
			html += "<td>"+r.getDescription()+"</td>";
			html += "<td>"+ resolver  +"</td>";
			html += "<td>"+ statusDao.getStatus(r.getStatusId()) +"</td>";
			html += "<td>"+ typeDao.getType(r.getTypeId()) +"</td>";
			html += "</tr>";
		}
		
		html += "</tbody>";
		html += "</table>";
		
		return html;
	}
}
