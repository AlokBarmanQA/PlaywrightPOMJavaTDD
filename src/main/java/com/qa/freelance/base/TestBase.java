package com.qa.freelance.base;

import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.microsoft.playwright.Page;
import com.qa.freelance.pages.HomePageObjects;
import com.qa.freelance.pages.SignInPageObjects;

public class TestBase {
	
	PlaywrightConnection pc;
	Page page;
	protected Properties prop;
	protected SignInPageObjects signInPageObjects;
	protected HomePageObjects homePageObjects;
	
	//@Parameters({"browser"})
	@BeforeClass
	public void setup() {
		pc = new PlaywrightConnection();
		prop = pc.initializeProperties();
		page = pc.initializeBrowser(prop);
		signInPageObjects = new SignInPageObjects(page);
		homePageObjects = new HomePageObjects(page);
	}
	
	@AfterClass
	public void dispose() {
		page.context().browser().close();
	}
}
