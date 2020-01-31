package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.pom.AdministrationCoursesCategoriesPOM;

public class Administration_CoursesCategories extends LoginTests {
	
	private AdministrationCoursesCategoriesPOM adminCreateCourseCategoryPOM;
	
	@Test
	public void administrationCourseCategory() throws InterruptedException {
		adminCreateCourseCategoryPOM= new AdministrationCoursesCategoriesPOM(driver);
		adminCreateCourseCategoryPOM.clickAdministrationBtn();
		adminCreateCourseCategoryPOM.clickCourseCategoriesLink();
		adminCreateCourseCategoryPOM.clickAddCategoryIcon();
		adminCreateCourseCategoryPOM.sendCategoryCode("BL");
		adminCreateCourseCategoryPOM.sendCategoryName("Blended Learning");
		adminCreateCourseCategoryPOM.clickRadioButtonForYes();
		adminCreateCourseCategoryPOM.validateRadioButtonForYes();
		Thread.sleep(2000);
		adminCreateCourseCategoryPOM.clickOnAddCategory();
	}
}
