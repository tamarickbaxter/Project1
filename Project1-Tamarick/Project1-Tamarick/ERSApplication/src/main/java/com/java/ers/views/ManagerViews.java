package com.java.ers.views;

import java.text.SimpleDateFormat;
import java.util.List;

import com.java.ers.constants.Constants;
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

public class ManagerViews {
	
	public String getReimbursements(String cat) {
		// Create Reimbursement Object
				ReimbursementDao reDao = new ReimbursementDaoImpl();
				UserDao userDao = new UserDaoImpl();
				StatusDao statusDao = new StatusDaoImpl();
				TypeDao typeDao = new TypeDaoImpl();
				
				List<Reimbursement> list = null; 
				
				if(cat.equalsIgnoreCase("all")) {
					list = reDao.getAllReimbursements();
				} else if(cat.equalsIgnoreCase("denied")) {
					list = reDao.getReimbursementsByStatus(statusDao.getStatusId(Constants.STATUS_DENINED));
				}  else if(cat.equalsIgnoreCase("approved")) {
					list = reDao.getReimbursementsByStatus(statusDao.getStatusId(Constants.STATUS_APPROVED));
				}  else if(cat.equalsIgnoreCase("pending")) {
					list = reDao.getReimbursementsByStatus(statusDao.getStatusId(Constants.STATUS_PENDING));
				}
				
				String html = "<br />";
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
				html += "<th>Action</th>";
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
					
					String action = ""; 
					String status = statusDao.getStatus(r.getStatusId());
					
					if(status.equalsIgnoreCase(Constants.STATUS_PENDING)) {
						action = "<a href='RequestHandlerServlet?type=action&cat=deny&id="+r.getId()+"'>" +
								"<img src='images/cross.png' style='width: 32px; height:32px;' /></a> "+
								" <a href='RequestHandlerServlet?type=action&cat=approve&id="+r.getId()+
								"'><img  style='width: 32px; height:32px;' src='images/tick.png' /></a>";
					}
					
					html += "<tr>";
					html += "<td>" + r.getAmount() + "</td>";
					html += "<td>"+submitted+"</td>";
					html += "<td>"+resolved+"</td>";
					html += "<td>"+r.getDescription()+"</td>";
					html += "<td>"+ resolver  +"</td>";
					html += "<td>"+ status +"</td>";
					html += "<td>"+ typeDao.getType(r.getTypeId()) +"</td>";
					html += "<td>" +action+"</td>"; 
					html += "</tr>";
				}
				
				html += "</tbody>";
				html += "</table>";
				
				return html;
	}
}
