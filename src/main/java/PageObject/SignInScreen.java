package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class SignInScreen {

	WebDriver driver;

	public SignInScreen(WebDriver driver) {
		this.driver = driver;
	}

	private By LoginIn = By.xpath("(//a[normalize-space()='Log In'])[1]");
	private By username = By.xpath("//input[@id='username']");
	private By password = By.xpath("//input[@id='password']");
	private By signInButton = By.xpath("//input[@id='loginButton']");
	private By creatNoteButton = By
			.xpath("//p[@class='yjPhSs1xEqaN9kqKu_33 z4Cw2GGrrl5JxqgBLMAW E_lbv7gA85FrFeRroPBY mJiFk9uD6bkda_vNvFfR']");

	public void UserLogin(WebDriver driver, Wait<WebDriver> wait) throws InterruptedException {

		driver.get(assignmentAssess.EnvConfig.url);
		driver.findElement(LoginIn).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(username));
		driver.findElement(username).sendKeys(assignmentAssess.EnvConfig.email);
		driver.findElement(signInButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(password));
		driver.findElement(password).sendKeys(assignmentAssess.EnvConfig.passowrd);
		driver.findElement(signInButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(creatNoteButton));

	}

}
