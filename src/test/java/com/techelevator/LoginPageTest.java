package com.techelevator;

import static org.junit.Assert.assertNotNull;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginPageTest<webDriver1> {
	
	private static WebDriver webDriver;
	
	/* Creating an instance of the WebDriver is time consuming
	 * since it opens up a browser window. Therefore, we do this
	 * only once at the start of the class and reuse the same
	 * browser window for all tests. */
	@BeforeClass
	public static void openWebBrowserForTesting() {
		
		String homeDir = System.getProperty("user.home"); // ~ or $HOME
		/* The ChromeDriver requires a system property with the name "webdriver.chrome.driver" that
		 * contains the directory path to the ChromeDriver executable. The following line assumes
		 * we have installed the ChromeDriver in a known location under our home directory */
		System.setProperty("webdriver.chrome.driver", homeDir+"/dev-tools/chromedriver/chromedriver");
		webDriver = new ChromeDriver();
	}

	@Before
	public void openHomePage() {
		webDriver.get("http://localhost:8080/capstone/");
	}
	
	@AfterClass
	public static void closeWebBrowser() {
		webDriver.close();
	}



//	public SurveyInputPage(WebDriver webDriver) {
//		this.webDriver1 = webDriver;
//	}
//	
	@Test
	public void clickLoginLink() {
		WebElement LoginLink = webDriver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[2]/li[2]/a"));
		LoginLink.click();
		//return new SurveyInputPage (webDriver1);
	}
	
	@Test
	public void clickUserName() {
		WebElement clickUserName = webDriver.findElement(By.xpath("//*[@id=\\\"userName\\\"]"));
		clickUserName.click();
		//return new SurveyInputPage (webDriver1);
	}
	
	@Test
	public void  enterUserName() {
		WebElement userName = webDriver.findElement(By.xpath("//*[@id=\"userName\"]"));
		userName.sendKeys("ipp");
		//return this;
	}
	@Test
	public void clickPassword() {
		WebElement clickPassword = webDriver.findElement(By.xpath("//*[@id=\"password\"]"));
		clickPassword.click();
		//return new SurveyInputPage(webDriver1);
	}
	@Test
	public void enterPassword() {
		WebElement password = webDriver.findElement(By.id("//*[@id=\\\"password\\\"]"));
		password.sendKeys("ipp");
		//return new SurveyInputPage(webDriver1);
	}
	
	@Test
	public void  login() {
		WebElement goToPage = webDriver.findElement(By.xpath("/html/body/div/div/div[2]/form/button"));
		goToPage.click();
		//return this;
	}
	
	@Test
	public void single_elements_can_be_found_by_tag_name() {
		WebElement header = webDriver.findElement(By.tagName("header"));
		WebElement footer = webDriver.findElement(By.tagName("footer"));
		assertNotNull(header);
		assertNotNull(footer);
	}
}


