package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class AddPeoplePageObject {

	private WebDriver driver = null;

	public AddPeoplePageObject(WebDriver driver) {
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(factory, this);
		this.driver = driver;
	}

	public WebElement getFirstNameElement(int rowNumber) throws Exception {
		WebElement element = null;
		element = driver.findElement(By.xpath("//tbody/tr[" + rowNumber + "]//input[@field='firstName']"));
		return element;
	}

	public WebElement getLastNameElement(int rowNumber) throws Exception {
		WebElement element = null;
		element = driver.findElement(By.xpath("//tbody/tr[" + rowNumber + "]//input[@field='lastName']"));
		return element;
	}

	public WebElement getEmailElement(int rowNumber) throws Exception {
		WebElement element = null;
		element = driver.findElement(By.xpath("//tbody/tr[" + rowNumber + "]//input[@field='email']"));
		return element;
	}

	public WebElement getStartDatePickerElelent(int rowNumber) throws Exception {
		WebElement element = null;
		element = driver.findElement(By.xpath("//tbody/tr[" + rowNumber + "]//input[@field='startDate']"));
		return element;
	}

	public WebElement getDateElelent(String selectedDate) throws Exception {
		WebElement element = null;
		element = driver.findElement(By.xpath("//div[@data-value='" + selectedDate + "']"));
		return element;
	}

	public WebElement getManagerDropdownElelent(int rowNumber) throws Exception {
		WebElement element = null;
		element = driver.findElement(By.xpath("//tbody/tr[" + rowNumber + "]/td[5]//span"));
		return element;
	}

	public WebElement getManagerItemElelent(String managerName) throws Exception {
		WebElement element = null;
		element = driver.findElement(By.xpath("//h4[text()='" + managerName + "']"));
		return element;
	}

	public WebElement getAddPeopleButtonElement() {
		WebElement element = null;
		element = driver.findElement(By.xpath("//span[text()='Add People']"));
		return element;
	}

	public WebElement getAddedToTinyPulseElement() {
		WebElement element = null;
		element = driver.findElement(By.xpath("//div[contains(text(),'employees have been added to TINYpulse')]"));
		return element;
	}

}
