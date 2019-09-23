package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.TechfiosPage;
import util.BrowserFactory;

//Test 1: Validate a user is able to add a category 
//and once the category is added it should display.

public class TestFinalExam {

	WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {
		// Start browser and saves the driver in the test class
		driver = BrowserFactory.startBrowser();
	}

	@Test
	public void validUsersShouldBeAbleToAddaCategory() throws InterruptedException {

		// Go to site
		driver.get("http://techfios.com/test/101/");

		// Call Login Method from LoginPage
		// Call Login Page, reference name = new LoginPage()
		TechfiosPage techfiospage = PageFactory.initElements(driver, TechfiosPage.class);

		// techfiospage.ClickOnAddaCategoryButton("Java Session at TechFios");
		techfiospage.ClickOnAddaCategoryButton("bbbbbb Session at TechFios");

		Thread.sleep(5000);

		// Test 2: Validate a user is not able to add a duplicated category.
		// If it does then the following message will display:
		// "The category you want to add already exists: <duplicated category name>."

		Assert.assertTrue(techfiospage.isWarningMessageDisplayed(), "Warning Message is not Displayed");

		Thread.sleep(5000);

//	Test 3: Validate the month drop down has all the months (jan, feb, mar ...) 
//	in the Due Date dropdown section.

		// click on back button
		techfiospage.clickOnBackButton();

		// click month dropdown
		techfiospage.selectMonthDropDown();

		// checking the list
		techfiospage.isMonthDropDownHasMonthsDisplayed();

		// Validate the month list
		Assert.assertTrue(techfiospage.isMonthDropDownHasMonthsDisplayed(),
				"Months in the drop down box do not match!");

	}
}
