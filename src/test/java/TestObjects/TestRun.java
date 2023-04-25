package TestObjects;

import org.testng.annotations.Test;

import PageObject.CreateTask;
import PageObject.SignInScreen;
import assignmentAssess.Base;

public class TestRun extends Base {

	@Test()
	public void UserSignIn() throws InterruptedException {
		SignInScreen sign = new SignInScreen(getDriver());
		sign.UserLogin(getDriver(), wait);
		CreateTask task = new CreateTask(getDriver());
		task.createTask(getDriver(), wait);
	}
}
