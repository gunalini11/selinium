package day1demo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class demo4 {
	WebDriver driver;
  @Test
  public void f() {
	  WebDriver driver =new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
	  driver.manage().window().maximize();
	  String a=driver.getTitle();
	  System.out.println(a);
	  driver.navigate().to("https://portal.accenture.com/");
	  String b=driver.getTitle();
	  String c=driver.getCurrentUrl();
	  System.out.println(b);
	  System.out.println(c);
	  driver.navigate().back();
	  driver.navigate().to("https://www.google.co.in");
	  driver.navigate().refresh();
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
