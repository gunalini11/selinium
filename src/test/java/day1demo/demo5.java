package day1demo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class demo5 {
	WebDriver driver;
  @Test
  public void f() {
	  driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
	  driver.manage().window().maximize();
	  driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul/li[1]/a")).click();
	  driver.findElement(By.cssSelector("input#userName")).sendKeys("Admin");
	  driver.findElement(By.cssSelector("input#password")).sendKeys("Password456");
	  driver.findElement(By.xpath("//input[@type='submit']")).click();
	  driver.findElement(By.xpath("/html/body/main/div/div/div/div[4]/button/h4")).click();
	  WebElement dd=(WebElement) new Select(driver.findElement(By.name("categorydropname")));
	  Select s=new Select(dd);
	  List<WebElement> values =s.getOptions();
	  for(WebElement e:values)
	  {
		 String option = e.getText();
		 if(option.equals("Electronics"));
		 {
			 s.selectByVisibleText(option);
			 int flag = 1;
			 break;
		 }
	  }
	  
	  //dd.selectByVisibleText("Electronics");
		int flag = 0;
		if(flag==1)
		{
			WebElement sub = driver.findElement(By.id("subcategorydropid"));
			Select s1 = null;
			List<WebElement> newvalues=s1.getOptions();
			for(WebElement e:newvalues)
			{
				String option = e.getText();
				if(option.equals("Travel Kit"))
				{
					s1.selectByVisibleText(option);
					break;
				}
					
			}
				driver.findElement(By.xpath("//input[@value='View Products']")).click();
		}
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
