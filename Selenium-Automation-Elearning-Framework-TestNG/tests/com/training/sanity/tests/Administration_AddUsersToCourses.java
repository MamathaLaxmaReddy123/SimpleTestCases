package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.pom.AdministrationAddUsersToCoursesPOM;

public class Administration_AddUsersToCourses extends LoginTests{
	
	private AdministrationAddUsersToCoursesPOM adminAddUsersToCoursePOM;

	@Test
	public void administrationAddUsersToCourses() throws InterruptedException  {
		adminAddUsersToCoursePOM= new AdministrationAddUsersToCoursesPOM(driver);
		adminAddUsersToCoursePOM.clickAdministrationBtn();
		adminAddUsersToCoursePOM.clickAddUsersToCourseLink();
		adminAddUsersToCoursePOM.selectUserFromUserList();
		adminAddUsersToCoursePOM.selectCourseFromCourseList();
		Thread.sleep(2000);
		adminAddUsersToCoursePOM.addToCoursesButton();
	}
}
