package screen;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class ScreenshotClass {
	static	WebDriver driver;

	@Test
	public void screen() throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		System.out.println("Browser has been Launched");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Take a Screenshot
		//		TakesScreenshot ts = ((TakesScreenshot) driver);
		//		File scr = ts.getScreenshotAs(OutputType.FILE);
		//		File dest = new File("ScreenShot/homePage.png");
		//		FileHandler.copy(scr, dest);
		//		driver.close();

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			Thread.sleep(10000);
			FileHandler.copy(screenshot, new File("ScreenShot/testDemo.png"));
			System.out.println("Screenshot captured succesfully");
		} catch (IOException e) {
			System.out.println(e.getStackTrace());
		}

	}

}
