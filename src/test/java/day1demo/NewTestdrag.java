package day1demo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;

public class NewTestdrag {
	WebDriver driver;
  @Test
  public void f() {
	  driver.get("http://jqueryui.com/resources/demos/resizable/default.html");
		WebElement resize = driver.findElement(By.xpath(".//*[@id='resizable']/div[3]"));
		Actions action = new Actions(driver);
		action.dragAndDropBy(resize, 400, 200).build().perform();}
  
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\training_c2a.05.08\\Desktop\\Selium 3.0\\Selium 3.0\\chromedriver.exe");
	  driver=new ChromeDriver();
  
  }

  @AfterClass
  public void afterClass() {
  }

}
