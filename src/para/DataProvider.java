package para;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DataProvider {
	WebDriver driver;

	@Test(dataProvider = "dataData")
	public void dataProvider(String user, String pass) {

		System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		System.out.println("Browser has been Launched");
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement username = driver.findElement(By.name("username")); 
		// Explicit wait
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(username));
		username.sendKeys(user);
		WebElement password = driver.findElement(By.name("password")); 
		password.sendKeys(pass);
		WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']")); 
		wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		loginButton.click();
		// For title verification
//		wait.until(ExpectedConditions.titleContains("OrangeHRM"));
		System.out.println("Login successful");

	}

	@org.testng.annotations.DataProvider
	public Object[][] dataData(){
		Object[][] data = new Object[3][2];

		data[0][0] = "Admin";
		data[0][1] = "admin123";

		data[1][0] = "password";
		data[1][1] = "admin123";

		data[2][0] = "username";
		data[2][1] = "admin123";

		return data;

	}

}
