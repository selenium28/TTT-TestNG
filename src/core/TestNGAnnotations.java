package core;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class TestNGAnnotations {
	
  @Test
  public void annot() {
	  System.out.println("TestCase: 1");
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before Method");
  }

  @Test
  public void annott() {
	  System.out.println("TestCase: 2");
  }
  
  @Test
  public void annottt() {
	  System.out.println("TestCase: 3");
  }
  
  @AfterMethod
  public void afterMethod() {
	  System.out.println("After Method");
  }

}
