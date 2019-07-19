package tests;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.reporters.jq.Main;

public class LoginTest {
	WebDriver driver = null;
	@Test
	public void testUserIsAbleToLoginIntoApp() {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com");

		driver.findElement(By.id("user-name")).sendKeys("standard_user");

		driver.findElement(By.id("password")).sendKeys("secret_sauce");

		driver.findElement(By.cssSelector("input[value='LOGIN']")).click();

		WebElement el = driver.findElement(By.id("shopping_cart_container"));
		
		SoftAssert soft = new SoftAssert();

		soft.assertTrue(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html111"), 
				"Current URL after login should be 'https://www.saucedemo.com/inventory.html111', "
				+ "but fould [" +driver.getCurrentUrl() + "]");
				
		Assert.assertTrue(el.isDisplayed());
		soft.assertAll();
		
		
		
	}

	@AfterClass(alwaysRun = true)
	public void closeBrowser()  {
	driver.quit();}
	
	
	
}