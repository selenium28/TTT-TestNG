package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class DependsOnLogin {
	WebDriver driver;

	@Test
	public void validLogin() {
		WebElement username = driver.findElement(By.name("username")); 
		username.sendKeys("Admin");
		WebElement password = driver.findElement(By.name("password")); 
		password.sendKeys("admin123");
		WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']")); 
		loginButton.click();
		System.out.println("1: Login successful");
	}

	@Test (dependsOnMethods = {"validLogin"})
	public void pimTest() {
		WebElement name = driver.findElement(By.xpath("(//*[@class='oxd-input oxd-input--active'])[2]")); 
		name.sendKeys("Dev123");
		System.out.println("Entered Name");
	}

	@Test (dependsOnMethods = {"pimTest"})
	public void addEmployeeTest() {
		WebElement addEmp = driver.findElement(By.xpath("(//*[text()='Add Employee'])[1]")); 
		addEmp.click();
		System.out.println("clicked Add emp");
	}

	//	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		System.out.println("Browser has been Launched");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	//	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		System.out.println("Browser has been Launched");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
