package com.crm.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtil;

public class ContactsPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	String sheetName = "contacts";
	
	public ContactsPageTest(){
		super();                   // property will be initialized in base class
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
		testUtil =new TestUtil();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));	
		contactsPage = homePage.clickOncontactsLink();
	}
	
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][]=testUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority =1)
	public void verifyContactsPagelabelTest(){
		Assert.assertTrue(contactsPage.verifyContactsLabel());
	}
	
	
	@Test(priority =2)
	public void selectDropDownTest(){
		contactsPage.verifyDropDown();
		}
	
	@Test(priority =3, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String firstname,String lastname, String company ){
		homePage.clickOnNewContactsLink();
		//contactsPage.createNewcontact("Jason", "Nash", "Google");
		contactsPage.createNewcontact(firstname, lastname, company);
		
		}	
	
	
	
	
		
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
