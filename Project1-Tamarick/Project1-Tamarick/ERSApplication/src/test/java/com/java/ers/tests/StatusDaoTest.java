package com.java.ers.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.java.ers.constants.Constants;
import com.java.ers.dao.StatusDao;
import com.java.ers.dao.StatusDaoImpl;

public class StatusDaoTest {

	@Test
	/**
	 * Function to test the Status from the database based on an 
	 * id. 
	 */
	public void testGetStatus() {

		// Test 1
		StatusDao dao = new StatusDaoImpl();
		String expected = Constants.STATUS_PENDING;
		String actual = dao.getStatus(1);
		assertEquals(expected, actual);

		// test 2
		expected = Constants.STATUS_APPROVED;
		actual = dao.getStatus(2);
		assertEquals(expected, actual);

		// test 3
		expected = Constants.STATUS_DENINED;
		actual = dao.getStatus(3);
		assertEquals(expected, actual);
	}

	@Test
	/**
	 * Function to get the Status Id from the Database based
	 * on the status
	 */
	public void testGetStatusId() {
		// Test 1
		StatusDao dao = new StatusDaoImpl();
		int expected = 1;
		int actual = dao.getStatusId(Constants.STATUS_PENDING);
		assertEquals(expected, actual);

		// test 2
		expected = 2;
		actual = dao.getStatusId(Constants.STATUS_APPROVED);
		assertEquals(expected, actual);

		// test 3
		expected = 3;
		actual = dao.getStatusId(Constants.STATUS_DENINED);
		assertEquals(expected, actual);
	}

}
