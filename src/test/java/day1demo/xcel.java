package day1demo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class xcel {
	WebDriver driver;
  @Test
  public void f() throws IOException {
	  
	  File src=new File("C:\\Users\\training_c2a.05.08\\Desktop\\New Microsoft Excel Worksheet (2).xlsx");
	  FileInputStream fis=new FileInputStream(src);
	  XSSFWorkbook wb=new XSSFWorkbook(fis);
	  XSSFSheet sheet1=wb.getSheetAt(0);
	  String data0=sheet1.getRow(0).getCell(0).getStringCellValue();
	  //System.out.println("data from excel is : "+data0);
	  driver.findElement(By.name("userName")).sendKeys(data0);
	  String data1=sheet1.getRow(0).getCell(1).getStringCellValue();
	  //System.out.println("data from excel is : "+data1);
	  driver.findElement(By.name("password")).sendKeys(data1);
	  driver.findElement(By.name("Login")).submit();
	  Assert.assertEquals(driver.getTitle(),"Home");
	  sheet1.getRow(0).createCell(2).setCellValue("passed");
	  FileOutputStream fout=new FileOutputStream(new File("C:\\Users\\training_c2a.05.08\\Desktop\\New Microsoft Excel Worksheet (2).xlsx"));
	  wb.write(fout);
	  wb.close();
	  }
  
  @BeforeClass
  public void beforeClass() { System.setProperty("webdriver.chrome.driver","C:\\Users\\training_c2a.05.08\\Desktop\\Selium 3.0\\Selium 3.0\\chromedriver.exe");
  driver=new ChromeDriver();
  driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
  driver.manage().window().maximize();
  }

  @AfterClass
  public void afterClass() {
  }

}
