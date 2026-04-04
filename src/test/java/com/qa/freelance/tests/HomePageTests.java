package com.qa.freelance.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.freelance.base.TestBase;

public class HomePageTests extends TestBase {
	
	@Test(priority = 1)
	public void verifyCartLinkLabelTest() {
		homePageObjects = signInPageObjects.navigateToLoginPage("admin@email.com", "admin@123");
		Assert.assertEquals(homePageObjects.verifyCartLink(), "Cart");
		System.out.println("HomePageTests-1");
	}
	
	@Test(priority = 2)
	public void verifyManageLinkLabel() {
		Assert.assertEquals(homePageObjects.verifyManageLink(), "Manage");
		System.out.println("HomePageTests-2");
	}
}
