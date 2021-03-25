package test.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;
import utils.*;

import java.util.HashMap;

@CucumberOptions(
        features = "src/test/java",
        glue = {"test.hooks", "steps.api", "steps.web"},
        plugin = {"pretty",
                "json:target/cucumber-reports/cucumber-report.json"},
        tags = "@CreateEmployee",
        monochrome = true)
//"json:target/cucumber-reports/cucumber.json"
public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @BeforeSuite(alwaysRun = true)
    @Parameters("Browser")
    static public void beforeSuite(@Optional("Chrome") String browser) {
        System.out.println("In Side Suite - Testrunner");
        MasterData.setContext(Keys.BROWSER, browser);
        MasterData.setContext(Keys.REPORT, new Report());
        System.out.println("Browser Name" + browser);
        System.out.println(PropertyReader.readConfig(ConfigurationProperties.JSON_PATH));
        HashMap<String, String> config_Map = JsonReader.readJsonFile(System.getProperty("user.dir") + PropertyReader.readConfig(ConfigurationProperties.JSON_PATH), "DEV", "INDIA");
        //config_Map.entrySet().stream().filter(s-> Keys.values().).forEach(s-> MasterData.setContext(s.getKey().toString(),s.getValue().toString()));
        TestUtilities.setMasterValues(config_Map);
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        new Report().generateBuilderReport();
    }
}
