package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AdministrationDeleteCoursesCategoriesPOM {

	private WebDriver driver;

	public AdministrationDeleteCoursesCategoriesPOM(WebDriver driver) { 
		this.driver = driver;
		PageFactory.initElements(driver, this); }

	@FindBy(xpath="//*[@title='Administration']")
	private WebElement adminstrationLink;

	@FindBy(linkText="Courses categories") 
	private WebElement courseCategories;

	@FindBy(xpath="//tr[5]//td[4]//a[3]//img[1]")
	private WebElement deleteThisCategoryIcon;
	
	@FindBy(xpath="//*[contains(text(),'Deleted')]")
	private WebElement actualMessage;
	

	public void clickAdministrationBtn() {
		this.adminstrationLink.click(); 
	}
	public void clickCourseCategoriesLink() {
		this.courseCategories.click(); 
	}
	public void clickOnDelThisCategoryIcon() {
		this.deleteThisCategoryIcon.click(); 
	}
	public void verifyMessageValidation() {
		String expectedMessage="Deleted";
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	

}
