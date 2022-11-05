package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Grouping {
	
  @Test (groups = {"smoke"})
  public void testcaseOne() {
	  System.out.println("TestCase One");
  }
  
  @Test (groups = {"smoke"},dependsOnMethods = {"testcaseOne"})
  public void testcaseTwo() {
	  System.out.println("TestCase Two");
  }
  
  @Test (groups = {"smoke"}, dependsOnMethods = {"testcaseTwo"})
  public void testcaseThree() {
	  System.out.println("TestCase Three");
  }
  
  @Test (groups = {"smoke"}, dependsOnMethods = {"testcaseThree"})
  public void testcaseFour() {
	  System.out.println("TestCase Four");
  }
  
  @Test (groups = {"Regression","smoke"}, dependsOnMethods = {"testcaseFour"})
  public void testcaseFive() {
	  System.out.println("TestCase Five");
  }
  
  @Test (groups = {"Regression"})
  public void testcaseSix() {
	  System.out.println("TestCase Six");
  }
  
  @Test (groups = {"Regression"})
  public void testcaseSeven() {
	  System.out.println("TestCase Seven");
  }

}
