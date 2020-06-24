package web.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import utils.TestContext;

public class firstwebSteps {
	private WebDriver driver = (WebDriver) TestContext.getContext(utils.Keys.WEBDRIVER);
	
	
	@Given("^google link was give$")
	public void google_link_was_give() {
		driver.get("https://www.google.com/");
	}

	@Given("^Search anything there$")
	public void search_anything_there() {
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("something search here");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);
	}

	@When("^Click on the first link$")
	public void click_on_the_first_link(){
		driver.findElement(By.xpath("//div[@class='rc']/div/a[contains(@href,'trends')]")).click();
		
	}

	@When("^respected page opens$")
	public void respected_page_opens() {
		Assert.assertEquals(true,driver.findElement(By.xpath("//*[contains(text(),'Explore what')]")).isDisplayed());
		driver.quit();
	   
	}

}
