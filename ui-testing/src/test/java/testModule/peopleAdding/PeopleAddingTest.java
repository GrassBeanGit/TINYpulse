package testModule.peopleAdding;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.Test;

import actions.common.JavaActions;
import actions.highLevelActions.LogInAction;
import actions.highLevelActions.PeopleAddingAction;
import actions.utils.ExcelUtils;
import constants.LogInDataSetFileConstants;
import testModule.base.BaseTest;

public class PeopleAddingTest extends BaseTest {

	@Test (priority = 1)
	public void verifyAddingPeopleSuccessfully() throws Exception {
		JavaActions.printNameOfCurrentMethod();
		executeLogIn();
		addPeople();
		verifyPeopleAddingProcessing();
	}

	private void verifyPeopleAddingProcessing() throws InterruptedException {
		PeopleAddingAction peopleAddingAction = new PeopleAddingAction(driver);
		peopleAddingAction.verifyPeopleAddingSuccessfully("https://tps-staging.tinyserver.info/invite/finish");
	}

	private void addPeople() throws Exception {
		PeopleAddingAction peopleAddingAction = new PeopleAddingAction(driver);
		peopleAddingAction.navigateToUsersAndSettingsPage();
		peopleAddingAction.addPeople();
	}

	private void executeLogIn() throws Exception, InterruptedException {
		String logInFilePath = LogInDataSetFileConstants.LOG_IN_DATA_SET_FILE_PATH;
		XSSFSheet logInDataSetSheet = ExcelUtils.getDataSheet(logInFilePath, LogInDataSetFileConstants.VALID_SHEET);
		
		String email = ExcelUtils.getCellData(logInDataSetSheet, 1, LogInDataSetFileConstants.EMAIL_COLUMN_INDEX);
		String password = ExcelUtils.getCellData(logInDataSetSheet, 1, LogInDataSetFileConstants.PASSWORD_COLUMN_INDEX);
		
		LogInAction logInAction = new LogInAction(driver);
		logInAction.doLogIn(email, password);
	}
}
