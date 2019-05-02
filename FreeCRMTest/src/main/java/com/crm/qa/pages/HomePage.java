package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase  {
	
	@FindBy(xpath="//span[@class='user-display']")
	WebElement userNameLabel;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement newContactLink;
	
	
	
	//Initializing the page Objects
		public HomePage(){
			PageFactory.initElements(driver, this);
		}
		
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
		
	}
	public ContactsPage clickOncontactsLink() throws InterruptedException{
		contactsLink.click();
		Thread.sleep(2000);
		return new ContactsPage();
	}
	public DealsPage clickOndealsLink(){
		dealsLink.click();
		return new DealsPage();
	}
	public TasksPage clickOntaskssLink(){
		tasksLink.click();
		return new TasksPage();
	}
	public void clickOnNewContactsLink(){
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
	}
}
