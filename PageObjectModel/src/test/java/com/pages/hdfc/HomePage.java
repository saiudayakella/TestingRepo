package com.pages.hdfc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	protected WebDriver driver;
	private By PayPremium = By.xpath("//p[contains(text(),'Pay Premium')]");
	private By BuyInsuranceOnline = By.xpath("//span[contains(text(),'Buy Life Insurance')]");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public String getHomePageTitle() {
		return driver.getTitle();
	}

	public boolean verifHomePageTitle(String expPageTitle) {
		return getHomePageTitle().contains(expPageTitle);
	}

	public PayPremiumPage navigateToPayPremiumPage() {
		driver.findElement(PayPremium).click();
		return new PayPremiumPage(driver);
	}

	public EasyHealthPlanPage navigateToEasyHealthPlanPage() {
		driver.findElement(BuyInsuranceOnline).click();
		return new EasyHealthPlanPage(driver);
	}

}
