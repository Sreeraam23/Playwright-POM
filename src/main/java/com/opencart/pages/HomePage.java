package com.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {
	private Page page;
	
	private String inputfield= "div#search input";
	private String searchbtn = "span.input-group-btn";
	private String menu = "//div/button[@class='btn btn-link dropdown-toggle']";
	private String items = "//ul[@class='nav navbar-nav']/li";
	private String searchmssg = "div#content h1";
	private String myaccount = "//span[text()='My Account']";
	private String login = "//li/a[text()='Login']";
	
	public HomePage(Page page) {
		this.page = page;
	}
	
	public String getTitle() {
		String title = page.title();
		System.out.println(page.title());
		return title;
	}
	
	public String getURL() {
		String url = page.url();
		System.out.println(page.url());
		return url;
	}
	
	public String dosearch() {
		page.locator(inputfield).type("Macbook");
		page.click(searchbtn);
		String message = page.locator(searchmssg).textContent();
		return message;
	}
	
	
	public int selectMenu() {
		page.click(menu);
		int count = page.locator(items).count();
		return count;
	}
	
	public LoginPage navigatetoLogin() {
		page.click(myaccount);
		page.click(login);
		return new LoginPage(page);
	}
	
}
