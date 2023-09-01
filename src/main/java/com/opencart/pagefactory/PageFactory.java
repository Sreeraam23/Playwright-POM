package com.opencart.pagefactory;

import java.io.FileInputStream;	
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PageFactory {
	
	Properties prop;
//	Playwright playwright;
//	Browser browser;
//	BrowserContext context;
//	Page page;
	
	private static ThreadLocal<Playwright> tlplaywright = new ThreadLocal<>();
	private static ThreadLocal<Browser> tlbrowser = new ThreadLocal<>();
	private static ThreadLocal<BrowserContext> tlcontext = new ThreadLocal<>();
	private static ThreadLocal<Page> tlpage = new ThreadLocal<>();
	
	public static Playwright getPlaywright() {
		return tlplaywright.get();
	}
	public static Browser getBrowser() {
		return tlbrowser.get();
	}
	public static BrowserContext getContext() {
		return tlcontext.get();
	}
	public static Page getPage() {
		return tlpage.get();
	}
	
	
	
	/**
	 * My property  file 
	 * @throws IOException 
	 */
	public Properties init_prop() throws IOException {
		FileInputStream fin = new FileInputStream("./src/test/resources/config/config.properties");
		prop = new Properties();
		prop.load(fin);
		return prop;
	}
	
	public Page intialBrowser() {
		String browsername = prop.getProperty("browser");
//		playwright = Playwright.create();
		tlplaywright.set(Playwright.create());
		switch (browsername.toLowerCase()) {
		
		case "chromium":
			tlbrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)));
//			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			
			break;
			
		case "firefox":
			tlbrowser.set(getPlaywright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false)));
//			browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
			
		case "safari":
			tlbrowser.set(getPlaywright().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false)));
//			browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
			
		case "edge":
			tlbrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("edge")));
//			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("edge"));
			break;
			
		case "chrome":
			tlbrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome")));
//			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
			break;


		default:
			System.out.println("Type a valid browser");
			break;
		}
//		context = browser.newContext();
		tlcontext.set(getBrowser().newContext());
//		page = context.newPage();
		tlpage.set(getContext().newPage());
//		page.navigate(prop.getProperty("url"));
		getPage().navigate(prop.getProperty("url"));
		return getPage();
	}
	
	public static String takeScreenshot() {
		String path = System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png";
		byte[] buffer = getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
		String base64encode = Base64.getEncoder().encodeToString(buffer);
		return base64encode;
	}
	
	
}
