package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtil;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public HomePageTest(){
		super();                   // property will be initialized in base class
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
		testUtil =new TestUtil();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));			
	}
	
	@Test(priority=3)
	public void verifyHomePageTitleTest(){
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM", "Home page Title not matched" );
		
	}
	@Test(priority=2)
	public void verifyUserNameTest(){
		//testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());		
	}
	
	@Test(priority=1)
	public void verifyContactsLinkTest() throws InterruptedException{	
		contactsPage = homePage.clickOncontactsLink();
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	

}
