package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LogInPageObject {

	public LogInPageObject(WebDriver driver) {
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(factory, this);
	}

	@FindBy(xpath = "//input[@data-cucumber = 'input-login-email']")
	public WebElement txtEmail;

	@FindBy(xpath = "//span[text()='Continue']")
	public WebElement btnContinue;

	@FindBy(xpath = "//input[@data-cucumber = 'input-login-password']")
	public WebElement txtPassword;

	@FindBy(xpath = "//span[text()='Sign in']")
	public WebElement btnSignIn;

	@FindBy(xpath = "//div[@style='display: none;']")
	public WebElement txtNonPassword;

}
