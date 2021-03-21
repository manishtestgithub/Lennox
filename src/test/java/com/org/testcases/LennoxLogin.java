package com.org.testcases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.org.basefile.BaseFileLynnox;
import com.org.basefile.ConfigReader;
import com.org.basefile.XLUtility;
import com.org.pageobj.*;

public class LennoxLogin extends BaseFileLynnox {
	public ExtentReports extent;
	public static ExtentTest logger;

	@BeforeSuite
	public void setupSuit() {
		ExtentHtmlReporter report = new ExtentHtmlReporter(
				new File(System.getProperty("user.dir") + "/Reports/Lennox.html"));
		extent = new ExtentReports();
		extent.attachReporter(report);
		logger = extent.createTest("LynnoxLogin Test");
	}

	@BeforeClass
	public void loginLennox() {

		ConfigReader config = new ConfigReader();

		logger.info("Launching browser and loading URL");
		driverInit(config.getChroDriver(), config.getAppURL());

		LoginPage loginPage = new LoginPage();
		logger.info("Login to application");
		clickEnter(loginPage.getSignIn_Select());

		enterValue(loginPage.getUser_Name(), "lenproautomation8@lenqat.com");

		enterValue(loginPage.getPass_Word(), "Community17");

		clickEnter(loginPage.getSubmit_Login());

		logger.pass("Login to application has passed");
	}

	@Test(priority = 1)
	public static void menuNavigate() {
		MenuNavigatePage menuNavigatePage = new MenuNavigatePage();
		
	  logger.info("Navigating to build proposal");
		clickEnter(menuNavigatePage.getMenu_Bar_Option());

		clickEnter(menuNavigatePage.getSales_Tool_select());

		clickEnter(menuNavigatePage.getBuild_a_Proposal_select());
		logger.pass("Selected build proposal");
	}

	@Test(priority = 2)
	public static void selectLead() {

		SelectLeadPage selectLeadPage = new SelectLeadPage();
		logger.info("Selecting Lead option");
		try {
			clickEnter(selectLeadPage.getSelect_lead());
		} catch (ElementClickInterceptedException e) {
			javaclick(selectLeadPage.getSelect_lead());
		} catch (Exception e) {
			moveMouseLeftclick(selectLeadPage.getSelect_lead());
		}
		logger.pass("Successfully selected lead");
	}

	@Test(priority = 3)
	public static void addLead() {

		AddLeadPage addLeadPage = new AddLeadPage();
		logger.info("Selecting Add new Lead option");
		
		javaclick(addLeadPage.getAdd_lead_select());
		logger.pass("Successfully Add New Lead selected");
	}

	@DataProvider(name = "DataFillLeadPage")
	public Object[][] getLeadInfo() throws IOException {
		
		// data from string
		String pathsheet = "./DataFile/DataSheet.xlsx";
		XLUtility xlutil = new XLUtility(pathsheet);
		int totalrows = xlutil.getRowCount("Sheet1");
		System.out.println(totalrows);
		int totalcols = xlutil.getCellCount("Sheet1", 1);

		Object leadData[][] = new Object[totalrows-1][totalcols];

		for (int i = 1; i < totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {

				leadData[i - 1][j] = xlutil.getCellData("Sheet1", i, j);
				System.out.print(leadData + " ");
			}
			System.out.println();

		}

		return leadData;

	}

	@Test(priority = 4, dataProvider = "DataFillLeadPage")
	public void dataFillLead(String uname, String lname, String email, String mno, String reqyer, String reqdate,
			String reqtime, String appyear, String appdate, String apptime, String docloc, String doctype,
			String imgloc)
	// public void dataFillLead(int a,ArrayList<String> allValue)
	{
		
		DataFillLeadPage dataFillLeadPage = new DataFillLeadPage();
		logger.info("Entering firstname");
		clearValue(dataFillLeadPage.getFirstname());
		enterValue(dataFillLeadPage.getFirstname(), uname);
		logger.pass("Successfully entered firstname");
		
		logger.info("Entering lastname");
		clearValue(dataFillLeadPage.getLastname());
		enterValue(dataFillLeadPage.getLastname(), lname);
		logger.pass("Successfully entered lastname");
		
		logger.info("Entering EmailID");
		clearValue(dataFillLeadPage.getEmailid());
		enterValue(dataFillLeadPage.getEmailid(), email);
		logger.pass("Successfully entered EmailID");
		
		logger.info("Entering PhoneNumber");
		clearValue(dataFillLeadPage.getPhonenumber());
		enterValue(dataFillLeadPage.getPhonenumber(), mno);
		logger.pass("Successfully entered PhoneNumber");
		
		mouseScrollDownaction();
		mouseScrollDownaction();
		mouseScrollDownaction();

		String req_monthYear = reqyer;
		String req_day = reqdate;

		logger.info("Entering Requested Date");
		clickEnter(dataFillLeadPage.getRequest_date());

		while (true) {
			String text = dataFillLeadPage.getMonth_year_select().getText();
			// System.out.println(text);
			if (text.equals(req_monthYear)) {
				break;
			}
			clickEnter(dataFillLeadPage.getNext_month_year());
		}

		String ele1 = "//a[text()=" + req_day + "]";
		driver.findElement(By.xpath(ele1)).click();
		logger.pass("Successfully entered Requested Date");
		
		logger.info("Entering Requested Time");
		selectfromdropdown(dataFillLeadPage.getRequest_time(), reqtime);
		logger.pass("Successfully entered Requested Time");
		
		String app_monthYear = appyear;
		String app_day = appdate;

		logger.info("Entering Appointment Date");
		clickEnter(dataFillLeadPage.getAppointment_date());
		while (true) {
			String text = dataFillLeadPage.getMonth_year_select().getText();
			// System.out.println(text);
			if (text.equals(app_monthYear)) {
				break;
			}
			clickEnter(dataFillLeadPage.getNext_month_year());
		}

		String ele2 = "//a[text()=" + app_day + "]";
		driver.findElement(By.xpath(ele2)).click();
		logger.pass("Successfully entered Appointment Date");
		
		logger.info("Entering Appointment Time");
		selectfromdropdown(dataFillLeadPage.getAppointment_time(), apptime);
		logger.pass("Successfully entered Appointment Time");
		
		String current = System.getProperty("user.dir");
		
		logger.info("UpLoading Document");
		if (docloc.isEmpty()) {

			System.out.println("No doc to load");

		} else {
			clickEnter(dataFillLeadPage.getAdd_document());

			selectfromdropdown(dataFillLeadPage.getSelect_document_type(), doctype);

			enterValue(dataFillLeadPage.getSelect_file(), current + docloc);
		}
		logger.pass("UpLoading Document passed");
		
		logger.info("UpLoading Image");
		if (imgloc.isEmpty()) {

			System.out.println("No Image to load");
		} else {

			clickEnter(dataFillLeadPage.getAdd_to_lead());

			enterValue(dataFillLeadPage.getAdd_image_select(), current + imgloc);
		}
		logger.pass("UpLoading Image passed");
		
		logger.info("Saving created Lead");
		clickEnter(dataFillLeadPage.getSave_new_lead());

		dismissCreateLoadPage dismissCreateLoadPage = new dismissCreateLoadPage();

		javaclick(dismissCreateLoadPage.getDublicate_create_lead());

		logger.pass("Succesfully Saved New Lead");
		menuNavigate();

		selectLead();

		addLead();

	}

	@AfterClass
	public void tearDown() {
		closeBrowser();
		quitBrowser();
	}

	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {

			logger.fail("Test Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(BaseFileLynnox.getScreenshot(driver)).build());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.pass("Test Passed",
					MediaEntityBuilder.createScreenCaptureFromPath(BaseFileLynnox.getScreenshot(driver)).build());
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.skip("Test Skipped",
					MediaEntityBuilder.createScreenCaptureFromPath(BaseFileLynnox.getScreenshot(driver)).build());
		}

		extent.flush();

	}
}
