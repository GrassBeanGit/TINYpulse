package testModule.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;

import actions.controlActions.BrowserActions;
import constants.LinksConstants;

public class WebDriverWrapper {

	public WebDriver driver;

	@Parameters("usageBrowserName")
	
	private WebDriver initDriver(String usageBrowserName) {
		driver = BrowserActions.openWebsite(usageBrowserName, LinksConstants.LOGIN_LINK);
		return driver;
	}
}
