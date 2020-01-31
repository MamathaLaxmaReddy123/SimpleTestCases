package com.training.sanity.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.training.pom.AdministrationCreateCoursePOM;
import com.training.pom.LoginPOM;

public class Administration_CreateCourse extends LoginTests {
	
	
	public WebDriver driver;
	public LoginPOM loginPOM;
	public AdministrationCreateCoursePOM adminCreateCoursePOM;
	
	@Test
	public void administrationCreateCourse() {
		
		adminCreateCoursePOM= new AdministrationCreateCoursePOM(driver);
		System.out.println("administrationCreateCourse is entered");
		adminCreateCoursePOM.clickAdministrationBtn();
		adminCreateCoursePOM.clickCreateCourseLink();
		adminCreateCoursePOM.sendTitle("testing");
		adminCreateCoursePOM.sendCode("tes");
		adminCreateCoursePOM.teachersTextSearch();//InvalidElementStateException
		adminCreateCoursePOM.categoryDD();
		adminCreateCoursePOM.languageDD();
		adminCreateCoursePOM.clickOnCreateCourse();
	}
}
