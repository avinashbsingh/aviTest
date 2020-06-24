package test.runner;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.service.DriverService;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Keys;
import utils.TestContext;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java", tags = { "@web" }, glue = { "web.steps" }, plugin = {
		"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html", "html:target/htmlreports",
		"json:target/cucumber-reports/cucumber-report.json" }, monochrome = true)

public class testRunner {
	private static WebDriver driver;
	private static DriverService driverService;

	@BeforeClass
	public static void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driverService = new ChromeDriverService.Builder().usingAnyFreePort().build();
		try {
			driverService.start();
			driver = new ChromeDriver((ChromeDriverService) driverService);
			System.out.println("::::Driver initiated ::::");
		} catch (IOException e) {
			System.out.println(":::: I/O error in ChromeDriver path ::::");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		TestContext.setContext(utils.Keys.WEBDRIVER, driver);
	}

	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File("config/report.xml"));
		TestContext.getContext(Keys.WEBDRIVER);
	}

}
