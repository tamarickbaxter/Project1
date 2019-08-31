package com.java.ers.tests;

import static org.junit.Assert.*;

import java.util.List;
import java.sql.Timestamp;

import org.junit.Test;

import com.java.ers.constants.Constants;
import com.java.ers.dao.ReimbursementDao;
import com.java.ers.dao.ReimbursementDaoImpl;
import com.java.ers.dao.StatusDao;
import com.java.ers.dao.StatusDaoImpl;
import com.java.ers.domain.Reimbursement;

// To pass these tests database needs to cleaned up
// It is expected there is no data in this table before
// running the tests. 

public class ReimbursementDaoTest {
	private Timestamp submitted;

	@Test
	/**
	 * Function to test the Insertion of new Reimbursement.
	 */
	public void testInsertReimbursement() {

		// DAO instance
		ReimbursementDao dao = new ReimbursementDaoImpl();
		submitted = new Timestamp(System.currentTimeMillis());
		
		// Reimbursement object
		Reimbursement object = new Reimbursement(dao.getNextId(), 250, submitted, null, "Food Expense", 3, 0, 1, 3);
		dao.insertReimbursement(object);

		List<Reimbursement> list = dao.getReimbursementsByUserId(3);
		assertEquals(list.size(), 1);

		Reimbursement instance = list.get(0);
		assertEquals(object.getAmount(), instance.getAmount(), 0.1);
		assertEquals(object.getDescription(), instance.getDescription());
		assertEquals(object.getAuthorId(), instance.getAuthorId());
		assertEquals(object.getStatusId(), instance.getStatusId());
		assertEquals(object.getTypeId(), instance.getTypeId());

		dao.delete();
	}

	@Test
	/**
	 * Function to test the update status function.
	 */
	public void testUpdateStatus() {
		// DAO instance
		ReimbursementDao dao = new ReimbursementDaoImpl();
		submitted = new Timestamp(System.currentTimeMillis());
		
		// Reimbursement object
		Reimbursement object = new Reimbursement(dao.getNextId(), 250, submitted, null, "Food Expense", 3, 0, 1, 3);
		dao.insertReimbursement(object);
		List<Reimbursement> list = dao.getReimbursementsByUserId(3);
		assertEquals(list.size(), 1);

		Reimbursement instance = list.get(0);
		assertEquals(object.getAmount(), instance.getAmount(), 0.1);
		assertEquals(object.getDescription(), instance.getDescription());
		assertEquals(object.getAuthorId(), instance.getAuthorId());
		assertEquals(object.getStatusId(), instance.getStatusId());
		assertEquals(object.getTypeId(), instance.getTypeId());

		StatusDao sdao = new StatusDaoImpl();
		int statusId = sdao.getStatusId(Constants.STATUS_APPROVED);

		// update status
		boolean expected = true;
		boolean result = dao.updateStatus(instance.getId(), 4, statusId);
		assertEquals(expected, result);
		dao.delete();
	}

	@Test
	/**
	 * Function to test the list of all expenses by a user
	 */
	public void testGetReimbursementsByUserId() {

		// DAO instance
		ReimbursementDao dao = new ReimbursementDaoImpl();
		submitted = new Timestamp(System.currentTimeMillis());

		// Reimbursement object
		Reimbursement object = new Reimbursement(dao.getNextId(), 250, submitted, null, "Food Expense", 1, 0, 1, 3);
		dao.insertReimbursement(object);

		object = new Reimbursement(dao.getNextId(), 300, submitted, null, "Travel Expense", 1, 0, 1, 2);
		dao.insertReimbursement(object);

		object = new Reimbursement(dao.getNextId(), 500, submitted, null, "Other Expense", 2, 0, 1, 4);
		dao.insertReimbursement(object);

		object = new Reimbursement(dao.getNextId(), 750, submitted, null, "Lodging Expense", 2, 0, 1, 1);
		dao.insertReimbursement(object);

		object = new Reimbursement(dao.getNextId(), 950, submitted, null, "Food Expense", 2, 0, 1, 3);
		dao.insertReimbursement(object);

		List<Reimbursement> list = dao.getReimbursementsByUserId(1);
		assertEquals(2, list.size());
		list = dao.getReimbursementsByUserId(2);
		assertEquals(3, list.size());
		dao.delete();
	}

	@Test
	/**
	 * Function to test the list of all expenses.
	 */
	public void testGetAllReimbursements() {

		// DAO instance
		ReimbursementDao dao = new ReimbursementDaoImpl();
		submitted = new Timestamp(System.currentTimeMillis());

		// Reimbursement object
		Reimbursement object = new Reimbursement(dao.getNextId(), 250, submitted, null, "Food Expense", 1, 0, 1, 3);
		dao.insertReimbursement(object);

		object = new Reimbursement(dao.getNextId(), 300, submitted, null, "Travel Expense", 1, 0, 1, 2);
		dao.insertReimbursement(object);

		object = new Reimbursement(dao.getNextId(), 500, submitted, null, "Other Expense", 2, 0, 1, 4);
		dao.insertReimbursement(object);

		object = new Reimbursement(dao.getNextId(), 750, submitted, null, "Lodging Expense", 2, 0, 1, 1);
		dao.insertReimbursement(object);

		object = new Reimbursement(dao.getNextId(), 950, submitted, null, "Food Expense", 2, 0, 1, 3);
		dao.insertReimbursement(object);

		List<Reimbursement> list = dao.getAllReimbursements();
		assertEquals(5, list.size());
		dao.delete();
	}

	@Test
	/**
	 * Function to test the list of Reimbursement by status
	 */
	public void testGetReimbursementsByStatus() {
		StatusDao sdao = new StatusDaoImpl();
		int statusId = sdao.getStatusId(Constants.STATUS_APPROVED);

		// DAO instance
		ReimbursementDao dao = new ReimbursementDaoImpl();
		submitted = new Timestamp(System.currentTimeMillis());

		// Reimbursement object
		Reimbursement object = new Reimbursement(dao.getNextId(), 250, submitted, null, "Food Expense", 1, 0, 1, 3);
		dao.insertReimbursement(object);

		object = new Reimbursement(dao.getNextId(), 300, submitted, null, "Travel Expense", 1, 0, 1, 2);
		dao.insertReimbursement(object);

		object = new Reimbursement(dao.getNextId(), 500, submitted, null, "Other Expense", 2, 0, 1, 4);
		dao.insertReimbursement(object);

		object = new Reimbursement(dao.getNextId(), 750, submitted, null, "Lodging Expense", 2, 0, 1, 1);
		dao.insertReimbursement(object);

		object = new Reimbursement(dao.getNextId(), 950, submitted, null, "Food Expense", 2, 0, 1, 3);
		dao.insertReimbursement(object);

		List<Reimbursement> list = dao.getAllReimbursements();
		assertEquals(5, list.size());

		list = dao.getReimbursementsByStatus(statusId);
		assertEquals(0, list.size());

		statusId = sdao.getStatusId(Constants.STATUS_PENDING);
		list = dao.getReimbursementsByStatus(statusId);
		assertEquals(5, list.size());

		statusId = sdao.getStatusId(Constants.STATUS_DENINED);
		list = dao.getReimbursementsByStatus(statusId);
		assertEquals(0, list.size());
		dao.delete();
	}

	@Test
	/**
	 * Function to test the Next Id from the database.
	 */
	public void testGetNextId() {

		// DAO instance
		ReimbursementDao dao = new ReimbursementDaoImpl();
		submitted = new Timestamp(System.currentTimeMillis());

		// Reimbursement object
		Reimbursement object = new Reimbursement(dao.getNextId(), 250, submitted, null, "Food Expense", 1, 0, 1, 3);
		dao.insertReimbursement(object);

		object = new Reimbursement(dao.getNextId(), 300, submitted, null, "Travel Expense", 1, 0, 1, 2);
		dao.insertReimbursement(object);

		object = new Reimbursement(dao.getNextId(), 500, submitted, null, "Other Expense", 2, 0, 1, 4);
		dao.insertReimbursement(object);

		object = new Reimbursement(dao.getNextId(), 750, submitted, null, "Lodging Expense", 2, 0, 1, 1);
		dao.insertReimbursement(object);

		object = new Reimbursement(dao.getNextId(), 950, submitted, null, "Food Expense", 2, 0, 1, 3);
		dao.insertReimbursement(object);

		List<Reimbursement> list = dao.getAllReimbursements();
		assertEquals(5, list.size());
		int id = 0;
		id = dao.getNextId();
		assertEquals(6, id);
		dao.delete();
	}

}
