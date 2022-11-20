package screen;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CaptureScreen {
	static WebDriver driver;

	@Test
	public static void captureScreenMethod() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
		// Initialize browser
		driver = new ChromeDriver();
		//navigate to url
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(3000);
//		Assert.assertEquals(false, false);
		driver.findElement(By.id("abcd")).click();  // wrong id for capture the screenshot
	}

	@AfterMethod
	public void captureScreenShot(ITestResult result) throws IOException {
		
		if (ITestResult.FAILURE==result.getStatus()) {
			try {
				TakesScreenshot ts = (TakesScreenshot) driver;

				File scr = ts.getScreenshotAs(OutputType.FILE);
				File trg = new File("Result/"+result.getName()+".png");
				FileHandler.copy(scr, trg);
				System.out.println("Successfully captured a screenshot");
			} catch (Exception e) {
				System.out.println("Exception while taking the screenshot" +e.getStackTrace());
			}
				
		}
		driver.close();
	
	}
}
