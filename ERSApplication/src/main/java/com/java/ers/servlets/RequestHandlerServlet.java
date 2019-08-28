package com.java.ers.servlets;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.ers.dao.UserDaoImpl;
import com.java.ers.domain.Reimbursement;
import com.java.ers.domain.User;
import com.java.ers.views.EmployeeView;
import com.java.ers.views.ManagerViews;
import com.java.ers.dao.ReimbursementDao;
import com.java.ers.dao.ReimbursementDaoImpl;
import com.java.ers.dao.RoleDao;
import com.java.ers.dao.RoleDaoImpl;
import com.java.ers.dao.StatusDao;
import com.java.ers.dao.StatusDaoImpl;
import com.java.ers.dao.UserDao;
import com.java.ers.constants.Constants;

/**
 * Servlet implementation class RequestHandlerServlet
 *
@WebServlet("/RequestHandlerServlet")
*/
public class RequestHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RequestHandlerServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Handle all the requests here.
		// Read the "type" parameter
		String type = request.getParameter("type");
		HttpSession session = request.getSession();
		User user = null;
		
		//System.out.println("HERE_______________> " + type);

		if (type.equalsIgnoreCase("login")) {

			// Parse user name and password
			String userName = request.getParameter("username");
			String password = request.getParameter("password");

			// UserDao
			UserDao userDao = new UserDaoImpl();

			if (userDao.login(userName, password)) {

				user = userDao.getUser(userName, password);
				session.setAttribute("user", user);

				// redirect to respect page
				RoleDao roleDao = new RoleDaoImpl();

				if (roleDao.getRole(user.getUserRoleId()).equalsIgnoreCase(Constants.ROLE_EMPLOYEE)) {
					response.sendRedirect("employee.html");
				} else {
					response.sendRedirect("manager.html");
				}

			} else {
				response.sendRedirect("login_error.html");
			}

		} else if (type.equalsIgnoreCase("insert")) {

			// Check the user is logged in
			user = (User) session.getAttribute("user");

			if (user == null) {
				// send to login page
				response.sendRedirect("index.html");

			} else {

				double amount = Double.parseDouble(request.getParameter("amount"));
				String desc = request.getParameter("description");
				int typeId = Integer.parseInt(request.getParameter("typeId"));
				Timestamp submitted = new Timestamp(System.currentTimeMillis());

				// Get the Status id
				StatusDao statusDao = new StatusDaoImpl();
				int statusId = statusDao.getStatusId(Constants.STATUS_PENDING);

				// Reimbursement Dao
				ReimbursementDao reDao = new ReimbursementDaoImpl();

				// Create Reimbursement Object
				Reimbursement re = new Reimbursement();
				int id = reDao.getNextId();

				re.setId(id);
				re.setAmount(amount);
				re.setSubmitted(submitted);
				re.setDescription(desc);
				re.setAuthorId(user.getUserId());
				re.setStatusId(statusId);
				re.setTypeId(typeId);

				// insert
				if (reDao.insertReimbursement(re)) {

					// back to empty page
					response.sendRedirect("employee.html");
				} else {
					// error page
					response.sendRedirect("reimbursement_error.html");
				}

			}
		} else if (type.equalsIgnoreCase("logout")) {
			session.invalidate();
			response.sendRedirect("index.html");
		} else if (type.equalsIgnoreCase("list")) {

			// Check the user is logged in
			user = (User) session.getAttribute("user");

			if (user == null) {
				// send to login page
				response.sendRedirect("index.html");
			} else {

				// RoleDao
				RoleDao roleDao = new RoleDaoImpl();

				if (roleDao.getRole(user.getUserRoleId()).equalsIgnoreCase(Constants.ROLE_EMPLOYEE)) {
					// Create Reimbursement Object
					System.out.println("Employee");
					EmployeeView view = new EmployeeView();
					response.getWriter().println(view.getReimbursements(user.getUserId()));
				} else {
					// Manager functions
					System.out.println("Manager");
					String cat = request.getParameter("cat");
					System.out.println(cat);
					ManagerViews view = new ManagerViews();
					response.getWriter().println(view.getReimbursements(cat));
				}
			}

		} else if (type.equalsIgnoreCase("action")) {
			// Check the user is logged in
			user = (User) session.getAttribute("user");
			if (user == null) {
				// send to login page
				response.sendRedirect("index.html");
			} else {
				String cat = request.getParameter("cat");
				System.out.println(cat);
				int id = Integer.parseInt(request.getParameter("id"));
				ReimbursementDao reDao = new ReimbursementDaoImpl();
				int statusId = 0; 
				System.out.println(id);
				StatusDao sDao = new StatusDaoImpl();
				if(cat.equalsIgnoreCase("approve")) statusId = sDao.getStatusId(Constants.STATUS_APPROVED);
				else statusId = sDao.getStatusId(Constants.STATUS_DENINED);
				reDao.updateStatus(id, user.getUserId(), statusId);
				response.sendRedirect("manager.html");
			}
		} else {
			response.sendRedirect("index.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
