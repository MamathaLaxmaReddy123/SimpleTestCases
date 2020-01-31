package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Administration_CourseListPOM {

	public WebDriver driver;
	public Administration_CourseListPOM(WebDriver driver) { 
		this.driver = driver;
		PageFactory.initElements(driver, this); }

	@FindBy(xpath="//a[contains(text(),'Administration')]") 
	private WebElement adminstrationLink; 
	@FindBy(xpath="//a[contains(text(),'My courses')]") 
	private WebElement homePageLink;
	
	
	@FindBy(linkText="Course list") 
	private WebElement courseList;

	@FindBy(xpath="//tr[11]//td[8]//a[6]//img[1]") 
	private WebElement deleteImg;

	@FindBy(xpath="//div[contains(text(),'Deleted')]")
	private WebElement actualMessage;
	
	public void clickAdministrationBtn() {
		this.adminstrationLink.click(); 
	}
	public void homePageLink() {
		this.homePageLink.click(); 
	}

	public void clickCourseListLink() {
		this.courseList.click(); 
	}
	public void clickOnDelImg() {
		this.deleteImg.click(); 
	}

	public void alertAccept() {
		driver.switchTo().alert().accept();
		//Assert.assertEquals(actualMessage, ExpectedMessage);
	}
	public void verifyMessage() {
		String ExpectedMessage="Deleted";
		String ActualMessage= driver.findElement(By.xpath("//div[contains(text(),'Deleted')]")).getText();
		Assert.assertEquals(ActualMessage, ExpectedMessage);
	}

}
