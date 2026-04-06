package com.qa.freelance.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class PlaywrightConnection {
	
	Playwright playwright;
	Browser browser;
	BrowserContext context;
	protected Page page;
	Properties prop;
	
	public Page initializeBrowser(Properties prop) {
		
		String browserName = prop.getProperty("browser.name").trim();
		playwright = Playwright.create();
		
		switch (browserName.toLowerCase()) {
		case "chromium":
			browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false).setSlowMo(1000));
			break;
		case "firefox":
			browser = playwright.firefox().launch(new LaunchOptions().setHeadless(false).setSlowMo(100));
			break;
		case "safari":
			browser = playwright.webkit().launch(new LaunchOptions().setHeadless(false).setSlowMo(100));
			break;	
		case "chrome":
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
			break;	
		case "edge":
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false));
			break;	
		default:
			System.out.println("Browser name is not valid ...");
			break;
		}
		context = browser.newContext();
		page = context.newPage();
		page.navigate(prop.getProperty("env.baseurl").trim());
		return page;
	}
	
	public Properties initializeProperties() {
		try {
			FileInputStream fis = new FileInputStream("./src/test/resources/resources/application.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}
