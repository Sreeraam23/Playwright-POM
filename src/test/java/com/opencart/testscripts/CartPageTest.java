package com.opencart.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.applicationconstants.ApplicationConstants;
import com.opencart.testbase.CaseTestBase;

public class CartPageTest extends CaseTestBase{

	@Test(priority=13)
	public void titleTest() {
		login = home.navigatetoLogin();
		login.enterDetails();
		product = login.navigateToproduct();
		cart = product.navigateToCart();
		String title_test = cart.getTitle();
		Assert.assertEquals(title_test, ApplicationConstants.CART_TITLE);
	}
	
	@Test(priority=14)
	public void quantityTest() {
		boolean quantity = cart.editQuantity();
		Assert.assertEquals(quantity, false);
	}
	
	@Test(priority=15)
	public void noCouponTest() throws InterruptedException {
		boolean no_coupon_error = cart.no_coupon();
		Assert.assertEquals(no_coupon_error, true);
	}
	
	@Test(priority=16)
	public void noGiftTest() {
		boolean no_gift_error = cart.no_gift();
		Assert.assertEquals(no_gift_error, true);
	}
	
	@Test(priority=17)
	public void invalidCoupon() {
		boolean coupon_error = cart.coupon_error();
		Assert.assertEquals(coupon_error, true);
	}
	
	@Test(priority=18)
	public void invalidGift() {
		boolean gift_error = cart.no_gift();
		Assert.assertEquals(gift_error, true);
	}
	
	@Test(priority=19)
	public void checkoutTest() {
		boolean isclick = cart.checkout_btn();
		Assert.assertEquals(isclick, true);
	}
}
