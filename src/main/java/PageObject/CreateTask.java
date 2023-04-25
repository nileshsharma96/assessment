package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class CreateTask {

	WebDriver driver;

	public CreateTask(WebDriver driver) {
		this.driver = driver;
	}

	private By createTaskNote = By.xpath(
			"(//p[@class='yjPhSs1xEqaN9kqKu_33 z4Cw2GGrrl5JxqgBLMAW E_lbv7gA85FrFeRroPBY mJiFk9uD6bkda_vNvFfR'])[1]");
	private By insertButton = By.xpath("//div[@class='TstAqE_Ikyk8di5eyO0U HUWoDG8e8KhEOGqVocpC']");
	private By addTable = By.xpath("//div[@data-tooltipmark='formattertable']");
	private By addRow = By.xpath("(//div[@class='SZtnQ'])[4]");
	private By boldButton = By.xpath("//button[@id='qa-BOLD_TEXT_BTN']//*[name()='svg']");
	private By iframe = By.xpath("//iframe[@id='qa-COMMON_EDITOR_IFRAME']");

	public void createTask(WebDriver driver, Wait<WebDriver> wait) throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(createTaskNote));
		driver.findElement(createTaskNote).click();
		driver.findElement(insertButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(addTable));
		driver.findElement(addTable).click();
		Thread.sleep(2000);
		WebElement frame = driver.findElement(iframe);
		driver.switchTo().frame(frame);

		int i = 1;

		for (i = 1; i <= 3; i++) {
			WebElement element = driver.findElement(addRow);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		}

		Thread.sleep(2000);

		for (i = 2; i <= 10; i++) {
			driver.findElement(By.xpath("(//div[@class='para'])[" + i + "]")).click();
//			driver.findElement(By.xpath("(//td)[" + i + "]")).click();
			driver.switchTo().parentFrame();
			driver.findElement(boldButton).click();
			driver.switchTo().frame(frame);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='para'])[" + i + "]")));
//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//td)[" + i + "]")));
			driver.findElement(By.xpath("(//div[@class='para'])[" + i + "]")).click();
//			driver.findElement(By.xpath("(//td)[" + i + "]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//div[@class='para'])[" + i + "]")).sendKeys("Dummy Data " + (i - 1) + "");
//			driver.findElement(By.xpath("(//td)[" + i + "]")).sendKeys("Dummy Data " + i + "");
			driver.findElement(By.xpath("(//div[@class='para'])[" + (i + 1) + "]")).click();
//			driver.findElement(By.xpath("(//td)[" + (i + 1) + "]")).click();
			driver.switchTo().parentFrame();
			driver.findElement(boldButton).click();
			driver.switchTo().frame(frame);
			wait.until(
					ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='para'])[" + (i + 1) + "]")));
//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//td)[" + (i + 1) + "]")));
			driver.findElement(By.xpath("(//div[@class='para'])[" + (i + 1) + "]")).sendKeys("Dummy Data " + i + "");
//			driver.findElement(By.xpath("(//td)[" + (i + 1) + "]")).sendKeys("Dummy Data " + (i + 1) + "");
			i++;
		}

		Thread.sleep(2000);

	}

}
