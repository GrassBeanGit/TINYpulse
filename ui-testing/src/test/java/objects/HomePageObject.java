package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePageObject {

	public HomePageObject(WebDriver driver) {
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(factory, this);
	}

	@FindBy(xpath = "//a[@aria-label='Users and Settings']")
	public WebElement btnUsersAndSettings;

	@FindBy(xpath = "//a[@href='/invite']")
	public WebElement btnAddPeople;

}
