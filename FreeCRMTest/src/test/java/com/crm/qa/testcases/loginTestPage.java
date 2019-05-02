package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class loginTestPage extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	
	public loginTestPage(){
		super();
	}
	//super class lai lai call garepaci when we initialization method it will
	//not throw null pointer exception.
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage= new LoginPage();
	}
	
	/*@Test
	public void LoginPageTitleTest(){
		loginpage.validateLoginPage();
		Assert.		
	}
	
	*/
	@Test(priority=1)
	public void loginTest() throws InterruptedException{
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	}
	

	@AfterMethod
	public void teardown(){
		driver.close();
	}
	
	
	
	
	

}
