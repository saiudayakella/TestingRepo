package com.pageobjectmodel.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObFramework {
	
	WebDriver driver;
	
	public PageObFramework(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(how=How.NAME, using="Email") 
	WebElement username;
	
	@FindBy(how=How.XPATH,using="//input[@id='next']")
	WebElement nextBtn;
	
	@FindBy(how=How.XPATH,using="//input[@id='Passwd']")
	WebElement password;
	
	public void loginToWebpage(String uname,String pwd)
	{
		username.sendKeys(uname);
		nextBtn.click();
		WebDriverWait wait=new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Passwd']")));
		password.sendKeys(pwd);
				
	}

}
