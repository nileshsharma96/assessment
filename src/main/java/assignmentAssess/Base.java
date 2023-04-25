package assignmentAssess;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Base {

//	public static WebDriver driver;
	public ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public static Wait<WebDriver> wait;

	public void setDriver(WebDriver driver) {
		this.driver.set(driver);
	}

	public WebDriver getDriver() {
		return this.driver.get();
	}

	@BeforeMethod
	@Parameters("browser")
	public void initialization(String browser) throws InterruptedException {

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver");
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--disable-notifications");
			setDriver(new ChromeDriver(options));

		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver");
			setDriver(new FirefoxDriver());
		}
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		wait = new FluentWait<>(getDriver()).withTimeout(Duration.ofSeconds(3600)).pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);
	}

//	@AfterMethod
//	public void tearDown() {
//		getDriver().quit();
//	}

	public static String getScreenshot(String testCaseName, WebDriver driver) throws IOException {

		TakesScreenshot ts = ((TakesScreenshot) driver);
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
//		return destinationFile;
		byte[] imageBytes = IOUtils.toByteArray(new FileInputStream(destinationFile));
		return Base64.getEncoder().encodeToString(imageBytes);
	}

}
