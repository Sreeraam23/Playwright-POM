package com.opencart.pages;

import com.microsoft.playwright.Page;

public class CheckoutPage {
	
	private String existing_radio = "//input[@value='existing']";
	private String new_radio = "//input[@value='new']";
	private String firstname = "input#input-payment-firstname";
	private String lastname = "input#input-payment-lastname";
	private String address_1 = "input#input-payment-address-1";
	private String city = "input#input-payment-city";
	private String pincode = "input#input-payment-postcode";
	private String country = "//select[@class='form-control']//option[text()='India']";
	private String state = "//select[@class='form-control']//option[text()='Tamil Nadu']";
	private String cred_btn = "input#button-payment-address";
	private String textarea = "textarea.form-control";
	private String terms_btn = "//div[@class='pull-right']/input[@name='agree']";
	private String pay_btn = "//div[@class='pull-right']/input[@id='button-payment-method']";
	
	private Page page;
	
	public CheckoutPage(Page page) {
		this.page = page;
	}
	public boolean use_existing_address() {
		page.click(existing_radio);
		boolean isclicked = page.locator(existing_radio).isEnabled();
		return isclicked;
	}
	
	public boolean new_address() {
		page.click(new_radio);
		page.locator(firstname).type("Arun");
		page.locator(lastname).type("Yash");
		page.locator(address_1).type("No 2,Anna Nagar, 2nd street,Chennai");
		page.locator(city).type("Chennai");
		page.locator(pincode).type("01");
		page.click(country);
		page.click(state);
		page.click(cred_btn);
		boolean click_btn = page.locator(cred_btn).isEditable();
		return click_btn;
	}
	
	public String pay() {
		page.locator(textarea).type("Gpay");
		String pay_method = page.locator(textarea).textContent() ;
		page.click(terms_btn);
		page.click(pay_btn);
		return pay_method;
	}
}
