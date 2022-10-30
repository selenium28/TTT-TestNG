package test;

import org.testng.annotations.Test;

public class DependsOnMethod {
	
	@Test 
	public void testCaseOne() {
		System.out.println("TestCaseOne");
	}

	@Test (dependsOnMethods = {"testCaseOne"})
	public void testCaseTwo() {
		System.out.println("TestCaseTwo");
	}

	@Test (dependsOnMethods = {"testCaseTwo"})
	public void testCaseThree() {
		System.out.println("TestCaseThree");
	}

	@Test (dependsOnMethods = {"testCaseThree"})
	public void testCaseFour() {
		System.out.println("TestCaseFour");
	}


}
