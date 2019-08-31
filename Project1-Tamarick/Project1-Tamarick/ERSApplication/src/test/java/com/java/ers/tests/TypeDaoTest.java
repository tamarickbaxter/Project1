package com.java.ers.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.java.ers.constants.Constants;
import com.java.ers.dao.TypeDao;
import com.java.ers.dao.TypeDaoImpl;

public class TypeDaoTest {

	@Test
	public void testGetType() {
		// Test 1
		TypeDao dao = new TypeDaoImpl();

		String expected = Constants.TYPE_LODGING;
		String actual = dao.getType(1);
		assertEquals(expected, actual);

		// test 2
		expected = Constants.TYPE_TRAVEL;
		actual = dao.getType(2);
		assertEquals(expected, actual);

		// test 3
		expected = Constants.TYPE_FOOD;
		actual = dao.getType(3);
		assertEquals(expected, actual);

		// test 4
		expected = Constants.TYPE_OTHER;
		actual = dao.getType(4);
		assertEquals(expected, actual);
	}

	@Test
	public void testGetTypeId() {
		// Test 1
		TypeDao dao = new TypeDaoImpl();
		int expected = 1;
		int actual = dao.getTypeId(Constants.TYPE_LODGING);
		assertEquals(expected, actual);

		// test 2
		expected = 2;
		actual = dao.getTypeId(Constants.TYPE_TRAVEL);
		assertEquals(expected, actual);

		// test 3
		expected = 3;
		actual = dao.getTypeId(Constants.TYPE_FOOD);
		assertEquals(expected, actual);

		// test 4
		expected = 4;
		actual = dao.getTypeId(Constants.TYPE_OTHER);
		assertEquals(expected, actual);
	}

}
