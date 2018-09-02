package com.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MyClassTest {
	MyClass tester = new MyClass();

	@BeforeClass
	public static void beforeAllTestCases() {
		System.out.println("Before running all test cases");
	}

	@AfterClass
	public static void afterrunningAllTestCases() {
		System.out.println("After running all test cases");
	}

	@Before
	public void beforeRunningTestCase() {
		System.out.println("Before running a test case");
	}

	@After
	public void afterRunningTestCase() {
		System.out.println("After running a test case");
	}

	@Test
	public void multiplicationOfZeroIntegersShouldReturnZero() {

		fail("this is volantarily failed");
		// assert statements
		assertEquals("10 x 0 must be 0", 0, tester.multiply(10, 0));
		assertEquals("0 x 10 must be 0", 0, tester.multiply(0, 10));
		assertEquals("0 x 0 must be 0", 0, tester.multiply(0, 0));
	}

	//@Ignore("This is not needed")
	@Test
	public void DivisionofZeroWithZeroShouldReturnZero() {
		assertEquals(0, tester.divide(0, 0), 0.0);
	}
}
