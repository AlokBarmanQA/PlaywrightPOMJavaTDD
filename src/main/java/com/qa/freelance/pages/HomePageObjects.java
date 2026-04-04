package com.qa.freelance.pages;

import com.microsoft.playwright.Page;

public class HomePageObjects {
	
	private Page page;
	
	//Locators
	private String link_cart="//button[normalize-space()='Cart']";
	private String link_manage="//span[normalize-space()='Manage']";
	
	
	public HomePageObjects(Page page) {
		this.page=page;
	}
	
	public String verifyCartLink() {
		return page.textContent(link_cart);
	}
	
	public String verifyManageLink() {
		return page.textContent(link_manage);
	}
}
