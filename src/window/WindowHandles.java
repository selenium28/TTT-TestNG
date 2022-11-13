package window;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowHandles {
	WebDriver driver;

	@Test
	public void window() {

		System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/popup.php");
		driver.manage().window().maximize();
		System.out.println("Browser has been Launched");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement clickHere = driver.findElement(By.linkText("Click Here"));
		clickHere.click();
		
		String mainWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		
		System.out.println("MainWindow ID: " +mainWindow);
		
		while(it.hasNext()) {
			String childWindow = it.next();
//			mainWindow  == Mainwindow
			if(!mainWindow.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
				WebElement mailID = driver.findElement(By.name("emailid"));
				mailID.sendKeys("Test@test.com");
			
				WebElement submit = driver.findElement(By.name("btnLogin"));
				submit.click();
				System.out.println("Child Window Handle");
				
				driver.switchTo().window(mainWindow);
				System.out.println("Switched to Parent Window");
				clickHere.isDisplayed();
				
			}
			
		}

	}
}
