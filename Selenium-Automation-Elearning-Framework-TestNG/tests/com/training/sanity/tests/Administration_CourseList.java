package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.pom.Administration_CourseListPOM;

public class Administration_CourseList extends LoginTests{
	
	private Administration_CourseListPOM adminCourseListPOM;

	@Test
	public void administrationCourseList() { 
		adminCourseListPOM = new Administration_CourseListPOM(driver); 
		System.out.println("Entered into administrationCourseList()");
		adminCourseListPOM.clickAdministrationBtn();
		adminCourseListPOM.clickCourseListLink();
		adminCourseListPOM.clickOnDelImg();
		adminCourseListPOM.alertAccept();
		adminCourseListPOM.verifyMessage();
	}

}
