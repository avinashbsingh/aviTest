package test.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.service.DriverService;
import utils.Keys;
import utils.MasterData;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Hooks {
    private static WebDriver driver;
    private static DriverService driverService;

    public Hooks() {
        //Necessary to run
    }

    @Before("@web")
    public static void webSetUp(Scenario scenario) {
        System.out.println("Scenario Name - " + scenario.getName());
        MasterData.setContext(Keys.SCENARIO,scenario);
        WebDriverManager.chromedriver().setup();
        driverService = new ChromeDriverService.Builder().usingAnyFreePort().build();
        try {
            driverService.start();
            driver = new ChromeDriver((ChromeDriverService) driverService);
            System.out.println("::::Driver initiated ::::");
        } catch (IOException e) {
            System.out.println(":::: I/O error in ChromeDriver path ::::");
        }
        driver.get("https://www.google.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        MasterData.setContext(Keys.WEBDRIVER, driver);
    }

    @After("@web")
    public static void webSetUp() {
        //Reporter.loadXMLConfig(new File("config/report.xml"));
        if (driver != null)
            driver.quit();
        driverService.stop();
    }

    @Before("@api")
    public static void apiSetUp(Scenario scenario) {
        System.out.println("Scenario Name - " + scenario.getName());
        MasterData.setContext(Keys.SCENARIO,scenario);
    }

    @After("@api")
    public static void apiCleanUp() {

    }

}
