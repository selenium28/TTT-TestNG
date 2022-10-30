package test;

import org.testng.annotations.Test;

public class PriorityClass {

	@Test (priority = 1)
	public void testCaseOne() {
		System.out.println("TestCaseOne");
	}

	@Test (priority = 1)
	public void testCaseTwo() {
		System.out.println("TestCaseTwo");
	}

	@Test (priority = 0)
	public void testCaseThree() {
		System.out.println("TestCaseThree");
	}

}
