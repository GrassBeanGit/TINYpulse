package testModule.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import actions.controlActions.BrowserActions;
import constants.LinksConstants;

public class BaseTest {

	public WebDriver driver;
	public int totalCase;
	public String filePath;

	@Parameters("usageBrowserName")

	@BeforeMethod
	public void executePreCondition(String usageBrowserName) throws Exception {
		driver = BrowserActions.openWebsite(usageBrowserName, LinksConstants.LOGIN_LINK);
	}

	@AfterMethod
	public void executePosCondition() {
		BrowserActions.closeAllOfBrowsers(driver);
	}
	

}
