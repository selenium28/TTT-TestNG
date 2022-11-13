package core;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class LoginScenario {
	WebDriver driver;

	@Test (priority = 3)
	public void inValidLogin() {
		
		WebDriver driver = new ChromeDriver();
		
		WebElement username = driver.findElement(By.name("username")); 
		username.sendKeys("Test");
		WebElement password = driver.findElement(By.name("password")); 
		password.sendKeys("12345");
		WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']")); 
		loginButton.click();
		
		WebElement validationMessage = driver.findElement(By.xpath("//*[text()='Invalid credentials']"));
		validationMessage.isDisplayed();
		System.out.println("Validation: " +validationMessage);
		System.out.println("3: Validation message has been displayed");
	}

	@Test (priority = 1)
	public void validLogin() {
		WebElement username = driver.findElement(By.name("username")); 
		username.sendKeys("Admin");
		WebElement password = driver.findElement(By.name("password")); 
		password.sendKeys("admin123");
		WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']")); 
		loginButton.click();
		System.out.println("1: Login successful");
	}

	@Test 
	public void blankLogin() {
		WebElement username = driver.findElement(By.name("username")); 
		username.sendKeys("  ");
		WebElement password = driver.findElement(By.name("password")); 
		password.sendKeys("  ");
		WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']")); 
		loginButton.click();
		System.out.println("2: Validation Messages of pass and user");
	}

	@Test 
	public void inValidPass() {
		WebElement username = driver.findElement(By.name("username")); 
		username.sendKeys("Admin");
		
		WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']")); 
		loginButton.click();
		System.out.println("4: Validation Messages of pass");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		System.out.println("Browser has been Launched");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
