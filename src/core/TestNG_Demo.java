package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestNG_Demo {

//	public static void main(String[] args) {
//		System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://demo.guru99.com/test/upload/");
//		driver.manage().window().maximize();
//		System.out.println("Browser has been Launched");
//		
//	}
	
	@Test
	public void testDemo() {
		System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/upload/");
		driver.manage().window().maximize();
		System.out.println("Browser has been Launched");
	}

}
