package assignmentAssess;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ErrorCatcherMethod {

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver");
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		ChromeOptions opt = new ChromeOptions();
		opt.setExperimentalOption("debuggerAddress", "Localhost:6655");
		opt.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(opt);

//		-----------------------------Write below this------------------------------------\

//		WebElement frame = driver.findElement(By.xpath("//iframe[@id='qa-COMMON_EDITOR_IFRAME']"));
//		driver.switchTo().frame(frame);

//		Thread.sleep(5000);

//		driver.findElement(By.xpath("//div[@class='TstAqE_Ikyk8di5eyO0U HUWoDG8e8KhEOGqVocpC']")).click();

		Thread.sleep(2000);

		WebElement photo = driver.findElement(By.xpath("//div[@id='tippy-23']"));

		photo.sendKeys("./src/main/resources/Tanjiro(DemonSlayer).jpeg");

//		photo.click();

	}

}

//For Windows
//~~  cd /usr/bin
//~~  google-chrome --remote-debugging-port=6655 --user-data-dir=/home/nileshsharma/Downloads/chromedata