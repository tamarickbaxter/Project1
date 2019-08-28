package com.java.ers.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import com.java.ers.dao.UserDao;
import com.java.ers.dao.UserDaoImpl;
import com.java.ers.domain.User;

// Expected some Users exist in the database 
// as in the DDL script there are some default records
// These User tests are based on those records. 

public class UserDaoTest {

	@Test
	/**
	 * Function to test the successful login of a user.
	 */
	public void testLogin() {

		// instance
		UserDao dao = new UserDaoImpl();

		// test success
		boolean expected = true;
		boolean result = dao.login("john", "1111");
		assertEquals(expected, result);

		// test administrator
		expected = true;
		result = dao.login("make", "123");
		assertEquals(expected, result);

		// test failure
		expected = false;
		result = dao.login("maker", "123");
		assertEquals(expected, result);
	}

	@Test
	/**
	 * 
	 */
	public void testGetUserByUserNamePassword() {
		// instance
		UserDao dao = new UserDaoImpl();

		// Test employee
		User user = dao.getUser("john", "1111");

		// test data
		assertEquals(1, user.getUserId());
		assertEquals("john", user.getUserName());
		assertEquals("1111", user.getPassword());
		assertEquals("John", user.getFirstName());
		assertEquals("Doe", user.getLastName());
		assertEquals("john@hotmail.com", user.getEmail());
		assertEquals(1, user.getUserRoleId());

		// Administrator test
		user = dao.getUser("make", "123");

		// test data
		assertEquals(4, user.getUserId());
		assertEquals("make", user.getUserName());
		assertEquals("123", user.getPassword());
		assertEquals("Make", user.getFirstName());
		assertEquals("Tee", user.getLastName());
		assertEquals("make@gmail.com", user.getEmail());
		assertEquals(2, user.getUserRoleId());

	}

	@Test
	public void testGetUserUserId() {
		// instance
		UserDao dao = new UserDaoImpl();

		// Test employee
		User user = dao.getUser(1);

		// test data
		assertEquals(1, user.getUserId());
		assertEquals("John", user.getFirstName());
		assertEquals("Doe", user.getLastName());
		assertEquals("john@hotmail.com", user.getEmail());
		assertEquals(1, user.getUserRoleId());

		// Administrator test
		user = dao.getUser(4);

		// test data
		assertEquals(4, user.getUserId());
		assertEquals("Make", user.getFirstName());
		assertEquals("Tee", user.getLastName());
		assertEquals("make@gmail.com", user.getEmail());
		assertEquals(2, user.getUserRoleId());
	}

}
