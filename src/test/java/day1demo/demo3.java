package day1demo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class demo3 {
	WebDriver driver;
	String a="Admin Home";
	String b="Hi,Admin";
	String c="SignOut";
  @Test
  public void f() {
	  driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
	  driver.manage().window().maximize();
	  driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul/li[1]/a")).click();
	  driver.findElement(By.cssSelector("input#userName")).sendKeys("Admin");
	  driver.findElement(By.cssSelector("input#password")).sendKeys("Password456");
	  driver.findElement(By.xpath("//input[@type='submit']")).click();
	  Assert.assertEquals(a, driver.getTitle());
	  Assert.assertEquals(b,"Hi,Admin");
	  Assert.assertEquals(c,"SignOut");
	  driver.findElement(By.xpath("/html/body/main/div/div/div/div[2]/button")).click();
	  driver.findElement(By.xpath("//*[@id=\"catgName\"]")).sendKeys("Holidays");
	  driver.findElement(By.xpath("//*[@id=\"catgDesc\"]")).sendKeys("Bags");
	  driver.findElement(By.xpath("/html/body/main/div/div/div/form/fieldset/div/div[3]/center/div[1]/input")).submit();
	  
  }
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\training_c2a.05.08\\Desktop\\Selium 3.0\\Selium 3.0\\chromedriver.exe");
	  driver=new ChromeDriver();
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
