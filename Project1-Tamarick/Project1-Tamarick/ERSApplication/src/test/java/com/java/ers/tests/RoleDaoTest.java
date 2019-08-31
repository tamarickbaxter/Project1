package com.java.ers.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.java.ers.dao.RoleDao;
import com.java.ers.dao.RoleDaoImpl;
import com.java.ers.constants.Constants;

public class RoleDaoTest {

	@Test
	/**
	 * Function to test the Role Id function by a given role
	 */
	public void testGetRole() {
		// Test 1
		RoleDao dao = new RoleDaoImpl();
		String expected = Constants.ROLE_EMPLOYEE;
		String actual = dao.getRole(1);
		assertEquals(expected, actual);

		// test 2
		expected = Constants.ROLE_MANAGER;
		actual = dao.getRole(2);
		assertEquals(expected, actual);
	}

	@Test
	/**
	 * Function to test reading the Role by given id
	 */
	public void testGetRoleId() {
		// Test 1
		RoleDao dao = new RoleDaoImpl();
		int expected = 1;
		int actual = dao.getRoleId(Constants.ROLE_EMPLOYEE);
		assertEquals(expected, actual);

		// test 2
		expected = 2;
		actual = dao.getRoleId(Constants.ROLE_MANAGER);
		assertEquals(expected, actual);
	}

}
