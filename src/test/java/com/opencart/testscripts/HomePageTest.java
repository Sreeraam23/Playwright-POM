package com.opencart.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.applicationconstants.ApplicationConstants;
import com.opencart.testbase.CaseTestBase;

public class HomePageTest extends CaseTestBase{
	
	@Test(priority=1)
	public void titleTest() {
		String title = home.getTitle();
		Assert.assertEquals(title, ApplicationConstants.HOMETITLE);
	}
	
	@Test(priority=2)
	public void urlTest() {
		String url = home.getURL();
		Assert.assertEquals(url, ApplicationConstants.HOMEURL);
	}
	
	@Test(priority=3)
	public void selectionTest() {
		String message = home.dosearch();
		Assert.assertEquals(message, ApplicationConstants.HOMESEARCH);
	}
		
	@Test(priority=4)
	public void itemList() {
		int count = home.selectMenu();
		Assert.assertEquals(count, 8);
	}
	
}
