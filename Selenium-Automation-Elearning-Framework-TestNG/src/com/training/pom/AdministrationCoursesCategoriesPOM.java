package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdministrationCoursesCategoriesPOM {

	private WebDriver driver;

	public AdministrationCoursesCategoriesPOM(WebDriver driver) { 
		this.driver = driver;
		PageFactory.initElements(driver, this); }

	@FindBy(xpath="//*[@href='http://elearningm1.upskills.in/main/admin/']")
	private WebElement adminstrationLink;
	
	@FindBy(linkText="Courses categories") 
	private WebElement courseCategories;

	@FindBy(xpath="//div[@class='actions']//a//img") 
	private WebElement addCategoryIcon;

	@FindBy(id="course_category_code") 
	private WebElement categoryCodeEntry;

	@FindBy(id="course_category_name") 
	private WebElement categoryNameEntry; 
	
	@FindBy(xpath="//label[contains(text(),'Yes')]") 
	private WebElement radioButtonForYes; 
	
	@FindBy(xpath="//label[contains(text(),'No')]") 
	private WebElement radioButtonForNo;
	
	@FindBy(id="course_category_submit") 
	private WebElement addCategoryBtn;

	public void clickAdministrationBtn() {
		this.adminstrationLink.click(); 
	}
	public void clickCourseCategoriesLink() {
		this.courseCategories.click(); 
	}
	public void clickAddCategoryIcon() {
		this.addCategoryIcon.click(); 
	}
	public void sendCategoryCode(String categoryCode) {
		this.categoryCodeEntry.clear();
		this.categoryCodeEntry.sendKeys(categoryCode);
	}

	public void sendCategoryName(String categoryName) {
		this.categoryNameEntry.clear();
		this.categoryNameEntry.sendKeys(categoryName);
	}
	
	public void clickRadioButtonForYes() {
		this.radioButtonForNo.click();
		this.radioButtonForYes.click();
	}
	
	public void validateRadioButtonForYes() {
		this.radioButtonForYes.isSelected();
		System.out.println("The RadioButton for Yes is clicked");
		this.radioButtonForYes.isDisplayed();
		System.out.println("The RadioButton for Yes is visible");
		this.radioButtonForYes.isEnabled();
		System.out.println("The RadioButton for Yes is enabled");
	}
	
	public void clickOnAddCategory() {
		this.addCategoryBtn.click();
	}
}
