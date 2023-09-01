package com.opencart.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
	private Page page;
	private static int index = 1;
	private String emailbox = "input#input-email.form-control";
	private String passwordbox = "input#input-password.form-control";
	private String loginbtn = "//input[@class='btn btn-primary']";
	private String login_valid = "//div/a[text()='My Account']";
	private String forgot_password = "//form//a[text()='Forgotten Password']";
	private String homebtn = "(//ul[@class='breadcrumb']/li/a)["+index+"]";
	
	public LoginPage(Page page) {
		this.page = page;
	}
	
	public String loginTitle() {
		return page.title();
	}
	
	public boolean forgotpassword() {
		boolean present = page.locator(forgot_password).isVisible();
		return present;
	}
	
	public boolean enterDetails() {
		page.locator(emailbox).type("admin@test.com");
		page.locator(passwordbox).type("admin");
		page.click(loginbtn);
		boolean result = page.locator(login_valid).isVisible();
		return result;
	}
	
	public ProductPage navigateToproduct() {
		page.click(homebtn);
		return new ProductPage(page);		
	}
}
