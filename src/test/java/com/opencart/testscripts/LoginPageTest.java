package com.opencart.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.applicationconstants.ApplicationConstants;
import com.opencart.testbase.CaseTestBase;

public class LoginPageTest extends CaseTestBase{
	
	@Test(priority=6)
	public void titleTest() {
		login = home.navigatetoLogin();
		String title = login.loginTitle();
		Assert.assertEquals(title, ApplicationConstants.LOGINTITLE);
	}
	
	@Test(priority=7)
	public void linkTest() throws InterruptedException {
		Thread.sleep(2000);
		boolean link  = login.forgotpassword();
		Assert.assertEquals(link, true);
	}
	
	@Test(priority=8)
	public void credentials() {
		boolean is_entered = login.enterDetails();
		Assert.assertEquals(is_entered, true);
	}
	
	
}
