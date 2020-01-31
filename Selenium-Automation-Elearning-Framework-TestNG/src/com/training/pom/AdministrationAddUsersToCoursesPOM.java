package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AdministrationAddUsersToCoursesPOM {

	private WebDriver driver;

	public AdministrationAddUsersToCoursesPOM(WebDriver driver) { 
		this.driver = driver;
		PageFactory.initElements(driver, this); }

	@FindBy(xpath="//a[contains(text(),'Administration')]") 
	private WebElement adminstrationLink; 

	@FindBy(linkText="Add users to course") 
	private WebElement addUsersToCourse;
	
	@FindBy(name="UserList[]") 
	private WebElement userListDD;
	
	@FindBy(name="CourseList[]") 
	private WebElement courseListDD;
	
	@FindBy(xpath="//button[@type='submit']") 
	private WebElement addToCoursesButton;
	
	public void clickAdministrationBtn() {
		this.adminstrationLink.click(); 
	}
	public void clickAddUsersToCourseLink() {
		this.addUsersToCourse.click(); 
	}
	
	public void selectUserFromUserList() {
		//this.languageDD.clear();
		Select user = new Select(userListDD);
		user.selectByValue("349");
	}
	
	public void selectCourseFromCourseList() {
		//this.languageDD.clear();
		Select course = new Select(courseListDD);
		course.selectByValue("NL103001");
		//course.selectByVisibleText("(MANIPALCOURSE) Manipal Course");
	}
	
	public void addToCoursesButton() {
		this.addToCoursesButton.click(); 
	}
	public void validateMessage() {
		String expectedMessage="The selected users are subscribed to the selected course";
		String actualMessage=driver.findElement(By.xpath("//div[contains(text(),'The selected users are subscribed to the selected course')]")).getText();
		Assert.assertEquals(actualMessage, expectedMessage);
	}
}
