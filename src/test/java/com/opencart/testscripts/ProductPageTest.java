package com.opencart.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.applicationconstants.ApplicationConstants;
import com.opencart.testbase.CaseTestBase;

public class ProductPageTest extends CaseTestBase{
	
	@Test(priority=9)
	public void selectTest() {
		login = home.navigatetoLogin();
		login.enterDetails();
		product = login.navigateToproduct();
		String product_name = product.select();
		Assert.assertEquals(product_name,ApplicationConstants.PRODUCT_NAME );
	}
	
	@Test(priority=10)
	public void priceTest() {
		boolean price_test  = product.price();
		Assert.assertEquals(price_test, true);
	}
	
	@Test(priority=11)
	public void quantityTest(){
		boolean  quantity_test = product.quantity();
		Assert.assertEquals(quantity_test, true);
	}
	
	@Test(priority=12)
	public void headingTest() {
		String heading_test = product.headingCheck();
		Assert.assertEquals(heading_test, ApplicationConstants.PRODUCT_HEADING);
	}
	
	@Test(priority=13)
	public void addTest() {
		boolean item_test = product.additem();
		Assert.assertEquals(item_test, true);
	}
	
	@Test(priority=14)
	public void viewcartTest() {
		boolean isclickable = product.gotocart();
		Assert.assertEquals(isclickable, true);
	}
	
	
}
