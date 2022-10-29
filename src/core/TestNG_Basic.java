package core;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class TestNG_Basic {
	WebDriver driver;

	@Test
	public void testCase() {

		WebElement cusID = driver.findElement(By.name("cusid"));
		cusID.sendKeys("54321");

		WebElement searchButton = driver.findElement(By.name("submit"));
		searchButton.click();

		// Switch to pop
		// Alert is a interface in Selenium
		Alert alert = driver.switchTo().alert();
		String deleteMSG = alert.getText();
		System.out.println(deleteMSG);

		alert.accept();
	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.guru99.com/test/delete_customer.php");
		driver.manage().window().maximize();
		System.out.println("Browser has been Launched");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
