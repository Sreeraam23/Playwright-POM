package com.opencart.pages;


import com.microsoft.playwright.Page;

public class ProductPage {
	private Page page;
	
	private String product1 = "//h4/a[text()='MacBook']";
	private String product_check = "//li/a[text()='MacBook']";
	private String price = "//li/h2";
	private String quantity = "div input#input-quantity";
	private String prod_heading = "//div/h1[text()='MacBook']";
	private String add_to_cart = "//button[text()='Add to Cart']";	
	private String go_cart_btn = "button.btn.btn-inverse.btn-block.btn-lg.dropdown-toggle";
	private String viewcart_btn = "//p/a[contains(@href, 'checkout/cart')]";
	
	public ProductPage(Page page) {
		this.page = page;
	}
	
	
	public String select() {
		page.click(product1);
		String prod_name = page.locator(product_check).textContent();
		return prod_name;
	}
	
	public boolean price() {
		boolean price_check = page.locator(price).isVisible();
		return price_check;
	}
	
	public boolean quantity(){
		boolean quantity_check = page.locator(quantity).isEditable();
		return quantity_check;
	}
	
	public String headingCheck() {
		String heading_check = page.locator(prod_heading).textContent();
		return heading_check;
	}
	
	public boolean additem() {
		page.click(add_to_cart);
		boolean text = page.locator(go_cart_btn).isVisible();
		return text;
	}
	public boolean gotocart() {
		boolean ispresent  = page.locator(go_cart_btn).isEnabled();
		page.click(go_cart_btn);
		return ispresent;
	}
	
	public CartPage navigateToCart() {
		page.click(go_cart_btn);
		page.click(viewcart_btn);
		return new CartPage(page);
	}
}
