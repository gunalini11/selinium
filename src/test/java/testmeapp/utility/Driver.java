package testmeapp.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class Driver {
  @Test
	  public class DriverUtility {
			
			public WebDriver getDriver(String browser)
			{
				if(browser.equals("chrome"))
				{
					System.setProperty("webdriver.chrome.driver","C:\\Users\\training_c2a.05.08\\Desktop\\Selium 3.0\\Selium 3.0\\chromedriver.exe");
					return new ChromeDriver();
				}
				else if(browser.equals("firefox"))
				{
					System.setProperty("webdriver.gecko.driver","C:\\Users\\training_c2a.05.08\\Desktop\\Selium 3.0\\Selium 3.0\\geckodriver.exe");
					return new FirefoxDriver();
				}
				else if(browser.equals("ie"))
				{
					System.setProperty("webdriver.ie.driver","C:\\Users\\training_c2a.05.08\\Desktop\\Selium 3.0\\Selium 3.0\\IEDriverServer.exe");
					return new InternetExplorerDriver();
				}
				else
				{
					return null;
				}
			}

		}
}


