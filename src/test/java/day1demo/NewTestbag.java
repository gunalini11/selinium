package day1demo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NewTestbag {
	WebDriver driver;
  @Test
  public void f() {
	 driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
	 // driver.get("http://localhost:8090/TestMeApp/fetchcat.htm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		WebElement search=driver.findElement(By.id("myInput"));
		Actions act1=new Actions(driver);
		act1.keyDown(search,Keys.SHIFT).perform();
		act1.sendKeys("b").pause(3000).sendKeys("a").pause(3000).sendKeys("g").build().perform();
		act1.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'Hand bag')]"))).click().perform();
		driver.findElement(By.cssSelector("input[value='FIND DETAILS']")).click();
		String text=driver.findElement(By.xpath("//h4[contains(text(),'Hand Bag')]")).getText();
		Assert.assertTrue(text.contains("Hand Bag"));
	
	  
	  
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\training_c2a.05.08\\Desktop\\Selium 3.0\\Selium 3.0\\chromedriver.exe");
	  driver=new ChromeDriver();
  }

  @AfterTest
  public void afterTest() {
  }

}
