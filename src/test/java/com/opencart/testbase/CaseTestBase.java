package com.opencart.testbase;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.opencart.pagefactory.PageFactory;
import com.opencart.pages.CartPage;
import com.opencart.pages.CheckoutPage;
import com.opencart.pages.HomePage;
import com.opencart.pages.LoginPage;
import com.opencart.pages.ProductPage;

public class CaseTestBase {
	PageFactory pf; 
	Page page;
	protected HomePage home;
	protected LoginPage login;
	protected ProductPage product;
	protected CartPage cart;
	protected CheckoutPage check;
	protected Properties prop;
	
	
	@BeforeTest
	public void setup() throws IOException {
		pf = new PageFactory();
		prop = pf.init_prop();
		page = pf.intialBrowser();
		home = new HomePage(page);
	}
		
	@AfterTest
	public void tear() {
		page.context().close();
	}
}
