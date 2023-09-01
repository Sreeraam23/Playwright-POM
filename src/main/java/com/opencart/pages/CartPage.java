package com.opencart.pages;

import com.microsoft.playwright.Page;

public class CartPage {
	
//	private static final int INDEX = 1;
	private String quantity_edit = "div.input-group.btn-block input.form-control";
	private String coupon = "//h4/a[@href='#collapse-coupon']";
	private String input_coupon = "div input#input-coupon";
	private String button_coupon = "div input#button-coupon";
	private String gift = "//h4/a[@href='#collapse-voucher']";
	private String input_gift = "input#input-voucher";
	private String button_gift = "input#button-voucher";
	private String error = "div.alert.alert-danger.alert-dismissible";
	private String checkout_btn = "//div[@class='pull-right']/a";
	private Page page;
	
	public CartPage(Page page) {
		this.page = page;
	}
	
	public String getTitle() {
		String title = page.title();
		return title;
	}
	
	public boolean editQuantity() {
		page.locator(quantity_edit).press("Backspace");
		page.locator(quantity_edit).type("2");
		boolean quants = page.locator(quantity_edit).equals("1");
		return quants;
	}
	
	public boolean no_coupon() throws InterruptedException {
		page.click(coupon);
		page.click(button_coupon);
		Thread.sleep(2000);
		boolean isdisp = page.locator(error).isVisible();
		return isdisp;
	}
	
	public boolean coupon_error() {
		page.click(coupon);
		page.locator(input_coupon).type("dfnwsdkcj");
		page.click(button_coupon);
		boolean iserror = page.locator(error).isVisible();
		return iserror;
	}
	
	public boolean no_gift() {
		page.click(gift);
		page.click(button_gift);
		boolean ismssg  = page.locator(error).isVisible();
		return ismssg;
	}
	
	public boolean girft_error() {
		page.click(gift);
		page.locator(input_gift).type("dfnwsdkcj");
		page.click(button_gift);
		boolean isgerror = page.locator(error).isVisible();
		return isgerror;
	}
	
	public boolean checkout_btn() {
		boolean isedit = page.locator(checkout_btn).isEditable();
		return isedit;
	}
	
	public CheckoutPage navigateTocheckout() {
		page.click(checkout_btn);
		return new CheckoutPage(page);
	}
}
