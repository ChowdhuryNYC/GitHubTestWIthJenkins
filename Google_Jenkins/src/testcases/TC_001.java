package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC_001 {

	WebDriver driver;
	@BeforeTest
	public void OpenBrowser() 
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");	
	}

	@Test
	public void Test_1() 
	{
		// Search Dhaka 

		driver.findElement(By.name("q")).sendKeys("Dhaka University");
		driver.findElement(By.name("btnK")).click();
		Assert.assertTrue(driver.getTitle().equals("Dhaka University - Google Search"));
	}

	@AfterMethod
	public void CloseBrowser() 
	{
		driver.quit();	
	}
}
