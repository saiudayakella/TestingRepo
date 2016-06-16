package com.pageobjectmodel.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PgFact {
WebDriver driver;
  @BeforeMethod
  public void initialize()
  {
	  System.setProperty("webdriver.chrome.driver", "D:\\Technical Software\\chromedriver_win32\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("http://www.gmail.com");
  }
  @Test
  public void callPage() {
	  PageObFramework pf=PageFactory.initElements(driver, PageObFramework.class);
	  pf.loginToWebpage("saiudayakella", "invalid");
	  WebDriverWait wait=new WebDriverWait(driver,5);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='errormsg_0_Passwd']")));
	  String errorText=driver.findElement(By.xpath("//span[@id='errormsg_0_Passwd']")).getAttribute("innerHTML");
	  System.out.println(errorText);
	  
	  //Assert.assertTrue(!driver.getTitle().contains("Inbox"));
  }
}
