package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement contactsLabel;
	
	@FindBy(xpath="//div[@name='action']//i[@class='dropdown icon']")
	WebElement dropDownLabel;
	
	@FindBy(name="first_name")
	WebElement firstName ;
	
	@FindBy(name="last_name")
	WebElement lastName ;
	
	@FindBy(xpath ="//div[@name='company']//input[@type='text']")
	WebElement company ;
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement saveButton ;
	
	//Initializing the page Objects
	public ContactsPage(){
	PageFactory.initElements(driver, this);
}
	public boolean verifyContactsLabel(){
		return contactsLabel.isDisplayed();
	}
	
	
	
	public void verifyDropDown(){
	Select dropdown = new Select(dropDownLabel);
	dropdown.selectByVisibleText("Delete");
	}
	
	public void createNewcontact(String ftName, String ltName,String cmpny){
		
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(cmpny);
		/* Select select = new Select(driver.findElement(By.xpath("//div[@name='source']//i[@class='dropdown icon']")));
		select.deselectByVisibleText(sourceName); */
		saveButton.click();
	}

}
