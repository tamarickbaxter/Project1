package com.java.ers.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	ReimbursementDaoTest.class,
	RoleDaoTest.class,
	StatusDaoTest.class,
	TypeDaoTest.class,
	UserDaoTest.class
})
public class AllTests {

}
