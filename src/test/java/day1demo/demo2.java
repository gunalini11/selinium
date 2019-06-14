package day1demo;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class demo2 {
	WebDriver driver;
	String a="Login";
  @Test
  public void f() {
	  driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
	  driver.manage().window().maximize();
	  driver.findElement(By.linkText("SignIn")).click();
	  Assert.assertEquals(a, driver.getTitle());
	  List<WebElement>link=driver.findElements(By.tagName("a"));
	  int noflink = link.size();
	  System.out.println(noflink);
	  for(int i=0;i<link.size();i++)
		  System.out.println(link.get(i).getAttribute("href"));
	  
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\training_c2a.05.08\\Desktop\\Selium 3.0\\Selium 3.0\\chromedriver.exe");
	  driver=new ChromeDriver();
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
