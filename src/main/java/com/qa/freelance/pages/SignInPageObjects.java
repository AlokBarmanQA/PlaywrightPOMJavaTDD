package com.qa.freelance.pages;

//import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SignInPageObjects {
	
	private Page page;
	
//	private Locator label_loginPageHeader;
//	private Locator label_SinIn;
//	private Locator textfield_email;
//	private Locator textfield_password;
//	private Locator button_Signin;
//	private Locator link_newuserSignup;
//	private Locator label_Connectwithus;
	
	private String label_loginPageHeader="//h1[normalize-space()='Learn Automation Courses']";
	private String label_SinIn="//h2[normalize-space()='Sign In']";
	private String textfield_email="#email1";
	private String textfield_password="#password1";
	private String button_Signin=".submit-btn";
	private String link_newuserSignup="//a[normalize-space()='New user? Signup']";
	private String label_Connectwithus="//h2[normalize-space()='Connect with us']";
	private String image_signout="//img[@alt='menu']";
	private String button_signout="//button[normalize-space()='Sign out']";
			
	public SignInPageObjects(Page page) {
		this.page=page;
//		label_loginPageHeader=this.page.getByPlaceholder("Learn Automation Courses");
//		label_SinIn=this.page.getByPlaceholder("//h2[normalize-space()='Sign In']");
//		textfield_email=this.page.getByPlaceholder("#email1");
//		textfield_password=this.page.getByPlaceholder("#password1");
//		button_Signin=this.page.getByPlaceholder(".submit-btn");
//		link_newuserSignup=this.page.getByPlaceholder("//a[normalize-space()='New user? Signup']");
//		label_Connectwithus=this.page.getByPlaceholder("//h2[normalize-space()='Connect with us']");
	}
	
	public String verifyLoginPageTitle() {
		return page.title();
	}
	
	public String verifyLoginPageUrl() {
		return page.url();
	}
	
	public String verifyLoginPageHeader() {
		return page.textContent(label_loginPageHeader);
	}
	
	public String verifySignInLabel() {
		return page.textContent(label_SinIn);
	}
	
	public HomePageObjects navigateToLoginPage(String user, String pass) {
		page.fill(textfield_email, user);
		page.fill(textfield_password, pass);
		page.click(button_Signin);
		return new HomePageObjects(page);
	}
	
	public String verifyNewuserSignupLink() {
		return page.textContent(link_newuserSignup);
	}
	
	public String verifyConnectwithusLabel() {
		return page.textContent(label_Connectwithus);
	}
	
	public void signout() {
		page.click(image_signout);
		page.click(button_signout);
	}
	
}
