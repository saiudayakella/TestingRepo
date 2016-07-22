package com.pages.hdfc;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PayPremiumOnlinePage {
	
	protected WebDriver driver;
	private By policyNumber=By.id("txtPolicyno");
	private By dateOfBirth=By.id("txtbd");
	private By name=By.id("txtfname");
	private By dueDate=By.id("txtduedate");
	private By amount=By.id("renewal_amount");
	private By yourEmailId=By.id("txtemailid");
	private By confirmButton=By.id("btnConfirmPol");
	private By errorMessage=By.id("lblMsg");
	
	public PayPremiumOnlinePage(WebDriver driver){
		this.driver=driver;
	}
	
	public String getPayPremiumOnlinePageTitle(){
		System.out.println(driver.getTitle());
		System.out.println(driver.getWindowHandle());
		return driver.getTitle();
	}
 
	public boolean verifyPayPremiumOnlinePageTitle(String expPageTitle){
		return getPayPremiumOnlinePageTitle().contains(expPageTitle);
	}
	
	public String fillForm(String polNum){
		enterPolicyNumber(polNum);
		enterDateOfBirth("");
		return getErrorMessage();
		
	}
	public String getErrorMessage(){
		String errMsgText=null;
		WebElement errTxt=driver.findElement(errorMessage);
		if(errTxt.isDisplayed()){
			errMsgText=errTxt.getText();
		}
			return errMsgText;
		
	}
	
	public void enterPolicyNumber(String polNum){
		WebElement policyNum=driver.findElement(policyNumber);
		if(policyNum.isDisplayed()&&policyNum.isEnabled())
		{
			policyNum.sendKeys(polNum);
			
		}
		return;
	}
	public void enterDateOfBirth(String birthDate){
		WebElement dateOfBir=driver.findElement(dateOfBirth);
		if(dateOfBir.isDisplayed()&&dateOfBir.isEnabled()){
			dateOfBir.sendKeys(birthDate);
		}
		return;
	}
	
   public void clickConfirmButton()
   {
	   WebElement confirmBtn=driver.findElement(confirmButton);
	   if(confirmBtn.isEnabled())
	   {
		   confirmBtn.click();
	   }
	   return;
   }
}
