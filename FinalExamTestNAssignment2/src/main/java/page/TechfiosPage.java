package page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class TechfiosPage extends BasePage {

	WebDriver driver; // global

	// Every Page must have a constructor to invite the driver
	public TechfiosPage(WebDriver driver) {
		this.driver = driver;
	}

	// Test 1: Validate a user is able to add a category
	// and once the category is added it should display.

	// Element Library
	@FindBy(how = How.NAME, using = "data")
	WebElement CategoryInputBox;
	@FindBy(how = How.XPATH, using = "//input[@value = 'Add']")
	WebElement AddButton;
	@FindBy(how = How.XPATH, using = "//body[contains(text(), 'Sorry that TODO item already exists. ')]")
	WebElement DuplicateWarningMessage;
	@FindBy(how = How.NAME, using = "due_month")
	WebElement MonthDropDown;
	@FindBy(how = How.LINK_TEXT, using = "Back")
	WebElement BackButton;

	@FindBys(@FindBy(how = How.XPATH, using = "//select[@name = 'due_month']/descendant::option"))
	List<WebElement> MonthList;

	// Methods to interact with the elements
	public void ClickOnAddaCategoryButton(String category) {
		CategoryInputBox.click();
		CategoryInputBox.sendKeys(category);
		AddButton.click();

	}

	// Method to check if warning message is displayed
	public boolean isWarningMessageDisplayed() {
		return DuplicateWarningMessage.isDisplayed();
	}

	// Method to go back after warning message has been displayed
	public void clickOnBackButton() throws InterruptedException {
		BackButton.click();
		Thread.sleep(4000);
	}

	// Test 3
	public void selectMonthDropDown() {
		MonthDropDown.click();
	}

	public boolean isMonthDropDownHasMonthsDisplayed() {

		Select selectMonthDropDown = new Select(MonthDropDown);
		List<WebElement> allMonthOptions = selectMonthDropDown.getOptions();

		String months = "None;Jan;Feb;Mar;Apr;May;Jun;Jul;Aug;Sep;Oct;Nov;Dec";
		String[] arrMonths = months.split(";");

		int count = 0;
		for (String str : arrMonths) {

			boolean found = false;
			for (WebElement ele : allMonthOptions) {
				if (str.equals(ele.getText())) {
					found = true;
					count++;
					System.out.println(str + "   Month exists!");
					break;
				}
			}
			if (!found) {
				System.out.println(str + "    Month does not exist!");
			}
		}
		System.out.println("Count : " + count);
		if(count < 13) {
		return false;
		}
		else {
			return true;
		}

	}

}
