package com.bridgelabz.workshopthree;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class EmployeeWageTest {

	@Test
	public void testValidFirstName() {
		boolean result = EmployeeWage.validateFirstName("John");
		assertTrue(result);
	}
}
