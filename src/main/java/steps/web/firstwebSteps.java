package steps.web;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import junit.framework.Assert;
import utils.MasterData;

public class firstwebSteps {
    WebDriver driver = (WebDriver) MasterData.getContext(utils.Keys.WEBDRIVER);


    @Given("^google link was give$")
    public void google_link_was_give() {
        //.get("https://www.google.com/");
        System.out.println("Inside - google link was given");
    }

    @Given("^Search anything there$")
    public void search_anything_there() {
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("something search here");
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);
    }

    @When("^Click on the first link$")
    public void click_on_the_first_link() {
        driver.findElement(By.xpath("//div[@class='rc']/div/a[contains(@href,'trends')]")).click();

    }

    @When("^respected page opens$")
    public void respected_page_opens() {
        Assert.assertEquals(true, driver.findElement(By.xpath("//*[contains(text(),'Explore what')]")).isDisplayed());
        driver.quit();

    }

    @Given("Check if this feature can tracable")
    public void checkIfThisFeatureCanTracable() {
        System.out.println("Inside new featurefile");
    }

}
