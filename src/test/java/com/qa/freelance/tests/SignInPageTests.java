package com.qa.freelance.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.freelance.base.TestBase;
import com.qa.freelance.constant.ApplicationEnum;
//import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SignInPageTests extends TestBase {
	
	@Test(priority = 1)
	public void verifyLoginPageTitleTest() {
		String actualtitle = signInPageObjects.verifyLoginPageTitle();
		Assert.assertEquals(actualtitle, ApplicationEnum.LOGIN_PAGE_TITLE);
		System.out.println("SignInPageTests-1");
	}
	
	@Test(priority = 2)
	public void verifyLoginPageUrlTest() {
		String actualUrl = signInPageObjects.verifyLoginPageUrl();
		Assert.assertEquals(actualUrl, prop.get("env.baseurl"));
		System.out.println("SignInPageTests-2");
	}
	
	@Test(priority = 3)
	public void verifyLoginPageHeaderTest() {
		Assert.assertEquals(signInPageObjects.verifyLoginPageHeader(), ApplicationEnum.LOGIN_PAGE_HEADER);
		//assertThat(page.Locator(label_loginPageHeader).hasText("Learn Automation Courses"));
		System.out.println("SignInPageTests-3");
	}
	
	@Test(priority = 4)
	public void verifySignInLabelTest() {
		Assert.assertEquals(signInPageObjects.verifySignInLabel(), "Sign In");
		System.out.println("SignInPageTests-4");
	}
	
	@Test(priority = 5)
	public void verifyNewuserSignupLinkTest() {
		Assert.assertEquals(signInPageObjects.verifyNewuserSignupLink(), "New user? Signup");
		System.out.println("SignInPageTests-5");
	}
	
	@Test(priority = 6)
	public void verifyConnectwithusLabelTest() {
		Assert.assertEquals(signInPageObjects.verifyConnectwithusLabel(), "Connect with us");
		System.out.println("SignInPageTests-6");
	}
	
	@Test(priority = 7)
	public void loginToApplicationTest() {
		signInPageObjects.navigateToLoginPage("admin@email.com", "admin@123");
		System.out.println("SignInPageTests-7");
	}
}
