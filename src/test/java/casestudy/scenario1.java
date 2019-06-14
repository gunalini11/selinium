package casestudy;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class scenario1 {
	WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest logger;
	ExtentReports reports;
	ExtentHtmlReporter htmlreporter;
	
  @Test(priority=2)
  public void testlogin() {
        logger=extent.createTest("passTest");
      //driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul/li[1]/a")).click();
	  driver.findElement(By.xpath("//*[@id=\"userName\"]")).sendKeys("anu5");
	  driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("gunalini11");
	  driver.findElement(By.name("Login")).submit();
	  //Assert.assertTrue(true);
	  Assert.assertEquals(driver.getTitle(),"Home");
  }
	  
  @Test(priority=3)
  public void testcart() {
	  logger=extent.createTest("passTest");
	 
	 
	   driver.findElement(By.name("products")).sendKeys("bag");
		
		driver.findElement(By.cssSelector("body > div.col-md-12.col-sm-12.col-xs-12 > form > input[type=submit]")).click();
		driver.findElement(By.cssSelector("body > section > div > div > div.col-sm-9 > div:nth-child(1) > div > div > div:nth-child(3) > center > a")).click();
		//Assert.assertTrue(true);
		Assert.assertEquals(driver.getTitle(),"Search");
  }
  @Test(priority=4)
  public void testpayment() throws InterruptedException {
	  logger=extent.createTest("passTest");
	  
	  driver.findElement(By.cssSelector("#header > div.header-middle > div > div > div.col-sm-8 > div > a:nth-child(2)")).click();
	  driver.findElement(By.cssSelector("#cart > tfoot > tr:nth-child(2) > td:nth-child(5) > a")).click();
	  driver.findElement(By.cssSelector("body > b > div > div > div.col-lg-6.col-md-6.col-sm-6.col-xs-12.col-md-push-6.col-sm-push-6 > div > div.panel-body > div:nth-child(4) > div > form:nth-child(2) > input")).click();
      WebDriverWait wait=new WebDriverWait(driver,100);
      wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#btn"))).click();
	 // driver.findElement(By.cssSelector("#btn")).click();
      driver.findElement(By.cssSelector("#horizontalTab > div.resp-tabs-container > div > div > div > div > form > input[type=text]:nth-child(2)")).sendKeys("anu5");
      driver.findElement(By.cssSelector("#horizontalTab > div.resp-tabs-container > div > div > div > div > form > input[type=password]:nth-child(4)")).sendKeys("gunalini11");
      driver.findElement(By.cssSelector("#horizontalTab > div.resp-tabs-container > div > div > div > div > form > div > div:nth-child(3) > input[type=submit]")).click();
	  
	  Assert.assertEquals(driver.getTitle(),"payment successfull");
	  
	  
  }
 @Test(priority=1)
  public void testregistration() {
	 logger=extent.createTest("passTest");
	  
	  driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul/li[2]/a")).click();
	  driver.findElement(By.xpath("//*[@id=\"userName\"]")).sendKeys("anu5");
	  driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys("guna");
	  driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys("b");
	  driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("gunalini11");
	  driver.findElement(By.xpath("//*[@id=\"pass_confirmation\"]")).sendKeys("gunalini11");
	  driver.findElement(By.xpath("//input[@type='radio'][@value='Female']")).click();
	  driver.findElement(By.xpath("//*[@id=\"emailAddress\"]")).sendKeys("11gunalini@gmail.com");
	  driver.findElement(By.xpath("//*[@id=\"mobileNumber\"]")).sendKeys("6363191405");
	  driver.findElement(By.xpath("//*[@id=\"dob\"]")).sendKeys("01/01/1998");
	  driver.findElement(By.xpath("//*[@id=\"address\"]")).sendKeys("t nagar chennai");
	  driver.findElement(By.xpath("//*[@id=\"securityQuestion\"]")).click();
	  driver.findElement(By.xpath("//*[@id=\"answer\"]")).sendKeys("puducherry");
	  driver.findElement(By.xpath("/html/body/main/div/div/form/fieldset/div/div[13]/div/input[1]")).submit();
	  //Assert.assertTrue(true);
	  Assert.assertEquals(driver.getTitle(),"Login");
	  
  }
  @AfterMethod
  public void getResult(ITestResult result) {
	  if(result.getStatus() == ITestResult.FAILURE) {
		  logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "Test Case Failed", ExtentColor.RED));
		  logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + "Test Case Failed", ExtentColor.RED)); 
	  } else if(result.getStatus() == ITestResult.SKIP) {
		  logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "Test Case skipped", ExtentColor.ORANGE));
	  }
	  else
		  logger.log(Status.PASS,MarkupHelper.createLabel("Test case passed", ExtentColor.GREEN));
	  
	  
  }
  @BeforeClass
  public void beforeclass() { 
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\training_c2a.05.08\\Desktop\\Selium 3.0\\Selium 3.0\\chromedriver.exe");
      driver = new ChromeDriver();
      driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
      driver.manage().window().maximize();
      
      
		
		
	  
  }
 
  @BeforeTest
  public void startreportbeforeTest() {
	  htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/extent-reports/"+new SimpleDateFormat("hh-mm-ss-ms-dd-MM-yyyy").format(new Date(0))+".html");
	  extent = new ExtentReports();
	  
	  extent.attachReporter(htmlReporter);
	  extent.setSystemInfo("Host Name", "GFT nextgen testing");
	  extent.setSystemInfo("Host Name", "GFT nextgen testing");
	  extent.setSystemInfo("Host Name", "GFT nextgen testing");
	  
	   htmlReporter.config().setDocumentTitle("report");
	   htmlReporter.config().setReportName("report");
	   htmlReporter.config().setTheme(Theme.STANDARD);
  }
		
	
  
@AfterTest
  public void endreportafterTest() {
	extent.flush();
	  
  }

}
