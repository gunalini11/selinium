package day1demo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class NewTest6 {
	WebDriver driver;
  @Test
  public void f() {
	  driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  Actions a= new Actions(driver);
	  a.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[3]/a/span"))).
	  moveToElement(driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[3]/ul/li/a/span"))).
	  moveToElement(driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[3]/ul/li/ul/li[1]/a"))).click().build().perform();
	  Assert.assertTrue(driver.getCurrentUrl().contains("chn"));
	  
	  
	  
	
  }
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\training_c2a.05.08\\Desktop\\Selium 3.0\\Selium 3.0\\chromedriver.exe");
	  driver=new ChromeDriver();
  }

  @AfterClass
  public void afterClass() {
  }

}
