package actions.highLevelActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import actions.controlActions.ButtonActions;
import actions.controlActions.TextFieldActions;
import actions.lowLevelActions.WaitActions;
import objects.LogInPageObject;

public class LogInAction {

	private WebDriver driver;

	public LogInAction(WebDriver driver) {
		this.driver = driver;
	}

	public void doLogIn(String email, String password) throws InterruptedException {
		LogInPageObject logInPage = new LogInPageObject(driver);
		TextFieldActions.setValue(logInPage.txtEmail, email);
		ButtonActions.click(logInPage.btnContinue);
		WaitActions.waitUntilVisibilityOfElementLocated(driver, By.xpath("//div[@style='display: block;']"), 10);
		TextFieldActions.setValue(logInPage.txtPassword, password);
		ButtonActions.click(logInPage.btnSignIn);

	}

}
