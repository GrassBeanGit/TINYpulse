package actions.common;

import java.util.Random;

import org.testng.asserts.SoftAssert;

public class JavaActions {

	public static void printNameOfCurrentMethod() {
		String currentMethod = new Throwable().getStackTrace()[1].getMethodName();
		System.out.println(
				"\n\n\n########################################################################################################");
		System.out.println("\033[43m " + currentMethod + "\033[0m");
		System.out.println(
				"########################################################################################################");
	}
	
	public static void compareTwoStringValues(String actualValue, String expectedValue) {
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualValue, expectedValue);
		softAssert.assertAll();
	}
	
	public static int generateRandomNumber(int maxValue) {
		Random random = new Random();
		return random.nextInt(maxValue);
	}
}
