package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.pom.AdministrationCreateCoursePOM;

public class Administration_CreateCourse extends LoginTests {

	private AdministrationCreateCoursePOM adminCreateCoursePOM;
	@Test
	public void administrationCreateCourse() throws InterruptedException {
		adminCreateCoursePOM= new AdministrationCreateCoursePOM(driver);
		adminCreateCoursePOM.clickAdministrationBtn();
		adminCreateCoursePOM.clickCreateCourseLink();
		adminCreateCoursePOM.sendTitle("testing");
		adminCreateCoursePOM.sendCode("tes");
		adminCreateCoursePOM.teachersTextSearch();//InvalidElementStateException
		adminCreateCoursePOM.categoryDD();
		adminCreateCoursePOM.languageDD();
		Thread.sleep(2000);
		adminCreateCoursePOM.clickOnCreateCourse();
	}
}
