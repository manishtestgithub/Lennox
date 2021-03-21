package com.org.basefile;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseFileLynnox {
	public static WebDriver driver;
	public static JavascriptExecutor executor;

	public static WebDriver driverInit(String browserName, String url_name) {

		if (browserName.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}

		else if (browserName.equals("ie")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new InternetExplorerDriver();

		}

		else if (browserName.equals("firefox")) {
			WebDriverManager.iedriver().setup();
			driver = new FirefoxDriver();

		}
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get(url_name);
		
		return driver;
	}

	
	// Find element

	// Ener data
	public static void enterValue(WebElement ele, String value) {
		ele.sendKeys(value);
	}
	//clear the value
	public static void clearValue(WebElement ele) {
		ele.clear();
	}
	
	// Click element
	public static void clickEnter(WebElement ele) {
		ele.click();
	}
	
	public static void javaclick(WebElement jele) {
		executor = (JavascriptExecutor)driver; 
		executor.executeScript("arguments[0].click();", jele);
	}
	
	public static void selectfromdropdown(WebElement ele, String val) {
		Select s = new Select(ele);
		s.selectByVisibleText(val);
	}

	// Close Browser
	public static void closeBrowser() {
		driver.close();
	}

	// Quit Browser
	public static void quitBrowser() {
		driver.quit();
	}

	public static void mouseMove(WebElement ele) {
		Actions acc = new Actions(driver);
		acc.moveToElement(ele).perform();

	}

	public static void moveMouseLeftclick(WebElement ele) {
		Actions acc = new Actions(driver);
		//acc.contextClick(ele).perform();
		
		acc.click().perform();
	}
	
	public void mouseScrollDownaction() {
		
		executor.executeScript("window.scrollBy(0,900)", "");
	}

	public static void waitUntilVisible(int t, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, t);
		wait.until(ExpectedConditions.visibilityOf(ele));
		// driver.manage().timeouts().implicitlyWait(t, TimeUnit.SECONDS);
	}

	public static String currentURL() {
		String currurl = driver.getCurrentUrl();
		return currurl;
	}

	public static void selecDropDown(WebElement ele, String st) {
		Select s = new Select(ele);
		s.deselectByVisibleText(st);

	}

	public static void deleteEnteredValue(WebElement ele) throws AWTException {

		clickEnter(ele);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_DELETE);

	}
	
	public static  String getScreenshot(WebDriver driver) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		String path =System.getProperty("user.dir")+"/Screenshot/test.png";
		File dest=new File(path);
		try {
			FileUtils.copyFile(src,dest);
			System.out.println("Screenshot captured");
		} catch (Exception e) {

		System.out.println("unable to capture screenshot"+e.getMessage());
		}
		
		return path;
	}
}
