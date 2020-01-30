package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.pom.AdministrationCoursesCategoriesPOM;

public class Administration_CoursesCategories extends LoginTests {
	
	private AdministrationCoursesCategoriesPOM adminCourseCategoryPOM;
	@Test
	public void administrationCourseCategory() throws InterruptedException {
		adminCourseCategoryPOM= new AdministrationCoursesCategoriesPOM(driver);
		adminCourseCategoryPOM.clickAdministrationBtn();
		adminCourseCategoryPOM.clickCourseCategoriesLink();
		adminCourseCategoryPOM.clickAddCategoryIcon();
		adminCourseCategoryPOM.sendCategoryCode("BL");
		adminCourseCategoryPOM.sendCategoryName("Blended Learning");
		adminCourseCategoryPOM.clickRadioButtonForYes();
		adminCourseCategoryPOM.validateRadioButtonForYes();
		Thread.sleep(2000);
		adminCourseCategoryPOM.clickOnAddCategory();
	}
}
