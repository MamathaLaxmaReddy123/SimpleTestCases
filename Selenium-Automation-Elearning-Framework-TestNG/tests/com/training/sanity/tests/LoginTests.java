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
import com.training.pom.Administration_CourseListPOM;
import com.training.pom.AdministrationCoursesCategoriesPOM;
import com.training.pom.AdministrationCreateCoursePOM;
import com.training.pom.AdministrationDeleteCoursesCategoriesPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTests {

	public WebDriver driver;
	public String baseUrl;
	public static Properties properties;
	public ScreenShot screenShot;
	public LoginPOM loginPOM;
	public Administration_CourseListPOM adminCourseListPOM;
	public AdministrationCreateCoursePOM adminCreateCoursePOM;
	public AdministrationAddUsersToCoursesPOM adminAddUsersToCoursePOM;
	public AdministrationCoursesCategoriesPOM adminCreateCourseCategoryPOM;
	public AdministrationDeleteCoursesCategoriesPOM adminDelCourseCategoryPOM;

	@BeforeTest
	public void setUpBeforeTest() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		baseUrl = properties.getProperty("baseURL");
		driver.get(baseUrl); //open the browser 
		loginPOM = new LoginPOM(driver); 
		adminCourseListPOM = new Administration_CourseListPOM(driver); 
		adminCreateCoursePOM= new AdministrationCreateCoursePOM(driver);
		adminAddUsersToCoursePOM= new AdministrationAddUsersToCoursesPOM(driver);
		adminDelCourseCategoryPOM= new AdministrationDeleteCoursesCategoriesPOM(driver);
		screenShot = new ScreenShot(driver);	
	}

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First");
	}

//	@Test(priority=2, dependsOnMethods="validLoginTest",enabled=false)
//	public void administration_CourseList() {
//		adminCourseListPOM.clickAdministrationBtn();
//		adminCourseListPOM.clickCourseListLink();
//		adminCourseListPOM.clickOnDelImg();
//		adminCourseListPOM.alertAccept();
//		adminCourseListPOM.verifyMessage();
//	}
//
//	@Test(priority=3, enabled=false)
//	public void administration_CreateCourse() throws InterruptedException {
//		adminCreateCoursePOM.clickAdministrationBtn();
//		adminCreateCoursePOM.clickCreateCourseLink();
//		adminCreateCoursePOM.sendTitle("Update Title 1");
//		adminCreateCoursePOM.sendCode("1234567");
//		adminCreateCoursePOM.teachersTextSearch();//InvalidElementStateException
//		//adminCreateCoursePOM.teachersTextSearch();InvalidElementStateException: invalid element state
//		adminCreateCoursePOM.categoryDD();
//		adminCreateCoursePOM.languageDD();
//		Thread.sleep(2000);
//		adminCreateCoursePOM.clickOnCreateCourse();
//	}
//	@Test(priority=4,enabled=false)
//	public void administration_AddUsersToCourses() throws InterruptedException  {
//		//System.out.println("Administration Tab is clicked Before");
//		adminAddUsersToCoursePOM.clickAdministrationBtn();
//		//System.out.println("Administration Tab is clicked");
//		adminAddUsersToCoursePOM.clickAddUsersToCourseLink();
//		adminAddUsersToCoursePOM.selectUserFromUserList();
//		adminAddUsersToCoursePOM.selectCourseFromCourseList();
//		Thread.sleep(2000);
//		adminAddUsersToCoursePOM.addToCoursesButton();
//		adminAddUsersToCoursePOM.validateMessage();
//	}
//	@Test(priority=5,enabled=false)
//	public void administrationCourseCategory() throws InterruptedException {
//		adminCreateCourseCategoryPOM= new AdministrationCoursesCategoriesPOM(driver);
//		adminCreateCourseCategoryPOM.clickAdministrationBtn();
//		adminCreateCourseCategoryPOM.clickCourseCategoriesLink();
//		adminCreateCourseCategoryPOM.clickAddCategoryIcon();
//		adminCreateCourseCategoryPOM.sendCategoryCode("BL");
//		adminCreateCourseCategoryPOM.sendCategoryName("Blended Learning");
//		adminCreateCourseCategoryPOM.clickRadioButtonForYes();
//		adminCreateCourseCategoryPOM.validateRadioButtonForYes();
//		Thread.sleep(2000);
//		adminCreateCourseCategoryPOM.clickOnAddCategory();
//	}
//
//	@Test(priority=6,enabled=false)
//	public void administration_DelCourseCategories() {
//		adminDelCourseCategoryPOM.clickAdministrationBtn();
//		adminDelCourseCategoryPOM.clickCourseCategoriesLink();
//		adminDelCourseCategoryPOM.clickOnDelThisCategoryIcon();
//		adminDelCourseCategoryPOM.verifyMessageValidation();
//	}

}
