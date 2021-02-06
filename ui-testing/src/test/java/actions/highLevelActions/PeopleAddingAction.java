package actions.highLevelActions;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;

import actions.common.JavaActions;
import actions.controlActions.BrowserActions;
import actions.controlActions.ButtonActions;
import actions.controlActions.TextFieldActions;
import actions.utils.ExcelUtils;
import constants.PeopleAddingDataSetFileConstants;
import objects.AddPeoplePageObject;
import objects.HomePageObject;

public class PeopleAddingAction {

	private WebDriver driver;

	public PeopleAddingAction(WebDriver driver) {
		this.driver = driver;
	}

	public void navigateToUsersAndSettingsPage() {
		HomePageObject homePage = new HomePageObject(driver);
		ButtonActions.click(homePage.btnUsersAndSettings);
		ButtonActions.click(homePage.btnAddPeople);
	}

	public void addPeople() throws Exception {
		String peopleAddingFilePath = PeopleAddingDataSetFileConstants.PEOPLE_ADDING_DATA_SET_FILE_PATH;
		XSSFSheet peopleAddingDataSetSheet = ExcelUtils.getDataSheet(peopleAddingFilePath,
				PeopleAddingDataSetFileConstants.VALID_SHEET);
		int totalRow = ExcelUtils.getTotalRow(peopleAddingDataSetSheet);

		AddPeoplePageObject addPeoplePage = new AddPeoplePageObject(driver);

		for (int i = 1; i < totalRow; i++) {
			String firstName = ExcelUtils.getCellData(peopleAddingDataSetSheet, i,
					PeopleAddingDataSetFileConstants.FIRST_NAME_INDEX);
			String lastName = ExcelUtils.getCellData(peopleAddingDataSetSheet, i,
					PeopleAddingDataSetFileConstants.LAST_NAME_INDEX);
			String email = ExcelUtils.getCellData(peopleAddingDataSetSheet, i,
					PeopleAddingDataSetFileConstants.EMAIL_INDEX);
			email = JavaActions.generateRandomNumber(5000) + email;
			TextFieldActions.setValue(addPeoplePage.getFirstNameElement(i), firstName);
			TextFieldActions.setValue(addPeoplePage.getLastNameElement(i), lastName);
			TextFieldActions.setValue(addPeoplePage.getEmailElement(i), email);
		}
		ButtonActions.click(addPeoplePage.getAddPeopleButtonElement());
	}

	public void verifyPeopleAddingSuccessfully(String expectedUrl) throws InterruptedException {
		boolean loop = true;
		int counter = 0;
		String url = "";
		while (loop == true) {
			counter = counter + 1;
			url = BrowserActions.getCurrentUrl(driver);
			if (url.contains("finish") == true) {
				loop = false;
			}
			if (counter == 1000000) {
				break;
			}
		}
		JavaActions.compareTwoStringValues(url, expectedUrl);
	}
}
