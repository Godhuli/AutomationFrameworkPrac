package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase  {
	//Page Factory (Object Repository)
	
	
	
	@FindBy(name="email")//similar to driver.findelement by name
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement LoginSubmitBtn;
	
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement SignUp;
	
	//Initializing the page Objects
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPage(){
		return driver.getTitle();
	}
	
	public HomePage login(String un,String pwd) throws InterruptedException{
		email.sendKeys(un);
		password.sendKeys(pwd);	
		LoginSubmitBtn.click();
		Thread.sleep(2000);
		
		return new HomePage();
	}
	

}
