package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdministrationCreateCoursePOM {

	private WebDriver driver;

	public AdministrationCreateCoursePOM(WebDriver driver) { 
		this.driver = driver;
		PageFactory.initElements(driver, this); }

	@FindBy(xpath="//a[contains(text(),'Administration')]") 
	private WebElement adminstrationLink; 

	@FindBy(linkText="Create a course") 
	private WebElement courseList;

	@FindBy(id="update_course_title") 
	private WebElement titleEntry;

	@FindBy(id="visual_code") 
	private WebElement codeEntry;

	@FindBy(xpath="//select[@id='course_teachers']") 
	private WebElement teachersSearch; 

	@FindBy(id="update_course_category_code") 
	private WebElement categoryDD;

	@FindBy(id="update_course_course_language") 
	private WebElement languageDD;
	
	@FindBy(id="update_course_submit") 
	private WebElement createCourseButton;

	public void clickAdministrationBtn() {
		this.adminstrationLink.click(); 
	}

	public void clickCreateCourseLink() {
		this.courseList.click(); 
	}
	public void sendTitle(String titleEntry) {
		this.titleEntry.clear();
		this.titleEntry.sendKeys(titleEntry);
	}

	public void sendCode(String codeEntry) {
		this.codeEntry.clear();
		this.codeEntry.sendKeys(codeEntry);
	}

	public void teachersTextSearch() {
		//this.teachersSearch.sendKeys("Test");
		Actions action = new Actions(driver);
		action.moveToElement(teachersSearch);
		action.click(teachersSearch).sendKeys(Keys.F5); // this is the key stroke.
		action.click(teachersSearch).sendKeys("manzoor");
		action.sendKeys(Keys.ARROW_DOWN);

		//		webdriver.select_tabs(search.btnSearch);
		//		Thread.sleep(3000);
		//		WebElement searchbox = driver.findElement(By.id("search-text"));
		//		Actions builder = new Actions(driver);
		//		Actions seriesOfActions = builder.moveToElement(searchbox).click().sendKeys(searchbox, "FAA");
		//		seriesOfActions.perform();
		//
		//		WebDriverWait wait = new WebDriverWait(driver, 30);
		//		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"search-text\"]")));
		//		element.sendKeys("FAA");
		//		element.sendKeys(Keys.ENTER);
		//
		//		webdriver.enter_key(search.txtSearch, Keys.ENTER);
		//		webdriver.enter_Text(search.txtSearch, "FAA");
		//		webdriver.enter_key(search.txtSearch, Keys.ENTER);
	}
	
	public void categoryDD() {
		//this.categoryDD.clear();
		Select category = new Select(categoryDD);
		category.selectByVisibleText("Automation09 (NL102909)");
	}
	
	public void languageDD() {
		//this.languageDD.clear();
		Select language = new Select(languageDD);
		language.selectByValue("german");
	}
	
	public void clickOnCreateCourse() {
		this.createCourseButton.click();
	}
}
