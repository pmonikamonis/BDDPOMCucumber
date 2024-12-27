package stepDefs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GooglePageStepDef {
	WebDriver driver;
	@Given("User is on Google Page")
	public void user_is_on_google_page() {
	  
		driver= new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	}
	@When("User enters the selenium tutorial")
	public void user_enters_the_selenium_tutorial() {
		WebElement search = driver.findElement(By.tagName("textarea"));
		search.sendKeys("Selenium Tutorial");
		search.submit();
	  
	}
	@Then("Should display the Selenium result Page")
	public void should_display_the_selenium_result_page() {
		Assert.assertEquals(driver.getTitle(), "Selenium Tutorial - Google Search");
	    
	}
	
	@When("User enters the java tutorial")
	public void user_enters_the_java_tutorial() {
		WebElement search = driver.findElement(By.tagName("textarea"));
		search.sendKeys("Java Tutorial");
		search.submit();
	}
	@Then("Should display the java result Page")
	public void should_display_the_java_result_page() {
		Assert.assertEquals(driver.getTitle(), "Java Tutorial - Google Search Page");
	 
	}
	
	@After
	public void attachScreenshot(Scenario scenario)
	{
		if(scenario.isFailed())
		{
		TakesScreenshot src= (TakesScreenshot)driver;
		byte[] imag= src.getScreenshotAs(OutputType.BYTES);
		scenario.attach(imag, "image/png", "Screenshot");
		}
	}


}
