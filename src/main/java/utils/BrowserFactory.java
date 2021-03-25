package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.service.DriverService;

public class BrowserFactory {
    BrowserFactory() {
        //Necessary to run
    }

    private static WebDriver driver;
    private static DriverService driverService;

    public static WebDriver getDriver() {

        return driver;
    }
}
