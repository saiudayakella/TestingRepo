package com.pages.hdfc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PayPremiumPage {
protected WebDriver driver;
private By PayPremiumOnline=By.xpath("//span[contains(text(),'Premium Online')]");
	public PayPremiumPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private String getPayPremiumPageTitle(){
		return driver.getTitle();
	}
    
	public boolean verifyPayPremiumPageTitle(String expPageTitle){
		return getPayPremiumPageTitle().contains(expPageTitle);
	}
	
	public PayPremiumOnlinePage navigateToPayPremiumOnlinePage(){
		driver.findElement(PayPremiumOnline).click();
		ArrayList<String> tabs=new ArrayList<String> (driver.getWindowHandles());
		
		for(String t:tabs){
		driver.switchTo().window(t);
		System.out.println(driver.getWindowHandle());
		}
		//driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		//WebDriverWait wait=new WebDriverWait(driver,10);
		//wait.until(ExpectedConditions.titleContains("HDFC STANDARD LIFE"));
		System.out.println(driver.getWindowHandle());
		return new PayPremiumOnlinePage(driver);
	}
}
