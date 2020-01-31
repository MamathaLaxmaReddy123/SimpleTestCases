package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.pom.AdministrationDeleteCoursesCategoriesPOM;

public class Administration_DelCoursesCategories extends LoginTests {

	private AdministrationDeleteCoursesCategoriesPOM adminDelCourseCategoryPOM;
	
	@Test
	public void administrationDelCourseCategory() throws InterruptedException {
		System.out.println("Entered into administrationCreateCourse()");
		adminDelCourseCategoryPOM= new AdministrationDeleteCoursesCategoriesPOM(driver);
		adminDelCourseCategoryPOM.clickAdministrationBtn();
		adminDelCourseCategoryPOM.clickCourseCategoriesLink();
		adminDelCourseCategoryPOM.clickOnDelThisCategoryIcon();
		adminDelCourseCategoryPOM.verifyMessageValidation();
	}
}
