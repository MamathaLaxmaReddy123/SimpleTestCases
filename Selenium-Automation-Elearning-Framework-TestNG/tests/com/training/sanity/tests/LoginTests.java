package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdministrationAddUsersToCoursesPOM;
import com.training.pom.AdministrationCourseListPOM;
import com.training.pom.AdministrationCreateCoursePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTests {

	public WebDriver driver;
	public String baseUrl;
	public LoginPOM loginPOM;
	public static Properties properties;
	public ScreenShot screenShot;
	public AdministrationCourseListPOM adminCourseListPOM;
	//	public AdministrationCreateCoursePOM adminCreateCoursePOM;
	//	public AdministrationAddUsersToCoursesPOM adminAddUsersToCoursePOM;

	@BeforeTest
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		baseUrl = properties.getProperty("baseURL");
		driver.get(baseUrl);// open the browser 
		loginPOM = new LoginPOM(driver); 
		//adminCourseListPOM = new AdministrationCourseListPOM(driver); 
		//		adminCreateCoursePOM= new AdministrationCreateCoursePOM(driver);
		//		adminAddUsersToCoursePOM= new AdministrationAddUsersToCoursesPOM(driver);
		screenShot = new ScreenShot(driver);	
	}

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}
	@Test
	public void validLoginTest() {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		//screenShot.captureScreenShot("First");
	}

	//	@Test(priority=2, dependsOnMethods="validLoginTest",enabled=true)
	//	public void administrationCourseList() {
	//		adminCourseListPOM.clickAdministrationBtn();
	//		adminCourseListPOM.clickCourseListLink();
	//		adminCourseListPOM.clickOnDelImg();
	//		adminCourseListPOM.alertAccept();
	//		String ExpectedMessage="Deleted";
	//		String ActualMessage= driver.findElement(By.xpath("//div[contains(text(),'Deleted')]")).getText();
	//		Assert.assertEquals(ActualMessage, ExpectedMessage);
	//	}

	//	@Test(priority=3, enabled=true)
	//	public void administrationCreateCourse() throws InterruptedException {
	//		adminCreateCoursePOM.clickAdministrationBtn();
	//		adminCreateCoursePOM.clickCreateCourseLink();
	//		adminCreateCoursePOM.sendTitle("Update Title 1");
	//		adminCreateCoursePOM.sendCode("1234567");
	//		adminCreateCoursePOM.teachersTextSearch();//InvalidElementStateException
	//		//adminCreateCoursePOM.teachersTextSearch();//InvalidElementStateException: invalid element state
	//		adminCreateCoursePOM.categoryDD();
	//		adminCreateCoursePOM.languageDD();
	//		Thread.sleep(2000);
	//		adminCreateCoursePOM.clickOnCreateCourse();
	//	}
	//	@Test(priority=4)
	//	public void administrationAddUsersToCourses() throws InterruptedException  {
	//		System.out.println("Administration Tab is clicked Before");
	//		adminAddUsersToCoursePOM.clickAdministrationBtn();
	//		System.out.println("Administration Tab is clicked");
	//		adminAddUsersToCoursePOM.clickAddUsersToCourseLink();
	//		adminAddUsersToCoursePOM.selectUserFromUserList();
	//		adminAddUsersToCoursePOM.selectCourseFromCourseList();
	//		Thread.sleep(2000);
	//		adminAddUsersToCoursePOM.addToCoursesButton();
	//	}
	
}
