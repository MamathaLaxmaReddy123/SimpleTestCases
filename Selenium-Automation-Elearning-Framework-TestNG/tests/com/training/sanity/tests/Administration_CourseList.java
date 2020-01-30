package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.pom.AdministrationCourseListPOM;
import com.training.pom.LoginPOM;

public class Administration_CourseList extends LoginTests{
	
	private AdministrationCourseListPOM adminCourseListPOM;

	@Test
	public void administrationCourseList() { 
		loginPOM = new LoginPOM(driver); 
		adminCourseListPOM = new AdministrationCourseListPOM(driver); 
		System.out.println("Entered into administrationCourseList()");
		adminCourseListPOM.homePageLink();
		System.out.println("HomePage is clicked");
		adminCourseListPOM.clickAdministrationBtn();
		adminCourseListPOM.clickCourseListLink();
		adminCourseListPOM.clickOnDelImg();
		adminCourseListPOM.alertAccept();
		String ExpectedMessage="Deleted";
		adminCourseListPOM.verifyMessage();
	}

}
